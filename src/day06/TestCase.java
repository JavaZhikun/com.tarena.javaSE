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
		//new Random(1) 随机数的种子（起始位置）
		//固定了，产生的随机序列是固定的
	
		Random r = new Random(1);
		Random r1 = new Random(System.currentTimeMillis());
		// nextInt产生 0 -100 之间的随机数
		int i = r.nextInt(100);
		System.out.println(i);
		i = r.nextInt(100);
		System.out.println(i);
		i = r.nextInt(100);
		System.out.println(i);
		
	}
	
	/**
	 * 使用Collections.sort（）对线性表进行排序
	 */
	//@Test
	public void testSort(){
		List<Integer> list = new ArrayList<Integer>();
		Random r = new Random(1);
		for(int i = 0; i < 10; i++){
			list.add(r.nextInt(100));
		}
		System.out.println(list);
		//调用Collections.sort（）方法
		Collections.sort(list);
		System.out.println(list);
		
	}
	
	/**
	 * sort方法可以对字符串进行排序
	 */
	@Test
	public void testSort2(){
		List<String> names = new ArrayList<String>();
		//添加一组数据到集合中
		Collections.addAll(names, "Tom","Jerry","Andy");
		System.out.println(names);
		Collections.sort(names);
		System.out.println(names);
	}
	
	/**
	 * "比较" 与"排序"的关系
	 * "比较"：对两个数据进行比较，结果：大，小，相等
	 * “排序”：将一组数据，根据每两个元素的”比较“
	 *       结果按照从小到大的按次序排列
	 *  结论： 根据”比较“ 结果进行”排序“
	 *  
	 *  推广：不能比较就不能排序
	 *      字符串能够比较大小，才能进行排序
	 *      字符串如何比较？
	 *      字符串上有一个方法compareTo 用于比较字符串大小
	 *      
	 *      sort排序方法就是调用compareTo方法比较每两个字符串的大小，
	 *      根据比较结果进行排序
	 *      
	 * comparable接口中声明了compareTo方法，
	 * String实现Comparable的compareTo   
	 * 
	 *  Java中有些API实现了Comparable接口
	 *  的compareTo，称为可以默认比较大小的类型
	 *  sort只能对可以比较大小的类型进行排序
	 *  如：   String Date Integer  Double  Float 等
	 *  如上现象称为： 自然排序
	 *  
	 *  实现了Comparable接口的数据，可以进行自然排序
	 */
	
	//@Test
	public void testCompareTo(){
		String s1 ="Tom";
		String s2 = "Tom";
		String s3 = "Jerry";
		String s4 = "Andy";
		//s1.compareTo(s2)比较两个字符串s1 s2
		//如果返回值 0 就是s1 == s2
		//如果返回  正整数   s1 > s2
		//如果返回  负整数  s1 < s2
		
		int var = s1.compareTo(s2);
		System.out.println(var);//0
		var = s1.compareTo(s3);
		System.out.println(var);//正数
		var = s4.compareTo(s1);
		System.out.println(var);//负数
				
	}
	
	/**
	 * 利用Comparator 进行自定义排序
	 * Comprator: 比较器
	 * Comparator 是实现两个元素大小比较操作的
	 * Java提供了Collections.sort(list,比较器)
	 * 重载的排序算法，在排序的时候利用比较器比较list集合值每两个元素的大小
	 * 根据比较结果按照从小到大的顺序排序
	 * 
	 * 进行自定义排序
	 * 1.准备排序数据： 类Person（name， age）代表人
	 * 2.将数据存在list中
	 * 3.准备比较器，实现Comparator接口
	 *    p1.age == p2.age  返回0
	 *    p1.age大于p2.age返回  正数
	 *    p1.age 小于 p2.age 返回负数
	 * 4.调用排序方法
	 *    Collections.sort（list，比较器对象）
	 * 5.得到排序结果
	 *  
	 *  总结：
	 *    工作中大多使用Comparator接口
	 *    工作中很少使用Comparable接口
	 *
	 */

	//@Test
	public void testComparator(){
		//准备排序数据
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("Tom",2));
		list.add(new Person("Jerry",8));
		list.add(new Person("Nemo",5));
		list.add(new Person("Andy", 7));
		System.out.println(list);
		
		//***准备比较器， 按照年龄大小比较两个对象的大小
		Comparator<Person> byAge = new Comparator<Person>(){
			//比较两个对象 o1,o2
			//返回值  是 0  表示o1  o2 相等
			//返回值 是>0 表示 o1  大于 o2
			//返回值是 < 0 表示 o1 小于  o2
			
			public int compare(Person o1, Person o2){
				return o1.age - o2.age;  //从小到大排列，升序
				//return (o1.age - o2.age);//降序
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
	 * 测试Queue队列
	 * 使用队列的好处：可以提高开发效率
	 * 
	 * 何时使用队列：
	 * 在软件中缓存数据的时候，数据处理需要遵守先进先出的原则进行处理的时候
	 * 
	 * 视频播放缓存现象是最典型的案例！
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
	 * 利用栈实现：
	 * 将输入的文本倒序输出
	 * 1. 从控制台读取用户输入的文本
	 * 2. 将文本中每个字符存储到栈中
	 * 3. 从栈中弹出每个字符（先进后出）
	 * 弹出序列就是倒序了
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
		
		System.out.println("输出栈中数据");
		while(stack.size() > 0){
			str = stack.pop();
			System.out.println(str);
		}
	}
	
	/**
	 * 创建一个Map集合
	 */
	
	//@Test
	public void testMap(){
		//创建Map集合
		//key 的类型  Value的类型
		Map<Integer, String> map = new HashMap<Integer,String>();
		System.out.println(map);
		//将key， value对添加到map集合中
		map.put(7,"Tom");
		map.put(10, "Jerry");
		System.out.println(map);
		//替换10 Jerry 为  10 Nemo
		map.put(10, "Nemo");
		System.out.println(map);
		
		//查找map中的数据，根据key查找value
		String name = map.get(7);
		System.out.println(name);
	}
	
	/**
	 * 顺序生成100000个不同的字符串
	 * 顺序查找一个字符串的位置
	 * ”aabc“ "dec" "ffk" ... "kkad"
	 *    0     1     2       99999
	 *  查找kkad位置返回值是99999
	 *  indexOf（”kkad“）
	 *  
	 *  将100000个字符串和生成的位置存储到散列表
	 *  利用散列表查找一个字符串 的位置
	 *  
	 *  key   value
	 *  aabc    0
	 *  def     1
	 *  ffk     2
	 *  ....
	 *  kkad   99999
	 *  利用散列表查找kkad的生成顺序
	 *  get（”kkad“） ->99999
	 */
	
	//@Test
	public void testMap2(){
		//UUID 就是封装产生不同字符串算法
		String key = UUID.randomUUID().toString();
		System.out.println(key);
		//准备数据100000个数据分别存储在list  map
		List<String> list = new ArrayList<String>();
		Map<String,Integer> map = new HashMap<String,Integer>(150000);//150000是初始容量
		
		for(int i = 0; i < 999999; i++){
			String s = UUID.randomUUID().toString();
			list.add(s);
			map.put(s, i);
		}
		list.add(key);
		map.put(key, 999999);
		//比较查询性能
		long t1 = System.nanoTime();
		int index1 =list.indexOf(key);
		long t2 = System.nanoTime();
		int index2 = map.get(key);
		long t3 = System.nanoTime();
		System.out.println((t2-t1) +"," +(t3-t2));//107227332,81335  近万倍
		System.out.println(index1 + "," + index2);
		//map 无论存储多少数据，查询性能始终如一
	}
	
	/**
	 * 散列表HashMap的工作原理
	 * 散列表中的数据 Key ——>value
	 * 
	 * 1.Java在基类Object上定义了一个方法
	 *   hashCode() 用于支持散列表算法！
	 *   hashCode（） 方法的返回值是一个整数，这个整数的规则是两个对象
	 *   相同的时候，他的hashCode（）返回值一定一样，两个对象不同的
	 *   时候，这个值尽量不同
	 * 2.散列表内部有一个数组用于存储数据，在添加数据时候，根据key对象的
	 *   hashCode值计算出数组的下标位置存储Value，重复位置重复时候
	 *   存储到散列桶中
	 * 3.查找时候根据查找的key的hashCode计算出数组中存储数据位置，再根据
	 *   key的equals方法比较key，最后查找到value
	 * 4.散列表要保持加载因子（充满率）在<75%保证查找性能优秀，在添加数据时候，
	 *   如果数据充满率接近75%时候，会自动扩容（重新散列）
	 * 5.为了提高添加数据的性能，如果事先可以预知添加数据的数量，可以事先设置数组的
	 *   容量大小，避免重新散列扩容
	 *   
	 *   
	 * 为了保证散列表正常查找，保证
	 * 1. key的hashCode（）返回结果要稳定，永远不变！
	 * 2. key的hashCode（）要与equals（）一起重写
	 *    保证在两个对象equals比较是ture时候
	 *    hashCode返回值是一致的
	 *    两个对象的equals比较是false时候，
	 *    hashCode返回值尽可能不同！
	 *  如果违反上述规定，散列出现逻辑问题
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
		//字符串的hashCode
		//相同的字符串equals返回true时候
		// hashCode一样
		// 不同字符串equals返回false时候
		//  hashCode 尽可能不同
		//字符串同时重写了equals和hashCode
	}
	
	/**
	 * 如果key的hashCode不稳定，在软件的不同阶段或变化，就会造成散列表的工作问题
	 * 如果key的hashCode变化会造成数据重复添加
	 * 
	 * *****在工作中不允许这么做******
	 */
	//@Test
	public void testMap3(){
		Map<Foo, Integer> map = new HashMap<Foo, Integer>();
		Foo foo = new Foo();
		foo.n = 6;
		map.put(foo,5);
		System.out.println(map);
		foo.n = 8;//散列值不稳定，造成重复添加！
		map.put(foo, 7);
		System.out.println(map);
		foo.n = 9;
		Integer a = map.get(foo);
		System.out.println(a);
	}
	
	class Foo{
		int n;
		//重写了HashCode
		public int hashCode(){
			return n;
		}
	}
	
	/**
	 * 一个Key类型没有一起重写hashCode和equals也会造成hashCode工作不正常
	 * 反之，如果一起合理重写equals hashCode
	 * 散列表工作就正常了
	 * 
	 * ************建议凡是重写了equals方法时候
	 * 一定一起重写hashCode 保证任何时候，任何人使用
	 * 散列表都是正常的
	 * 
	 */
	
	@Test
	public void testMap4(){
		Map<Goo, Integer> map = new HashMap<Goo,Integer>();
		Goo goo= new Goo(5);
		map.put(goo, 100);
		//使用同样对象无法查找数据
		//没有成对重写equals和hashCode
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
