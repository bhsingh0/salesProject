/**
 * 
 */
package com.jpmcsales.utils;

/**
 * @author Bharti.Singh
 *
 */

/**
 * MessageHelper class for helping methods to api
 *
 */
public class MessageHelper {

	private MessageHelper() {
	}

	/**
	 * Method helps to handle with plurals of items
	 * 
	 * @param item
	 * @return
	 */
	public static String pluralHandler(String item) {
		String parsedType = "";
		String itemLastChar = item.substring(0, item.length() - 1);
		if (item.endsWith("o")) {
			parsedType = String.format("%soes", itemLastChar);
		} else if (item.endsWith("y")) {
			parsedType = String.format("%sies", itemLastChar);
		} else if (item.endsWith("h")) {
			parsedType = String.format("%shes", itemLastChar);
		} else if (!item.endsWith("s")) {
			parsedType = String.format("%ss", item);
		} else {
			parsedType = String.format("%s", item);
		}
		return parsedType.toLowerCase();
	}

    /**
     * Method helps to handle item price
     * 
     * @param itemPrice
     * @return
     */
    public static Double priceHandler(String itemPrice) {
    	Double price = Double.parseDouble(itemPrice.replaceAll("£|p", ""));
        if (!itemPrice.contains(".")) {
            price = Double.valueOf(Double.valueOf(price) / Double.valueOf("100"));
        }
        return price;
    }
	
}
