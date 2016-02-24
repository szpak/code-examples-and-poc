package info.solidsoft.blog.rxjava.completable

import groovy.transform.ToString
import groovy.util.logging.Slf4j

@ToString(includePackage = false)
@Slf4j
class TestJob implements Job {

    final String name

    private Optional<Integer> timeoutInMillis
    private boolean executed

    TestJob(String name) {
        this.name = name
        this.executed = false
    }

    @Override
    void execute() {
        log.info("Running test job $name")
        executed = true
    }

    boolean isExecuted() {
        return executed
    }
}
