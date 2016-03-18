package one.equinox.usecases.auto;

public abstract class UseCaseBase<T> implements UseCase<T>{
        abstract UseCaseExecutor executor();
        protected T executeInternal(){
            return null;
        }
        UseCaseExecutionBase<T> execute(){
            return executor().execute(this);
        }
    }