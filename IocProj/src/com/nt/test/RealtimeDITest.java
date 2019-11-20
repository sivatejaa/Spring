package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.controller.MainController;
import com.nt.vo.StudentVO;

public class RealtimeDITest {

	public static void main(String[] args) {
		BeanFactory factory=null;
		MainController controller=null;
		Scanner sc=null;
		String sname=null,sadd=null,m1=null,m2=null,m3=null;
		StudentVO vo=null;
		//create IOC containe
		factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
        //get Controller class obj
		controller=factory.getBean("controller",MainController.class);
		//read inputs
		sc=new Scanner(System.in);
		 System.out.println("Enter student name::");
		 sname=sc.next();
		 System.out.println("Enter student addrs::");
		 sadd=sc.next();
		 System.out.println("Enter student Marks1::");
		 m1=sc.next();
		 System.out.println("Enter student Marks2::");
		 m2=sc.next();
		 System.out.println("Enter student Marks3::");
		 m3=sc.next();
		 
		 //prepare VO class obj
		 vo=new StudentVO();
		 vo.setSname(sname); vo.setSadd(sadd);
		 vo.setM1(m1); vo.setM2(m2); vo.setM3(m3);
		 
		 //invoke method
		 try {
			 System.out.println(controller.processStudent(vo));
		 }
		 catch(Exception e) {
			 System.out.println("Internal Problem");
			 e.printStackTrace();
		 }
	}
}
