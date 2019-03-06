package com.xingzy;

/**
 * @author roy.xing
 * @date 2019/3/6
 * 无参数有返回值
 */
public abstract class Function3<T> extends Function {

    public Function3(String functionName) {
        super(functionName);
    }

    public abstract T function();
}
