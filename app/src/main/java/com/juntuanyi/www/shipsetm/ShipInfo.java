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

    public ShipInfo(){

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
}


