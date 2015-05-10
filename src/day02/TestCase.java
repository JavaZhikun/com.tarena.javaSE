package day02;

import org.junit.Test;

public class TestCase
{
	/**
	 * 测试StringBuilder 的API
	 */
	//@Test
	public void testStringBuilder(){
		//创建了StringBuilder对象，空白对象
		//StringBuilder 内部的数组可以改变
		//空白对象可以更改内容
		
		StringBuilder buf = new StringBuilder();
		//append方法修改了buf的内容，为其追加了内容"孙俪"
		buf.append("孙俪");
		//输出的时候说明buf引用的对象内容为 孙俪
		System.out.println(buf);
		//全面测试StringBuffer 的API
		//append 追加
		//insert 插入    delete 删除   replace替换
		buf.append("的").append("老公是").append("邓超").insert(6, "逗比")
		.delete(2, 3).replace(7,9,"邓XX");
		System.out.println(buf);
	}
	
	
	/**
	 * Java 的动态字符串连接就是使用StringBuilder实现的
	 */
	
	//@Test
	public void testStringConcat(){
		String s = "A";
		//字符串连接就是使用StringBuilder 实现的
		String s1 = new StringBuilder(s).append("De").append(5).toString();
		System.out.println(s1);//ADe5
		//如上是一个StringBuilder对象
		
		String s2 = "A";
		s2 = s2 + 'A';
		//new StringBuilder(s2).append('A').toString()
		s2 = s2 + 'A';
		System.out.println(s2);
		//new StringBuilder(s2).append('A').toString()
		//***如上代码每行都会创建StringBuilder对象
		//性不好
		//建议做如下替换
		StringBuilder buf = new StringBuilder("A");
		buf.append("A");
		buf.append("A");
		s2 = buf.toString();
		System.out.println(s2);
	}
	
	/**
	 * 测试String的链接性能
	 */
	//@Test
	public void test1(){
		long start = System.nanoTime();//***系统的纳秒时间
		//连接字符串
		String s = "";//空字符串
		for(int i = 0; i < 10000; i++){
			s = s + "A";//创建StringBuilder
		}
		long end = System.nanoTime();
		System.out.println("test1:" + (end - start));//test1:648043637
		
	}
	
	/**
	 * 测试StringBuilder的连接性能
	 * 
	 */
	//@Test
	public void test2(){
		long start = System.nanoTime();
		//使用StringBuilder连接10000个A
		//在循环期间使用1个StringBuilder对象
		StringBuilder buf = new StringBuilder();
		for(int i = 0; i < 10000; i++){
			buf.append("A");
		}
		
		long end = System.nanoTime();
		System.out.println("test2:" + (end - start)); //	test2:1406876
	
	}
	
	/**
	 * 使用String类的API测试正则表达式
	 * String 提供了方法
	 *    match 检查字符串和正则表达式的匹配关系
	 */
	
	//@Test
	public void testReg(){
		String r1 = "[a-z]";
		//r1的规则意义 ： a-z某一个字符
		String s = "a";
		// 调用matches方法检查s的值是否符合r1规则
		System.out.println(s.matches(r1)); //true
		System.out.println("T".matches(r1));//true
		
		String r2 = "\\d.{0,}\\html";
		System.out.println("r2:" + r2);// \d.{0.}\.html
		String file = "518_index.html";
		System.out.println(file.matches(r2));//true
		
		
		String r3 = "我\\s* [去草]";
		String str = "我   去";
		System.out.println(str.matches(r3));//true
		
		String str2 = "我去了吗？";
		System.out.println(str2.matches(r3));
	
	
	
	
	
	
	}
	
	//@Test
	public void testReg2(){
		//matches 方法与测试工具的差别
		//matches 进行全部内容的匹配：str必须全部符合规则返回true
		//Reg测试工具：在字符串中检索符合规则的位置
		//Ip的规则测试
		String r4 = "(\\d{1,3}\\.){3}\\d{1,3}";
		String ip = "192.168.1.10";
		System.out.println(ip.matches(r4));//true
		
		
		//匹配一个文件的规则:
		//5index.html  5index.HTML
		//\d.*\.(html|HTML)
		String r5 = "\\d.*\\.(html|HTML)";
		String htmlFile = "518index.Html";
		System.out.println(htmlFile.toLowerCase().matches(r5));//true
		
		String r6 = "\\w{8,10}";  //从头到尾连续8-10个单词字符
		String str3 = "Tom12323_And_Jerry";
		System.out.println(str3.matches(r6));//false
		
	}
	
