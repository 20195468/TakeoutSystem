import java.io.Serializable;

public class Animal implements Serializable{

	private String code;
	private String animal;
	private String gender;
	private String colour;
	private int year;

	public Animal(String code,String animal,String gender, String colour, int year) {
		this.gender=gender;
		this.code=code;
		this.animal = animal;
		this.colour = colour;
		this.year = year;
	}

	public String getcode() {
		return code;
	}
	
	public String getcolour() {
		return colour;
	}
	
	public String getanimal() {
		return animal;
	}

	public String getgender() {
		return gender;
	}

	public int getyear() {
		return year;
	}

	public boolean equals(Object object) {

		return object instanceof Animal && getcode().equals(((Animal) object).getcode());
	}

	public String toString() {
		return getcode() + "_" +  getanimal() + "_" +getgender()+"_"+getcolour()+"_"+getyear();
	}

}
