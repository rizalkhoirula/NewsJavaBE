package czimt.edu.cn.rka.demo;

import java.util.ArrayList;
import java.util.List;


public class ArrayListManage {
	//List adalah interface
	
	public void manage(){
	List list = new ArrayList(); 
	Student jack = new Student();
	jack.setName("Jake");
	Student make = new Student();
	make.setName("Make");
	Student Mary = new Student();
	Mary.setName("Marry");
	Student Sunhualin = new Student();
	Sunhualin.setName("Marry");
	
	list.add(jack);
	list.add(make);
	list.add(Mary);
	list.add(Sunhualin);
	for(int i = 0; i<list.size();i++)
	{
		Student stu = new Student();
		stu = (Student) list.get(i);
		System.out.println(stu.getName());
	}
	
	}
	
	

}
