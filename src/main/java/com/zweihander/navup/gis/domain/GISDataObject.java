package com.zweihander.navup.gis.domain;

import java.util.List;


/**
 *
 * @author Zweihander-GIS
 */

public class GISDataObject 
{
   private String GPSCoordinates = null;
   private String objectName;
   private List<String> GPSTags;
   
   public GISDataObject()
   {
       GPSTags = null;
       objectName = "";
       GPSCoordinates = "0.0,0.0";
   }
   public GISDataObject(String mGPSCoordinates, String mObjectName,List<String> tags)
   {
       GPSCoordinates = mGPSCoordinates;
       objectName = mObjectName ;
       GPSTags = tags;
   }
   public String getGPSCoord() 
   {
        return this.GPSCoordinates;
   }
   public void setGPSCoord(String mGPSCoordinates)
   {
        this.GPSCoordinates = mGPSCoordinates;
   }
   public List<String> getGPSTags() 
   {
        return GPSTags;
   }
   public void setGPSTags(List<String> GPSTags)
   {
        this.GPSTags = GPSTags;
   }
   public void addTag( String tag) 
   {
        this.GPSTags.add(tag);
   }
   public String getObjectName() 
   {
        return objectName;
   }
   public void setObjectName(String objectName) 
   {
        this.objectName = objectName;
   }
}