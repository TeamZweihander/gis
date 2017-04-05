package com.zweihander.navup.gis.domain;

import java.util.List;

/**
 *
 * @author Zweihander-GIS
 */

public class GISDataObject 
{
   private double[] GPSCoord = new double[2];
   private String objectName;
   private List<String> GPSTags;
   
   public GISDataObject()
   {
       GPSTags = null;
       
       for(int i = 0;i<GPSCoord.length;i++)
       {
           GPSCoord[i] = 0.0;
       }
   }
   public GISDataObject(double latitude,double longitude, String mObjectName,List<String> tags)
   {
       GPSCoord[0] = latitude;
       GPSCoord[1] = longitude;
       objectName = mObjectName ;
       GPSTags = tags;
   }
   public double[] getGPSCoord() 
   {
        return this.GPSCoord;
   }
   public void setGPSCoord(double[] GPSCoord)
   {
        this.GPSCoord = GPSCoord;
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