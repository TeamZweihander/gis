package com.zweihander.navup.gis.services;


import com.zweihander.navup.gis.domain.GISDataObject;
import com.zweihander.navup.gis.request.GISRequest;
import com.zweihander.navup.gis.response.GISResponse;
import java.util.List;


public interface GISModule 
{
    public GISResponse addGISDataObject(GISRequest request);
    public List<GISDataObject> getAllGISDataObjects();
    public List<String>  getGISObjectByName(String name);
}
