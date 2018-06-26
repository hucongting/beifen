package com.cbt.reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

public class JUnitDemo {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("输入类名：");
		Class cls = Class.forName(in.nextLine());
		
		//查找类中全部方法
		Method[] methods = cls.getDeclaredMethods();
		//找到這些方法中哪些方法是以test爲開頭的方法
		for(Method method : methods) {
			//獲取每一個方法名
			String mdname = method.getName();
			//檢查方法名是否以test開頭
			if(mdname.startsWith("test")) {
				method.invoke(cls.newInstance());
			}
		}
		
	}
}
