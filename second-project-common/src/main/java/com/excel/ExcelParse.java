package com.excel;

import java.io.InputStream;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * @date 2018/8/1 17:15
 */
public class ExcelParse {
    private IExcelParse excelParse = null;

    public ExcelParse() {
    }

    private boolean getInstance(String path) throws Exception {
        path = path.toLowerCase();
        if (path.endsWith(".xls")) {
            this.excelParse = new ExcelParse2003();
        } else {
            if (!path.endsWith(".xlsx")) {
                throw new Exception("对不起，目前系统不支持对该版本Excel文件的解析。");
            }

            this.excelParse = new ExcelParse2007();
        }

        return true;
    }

    public void loadExcel(String filePathAndName) throws Exception {
        this.getInstance(filePathAndName);
        this.excelParse.loadExcel(filePathAndName);
    }

    public void loadExcel(InputStream is, String version) throws Exception {
        if ("xls".equalsIgnoreCase(version)) {
            this.excelParse = new ExcelParse2003();
        } else {
            if (!"xlsx".equalsIgnoreCase(version)) {
                throw new Exception("对不起，目前系统不支持对该版本Excel文件的解析。");
            }

            this.excelParse = new ExcelParse2007();
        }

        this.excelParse.loadExcel(is);
    }

    public String getSheetName(int sheetNo) {
        return this.excelParse.getSheetName(sheetNo);
    }

    public int getSheetCount() throws Exception {
        return this.excelParse.getSheetCount();
    }

    public int getRowCount(int sheetNo) {
        return this.excelParse.getRowCount(sheetNo);
    }

    public int getRealRowCount(int sheetNo) {
        return this.excelParse.getRealRowCount(sheetNo);
    }

    public String readExcelByRowAndCell(int sheetNo, int rowNo, int cellNo) throws Exception {
        return this.excelParse.readExcelByRowAndCell(sheetNo, rowNo, cellNo);
    }

    public String[] readExcelByRow(int sheetNo, int rowNo) throws Exception {
        return this.excelParse.readExcelByRow(sheetNo, rowNo);
    }

    public String[] readExcelByCell(int sheetNo, int cellNo) throws Exception {
        return this.excelParse.readExcelByCell(sheetNo, cellNo);
    }

    public void close() {
        this.excelParse.close();
    }

}
