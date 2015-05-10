package day02;

import org.junit.Test;

public class TestCase
{
	/**
	 * ����StringBuilder ��API
	 */
	//@Test
	public void testStringBuilder(){
		//������StringBuilder���󣬿հ׶���
		//StringBuilder �ڲ���������Ըı�
		//�հ׶�����Ը�������
		
		StringBuilder buf = new StringBuilder();
		//append�����޸���buf�����ݣ�Ϊ��׷��������"��ٳ"
		buf.append("��ٳ");
		//�����ʱ��˵��buf���õĶ�������Ϊ ��ٳ
		System.out.println(buf);
		//ȫ�����StringBuffer ��API
		//append ׷��
		//insert ����    delete ɾ��   replace�滻
		buf.append("��").append("�Ϲ���").append("�˳�").insert(6, "����")
		.delete(2, 3).replace(7,9,"��XX");
		System.out.println(buf);
	}
	
	
	/**
	 * Java �Ķ�̬�ַ������Ӿ���ʹ��StringBuilderʵ�ֵ�
	 */
	
	//@Test
	public void testStringConcat(){
		String s = "A";
		//�ַ������Ӿ���ʹ��StringBuilder ʵ�ֵ�
		String s1 = new StringBuilder(s).append("De").append(5).toString();
		System.out.println(s1);//ADe5
		//������һ��StringBuilder����
		
		String s2 = "A";
		s2 = s2 + 'A';
		//new StringBuilder(s2).append('A').toString()
		s2 = s2 + 'A';
		System.out.println(s2);
		//new StringBuilder(s2).append('A').toString()
		//***���ϴ���ÿ�ж��ᴴ��StringBuilder����
		//�Բ���
		//�����������滻
		StringBuilder buf = new StringBuilder("A");
		buf.append("A");
		buf.append("A");
		s2 = buf.toString();
		System.out.println(s2);
	}
	
	/**
	 * ����String����������
	 */
	//@Test
	public void test1(){
		long start = System.nanoTime();//***ϵͳ������ʱ��
		//�����ַ���
		String s = "";//���ַ���
		for(int i = 0; i < 10000; i++){
			s = s + "A";//����StringBuilder
		}
		long end = System.nanoTime();
		System.out.println("test1:" + (end - start));//test1:648043637
		
	}
	
	/**
	 * ����StringBuilder����������
	 * 
	 */
	//@Test
	public void test2(){
		long start = System.nanoTime();
		//ʹ��StringBuilder����10000��A
		//��ѭ���ڼ�ʹ��1��StringBuilder����
		StringBuilder buf = new StringBuilder();
		for(int i = 0; i < 10000; i++){
			buf.append("A");
		}
		
		long end = System.nanoTime();
		System.out.println("test2:" + (end - start)); //	test2:1406876
	
	}
	
	/**
	 * ʹ��String���API����������ʽ
	 * String �ṩ�˷���
	 *    match ����ַ�����������ʽ��ƥ���ϵ
	 */
	
	//@Test
	public void testReg(){
		String r1 = "[a-z]";
		//r1�Ĺ������� �� a-zĳһ���ַ�
		String s = "a";
		// ����matches�������s��ֵ�Ƿ����r1����
		System.out.println(s.matches(r1)); //true
		System.out.println("T".matches(r1));//true
		
		String r2 = "\\d.{0,}\\html";
		System.out.println("r2:" + r2);// \d.{0.}\.html
		String file = "518_index.html";
		System.out.println(file.matches(r2));//true
		
		
		String r3 = "��\\s* [ȥ��]";
		String str = "��   ȥ";
		System.out.println(str.matches(r3));//true
		
		String str2 = "��ȥ����";
		System.out.println(str2.matches(r3));
	
	
	
	
	
	
	}
	
