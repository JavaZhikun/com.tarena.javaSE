package day05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestSort
{
	public static void main(String[] args)
	{
		List<Emp> emps = new ArrayList<Emp>();
		Emp emp1 = new Emp("Terry",25,'m',6000);
		Emp emp2 = new Emp("Allen",21,'f',4000);
		Emp emp3 = new Emp("Smith",23,'m',3000);
		
		emps.add(emp1);
		emps.add(emp2);
		emps.add(emp3);
		
		Collections.sort(emps,new Comparator<Emp>(){
			 public int compare(Emp e1,Emp e2){
				 return e1.salary - e2.salary;
			 }
		 });
		
		System.out.println(emps);
	}

}

class Emp{
	String name;
	int age;
	char gender;
	int salary;
	
	public Emp(String name,int age,char gender,int salary){
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
	}
	public String toString(){
		return "[" +name + "," + age +"," +gender +"," + salary +"]";
	}
}