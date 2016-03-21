package one.equinox.usecases.usecases;

import com.google.auto.value.AutoValue;

import java.util.concurrent.Callable;

@AutoValue
public abstract class SampleTestUseCaseWithParams implements Callable<Integer>{
    public static Builder getBuilder(){
        return new AutoValue_SampleTestUseCaseWithParams.Builder();
    }
    abstract int page();

    @Override
    public Integer call() throws Exception {
        return page();
    }

    @AutoValue.Builder
    public abstract static class BuilderImpl implements Builder{
        public abstract BuilderImpl page(int page);
        public abstract SampleTestUseCaseWithParams build();
    }

    public interface Builder{
        Builder page(int page);
        Callable<Integer> build();
    }
}
