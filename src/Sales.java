import java.util.ArrayList;
import java.util.Iterator;

public class Sales implements Iterable<Orders> {

	private ArrayList<Orders> orders;

	public Sales() {
		orders = new ArrayList<Orders>();
	}

	@Override
	public Iterator<Orders> iterator() {
		return orders.iterator();
	}

	public void addOrders(Orders order) {// ����û���Ϣ
		orders.add(order);
	}

	public int getNumberOfOrders() {// ����û�������

		return this.orders.size();
	}
}
