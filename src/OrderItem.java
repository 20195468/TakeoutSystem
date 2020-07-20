import java.io.Serializable;

public class OrderItem implements Serializable{

	private Animal animal;

	private int quantity;

	public OrderItem(Animal animal, int quantity) {
		this.animal = animal;
		this.quantity = quantity;
	}

	public Animal getAnimal() {

		return this.animal;
	}

	public int getQuantity() {

		return this.quantity;
	}

	public void setQuantity(int newQuantity) {

		this.quantity = newQuantity;
	}

	public String toString() {

		return getAnimal().getcode()+"_"+ getAnimal().getanimal()+"_"+getAnimal().getcolour() +"_"+getQuantity();
	}
}
