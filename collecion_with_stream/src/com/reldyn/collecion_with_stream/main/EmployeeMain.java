package com.reldyn.collecion_with_stream.main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.reldyn.collecion_with_stream.entity.EmployeeEntity;

public class EmployeeMain {
	public static void main(String[] args) {
		List<EmployeeEntity> l=new ArrayList<>();
		l.add(new EmployeeEntity(1,"jm","Hr"));
		l.add(new EmployeeEntity(2, "lk","Operation" ));
		l.add(new EmployeeEntity(3, "sk", "Hr"));
		l.add(new EmployeeEntity(4, "pt", "Production"));
		l.add(new EmployeeEntity(5, "qk", "Hr"));
		System.out.println(l);
		System.out.println("-------------------------");
		
		//get the deptName in hr
		List<Integer> collect = l.stream().filter(t->t.getDeptName()=="Hr").map(t->t.getId()).collect(Collectors.toList());
		System.out.println(collect);	
		
		//iterate the list using forEach
		l.stream().forEach(t->System.out.println(t));
		
		long count = l.stream().count();
		System.out.println("count:"+count);
				
		
		
		
		
	}

}
