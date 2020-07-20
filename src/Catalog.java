import java.util.ArrayList;
import java.util.Iterator;

public class Catalog implements Iterable<Animal>{

	private ArrayList<Animal> animals;
	
	public Catalog() {
		animals=new ArrayList<Animal>();
	}
	
	public void addAnimal(Animal animal) {
		animals.add(animal);
	}
	
	public Animal getanimal(String code) {
		for(Animal animal:animals) {
			if(animal.getcode().equals(code)) {
				return animal;
			}
		}
		return null;
	}
	
	public void removeAnimal(Animal animal) {
		animals.remove(animal);
	}
	
	public int getNumberOfanimal() {
		return animals.size();
	}

	@Override
	public Iterator<Animal> iterator() {
		return animals.iterator();
	}
	
	
}