	//String matches
	
	//@Test
	public void testMatches(){
		String emailReg = 
				"^[0-9a-zA-Z_.-]+@([0-9a-zA-Z-]+\\.)+"+"[0-9a-zA-Z]{2,4}$";
		
		String mail = "liucangsong@gmail.com";
		String mail2 = "liucs@tarena.com.cn";
		System.out.println(mail.matches(emailReg));
		System.out.println(mail2.matches(emailReg));
		
		//其中 ^代表字符串开始
		//$代表字符串结束
		//这种写法有从头到尾整体的规定
	}
	
	
	//测试split方法
	/**
	 * 这个案例是经典的字符拆分方法
	 * 在字符串处理中非常有用
	 * 
	 */
	
	//@Test
	public void testSplit(){
		String str = "tom, 2, 119,tom@tarena.com.cn";
		//split 将字符串str按照位置 ,\s*   \s表示空白字符  [\t\n\x0B\f\r]
		//X*表示0个或者任意多个X
		String[] data = str.split(",\\s*");
		for(String s : data){
			System.out.println(s);
		}
	}
	
	
	//@Test
	public void testIp(){
		//ip地址的严格检验算法
		//ip: 192.168.1.199
		//  1)先检查正则规则 matches
		//  2)用 . 劈开
		//  3）将每个数字转换为int
		//     int n =Integer.parseInt("199");
		//  4)检查每个数字是否  0 -255
		
		String ip = "1922.168.1.199";
		String ipReg = "^(\\d{1,3}\\.){3}"+"([\\d{1,3}){1}$";
		boolean isIp = true;
		if(ip.matches(ipReg)){
			String[] data = ip.split("\\.");
			for(String str : data){
				int n = Integer.parseInt(str);
				if(n < 0 || n > 255){
					isIp = false;
				}
			}
			System.out.println(isIp);
		}
				
          //"^[0-9a-zA-Z_.-]+@([0-9a-zA-Z-]+\\.)+"+"[0-9a-zA-Z]{2,4}$";
	}
	
	
	/**
	 * replaceAll 测试
	 */
	//@Test
	public void testReplaceAll(){
		//实现关键词替换功能：
		 //将 “我去” “我草” 替换为XX
		String str = "那一年我去了她们家," + "她说：我草";
		//返回结果是新字符串
		str = str.replaceAll("我[去草]", "XX");
		System.out.println(str);
	}
	
	
	//身份证号码的校验
	@Test
	public void testIdCard(){
		//
		String id ="421127199002202546";
		String regex = "^\\d{17}"+"(\\d|X){1}$";
		
		
//		11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:" 
//			安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",
//		52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"
		boolean isID = true;
		
		if(id.matches(regex)){
			int province = Integer.parseInt(id.substring(0,2));
			//判断省份是否正确
			int[] all = {11,12,13,14,15,21,22,23,31,32,33,34,35,36,37,41,42,43,44,45,46,
					     50,51,52,53,54,61,62,63,64,65,71,81,82};
			boolean isProvince = false;
			for(int i = 0 ; i <all.length; i++){
				if(province == all[i]){
					isProvince = true;
				}
			}
			//省份不正确，则不是ID号
			if(isProvince == false){
				isID = false;
			}
			int year = Integer.parseInt(id.substring(6,10));
			int month = Integer.parseInt(id.substring(10,12));
			int day = Integer.parseInt(id.substring(12,14));
			
			//年份在2016年以前
			if(year>2016)
				 isID =false;
			//月份在1到12之间
			if(month < 1 || month > 12)
				isID = false;
			
			
			switch(month){
			//大月有31天
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:  if(day < 0 || day >31 )
						 isID = false;break;
			//小月有30天
			case 4:
			case 6:
			case 9:
			case 11:  if(day < 0 || day >30)
				         isID = false; break;
		     //2月特殊月
			case 2:  if(year %4==0 && year%100!=0 ||year%400==0){//是闰年
							if(day < 0 || day>29)
								isID = false; break;
						}
					
					//非闰年
					if(day < 0 || day > 28)
						isID = false; break;
			}
			
			if(isID){
				System.out.println("是身份证号码！");
			}else{
				System.out.println("不是身份证号码！");
			}
			
			
		}
	}
	
	

}
