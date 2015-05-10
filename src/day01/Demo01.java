package day01;

/**
 * 字符串“对象”是不可改变的
 * 字符串的引用是可以改变的
 *
 */

public class Demo01
{
	public static void main(String[] args){
		String s1="ab";
		String s2 = s1;
		s2 = s2 + "cd";
		System.out.println(s2);
		//s1 能输出“ab”就说明：字符串“对象”是不可改变的
		System.out.println(s1);//ab
	}

}
