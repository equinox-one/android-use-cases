//package one.equinox.usecases;
//
//import com.google.auto.value.AutoValue;
//
///**
// * Created by mateuyabar on 1/03/16.
// */
//public class SampleUseCaseAuto {
//    UseCaseExecutor useCaseExecutor;
//
//    public static void sampleCall(){
//        SampleUseCaseAuto useCase = null;
//        useCase.callWith().filter("something").execute()
//                .onSuccess(null)
//                .onError(null);
//    }
//
//    public SampleUseCaseAuto(UseCaseExecutor useCaseExecutor) {
//        this.useCaseExecutor = useCaseExecutor;
//    }
//
//    public SampleUseCaseCall callWith(){
//        return new SampleUseCaseCall();
//    }
//
//
//
//
//
//    public static abstract class BaseUseCaseCall<T> implements UseCaseCall<T>{
//        public UseCaseExecution<T> execute(){
//            //T result = executeInternal();
//            return new UseCaseExecution<T>();
//        }
//        public abstract T executeInternal() throws Exception;
//    }
//
//    public interface UseCaseCall<T>{
//        public UseCaseExecution<T> execute();
//    }
//
//    public static class UseCaseExecution<T>{
//        OnSuccessListener<T> onSuccessListener;
//        OnErrorListener onErrorListener;
//
//        public UseCaseExecution onSuccess(OnSuccessListener<T> onSuccessListener) {
//            this.onSuccessListener = onSuccessListener;
//            return this;
//        }
//
//        public UseCaseExecution onError(OnErrorListener onErrorListener) {
//            this.onErrorListener = onErrorListener;
//            return this;
//        }
//    }
//
//    public interface OnSuccessListener<T>{
//        void onSuccess(T result);
//    }
//    public interface OnErrorListener{
//        void onError(Exception error);
//    }
//}
