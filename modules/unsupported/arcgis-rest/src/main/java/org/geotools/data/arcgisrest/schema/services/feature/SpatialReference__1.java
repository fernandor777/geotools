<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> 5fb8ab8508... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
=======

>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
package org.geotools.data.arcgisrest.schema.services.feature;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpatialReference__1 {

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
    /**
     * 
     * (Required)
     * 
     */
<<<<<<< HEAD
    @SerializedName("wkid")
    @Expose
    private Integer wkid;
    /**
     * 
     * (Required)
     * 
     */
=======
    /** (Required) */
    @SerializedName("wkid")
    @Expose
    private Integer wkid;
    /** (Required) */
>>>>>>> 5fb8ab8508... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
    @SerializedName("latestWkid")
    @Expose
    private Integer latestWkid;

<<<<<<< HEAD
    /**
     * 
     * (Required)
     * 
     */
=======
=======
    @SerializedName("wkid")
    @Expose
    private Integer wkid;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("latestWkid")
    @Expose
    private Integer latestWkid;
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
    @SerializedName("wkt")
    @Expose
    private String wkt;

<<<<<<< HEAD
    /** (Required) */
>>>>>>> 5fb8ab8508... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
=======
    /**
     * 
     * (Required)
     * 
     */
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
    public Integer getWkid() {
        return wkid;
    }

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
    /**
     * 
     * (Required)
     * 
     */
<<<<<<< HEAD
=======
    /** (Required) */
>>>>>>> 5fb8ab8508... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
=======
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
    public void setWkid(Integer wkid) {
        this.wkid = wkid;
    }

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
    /**
     * 
     * (Required)
     * 
     */
<<<<<<< HEAD
=======
    /** (Required) */
>>>>>>> 5fb8ab8508... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
=======
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
    public Integer getLatestWkid() {
        return latestWkid;
    }

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
    /**
     * 
     * (Required)
     * 
     */
<<<<<<< HEAD
=======
    /** (Required) */
>>>>>>> 5fb8ab8508... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
=======
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
    public void setLatestWkid(Integer latestWkid) {
        this.latestWkid = latestWkid;
    }

<<<<<<< HEAD
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SpatialReference__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("wkid");
        sb.append('=');
        sb.append(((this.wkid == null)?"<null>":this.wkid));
        sb.append(',');
        sb.append("latestWkid");
        sb.append('=');
        sb.append(((this.latestWkid == null)?"<null>":this.latestWkid));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
=======
    public String getWkt() {
        return wkt;
    }

    public void setWkt(String wkt) {
        this.wkt = wkt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SpatialReference__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("wkid");
        sb.append('=');
        sb.append(((this.wkid == null)?"<null>":this.wkid));
        sb.append(',');
        sb.append("latestWkid");
        sb.append('=');
        sb.append(((this.latestWkid == null)?"<null>":this.latestWkid));
        sb.append(',');
        sb.append("wkt");
        sb.append('=');
        sb.append(((this.wkt == null)?"<null>":this.wkt));
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
        result = ((result* 31)+((this.wkid == null)? 0 :this.wkid.hashCode()));
        result = ((result* 31)+((this.latestWkid == null)? 0 :this.latestWkid.hashCode()));
=======
        result = ((result * 31) + ((this.wkid == null) ? 0 : this.wkid.hashCode()));
        result = ((result * 31) + ((this.wkt == null) ? 0 : this.wkt.hashCode()));
        result = ((result * 31) + ((this.latestWkid == null) ? 0 : this.latestWkid.hashCode()));
>>>>>>> 5fb8ab8508... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
=======
        result = ((result* 31)+((this.wkid == null)? 0 :this.wkid.hashCode()));
        result = ((result* 31)+((this.wkt == null)? 0 :this.wkt.hashCode()));
        result = ((result* 31)+((this.latestWkid == null)? 0 :this.latestWkid.hashCode()));
>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SpatialReference__1) == false) {
            return false;
        }
        SpatialReference__1 rhs = ((SpatialReference__1) other);
<<<<<<< HEAD
<<<<<<< HEAD
        return (((this.wkid == rhs.wkid)||((this.wkid!= null)&&this.wkid.equals(rhs.wkid)))&&((this.latestWkid == rhs.latestWkid)||((this.latestWkid!= null)&&this.latestWkid.equals(rhs.latestWkid))));
    }

=======
        return ((((this.wkid == rhs.wkid) || ((this.wkid != null) && this.wkid.equals(rhs.wkid)))
                        && ((this.wkt == rhs.wkt)
                                || ((this.wkt != null) && this.wkt.equals(rhs.wkt))))
                && ((this.latestWkid == rhs.latestWkid)
                        || ((this.latestWkid != null) && this.latestWkid.equals(rhs.latestWkid))));
    }
>>>>>>> 5fb8ab8508... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
=======
        return ((((this.wkid == rhs.wkid)||((this.wkid!= null)&&this.wkid.equals(rhs.wkid)))&&((this.wkt == rhs.wkt)||((this.wkt!= null)&&this.wkt.equals(rhs.wkt))))&&((this.latestWkid == rhs.latestWkid)||((this.latestWkid!= null)&&this.latestWkid.equals(rhs.latestWkid))));
    }

>>>>>>> db04a836af... [AUR-5856] Geoserver ArcGIS datastore Fails to Recognize CRS
}
