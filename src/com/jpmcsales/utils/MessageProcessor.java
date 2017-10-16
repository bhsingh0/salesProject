/**
 * 
 */
package com.jpmcsales.utils;

import java.io.Serializable;

/**
 * @author Bharti.Singh
 *
 */
public class MessageProcessor implements Serializable {

	/**
	 * system generated serial version id
	 */
	private static final long serialVersionUID = -8627602645831373725L;

	private static String SALES_ERROR = "Error in sales process";

	private static String OPERATION_MATCHES = "Add|Subtract|Multiply";

	private String itemType;

	private Integer itemQty;

	private Double itemPrice;

	private String operation;

	/**
	 * Constructor for initialising
	 * 
	 * @param msg
	 */
	public MessageProcessor(String msg) {
		this.itemType = "";
		this.itemPrice = 0.0;
		this.itemQty = 0;
		this.operation = "";
		processMsg(msg);
	}

	private boolean processMsg(String msg) {
		if (msg == null || msg.isEmpty()) {
			return false;
		}
		String[] messages = msg.trim().split("\\s+");
		String firstWord = messages[0];
		if (firstWord.matches(OPERATION_MATCHES)) {
			return processMsg3(messages);
		} else if (firstWord.matches("^\\d+")) {
			return processMsg2(messages);
		} else if (messages.length == 3 && messages[1].contains("at")) {
			return processMsg1(messages);
		} else {
			System.err.println(SALES_ERROR);
		}
		return true;
	}

	private Boolean processMsg1(String[] messages) {
		if (messages.length > 3 || messages.length < 3) {
			return Boolean.FALSE;
		} else {
			itemType = MessageHelper.pluralHandler(messages[0]);
			itemPrice = MessageHelper.priceHandler(messages[2]);
			itemQty = 1;
			return Boolean.TRUE;
		}
	}

	private Boolean processMsg2(String[] messages) {
		if (messages.length > 7 || messages.length < 7) {
			return Boolean.FALSE;
		} else {
			itemType = MessageHelper.pluralHandler(messages[3]);
			itemPrice = MessageHelper.priceHandler(messages[5]);
			itemQty = Integer.parseInt(messages[0]);
			return Boolean.TRUE;
		}
	}

	private Boolean processMsg3(String[] messages) {
		if (messages.length > 3 || messages.length < 3) {
			return Boolean.FALSE;
		} else {
			operation = messages[0];
			itemType = MessageHelper.pluralHandler(messages[2]);
			itemQty = 0;
			itemPrice = MessageHelper.priceHandler(messages[1]);
			return Boolean.TRUE;
		}
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
	 * @return the itemQty
	 */
	public Integer getItemQty() {
		return itemQty;
	}

	/**
	 * @param itemQty the itemQty to set
	 */
	public void setItemQty(Integer itemQty) {
		this.itemQty = itemQty;
	}

	/**
	 * @return the itemPrice
	 */
	public Double getItemPrice() {
		return itemPrice;
	}

	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}
}