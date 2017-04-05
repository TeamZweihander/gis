package com.zweihander.navup.gis.response;

import com.zweihander.navup.gis.domain.GISDataObject;
/**
 *
 * @author Zweihander-GIS
 */
public class GISResponse  
{
    private GISDataObject mGISDataObject;
    
    public GISResponse()
    {
        mGISDataObject = null;
    }
    public GISResponse(GISDataObject sGISDataObject)
    {
        mGISDataObject = sGISDataObject;
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
