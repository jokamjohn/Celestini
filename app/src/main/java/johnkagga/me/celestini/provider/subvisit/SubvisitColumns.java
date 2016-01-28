package johnkagga.me.celestini.provider.subvisit;

import android.net.Uri;
import android.provider.BaseColumns;

import johnkagga.me.celestini.provider.CelestiniProvider;
import johnkagga.me.celestini.provider.newvisit.NewvisitColumns;
import johnkagga.me.celestini.provider.subvisit.SubvisitColumns;

/**
 * Initial Visit
 */
public class SubvisitColumns implements BaseColumns {
    public static final String TABLE_NAME = "subvisit";
    public static final Uri CONTENT_URI = Uri.parse(CelestiniProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * Patient Id
     */
    public static final String PATIENT_ID = "Patient_Id";

    /**
     * Chronic problem
     */
    public static final String ANY_OTHER_CHRONIC_MEDICAL_PROBLEM = "Any_Other_Chronic_Medical_Problem";

    public static final String HEAD_PAIN = "Head_Pain";

    public static final String EPIGASTRIC_PAIN = "Epigastric_Pain";

    /**
     * Fever
     */
    public static final String FEVER = "Fever";

    /**
     * Nausea and vomiting
     */
    public static final String NAUSEA_VOMITING = "Nausea_Vomiting";

    public static final String VISUAL_DISTURBANCES = "Visual_Disturbances";

    /**
     * Chest pain
     */
    public static final String CHEST_PAIN = "Chest_Pain";

    /**
     * Difficulty in breathing
     */
    public static final String DIFFICULTY_IN_BREATHING = "Difficulty_In_Breathing";

    public static final String VAGINAL_BLEEDING_WITH_ABDOMINAL_PAIN = "Vaginal_Bleeding_With_Abdominal_Pain";

    /**
     * Hypertension drugs
     */
    public static final String HYPERTENSION_DRUGS = "Hypertension_Drugs";

    /**
     * Diabetes drugs
     */
    public static final String DIABETES_DRUGS = "Diabetes_Drugs";

    public static final String IRON_TABLETS = "Iron_Tablets";

    /**
     * Folic acid tablets
     */
    public static final String FOLIC_ACID_TABLETS = "Folic_Acid_Tablets";

    /**
     * Any other drugs
     */
    public static final String ANY_OTHER_SPECIFY = "Any_Other_Specify";

    public static final String ANY_MULTIPLE_GESTATION = "Any_Multiple_Gestation";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            PATIENT_ID,
            ANY_OTHER_CHRONIC_MEDICAL_PROBLEM,
            HEAD_PAIN,
            EPIGASTRIC_PAIN,
            FEVER,
            NAUSEA_VOMITING,
            VISUAL_DISTURBANCES,
            CHEST_PAIN,
            DIFFICULTY_IN_BREATHING,
            VAGINAL_BLEEDING_WITH_ABDOMINAL_PAIN,
            HYPERTENSION_DRUGS,
            DIABETES_DRUGS,
            IRON_TABLETS,
            FOLIC_ACID_TABLETS,
            ANY_OTHER_SPECIFY,
            ANY_MULTIPLE_GESTATION
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(PATIENT_ID) || c.contains("." + PATIENT_ID)) return true;
            if (c.equals(ANY_OTHER_CHRONIC_MEDICAL_PROBLEM) || c.contains("." + ANY_OTHER_CHRONIC_MEDICAL_PROBLEM)) return true;
            if (c.equals(HEAD_PAIN) || c.contains("." + HEAD_PAIN)) return true;
            if (c.equals(EPIGASTRIC_PAIN) || c.contains("." + EPIGASTRIC_PAIN)) return true;
            if (c.equals(FEVER) || c.contains("." + FEVER)) return true;
            if (c.equals(NAUSEA_VOMITING) || c.contains("." + NAUSEA_VOMITING)) return true;
            if (c.equals(VISUAL_DISTURBANCES) || c.contains("." + VISUAL_DISTURBANCES)) return true;
            if (c.equals(CHEST_PAIN) || c.contains("." + CHEST_PAIN)) return true;
            if (c.equals(DIFFICULTY_IN_BREATHING) || c.contains("." + DIFFICULTY_IN_BREATHING)) return true;
            if (c.equals(VAGINAL_BLEEDING_WITH_ABDOMINAL_PAIN) || c.contains("." + VAGINAL_BLEEDING_WITH_ABDOMINAL_PAIN)) return true;
            if (c.equals(HYPERTENSION_DRUGS) || c.contains("." + HYPERTENSION_DRUGS)) return true;
            if (c.equals(DIABETES_DRUGS) || c.contains("." + DIABETES_DRUGS)) return true;
            if (c.equals(IRON_TABLETS) || c.contains("." + IRON_TABLETS)) return true;
            if (c.equals(FOLIC_ACID_TABLETS) || c.contains("." + FOLIC_ACID_TABLETS)) return true;
            if (c.equals(ANY_OTHER_SPECIFY) || c.contains("." + ANY_OTHER_SPECIFY)) return true;
            if (c.equals(ANY_MULTIPLE_GESTATION) || c.contains("." + ANY_MULTIPLE_GESTATION)) return true;
        }
        return false;
    }

}
