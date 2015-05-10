package day06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.UUID;

import org.junit.Test;

public class TestCase
{
	//@Test
	public void testRandom(){
		//new Random(1) ����������ӣ���ʼλ�ã�
		//�̶��ˣ���������������ǹ̶���
	
		Random r = new Random(1);
		Random r1 = new Random(System.currentTimeMillis());
		// nextInt���� 0 -100 ֮��������
		int i = r.nextInt(100);
		System.out.println(i);
		i = r.nextInt(100);
		System.out.println(i);
		i = r.nextInt(100);
		System.out.println(i);
		
	}
	
	/**
	 * ʹ��Collections.sort���������Ա��������
	 */
	//@Test
	public void testSort(){
		List<Integer> list = new ArrayList<Integer>();
		Random r = new Random(1);
		for(int i = 0; i < 10; i++){
			list.add(r.nextInt(100));
		}
		System.out.println(list);
		//����Collections.sort��������
		Collections.sort(list);
		System.out.println(list);
		
	}
	
	/**
	 * sort�������Զ��ַ�����������
	 */
	@Test
	public void testSort2(){
		List<String> names = new ArrayList<String>();
		//���һ�����ݵ�������
		Collections.addAll(names, "Tom","Jerry","Andy");
		System.out.println(names);
		Collections.sort(names);
		System.out.println(names);
	}
	
	/**
	 * "�Ƚ�" ��"����"�Ĺ�ϵ
	 * "�Ƚ�"�����������ݽ��бȽϣ��������С�����
	 * �����򡱣���һ�����ݣ�����ÿ����Ԫ�صġ��Ƚϡ�
	 *       ������մ�С����İ���������
	 *  ���ۣ� ���ݡ��Ƚϡ� ������С�����
	 *  
	 *  �ƹ㣺���ܱȽϾͲ�������
	 *      �ַ����ܹ��Ƚϴ�С�����ܽ�������
	 *      �ַ�����αȽϣ�
	 *      �ַ�������һ������compareTo ���ڱȽ��ַ�����С
	 *      
	 *      sort���򷽷����ǵ���compareTo�����Ƚ�ÿ�����ַ����Ĵ�С��
	 *      ���ݱȽϽ����������
	 *      
	 * comparable�ӿ���������compareTo������
	 * Stringʵ��Comparable��compareTo   
	 * 
	 *  Java����ЩAPIʵ����Comparable�ӿ�
	 *  ��compareTo����Ϊ����Ĭ�ϱȽϴ�С������
	 *  sortֻ�ܶԿ��ԱȽϴ�С�����ͽ�������
	 *  �磺   String Date Integer  Double  Float ��
	 *  ���������Ϊ�� ��Ȼ����
	 *  
	 *  ʵ����Comparable�ӿڵ����ݣ����Խ�����Ȼ����
	 */
	
	//@Test
	public void testCompareTo(){
		String s1 ="Tom";
		String s2 = "Tom";
		String s3 = "Jerry";
		String s4 = "Andy";
		//s1.compareTo(s2)�Ƚ������ַ���s1 s2
		//�������ֵ 0 ����s1 == s2
		//�������  ������   s1 > s2
		//�������  ������  s1 < s2
		
		int var = s1.compareTo(s2);
		System.out.println(var);//0
		var = s1.compareTo(s3);
		System.out.println(var);//����
		var = s4.compareTo(s1);
		System.out.println(var);//����
				
	}
	
	/**
	 * ����Comparator �����Զ�������
	 * Comprator: �Ƚ���
	 * Comparator ��ʵ������Ԫ�ش�С�Ƚϲ�����
	 * Java�ṩ��Collections.sort(list,�Ƚ���)
	 * ���ص������㷨���������ʱ�����ñȽ����Ƚ�list����ֵÿ����Ԫ�صĴ�С
	 * ���ݱȽϽ�����մ�С�����˳������
	 * 
	 * �����Զ�������
	 * 1.׼���������ݣ� ��Person��name�� age��������
	 * 2.�����ݴ���list��
	 * 3.׼���Ƚ�����ʵ��Comparator�ӿ�
	 *    p1.age == p2.age  ����0
	 *    p1.age����p2.age����  ����
	 *    p1.age С�� p2.age ���ظ���
	 * 4.�������򷽷�
	 *    Collections.sort��list���Ƚ�������
	 * 5.�õ�������
	 *  
	 *  �ܽ᣺
	 *    �����д��ʹ��Comparator�ӿ�
	 *    �����к���ʹ��Comparable�ӿ�
	 *
	 */

	//@Test
	public void testComparator(){
		//׼����������
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("Tom",2));
		list.add(new Person("Jerry",8));
		list.add(new Person("Nemo",5));
		list.add(new Person("Andy", 7));
		System.out.println(list);
		
