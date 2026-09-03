package assign1;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;


public class Order implements OrderDBInterface 	{
	int orderCount;
	int orderNum;
	int orderID;
	public String fileName;
	public Order getOrder;
	double totalAmt;
	String product;
	String orderDate;
	String customerName;
	
	Order[] order = new Order[100];

	public Order(String record) {
		String[] fields = record.split(",");
		this.setOrderID(Integer.parseInt(fields[0]));
		this.setCustomerName(fields[1]);
		this.setProduct(fields[2]);
		this.setTotalAmount(Double.parseDouble(fields[3]));
		this.setOrderDate(fields[4]);
	}

	@Override
	public int loadOrders(String fileName) {
		String record;
		Scanner orderFile;
		
		try {
			orderFile = new Scanner(new File(fileName));
			record = orderFile.nextLine();  //Read File Header
			
			while(orderFile.hasNext()) {		
				record = orderFile.nextLine();  
				order[orderCount] = new Order(record);
				orderCount++;
				
			}
			orderFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return 0;	
	}

	@Override
	public int saveOrders(String fileName) {
		return 0;
	}

	@Override
	public void showOrders() {
		int index = 0;
		
		System.out.printf("%-8s %-30s %10s\n","Order ID","Product", "Total Amt"); 
		System.out.printf("%-8s %-30s %10s\n","--------","-------", "---------"); 
		while(order[index] != null) {
			System.out.printf("%-+8d %-30s %10.2f\n", order[index].getOrderID(), order[index].getProduct(), order[index].getTotalAmt());
			index++;
		}
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
		return this.order[index-1];
	}

	@Override
	public int searchByOrderID(int orderID) {
		int orderID1 = 0;
		
		for(int index = 0; index < order.length; index++) {
			orderID1 = order[index].getOrderID();
			if(orderID1 == orderID) {
				return index+1;
			}
		}
		
		return -1;
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
		return orderCount;
	}

	@Override
	public int capacity() {
		return order.length;
	}

	@Override
	public void resize() {
		
	}
	
	public Order() {
		
	}

	
	
	private void setOrderDate(String string) {  //Getters and Setters to display orders. 
		this.orderDate = string;
	}
	private void setTotalAmount(double double1) {
		this.totalAmt = double1;
	}
	private void setProduct(String string) {
		this.product = string; 
	}
	private void setCustomerName(String string) {
		this.customerName = string; 
	}
	private void setOrderID(int int1) {
		this.orderID = int1;
	}
	private String getOrderDate() {
		return this.orderDate;
	}
	private double getTotalAmt() {
		return this.totalAmt;
	}
	private String getProduct() {
		return this.product;
	}
	private String getCustomerName() {
		return customerName;
	}
	private int getOrderID() {
		return orderID;
	}
	public String toString() {
		return "Order ID: " + orderID + ", Product: " + product + ", Total Amount: " + totalAmt;
	}

}
