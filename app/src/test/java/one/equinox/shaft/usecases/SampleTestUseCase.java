package one.equinox.shaft.usecases;


import java.util. concurrent.Callable;

public class SampleTestUseCase implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "result done";
    }
}
