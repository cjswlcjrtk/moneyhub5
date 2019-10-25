package com.moneyhub5.web.cmm;

//@FunctionalInterface
//public interface IFunction {
//	public Object apply(Object o);
//}

@FunctionalInterface
public interface IFunction<T, R> {
	public R apply(T t);
}
//T ==> 파라매터, R ==> 리턴타입
