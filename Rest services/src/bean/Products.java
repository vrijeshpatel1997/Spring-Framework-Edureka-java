package bean;


import java.util.ArrayList;

public class Products    {

	// list of products
	ArrayList<Product> thelist = new ArrayList<>();
	
	
	public void add(Product pt) {
		
		thelist.add(pt);
	}
	
	// method to print constructor
	public void printAll() {
		
		
		System.out.println("---------------------These are list of produtcts");
		
		for(Product pt :thelist) {
			System.out.println("Id " + pt.orderNo);
		}
		
		System.out.println("---------------------End of list of produtcts");
		
	}

	// default constructor 
	public Products() {
		
	}

}
