package com.cbt.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 *  Class.newInstance() 与 Constructor.newInstance()
 *  - Class.newInstance()只能调用类中无参数构造器！如果没有无参数构造器则抛出异常
 *  - Constructor.newInstance()可以调用任何一个构造器
 *  在实际工作中，大部分类都是无参数构造器！所以在利用发射创建对象时，Class.newInstance()更加方便常用。
 *  
 *  @作者 soft01
 *  2018年6月25日下午3:11:41
 */
public class ConstrutorDemo {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入类名：");
		Class cls = Class.forName(scanner.nextLine());
		
		//找到类中的无参构造
		//在cls对应的类型上查找一个int类型参数的构造器，找到了赋值给constructor
		//如果没有找到构造器则抛出异常！
		Constructor constructor = cls.getConstructor(int.class);		
		//一定传递类型相同的数据，否则将出现异常
		Object obj = constructor.newInstance(58);
		
		Constructor constructors = cls.getConstructor(int.class,int.class);
		Object objs = constructors.newInstance(20,30);
		//检查创建对象
		System.out.println(obj);
		System.out.println(objs);

	}
}
