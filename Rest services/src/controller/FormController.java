package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import bean.Product;
import bean.User;
import database.DatabaseService;

@ManagedBean
public class FormController {
	
	// controller for buttons on pages

	public FormController() {

	}

	
	

	public String onSubmitUser() {
		// Get user managed bean
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);

	
		// Forward to Test Response view along with the user managed bean
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "LoginResponse.xhtml";
	}

	public String onSubmitsignin() {
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);

		// Forward to Test Response view along with the user managed bean
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "SigninResponse.xhtml";
	}

	public String onSubmit() throws SQLException {

		// read the "get" values from form
		FacesContext context = FacesContext.getCurrentInstance();

		Product pt = context.getApplication().evaluateExpressionGet(context, "#{product}", Product.class);

		// pt holds the value of object that was on web form\

		// store in data base

		// put it in repsonse page
		System.out.println("you entered " + pt.getProductName());

		DatabaseService db = new DatabaseService();
		db.insert(pt);

		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("product", pt);

		return "Response.xhtml";
	}

	public String onSubmitedit() throws SQLException {

		// read the "get" values from form
		FacesContext context = FacesContext.getCurrentInstance();

		Product pt = context.getApplication().evaluateExpressionGet(context, "#{product}", Product.class);

		// pt holds the value of object that was on web form\

		// store in data base

		// put it in repsonse page
		System.out.println("you are editing  " + pt.getProductName());

		DatabaseService db = new DatabaseService();
		db.update(pt.getOrderNo(), pt);

		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("product", pt);

		return "Response.xhtml";
	}

	// read all products from database
	public ArrayList<Product> getAll() throws SQLException {

		DatabaseService ds = new DatabaseService();
		return ds.readAll();

	}

	public String onDelete(Product pt) throws SQLException {

	
		// delete product

		System.out.println("you deleted" + pt.getProductName());
		DatabaseService db = new DatabaseService();
		db.delete(pt.getOrderNo());

		// put it in repsonse page

		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("product", pt);

		return "Response.xhtml";

	}

	public String onShowEdit(Product pt) {
		
		// edit products

		System.out.println("the  product that are you are editing  is " + pt.getProductName());

		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("product", pt);

		return "editform.xhtml";
	}

	public String showcreate() {
		return "entry.xhtml";
	}

}