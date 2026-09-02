package assign1;

public class Order implements OrderDBInterface	{

	@Override
	public int loadOrders(String fileName) {
		return 0;
	}

	@Override
	public int saveOrders(String fileName) {
		return 0;
	}

	@Override
	public void showOrders() {
		
	}

	@Override
	public boolean add(Order order) {
		return false;
	}

	@Override
	public void add(int index, Order order) {
		
	}

	@Override
	public void clear() {
		
	}

	@Override
	public Order get(int index) {
		return null;
	}

	@Override
	public int searchByOrderID(int orderID) {
		return 0;
	}

	@Override
	public Order remove(int index) {
		return null;
	}

	@Override
	public Order set(int index, Order order) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public int capacity() {
		return 0;
	}

	@Override
	public void resize() {
		
	}

}
