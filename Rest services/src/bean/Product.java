package bean;

import javax.faces.bean.ManagedBean;
import javax.xml.bind.annotation.XmlRootElement;



@ManagedBean
@XmlRootElement(name="product")

// Product class
public class Product     { 
	
	// variables
	int orderNo ;
	String productName;
	float price;
	int quantity;
	
	// default constructor
	public Product() {
		
		
	}
	
	// getters setters
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	// parameterized constructor
	public Product(int orderNo, String productName, float price, int quantity) {

		this.orderNo = orderNo;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	

	
}
