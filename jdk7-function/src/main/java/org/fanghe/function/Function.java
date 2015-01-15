package org.fanghe.function;

/**
 *
 * Created by Lucky on 1/15/2015.
 */
abstract public class Function<T, R> {

    abstract R accept(T parameter);

    private R call(T x) {
        return this.accept(x);
    }

    public final <U> Function<T, U> andThen(final Function<? super R, ? extends U> g) {
        final Function<T, R> f = this;
        return new Function<T, U>() {
            @Override
            U accept(T parameter) {
                return g.call(f.call(parameter));
            }
        };
    }

    public final <S> Function<S, R> compose(final Function<? super S, ? extends T> g) {
        final Function<T, R> f = this;
        return new Function<S, R>() {
            @Override
            R accept(S parameter) {
                return f.call(g.call(parameter));
            }
        };
    }

}
