package day03;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.junit.Test;

public class TestCase
{
	/**
	 * IP 规则检查
	 * 192.168.1.199 是一个32位数  最大值是42亿
	 * 8位.8位.8位.8位
	 * 
	 * 1.使用正则验证数据的结构
	 * 2.使用split劈开
	 * 3.逐个检查每个8位使用合理
	 */

	public static boolean checkIp(String ip){
		String rule = "^(\\d{1,3}\\.){3}(\\d{1,3})$";
		if(ip == null || !ip.matches(rule)){
			//检查入口数据完整同时减少if语句的嵌套!
			return false;
		}
		//if语句满足的情况下，执行如下语句
		String[] data = ip.split("\\.");
		for(String s: data){
			int n = Integer.parseInt(s);
			if(n<0 || n >255){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 测试checkIp方法
	 */
	//@Test
	public void testCheckIp(){
		//Scanner? 在JUnit不能使用nextXXX
		System.out.println(
				checkIp("192.168.1.199"));
		System.out.println(
				checkIp("192.168.1.254"));
		System.out.println(
				checkIp("193.168.1.256"));
		System.out.println(
				checkIp("192.168.199"));
		System.out.println(
				checkIp(null));
	
	}
	
	/**
	 * 测试Object默认的toString方法的结果
	 */
	//@Test
	public void testObjectToString(){
		Foo f = new Foo();
		//f.toString 调用了Object集成的toString方法，返回
		//类名@散列表  散列值：不是对象的地址
//		   这个返回值，没啥用
		//java建议子类重写toString
		System.out.println(f.toString());
		//println()自动调用toString
		System.out.println(f);
	}
	
	/**
	 * 测试重写toString()
	 */
	//@Test
	public void testToString(){
		Koo koo = new Koo();
		//自动调用重写的toString方法
		System.out.println(koo);
		Object obj = new Koo();
		//自动调用重写的toString方法
		System.out.println(obj);
	}
	
	/**
	 * 如何重写toString方法：
	 * 一般情况下，重写toString的目的方便软件的调试
	 * 都是返回当前对象的数据！
	 * 在输出对象的时候就很方便了。
	 * 
	 */
	
	//@Test
	public void testOverrideToString(){
		Airplane plane = new Airplane();
		System.out.println(plane);//显示飞机的位置
		plane.move();
		//字符串连接的时候也自动调用toString
		System.out.println("飞到了：" + plane);
		//Java 的"很多"API都自动调用toString
		// 1. print() println()
		// 2.字符串连接：  "飞到了" + plane
		// 3.String.valueOf(obj)
		
		String s = String.valueOf(plane);
		System.out.println(s);
		
		//4 Arrays.toString() 自动调用每个元素的toString：
		//  [ + 元素1.toString() +, 元素2.toString（） +... + ]
		Airplane[] all = {new Airplane(),plane};
		String ss = Arrays.toString(all);
		System.out.println(ss);
		// 5 ...
	}
	
	/**
	 * == 的作用
	 * 1. 比较”变量的值“ 是否一样
	 * 2.基本的类型的值，就是比较这个基本值
	 *   如果类型不兼容，先转换类型再比较
	 * 3.引用类型比较引用的值，就比较地址值
	 *   地址值一样，就返回值true，说明两个引用
	 *   引用的是同一个对象
	 * 4. == 不比较对象！ 只是比较变量的值
	 */
	
	//@Test
	public void testEqualsOpt(){
		int i = 5;
		long l = 5;
		System.out.println(i == l);//true
		Foo f1 = new Foo();
		Foo f2 = f1;
		Foo f3 = new Foo();
		Foo f4 = null;
		Object obj = null;
		Object obj2 = f1;
		System.out.println(f2 == f1);//true
		System.out.println(f1 == f3);//false
		System.out.println(f1 == f4);//false
		//                 null   null
		System.out.println(f4 == obj);//true
		//               f2 ==f1  obj2 == f1
		System.out.println(obj2 == f2);//true
	}
	
	/**
	 * 默认的Object equals 方法
	 *   是用 == 实现的功能， 不能比较两个方法 是否相等
	 *   Java的建议：重写equals实现对象的相等比较
	 */
	
	//@Test
	public void testObjectEquals(){
		Hoo h1 = new Hoo();
		Hoo h2 = new Hoo();
	}
	
	class Hoo{
		
	}
	/**
	 * 如何重写Object的equals方法：
	 * 1.建议在子类中重写equals 方法
	 * 2.根据当前对象的关键属性重写equals方法
	 * 3.重写要使用模板方式重写
	 *  符合equals的重写建议，参考API
	 * 4.单列对象无需重写equals
	 */
	//@Test
	public void testEquals(){
		//比较两个点对象是否
		Point p1 = new Point(3,4);
		Point p2 = new Point(3,4);
		Point p3 = new Point(3,5);
		System.out.println(p1.equals(p2));//true
		System.out.println(p1.equals(p3));//false
		System.out.println(p1.equals("3,4"));//fasle
		System.out.println(p1.equals(null));//false
	}
	
	class Point{
		int x;
		int y;
		public Point(){
			
		}
		
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		/**
		 * 重写Object的equals方法
		 * 重写规则：比较当前对象this与比较
		 * 对象obj的数据是否一样
		 */
		
		public boolean equals(Object obj){
			//入口检查数据
			if(obj == null) return false;
			//比较地址值是否一样
			if(this ==obj) return true;
			//如果不是同一个对象，必须按照对象的数据
			//按照对象的属性this(x,y) obj(x,y)比较
//			/如果值一样，就返回true  否则返回false
			if(obj instanceof Point){
				Point other = (Point) obj;
				return x == other.x && y == other.y;
			}
			return false;
		}
	}
	
	/**
	 * Java 系统API "很多"都重写了equals方法
	 * 用于比较两个对象是否相等
	 * 1. String重写了equals方法用于比较
	 *    string对象是否相等
	 *    比较两个字符串相等应该使用equals方法
	 */
	//@Test
	public void testStringEquals(){
		String s1 = new String("ABC");
		String s2 = new String("ABC");
		//s1 == s2 结果说明s1 和s2引用的不是同一个对象
		System.out.println(s1 ==s2);
		
	}
	
	/*
	 * 包装类 Nubmer 
	 * 1.Number 是数值包装类的抽象父类型
	 * 2.Number 提供了类型转换算法
	 */
	
	//@Test
	public void testNumber(){
		//所有数值类型都可以赋值给Number
		//Java 将3.14包装为Double类型对象
		//再将引用赋值给n1
		
		Number n1 = 3.1415926;
		Number n2 = 0.618;
		
		//Java 将5包装为Integer类型对象再将引用赋值给n3
		Number n3 = 5;
		//Number 提供数值类型转换方法
		int i = n1.intValue();//1
		System.out.println(1);
		double x = n3.doubleValue();//5.0
		System.out.println(x);
		//取回double值
		double d = n1.doubleValue();
		System.out.println(d);//3.1415926
	}
	
	/*
	 * Integer 定义了整数的最大值和最小值常量
	 */
	
	//@Test
	public void testMaxValue(){
		//整数的最大值
		int max = Integer.MAX_VALUE;
		//整数的最小值
		int min = Integer.MIN_VALUE;
		System.out.println(max - min);
	}
	
	/**
	 * Integer 提供了int与String之间转换方法
	 * 科技以人为本
	 * 1、人能够理解和识别文本信息”250“
	 * 2.计算机内部只有2进制数据！  11111010
	 * 3.Java在包装类中提供了每种数据类型的2进制数据到文本的转换方法
	 * ，目的是将计算机内部数据转换为人类能够识别文本信息！
	 * Integer 提供了静态方法toString()
	 * 将计算机内部11111010转换为”250“方法
	 * 4.Java在输出整数数据时候，都会调用toString转换后再输出
	 */
	
	//@Test
	public void testIntegerToString(){
		int i = 0xfa;//内存中1111 1010
		//println 自动调用Integer.toString()
		//将i的值（2进制）转换为”250“再输出
		System.out.println(i);
		
		//类似如下过程：
		String s = Integer.toString(i);
		System.out.println(s);
		
		//String.ValueOf() 与Integer.toString(i);
		String  ss = String.valueOf(i);
		System.out.println(ss);
		
		//toString(i,进制)
		System.out.println(Integer.toString(i,16));
		System.out.println(Integer.toString(i,3));
		
		//toString 实现了内存的int转换为String方法
		//parseInt 实现”10进制整数字符串“转换为int的算法
		int a = Integer.parseInt("250");
		//a在内存是2进制的11111010
		System.out.println(a);//250
		//如下代码  转换都是自动发生的，本质还是
		//利用toString parseInt方法实现的
		int  b = 100;
		System.out.println(b);
		
		
	}
	
	//自动包装
	//@Test
	public void testAutoBoxing(){
		//Java自动的将int变量包装为Integer类型的对象
		Integer i = 5;
		Integer b = 100;
		//Java的编译器进行了代码替换
		//编译器采用如下代码替换了Integer  b =100;
		//Integer b = Integer.valueOf(100);
		Integer c = Integer.valueOf(100);
		//优点： 写代码少了！
		//for(String s: data) 编译器进行替换的!
		//自动拆箱： 将Integer中的int值去除的过程
		int x = c;
		//编译器进行的替换， int x=c
		//替换为int x = c.intValue();
		//在运算表达式等很多位置都是自动发送
		int y = c*100;
		System.out.println(y);
		
		
	}
	
	/**
	 * Double提供了
	 * double 类型到String类型相互转换算法
	 * 3.14 到”3.14“
	 * toString: double 转换为String
	 * parseDouble:  String 转double
	 * 
	 * 思考： ”true“如何转换为boolean数据
	 * String s = "Day Day up : true"
	 * boolean b = Boolean.parseBoolean("true")
	 */
	@Test
	public void testDouble(){
		double pi = 3.14159;
		String s = Double.toString(pi);
		System.out.println(s);
		
		double d = Double.parseDouble("0.618");
		System.out.println(d);
		
		//凡是不自动执行这两个方法时候就手动调用
		// double d = 8.8;
		//g.drawString(Double.toString(d),x,y);
		String str= "黄金分割:0.618";
		String ss = str.substring(str.indexOf(":")+1);
		double x = Double.parseDouble(ss);
		System.out.println("---------------------");
		System.out.println(x);
	}
	
	
	/**
	 * 系统时间毫秒数
	 */
	//@Test
	public void testTimeMillis(){
		long now = System.currentTimeMillis();
		System.out.println(now);
	}
	
	/**
	 * Date 类型
	 * 1.Date类型内部封装的就是当前系统毫秒数
	 * 2.Date提供了算法：帮助根据毫秒数计算出当前的时间分量： 年  月  日
	 */
	//@Test 
	public void testDate(){
		//请导入java.util.Date类
		//date对象内部数据就是当前系统的时间毫秒数
		// Date date = new Date(1000L*60*60*24*360);
		Date date = new Date();
		long now = date.getTime();
		System.out.println(now);//毫秒数
		//计算时间分量，根据时间毫秒数计算得到的
		//getYear()在2000以前是正常的2位数时间
		//2000年以后就变成3位了
		//  1997:97  1999:99  2000:100  2015:115
		int year = date.getYear() + 1900;
		System.out.println(year);//2015
	}
	
	/**
	 * setTime 方法
	 */
	public void testSetTime(){
		Date date = new Date();
		System.out.println(date);
		long time = date.getTime();
		//简单的时间计算方法：使用毫秒数计算
		time += 1000L*60*60*24;
		//修改date的时间
		date.setTime(time);
		System.out.println(date);
	}
	
	/**
	 * Date 类型重写了toString 和equals方法
	 */
	
	//@Test
	public void testDateEquals(){
		Date d1 = new Date();
		Date d2 = new Date();
		System.out.println(d1.getTime());
		System.out.println(d2.getTime());
		System.out.println(d1.equals(d2));//true
	}
	
	/**
	 * SimpleDateFormat 类API 
	 * 日期的格式化
	 * 1.提供将系统时间（long Date）转换为String时间，目的是给人看
	 * 2.将字符串时间转换为long/Date给计算机
	 */
	
	//@Test
	public void testDateFormat(){
		SimpleDateFormat fmt = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		long now = System.currentTimeMillis();
		//format(long) java 手册没有说明，但是能用
		String str = fmt.format(now);
		System.out.println(str);
		Date d = new Date(0);
		String s = fmt.format(d);
		System.out.println(s);
	}
	
	
}//TestCase类的结束

class Airplane{
	int x, y;
	public void move(){
		y++;
	}
	public String toString(){
		return x + "," + y; //返回当前对象的数据
	}
}

class Koo{
	public String toString(){
		return "Hello Tom!";
	}
}

class Foo{
	
}
