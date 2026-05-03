package demo;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class TestSample {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		DataDriven4 dd=new DataDriven4();
		ArrayList data=dd.getData("AddProfile");
		
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
	
	}
	
	
}
