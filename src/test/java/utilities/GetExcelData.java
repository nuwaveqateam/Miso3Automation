package utilities;

import base.Base;

public class GetExcelData extends Base {
	
	public static String fileName;

	
	
	public static Object[][] getData(String sheetName) {

		

		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);

		System.out.println(excel.getCellData(sheetName, 0, 2));

		Object[][] data = new Object[rowNum - 1][colNum];

		for (int rows = 2; rows <= rowNum; rows++) {

			for (int cols = 0; cols < colNum; cols++) {
				
				data[rows - 2][cols] = excel.getCellData(sheetName, cols, rows);

			}

		}

		
		
		return data;
	}

}
