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
    private Float shipTrimMin ;
    private Float shipTrimStep;
    private Date validDate ;

    private Integer calType;
    private String version;

    public ShipInfo(){
        this.shipId  = 0;
        this.name = new String();
        this.crt =  new String();
        this.tankNumber = 0;
        this.capacityNumber = 0;
        this.shipTrimMin =  new Float(0);
        this.shipTrimStep =  new Float(0);

        this.validDate = new  Date();
        this.calType = 0 ;
        this.version = new String("0.0.0");

    }
    public ShipInfo(ShipInfo info){
        this.shipId  = info.getShipId();
        this.name = new String(info.getName());
        this.crt =  new String(info.getCrt());
        this.tankNumber = info.getTankNumber();
        this.capacityNumber =info.getCapacityNumber();

        this.shipTrimMin = info.getShipTrimMin() ;
        this.shipTrimStep = info.getShipTrimStep();
        this.validDate = info.getValidDate();
        this.calType = info.getCalType();
        this.version = info.getVersion();
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

    public Float getShipTrimMin() {
        return shipTrimMin;
    }

    public void setShipTrimMin(Float shipTrimMin) {
        this.shipTrimMin = shipTrimMin;
    }

    public Float getShipTrimStep() {
        return shipTrimStep;
    }

    public void setShipTrimStep(Float shipTrimStep) {
        this.shipTrimStep = shipTrimStep;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "ShipInfo{" +
                "shipId=" + shipId +
                ", name='" + name + '\'' +
                ", crt='" + crt + '\'' +
                ", tankNumber=" + tankNumber +
                ", capacityNumber=" + capacityNumber +
                ", shipTrimMin='" + shipTrimMin + '\'' +
                ", shipTrimStep='" + shipTrimStep + '\'' +
                ", validDate=" + validDate +
                ", calType=" + calType +
                ", version=" + version +
                '}';
    }
}


