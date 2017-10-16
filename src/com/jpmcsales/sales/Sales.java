/**
 * 
 */
package com.jpmcsales.sales;

import java.lang.reflect.InvocationTargetException;

import com.jpmcsales.model.Item;
import com.jpmcsales.utils.MessageProcessor;
import com.jpmcsales.utils.impl.ItemPriceStrategyImpl;

/**
 * @author Bharti.Singh
 *
 */
public class Sales {
	public SaleReport salesLog;

	private ItemPriceStrategyImpl priceStrategy;

	private Item item;

	public Sales() {
		this.salesLog = new SaleReport();
	}

	public boolean processNotification(String saleNotice) throws IllegalAccessException, InvocationTargetException {

        MessageProcessor messageProcessor;

        messageProcessor = new MessageProcessor(saleNotice);

        String productType = messageProcessor.getItemType();

        if (productType.isEmpty()) {
            return false;
        }

        item = salesLog.getItem(productType);

        priceStrategy = new ItemPriceStrategyImpl(item);

        item.setItemQuantity(messageProcessor.getItemQty());
        item.setTotalQuantity(messageProcessor.getItemQty());
        item.setItemPrice(messageProcessor.getItemPrice());
        item.setAdjustmentOperation(messageProcessor.getOperation());

        setProductTotalPrice();

        salesLog.setNormalReports(saleNotice);

        salesLog.updateProduct(item);

        return true;
    }
	   private void setProductTotalPrice() throws IllegalAccessException, InvocationTargetException {
	        Double adjustedPrice;
	        Double itemValue;

	        if (!item.getAdjustmentOperation().isEmpty()) {
	            adjustedPrice = priceStrategy.getAdjustedPrice();
	            salesLog.setAdjustmentReports(priceStrategy.adjustmentReport());
	            item.setTotalPrice(adjustedPrice);
	        } else {
	            itemValue = priceStrategy.calculatePrice(item.getItemQuantity(), item.getItemPrice());
	           priceStrategy.priceAdjustment(itemValue);
	        }
	    }
}
