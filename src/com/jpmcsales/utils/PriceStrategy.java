/**
 * 
 */
package com.jpmcsales.utils;

/**
 * @author Bharti.Singh
 *
 */
public interface PriceStrategy {
	
	/**
	 * @param qty
	 * @param price
	 * @return
	 */
	public Double calculatePrice(Integer qty, Double price);
	
	/**
	 * @param price
	 * @return
	 */
	public Double priceAdjustment(Double price);

}
