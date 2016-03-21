//package one.equinox.usecases.auto.example;
//
//import com.google.auto.value.AutoValue;
//
//import one.equinox.usecases.auto.UseCaseBase;
//import one.equinox.usecases.auto.UseCaseBuilderBase;
//import one.equinox.usecases.auto.UseCaseExecutionBase;
//import one.equinox.usecases.auto.UseCaseExecutor;
//import one.equinox.usecases.working.SampleUseCaseWithFunction;
//
//
//@AutoValue
//public abstract class UseCaseWithAutoOutSide extends UseCaseBase<String> {
//    public static UseCaseWithAutoV3Builder getBuilder(UseCaseExecutor executor){
//        return new AutoValue_UseCaseWithAutoOutSide.Builder().executor(executor);
//    }
//
//    abstract UseCaseExecutor executor();
//    abstract String filter();
//    abstract int numberOfLegs();
//
//    public String executeInternal(){
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "HELLO WORLD";
//    }
//
//    @AutoValue.Builder
//    abstract static class UseCaseWithAutoV3Builder extends UseCaseBuilderBase<String, UseCaseWithAutoOutSide> {
//        abstract UseCaseWithAutoV3Builder executor(UseCaseExecutor executor);
//        abstract UseCaseWithAutoV3Builder filter(String s);
//        abstract UseCaseWithAutoV3Builder numberOfLegs(int n);
//        public abstract UseCaseWithAutoOutSide build();
//    }
//
//
//
//
//    public static void main(String[] args){
//        UseCaseWithAutoV3Builder builder = UseCaseWithAutoOutSide.getBuilder(new UseCaseExecutor());
//        UseCaseExecutionBase<String> execution = builder.filter("filter").numberOfLegs(2).execute();
//        execution.setOnSuccessListener(new SampleUseCaseWithFunction.OnSuccessListener<String>() {
//            @Override
//            public void onSuccess(String result) {
//                System.out.println(result);
//            }
//        });
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//
//
//}