		//***׼���Ƚ����� ���������С�Ƚ���������Ĵ�С
		Comparator<Person> byAge = new Comparator<Person>(){
			//�Ƚ��������� o1,o2
			//����ֵ  �� 0  ��ʾo1  o2 ���
			//����ֵ ��>0 ��ʾ o1  ���� o2
			//����ֵ�� < 0 ��ʾ o1 С��  o2
			
			public int compare(Person o1, Person o2){
				return o1.age - o2.age;  //��С�������У�����
				//return (o1.age - o2.age);//����
			}
		};
		Collections.sort(list, byAge);
		System.out.println(list);
	}
	
	class Person{
		String name ;
		int age;
		public Person(String name , int age){
			this.name  = name;
			this.age = age;
		}
		
		public String toString(){
			return name + "," + age;
		}
	}
	
	/**
	 * ����Queue����
	 * ʹ�ö��еĺô���������߿���Ч��
	 * 
	 * ��ʱʹ�ö��У�
	 * ������л������ݵ�ʱ�����ݴ�����Ҫ�����Ƚ��ȳ���ԭ����д����ʱ��
	 * 
	 * ��Ƶ���Ż�������������͵İ�����
	 */
	
	//@Test
	public void testQueue(){
		Queue<String> queue = new LinkedList<String>();
		queue.offer("A");
		queue.offer("B");
		queue.offer("C");
		String s = queue.peek();
		while(queue.size() > 0){
			String str = queue.poll();
			System.out.println(str);
		}
	}
	
	/**
	 * ����ջʵ�֣�
	 * ��������ı��������
	 * 1. �ӿ���̨��ȡ�û�������ı�
	 * 2. ���ı���ÿ���ַ��洢��ջ��
	 * 3. ��ջ�е���ÿ���ַ����Ƚ������
	 * �������о��ǵ�����
	 */
	//@Test
	public void testReverse(){
		Stack<String> stack = new Stack<String>();
		Scanner input = new Scanner(System.in);
		String str;
		while(true){
		 str = input.next();
		 if(str =="A")
			 break;
		 stack.push(str);
		}
		
		System.out.println("���ջ������");
		while(stack.size() > 0){
			str = stack.pop();
			System.out.println(str);
		}
	}
	
	/**
	 * ����һ��Map����
	 */
	
	//@Test
	public void testMap(){
		//����Map����
		//key ������  Value������
		Map<Integer, String> map = new HashMap<Integer,String>();
		System.out.println(map);
		//��key�� value����ӵ�map������
		map.put(7,"Tom");
		map.put(10, "Jerry");
		System.out.println(map);
		//�滻10 Jerry Ϊ  10 Nemo
		map.put(10, "Nemo");
		System.out.println(map);
		
		//����map�е����ݣ�����key����value
		String name = map.get(7);
		System.out.println(name);
	}
	
	/**
	 * ˳������100000����ͬ���ַ���
	 * ˳�����һ���ַ�����λ��
	 * ��aabc�� "dec" "ffk" ... "kkad"
	 *    0     1     2       99999
	 *  ����kkadλ�÷���ֵ��99999
	 *  indexOf����kkad����
	 *  
	 *  ��100000���ַ��������ɵ�λ�ô洢��ɢ�б�
	 *  ����ɢ�б����һ���ַ��� ��λ��
	 *  
	 *  key   value
	 *  aabc    0
	 *  def     1
	 *  ffk     2
	 *  ....
	 *  kkad   99999
	 *  ����ɢ�б����kkad������˳��
	 *  get����kkad���� ->99999
	 */
	
	//@Test
	public void testMap2(){
		//UUID ���Ƿ�װ������ͬ�ַ����㷨
		String key = UUID.randomUUID().toString();
		System.out.println(key);
		//׼������100000�����ݷֱ�洢��list  map
		List<String> list = new ArrayList<String>();
		Map<String,Integer> map = new HashMap<String,Integer>(150000);//150000�ǳ�ʼ����
		
		for(int i = 0; i < 999999; i++){
			String s = UUID.randomUUID().toString();
			list.add(s);
			map.put(s, i);
		}
		list.add(key);
		map.put(key, 999999);
		//�Ƚϲ�ѯ����
		long t1 = System.nanoTime();
		int index1 =list.indexOf(key);
		long t2 = System.nanoTime();
		int index2 = map.get(key);
		long t3 = System.nanoTime();
		System.out.println((t2-t1) +"," +(t3-t2));//107227332,81335  ����
		System.out.println(index1 + "," + index2);
		//map ���۴洢�������ݣ���ѯ����ʼ����һ
	}
	
	/**
	 * ɢ�б�HashMap�Ĺ���ԭ��
	 * ɢ�б��е����� Key ����>value
	 * 
	 * 1.Java�ڻ���Object�϶�����һ������
	 *   hashCode() ����֧��ɢ�б��㷨��
	 *   hashCode���� �����ķ���ֵ��һ����������������Ĺ�������������
	 *   ��ͬ��ʱ������hashCode��������ֵһ��һ������������ͬ��
	 *   ʱ�����ֵ������ͬ
	 * 2.ɢ�б��ڲ���һ���������ڴ洢���ݣ����������ʱ�򣬸���key�����
	 *   hashCodeֵ�����������±�λ�ô洢Value���ظ�λ���ظ�ʱ��
	 *   �洢��ɢ��Ͱ��
	 * 3.����ʱ����ݲ��ҵ�key��hashCode����������д洢����λ�ã��ٸ���
	 *   key��equals�����Ƚ�key�������ҵ�value
	 * 4.ɢ�б�Ҫ���ּ������ӣ������ʣ���<75%��֤�����������㣬���������ʱ��
	 *   ������ݳ����ʽӽ�75%ʱ�򣬻��Զ����ݣ�����ɢ�У�
	 * 5.Ϊ�����������ݵ����ܣ�������ȿ���Ԥ֪������ݵ������������������������
	 *   ������С����������ɢ������
	 *   
	 *   
	 * Ϊ�˱�֤ɢ�б��������ң���֤
	 * 1. key��hashCode�������ؽ��Ҫ�ȶ�����Զ���䣡
	 * 2. key��hashCode����Ҫ��equals����һ����д
	 *    ��֤����������equals�Ƚ���tureʱ��
	 *    hashCode����ֵ��һ�µ�
	 *    ���������equals�Ƚ���falseʱ��
	 *    hashCode����ֵ�����ܲ�ͬ��
	 *  ���Υ�������涨��ɢ�г����߼�����
	 *   
	 * 
	 */
	
	//@Test
	public void testHashCode(){
		System.out.println("Tom".hashCode());
		System.out.println("Jerry".hashCode());
		System.out.println("Andy".hashCode());
		System.out.println("Numo".hashCode());
		System.out.println("Robin".hashCode());
		String name = new String("Tom");
		System.out.println(name.hashCode());
		//�ַ�����hashCode
		//��ͬ���ַ���equals����trueʱ��
		// hashCodeһ��
		// ��ͬ�ַ���equals����falseʱ��
		//  hashCode �����ܲ�ͬ
		//�ַ���ͬʱ��д��equals��hashCode
	}
	
	/**
	 * ���key��hashCode���ȶ���������Ĳ�ͬ�׶λ�仯���ͻ����ɢ�б�Ĺ�������
	 * ���key��hashCode�仯����������ظ����
	 * 
	 * *****�ڹ����в�������ô��******
	 */
	//@Test
	public void testMap3(){
		Map<Foo, Integer> map = new HashMap<Foo, Integer>();
		Foo foo = new Foo();
		foo.n = 6;
		map.put(foo,5);
		System.out.println(map);
		foo.n = 8;//ɢ��ֵ���ȶ�������ظ���ӣ�
		map.put(foo, 7);
		System.out.println(map);
		foo.n = 9;
		Integer a = map.get(foo);
		System.out.println(a);
	}
	
	class Foo{
		int n;
		//��д��HashCode
		public int hashCode(){
			return n;
		}
	}
	
	/**
	 * һ��Key����û��һ����дhashCode��equalsҲ�����hashCode����������
	 * ��֮�����һ�������дequals hashCode
	 * ɢ�б�����������
	 * 
	 * ************���鷲����д��equals����ʱ��
	 * һ��һ����дhashCode ��֤�κ�ʱ���κ���ʹ��
	 * ɢ�б���������
	 * 
	 */
	
	@Test
	public void testMap4(){
		Map<Goo, Integer> map = new HashMap<Goo,Integer>();
		Goo goo= new Goo(5);
		map.put(goo, 100);
		//ʹ��ͬ�������޷���������
		//û�гɶ���дequals��hashCode
		Goo key = new Goo(5);
		Integer i = map.get(key);
		System.out.println(i);
	}
	
	class Goo{
		private int n;
		public Goo(int n){
			this.n =n;
		}
		
		public boolean equals(Object obj){
			if(obj == null)return false;
			if(obj == this)return true;
			if(obj instanceof Goo){
				Goo other = (Goo) obj;
				return n == other.n;
			}
			return false;
		}
		public int hashCode(){
			return n;
		}
	}
}
