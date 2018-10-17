package com.enummodel;

import lombok.Getter;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * DATE： 2018/9/21 18:08
 */
public enum HolidayEnum {
    /**
    元旦节;New years
    情人节;Valentine's Day
    除夕;YearEve
    春节;Chinese New Year
    元宵节;Lantern Festival
    妇女节;
    清明节;Ching Ming Festival
    儿童节;
    端午节;Dragon Boat Festival
    七夕节;Qixi Festival
    教师节;Teachers' Day
    中秋节;Mid-Autumn Festival
    圣诞节;Christmas
*/

    /**
     * 劳动节
     */
    LaborDay(true, "05-01", "05-01", "劳动节"),
    /**
     * 国庆节
     */
    NationalDay(true, "10-01", "10-07", "国庆节");

    private HolidayEnum(boolean isLunar, String start, String end, String desc) {
        this.isLunar = isLunar;
        this.start = start;
        this.end = end;
        this.desc = desc;
    }

    /**
     * 是否阳历
     */
    @Getter
    private boolean isLunar;
    /**
     * 开始日期
     */
    @Getter
    private String start;
    /**
     * 结束日期
     */
    @Getter
    private String end;

    /**
     * 描述
     */
    @Getter
    private String desc;
}
