package one.equinox.usecases.auto;

import one.equinox.usecases.working.SampleUseCaseWithFunction;

public interface UseCaseExecution<K>{
    void setOnSuccessListener(SampleUseCaseWithFunction.OnSuccessListener<K> onSuccessListener);
}