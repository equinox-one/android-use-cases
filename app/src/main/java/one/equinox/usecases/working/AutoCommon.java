package one.equinox.usecases.working;

import one.equinox.usecases.UseCaseExecutor;

/**
 * Created by mateuyabar on 1/03/16.
 */
public class AutoCommon {

    public static abstract class Params<K extends AutoUseCase>{
        abstract K useCase();

        public void execute(){
            useCase().execute(this);
        }
    }

    public static abstract class AutoUseCase<T, P extends Params> {
        UseCaseExecutor useCaseExecutor;
        public AutoUseCase(UseCaseExecutor useCaseExecutor) {
            this.useCaseExecutor = useCaseExecutor;
        }

        abstract void executeInternal(P params);
        public void execute(P params){
            useCaseExecutor.execute(null);
            executeInternal(params);
        }
    }

    public static abstract class ParamsBuilder<T extends Params>{
        abstract T build();
        public void execute(){
            build().execute();
        }
    }
}
