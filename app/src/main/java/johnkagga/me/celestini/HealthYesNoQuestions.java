package johnkagga.me.celestini;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.UUID;

/**
 * Created by jokamjohn on 1/6/2016.
 */
@ParseClassName("HealthYesNoQuestions")
public class HealthYesNoQuestions extends ParseObject {

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

    public void setHistoryHypertension(String historyHypertension) {
        put("HypertensionPP", historyHypertension);
    }

    public boolean getHypertensionHistory() {
        return getBoolean("HypertensionPP");
    }

    public void setCesarean(String cesarean) {
        put("Cesarean", cesarean);
    }

    public String getCesarean() {
        return getString("Cesarean");
    }

    public void setHypertensive(String hypertensive) {
        put("Hypertensive", hypertensive);
    }

    public String getHypertensive() {
        return getString("Hypertensive");
    }

    public void setDiabetic(String diabetic) {
        put("Diabetic", diabetic);
    }

    public String getDiabetic() {
        return getString("Diabetic");
    }

    public void setChronicRenal(String chronic) {
        put("ChronicRenal", chronic);
    }

    public String getChronicRenal() {
        return getString("ChronicRenal");
    }

    public void setThyroid(String thyroid) {
        put("Thyroid", thyroid);
    }

    public String getThyroid() {
        return getString("Thyroid");
    }

    public void setSickleCell(String sickleCell) {
        put("SickleCell", sickleCell);
    }

    public String getSickleCell() {
        return getString("SickleCell");
    }

    public void setOwner(ClientContactInformation contactInformation)
    {
        put("InfoOwner",contactInformation);
    }

    public static ParseQuery<HealthYesNoQuestions> getQuery()
    {
        return ParseQuery.getQuery(HealthYesNoQuestions.class);
    }
}
