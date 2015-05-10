package day01;

import org.junit.Test;

/**
 * Test 测试Case案例
 *
 */
public class TestCase
{
	//@Test  //加上@Test注解的方法就可以执行了
	//要求这个方法必须是共有的无参数无返回值的方法
	@Test
	public void hello(){
		System.out.println("Hello world");
	}
	
	//@Test
	public void testIndexOf(){
		String str = "I can because I think I can!";
		int index = str.indexOf("can");
		System.out.println(index);
		index = str.lastIndexOf("can");
		System.out.println(index);
		index = str.indexOf("can", 6);
		System.out.println(index);
		index = str.indexOf("Can");
		System.out.println(index);
	}
	
	/**
	 *  indexOf的经典用途：检查字符串的包含关系
	 */
	//@Test
	public void test2IndexOf(){
		String str = "photo_2014_01.jpg";
		//检查文件中是否包含2014字样
		//str.indexOf("2014")>=0 测试是否包含一个字符串
		if(str.indexOf("2014")>= 0){
			System.out.println("包含2014字样");
		}
	}
	
	/**
	 * 截取部分字符串，substring
	 */
	//@Test
	public void testSubstring(){
		String email = "liucangsong@gmail.com";
		//1)获取用户名
		String name = email.substring(0,11);
		System.out.println(name);
		//2)获取主机名
		String host = email.substring(12);
		System.out.println(host);
		//通用做法
		email ="liucs@tarena.com.cn";
		    //先获取@的地址
		int index = email.indexOf('@');
		name = email.substring(0,index);//前者包含后者不包含
		//获取主机名
		host = email.substring(index+1);
		System.out.println(host);
	}
	
	/**
	 * trim 功能：
	 * 1.去除字符串两端的空白！
	 *   空白是编码小于 13的控制字符！  和空格
	 *   包括：  空格  \t   \n    \r     \0
	 *       水平制表          换行             回车              空字符
	 *  2.trim（）返回值：
	 *     A.如果返回的内容与原字符串不一样
	 *       则返回的是新字符串对象，原对象不变
	 *     B.如果返回内容不需改变，则直接返回原
	 *        字符串对象，这样性能好
	 *  3.用途：经常用于处理用户意外输入的空白
	 *        
	 *   
	 */       
	//@Test
	public void testTrim(){
		//打印任何字符的编码
		char c = ' ';
		System.out.println((int) c);
		//用户输入的数据包含空白
		String name = "Tom \t \n \r \0";
		//trim()返回的是新对象
		String login = name.trim();
		System.out.println(login);//"Tom"
		//login与name引用的是不同的对象
		System.out.println(login == name);
		
		 name = "Tom";
		 //无需改变的时候返回原对象，性能好
		 login = name.trim();
		 //login与name引用的是相同的对象
		 System.out.println(login == name);
		
	}
	
	//trim（）方法经典面试题
	//@Test
	public void testTrim2(){
		String name = "  Tom   ";
		name.trim();  //方法返回是新对象引用
		//原对象不变
		System.out.println(name);//   Tom
		//正常的写法
		name = name.trim();//更改name引用了”新对象“
		System.out.println(name);//"Tom"
		
		//name经过trim之后引用了新对象，但没有放进常量池
		//而s = "Tom"这一变量在产生之后就放进常量池了，所以两者不是同一引用
		String s = "Tom";
		System.out.println(s == name);//***false
		
		//Tom在trim之后还是返回原来的Tom，所以为true
		String ss = "Tom".trim();
		System.out.println(s == ss);//true
		
	}
	
	
	//打印一个字符串中每个字符的编码
	//@Test
	public void printCharCode(){
		String str = "刘苍松";
		
		for(int i = 0; i < str.length();i++){
			char c = str.charAt(i);
			System.out.println(c);
		}
	}
	
	//挑出字符串中的英文字符
	//如果需要实现字符串每个字符的遍历算法
	//可以利用length（） charAt() + for 循环实现
	
	@Test
	public void testCharAt(){
		String s= "我爱java";
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if((c>='a'&&c<='z')||(c>='A'&&c<='Z'))
			{
				System.out.println(c);
			}
		}
	}
	
	//检查用户输入的字符串与哪个字符串的开头一样
	@Test
	public void testStartsWith(){
		String[] words = {"public ","protected","private","class","for"};
		String s = "p";
		for(String word : words){
			if(word.startsWith(s)){
				System.out.print(word+" ");
			}
		}
		
	}
	
	//检查一个文件是否是png图片
	@Test
	public void testEndsWith(){
		String filename = "luanzhikun.png  ";
		//去头尾
		filename = filename.trim();
		if(filename.endsWith(".png")){
			System.out.println("是png图片");
			
		}
		
	}
	
	/**
	 * 大小写转换方法
	 * 1.将字符串中的英文转换为小写，大写
	 * 2.返回值
	 *   A.如果需要转换为大写，小写返回新对象
	 *   B.如果无需改变，就返回原对象
	 */
	//@Test
	public void testCase(){
		
		//转换之后需要赋值给字符串str才能改变str的引用，否则str还是原来的那个对象
		String str = "我喜欢Java";
		str.toUpperCase();
		System.out.println(str);
		str = str.toUpperCase();
		System.out.println(str);
		
		str = str.toLowerCase();
		System.out.println(str);
		
		String s = "您好java";
		String ss ="您好java".toLowerCase();
		System.out.println(s == ss);
		
		//检查一个文件是否为png文件
		//1.将文件名trim
		//2.转换为全部小写
		//3，在判断是否为.png结尾
		String filename = "screen.png";
		filename = filename.trim().toLowerCase();
		if(filename.endsWith(".png")){
			System.out.println("是png文件");
		}
		
		//根据原文件名生成一个新文件名
		//文件名要求：原文件名_时间毫秒数.png
		
		//找出.的位置,拆分成两部分
		int index = filename.lastIndexOf(".");
		String name = filename.substring(0,index);
		//ext 外部的
		String ext = filename.substring(index);//后缀名
		long time = System.currentTimeMillis();
		System.out.println(name + "_" + time + ext);
		
		
		
	}
	
	/**
	 * valueOf() 方法
	 * 1.是一个静态方法
	 * 2.有一系列重载的valueOf方法
	 * 3.将其他类型转换为字符串类型
	 *   本质上是将内存中的数据转换为String类型
	 *   用于输出（给人看）
	 * 4.任何数据按照字符串数据时候底都自动调用
	 *   这个valueOf方法实现数据的转化
	 *   int a = 0xff;//1111 1111
	 *   valueOf 将a的二进制转换为字符串“255”
	 *   String s = String.valueOf(a)
	 *   println(s)//255
	 *   println(a)//255 底层也自动调用valueOf
	 * 5  凡是需要手工转换  数据到字符串时候
	 *   就可以调用这个方法实现数据类型转换
	 * 
	 */
	@Test
	public void testValueOf(){
		int a = 0xff;
		String s = String.valueOf(a);
		System.out.println(s);
		
		System.out.println(a);
		double pi = 3.1415926;
		System.out.println(pi);
		s = String.valueOf(pi);
		System.out.println(s);
		
		//凡是需要手工转换  数据到字符串时候
		//就可以调用这个方法实现数据类型转换
		boolean b = true;
		int n = 100;
		String str = String.valueOf(n) + String.valueOf(b);
		System.out.println(str);
	}
	
	
	@Test
     public void testValueOf2(){
		
		
	}
}
