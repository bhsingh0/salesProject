/**
 * 
 */
package com.jpmcsales.model;

import java.io.Serializable;

/**
 * @author Bharti.Singh
 *
 */
public class Item implements Serializable {

	private static final long serialVersionUID = -7401918199056213985L;

	private double itemPrice;

    private int itemQuantity;

    private String adjustmentOperation;

    private String itemType;

    private int totalQuantity;
    
    private Double totalPrice;
    
	public Item() {
	}

	public Item(String type) {
        this.itemType = type;
        this.adjustmentOperation = null;
        this.totalQuantity = 0;
        this.totalPrice = 0.0;
    }

	/**
	 * @return the itemPrice
	 */
	public double getItemPrice() {
		return itemPrice;
	}

	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	 * @return the itemQuantity
	 */
	public int getItemQuantity() {
		return itemQuantity;
	}

	/**
	 * @param itemQuantity the itemQuantity to set
	 */
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	/**
	 * @return the adjustmentOperator
	 */
	public String getAdjustmentOperation() {
		return adjustmentOperation;
	}

	/**
	 * @param adjustmentOperation the adjustmentOperator to set
	 */
	public void setAdjustmentOperation(String adjustmentOperation) {
		this.adjustmentOperation = adjustmentOperation;
	}

	/**
	 * @return the itemType
	 */
	public String getItemType() {
		return itemType;
	}

	/**
	 * @param itemType the itemType to set
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	/**
	 * @return the totalQuantity
	 */
	public int getTotalQuantity() {
		return totalQuantity;
	}

	/**
	 * @param totalQuantity the totalQuantity to set
	 */
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	/**
	 * @return the totalPrice
	 */
	public Double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
}