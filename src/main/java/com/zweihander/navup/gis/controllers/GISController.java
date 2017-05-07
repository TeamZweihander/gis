package com.zweihander.navup.gis.controllers;


import java.util.LinkedList;
import java.util.List;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.zweihander.navup.gis.domain.GISDataObject;
import com.zweihander.navup.gis.exceptions.GISObjectNotFoundException;
import com.zweihander.navup.gis.request.GISRequest;
import com.zweihander.navup.gis.response.GISResponse;
import com.zweihander.navup.gis.services.GISModule;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
public class GISController implements GISModule
{
    
    private Connection c = null;
    private Statement stmt = null;
    int id = 0;
    
    
  
    @RequestMapping(value ="/gis/addGISObject")
    public GISResponse addGISDataObject(GISRequest request) 
    {
        GISDataObject GISObject = request.getmGISDataObject();
        int i = 0;
        String sql;
        try {
           
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgis","postgres", "admin");
            stmt = c.createStatement();
            id++;
            
            sql = "INSERT INTO CAMPUS_BUILDINGS (ID,NAME,POLYGONS) "
                    + "VALUES (" + id + ", '" + GISObject.getObjectName() + "','" + GISObject.getGPSCoord() + "' );";
            stmt.executeUpdate(sql);
            
            // do something...
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GISController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GISController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new GISResponse(GISObject);

     }
  
    @RequestMapping(value ="/gis/getAllGISObjects")
    public  @ResponseBody List<GISDataObject> getAllGISDataObjects() 
    {   
        List<GISDataObject> objects = new ArrayList();
        
    
        int i = 1;  
        try {
            
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgis","postgres", "admin");
                
            stmt = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            //stmt = c.prepareStatement("select * from " + "campus_buildings",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            stmt.setMaxRows(100); // bacause of: org.postgresql.util.PSQLException: Ran out of memory retrieving query results.
            ResultSet rs = stmt.executeQuery("select * from " + "campus_buildings"); 
           
         
            while (rs.next()) {

                GISDataObject GISObject = new GISDataObject();
                GISObject.setObjectName(rs.getString(2));
                GISObject.setGPSCoord(rs.getString(3));
                
                objects.add(GISObject);
                
       

                i++;


            }
            
            for(int m=0; m< objects.size();m++)
            {
                //System.out.println("Building name: "+objects.get(m).getObjectName()+"  "+" Coordinates: "+objects.get(m).getGPSCoord());
            }
            
                        
        
          id = i; 
        } catch (SQLException ex) {
            Logger.getLogger(GISController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GISController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objects;
    }
  
    @RequestMapping(value ="/gis/getGISObjectByName")
    public  @ResponseBody GISDataObject  getGISObjectByName(String name)throws GISObjectNotFoundException
    {
        
        GISDataObject GISObject = new GISDataObject();
    
        int i = 0;  
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgis","postgres", "admin");
                
            stmt = c.createStatement();
            stmt.setMaxRows(100); // bacause of: org.postgresql.util.PSQLException: Ran out of memory retrieving query results.
            ResultSet rs = stmt.executeQuery("select * from " + "campus_buildings"); 
           
            for (;;) {
                while (rs.next()) {
                    i++;
                    if(rs.getString("name").equals(name))
                    {
                       GISObject.setObjectName(rs.getString("name"));
                       GISObject.setGPSCoord(rs.getString("polygons")); 
                    }
                    
                }
                if ((stmt.getMoreResults() == false) && (stmt.getUpdateCount() == -1)) {
                    break;
                }           
            }
            id = i;
        } catch (SQLException ex) {
            Logger.getLogger(GISController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GISController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return GISObject;
    }

    @RequestMapping(value ="/gis/getGISObjectByCoordinates")
    public  @ResponseBody GISDataObject  getGISObjectByCoordinates(String coordinates)throws GISObjectNotFoundException
    {
        GISDataObject GISObject = new GISDataObject();       
        System.out.println(coordinates);
        int i = 0;  
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgis","postgres", "admin");
                
            stmt = c.createStatement();
            stmt.setMaxRows(100); // bacause of: org.postgresql.util.PSQLException: Ran out of memory retrieving query results.
            ResultSet rs = stmt.executeQuery("select * from " + "campus_buildings"); 
           
            for (;;) {
                while (rs.next()) {
                    i++;
                   
                    if(rs.getString("polygons").toString().equals(coordinates))
                    {
                       GISObject.setObjectName(rs.getString("name"));
                       GISObject.setGPSCoord(rs.getString("polygons")); 
                    }
                    
                }
                if ((stmt.getMoreResults() == false) && (stmt.getUpdateCount() == -1)) {
                    break;
                }           
            }
            id = i;
        } catch (SQLException ex) {
            Logger.getLogger(GISController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GISController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return GISObject;
    }

    @RequestMapping(value ="/gis/getVenues")
    public  @ResponseBody List<String> getVenues(String buildingName)
    {
        List<String> venues = new ArrayList();
       
    
        int i = 0;  
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgis","postgres", "admin");
                
            stmt = c.createStatement();
            stmt.setMaxRows(100); // bacause of: org.postgresql.util.PSQLException: Ran out of memory retrieving query results.
           
            ResultSet rs = stmt.executeQuery("select * from " + "lecture_halls"); 
           
            for (;;) {
                while (rs.next()) {
                    i++;
                    
                    if(rs.getString("building_name").equals(buildingName))
                    {
                        venues.add(rs.getString("room_name"));
                    }
                    
                    
                }
                if ((stmt.getMoreResults() == false) && (stmt.getUpdateCount() == -1)) {
                    break;
                }           
            }
            id = i;
        } catch (SQLException ex) {
            Logger.getLogger(GISController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GISController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return venues;
    }
    @RequestMapping(value ="/gis/getRoutes")
    public List<String> routesBetweenPoints(String pointACoordinates,String pointBCoordinates)
    {
       return null; 
    }
    @RequestMapping(value ="/gis/getRoutesDetails")
    public String getRouteDetails(String route)
    {
       return null; 
    }
    @RequestMapping(value ="/gis/setID")
    public void setID(int id)
    {
        
        this.id = id;
    }
}
