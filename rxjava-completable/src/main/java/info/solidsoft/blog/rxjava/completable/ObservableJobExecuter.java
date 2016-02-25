package info.solidsoft.blog.rxjava.completable;

import rx.Observable;
import rx.schedulers.Schedulers;

public class ObservableJobExecuter extends AbstractJobExecuter {

    public ObservableJobExecuter(Job job1, Job job2) {
        super(job1, job2);
    }

    @Override
    public void execute() {
        Observable<Void> run1 = rxJobExecute(job1).subscribeOn(Schedulers.io());
        Observable<Void> run2 = rxJobExecute(job2).subscribeOn(Schedulers.io());

        Observable.zip(run1, run2, (r1, r2) -> null)
                .toBlocking()
                .single();
        log.info("All jobs finished successfully (Observable)");
    }

    private Observable<Void> rxJobExecute(Job job) {
        return Observable.fromCallable(() -> { job.execute(); return null; });
    }
}
