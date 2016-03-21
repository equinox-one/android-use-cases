package one.equinox.usecases;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import one.equinox.shaft.ShaftFuture;
import one.equinox.shaft.ShaftExecutors;
import one.equinox.shaft.ShaftThreadPoolExecutor;
import one.equinox.usecases.usecases.SampleExceptionTestUseCase;
import one.equinox.usecases.usecases.SampleTestUseCase;
import one.equinox.usecases.usecases.SampleTestUseCaseWithParams;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by mateuyabar on 21/03/16.
 */
public class UseCaseTest {
    CountDownLatch downLatch;
    ShaftThreadPoolExecutor executor = ShaftExecutors.newFixedThreadPool(3);

    @Before
    public void setCountdown(){
        downLatch = new CountDownLatch(1);
    }

    @Before
    public void configureListenerExecutor(){
        Executor listenerExecutor = Executors.newSingleThreadExecutor();
        ShaftFuture.setDefaultListenerExecutor(listenerExecutor);
    }

    @Test
    public void executeUseCase() throws ExecutionException, InterruptedException {
        Callable<String> sampleUseCase = new SampleTestUseCase();

        ShaftFuture<String> result = executor.submit(sampleUseCase);
        result.setListeners(new ShaftFuture.SuccessListener<String>() {
            @Override
            public void onSuccess(String result) {
                downLatch.countDown();
                assertNotNull(result);
            }
        }, null);

        downLatch.await();
        assertNotNull(result.get());
    }

    @Test
    public void executeUseCaseWithParams() throws ExecutionException, InterruptedException {
        final Integer value = 3;

        Callable<Integer> sampleUseCase = SampleTestUseCaseWithParams.getBuilder().page(value).build();

        ShaftFuture<Integer> result = executor.submit(sampleUseCase);
        result.setListeners(new ShaftFuture.SuccessListener<Integer>() {
            @Override
            public void onSuccess(Integer result) {
                downLatch.countDown();
                assertEquals(value, result);
            }
        }, null);

        downLatch.await();
        assertEquals(value, result.get());
    }

    @Test
    public void executeExceptionUseCase() throws ExecutionException, InterruptedException {
        Callable<String> sampleUseCase = new SampleExceptionTestUseCase();

        ShaftFuture<String> result = executor.submit(sampleUseCase);
        result.setListeners(null, new ShaftFuture.ErrorListener() {
            @Override
            public void onError(Throwable e) {
                downLatch.countDown();
                assertTrue(e instanceof SampleExceptionTestUseCase.MyException);
            }
        });

        downLatch.await();

    }
}
