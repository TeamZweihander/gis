package com.zweihander.navup.gis.controllers;


import com.zweihander.navup.gis.domain.GISDataObject;
import com.zweihander.navup.gis.exceptions.GISObjectNotFoundException;
import com.zweihander.navup.gis.repositories.GISRepository;
import com.zweihander.navup.gis.services.GISService;
import org.springframework.web.bind.annotation.*;

@RestController
public class GISController {
    // Todo: inject
    GISRepository gisRepository;

    private final GISService gisService = new GISService(); // dependency injection

    @RequestMapping(value = "/gis/getGISDataObject", method = RequestMethod.POST)
    public @ResponseBody
    GISDataObject getGISDOByCoordinates(@RequestBody GISDataObject gisData) {
        if(gisData.getGpsCoords()[0] == 5)
            throw new GISObjectNotFoundException();

        GISDataObject gisDataObject = new GISDataObject();
        gisDataObject.setGpsCoords(gisData.getGpsCoords());

        return gisDataObject;
    }

    @RequestMapping(value = "/gis/addGISDataObject", method = RequestMethod.POST)
    public @ResponseBody GISDataObject addGISDataOBject(@RequestBody GISDataObject gisData) {
        GISDataObject gisDataObject = new GISDataObject(gisData);

        return gisDataObject;
    }
}
