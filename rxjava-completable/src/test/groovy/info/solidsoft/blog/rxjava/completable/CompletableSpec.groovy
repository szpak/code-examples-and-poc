package info.solidsoft.blog.rxjava.completable

import org.junit.ClassRule
import org.junit.contrib.java.lang.system.RestoreSystemProperties
import spock.lang.Shared
import spock.lang.Specification

class CompletableSpec extends Specification {

    @ClassRule
    @Shared
    RestoreSystemProperties restoreSystemProperties     //Extension from Spock cannot be use as it doesn't support setupSpec

    private TestJob job1 = new TestJob("job1")
    private TestJob job2 = new TestJob("job2")

    void setupSpec() {
        System.setProperty("org.slf4j.simpleLogger.showDateTime", "true")
    }

    def "should execute two tasks"() {
        given:
            AbstractJobExecuter completable = new CompletableJobExecutor(this.job1, job2)
        when:
            completable.execute()
        then:
            job1.executed
            job2.executed
    }

    def "should execute two tasks (old way)"() {
        given:
            AbstractJobExecuter completable = new ObservableJobExecuter(job1, job2)
        when:
            completable.execute()
        then:
            job1.executed
            job2.executed
    }

    def "should execute two tasks (future)"() {
        given:
            AbstractJobExecuter completable = new FutureJobExecutor(job1, job2)
        when:
            completable.execute()
        then:
            job1.executed
            job2.executed
    }
}