	//@Test
	public void testReg2(){
		//matches ��������Թ��ߵĲ��
		//matches ����ȫ�����ݵ�ƥ�䣺str����ȫ�����Ϲ��򷵻�true
		//Reg���Թ��ߣ����ַ����м������Ϲ����λ��
		//Ip�Ĺ������
		String r4 = "(\\d{1,3}\\.){3}\\d{1,3}";
		String ip = "192.168.1.10";
		System.out.println(ip.matches(r4));//true
		
		
		//ƥ��һ���ļ��Ĺ���:
		//5index.html  5index.HTML
		//\d.*\.(html|HTML)
		String r5 = "\\d.*\\.(html|HTML)";
		String htmlFile = "518index.Html";
		System.out.println(htmlFile.toLowerCase().matches(r5));//true
		
		String r6 = "\\w{8,10}";  //��ͷ��β����8-10�������ַ�
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
		
		//���� ^�����ַ�����ʼ
		//$�����ַ�������
		//����д���д�ͷ��β����Ĺ涨
	}
	
	
	//����split����
	/**
	 * ��������Ǿ�����ַ���ַ���
	 * ���ַ��������зǳ�����
	 * 
	 */
	
	//@Test
	public void testSplit(){
		String str = "tom, 2, 119,tom@tarena.com.cn";
		//split ���ַ���str����λ�� ,\s*   \s��ʾ�հ��ַ�  [\t\n\x0B\f\r]
		//X*��ʾ0������������X
		String[] data = str.split(",\\s*");
		for(String s : data){
			System.out.println(s);
		}
	}
	
	
	//@Test
	public void testIp(){
		//ip��ַ���ϸ�����㷨
		//ip: 192.168.1.199
		//  1)�ȼ��������� matches
		//  2)�� . ����
		//  3����ÿ������ת��Ϊint
		//     int n =Integer.parseInt("199");
		//  4)���ÿ�������Ƿ�  0 -255
		
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
	 * replaceAll ����
	 */
	//@Test
	public void testReplaceAll(){
		//ʵ�ֹؼ����滻���ܣ�
		 //�� ����ȥ�� ���Ҳݡ� �滻ΪXX
		String str = "��һ����ȥ�����Ǽ�," + "��˵���Ҳ�";
		//���ؽ�������ַ���
		str = str.replaceAll("��[ȥ��]", "XX");
		System.out.println(str);
	}
	
	
	//���֤�����У��
	@Test
	public void testIdCard(){
		//
		String id ="421127199002202546";
		String regex = "^\\d{17}"+"(\\d|X){1}$";
		
		
//		11:"����",12:"���",13:"�ӱ�",14:"ɽ��",15:"���ɹ�",21:"����",22:"����",23:"������",31:"�Ϻ�",32:"����",33:"�㽭",34:" 
//			����",35:"����",36:"����",37:"ɽ��",41:"����",42:"����",43:"����",44:"�㶫",45:"����",46:"����",50:"����",51:"�Ĵ�",
//		52:"����",53:"����",54:"����",61:"����",62:"����",63:"�ຣ",64:"����",65:"�½�",71:"̨��",81:"���",82:"����",91:"����"
		boolean isID = true;
		
		if(id.matches(regex)){
			int province = Integer.parseInt(id.substring(0,2));
			//�ж�ʡ���Ƿ���ȷ
			int[] all = {11,12,13,14,15,21,22,23,31,32,33,34,35,36,37,41,42,43,44,45,46,
					     50,51,52,53,54,61,62,63,64,65,71,81,82};
			boolean isProvince = false;
			for(int i = 0 ; i <all.length; i++){
				if(province == all[i]){
					isProvince = true;
				}
			}
			//ʡ�ݲ���ȷ������ID��
			if(isProvince == false){
				isID = false;
			}
			int year = Integer.parseInt(id.substring(6,10));
			int month = Integer.parseInt(id.substring(10,12));
			int day = Integer.parseInt(id.substring(12,14));
			
			//�����2016����ǰ
			if(year>2016)
				 isID =false;
			//�·���1��12֮��
			if(month < 1 || month > 12)
				isID = false;
			
			
			switch(month){
			//������31��
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:  if(day < 0 || day >31 )
						 isID = false;break;
			//С����30��
			case 4:
			case 6:
			case 9:
			case 11:  if(day < 0 || day >30)
				         isID = false; break;
		     //2��������
			case 2:  if(year %4==0 && year%100!=0 ||year%400==0){//������
							if(day < 0 || day>29)
								isID = false; break;
						}
					
					//������
					if(day < 0 || day > 28)
						isID = false; break;
			}
			
			if(isID){
				System.out.println("�����֤���룡");
			}else{
				System.out.println("�������֤���룡");
			}
			
			
		}
	}
	
	

}
