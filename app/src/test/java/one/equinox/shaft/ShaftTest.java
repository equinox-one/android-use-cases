package one.equinox.shaft;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import one.equinox.shaft.usecases.SampleExceptionTestUseCase;
import one.equinox.shaft.usecases.SampleTestUseCase;
import one.equinox.shaft.usecases.SampleTestUseCaseWithParams;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by mateuyabar on 21/03/16.
 */
public class ShaftTest {
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
        result.setListeners(new SuccessListener<String>() {
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
    public void executeExceptionUseCase() throws ExecutionException, InterruptedException {
        Callable<String> sampleUseCase = new SampleExceptionTestUseCase();

        ShaftFuture<String> result = executor.submit(sampleUseCase);
        result.setListeners(null, new ErrorListener() {
            @Override
            public void onError(Throwable e) {
                downLatch.countDown();
                assertTrue(e instanceof SampleExceptionTestUseCase.MyException);
            }
        });

        downLatch.await();
    }




    @Test
    public void executeUseCaseSuccesful() throws ExecutionException, InterruptedException {
        testUseCase(3, 0);
        testUseCase(33, 1000);
    }

    @Test
    public void executeUseCaseWithError() throws ExecutionException, InterruptedException {
        Exception exception = new Exception();
        testUseCase(exception, 0);
        testUseCase(exception, 1000);
    }

    public void testUseCase(final Integer value, int waitTime) throws ExecutionException, InterruptedException {
        Callable<Integer> useCase = SampleTestUseCaseWithParams.getBuilder().result(value).waitTime(waitTime).build();
        ShaftFuture<Integer> result = executor.submit(useCase);
        result.setListeners(new SuccessListener<Integer>() {
            @Override
            public void onSuccess(Integer result) {
                downLatch.countDown();
                assertEquals(value, result);
            }
        }, null);

        downLatch.await();
        assertEquals(value, result.get());
    }

    public void testUseCase(final Exception exception, int waitTime) throws ExecutionException, InterruptedException {
        Callable<Integer> useCase = SampleTestUseCaseWithParams.getBuilder().exception(exception).waitTime(waitTime).build();
        ShaftFuture<Integer> result = executor.submit(useCase);
        result.setListeners(null,
                new ErrorListener() {
                    @Override
                    public void onError(Throwable e) {
                        downLatch.countDown();
                        assertEquals(e, exception);
                    }
                });

        downLatch.await();

    }
}
