package fileprocessors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.text.AbstractDocument.BranchElement;

public class StockFileReader {
	
	String filePath = null;
	
	public StockFileReader(String filePath){
		this.filePath = filePath;
	}
	
	public List<String> getHeaders() throws IOException{
		String line = readFirstLine(filePath);
		String [] header = line.split(",");
		List<String> values = new ArrayList<String>();
		values = Arrays.asList(header);
		return values;
	}
	
	static String readFirstLine(String path) throws IOException {
	    try (BufferedReader br =
	                   new BufferedReader(new FileReader(path))) {
	        return br.readLine();
	    }
	}
	/**
	 * Complete the body of this method.
	 * @return List
	 * @throws IOException
	 */
	public List<String> readFileData() throws IOException{
		
		List<String> lines = new ArrayList<String>();
		
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){  // reading in the file which was named in main method
			 
			bufferedReader.readLine(); // skips the first line
			String line = bufferedReader.readLine();
			
			while(line!= null) {
			lines.add(line);
			line = bufferedReader.readLine();
			}
		}
	    return lines;
	}


	

}
