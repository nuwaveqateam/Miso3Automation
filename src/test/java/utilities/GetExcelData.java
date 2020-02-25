package utilities;

import base.Base;

public class GetExcelData extends Base {
	
	public static String fileName;

	/*public static void captureScreenshot() throws IOException {

		Date d = new Date();
		fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".\\target\\surefire-reports\\html\\" + fileName));

	}*/
	
	
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
