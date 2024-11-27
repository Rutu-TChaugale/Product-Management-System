package com.rutu.model;

public class Product {
	
	private int product_id;
	private String product_type;
	private String product_name;
	private double product_prize;
	private int product_Qty;
	
	
	public Product(int product_id, String product_type, String product_name, double product_prize, int product_Qty) {
		super();
		this.product_id = product_id;
		this.product_type = product_type;
		this.product_name = product_name;
		this.product_prize = product_prize;
		this.product_Qty = product_Qty;
	}
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getProduct_prize() {
		return product_prize;
	}
	public void setProduct_prize(double product_prize) {
		this.product_prize = product_prize;
	}
	public int getProduct_Qty() {
		return product_Qty;
	}
	public void setProduct_Qty(int product_Qty) {
		this.product_Qty = product_Qty;
	}

	@Override
	public String toString() {
		return "Prooduct [product_id=" + product_id + ", product_type=" + product_type + ", product_name="
				+ product_name + ", product_prize=" + product_prize + ", product_Qty=" + product_Qty + "]";
	}

}
