package smsdemo;
public class Student {
	private String sid;
	private String name;
	private int age;
	private String tel;

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Student(String sid, String name, int age, String tel) {
		this.sid = sid;
		this.name = name;
		this.age = age;
		this.tel = tel;
	}

	public Student() {
	}

	public String toString(){
		return "sid="+this.sid+"  name="+this.name
		+"  age="+this.age+"  tel="+this.tel;
	}
}
