package com.wss.lsl.jts.demo;

import java.io.IOException;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.IntersectionMatrix;
import com.vividsolutions.jts.io.OutputStreamOutStream;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKBWriter;
import com.vividsolutions.jts.io.WKTReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParseException, IOException
    {
        System.out.println( "Hello World!" );
        Geometry geometry = new WKTReader().read("LINESTRING (0 0, 10 10, 20 20)");
        
        // eq 
        Coordinate[] coordinates = new Coordinate[]{
        		new Coordinate(0, 0),
        		new Coordinate(10, 10),
        		new Coordinate(20, 20)
        };
        Geometry g2 = new GeometryFactory().createLineString(coordinates);
        Geometry g3 = g2.intersection(geometry);
        
        IntersectionMatrix m = g2.relate(geometry);
        
        new WKBWriter().write(geometry, new OutputStreamOutStream(System.out));
    }
}
