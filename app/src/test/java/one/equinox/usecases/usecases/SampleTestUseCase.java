package one.equinox.usecases.usecases;


import java.util. concurrent.Callable;

public class SampleTestUseCase implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        return "result done";
    }
}
