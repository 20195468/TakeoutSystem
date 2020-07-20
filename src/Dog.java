import java.io.Serializable;

public class Dog extends Animal implements Serializable{

	private String name;
	private String kind;
	
	public Dog(String code, String animal, String gender, String colour, int year, String name, String kind) {
		super(code, animal, gender, colour, year);
		this.name = name;
		this.kind = kind;
	}

	public String getname() {
		return name;
	}

	public String getkind() {
		return kind;
	}

	public String toString() {
		return super.toString() + "_" + getname() + "_" + getkind();
	}
}
