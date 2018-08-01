package com.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

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
 * @date 2018/8/1 17:01
 */
public class ExcelParse2003 implements IExcelParse{
    private HSSFWorkbook wb = null;

    public ExcelParse2003() {
    }

    @Override
    public void loadExcel(String filePathAndName) throws FileNotFoundException, IOException {
        FileInputStream fis = null;
        POIFSFileSystem fs = null;

        try {
            fis = new FileInputStream(filePathAndName);
            fs = new POIFSFileSystem(fis);
            this.wb = new HSSFWorkbook(fs);
        } catch (FileNotFoundException var9) {
            var9.printStackTrace();
            throw new FileNotFoundException("加载Excel文件失败：" + var9.getMessage());
        } catch (IOException var10) {
            var10.printStackTrace();
            throw new IOException("加载Excel文件失败：" + var10.getMessage());
        } finally {
            if (fis != null) {
                fis.close();
                fis = null;
            }
            if (fs != null) {
                fs.close();
            }
        }
    }

    @Override
    public void loadExcel(InputStream is) throws Exception {
        this.wb = new HSSFWorkbook(is);
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
        HSSFSheet sheet = this.wb.getSheetAt(sheetNo - 1);
        rowCount = sheet.getLastRowNum();
        return rowCount;
    }
    @Override
    public int getRealRowCount(int sheetNo) {
        int rowCount = 0;
        int rowNum = 0;
        HSSFSheet sheet = this.wb.getSheetAt(sheetNo - 1);
        rowCount = sheet.getLastRowNum();
        if (rowCount == 0) {
            return rowCount;
        } else {
            HSSFRow row = null;
            HSSFCell cell = null;
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
        --sheetNo;
        HSSFSheet sheet = this.wb.getSheetAt(sheetNo);
        String sheetName = this.wb.getSheetName(sheetNo);

        try {
            HSSFRow row = sheet.getRow(rowNo);
            if (row == null) {
                return "";
            } else {
                HSSFCell cell = row.getCell(cellNo - 1);
                if (cell == null) {
                    return "";
                } else {
                    int cellType = cell.getCellType();
                    double d;
                    if (cellType == 0) {
                        if (HSSFDateUtil.isCellDateFormatted(cell)) {
                            d = cell.getNumericCellValue();
                            Date date = HSSFDateUtil.getJavaDate(d);
                            Timestamp timestamp = new Timestamp(date.getTime());
                            String temp = timestamp.toString();
                            if (temp.endsWith("00:00:00.0")) {
                                rowCellData = temp.substring(0, temp.lastIndexOf("00:00:00.0"));
                            } else if (temp.endsWith(".0")) {
                                rowCellData = temp.substring(0, temp.lastIndexOf(".0"));
                            } else {
                                rowCellData = timestamp.toString();
                            }
                        } else {
                            rowCellData = (new DecimalFormat("0.########")).format(cell.getNumericCellValue());
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
                    } else if (cellType == 5) {
                        rowCellData = "";
                    }

                    return rowCellData;
                }
            }
        } catch (Exception var15) {
            var15.printStackTrace();
            throw new Exception(sheetName + "sheet页中" + "第" + rowNo + "行" + "第" + cellNo + "列" + "数据不符合要求,请检查sheet页");
        }
    }
    @Override
    public String[] readExcelByRow(int sheetNo, int rowNo) throws Exception {
        String[] rowData = null;
        HSSFSheet sheet = this.wb.getSheetAt(sheetNo - 1);
        HSSFRow row = sheet.getRow(rowNo - 1);
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
        HSSFSheet sheet = this.wb.getSheetAt(sheetNo - 1);
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
                this.wb = null;
            } catch (IOException var2) {
                var2.printStackTrace();
            }
        }

    }
}
