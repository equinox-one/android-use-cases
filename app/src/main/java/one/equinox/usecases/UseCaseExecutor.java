package one.equinox.usecases;


import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class UseCaseExecutor {
    static ThreadFactory threadFactory = Executors.defaultThreadFactory();

    public void execute(Object useCase){

    }
    /*public <T> UseCaseExecution<T> execute(UseCase<T> useCase){
        UseCaseExecution<T> useCaseExecution = new UseCaseExecution<T>(useCase);
        threadFactory.newThread(useCaseExecution);
        return useCaseExecution;
    }*/
}
