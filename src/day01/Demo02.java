package day01;


/**
 * �ַ���������
 * 1. Java �������þ�̬�ַ��� �������ڴ�ʹ�ã��������
 * 2. ��Щ�ַ����������ã�
 *    A,�ַ������������磺��ABC��
 *    B.�ַ���������
 *       static final String S ="ABC"
 *    C.�������ͳ�����̬���ӵĽ����
 *       ��AB�� + "c"   "AB" + ��c��  S + "C"
 * 3.������õģ�java�������ڼ佫һ���ľ�̬�ַ�������ͬһ������ʵ������
 * 4.��Щ��������ã�
 *     A.ʹ��new �������ַ���
 *     B.��̬�ַ��������������ӽ��
 *  5����μ���Ƿ��������ã�
 *     ʹ��==����Ƚ����ö����ֵ�Ƿ�Ϊͬһ����ֵַ���������true����˵����
 *     ͬһ������ĵ�ַ��Ҳ���Ǳ������á���
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
		String s4 = SS +"!"; //������ֱ�ӵó����
		
		System.out.println(s4 ==s1);
		String s5 = SS;
		String s6 = s5 + "!";  //s6�Ǳ������ӵĽ��
		System.out.println(s6 == s1);//false
	}
	
	
	
	

}
