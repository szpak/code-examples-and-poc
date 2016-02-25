package info.solidsoft.blog.rxjava.completable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractJobExecuter implements JobExecutor {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    protected final Job job1;
    protected final Job job2;

    protected AbstractJobExecuter(Job job1, Job job2) {
        this.job1 = job1;
        this.job2 = job2;
    }
}
