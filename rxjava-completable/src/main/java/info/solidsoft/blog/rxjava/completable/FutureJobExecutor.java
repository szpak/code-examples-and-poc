package info.solidsoft.blog.rxjava.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FutureJobExecutor extends AbstractJobExecuter {

    public FutureJobExecutor(Job job1, Job job2) {
        super(job1, job2);
    }

    @Override
    public void execute() {
        try {
            CompletableFuture<Void> run1 = CompletableFuture.runAsync(job1::execute);
            CompletableFuture<Void> run2 = CompletableFuture.runAsync(job2::execute);

            CompletableFuture.allOf(run1, run2).get();
            log.info("All jobs finished successfully (Future)");

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
