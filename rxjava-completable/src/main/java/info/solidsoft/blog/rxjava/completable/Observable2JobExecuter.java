package info.solidsoft.blog.rxjava.completable;

import rx.Observable;
import rx.schedulers.Schedulers;

public class Observable2JobExecuter extends AbstractJobExecuter {

    public Observable2JobExecuter(Job job1, Job job2) {
        super(job1, job2);
    }

    @Override
    public void execute() {
        Observable<Object> run1 = rxJobExecute(job1).subscribeOn(Schedulers.io());
        Observable<Object> run2 = rxJobExecute(job2).subscribeOn(Schedulers.io());

        Observable.merge(run1, run2)
                .toBlocking()
                .subscribe(next -> { });
        log.info("All jobs finished successfully (Observable2)");
    }

    private Observable<Object> rxJobExecute(Job job) {
        return Observable.empty().doOnCompleted(job::execute);
    }
}
