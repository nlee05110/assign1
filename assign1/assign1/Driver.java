package assign1;

public class Driver {

	public static void main(String[] args) {
		int searchOrderID = 1005;
		int getOrderIndex = 4; 
		String fileName = "orders.txt";
		
		Order order = new Order();
		
		
		Order addOrder = new Order("1051,Alice Smith,Desk Pad,300.2,2026-01-18");
		Order setOrder = new Order("1052,Jim Smith,XBOX,599.99,2026-03-23");
		order.loadOrders(fileName); //Loads contents in array
		order.saveOrders(fileName); //Saves contents from array and overwrites file
		order.showOrders(); //Shows orders before modifying array
		System.out.println();
		order.add(4, addOrder); //Adds a new order from addOrder object
		System.out.println(" - Removed: " + order.remove(9));
		order.set(7, setOrder); //Replaces order with setOrder in array
		System.out.println(" - OrderID " + searchOrderID + " " + "located on index: " + order.searchByOrderID(searchOrderID)); 
		System.out.println(" - Getting order details:  " + order.get(getOrderIndex) + "\n");
		order.showOrders(); //Shows orders in array after changes made

	}

}
