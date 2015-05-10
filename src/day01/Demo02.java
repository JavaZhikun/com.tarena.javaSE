package day01;


/**
 * 字符串常量池
 * 1. Java 尽量重用静态字符串 ，减少内存使用，提高性能
 * 2. 哪些字符串对象被重用：
 *    A,字符串字面量，如：“ABC”
 *    B.字符串常量：
 *       static final String S ="ABC"
 *    C.字面量和常量静态连接的结果：
 *       “AB” + "c"   "AB" + ‘c’  S + "C"
 * 3.如何重用的：java在运行期间将一样的静态字符串引用同一个对象，实现重用
 * 4.哪些情况不重用：
 *     A.使用new 创建的字符串
 *     B.动态字符串（变量）连接结果
 *  5、如何检测是否发生了重用？
 *     使用==运算比较引用对象的值是否为同一个地址值，如果返回true，就说明是
 *     同一个对象的地址，也就是被“重用”了
 *
 */
public class Demo02
{
	public static final String S = "Hello!";
	public static final String SS ="Hello";
	
	public static void main(String[] args){
		String s1 ="Hello!";
		String s2 = "Hello!";
		String s3 = new String("Hello");
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s1 ==S);
		String s4 = SS +"!"; //编译期直接得出结果
		
		System.out.println(s4 ==s1);
		String s5 = SS;
		String s6 = s5 + "!";  //s6是变量连接的结果
		System.out.println(s6 == s1);//false
	}
	
	
	
	

}
