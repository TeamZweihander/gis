package com.zweihander.navup.gis.controllers;


import com.zweihander.navup.gis.domain.GISDataObject;
import com.zweihander.navup.gis.exceptions.GISObjectNotFoundException;
import com.zweihander.navup.gis.request.GISRequest;
import com.zweihander.navup.gis.response.GISResponse;
import com.zweihander.navup.gis.services.GISModule;
import java.util.LinkedList;
import java.util.List;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
public class GISController implements GISModule
{

    @Override
    @RequestMapping(value ="/AddGISObject")
    public GISResponse addGISDataObject(GISRequest request) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value ="/gis/getAllGISObjects")
    public  @ResponseBody List<GISDataObject> getAllGISDataObjects() 
    {
        
        //Below is just a mocked respoonse which is a list of GISObjects, in this case buildings
        List<GISDataObject> buildings = new LinkedList<>();
        
        GISDataObject buildingOne =  new GISDataObject(-25.755682,28.232734,"IT Building",null);
        GISDataObject buildingTwo = new GISDataObject(-25.755097,28.232496,"Economic and Management Sciences building",null);
         
        buildings.add(buildingOne);
        buildings.add(buildingTwo);
        
        return buildings;
    }
    @Override
    @RequestMapping(value ="/gis/getVenues")
    public  @ResponseBody List<String>  getGISObjectByName(String name)throws GISObjectNotFoundException
    {
        List<String> venuesITBuilding = new LinkedList<>();
        List<String> venuesEMSBuilding = new LinkedList<>();
        
        
        // Below are mocked venues for the above mocked buildings 
        
        name = "IT Building";
        
        if(name == "IT Building")
        {
            venuesITBuilding.add("IT 2-23");
            venuesITBuilding.add("IT 2-24");
            venuesITBuilding.add("IT 2-25");
            venuesITBuilding.add("IT 4-1");
            venuesITBuilding.add("IT 4-2");
            venuesITBuilding.add("IT 4-3");
            venuesITBuilding.add("IT 4-4");
            venuesITBuilding.add("301 LABS");
            venuesITBuilding.add("Blackberry Labs");
            
            return venuesITBuilding;
            
        }
        else if(name == "Economic and Management Sciences building")
        {
            
            venuesEMSBuilding.add("Samlum conference center");
            venuesEMSBuilding.add("EMB 2-23");
            venuesEMSBuilding.add("EMB 2-24");
            venuesEMSBuilding.add("EMB 2-25");
            
           return venuesEMSBuilding;
           
            
        }
        else
        {
            throw new GISObjectNotFoundException();
        }
            
     }

}
