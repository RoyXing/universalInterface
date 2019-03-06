package com.xingzy;

/**
 * @author roy.xing
 * @date 2019/3/6
 * 无有参数有返回值
 */
public abstract class Function4<T, P> extends Function {

    public Function4(String functionName) {
        super(functionName);
    }

    public abstract T function(P p);
}
