package info.solidsoft.blog.boot.events

import info.solidsoft.blog.boot.events.domain.Blog
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.transaction.TestTransaction
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

/**
 * Note: Database cleaning omitted for brevity - it is not important here.
 */
@SpringApplicationConfiguration(classes = TransactionalEventsApplication.class)
class TransactionalEventsApplication2Spec extends Specification {

    @Autowired
    private BlogSaver blogSaver

    @Autowired
    @Delegate
    private TestNotificationSender testNotificationSender

    private Blog testBlog

    void setup() {
        testNotificationSender.resetCounters()
        testBlog = getTestBlog()
    }

    def "should send standard and transactional fallback notification immediately when in non transactional context"() {
        when:
            blogSaver.saveAndSendEvent(testBlog)
        then:
            newBlogCounter.get() == 1
            newBlogTransactionalOldSchoolCounter.get() == 1
            newBlogTransactionalWithFallbackCounter.get() == 1
        and:
            newBlogTransactionalCounter.get() == 0
    }

    @Transactional
    def "should send transactional notification after commit when in transactional context"() {
        when:
            blogSaver.saveAndSendEvent(testBlog);
        then:
            newBlogTransactionalCounter.get() == 0
            newBlogTransactionalOldSchoolCounter.get() == 0
            newBlogTransactionalWithFallbackCounter.get() == 0
        when:
            TestTransaction.flagForCommit()
            TestTransaction.end()
        then:
            newBlogTransactionalCounter.get() == 1
            newBlogTransactionalOldSchoolCounter.get() == 1
            newBlogTransactionalWithFallbackCounter.get() == 1
    }

    @Transactional
    def "should not send transactional notification after rollback when in transactional context"() {
        when:
            blogSaver.saveAndSendEvent(testBlog);
        then:
            newBlogTransactionalCounter.get() == 0
            newBlogTransactionalOldSchoolCounter.get() == 0
            newBlogTransactionalWithFallbackCounter.get() == 0
        when:
            TestTransaction.flagForRollback()
            TestTransaction.end()
        then:
            newBlogTransactionalCounter.get() == 0
            newBlogTransactionalOldSchoolCounter.get() == 0
            newBlogTransactionalWithFallbackCounter.get() == 0
    }

    @Transactional
    def "should send standard notification immediately when in transactional context"() {
        when:
            blogSaver.saveAndSendEvent(testBlog);
        then:
            newBlogCounter.get() == 1
    }

    private Blog getTestBlog() {
        return new Blog(name: "My fancy blog", url: "http://blog.exxample.com/")
    }
}
