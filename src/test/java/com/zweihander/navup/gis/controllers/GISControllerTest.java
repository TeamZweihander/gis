package com.zweihander.navup.gis.controllers;

import com.zweihander.navup.gis.domain.GISDataObject;
import com.zweihander.navup.gis.request.GISRequest;
import com.zweihander.navup.gis.response.GISResponse;
import java.util.List;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Liz Bode
 */
public class GISControllerTest {
    private List<GISDataObject> testGISDataObject;
    private List<TestGISRequest> testRequest;
    
    public GISControllerTest() {
    }

    /**
     * Test of addGISDataObject method, of class GISController.
     */
    @Test
    public void testAddGISDataObject() {
        System.out.println("addGISDataObject");
        GISDataObject building = new GISDataObject("-25.7531839, 28.2287180", "Engineering 1", null);
        GISRequest request = new GISRequest();
        request.setmGISDataObject(building);
        GISController controller = new GISController();
        GISResponse expResult = new GISResponse(building);
        GISResponse result = controller.addGISDataObject(request);
        assertEquals(expResult.getmGISDataObject().getObjectName(), result.getmGISDataObject().getObjectName());
        assertEquals(expResult.getmGISDataObject().getGPSCoord(), result.getmGISDataObject().getGPSCoord());
    }

    /**
     * Test of getAllGISDataObjects method, of class GISController.
     */
//    @Test
//    public void testGetAllGISDataObjects() {
//        System.out.println("getAllGISDataObjects");
//        GISController instance = new GISController();
//        List<GISDataObject> expResult = null;
//        List<GISDataObject> result = instance.getAllGISDataObjects();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getGISObjectByName method, of class GISController.
     */
    @Test
    public void testGetGISObjectByName() {
        System.out.println("getGISObjectByName");
        String name = "IT Building";
        GISController instance = new GISController();
        GISDataObject expResult = new GISDataObject("IT Building", "28.233034,-25.7560391,0,28.233026,-25.7560174,0,28.2330018,-25.7560077,0,28.2329589,-25.7560005,0,28.2328731,-25.7560391,0,28.2324868,-25.7559256,0,28.2324734,-25.7559498,0,28.2322615,-25.7559039,0,28.232165,-25.7557855,0,28.2322642,-25.7554594,0,28.2323098,-25.7554231,0,28.2324949,-25.7554739,0,28.2327604,-25.7555463,0,28.2329589,-25.755585,0,28.2330313,-25.755672,0,28.2330152,-25.7556913,0,28.2330555,-25.7557323,0,28.2330233,-25.7557637,0,28.2330769,-25.7557758,0,28.2330877,-25.7558121,0,28.2331386,-25.7558652,0,28.2332003,-25.7558845,0,28.2332727,-25.7558725,0,28.233313,-25.7558483,0,28.2333398,-25.7557952,0,28.2333639,-25.7557613,0,28.2333398,-25.7557565,0,28.2333371,-25.7557348,0,28.2333639,-25.7557106,0,28.2333961,-25.7557299,0,28.2334229,-25.7557082,0,28.2334685,-25.7557251,0,28.2334819,-25.7557058,0,28.2335812,-25.755742,0,28.2336777,-25.7557855,0,28.2336456,-25.7558338,0,28.2336241,-25.7559039,0,28.233608,-25.7559473,0,28.2336456,-25.7559763,0,28.2336187,-25.7560005,0,28.2335785,-25.7559884,0,28.2335678,-25.7560126,0,28.2335436,-25.7559908,0,28.2335302,-25.7560077,0,28.233549,-25.7560271,0,28.2335114,-25.7560705,0,28.23349,-25.7560536,0,28.2334685,-25.7560657,0,28.2334846,-25.7560826,0,28.2334524,-25.7560947,0,28.2334685,-25.7561358,0,28.2334417,-25.7561527,0,28.2334095,-25.7561213,0,28.2333773,-25.7561358,0,28.233372,-25.756114,0,28.2333532,-25.7561189,0,28.2333586,-25.756143,0,28.2332969,-25.7561551,0,28.2332861,-25.7561309,0,28.2332674,-25.756143,0,28.23327,-25.7561599,0,28.2332459,-25.7561599,0,28.2332271,-25.7561696,0,28.2332137,-25.7562107,0,28.2331923,-25.7561986,0,28.2331976,-25.7561648,0,28.2331789,-25.7561672,0,28.2331601,-25.7561648,0,28.2331654,-25.7561406,0,28.2331413,-25.7561358,0,28.2331279,-25.7561575,0,28.2330716,-25.7561454,0,28.2330796,-25.7561213,0,28.2330582,-25.7561164,0,28.2330447,-25.7561382,0,28.2330152,-25.7561237,0,28.2330126,-25.7560657,0,28.233034,-25.7560391,0", null);
        GISDataObject result = instance.getGISObjectByName(name);
        assertEquals(expResult.getObjectName(), result.getObjectName());
        assertEquals(expResult.getGPSCoord(), result.getGPSCoord());
    }

