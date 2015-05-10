package day03;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.junit.Test;

public class TestCase
{
	/**
	 * IP ������
	 * 192.168.1.199 ��һ��32λ��  ���ֵ��42��
	 * 8λ.8λ.8λ.8λ
	 * 
	 * 1.ʹ��������֤���ݵĽṹ
	 * 2.ʹ��split����
	 * 3.������ÿ��8λʹ�ú���
	 */

	public static boolean checkIp(String ip){
		String rule = "^(\\d{1,3}\\.){3}(\\d{1,3})$";
		if(ip == null || !ip.matches(rule)){
			//��������������ͬʱ����if����Ƕ��!
			return false;
		}
		//if������������£�ִ���������
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
	 * ����checkIp����
	 */
	//@Test
	public void testCheckIp(){
		//Scanner? ��JUnit����ʹ��nextXXX
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
	 * ����ObjectĬ�ϵ�toString�����Ľ��
	 */
	//@Test
	public void testObjectToString(){
		Foo f = new Foo();
		//f.toString ������Object���ɵ�toString����������
		//����@ɢ�б�  ɢ��ֵ�����Ƕ���ĵ�ַ
//		   �������ֵ��ûɶ��
		//java����������дtoString
		System.out.println(f.toString());
		//println()�Զ�����toString
		System.out.println(f);
	}
	
	/**
	 * ������дtoString()
	 */
	//@Test
	public void testToString(){
		Koo koo = new Koo();
		//�Զ�������д��toString����
		System.out.println(koo);
		Object obj = new Koo();
		//�Զ�������д��toString����
		System.out.println(obj);
	}
	
	/**
	 * �����дtoString������
	 * һ������£���дtoString��Ŀ�ķ�������ĵ���
	 * ���Ƿ��ص�ǰ��������ݣ�
	 * ����������ʱ��ͺܷ����ˡ�
	 * 
	 */
	
	//@Test
	public void testOverrideToString(){
		Airplane plane = new Airplane();
		System.out.println(plane);//��ʾ�ɻ���λ��
		plane.move();
		//�ַ������ӵ�ʱ��Ҳ�Զ�����toString
		System.out.println("�ɵ��ˣ�" + plane);
		//Java ��"�ܶ�"API���Զ�����toString
		// 1. print() println()
		// 2.�ַ������ӣ�  "�ɵ���" + plane
		// 3.String.valueOf(obj)
		
		String s = String.valueOf(plane);
		System.out.println(s);
		
		//4 Arrays.toString() �Զ�����ÿ��Ԫ�ص�toString��
		//  [ + Ԫ��1.toString() +, Ԫ��2.toString���� +... + ]
		Airplane[] all = {new Airplane(),plane};
		String ss = Arrays.toString(all);
		System.out.println(ss);
		// 5 ...
	}
	
	/**
	 * == ������
	 * 1. �Ƚϡ�������ֵ�� �Ƿ�һ��
	 * 2.���������͵�ֵ�����ǱȽ��������ֵ
	 *   ������Ͳ����ݣ���ת�������ٱȽ�
	 * 3.�������ͱȽ����õ�ֵ���ͱȽϵ�ֵַ
	 *   ��ֵַһ�����ͷ���ֵtrue��˵����������
	 *   ���õ���ͬһ������
	 * 4. == ���Ƚ϶��� ֻ�ǱȽϱ�����ֵ
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
	 * Ĭ�ϵ�Object equals ����
	 *   ���� == ʵ�ֵĹ��ܣ� ���ܱȽ��������� �Ƿ����
	 *   Java�Ľ��飺��дequalsʵ�ֶ������ȱȽ�
	 */
	
	//@Test
	public void testObjectEquals(){
		Hoo h1 = new Hoo();
		Hoo h2 = new Hoo();
	}
	
	class Hoo{
		
	}
	/**
	 * �����дObject��equals������
	 * 1.��������������дequals ����
	 * 2.���ݵ�ǰ����Ĺؼ�������дequals����
	 * 3.��дҪʹ��ģ�巽ʽ��д
	 *  ����equals����д���飬�ο�API
	 * 4.���ж���������дequals
	 */
	//@Test
	public void testEquals(){
		//�Ƚ�����������Ƿ�
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
		 * ��дObject��equals����
		 * ��д���򣺱Ƚϵ�ǰ����this��Ƚ�
		 * ����obj�������Ƿ�һ��
		 */
		
		public boolean equals(Object obj){
			//��ڼ������
			if(obj == null) return false;
			//�Ƚϵ�ֵַ�Ƿ�һ��
			if(this ==obj) return true;
			//�������ͬһ�����󣬱��밴�ն��������
			//���ն��������this(x,y) obj(x,y)�Ƚ�
//			/���ֵһ�����ͷ���true  ���򷵻�false
			if(obj instanceof Point){
				Point other = (Point) obj;
				return x == other.x && y == other.y;
			}
			return false;
		}
	}
	
	/**
	 * Java ϵͳAPI "�ܶ�"����д��equals����
	 * ���ڱȽ����������Ƿ����
	 * 1. String��д��equals�������ڱȽ�
	 *    string�����Ƿ����
	 *    �Ƚ������ַ������Ӧ��ʹ��equals����
	 */
	//@Test
	public void testStringEquals(){
		String s1 = new String("ABC");
		String s2 = new String("ABC");
		//s1 == s2 ���˵��s1 ��s2���õĲ���ͬһ������
		System.out.println(s1 ==s2);
		
	}
	
	/*
	 * ��װ�� Nubmer 
	 * 1.Number ����ֵ��װ��ĳ�������
	 * 2.Number �ṩ������ת���㷨
	 */
	
	//@Test
	public void testNumber(){
		//������ֵ���Ͷ����Ը�ֵ��Number
		//Java ��3.14��װΪDouble���Ͷ���
		//�ٽ����ø�ֵ��n1
		
		Number n1 = 3.1415926;
		Number n2 = 0.618;
		
		//Java ��5��װΪInteger���Ͷ����ٽ����ø�ֵ��n3
		Number n3 = 5;
		//Number �ṩ��ֵ����ת������
		int i = n1.intValue();//1
		System.out.println(1);
		double x = n3.doubleValue();//5.0
		System.out.println(x);
		//ȡ��doubleֵ
		double d = n1.doubleValue();
		System.out.println(d);//3.1415926
	}
	
	/*
	 * Integer ���������������ֵ����Сֵ����
	 */
	
	//@Test
	public void testMaxValue(){
		//���������ֵ
		int max = Integer.MAX_VALUE;
		//��������Сֵ
		int min = Integer.MIN_VALUE;
		System.out.println(max - min);
	}
	
	/**
	 * Integer �ṩ��int��String֮��ת������
	 * �Ƽ�����Ϊ��
	 * 1�����ܹ�����ʶ���ı���Ϣ��250��
	 * 2.������ڲ�ֻ��2�������ݣ�  11111010
	 * 3.Java�ڰ�װ�����ṩ��ÿ���������͵�2�������ݵ��ı���ת������
	 * ��Ŀ���ǽ�������ڲ�����ת��Ϊ�����ܹ�ʶ���ı���Ϣ��
	 * Integer �ṩ�˾�̬����toString()
	 * ��������ڲ�11111010ת��Ϊ��250������
	 * 4.Java�������������ʱ�򣬶������toStringת���������
	 */
	
	//@Test
	public void testIntegerToString(){
		int i = 0xfa;//�ڴ���1111 1010
		//println �Զ�����Integer.toString()
		//��i��ֵ��2���ƣ�ת��Ϊ��250�������
		System.out.println(i);
		
		//�������¹��̣�
		String s = Integer.toString(i);
		System.out.println(s);
		
		//String.ValueOf() ��Integer.toString(i);
		String  ss = String.valueOf(i);
		System.out.println(ss);
		
		//toString(i,����)
		System.out.println(Integer.toString(i,16));
		System.out.println(Integer.toString(i,3));
		
		//toString ʵ�����ڴ��intת��ΪString����
		//parseInt ʵ�֡�10���������ַ�����ת��Ϊint���㷨
		int a = Integer.parseInt("250");
		//a���ڴ���2���Ƶ�11111010
		System.out.println(a);//250
		//���´���  ת�������Զ������ģ����ʻ���
		//����toString parseInt����ʵ�ֵ�
		int  b = 100;
		System.out.println(b);
		
		
	}
	
	//�Զ���װ
	//@Test
	public void testAutoBoxing(){
		//Java�Զ��Ľ�int������װΪInteger���͵Ķ���
		Integer i = 5;
		Integer b = 100;
		//Java�ı����������˴����滻
		//�������������´����滻��Integer  b =100;
		//Integer b = Integer.valueOf(100);
		Integer c = Integer.valueOf(100);
		//�ŵ㣺 д�������ˣ�
		//for(String s: data) �����������滻��!
		//�Զ����䣺 ��Integer�е�intֵȥ���Ĺ���
		int x = c;
		//���������е��滻�� int x=c
		//�滻Ϊint x = c.intValue();
		//��������ʽ�Ⱥܶ�λ�ö����Զ�����
		int y = c*100;
		System.out.println(y);
		
		
	}
	
	/**
	 * Double�ṩ��
	 * double ���͵�String�����໥ת���㷨
	 * 3.14 ����3.14��
	 * toString: double ת��ΪString
	 * parseDouble:  String תdouble
	 * 
	 * ˼���� ��true�����ת��Ϊboolean����
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
		
		//���ǲ��Զ�ִ������������ʱ����ֶ�����
		// double d = 8.8;
		//g.drawString(Double.toString(d),x,y);
		String str= "�ƽ�ָ�:0.618";
		String ss = str.substring(str.indexOf(":")+1);
		double x = Double.parseDouble(ss);
		System.out.println("---------------------");
		System.out.println(x);
	}
	
	
	/**
	 * ϵͳʱ�������
	 */
	//@Test
	public void testTimeMillis(){
		long now = System.currentTimeMillis();
		System.out.println(now);
	}
	
	/**
	 * Date ����
	 * 1.Date�����ڲ���װ�ľ��ǵ�ǰϵͳ������
	 * 2.Date�ṩ���㷨���������ݺ������������ǰ��ʱ������� ��  ��  ��
	 */
	//@Test 
	public void testDate(){
		//�뵼��java.util.Date��
		//date�����ڲ����ݾ��ǵ�ǰϵͳ��ʱ�������
		// Date date = new Date(1000L*60*60*24*360);
		Date date = new Date();
		long now = date.getTime();
		System.out.println(now);//������
		//����ʱ�����������ʱ�����������õ���
		//getYear()��2000��ǰ��������2λ��ʱ��
		//2000���Ժ�ͱ��3λ��
		//  1997:97  1999:99  2000:100  2015:115
		int year = date.getYear() + 1900;
		System.out.println(year);//2015
	}
	
	/**
	 * setTime ����
	 */
	public void testSetTime(){
		Date date = new Date();
		System.out.println(date);
		long time = date.getTime();
		//�򵥵�ʱ����㷽����ʹ�ú���������
		time += 1000L*60*60*24;
		//�޸�date��ʱ��
		date.setTime(time);
		System.out.println(date);
	}
	
	/**
	 * Date ������д��toString ��equals����
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
	 * SimpleDateFormat ��API 
	 * ���ڵĸ�ʽ��
	 * 1.�ṩ��ϵͳʱ�䣨long Date��ת��ΪStringʱ�䣬Ŀ���Ǹ��˿�
	 * 2.���ַ���ʱ��ת��Ϊlong/Date�������
	 */
	
	//@Test
	public void testDateFormat(){
		SimpleDateFormat fmt = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		long now = System.currentTimeMillis();
		//format(long) java �ֲ�û��˵������������
		String str = fmt.format(now);
		System.out.println(str);
		Date d = new Date(0);
		String s = fmt.format(d);
		System.out.println(s);
	}
	
	
}//TestCase��Ľ���

class Airplane{
	int x, y;
	public void move(){
		y++;
	}
	public String toString(){
		return x + "," + y; //���ص�ǰ���������
	}
}

class Koo{
	public String toString(){
		return "Hello Tom!";
	}
}

class Foo{
	
}
