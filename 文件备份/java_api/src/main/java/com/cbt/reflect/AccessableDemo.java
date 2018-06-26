package com.cbt.reflect;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *  ###反射可以调用私有方法
 *  利用反射API可以调用方法：
 *  1.在类上查找指定参数类型的方法信息
 *  2.获取拥有方法的对象
 *  3.利用反射API执行对象的方法
 *  	> 如果方法是不可见的，在执行之前使用setAccessable(true)就可以打开访问权限，执行不可见方法
 *  
 *  步骤：找到方法：
 *  	>Method method = cls.getDeclaredMethod(String 方法名,参数1，参数2，...);
 *  	>method.setAccessible(true);
 *  	>method.invoke(动态加载类名，参数1，参数2，...);
 *  
 *  @作者 soft01
 *  2018年6月25日下午3:39:16
 */
public class AccessableDemo {
	static String sss;//引用变量默认值 nulls
	
	public static void main(String[] args) throws Exception {

		String a = "aaa";
		String b = a;
		String ss; //局部变量调用前需要给默认值
		a = "ccc";
		System.out.println(b);
		//System.out.println(ss);
		System.out.println(sss);
		
		
		Set<Short> s=new HashSet<Short>();
		for(Short i=0;i<100;i++) {
		s.add(i);
		s.remove(i-1);
		} 
		System.out.println(s.size());
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入类名：");
		
		Class cls = Class.forName(scanner.nextLine());
		Method method = cls.getDeclaredMethod("who", String.class,int.class);
		method.setAccessible(true);
		method.invoke(cls.newInstance(), "我是你爸爸",22);
	}
}

