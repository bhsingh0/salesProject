/**
 * 
 */
package com.jpmcsales.utils.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.jpmcsales.model.Item;
import com.jpmcsales.utils.PriceStrategy;

/**
 * @author Bhrti.Singh
 *
 */
public class ItemPriceStrategyImpl implements PriceStrategy {

	private Item item;

	private Double adjustedPrice;

	public ItemPriceStrategyImpl(Item item) {
		
		this.item = item;
		this.adjustedPrice = 0.0;
	}

	@Override
	public Double calculatePrice(Integer qty, Double price) {
		return qty * price;
	}

	@Override
	public Double priceAdjustment(Double price) {
		Double allPrice = getItem().getTotalPrice();
		Double itemTotalPrice = allPrice += price;

		return itemTotalPrice;
	}

	public Double getAdjustedPrice() throws IllegalAccessException, InvocationTargetException {
		String adjustmentMethod = String.format("%sPrice", item.getAdjustmentOperation().toLowerCase());
		try {
			Method method = this.getClass().getMethod(adjustmentMethod, null);
			method.invoke(this, null);
		} catch (NoSuchMethodException e) {
			e.getMessage();
		}
		return adjustedPrice;
	}

	public void addPrice() {
		this.adjustedPrice = getItem().getTotalPrice()
				+ (this.item.getTotalQuantity() * this.item.getItemPrice());
	}

	public void subtractPrice() {
		this.adjustedPrice = getItem().getTotalPrice()
				- (this.item.getTotalQuantity() * this.item.getItemPrice());
	}

	public void multiplyPrice() {
		this.adjustedPrice = getItem().getTotalPrice() + (getItem().getTotalPrice() * this.item.getItemPrice())
				+ (this.item.getTotalQuantity() * this.item.getItemPrice());
	}

	/**
	 * @return adjustment report
	 */
	public String adjustmentReport() {
		return String.format("Performed %s %.2fp to %d %s and price adjusted from %.2fp to %.2fp",
				this.item.getAdjustmentOperation(), this.item.getItemPrice(), this.item.getTotalQuantity(),
				this.item.getItemType(), getItem().getTotalPrice(), this.adjustedPrice);
	}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * @param adjustedPrice the adjustedPrice to set
	 */
	public void setAdjustedPrice(Double adjustedPrice) {
		this.adjustedPrice = adjustedPrice;
	}
}
