package assign1;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Order implements OrderDBInterface 	{
	int orderCount;
	int orderNum;
	int orderID;
	int writtenRecords;
	public Order getOrder;
	double totalAmt;
	String product;
	String orderDate;
	String customerName;
	private static final int DEFAULT = 100;
	
	Order[] order = new Order[DEFAULT];

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
		int i = 0;
		try {
			orderFile = new Scanner(new File(fileName));
			 record = orderFile.nextLine();
			
			while(orderFile.hasNext()) {		
				record = orderFile.nextLine();  
				
				order[orderCount] = new Order(record);
				orderCount++;
				if(i == 12) {
					break;
				}
				i++;
			}
			orderFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return orderCount;	
	}

	@Override
	public int saveOrders(String fileName) {
		
		try {
			FileWriter writer = new FileWriter(fileName);
			for(int i = 0; i < this.orderCount; i++) {
				writer.write(this.order[i].orderID + "," + this.order[i].customerName + "," + this.order[i].product + "," + this.order[i].totalAmt + "," + this.order[i].orderDate);
				writer.write(System.lineSeparator());
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
		
	}
	@Override
	public void showOrders() {
		int index = 0;
		
		System.out.printf("%-8s %-30s %10s\n","Order ID","Product", "Total Amt"); 
		System.out.printf("%-8s %-30s %10s\n","--------","-------", "---------"); 
		if(order[index] == null) {
			System.out.println("-EMPTY-\t\s-EMPTY-\t\t\t\s-EMPTY-");
		}
		while(order[index] != null) {
			System.out.printf("%-+8d %-30s %10.2f\n", order[index].getOrderID(), order[index].getProduct(), order[index].getTotalAmt());
			index++;
		}
		
		
	}

	@Override
	public boolean add(Order order) {
		for(int i = 0; i < this.order.length; i++) {
			if(this.order[i] == order) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void add(int index, Order order) {
		Order[] newArr = new Order[this.order.length]; 
		if(index > this.orderCount) {
			System.out.println("*** Index position in array is invalid ***");
		} else {
			for(int i = 0; i < this.order.length; i++) {
				if(i == index) {
					newArr[i] = order;
					
				} else if(i > index) {
					newArr[i] = this.order[i-1]; 
				}else {
					newArr[i] = this.order[i];
				}
			}
			this.orderCount++;
			this.order = newArr;
			
		}
	}

	@Override
	public void clear() {
		Order[] clear = new Order[DEFAULT];
		for(int index = 0; index < this.order.length; index++) {
			this.order[index] = clear[index];
		}
		
		
	}

	@Override
	public Order get(int index) {
		return this.order[index];
	}

	@Override
	public int searchByOrderID(int orderID) {
		int orderID1 = 0;
		
		for(int index = 0; index < order.length; index++) {
			orderID1 = order[index].getOrderID();
			if(orderID1 == orderID) {
				return index;
			}
		}
		
		return -1;
	}

	@Override
	public Order remove(int index) {
		Order[] newArr = new Order[this.order.length]; 
		Order[] copyArr = new Order[this.order.length];
		copyArr(copyArr);
		
		for(int i = 0; i < this.order.length-1; i++) {
			if(i < index) {
				newArr[i] = this.order[i];
			} else if(i >= index && this.order[i+1] != null) {
				newArr[i] = this.order[i+1];
			}
		}
		this.order = newArr;
		
		for(int i = 0; i < this.order.length-1; i++) {
			if(copyArr[i] != this.order[i]) {
				return copyArr[i];
			}
		}
		return null;
	}

	@Override
	public Order set(int index, Order order) {
		Order[] newArr = new Order[this.order.length];
		Order[] replacedOrder = new Order[this.order.length];
		copyArr(replacedOrder);
		
		for(int i = 0; i < this.order.length; i++) {
			if(i == index) {
				newArr[i] = order;
				this.order[i] = newArr[i];
			}
		}
		
		return replacedOrder[index];
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
		Order[] newArr = new Order[this.order.length + 25]; 
		copyArr(newArr);
		this.order = newArr;
		
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
	private double getTotalAmt() {
		return this.totalAmt;
	}
	private String getProduct() {
		return this.product;
	}
	private int getOrderID() {
		return orderID;
	}
	public Order[] copyArr(Order[] array) {
		for(int i = 0; i < this.order.length-1; i++) {
			array[i] = this.order[i];
		}
		return array;
	}
	
	public String toString() {
		return "Order ID: " + orderID + ", Product: " + product + ", Total Amount: " + totalAmt;
	}

}
