package assign1;

public interface OrderDBInterface {

	int loadOrders(String fileName);    //Loads the orders into the array from the specified file. Returns the number of orders loaded.
	int saveOrders(String fileName);    //Saves the orders from the array in the specified file. Returns the number of records written.
	void showOrders();                  //Display the Orders from the File
	boolean add(Order order);            //Add order to the End of the array. Returns true if successful.
	void add(int index, Order order);    //Inserts the order at the specified position in this array.
	void clear();                        //Removes all orders
	Order get(int index);                //Returns the order at the specified position in the array
	int searchByOrderID(int orderID);    //Returns the location of the order with the specified orderID in the array.  Returns -1 if not found.
	Order remove(int index);             //Removes the order at the specified position in the array. Returns the removed order.
	Order set(int index, Order order);   //Replaces the order at the specified position in the array with the new order.  Returns the order that was replaced
	int size();                          //Returns the number of orders in the array
	int capacity();                      //Returns the allocated size of the array.  
	void resize();                       //Resize the Array by 25 additional elements.

}