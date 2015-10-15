package com.juntuanyi.www.shipsetm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dandan on 2015/10/8.
 */
public class ShipInfoList {
    private List<ShipInfo> shipInfolist ;
    public  ShipInfoList(){
        this.shipInfolist = new ArrayList<ShipInfo>();

    }
    public Boolean  appendShipInfo(ShipInfo shipInfo){
        ShipInfo newShip = new ShipInfo(shipInfo);
        this.shipInfolist.add(newShip);
        return true ;
    }
    public Boolean clearList(){
        shipInfolist.clear();
        return true;
    }
    public Boolean removeShipInfo(Integer shipId){
        return true ;
    }
    public Integer size(){
        return shipInfolist.size();
    }
    @Override
    public String toString() {
        String ret = new String("ShipInfoList{" +
                "shipInfolist=");
        for (int i = 0;i<shipInfolist.size();i++){
            ret = ret + "   "+ ((ShipInfo)(shipInfolist.get(i))).toString();
        }
        return ret ;
    }
}
