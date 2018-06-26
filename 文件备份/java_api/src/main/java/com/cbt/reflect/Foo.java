package com.cbt.reflect;

public class Foo {

	int a;

	public Foo(int a) {
		this.a = a;
	}
	public Foo() {
		
	}

	private void who(String name, int age) {
		System.out.println(name+"多大"+age+">>>>>>");
	}

	public void test() {
		System.out.println("test()....");
	}
	
	@Override
	public String toString() {
		return "Foo [a=" + a + "]";
	}
	
	public void testabc() {
		System.out.println("testabc>>>>>>>>>>");
	}
	
	public void testedg() {
		System.out.println("test edg()....");
	}
	
	
}
