package com.cbt.reflect;

/**
 *  方法的变长参数现象：
 *  
 *  @作者 soft01
 *  2018年6月25日下午4:35:06
 */
public class ParamDemo {
	public static void main(String[] args) {
		test();
		test(1);
		test(3,5);
		test(6,8);
	}
	
	/**
	 * 本质上变长参数就是数组参数！
	 * 1.使用...声明的参数称为变长参数
	 * 2.在调用时可以传递任意多个参数
	 * 3.在方法中，按照数组对变长参数进行处理
	 * 4.变长参数可以直接接受数组参数
	 * 5.一个方法只能有一个变长参数，而且只能放在最后一个参数
	 * 6.技巧: 如果想接收多态参数可以使用Object...
	 * 
	 * @param a
	 */
	public static void test(int... a) {
		//a实际上是一个int[] 数组
		//test()时候是0长度数组a={}
		//test(1)使用1个长度数组a={1}
		//test(2,3)参数是两个长度数组a={2,3}
		int sum = 0;
		for(int aa : a) {
			sum += aa;
		}
		System.out.println(sum);
	}
	
	public static void test2(String str, String...strings) {
		
	}
}
