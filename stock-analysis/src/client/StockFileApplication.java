package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

public class StockFileApplication {
	
	public static void main(String args[]) throws IOException{
		StockFileReader fr = new StockFileReader("table.csv");
		
		List<HashMap<String, Double>> dataResult = populateStockFileData(fr.getHeaders(), fr.readFileData());
		StockFileData fileData = new StockFileData();
		fileData.addData(dataResult);
		fileData.printData();
		System.out.println(dataResult.size());
	}
	/**
	 * Complete the method body so that it returns the given structure needed to 
	 * populate the data field in the StockFileData class. 
	 * @param headers
	 * @param lines
	 * @return List
	 */
	public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines){
		List<HashMap<String, Double>> dataResult = new ArrayList<>();
		
		
		for (String line : lines) {
			
			
			String [] values = line.split(",");
//			List<String> values = new ArrayList<String>();
//			values = Arrays.asList(data);
			
			HashMap<String, Double> headerValMap = new HashMap<>();
			int cnt = 0;
			for (String value : values) {
				
				double dval = Double.parseDouble(value); // converts string to double
				
				headerValMap.put(headers.get(cnt), dval);
				cnt++;
			}
			dataResult.add(headerValMap);
		
			
			
			
// 			
//			dataResult.add(new HashMap<String, Double>().put(headers.get(0), intValues.get(0)));
//			dataResult.add(new HashMap<String, Double>().put(headers.get(1), intValues.get(1)));
//			dataResult.add(new HashMap<String, Double>().put(headers.get(2), intValues.get(2)));
//			dataResult.add(new HashMap<String, Double>().put(headers.get(3), intValues.get(3)));
//			dataResult.add(new HashMap<String, Double>().put(headers.get(4), intValues.get(4)));

		}
		
		
		return dataResult;
	}
	
	
}
