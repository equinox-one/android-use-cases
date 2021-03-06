package one.equinox.shaft.usecases;


import java.util.concurrent.Callable;

public class SampleExceptionTestUseCase implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        throw new MyException();
    }

    public static class MyException extends Exception{

    }
}
