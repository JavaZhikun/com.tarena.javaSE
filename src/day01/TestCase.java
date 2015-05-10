package day01;

import org.junit.Test;

/**
 * Test ����Case����
 *
 */
public class TestCase
{
	//@Test  //����@Testע��ķ����Ϳ���ִ����
	//Ҫ��������������ǹ��е��޲����޷���ֵ�ķ���
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
	 *  indexOf�ľ�����;������ַ����İ�����ϵ
	 */
	//@Test
	public void test2IndexOf(){
		String str = "photo_2014_01.jpg";
		//����ļ����Ƿ����2014����
		//str.indexOf("2014")>=0 �����Ƿ����һ���ַ���
		if(str.indexOf("2014")>= 0){
			System.out.println("����2014����");
		}
	}
	
	/**
	 * ��ȡ�����ַ�����substring
	 */
	//@Test
	public void testSubstring(){
		String email = "liucangsong@gmail.com";
		//1)��ȡ�û���
		String name = email.substring(0,11);
		System.out.println(name);
		//2)��ȡ������
		String host = email.substring(12);
		System.out.println(host);
		//ͨ������
		email ="liucs@tarena.com.cn";
		    //�Ȼ�ȡ@�ĵ�ַ
		int index = email.indexOf('@');
		name = email.substring(0,index);//ǰ�߰������߲�����
		//��ȡ������
		host = email.substring(index+1);
		System.out.println(host);
	}
	
	/**
	 * trim ���ܣ�
	 * 1.ȥ���ַ������˵Ŀհף�
	 *   �հ��Ǳ���С�� 13�Ŀ����ַ���  �Ϳո�
	 *   ������  �ո�  \t   \n    \r     \0
	 *       ˮƽ�Ʊ�          ����             �س�              ���ַ�
	 *  2.trim��������ֵ��
	 *     A.������ص�������ԭ�ַ�����һ��
	 *       �򷵻ص������ַ�������ԭ���󲻱�
	 *     B.����������ݲ���ı䣬��ֱ�ӷ���ԭ
	 *        �ַ��������������ܺ�
	 *  3.��;���������ڴ����û���������Ŀհ�
	 *        
	 *   
	 */       
	//@Test
	public void testTrim(){
		//��ӡ�κ��ַ��ı���
		char c = ' ';
		System.out.println((int) c);
		//�û���������ݰ����հ�
		String name = "Tom \t \n \r \0";
		//trim()���ص����¶���
		String login = name.trim();
		System.out.println(login);//"Tom"
		//login��name���õ��ǲ�ͬ�Ķ���
		System.out.println(login == name);
		
		 name = "Tom";
		 //����ı��ʱ�򷵻�ԭ�������ܺ�
		 login = name.trim();
		 //login��name���õ�����ͬ�Ķ���
		 System.out.println(login == name);
		
	}
	
	//trim������������������
	//@Test
	public void testTrim2(){
		String name = "  Tom   ";
		name.trim();  //�����������¶�������
		//ԭ���󲻱�
		System.out.println(name);//   Tom
		//������д��
		name = name.trim();//����name�����ˡ��¶���
		System.out.println(name);//"Tom"
		
		//name����trim֮���������¶��󣬵�û�зŽ�������
		//��s = "Tom"��һ�����ڲ���֮��ͷŽ��������ˣ��������߲���ͬһ����
		String s = "Tom";
		System.out.println(s == name);//***false
		
		//Tom��trim֮���Ƿ���ԭ����Tom������Ϊtrue
		String ss = "Tom".trim();
		System.out.println(s == ss);//true
		
	}
	
	
	//��ӡһ���ַ�����ÿ���ַ��ı���
	//@Test
	public void printCharCode(){
		String str = "������";
		
		for(int i = 0; i < str.length();i++){
			char c = str.charAt(i);
			System.out.println(c);
		}
	}
	
	//�����ַ����е�Ӣ���ַ�
	//�����Ҫʵ���ַ���ÿ���ַ��ı����㷨
	//��������length���� charAt() + for ѭ��ʵ��
	
	@Test
	public void testCharAt(){
		String s= "�Ұ�java";
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if((c>='a'&&c<='z')||(c>='A'&&c<='Z'))
			{
				System.out.println(c);
			}
		}
	}
	
	//����û�������ַ������ĸ��ַ����Ŀ�ͷһ��
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
	
	//���һ���ļ��Ƿ���pngͼƬ
	@Test
	public void testEndsWith(){
		String filename = "luanzhikun.png  ";
		//ȥͷβ
		filename = filename.trim();
		if(filename.endsWith(".png")){
			System.out.println("��pngͼƬ");
			
		}
		
	}
	
	/**
	 * ��Сдת������
	 * 1.���ַ����е�Ӣ��ת��ΪСд����д
	 * 2.����ֵ
	 *   A.�����Ҫת��Ϊ��д��Сд�����¶���
	 *   B.�������ı䣬�ͷ���ԭ����
	 */
	//@Test
	public void testCase(){
		
		//ת��֮����Ҫ��ֵ���ַ���str���ܸı�str�����ã�����str����ԭ�����Ǹ�����
		String str = "��ϲ��Java";
		str.toUpperCase();
		System.out.println(str);
		str = str.toUpperCase();
		System.out.println(str);
		
		str = str.toLowerCase();
		System.out.println(str);
		
		String s = "����java";
		String ss ="����java".toLowerCase();
		System.out.println(s == ss);
		
		//���һ���ļ��Ƿ�Ϊpng�ļ�
		//1.���ļ���trim
		//2.ת��Ϊȫ��Сд
		//3�����ж��Ƿ�Ϊ.png��β
		String filename = "screen.png";
		filename = filename.trim().toLowerCase();
		if(filename.endsWith(".png")){
			System.out.println("��png�ļ�");
		}
		
		//����ԭ�ļ�������һ�����ļ���
		//�ļ���Ҫ��ԭ�ļ���_ʱ�������.png
		
		//�ҳ�.��λ��,��ֳ�������
		int index = filename.lastIndexOf(".");
		String name = filename.substring(0,index);
		//ext �ⲿ��
		String ext = filename.substring(index);//��׺��
		long time = System.currentTimeMillis();
		System.out.println(name + "_" + time + ext);
		
		
		
	}
	
	/**
	 * valueOf() ����
	 * 1.��һ����̬����
	 * 2.��һϵ�����ص�valueOf����
	 * 3.����������ת��Ϊ�ַ�������
	 *   �������ǽ��ڴ��е�����ת��ΪString����
	 *   ������������˿���
	 * 4.�κ����ݰ����ַ�������ʱ��׶��Զ�����
	 *   ���valueOf����ʵ�����ݵ�ת��
	 *   int a = 0xff;//1111 1111
	 *   valueOf ��a�Ķ�����ת��Ϊ�ַ�����255��
	 *   String s = String.valueOf(a)
	 *   println(s)//255
	 *   println(a)//255 �ײ�Ҳ�Զ�����valueOf
	 * 5  ������Ҫ�ֹ�ת��  ���ݵ��ַ���ʱ��
	 *   �Ϳ��Ե����������ʵ����������ת��
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
		
		//������Ҫ�ֹ�ת��  ���ݵ��ַ���ʱ��
		//�Ϳ��Ե����������ʵ����������ת��
		boolean b = true;
		int n = 100;
		String str = String.valueOf(n) + String.valueOf(b);
		System.out.println(str);
	}
	
	
	@Test
     public void testValueOf2(){
		
		
	}
}
