package org.fanghe.function;

/**
 * jdk7-commons
 * Created by Lucky on 1/16/2015.
 */
abstract public class Supplier<R> extends Function<Void, R> {

    abstract public R apply();

    @Override
    public final R accept(Void parameter) {
        return this.apply();
    }
}
