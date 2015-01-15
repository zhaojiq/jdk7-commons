package org.fanghe.function;

/**
 * 函数接口<br />
 * 这个是函数的父接口，所有的函数都应继承这个抽象类。<br />
 * 接口本身并不约束函数本身对元素本身的影响，但是原则上应该修改元素的内容
 *
 * Created by Lucky on 1/15/2015.
 */
abstract public class Function<T, R> {

    /**
     * 函数体
     * @param parameter 函数的参数
     * @return 函数的执行结果
     */
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
