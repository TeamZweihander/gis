package com.zweihander.navup.gis.repositories;

import com.zweihander.navup.gis.domain.*;

import java.util.List;

// Todo: extend Mongo repositories
public interface GISRepository {
    void addGISDataObject(GISDataObject gisDataObject);
    GISDataObject findOneByCoordinates(String coords);
    GISDataObject findByGPSTags(List<String> tags);
}
