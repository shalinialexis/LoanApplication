package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public ArrayList<String> getData(String testCaseName) throws IOException {
		String userName = "user1";
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\rober\\eclipse-workspace\\RadiusBankProject\\src\\testCases\\Rdemo.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int SheetCount = workbook.getNumberOfSheets();
		for (int i = 0; i < SheetCount; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("UserData")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> cell = firstRow.cellIterator();
				int k = 0;
				int column = 0;
				while (cell.hasNext()) {
					Cell value = cell.next();
					if (value.getStringCellValue().equalsIgnoreCase(testCaseName)) {
						column = k;

					}
					k++;
				}
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(userName)) {
						Iterator<Cell> cellValue = r.cellIterator();
						while (cellValue.hasNext()) {
							Cell cv = cellValue.next();
							if (cv.getCellType() == CellType.STRING) {
								a.add(cv.getStringCellValue());
							} else

								a.add(NumberToTextConverter.toText(cv.getNumericCellValue()));

						}
					}
				}
			}
		}

		return a;

	}

	public static void main(String[] args) throws IOException {
		ExcelData ed = new ExcelData();
		ArrayList a = ed.getData("Users");
		System.out.println(a.get(1));
		System.out.println(a.get(3));
		System.out.println(a.get(2));
		System.out.println(a.get(4));

	}

}
