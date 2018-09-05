/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2015 - 2016, Open Source Geospatial Foundation (OSGeo)
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
package org.geotools.xml;

import java.io.StringWriter;
import javax.xml.namespace.QName;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.helpers.NamespaceSupport;

/**
 * XML related utilities not otherwise found in base libraries
 *
 * @author Andrea Aime - GeoSolutions
 */
public class XMLUtils {

    /**
     * Checks the string for XML invalid chars, and in case any is found, create a copy with the
     * invalid ones removed.
     *
     * @param input
     * @return
     */
    public static String removeXMLInvalidChars(String in) {
        // sanity check
        if (in == null || ("".equals(in))) {
            return in;
        }

        // verify if valid
        final int lenght = in.length();
        int invalid = 0;
        for (int i = 0; i < lenght; i++) {
            final char current = in.charAt(i);
            if (!isXMLValidChar(current)) {
                invalid++;
            }
        }

        if (invalid > 0) {
            StringBuilder out = new StringBuilder(in.length() - invalid);
            for (int i = 0; i < lenght; i++) {
                final char current = in.charAt(i);
                if (isXMLValidChar(current)) {
                    out.append(current);
                }
            }
            in = out.toString();
        }

        return in;
    }

    /**
     * Creates a qualified name from a string by parsing out the colon as the prefix / local
     * separator.
     *
     * @param name The possibly qualified name.
     * @param namespaces The namespace prefix uri mappings.
     */
    public static QName qName(String name, NamespaceSupport namespaces) {
        int dot = name.indexOf(':');
        if (dot > -1) {
            String[] split = name.split(":");
            String prefix = split[0];
            String local = split[1];

            return new QName(namespaces.getURI(prefix), local, prefix);
        }

        return new QName(name);
    }

    /**
     * Returns true if the character provided is valid according to XML 1.0
     *
     * @param c
     * @return
     */
    private static boolean isXMLValidChar(char c) {
        return (c == 0x9)
                || (c == 0xA)
                || (c == 0xD)
                || ((c >= 0x20) && (c <= 0xD7FF))
                || ((c >= 0xE000) && (c <= 0xFFFD))
                || ((c >= 0x10000) && (c <= 0x10FFFF));
    }

    /**
     * Returns xml String from a Document Object
     *
     * @param document Xml Document to parse
     * @return Xml String representation
     * @throws TransformerException
     */
    public static String documentToString(Document document) throws TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(document), new StreamResult(writer));
        return writer.getBuffer().toString();
    }
}
