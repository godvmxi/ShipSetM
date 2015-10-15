package com.juntuanyi.www.shipsetm;

import java.util.Date;
import java.util.List;

/**
 * Created by dandan on 2015/9/27.
 */
public class ShipInfo {
    private Integer shipId ;
    private String  name ;
    private String crt ;
    private Integer tankNumber ;
    private Integer capacityNumber ;
    private String shipTrimValue ;
    private Date validDate ;

    private Integer calType;
    private String version;

    public ShipInfo(){
        this.shipId  = 0;
        this.name = new String();
        this.crt =  new String();
        this.tankNumber = 0;
        this.capacityNumber = 0;
        this.shipTrimValue = new String();
        this.validDate = new  Date();
        this.calType = 1 ;
        this.version = new String("1.0.01");

    }
    public ShipInfo(ShipInfo info){
        this.shipId  = info.getShipId();
        this.name = new String(info.getName());
        this.crt =  new String(info.getCrt());
        this.tankNumber = info.getTankNumber();
        this.capacityNumber =info.getCapacityNumber();
        this.shipTrimValue = info.getShipTrimValue();
        this.validDate = info.getValidDate();
    }

    public Integer getShipId() {
        return shipId;
    }

    public void setShipId(Integer shipId) {
        this.shipId = shipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrt() {
        return crt;
    }

    public void setCrt(String crt) {
        this.crt = crt;
    }

    public Integer getTankNumber() {
        return tankNumber;
    }

    public void setTankNumber(Integer tankNumber) {
        this.tankNumber = tankNumber;
    }

    public Integer getCapacityNumber() {
        return capacityNumber;
    }

    public void setCapacityNumber(Integer capacityNumber) {
        this.capacityNumber = capacityNumber;
    }

    public String getShipTrimValue() {
        return shipTrimValue;
    }

    public void setShipTrimValue(String shipTrimValue) {
        this.shipTrimValue = shipTrimValue;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public Integer getCalType() {
        return calType;
    }

    public void setCalType(Integer calType) {
        this.calType = calType;
    }

    @Override
    public String toString() {
        return "ShipInfo{" +
                "shipId=" + shipId +
                ", name='" + name + '\'' +
                ", crt='" + crt + '\'' +
                ", tankNumber=" + tankNumber +
                ", capacityNumber=" + capacityNumber +
                ", shipTrimValue='" + shipTrimValue + '\'' +
                ", validDate=" + validDate +
                ", calType=" + calType +
                ", version=" + version +
                '}';
    }
}


