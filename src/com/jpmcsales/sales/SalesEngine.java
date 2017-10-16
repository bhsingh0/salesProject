/**
 * 
 */
package com.jpmcsales.sales;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Bharti.Singh
 *
 */
public class SalesEngine {
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		
        Sales sale = new Sales();

        // Read inputs from test file
        try {
            String line;
            BufferedReader inputFile = new BufferedReader(new FileReader("data/sales-data.txt"));
            while((line = inputFile.readLine()) != null) {
                // process message for each sale notification
                sale.processNotification(line);

                sale.salesLog.report();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
