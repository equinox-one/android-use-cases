package one.equinox.usecases.auto;

public abstract class UseCaseBuilderBase<K, T extends UseCaseBase<K>> implements UseCaseBuilder<K, T> {
    public UseCaseExecutionBase<K> execute(){
        return build().execute();
    }
}