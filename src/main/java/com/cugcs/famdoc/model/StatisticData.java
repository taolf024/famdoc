package com.cugcs.famdoc.model;

public class StatisticData {
    private int HprsNum;
    private int LprsNum;
    private int OverWeight;

    public StatisticData() {
    }

    public int getHprsNum() {
        return HprsNum;
    }

    public void setHprsNum(int hprsNum) {
        HprsNum = hprsNum;
    }

    public int getLprsNum() {
        return LprsNum;
    }

    public void setLprsNum(int lprsNum) {
        LprsNum = lprsNum;
    }

    public int getOverWeight() {
        return OverWeight;
    }

    public void setOverWeight(int overWeight) {
        OverWeight = overWeight;
    }

    public StatisticData(int hprsNum, int lprsNum, int overWeight) {
        HprsNum = hprsNum;
        LprsNum = lprsNum;
        OverWeight = overWeight;
    }
}
