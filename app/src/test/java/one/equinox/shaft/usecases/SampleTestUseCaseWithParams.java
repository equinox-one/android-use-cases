package one.equinox.shaft.usecases;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.concurrent.Callable;

@AutoValue
public abstract class SampleTestUseCaseWithParams implements Callable<Integer>{
    public static Builder getBuilder(){
        return new AutoValue_SampleTestUseCaseWithParams.Builder();
    }
    abstract int waitTime();
    @Nullable
    abstract Integer result();
    @Nullable
    abstract Exception exception();

    @Override
    public Integer call() throws Exception {
        Thread.sleep(waitTime());
        if(exception()==null)
            return result();
        else throw exception();
    }

    @AutoValue.Builder
    public abstract static class BuilderImpl implements Builder{
        public abstract BuilderImpl waitTime(int milis);
        public abstract BuilderImpl result(Integer result);
        public abstract BuilderImpl exception(Exception exception);

        public abstract SampleTestUseCaseWithParams build();
    }

    public interface Builder{
        Builder waitTime(int milis);
        Builder result(Integer milis);
        Builder exception(Exception exception);
        Callable<Integer> build();
    }
}
