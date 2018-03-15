package kayan.guava;

import static com.google.common.base.Joiner.on;
import static com.google.common.collect.Lists.transform;

import java.util.List;

import kayan.common.Employee;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class TestTransform {

	public static void main(String[] args) {

		List<Employee> list = Lists.newArrayList(
				new Employee("ken", 11),
				new Employee("dash", 22), new Employee("mishka", 43));

		String s = on(", ").join(
				transform(list, new Function<Employee, String>() {
					public String apply(Employee input) {
						return input.getAge().toString();
					}
				}));


		System.out.println(s);

	}
}
