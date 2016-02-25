package info.solidsoft.blog.rxjava.completable

import org.junit.ClassRule
import org.junit.contrib.java.lang.system.RestoreSystemProperties
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class CompletableSpec extends Specification {

    @ClassRule
    @Shared
    RestoreSystemProperties restoreSystemProperties     //Extension from Spock cannot be use as it doesn't support setupSpec

    private TestJob job1 = new TestJob("job1")
    private TestJob job2 = new TestJob("job2")

    void setupSpec() {
        System.setProperty("org.slf4j.simpleLogger.showDateTime", "true")
    }

    def "should execute two tasks (#executorName)"() {
        given:
            JobExecutor executor = executorClosure(job1, job2)
        when:
            executor.execute()
        then:
            job1.executed
            job2.executed
        where:
            executorName  | executorClosure
            "future"      | { j1, j2 -> new FutureJobExecutor(j1, j2) }
            "observable1" | { j1, j2 -> new ObservableJobExecuter(j1, j2) }
            "observable2" | { j1, j2 -> new Observable2JobExecuter(j1, j2) }
            "completable" | { j1, j2 -> new CompletableJobExecutor(j1, j2) }
    }
}
