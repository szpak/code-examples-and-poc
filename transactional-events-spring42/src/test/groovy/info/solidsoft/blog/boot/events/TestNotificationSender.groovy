package info.solidsoft.blog.boot.events

import info.solidsoft.blog.boot.events.domain.event.BlogAddedEvent
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

import java.util.concurrent.atomic.AtomicInteger

@Component
@Primary
class TestNotificationSender implements NotificationSender {

    final AtomicInteger newBlogCounter = new AtomicInteger()
    final AtomicInteger newBlogTransactionalCounter = new AtomicInteger()
    final AtomicInteger newBlogTransactionalWithFallbackCounter = new AtomicInteger()
    final AtomicInteger newBlogTransactionalOldSchoolCounter = new AtomicInteger()

    @Override
    void blogAdded(BlogAddedEvent blogAddedEvent) {
        newBlogCounter.incrementAndGet()
    }

    @Override
    void blogAddedTransactional(BlogAddedEvent blogAddedEvent) {
        newBlogTransactionalCounter.incrementAndGet()
    }

    @Override
    void blogAddedTransactionalWithFallback(BlogAddedEvent blogAddedEvent) {
        newBlogTransactionalWithFallbackCounter.incrementAndGet()
    }

    @Override
    void blogAddedTransactionalOldSchool(BlogAddedEvent blogAddedEvent) {
        newBlogTransactionalOldSchoolCounter.incrementAndGet()
    }

    void resetCounters() {
        //TODO: Switch to reflection and Groovy magic (by suffix)?
        [newBlogCounter, newBlogTransactionalCounter, newBlogTransactionalWithFallbackCounter, newBlogTransactionalOldSchoolCounter].each {
            it.set(0)
        }
    }
}
