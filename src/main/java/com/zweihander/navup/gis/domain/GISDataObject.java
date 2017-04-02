package com.zweihander.navup.gis.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GISDataObject implements Serializable{
    private double[] gpsCoords = new double[2];
    private List<String> gpsTags = new ArrayList<>();

    public GISDataObject() {

    }

    public GISDataObject(GISDataObject gisDataObject) {
        this.gpsCoords = gisDataObject.gpsCoords;
        this.gpsTags = gisDataObject.gpsTags;
    }

    public double[] getGpsCoords() {
        return gpsCoords;
    }

    public void setGpsCoords(double[] gpsCoords) {
        this.gpsCoords = gpsCoords;
    }

    public List<String> getGpsTags() {
        return gpsTags;
    }

    public void setGpsTags(List<String> gpsTags) {
        this.gpsTags = gpsTags;
    }
}
