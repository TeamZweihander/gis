package com.zweihander.navup.gis;


import com.zweihander.navup.gis.controllers.GISController;
import com.zweihander.navup.gis.domain.GISDataObject;
import com.zweihander.navup.gis.request.GISRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


@EnableAutoConfiguration
@ComponentScan("com.zweihander.navup.gis")
public class GisApplication {
    
    
        private static int id = 0;
    
        
	public static void createBuild()
	{
		BufferedReader  reader = null;
		try {
			reader = new BufferedReader (new FileReader("db_csv/build.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	      //Read CSV line by line and use the string array as you want
	      String nextLine;
	      List<String> buildingNames = new ArrayList<String>();
	      List<String> polygons = new ArrayList<String>();
	      try {
			while ((nextLine = reader.readLine()) != null) {
			     if (nextLine != null) {
			        //Verifying the read data here
			    	 
			    	 String[] oneSeparatedLine = nextLine.toString().split("\"");
			    	 buildingNames.add(oneSeparatedLine[2].replace(",", ""));
			    	 polygons.add(oneSeparatedLine[1]);
			     }
			   }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      Connection c = null;
	       Statement stmt = null;
	       try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/postgis",
	            "postgres", "admin");
	         System.out.println("Opened database successfully");
	         stmt = c.createStatement();
	         String sql = "CREATE TABLE BUILD " +
                     "(ID INT PRIMARY KEY     NOT NULL," +
                     " NAME           TEXT    NOT NULL, " +
                     " POLYGONS       TEXT     NOT NULL)";
	         stmt.executeUpdate(sql);
	         stmt = c.createStatement();
	         for (int i = 0; i < buildingNames.size(); i++)
			 {
	        	 sql = "INSERT INTO BUILD (ID,NAME,POLYGONS) "
		                 + "VALUES (" + i + ", '" + buildingNames.get(i) + "','" + polygons.get(i) + "' );";
		         stmt.executeUpdate(sql);
			 }
	         id++;
	         stmt.close();
	         c.close();
	       } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         //System.exit(0);
	       }
	       System.out.println("Table created successfully");
	}
	
	public static void createBuildingEntrances()
	{
		BufferedReader  reader = null;
		try {
			reader = new BufferedReader (new FileReader("db_csv/building_entrances.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	      //Read CSV line by line and use the string array as you want
	      String nextLine;
	      List<String> entranceNames = new ArrayList<String>();
	      List<String> latitude = new ArrayList<String>();
	      List<String> longitude = new ArrayList<String>();
	      try {
			while ((nextLine = reader.readLine()) != null) {
			     if (nextLine != null) {
			        //Verifying the read data here
			    	 
			    	 String[] oneSeparatedLine = nextLine.toString().split(",");
			    	 latitude.add(oneSeparatedLine[0]);
			    	 longitude.add(oneSeparatedLine[1]);
			    	 entranceNames.add(oneSeparatedLine[4]);
			     }
			   }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      Connection c = null;
	       Statement stmt = null;
	       try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/postgis",
	            "postgres", "admin");
	         System.out.println("Opened database successfully");
	         stmt = c.createStatement();
	         String sql = "CREATE TABLE BUILDING_ENTRANCES " +
                     "(ID INT PRIMARY KEY     NOT NULL," +
                     " NAME           TEXT    NOT NULL, " +
                     " LATITUDE       TEXT     NOT NULL, " +
                     " LONGITUDE      TEXT)";
	         stmt.executeUpdate(sql);

	         
	         for (int i = 0; i < entranceNames.size(); i++)
			 {
	        	 sql = "INSERT INTO BUILDING_ENTRANCES (ID,NAME,LATITUDE,LONGITUDE) "
		                 + "VALUES (" + i + ", '" + entranceNames.get(i) + "','" + latitude.get(i) + "','" + longitude.get(i) +"');";
		         stmt.executeUpdate(sql);
			 }
	         
	         stmt.close();
	         c.close();
	       } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         //System.exit(0);
	       }
	       System.out.println("Table created successfully");
	}
	
	public static void createCampusBuildings()
	{
		BufferedReader  reader = null;
		try {
			reader = new BufferedReader (new FileReader("db_csv/campus_buildings.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
		//Read CSV line by line and use the string array as you want
	      String nextLine;
	      List<String> buildingNames = new ArrayList<String>();
	      List<String> polygons = new ArrayList<String>();
	      try {
			while ((nextLine = reader.readLine()) != null) {
			     if (nextLine != null) {
			        //Verifying the read data here
			    	 
			    	 String[] oneSeparatedLine = nextLine.toString().split("\"");
			    	 buildingNames.add(oneSeparatedLine[2].replace(",", ""));
			    	 polygons.add(oneSeparatedLine[1]);
			     }
			   }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      Connection c = null;
	       Statement stmt = null;
	       try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/postgis",
	            "postgres", "admin");
	         System.out.println("Opened database successfully");
	         stmt = c.createStatement();
	         String sql = "CREATE TABLE CAMPUS_BUILDINGS " +
                     "(ID INT PRIMARY KEY     NOT NULL," +
                     " NAME           TEXT    NOT NULL, " +
                     " POLYGONS       TEXT     NOT NULL)";
	         stmt.executeUpdate(sql);
	         for (int i = 0; i < buildingNames.size(); i++)
			 {
	        	 sql = "INSERT INTO CAMPUS_BUILDINGS (ID,NAME,POLYGONS) "
		                 + "VALUES (" + i + ", '" + buildingNames.get(i) + "','" + polygons.get(i) + "' );";
		         stmt.executeUpdate(sql);
                         id =i ;
			 }
	         
	         stmt.close();
	         c.close();
	       } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         //System.exit(0);
	       }
	       System.out.println("Table created successfully");
	}
	
	public static void createLectureHallsL2()
	{
		BufferedReader  reader = null;
		try {
			reader = new BufferedReader (new FileReader("db_csv/lecture_halls_l2.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
		//Read CSV line by line and use the string array as you want
	      String nextLine;
	      List<String> buildingNames = new ArrayList<String>();
	      List<String> roomNames = new ArrayList<String>();
	      List<String> polygons = new ArrayList<String>();
	      List<String> ids = new ArrayList<String>();
	      List<String> levels = new ArrayList<String>();
	      try {
			while ((nextLine = reader.readLine()) != null) {
			     if (nextLine != null) {			    	 
			    	 String[] oneSeparatedLine = nextLine.toString().split("\"");
			    	 String[] others = oneSeparatedLine[2].split(",");
			    	 buildingNames.add(others[3]);
			    	 roomNames.add(others[2]);
			    	 ids.add(others[1]);
			    	 levels.add(others[4]);
			    	 polygons.add(oneSeparatedLine[1]);
			     }
			   }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      Connection c = null;
	       Statement stmt = null;
	       try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/postgis",
	            "postgres", "admin");
	         System.out.println("Opened database successfully");
	         stmt = c.createStatement();
	         String sql = "CREATE TABLE LECTURE_HALLS " +
                     "(ID INT PRIMARY KEY     NOT NULL," +
	         		   " ROOM_NAME           TEXT    NOT NULL, " +
                     " BUILDING_NAME           TEXT    NOT NULL, " +
	         		   " LEVEL           INT    NOT NULL, " +
                     " POLYGONS       TEXT     NOT NULL)";
	         stmt.executeUpdate(sql);
	         for (int i = 0; i < buildingNames.size(); i++)
			 {
	        	 sql = "INSERT INTO LECTURE_HALLS (ID,ROOM_NAME,BUILDING_NAME,LEVEL,POLYGONS) "
		                 + "VALUES (" + ids.get(i) + ",'" + roomNames.get(i) + "','" + buildingNames.get(i) + "', " + levels.get(i) + ",'" + polygons.get(i) + "' );";
		         stmt.executeUpdate(sql);
			 }
	         
	         stmt.close();
	         c.close();
	       } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         //System.exit(0);
	       }
	       System.out.println("Table created successfully");
	}

    public GisApplication() {
    }
	
	public static void createLectureHallsL3()
	{
		BufferedReader  reader = null;
		try {
			reader = new BufferedReader (new FileReader("db_csv/lecture_halls_l3.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
		//Read CSV line by line and use the string array as you want
	      String nextLine;
	      List<String> buildingNames = new ArrayList<String>();
	      List<String> roomNames = new ArrayList<String>();
	      List<String> polygons = new ArrayList<String>();
	      List<String> ids = new ArrayList<String>();
	      List<String> levels = new ArrayList<String>();
	      try {
			while ((nextLine = reader.readLine()) != null) {
			     if (nextLine != null) {			    	 
			    	 String[] oneSeparatedLine = nextLine.toString().split("\"");
			    	 String[] others = oneSeparatedLine[2].split(",");
			    	 buildingNames.add(others[3]);
			    	 roomNames.add(others[2]);
			    	 ids.add(others[1]);
			    	 levels.add(others[4]);
			    	 polygons.add(oneSeparatedLine[1]);
			     }
			   }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      Connection c = null;
	       Statement stmt = null;
	       try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/postgis",
	            "postgres", "admin");
	         System.out.println("Opened database successfully");
	         stmt = c.createStatement();
	         String sql = "CREATE TABLE LECTURE_HALLS " +
                     "(ID INT PRIMARY KEY     NOT NULL," +
	         		   " ROOM_NAME           TEXT    NOT NULL, " +
                     " BUILDING_NAME           TEXT    NOT NULL, " +
	         		   " LEVEL           INT    NOT NULL, " +
                     " POLYGONS       TEXT     NOT NULL)";
	         stmt.executeUpdate(sql);
	         for (int i = 0; i < buildingNames.size(); i++)
			 {
	        	 sql = "INSERT INTO LECTURE_HALLS (ID,ROOM_NAME,BUILDING_NAME,LEVEL,POLYGONS) "
		                 + "VALUES (" + ids.get(i) + ",'" + roomNames.get(i) + "','" + buildingNames.get(i) + "', " + levels.get(i) + ",'" + polygons.get(i) + "' );";
		         stmt.executeUpdate(sql);
			 }
	         
	         stmt.close();
	         c.close();
	       } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         //System.exit(0);
	       }
	       System.out.println("Table created successfully");
	}
	
	public static void createStairs()
	{
		BufferedReader  reader = null;
		try {
			reader = new BufferedReader (new FileReader("db_csv/stairs.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	      //Read CSV line by line and use the string array as you want
	      String nextLine;
	      List<String> buildingsNames = new ArrayList<String>();
	      List<String> levels = new ArrayList<String>();
	      List<String> positions = new ArrayList<String>();
	      List<String> latitude = new ArrayList<String>();
	      List<String> longitude = new ArrayList<String>();
	      List<String> ids = new ArrayList<String>();
	      try {
			while ((nextLine = reader.readLine()) != null) {
			     if (nextLine != null) {
			        //Verifying the read data here
			    	 
			    	 String[] oneSeparatedLine = nextLine.toString().split(",");
			    	 latitude.add(oneSeparatedLine[0]);
			    	 longitude.add(oneSeparatedLine[1]);
			    	 buildingsNames.add(oneSeparatedLine[7]);
			    	 levels.add(oneSeparatedLine[5]);
			    	 positions.add(oneSeparatedLine[6]);
			    	 ids.add(oneSeparatedLine[4]);
			     }
			   }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      Connection c = null;
	       Statement stmt = null;
	       try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/postgis",
	            "postgres", "admin");
	         System.out.println("Opened database successfully");
	         stmt = c.createStatement();
	         String sql = "CREATE TABLE STAIRS " +
                     "(ID INT PRIMARY KEY     NOT NULL," +
                     " BUILDING_NAME           TEXT    NOT NULL, " +
                     " LEVEL           TEXT    NOT NULL, " +
                     " POSITION           TEXT    NOT NULL, " +
                     " LATITUDE       TEXT     NOT NULL, " +
                     " LONGITUDE      TEXT)";
	         stmt.executeUpdate(sql);

	         
	         for (int i = 0; i < buildingsNames.size(); i++)
			 {
	        	 sql = "INSERT INTO STAIRS (ID,BUILDING_NAME,LEVEL,POSITION,LATITUDE,LONGITUDE) "
		                  + "VALUES (" + i + ", '" + buildingsNames.get(i) + "','" + levels.get(i) + "', '" + positions.get(i) + "','" + latitude.get(i) + "','" + longitude.get(i) +"');";
		         stmt.executeUpdate(sql);
			 }
	         
	         stmt.close();
	         c.close();
	       } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         //System.exit(0);
	       }
	       System.out.println("Table created successfully");
	}
	
	public static void createLectureWalls()
	{
		BufferedReader  reader = null;
		try {
			reader = new BufferedReader (new FileReader("db_csv/lecture_walls.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
		//Read CSV line by line and use the string array as you want
	      String nextLine;
	      List<String> buildingNames = new ArrayList<String>();
	      List<String> roomNames = new ArrayList<String>();
	      List<String> polygons = new ArrayList<String>();
	      List<String> ids = new ArrayList<String>();
	      List<String> levels = new ArrayList<String>();
	      try {
			while ((nextLine = reader.readLine()) != null) {
			     if (nextLine != null) {			    	 
			    	 String[] oneSeparatedLine = nextLine.toString().split("\"");
			    	 String[] others = oneSeparatedLine[2].split(",");
			    	 buildingNames.add(others[3]);
			    	 roomNames.add(others[2]);
			    	 ids.add(others[1]);
			    	 levels.add(others[4]);
			    	 polygons.add(oneSeparatedLine[1]);
			     }
			   }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      Connection c = null;
	       Statement stmt = null;
	       try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/postgis",
	            "postgres", "admin");
	         System.out.println("Opened database successfully");
	         stmt = c.createStatement();
	         String sql = "CREATE TABLE LECTURE_WALLS " +
                     "(ID INT PRIMARY KEY     NOT NULL," +
	         		   " ROOM_NAME           TEXT    NOT NULL, " +
                     " BUILDING_NAME           TEXT    NOT NULL, " +
	         		   " LEVEL           INT    NOT NULL, " +
                     " POLYGONS       TEXT     NOT NULL)";
	         stmt.executeUpdate(sql);
	         for (int i = 0; i < buildingNames.size(); i++)
			 {
	        	 sql = "INSERT INTO LECTURE_WALLS (ID,ROOM_NAME,BUILDING_NAME,LEVEL,POLYGONS) "
		                 + "VALUES (" + ids.get(i) + ",'" + roomNames.get(i) + "','" + buildingNames.get(i) + "', " + levels.get(i) + ",'" + polygons.get(i) + "' );";
		         stmt.executeUpdate(sql);
			 }
	         
	         stmt.close();
	         c.close();
	       } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         //System.exit(0);
	       }
	       System.out.println("Table created successfully");
	}
       
	public static void populateDatabase()
	{
		createBuild();
		createBuildingEntrances();
		createCampusBuildings();
		createLectureHallsL2();
		createLectureHallsL3();
		createLectureWalls();
		createStairs();
                
               
             
        }
        public static void main(String[] args) {
            
            // Populate the GIS database in bulk from csv files 
            
//            populateDatabase();
                
                
                
            GISController controller = new GISController();
            List<GISDataObject> buildings = null;
            List<String> venues = new ArrayList();
            Scanner input = new Scanner(System.in);
            String buildingName = "";
            String buildingName_venues = "";
            
            controller.setID(id);
            GISDataObject building1 = new GISDataObject();
            GISDataObject building2 = new GISDataObject();
            GISDataObject building3 = new GISDataObject();
            GISDataObject building4 = new GISDataObject();
            
            //Adding GIS objects
            
            building1.setObjectName("Natural sciences");
            building1.setGPSCoord("23.6577543,21.5467523");
            GISRequest request1 = new GISRequest();
            request1.setmGISDataObject(building1);
            
            controller.addGISDataObject(request1);
            
            building2.setObjectName("Aula");
            building2.setGPSCoord("24.6577553,22.5467556");
            GISRequest request2 = new GISRequest();
            request2.setmGISDataObject(building2);
            
            controller.addGISDataObject(request2);
            
            
            
            // Get all GIS objects from the database
            
            buildings = controller.getAllGISDataObjects();
            
            for(int i=0; i< buildings.size();i++)
            {
                System.out.println("Building name: "+buildings.get(i).getObjectName()+"  "+" Coordinates: "+buildings.get(i).getGPSCoord());
            }
            
            // Search for GIS object by coordinates 
           
            building2 = controller.getGISObjectByCoordinates("28.2322615, -25.7550149");
            System.out.println("Building name after search by coordinates: " +building2.getObjectName());
            
            System.out.println("Please enter building name: ");
            buildingName = input.nextLine();
            
            building2 = controller.getGISObjectByName(buildingName);
            System.out.println("Building name after search by name: " +building2.getObjectName());
            
            System.out.println("Please enter building name to get venues: ");
            buildingName_venues = input.nextLine();
            venues = controller.getVenues(buildingName_venues);
            
            System.out.println("List of venues for "+buildingName_venues);
            for(int i=0; i< venues.size();i++)
            {
               System.out.println(venues.get(i)); 
            }
            
            //  Search for building by name
                
            SpringApplication.run(GisApplication.class, args);
	}
}
