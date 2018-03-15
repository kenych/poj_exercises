package kayan.common;

public class Employee {

	String name;
	String code;
	Integer age;
	private final static String DEFAULT_CODE = null;

	public Employee() {
	}

	public Employee(String name, Integer age) {
		this(name, age, DEFAULT_CODE);

	}

	public Employee(String name, Integer age, String code) {
		this.name = name;
		this.age = age;
		this.code = code;
	}
	
	

	public String getCode() {
		return code;
	}


	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

}
