package com.excel;

import java.io.InputStream;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * @date 2018/8/1 16:59
 */
public interface IExcelParse {
    void loadExcel(String var1) throws Exception;

    void loadExcel(InputStream var1) throws Exception;

    String getSheetName(int var1);

    int getSheetCount() throws Exception;

    int getRowCount(int var1);

    int getRealRowCount(int var1);

    String readExcelByRowAndCell(int var1, int var2, int var3) throws Exception;

    String[] readExcelByRow(int var1, int var2) throws Exception;

    String[] readExcelByCell(int var1, int var2) throws Exception;

    void close();
}
