package assign1;

public class Driver {

	public static void main(String[] args) {
		int searchOrder = 1005;
		int getOrder = 4; 
		OrderDBInterface order = new Order();
		order.loadOrders("orders.txt");
		order.showOrders();
		System.out.printf("\n - Total number of orders are \t\t--- %d\n",order.size());
		System.out.printf(" - Allocated array size: \t\t--- %d elements\n", order.capacity());
		System.out.printf(" - Order # %d is \t\t\t--- %s\n",getOrder, order.get(getOrder));
		System.out.printf(" - Order # %d is stored in element: \t--- %d of the array\n", searchOrder, order.searchByOrderID(searchOrder));
	}

}
