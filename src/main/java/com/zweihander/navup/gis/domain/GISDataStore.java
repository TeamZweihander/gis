package com.zweihander.navup.gis.domain;


import com.sun.javafx.scene.control.skin.VirtualFlow;
import com.zweihander.navup.gis.request.GISRequest;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Zweihander-GIS
 */

public class GISDataStore 
{
   
    private List<GISDataObject> gisDataObjects = new LinkedList<>();
    
    public GISDataStore()
    {}
    public  GISDataStore(GISDataObject mGisDataObject)
    {
       gisDataObjects.add(mGisDataObject);
    }
    public GISDataObject getGISDataObject(GISRequest mGISRequest)
    {
       for(int i=0;i< gisDataObjects.size();i++)
       {
           if(gisDataObjects.get(i)== mGISRequest.getmGISDataObject())
           {
               return gisDataObjects.get(i);
           }
       }
       return null;
    }
    public GISDataObject modifyGISData(GISDataObject mGisDataObject)
    {
       return null;
    }
}
