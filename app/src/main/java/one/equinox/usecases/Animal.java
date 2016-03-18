package one.equinox.usecases;

import com.google.auto.value.AutoValue;


@AutoValue
public abstract class Animal {
    static Builder builder() {
        return new AutoValue_Animal.Builder();
    }

    abstract String name();
    abstract int numberOfLegs();

    @AutoValue.Builder
    abstract static class Builder {
        abstract Builder name(String s);
        abstract Builder numberOfLegs(int n);
        abstract Animal build();
    }
}

