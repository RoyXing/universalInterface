package com.xingzy;

/**
 * @author roy.xing
 * @date 2019/3/6
 * 有参数无返回值
 */
public abstract class Function2<T> extends Function {

    public Function2(String functionName) {
        super(functionName);
    }

    public abstract void function(T t);
}
