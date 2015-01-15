package org.fanghe.function;

/**
 * jdk7-commons
 * Created by Lucky on 1/16/2015.
 */
abstract public class Consumer<T> extends Function<T, Void> {
    abstract void apply(T x);

    @Override
    Void accept(T parameter) {
        this.apply(parameter);
        return null;
    }
}
