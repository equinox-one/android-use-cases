package one.equinox.shaft;


import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

public class ShaftFuture<T> extends FutureTask<T> {
    SuccessListener<T> successListener;
    ErrorListener errorListener;
    Executor listenerExecutor;

    public ShaftFuture(Callable<T> callable) {
        super(callable);
    }

    public ShaftFuture(Runnable runnable, T result) {
        super(runnable, result);
    }

    public synchronized void setListeners(SuccessListener<T> successListener, ErrorListener errorListener) {
        this.successListener = successListener;
        this.errorListener = errorListener;

        if(isDone()){
            notifyListener();
        }
    }



    @Override
    protected void done() {
        super.done();
        notifyListener();
    }

    private synchronized void notifyListener() {
        if(!isCancelled()){

            T result = null;
            try {
                result = get();
            } catch (final Exception e) {
                if(errorListener!=null) {
                    getListenerExecutor().execute(new Runnable() {
                        @Override
                        public void run() {
                            errorListener.onError(e.getCause());
                        }
                    });
                }
                return;
            }
            /*} catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }*/
            final T finalResult = result;
            if(successListener!=null) {
                getListenerExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        successListener.onSuccess(finalResult);
                    }
                });
            }
        }
    }

    public void setListenerExecutor(Executor listenerExecutor) {
        this.listenerExecutor = listenerExecutor;
    }

    public Executor getListenerExecutor() {
        if(listenerExecutor==null){
            return defaultListenerExecutor;
        }
        return listenerExecutor;
    }

    private static Executor defaultListenerExecutor = new Executor(){
        @Override
        public void execute(Runnable command) {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(command);
        }
    };

    /**
     * Only used in tests. Changes the default executor for the listeners.
     * @param defaultListenerExecutor
     */
    public static void setDefaultListenerExecutor(Executor defaultListenerExecutor) {
        ShaftFuture.defaultListenerExecutor = defaultListenerExecutor;
    }
}
