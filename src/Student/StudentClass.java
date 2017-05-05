package Student;
public class StudentClass {
	private String name;
	private int age;
	private int studynumber;

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

	public int getStudynumber() {
		return studynumber;
	}

	public void setStudynumber(int studynumber) {
		this.studynumber = studynumber;
	}

	public StudentClass(String name, int age, int studynumber) {
		this.name = name;
		this.age = age;
		this.studynumber = studynumber;
	}
	public StudentClass(){}

}
