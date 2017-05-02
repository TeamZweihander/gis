package com.zweihander.navup.gis.services;


import com.zweihander.navup.gis.domain.GISDataObject;
import com.zweihander.navup.gis.exceptions.GISObjectNotFoundException;
import com.zweihander.navup.gis.request.GISRequest;
import com.zweihander.navup.gis.response.GISResponse;
import java.util.List;


public interface GISModule 
{
    public GISResponse addGISDataObject(GISRequest request);
    public List<GISDataObject> getAllGISDataObjects();
    public GISDataObject getGISObjectByName(String name)throws GISObjectNotFoundException;;
    public GISDataObject getGISObjectByCoordinates(double lattitude,double longitude)throws GISObjectNotFoundException;
    public List<String> getVenues(String buildingName);
    public List<String> routesBetweenPoints(String pointACoordinates,String pointBCoordinates);
    public String getRouteDetails(String route);
}
