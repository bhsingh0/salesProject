/**
 * 
 */
package com.jpmcsales.sales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jpmcsales.model.Item;

/**
 * @author Bharti.Singh
 *
 */
public class SaleReport {

	private Map<String, Item> inlineItems = new HashMap<>();

	private Double totalSales;

	private List<String> normalReports;

	private List<String> adjustmentReports;

	/**
	 * Constructor
	 */
	public SaleReport() {
		this.normalReports = new ArrayList<>();
		this.adjustmentReports = new ArrayList<>();
		this.totalSales = 0.0;
	}

	/**
	 * @param item
	 * @return
	 */
	public Item getItem(String item) {
		return inlineItems.getOrDefault(item, new Item(item));
	}

	/**
	 * @param item
	 */
	public void updateProduct(Item item) {
		inlineItems.put(item.getItemType(), item);
	}

	/**
	 * @param totalPrice
	 */
	public void appendTotalSalesValue(double totalPrice) {
		totalSales += totalPrice;
	}
    public void report() {

        // Report logged after 10th iteration.
        if((normalReports.size() % 10) == 0 && normalReports.size() !=0) {
            setTotalSales(0.0);
            //System.out.println(normalReports);
            System.out.println("10 sales appended to log");
            System.out.println("+------------[ Log Report ]----------------+");
            System.out.println("|\tItems \t   |\tQty    | Value     |");
            System.out.println("+------------------+-----------+-----------+");
            inlineItems.forEach((k,v) -> formatReports(k,v));
            System.out.println("+------------------------------------------+");
            System.out.println(String.format("|%-30s|%-11.2f|","Total Sales",getTotalSales()));
            System.out.println("+------------------------------------------+");
            System.out.println("End\n\n");
            try {
                // Add 2 second pause
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Report and stop execution after 50th message
        if((normalReports.size() % 50) == 0 && normalReports.size() !=0) {
            System.out.println("Application is received 50 messages hence cannot process further. The following adjustments are done in records;\n");

            // Display all the adjustment reports so far recorded.
            getAdjustmentReports().forEach(System.out::println);
            System.exit(1);
        }
    }

    // Format the report with right padding structure. populates product details on each line.
    public void formatReports(String type, Item item) {
        String lineItem = String.format("|%-18s|%-11d|%-11.2f|", item.getItemType(), item.getTotalQuantity(), item.getTotalPrice());
        appendTotalSalesValue(item.getTotalPrice());
        System.out.println(lineItem);
    }
	/**
	 * @return the totalSales
	 */
	public Double getTotalSales() {
		return totalSales;
	}

	/**
	 * @param totalSales
	 *            the totalSales to set
	 */
	public void setTotalSales(Double totalSales) {
		this.totalSales = totalSales;
	}

	/**
	 * @return the normalReports
	 */
	public List<String> getNormalReports() {
		return normalReports;
	}

	/**
	 * @param normalReports
	 *            the normalReports to set
	 */
	public void setNormalReports(String normalReport) {
		this.normalReports.add(normalReport);
	}

	/**
	 * @return the adjustmentReports
	 */
	public List<String> getAdjustmentReports() {
		return adjustmentReports;
	}

	/**
	 * @param adjustmentReports
	 *            the adjustmentReports to set
	 */
	public void setAdjustmentReports(String adjustmentReport) {
		this.adjustmentReports.add(adjustmentReport);
	}
}
