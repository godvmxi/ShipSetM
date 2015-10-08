package com.juntuanyi.www.shipsetm;

/**
 * Created by dandan on 2015/9/27.
 */
public class TankInfo {

    public Integer tankId ;
    public Integer valueType;
    public String strResult;
    public Integer sounding ;
    static public Integer shipId ;
    static Integer soundingMax ;
    static Integer soundingMin ;
    public Object  ref ;
    public TankInfo(Integer tankId) {
        this.tankId = tankId;
    }

    @Override
    public String toString() {
        return "TankInfo{" +
                "tankId=" + tankId +
                ", shipId=" + shipId +
                ", type=" + valueType +
                ", ref=" + ref + " ,result=" + strResult +
                '}';
    }
}
