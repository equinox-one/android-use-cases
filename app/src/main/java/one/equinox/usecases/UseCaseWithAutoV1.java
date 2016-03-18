//package one.equinox.usecases;
//
//import com.google.auto.value.AutoValue;
//
//
//public class UseCaseWithAutoV1 {
//    UseCaseExecutor useCaseExecutor;
//    public UseCaseWithAutoV1(UseCaseExecutor useCaseExecutor) {
//        this.useCaseExecutor = useCaseExecutor;
//    }
//
//    public void executeInternal(){
//        //DO SOMETHING
//    }
//
//    MyUseCaseCall.Builder callWith() {
//        return new AutoValue_UseCaseWithAutoV1_MyUseCaseCall.Builder().useCaseWithAutoV1(this);
//    }
//
//    @AutoValue
//    abstract static class MyUseCaseCall extends AutoUseCaseCall {
//        abstract UseCaseWithAutoV1 useCaseWithAutoV1();
//        abstract String name();
//        abstract int numberOfLegs();
//
//
//        @AutoValue.Builder
//        abstract static class Builder extends AutoUseCaseCallBuilder<MyUseCaseCall>{
//            abstract Builder useCaseWithAutoV1(UseCaseWithAutoV1 useCase);
//            abstract Builder name(String s);
//            abstract Builder numberOfLegs(int n);
//            abstract MyUseCaseCall build();
//        }
//    }
//
//
//
//    public static abstract class AutoUseCaseCall{
//        abstract UseCaseWithAutoV1 useCaseWithAutoV1();
//
//        abstract void executeInternal();
//        public void execute(){
//            useCaseWithAutoV1().useCaseExecutor.execute(null);
//            useCaseWithAutoV1().executeInternal();
//        };
//
//
//    }
//
//    public static abstract class AutoUseCaseCallBuilder<T extends AutoUseCaseCall>{
//        abstract T build();
//        public void execute(){
//            build().execute();
//        }
//    }
//
//
//    public static void xxx(){
//        new UseCaseWithAutoV1(new UseCaseExecutor()).callWith().name("name").numberOfLegs(2).execute();
//    }
//
//}
