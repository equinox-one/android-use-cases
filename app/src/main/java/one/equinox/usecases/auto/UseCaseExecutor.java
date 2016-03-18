package one.equinox.usecases.auto;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class UseCaseExecutor {
        static ThreadFactory threadFactory = Executors.defaultThreadFactory();

        public <T> UseCaseExecutionBase<T> execute(final UseCaseBase<T> useCase){
            final UseCaseExecutionBase<T> execution = new UseCaseExecutionBase<T>();
            threadFactory.newThread(new Runnable() {
                @Override
                public void run() {
                    execution.setResult(useCase.executeInternal());
                }
            }).start();
            return execution;
        }
    }