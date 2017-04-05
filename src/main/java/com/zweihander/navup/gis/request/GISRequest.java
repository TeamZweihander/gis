package com.zweihander.navup.gis.request;


import com.zweihander.navup.gis.domain.GISDataObject;
/**
 *
 * @author Zweihander-GIS
 */
public class GISRequest 
{
    private GISDataObject mGISDataObject;
    
    public GISRequest()
    {
        mGISDataObject = null;
    }
    public GISDataObject getmGISDataObject() 
    {
        return mGISDataObject;
    }
    public void setmGISDataObject(GISDataObject mGISDataObject) 
    {
        this.mGISDataObject = mGISDataObject;
    }
}
