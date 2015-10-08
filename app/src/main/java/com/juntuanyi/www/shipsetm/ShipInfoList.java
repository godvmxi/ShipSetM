package com.juntuanyi.www.shipsetm;

import java.util.List;

/**
 * Created by dandan on 2015/10/8.
 */
public class ShipInfoList {
    private List<ShipInfo> shipInfolist ;
    public  ShipInfoList(){
        this.shipInfolist = new List<ShipInfo> ;

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
    public String toString (){

    }
}
