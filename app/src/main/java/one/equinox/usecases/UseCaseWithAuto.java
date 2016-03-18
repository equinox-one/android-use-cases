//package one.equinox.usecases;
//
//import com.google.auto.value.AutoValue;
//
//@AutoValue
//public abstract class UseCaseWithAuto  {
//    public static class UseCaseWithAutoProvider{
//        Builder callWith() {
//            return new AutoValue_UseCaseWithAuto.Builder();
//        }
//    }
//
//    abstract String name();
//    abstract int numberOfLegs();
//
//    public void execute(){
//        //DO SOMETHING
//    }
//
//    @AutoValue.Builder
//    abstract static class Builder extends AutoUseCaseCallBuilder<UseCaseWithAuto>{
//        abstract Builder name(String s);
//        abstract Builder numberOfLegs(int n);
//        abstract UseCaseWithAuto build();
//    }
//
//
//    public interface AutoUseCaseCall{
//        public void execute();
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
//        new UseCaseWithAuto().callWith().name("name").numberOfLegs(2).execute();
//    }
//
//}
