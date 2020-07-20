import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Orders implements Iterable<OrderItem>,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4217542780562475363L;
	private ArrayList<OrderItem> items;

	public Orders() {
		items = new ArrayList<OrderItem>();
	}

	public void addItem(OrderItem orderItem) {// ����û��Ķ���

		this.items.add(orderItem);
	}

	public void removeItem(OrderItem orderItem) {// ɾ���û�����

		this.items.remove(orderItem);
	}

	public OrderItem getItem(Animal animal) {// �õ��û��Ķ���

		for (OrderItem orderItem : this.items) {

			if (orderItem.getAnimal().equals(animal)) {

				return orderItem;
			}
		}

		return null;
	}

	public int getNumberOfItems() {// ��ȡ�û��Ķ�������

		return this.items.size();
	}

	@Override
	public Iterator<OrderItem> iterator() {
		return this.items.iterator();
	}

}
