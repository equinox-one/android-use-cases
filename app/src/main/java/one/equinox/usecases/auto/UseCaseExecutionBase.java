package one.equinox.usecases.auto;

import one.equinox.usecases.working.SampleUseCaseWithFunction;

public class UseCaseExecutionBase<K> implements UseCaseExecution<K>{
    K result;
    SampleUseCaseWithFunction.OnSuccessListener<K> onSuccessListener;


    public UseCaseExecutionBase() {
        this.result = result;
    }

    public void setOnSuccessListener(SampleUseCaseWithFunction.OnSuccessListener<K> onSuccessListener) {
        this.onSuccessListener = onSuccessListener;
        if(result!=null){
            onSuccessListener.onSuccess(result);
        }
    }

    public void setResult(K result) {
        this.result = result;
        if(onSuccessListener!=null)
            onSuccessListener.onSuccess(result);
    }
}