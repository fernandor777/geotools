<<<<<<< HEAD
<<<<<<< HEAD

package org.geotools.data.arcgisrest.schema.catalog;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Project Open Data ContactPoint vCard
 * <p>
 * A Dataset ContactPoint as a vCard object
 * 
=======
=======

>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
package org.geotools.data.arcgisrest.schema.catalog;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Project Open Data ContactPoint vCard
<<<<<<< HEAD
 *
 * <p>A Dataset ContactPoint as a vCard object
>>>>>>> 5fb8ab8508... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
=======
 * <p>
 * A Dataset ContactPoint as a vCard object
 * 
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
 */
public class Vcard {

    /**
     * Metadata Context
<<<<<<< HEAD
<<<<<<< HEAD
     * <p>
     * IRI for the JSON-LD data type. This should be vcard:Contact for contactPoint
     * 
=======
     *
     * <p>IRI for the JSON-LD data type. This should be vcard:Contact for contactPoint
>>>>>>> 5fb8ab8508... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
=======
     * <p>
     * IRI for the JSON-LD data type. This should be vcard:Contact for contactPoint
     * 
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
     */
    @SerializedName("@type")
    @Expose
    private Vcard.Type type;
    /**
     * Contact Name
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
     * <p>
     * A full formatted name, eg Firstname Lastname
     * (Required)
     * 
<<<<<<< HEAD
=======
     *
     * <p>A full formatted name, eg Firstname Lastname (Required)
>>>>>>> 5fb8ab8508... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
=======
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
     */
    @SerializedName("fn")
    @Expose
    private String fn;
    /**
     * Email
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
     * <p>
     * Email address for the contact
     * (Required)
     * 
<<<<<<< HEAD
=======
     *
     * <p>Email address for the contact (Required)
>>>>>>> 5fb8ab8508... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
=======
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
     */
    @SerializedName("hasEmail")
    @Expose
    private String hasEmail;

    /**
     * Metadata Context
<<<<<<< HEAD
<<<<<<< HEAD
     * <p>
     * IRI for the JSON-LD data type. This should be vcard:Contact for contactPoint
     * 
=======
     *
     * <p>IRI for the JSON-LD data type. This should be vcard:Contact for contactPoint
>>>>>>> 5fb8ab8508... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
=======
     * <p>
     * IRI for the JSON-LD data type. This should be vcard:Contact for contactPoint
     * 
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
     */
    public Vcard.Type getType() {
        return type;
    }

    /**
     * Metadata Context
<<<<<<< HEAD
<<<<<<< HEAD
     * <p>
     * IRI for the JSON-LD data type. This should be vcard:Contact for contactPoint
     * 
=======
     *
     * <p>IRI for the JSON-LD data type. This should be vcard:Contact for contactPoint
>>>>>>> 5fb8ab8508... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
=======
     * <p>
     * IRI for the JSON-LD data type. This should be vcard:Contact for contactPoint
     * 
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
     */
    public void setType(Vcard.Type type) {
        this.type = type;
    }

    /**
     * Contact Name
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
     * <p>
     * A full formatted name, eg Firstname Lastname
     * (Required)
     * 
<<<<<<< HEAD
=======
     *
     * <p>A full formatted name, eg Firstname Lastname (Required)
>>>>>>> 5fb8ab8508... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
=======
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
     */
    public String getFn() {
        return fn;
    }

    /**
     * Contact Name
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
     * <p>
     * A full formatted name, eg Firstname Lastname
     * (Required)
     * 
<<<<<<< HEAD
=======
     *
     * <p>A full formatted name, eg Firstname Lastname (Required)
>>>>>>> 5fb8ab8508... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
=======
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
     */
    public void setFn(String fn) {
        this.fn = fn;
    }

    /**
     * Email
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
     * <p>
     * Email address for the contact
     * (Required)
     * 
<<<<<<< HEAD
=======
     *
     * <p>Email address for the contact (Required)
>>>>>>> 5fb8ab8508... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
=======
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
     */
    public String getHasEmail() {
        return hasEmail;
    }

