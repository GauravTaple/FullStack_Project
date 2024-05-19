package com.reldyn.collecion_with_stream.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Filter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.reldyn.collecion_with_stream.entity.Employees;

public class EmployeesMain {
	public static void main(String[] args) {
		List<Employees> l = new ArrayList<Employees>();
		l.add(new Employees(111, "Jiya Brein", 32, "Female", "HR"));
		l.add(new Employees(122, "Paul Niksui", 25, "Male", "Sales And Marketing"));
		l.add(new Employees(133, "Martin Theron", 29, "Male", "Infrastructure"));
		l.add(new Employees(144, "Murali Gowda", 28, "Male", "Product Development"));
		l.add(new Employees(155, "Nima Roy", 27, "Female", "HR"));
		l.add(new Employees(166, "Iqbal Hussain", 43, "Male", "Security And Transport"));
		l.add(new Employees(177, "Manu Sharma", 35, "Male", "Account And Finance"));
		l.add(new Employees(14, "rani Gowda", 38, "Female", "Product Development"));

//How many male and female employees are there in the organization?
		Map<String, Long> collect = l.stream()
				.collect(Collectors.groupingBy(Employees::getGender, Collectors.counting()));
		System.out.println(collect);

		System.out.println(
				"---------------------------------------------------------------------------------------------");

//Print the name of all departments in the organization?
		l.stream().filter(t -> t.getDepartment() != null).map(j -> j.getDepartment())
				.forEach(t -> System.out.println(t));
		System.out.println(l);

//------additional method--------
		l.stream().map(Employees::getDepartment).distinct().forEach(t -> System.out.println(t));

		System.out.println(
				"----------------------------------------------------------------------------------------------");

//What is the average age of male and female employees?
		Map<String, Double> l1 = l.stream()
				.collect(Collectors.groupingBy(Employees::getGender, Collectors.averagingInt(Employees::getAge)));
		System.out.println(l1);

		System.out.println(
				"----------------------------------------------------------------------------------------------");

//Get the details of highest age employee in the organization?
		Optional<Employees> collect1 = l.stream().collect(Collectors.maxBy(Comparator.comparing(Employees::getAge)));
		System.out.println(collect1);

		System.out.println(
				"----------------------------------------------------------------------------------------------");
//Get the names of all employees who have age>30?
		l.stream().filter(t -> t.getAge() >= 30).map(t -> t.getName()).forEach(System.out::println);

//Count the number of employees in each department?
		Map<String, Long> collect2 = l.stream()
				.collect(Collectors.groupingBy(Employees::getDepartment, Collectors.counting()));
		System.out.println("count:" + collect2);
		Set<Entry<String, Long>> entrySet = collect2.entrySet();
		entrySet.stream().map(z -> z.getKey() + ":" + z.getValue()).forEach(t -> System.out.println(t));

		System.out.println(
				"----------------------------------------------------------------------------------------------");

//What is the average age of each department?
		Map<String, Double> collect3 = l.stream().collect(
				Collectors.groupingBy(Employees::getDepartment, Collectors.averagingDouble(Employees::getAge)));
		Set<Entry<String, Double>> entrySet2 = collect3.entrySet();
		for (Entry<String, Double> entry : entrySet2) {
			System.out.println(entry.getKey() + ":" + entry.getValue());

			System.out.println(
					"----------------------------------------------------------------------------------------------");

//Get the details of youngest male employee in the product development department?
			Optional<Employees> min = l.stream()
					.filter(e -> e.getGender() == "Male" && e.getDepartment() == "Product Development")
					.min(Comparator.comparingInt(Employees::getAge));
			Employees emp = min.get();
			System.out.println(emp.getName());
			System.out.println(emp.getId());
			System.out.println(emp.getGender());
			System.out.println(emp.getAge());
			System.out.println(emp.getDepartment());
			System.out.println(
					"----------------------------------------------------------------------------------------------");

//Who has the most age in the organization?
			Optional<Employees> max = l.stream().sorted(Comparator.comparingInt(Employees::getAge)).findFirst();
			Employees emp1 = max.get();
			System.out.println(emp1.getName());
			System.out.println(emp1.getId());
			System.out.println(emp1.getGender());
			System.out.println(emp1.getAge());
			System.out.println(emp1.getDepartment());

			System.out.println(
					"----------------------------------------------------------------------------------------------");

//How many male and female employees are there in the sales and marketing team?
			Map<String, Long> collect4 = l.stream().filter(w -> w.getDepartment() == "Sales And Marketing")
					.collect(Collectors.groupingBy(Employees::getGender, Collectors.counting()));
			System.out.println("counting is:" + collect4);

			System.out.println(
					"----------------------------------------------------------------------------------------------");

//What is the average age of male and female employees?
			Map<String, Double> collect5 = l.stream().collect(
					Collectors.groupingBy(Employees::getGender, Collectors.averagingDouble(Employees::getAge)));
			System.out.println(collect5);

			System.out.println(
					"----------------------------------------------------------------------------------------------");
//List down the names of all employees in each department?
			Map<String, List<Employees>> collect6 = l.stream().collect(Collectors.groupingBy(Employees::getDepartment));
			Set<Entry<String, List<Employees>>> entrySet1 = collect6.entrySet();
			for (Entry<String, List<Employees>> entry1 : entrySet1) {
				System.out.println("Employees in:---" + entry1.getKey());
				List<Employees> value = entry1.getValue();
				for (Employees e : value) {
					System.out.println(e.getName());
				}
			}
			System.out.println(
					"----------------------------------------------------------------------------------------------");

//What is the average id and total age of the whole organization?
			DoubleSummaryStatistics collect7 = l.stream().collect(Collectors.summarizingDouble(Employees::getAge));
			System.out.println("Avg id:" + collect7.getAverage());
			System.out.println("Total age:" + collect7.getSum());

			System.out.println(
					"----------------------------------------------------------------------------------------------"); // System.out.println("--------------------------------------------");

//Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
			Map<Boolean, List<Employees>> collect8 = l.stream()
					.collect(Collectors.partitioningBy(t -> t.getAge() > 25));
			Set<Entry<Boolean, List<Employees>>> entrySet8 = collect8.entrySet();
			for (Entry<Boolean, List<Employees>> e : entrySet8) {
				if (e.getKey()) {
					System.out.println("Employees older than 25 years");
				} else {
					System.out.println("Employees less or equal than 25 years");
				}
				List<Employees> value = e.getValue();
				for (Employees e1 : value) {
					System.out.println(e1.getName());
				}
			}
			System.out.println(
					"----------------------------------------------------------------------------------------------");

//Who is the oldest employee in the organization? What is his age and which department he belongs to?
			Optional<Employees> max2 = l.stream().max(Comparator.comparingInt(Employees::getAge));
			max2.stream().forEach(s -> System.out.println(s));
			System.out.println("**********************************************");
			// Only get name,age and department name.....
			Employees em3 = max2.get();
			System.out.println(em3.getName());
			System.out.println(em3.getAge());
			System.out.println(em3.getDepartment());

			System.out.println(
					"----------------------------------------------------------------------------------------------");
		}
	}
}