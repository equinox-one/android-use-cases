//package one.equinox.usecases;
//
//
//import android.os.Handler;
//import android.os.Looper;
//
//public class UseCaseExecution<T> implements Runnable{
//    OnSuccessListener<T> onSuccessListener;
//    OnErrorListener onErrorListener;
//    UseCaseCall<T> useCase;
//
//    public UseCaseExecution(UseCaseCall<T> useCase) {
//        this.useCase = useCase;
//    }
//
//    @Override
//    public void run() {
//        try {
//            final T result = useCase.execute();
//            Handler mainHandler = new Handler(Looper.getMainLooper());
//            mainHandler.post(new Runnable() {
//                @Override
//                public void run() {
//                    onSuccessListener.onSuccess(result);
//                }
//            });
//        } catch (final Exception e) {
//            Handler mainHandler = new Handler(Looper.getMainLooper());
//            mainHandler.post(new Runnable() {
//                @Override
//                public void run() {
//                    onErrorListener.onError(e);
//                }
//            });
//        }
//    }
//
//    public void setListeners(OnSuccessListener<T> onSuccessListener, OnErrorListener onErrorListener){
//        this.onSuccessListener = onSuccessListener;
//        this.onErrorListener = onErrorListener;
//    }
//
//    public interface OnSuccessListener<T>{
//        void onSuccess(T result);
//    }
//    public interface OnErrorListener{
//        void onError(Exception error);
//    }
//}
