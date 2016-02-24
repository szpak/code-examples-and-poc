package info.solidsoft.blog.rxjava.completable;

import rx.Completable;
import rx.schedulers.Schedulers;

public class CompletableJobExecutor extends AbstractJobExecuter {

    public CompletableJobExecutor(Job job1, Job job2) {
        super(job1, job2);
    }

    @Override
    public void execute() {
        Completable completable1 = Completable.fromAction(job1::execute)
                .subscribeOn(Schedulers.io());
        Completable completable2 = Completable.fromAction(job2::execute)
                .subscribeOn(Schedulers.io());

        Completable.merge(completable1, completable2)
                .doOnComplete(() -> log.info("All jobs finished successfully (Completable)"))
                .await();
    }
}