    /**
     * Test of getGISObjectByCoordinates method, of class GISController.
     */
    @Test
    public void testGetGISObjectByCoordinates() {
        System.out.println("getGISObjectByCoordinates");
        String coordinates = "28.233034,-25.7560391,0,28.233026,-25.7560174,0,28.2330018,-25.7560077,0,28.2329589,-25.7560005,0,28.2328731,-25.7560391,0,28.2324868,-25.7559256,0,28.2324734,-25.7559498,0,28.2322615,-25.7559039,0,28.232165,-25.7557855,0,28.2322642,-25.7554594,0,28.2323098,-25.7554231,0,28.2324949,-25.7554739,0,28.2327604,-25.7555463,0,28.2329589,-25.755585,0,28.2330313,-25.755672,0,28.2330152,-25.7556913,0,28.2330555,-25.7557323,0,28.2330233,-25.7557637,0,28.2330769,-25.7557758,0,28.2330877,-25.7558121,0,28.2331386,-25.7558652,0,28.2332003,-25.7558845,0,28.2332727,-25.7558725,0,28.233313,-25.7558483,0,28.2333398,-25.7557952,0,28.2333639,-25.7557613,0,28.2333398,-25.7557565,0,28.2333371,-25.7557348,0,28.2333639,-25.7557106,0,28.2333961,-25.7557299,0,28.2334229,-25.7557082,0,28.2334685,-25.7557251,0,28.2334819,-25.7557058,0,28.2335812,-25.755742,0,28.2336777,-25.7557855,0,28.2336456,-25.7558338,0,28.2336241,-25.7559039,0,28.233608,-25.7559473,0,28.2336456,-25.7559763,0,28.2336187,-25.7560005,0,28.2335785,-25.7559884,0,28.2335678,-25.7560126,0,28.2335436,-25.7559908,0,28.2335302,-25.7560077,0,28.233549,-25.7560271,0,28.2335114,-25.7560705,0,28.23349,-25.7560536,0,28.2334685,-25.7560657,0,28.2334846,-25.7560826,0,28.2334524,-25.7560947,0,28.2334685,-25.7561358,0,28.2334417,-25.7561527,0,28.2334095,-25.7561213,0,28.2333773,-25.7561358,0,28.233372,-25.756114,0,28.2333532,-25.7561189,0,28.2333586,-25.756143,0,28.2332969,-25.7561551,0,28.2332861,-25.7561309,0,28.2332674,-25.756143,0,28.23327,-25.7561599,0,28.2332459,-25.7561599,0,28.2332271,-25.7561696,0,28.2332137,-25.7562107,0,28.2331923,-25.7561986,0,28.2331976,-25.7561648,0,28.2331789,-25.7561672,0,28.2331601,-25.7561648,0,28.2331654,-25.7561406,0,28.2331413,-25.7561358,0,28.2331279,-25.7561575,0,28.2330716,-25.7561454,0,28.2330796,-25.7561213,0,28.2330582,-25.7561164,0,28.2330447,-25.7561382,0,28.2330152,-25.7561237,0,28.2330126,-25.7560657,0,28.233034,-25.7560391,0";
        GISController instance = new GISController();
        GISDataObject expResult = new GISDataObject("IT Building", "28.233034,-25.7560391,0,28.233026,-25.7560174,0,28.2330018,-25.7560077,0,28.2329589,-25.7560005,0,28.2328731,-25.7560391,0,28.2324868,-25.7559256,0,28.2324734,-25.7559498,0,28.2322615,-25.7559039,0,28.232165,-25.7557855,0,28.2322642,-25.7554594,0,28.2323098,-25.7554231,0,28.2324949,-25.7554739,0,28.2327604,-25.7555463,0,28.2329589,-25.755585,0,28.2330313,-25.755672,0,28.2330152,-25.7556913,0,28.2330555,-25.7557323,0,28.2330233,-25.7557637,0,28.2330769,-25.7557758,0,28.2330877,-25.7558121,0,28.2331386,-25.7558652,0,28.2332003,-25.7558845,0,28.2332727,-25.7558725,0,28.233313,-25.7558483,0,28.2333398,-25.7557952,0,28.2333639,-25.7557613,0,28.2333398,-25.7557565,0,28.2333371,-25.7557348,0,28.2333639,-25.7557106,0,28.2333961,-25.7557299,0,28.2334229,-25.7557082,0,28.2334685,-25.7557251,0,28.2334819,-25.7557058,0,28.2335812,-25.755742,0,28.2336777,-25.7557855,0,28.2336456,-25.7558338,0,28.2336241,-25.7559039,0,28.233608,-25.7559473,0,28.2336456,-25.7559763,0,28.2336187,-25.7560005,0,28.2335785,-25.7559884,0,28.2335678,-25.7560126,0,28.2335436,-25.7559908,0,28.2335302,-25.7560077,0,28.233549,-25.7560271,0,28.2335114,-25.7560705,0,28.23349,-25.7560536,0,28.2334685,-25.7560657,0,28.2334846,-25.7560826,0,28.2334524,-25.7560947,0,28.2334685,-25.7561358,0,28.2334417,-25.7561527,0,28.2334095,-25.7561213,0,28.2333773,-25.7561358,0,28.233372,-25.756114,0,28.2333532,-25.7561189,0,28.2333586,-25.756143,0,28.2332969,-25.7561551,0,28.2332861,-25.7561309,0,28.2332674,-25.756143,0,28.23327,-25.7561599,0,28.2332459,-25.7561599,0,28.2332271,-25.7561696,0,28.2332137,-25.7562107,0,28.2331923,-25.7561986,0,28.2331976,-25.7561648,0,28.2331789,-25.7561672,0,28.2331601,-25.7561648,0,28.2331654,-25.7561406,0,28.2331413,-25.7561358,0,28.2331279,-25.7561575,0,28.2330716,-25.7561454,0,28.2330796,-25.7561213,0,28.2330582,-25.7561164,0,28.2330447,-25.7561382,0,28.2330152,-25.7561237,0,28.2330126,-25.7560657,0,28.233034,-25.7560391,0", null);
        GISDataObject result = instance.getGISObjectByCoordinates(coordinates);
        assertEquals(expResult.getObjectName(), result.getObjectName());
        assertEquals(expResult.getGPSCoord(), result.getGPSCoord());
    }

    /**
     * Test of getVenues method, of class GISController.
     */
//    @Test
//    public void testGetVenues() {
//        System.out.println("getVenues");
//        String buildingName = "";
//        GISController instance = new GISController();
//        List<String> expResult = null;
//        List<String> result = instance.getVenues(buildingName);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of routesBetweenPoints method, of class GISController.
     */
//    @Test
//    public void testRoutesBetweenPoints() {
//        System.out.println("routesBetweenPoints");
//        String pointACoordinates = "";
//        String pointBCoordinates = "";
//        GISController instance = new GISController();
//        List<String> expResult = null;
//        List<String> result = instance.routesBetweenPoints(pointACoordinates, pointBCoordinates);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getRouteDetails method, of class GISController.
     */
//    @Test
//    public void testGetRouteDetails() {
//        System.out.println("getRouteDetails");
//        String route = "";
//        GISController instance = new GISController();
//        String expResult = "";
//        String result = instance.getRouteDetails(route);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     *
     * @author Zweihander-GIS
     */
    public class TestGISRequest 
    {
        private GISDataObject mGISDataObject;

        public TestGISRequest()
        {
            mGISDataObject = null;
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

    
}
