package one.equinox.usecases.auto;

public interface UseCaseBuilder<K, T extends UseCaseBase<K>>{
    T build();
}