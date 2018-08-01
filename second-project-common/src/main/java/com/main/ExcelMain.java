package com.main;

import com.excel.ExcelParse;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * @date 2018/8/1 17:22
 */
public class ExcelMain {
    public static void main(String[] args) {
        ExcelParse parse = new ExcelParse();

        try {
            parse.loadExcel("C:\\Users\\zhouzhongyi1\\Desktop\\yao.xlsx");
            System.out.println(parse.getSheetCount());
            //去掉表头行
            System.out.println(parse.getRealRowCount(1));
            //去掉表头行
            System.out.println(parse.getRowCount(1));
            System.out.println(parse.getSheetName(2));
            //去掉表头
            System.out.println(parse.readExcelByRowAndCell(2, 2, 4));
            //去掉表头
            String[] var2 = parse.readExcelByRow(1, 1);
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                String str = var2[var4];
                System.out.print(str + " --- ");
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        } finally {
            parse.close();
        }
    }
}
