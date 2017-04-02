package com.zweihander.navup.gis.services;


import com.zweihander.navup.gis.domain.GISDataObject;
import com.zweihander.navup.gis.repositories.GISRepository;

public class GISService {
    //Todo: inject
    GISRepository gisRepository;

    public void addGISDataObject(GISDataObject gisDataObject){
        gisRepository.addGISDataObject(gisDataObject);
    }
}
