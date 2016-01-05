package johnkagga.me.celestini;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;

import java.util.Date;

/**
 * Created by jokamjohn on 1/5/2016.
 */
//Add the annotation for the Parse Sub-class and then register it in the Application
@ParseClassName("ClientContactInformation")
public class ClientContactInformation extends ParseObject {

    public void setFirstName(String firstName)
    {
        put("FirstName",firstName);
    }

    public String getFirstName()
    {
        return getString("FirstName");
    }

    public void setLastName(String lastName)
    {
        put("LastName",lastName);
    }

    public String getLastName()
    {
        return getString("LastName");
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        put("DateOfBirth", dateOfBirth);
    }

    public Date getDateOfBirth()
    {
        return getDate("DateOfBirth");
    }

    public void setTribe(String tribe)
    {
        put("Tribe", tribe);
    }

    public String getTribe()
    {
        return getString("Tribe");
    }

    public void setOccupation(String occupation)
    {
       put("Occupation",occupation);
    }

    public String getOccupation()
    {
        return getString("Occupation");
    }

    public void setPhoneNumber(String phoneNumber)
    {
        put("PhoneNumber",phoneNumber);
    }

    public String getPhoneNumber()
    {
        return getString("PhoneNumber");
    }

    public void setAltPhoneNumber(String altPhoneNumber)
    {
        put("AltPhoneNumber",altPhoneNumber);
    }

    public String getAltPhoneNumber()
    {
        return getString("AltPhoneNumber");
    }

    public void setImage(ParseFile imageFile)
    {
        put("Image",imageFile);
    }

    public ParseFile getImage()
    {
        return getParseFile("Image");
    }

    public void setGeoPoint(ParseGeoPoint geoPoint)
    {
        put("GeoLocation",geoPoint);
    }

    public ParseGeoPoint getGeoPoint()
    {
        return getParseGeoPoint("GeoLocation");
    }



}
