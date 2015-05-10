package day01;

/**
 * 检测字符串的长度（字符的个数） length（）
 * 1.无论英文还是中文都是一个字符
 * 2.字符串中每个字符都是char类型的数据
 * 3.16位占用2个字节，与字符一样都是unicode编码
 * 
 *
 */
public class Demo03
{
	public static void main(String[] args){
		String s = "ABCD";
		System.out.println(s.length());
		s = "您好, \\Java!";
		System.out.println(s.length());
	}
	
	

}
