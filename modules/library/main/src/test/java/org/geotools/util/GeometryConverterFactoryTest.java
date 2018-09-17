/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2002-2008, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.util;

import junit.framework.TestCase;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.CoordinateXYM;
import org.locationtech.jts.geom.CoordinateXYZM;
import org.locationtech.jts.geom.Envelope;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

/** @source $URL$ */
public class GeometryConverterFactoryTest extends TestCase {

    GeometryConverterFactory factory;

    protected void setUp() throws Exception {
        factory = new GeometryConverterFactory();
    }

    public void testEnvelopeToGeometry() throws Exception {
        Geometry geometry =
                factory.createConverter(Envelope.class, Geometry.class, null)
                        .convert(
                                new Envelope(new Coordinate(0, 0), new Coordinate(1, 1)),
                                Geometry.class);
        assertNotNull(geometry);
        assertTrue(
                new GeometryFactory()
                        .createPolygon(
                                new GeometryFactory()
                                        .createLinearRing(
                                                new Coordinate[] {
                                                    new Coordinate(0, 0),
                                                    new Coordinate(1, 0),
                                                    new Coordinate(1, 1),
                                                    new Coordinate(0, 1),
                                                    new Coordinate(0, 0)
                                                }),
                                null)
                        .equalsTopo(geometry));
    }

    public void testGeometryToEnvelope() throws Exception {
        Envelope envelope =
                factory.createConverter(Geometry.class, Envelope.class, null)
                        .convert(
                                new GeometryFactory()
                                        .createPolygon(
                                                new GeometryFactory()
                                                        .createLinearRing(
                                                                new Coordinate[] {
                                                                    new Coordinate(0, 0),
                                                                    new Coordinate(1, 0),
                                                                    new Coordinate(1, 1),
                                                                    new Coordinate(0, 1),
                                                                    new Coordinate(0, 0)
                                                                }),
                                                null),
                                Envelope.class);

        assertEquals(new Envelope(new Coordinate(0, 0), new Coordinate(1, 1)), envelope);
    }

    public void testStringToGeometry() throws Exception {
        Geometry geometry =
                factory.createConverter(String.class, Geometry.class, null)
                        .convert("POLYGON((0 0, 1 0, 1 1, 0 1, 0 0))", Geometry.class);
        assertNotNull(geometry);
        assertTrue(
                new GeometryFactory()
                        .createPolygon(
                                new GeometryFactory()
                                        .createLinearRing(
                                                new Coordinate[] {
                                                    new Coordinate(0, 0),
                                                    new Coordinate(1, 0),
                                                    new Coordinate(1, 1),
                                                    new Coordinate(0, 1),
                                                    new Coordinate(0, 0)
                                                }),
                                null)
                        .equalsTopo(geometry));
    }

    public void testGeometryToString() throws Exception {
        String wkt =
                factory.createConverter(Geometry.class, String.class, null)
                        .convert(
                                new GeometryFactory()
                                        .createPolygon(
                                                new GeometryFactory()
                                                        .createLinearRing(
                                                                new Coordinate[] {
                                                                    new Coordinate(0, 0),
                                                                    new Coordinate(1, 0),
                                                                    new Coordinate(1, 1),
                                                                    new Coordinate(0, 1),
                                                                    new Coordinate(0, 0)
                                                                }),
                                                null),
                                String.class);

        assertEquals("POLYGON ((0 0, 1 0, 1 1, 0 1, 0 0))", wkt);
    }

    /** Tests measure (M) coordinate value on Point */
    @Test
    public void testPointMToString() throws Exception {
        GeometryFactory gf = new GeometryFactory();
        String wkt =
                factory.createConverter(Geometry.class, String.class, null)
                        .convert(gf.createPoint(new CoordinateXYM(1, 1, 4)), String.class);
        assertEquals("POINT (1 1 0 4)", wkt);
    }

    /** Tests measure (M) coordinate value on Point */
    @Test
    public void testPointZMToString() throws Exception {
        GeometryFactory gf = new GeometryFactory();
        String wkt =
                factory.createConverter(Geometry.class, String.class, null)
                        .convert(gf.createPoint(new CoordinateXYZM(1, 1, 1, 4)), String.class);
        assertEquals("POINT (1 1 1 4)", wkt);
    }

    /** Tests measure (M) coordinate value on LineString */
    @Test
    public void testLineMToString() throws Exception {
        GeometryFactory gf = new GeometryFactory();
        String wkt =
                factory.createConverter(Geometry.class, String.class, null)
                        .convert(
                                gf.createLineString(
                                        new CoordinateXYM[] {
                                            new CoordinateXYM(1, 1, 4), new CoordinateXYM(2, 2, 4)
                                        }),
                                String.class);
        assertEquals("LINESTRING (1 1 0 4, 2 2 0 4)", wkt);
    }

    /** Tests measure (M) coordinate value on Polygon */
    @Test
    public void testPolygonMToString() throws Exception {
        GeometryFactory gf = new GeometryFactory();
        String wkt =
                factory.createConverter(Geometry.class, String.class, null)
                        .convert(
                                gf.createPolygon(
                                        new CoordinateXYM[] {
                                            new CoordinateXYM(1, 1, 4),
                                            new CoordinateXYM(1, 2, 4),
                                            new CoordinateXYM(2, 1, 4),
                                            new CoordinateXYM(1, 1, 4)
                                        }),
                                String.class);
        assertEquals("POLYGON ((1 1 0 4, 1 2 0 4, 2 1 0 4, 1 1 0 4))", wkt);
    }
}
