package one.equinox.usecases.working;

import one.equinox.usecases.UseCaseExecutor;

/**
 * Created by mateuyabar on 1/03/16.
 */
public class SampleUseCaseWithFunction {
    public static void sampleCall(){
        SampleUseCaseWithFunction useCase = null;

        useCase.callWith("something", "somethingElse")
                .onSuccess(null)
                .onError(null);
    }

    UseCaseExecutor useCaseExecutor;
    public SampleUseCaseWithFunction(UseCaseExecutor useCaseExecutor) {
        this.useCaseExecutor = useCaseExecutor;
    }

    public UseCaseExecution<String> callWith(String x, String y){
        return new SampleUseCaseCall(useCaseExecutor, x,y).execute();
    }

    public class SampleUseCaseCall extends BaseUseCaseCall<String>{
        String x;
        String y;

        public SampleUseCaseCall(UseCaseExecutor useCaseExecutor, String x, String y) {
            super(useCaseExecutor);
            this.x = x;
            this.y = y;
        }

        public String executeInternal(){
            return "DONE";
        }
    }



    public static abstract class BaseUseCaseCall<T> implements UseCaseCall<T>{
        UseCaseExecutor useCaseExecutor;

        public BaseUseCaseCall(UseCaseExecutor useCaseExecutor) {
            this.useCaseExecutor = useCaseExecutor;
        }

        public UseCaseExecution<T> execute(){
            useCaseExecutor.execute(null);
            //T result = executeInternal();
            return new UseCaseExecution<T>();
        }
        public abstract T executeInternal() throws Exception;
    }

    public interface UseCaseCall<T>{
        public UseCaseExecution<T> execute();
    }

    public static class UseCaseExecution<T>{
        OnSuccessListener<T> onSuccessListener;
        OnErrorListener onErrorListener;

        public UseCaseExecution onSuccess(OnSuccessListener<T> onSuccessListener) {
            this.onSuccessListener = onSuccessListener;
            return this;
        }

        public UseCaseExecution onError(OnErrorListener onErrorListener) {
            this.onErrorListener = onErrorListener;
            return this;
        }
    }

    public interface OnSuccessListener<T>{
        void onSuccess(T result);
    }
    public interface OnErrorListener{
        void onError(Exception error);
    }
}
