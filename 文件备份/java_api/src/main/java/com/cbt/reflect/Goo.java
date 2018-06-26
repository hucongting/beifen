package com.cbt.reflect;

public class Goo {

	int b;
	int c;
	
	public Goo() {}
	
	public Goo(int b) {
		this.b = b;
	}
	
	public Goo(int b,int c) {
		this.b = b;
		this.c = c;
	}
	
	public void test() {
		System.out.println("Goo test()...");
	}
	
	private void who(String str, int age) {
		System.out.println(str+">>>>>"+age);
	}

	@Override
	public String toString() {
		return "Goo [b=" + b + ", c=" + c + "]";
	}
	
}
