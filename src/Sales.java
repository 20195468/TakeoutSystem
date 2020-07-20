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

	public void addOrders(Orders order) {// 添加用户信息
		orders.add(order);
	}

	public int getNumberOfOrders() {// 获得用户的数量

		return this.orders.size();
	}
}
