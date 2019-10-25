package com.moneyhub5.web.cmm;

@FunctionalInterface
public interface IPredicate<T> {
	public boolean Test(Object o);
}
