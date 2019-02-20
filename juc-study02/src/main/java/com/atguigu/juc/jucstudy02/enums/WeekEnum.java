package com.atguigu.juc.jucstudy02.enums;

import lombok.Getter;

import javax.swing.plaf.nimbus.State;

public enum WeekEnum
{
    ONE(1,"周一"),TWO(2,"周二"),THREE(3,"周三"),FOUR(4,"周四"),FIVE(5,"周五"),SIX(6,"周六"),SEVEN(7,"周日");

    @Getter private Integer retCode;
    @Getter private String  retMessage;

    WeekEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static WeekEnum forEach_WeekEnum(int index)
    {
        WeekEnum[] myArray = WeekEnum.values();
        for (WeekEnum weekEnum : myArray)
        {
            if(index == weekEnum.getRetCode())
            {
                return weekEnum;
            }
        }
        return null;
    }
}
