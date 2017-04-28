package com.zweihander.navup.gis;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.postgresql.*;
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


@EnableAutoConfiguration
@ComponentScan("com.zweihander.navup.gis")
public class GisApplication {
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
	         
	         stmt.close();
	         c.close();
	       } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
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
			for (int i = 0; i < entranceNames.size(); i++)
			{
				System.out.println("Building: " + entranceNames.get(i) + " Latitude: " + latitude.get(i));
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
	         System.exit(0);
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
			 }
	         
	         stmt.close();
	         c.close();
	       } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
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
	         System.exit(0);
	       }
	       System.out.println("Table created successfully");
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
	         System.exit(0);
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
	         System.exit(0);
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
	         System.exit(0);
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
		populateDatabase();
		SpringApplication.run(GisApplication.class, args);
	}
}
