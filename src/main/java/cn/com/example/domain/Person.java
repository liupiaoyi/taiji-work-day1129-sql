package cn.com.example.domain;

public class Person {

	private String name;

	private int age;

	private int pid;
	

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	public Person() {
		super();
	}

	public Person(String name, int age, int pid) {
		super();
		this.name = name;
		this.age = age;
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ",pid="+pid+"]";
	}	
}
