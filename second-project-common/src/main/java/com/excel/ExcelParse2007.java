package com.excel;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * @date 2018/8/1 17:03
 */
public class ExcelParse2007 implements IExcelParse {
    private XSSFWorkbook wb = null;

    public ExcelParse2007() {
    }

    @Override
    public void loadExcel(String filePathAndName) throws FileNotFoundException, IOException {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(filePathAndName);
            this.wb = new XSSFWorkbook(fis);
        } catch (FileNotFoundException var8) {
            var8.printStackTrace();
            throw new FileNotFoundException("加载Excel文件失败：" + var8.getMessage());
        } catch (IOException var9) {
            var9.printStackTrace();
            throw new IOException("加载Excel文件失败：" + var9.getMessage());
        } finally {
            if (fis != null) {
                fis.close();
                fis = null;
            }

        }

    }

    @Override
    public void loadExcel(InputStream is) throws Exception {
        this.wb = new XSSFWorkbook(is);
    }

    @Override
    public String getSheetName(int sheetNo) {
        return this.wb.getSheetName(sheetNo - 1);
    }

    @Override
    public int getSheetCount() throws Exception {
        int sheetCount = this.wb.getNumberOfSheets();
        if (sheetCount == 0) {
            throw new Exception("Excel中没有SHEET页");
        } else {
            return sheetCount;
        }
    }

    @Override
    public int getRowCount(int sheetNo) {
        int rowCount = 0;
        XSSFSheet sheet = this.wb.getSheetAt(sheetNo - 1);
        rowCount = sheet.getLastRowNum();
        return rowCount;
    }

    @Override
    public int getRealRowCount(int sheetNo) {
        int rowCount ;
        int rowNum ;
        XSSFSheet sheet = this.wb.getSheetAt(sheetNo - 1);
        rowCount = sheet.getLastRowNum();
        if (rowCount == 0) {
            return rowCount;
        } else {
            XSSFRow row = null;
            XSSFCell cell = null;
            rowNum = rowCount;
            int i = 0;

            label50:
            while(true) {
                if (i >= rowCount) {
                    return rowNum;
                }

                row = sheet.getRow(rowNum);
                --rowNum;
                if (row != null) {
                    short firstCellNum = row.getFirstCellNum();
                    short lastCellNum = row.getLastCellNum();

                    for(int j = firstCellNum; j < lastCellNum; ++j) {
                        cell = row.getCell(j);
                        if (cell != null && cell.getCellType() != 3) {
                            if (cell.getCellType() != 1) {
                                break label50;
                            }

                            String value = cell.getStringCellValue();
                            if (value != null && !value.equals("")) {
                                value = value.trim();
                                if (!value.isEmpty() && !value.equals("") && value.length() != 0) {
                                    break label50;
                                }
                            }
                        }
                    }
                }

                ++i;
            }

            rowCount = rowNum + 1;
            return rowCount;
        }
    }

    @Override
    public String readExcelByRowAndCell(int sheetNo, int rowNo, int cellNo) throws Exception {
        String rowCellData = "";
        XSSFSheet sheet = this.wb.getSheetAt(sheetNo - 1);
        String sheetName = this.wb.getSheetName(sheetNo - 1);

        try {
            XSSFRow row = sheet.getRow(rowNo);
            if (row == null) {
                return "";
            } else {
                XSSFCell cell = row.getCell((short)(cellNo - 1));
                if (cell == null) {
                    return "";
                } else {
                    int cellType = cell.getCellType();
                    String df = cell.getCellStyle().getDataFormatString();
                    double d;
                    if (cellType == 0) {
                        d = cell.getNumericCellValue();
                        if (!DateUtil.isCellDateFormatted(cell) && !df.contains("yyyy\"年\"m\"月\"d\"日\"")) {
                            rowCellData = (new DecimalFormat("0.########")).format(d);
                        } else {
                            Date date = DateUtil.getJavaDate(d);
                            Timestamp timestamp = new Timestamp(date.getTime());
                            String temp = timestamp.toString();
                            if (temp.endsWith("00:00:00.0")) {
                                rowCellData = temp.substring(0, temp.lastIndexOf("00:00:00.0"));
                            } else if (temp.endsWith(".0")) {
                                rowCellData = temp.substring(0, temp.lastIndexOf(".0"));
                            } else {
                                rowCellData = timestamp.toString();
                            }
                        }
                    } else if (cellType == 1) {
                        rowCellData = cell.getStringCellValue();
                    } else if (cellType == 2) {
                        d = cell.getNumericCellValue();
                        rowCellData = String.valueOf(d);
                    } else if (cellType == 3) {
                        rowCellData = "";
                    } else if (cellType == 4) {
                        rowCellData = "";
                    } else {
                        if (cellType != 5) {
                            throw new Exception(sheetName + " sheet页中" + "第" + rowNo + "行" + "第" + cellNo + "列,单元格格式无法识别，请检查sheet页");
                        }

                        rowCellData = "";
                    }

                    return rowCellData;
                }
            }
        } catch (Exception var16) {
            var16.printStackTrace();
            throw new Exception(sheetName + "sheet页中" + "第" + rowNo + "行" + "第" + cellNo + "列" + "数据不符合要求,请检查sheet页");
        }
    }

    @Override
    public String[] readExcelByRow(int sheetNo, int rowNo) throws Exception {
        String[] rowData = null;
        XSSFSheet sheet = this.wb.getSheetAt(sheetNo - 1);
        XSSFRow row = sheet.getRow(rowNo - 1);
        int cellCount = row.getLastCellNum();
        rowData = new String[cellCount];

        for(int k = 1; k <= cellCount; ++k) {
            rowData[k - 1] = this.readExcelByRowAndCell(sheetNo, rowNo, k);
        }

        return rowData;
    }

    @Override
    public String[] readExcelByCell(int sheetNo, int cellNo) throws Exception {
        String[] cellData = null;
        XSSFSheet sheet = this.wb.getSheetAt(sheetNo - 1);
        int rowCount = sheet.getLastRowNum();
        cellData = new String[rowCount + 1];

        for(int i = 0; i <= rowCount; ++i) {
            cellData[i] = this.readExcelByRowAndCell(sheetNo, i, cellNo);
        }

        return cellData;
    }

    @Override
    public void close() {
        if (this.wb != null) {
            try {
                this.wb.close();
            } catch (IOException var5) {
                var5.printStackTrace();
            } finally {
                this.wb = null;
            }
        }

    }
}