    /**
     * Email
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
     * <p>
     * Email address for the contact
     * (Required)
     * 
<<<<<<< HEAD
=======
     *
     * <p>Email address for the contact (Required)
>>>>>>> 5fb8ab8508... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
=======
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
     */
    public void setHasEmail(String hasEmail) {
        this.hasEmail = hasEmail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
<<<<<<< HEAD
<<<<<<< HEAD
        sb.append(Vcard.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("fn");
        sb.append('=');
        sb.append(((this.fn == null)?"<null>":this.fn));
        sb.append(',');
        sb.append("hasEmail");
        sb.append('=');
        sb.append(((this.hasEmail == null)?"<null>":this.hasEmail));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
=======
        sb.append(Vcard.class.getName())
                .append('@')
                .append(Integer.toHexString(System.identityHashCode(this)))
                .append('[');
=======
        sb.append(Vcard.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("fn");
        sb.append('=');
        sb.append(((this.fn == null)?"<null>":this.fn));
        sb.append(',');
        sb.append("hasEmail");
        sb.append('=');
        sb.append(((this.hasEmail == null)?"<null>":this.hasEmail));
        sb.append(',');
<<<<<<< HEAD
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
>>>>>>> 5fb8ab8508... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
=======
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
<<<<<<< HEAD
<<<<<<< HEAD
        result = ((result* 31)+((this.fn == null)? 0 :this.fn.hashCode()));
        result = ((result* 31)+((this.hasEmail == null)? 0 :this.hasEmail.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
=======
        result = ((result * 31) + ((this.fn == null) ? 0 : this.fn.hashCode()));
        result = ((result * 31) + ((this.hasEmail == null) ? 0 : this.hasEmail.hashCode()));
        result = ((result * 31) + ((this.type == null) ? 0 : this.type.hashCode()));
>>>>>>> 5fb8ab8508... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
=======
        result = ((result* 31)+((this.fn == null)? 0 :this.fn.hashCode()));
        result = ((result* 31)+((this.hasEmail == null)? 0 :this.hasEmail.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Vcard) == false) {
            return false;
        }
        Vcard rhs = ((Vcard) other);
<<<<<<< HEAD
<<<<<<< HEAD
        return ((((this.fn == rhs.fn)||((this.fn!= null)&&this.fn.equals(rhs.fn)))&&((this.hasEmail == rhs.hasEmail)||((this.hasEmail!= null)&&this.hasEmail.equals(rhs.hasEmail))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))));
    }

    public enum Type {

        @SerializedName("vcard:Contact")
        VCARD_CONTACT("vcard:Contact");
        private final String value;
        private final static Map<String, Vcard.Type> CONSTANTS = new HashMap<String, Vcard.Type>();

        static {
            for (Vcard.Type c: values()) {
=======
        return ((((this.fn == rhs.fn) || ((this.fn != null) && this.fn.equals(rhs.fn)))
                        && ((this.hasEmail == rhs.hasEmail)
                                || ((this.hasEmail != null) && this.hasEmail.equals(rhs.hasEmail))))
                && ((this.type == rhs.type)
                        || ((this.type != null) && this.type.equals(rhs.type))));
=======
        return ((((this.fn == rhs.fn)||((this.fn!= null)&&this.fn.equals(rhs.fn)))&&((this.hasEmail == rhs.hasEmail)||((this.hasEmail!= null)&&this.hasEmail.equals(rhs.hasEmail))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))));
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
    }

    public enum Type {

        @SerializedName("vcard:Contact")
        VCARD_CONTACT("vcard:Contact");
        private final String value;
        private final static Map<String, Vcard.Type> CONSTANTS = new HashMap<String, Vcard.Type>();

        static {
<<<<<<< HEAD
            for (Vcard.Type c : values()) {
>>>>>>> 5fb8ab8508... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
=======
            for (Vcard.Type c: values()) {
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
                CONSTANTS.put(c.value, c);
            }
        }

        private Type(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static Vcard.Type fromValue(String value) {
            Vcard.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }
<<<<<<< HEAD
<<<<<<< HEAD

    }

=======
    }
>>>>>>> 5fb8ab8508... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
=======

    }

>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
}
