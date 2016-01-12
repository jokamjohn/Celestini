package johnkagga.me.celestini.data;

import com.parse.ParseClassName;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.Date;
import java.util.UUID;

/**
 * Created by jokamjohn on 1/5/2016.
 */
//Add the annotation for the Parse Sub-class and then register it in the Application
@ParseClassName("ClientContactInformation")
public class ClientContactInformation extends ParseObject {

    public void setFirstName(String firstName) {
        put("FirstName", firstName);
    }

    public String getFirstName() {
        return getString("FirstName");
    }

    public void setLastName(String lastName) {
        put("LastName", lastName);
    }

    public String getLastName() {
        return getString("LastName");
    }

    public String getName(){
        return getFirstName() +" " + getLastName();
    }

    public void setDateOfBirth(Date dateOfBirth) {
        put("DateOfBirth", dateOfBirth);
    }

    public Date getDateOfBirth() {
        return getDate("DateOfBirth");
    }

    public void setTribe(String tribe) {
        put("Tribe", tribe);
    }

    public String getTribe() {
        return getString("Tribe");
    }

    public void setOccupation(String occupation) {
        put("Occupation", occupation);
    }

    public String getOccupation() {
        return getString("Occupation");
    }

    public void setPhoneNumber(String phoneNumber) {
        put("PhoneNumber", phoneNumber);
    }

    public String getPhoneNumber() {
        return getString("PhoneNumber");
    }

    public void setAltPhoneNumber(String altPhoneNumber) {
        put("AltPhoneNumber", altPhoneNumber);
    }

    public String getAltPhoneNumber() {
        return getString("AltPhoneNumber");
    }

    public void setGeoPoint(ParseGeoPoint geoPoint) {
        put("GeoLocation", geoPoint);
    }

    public ParseGeoPoint getGeoPoint() {
        return getParseGeoPoint("GeoLocation");
    }

    public void setDistrict(String district)
    {
        put("District",district);
    }

    public void setVillage(String village)
    {
        put("Village",village);
    }

    public String getPhysicalLocation()
    {
        return getString("Village") + "-" + getString("District");
    }

    public void setCreatedBy(ParseUser user) {
        put("CreatedBy", user);
    }

    public void setUuidString() {
        UUID uuid = UUID.randomUUID();
        put("Uuid", uuid.toString());
    }

    public String getUuidString() {
        return getString("Uuid");
    }

    public void setSync(boolean isSynced) {
        put("isSynced", isSynced);
    }

    public boolean isSynced() {
        return getBoolean("isSynced");
    }

    public ParseQuery<ClientContactInformation> getCreator() {
        return getQuery().whereEqualTo("CreatedBy", ParseUser.getCurrentUser());
    }

    public void setHealthInfo(HealthYesNoQuestions healthInfo) {
        put("HealthYesNoQuestions", healthInfo);
    }

    public static ParseQuery<ClientContactInformation> getQuery() {
        return ParseQuery.getQuery(ClientContactInformation.class);
    }

    public void setHealthCheckInformation(HealthCheckQuestions healthCheckInformation)
    {
        put("HealthCQ",healthCheckInformation);
    }

    public void setStructuredHealthInformation(StructuredQuestions structuredQuestions)
    {
        put("StructuredHQ",structuredQuestions);
    }

}
