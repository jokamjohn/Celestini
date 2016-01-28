package johnkagga.me.celestini.provider.newvisit;

import android.net.Uri;
import android.provider.BaseColumns;

import johnkagga.me.celestini.provider.CelestiniProvider;

/**
 * Initial Visit
 */
public class NewvisitColumns implements BaseColumns {
    public static final String TABLE_NAME = "newvisit";
    public static final Uri CONTENT_URI = Uri.parse(CelestiniProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * Hospital Address
     */
    public static final String HOSPITAL_ADDRESS = "Hospital_Address";

    /**
     * Hospital Name
     */
    public static final String HOSPITAL_NAME = "Hospital_Name";

    public static final String VISIT_NO = "Visit_No";

    public static final String PATIENT_NAME = "Patient_Name";

    /**
     * Home District
     */
    public static final String HOME_DISTRICT = "Home_District";

    /**
     * Date of birth
     */
    public static final String DOB = "DOB";

    public static final String EDUCATION_LEVEL = "Education_Level";

    /**
     * Tribe
     */
    public static final String TRIBE = "Tribe";

    /**
     * Religion
     */
    public static final String RELIGION = "Religion";

    public static final String OCCUPATION = "Occupation";

    /**
     * Town
     */
    public static final String TOWN = "Town";

    /**
     * Blood Pressure
     */
    public static final String BLOODPRESSURE = "BloodPressure";

    public static final String PARITY_NO_OF_PREGNANCIES = "Parity_No_Of_Pregnancies";

    /**
     * Pregnancy_Outcome
     */
    public static final String PREGNANCY_OUTCOME = "Pregnancy_Outcome";

    /**
     * History of hypertension in past pregnancies
     */
    public static final String PAST_PREGNANCY_HYPERTENSION_HISTORY = "Past_Pregnancy_Hypertension_History";

    public static final String LAST_NORMAL_MP_DATE = "Last_Normal_Mp_Date";

    /**
     * Previous C-section
     */
    public static final String PREVIOUS_CAESAREAN = "Previous_Caesarean";

    /**
     * Hypertension before pregnancy
     */
    public static final String HYPERTENSION_BEFORE_PREGNANCY = "Hypertension_Before_Pregnancy";

    public static final String DIABETIC_BEFORE_PREGNANCY = "Diabetic_Before_Pregnancy";

    /**
     * Chronic renal disease
     */
    public static final String CHRONIC_RENAL_DISEASE = "Chronic_Renal_Disease";

    /**
     * Thyroid disease
     */
    public static final String THYROID_DISEASE = "Thyroid_Disease";

    public static final String SICKLE_CELLS = "Sickle_Cells";

    /**
     * Any other chronic problem
     */
    public static final String OTHER_CHRONIC_PROBLEM = "Other_Chronic_Problem";

    /**
     * Do you have headache
     */
    public static final String HEADACHE_SYMPTOME = "Headache_Symptome";

    public static final String EPIGASTRIC_PAIN = "Epigastric_Pain";

    /**
     * Fever
     */
    public static final String FEVER = "Fever";

    /**
     * Nausea and vomiting
     */
    public static final String NAUSEA_AND_VOMITING = "Nausea_And_Vomiting";

    public static final String VISUAL_DISTURBANCE = "Visual_Disturbance";

    /**
     * Chest pain
     */
    public static final String CHEST_PAIN = "Chest_Pain";

    /**
     * Difficulty in breathing
     */
    public static final String DIFFICULTY_IN_BREATHING = "Difficulty_In_Breathing";

    /**
     * Vaginal bleeding
     */
    public static final String VAGINAL_BLEEDING = "Vaginal_Bleeding";

    /**
     * Hypertension drugs
     */
    public static final String HYPERTENSION_DRUGS = "Hypertension_Drugs";

    /**
     * Diabetes drugs
     */
    public static final String DIABETES_DRUGS = "Diabetes_Drugs";

    /**
     * Iron tablets
     */
    public static final String IRON_TABLETS = "Iron_Tablets";

    /**
     * Folic acid tablets
     */
    public static final String FOLIC_ACID_TABLETS = "Folic_Acid_Tablets";

    /**
     * Any other drugs
     */
    public static final String OTHER_DRUGS = "Other_Drugs";

    /**
     * Hypertension while on contraceptives
     */
    public static final String HYPERTENSION_HISTORY_COCS = "Hypertension_History_Cocs";

    /**
     * History of preeclampsia in the family
     */
    public static final String PREECLAMPSIA_FAMILY_HISTORY = "Preeclampsia_Family_History";

    /**
     * Any treatment for infertility in the past
     */
    public static final String INFERTILITY_TREATMENT_HISTORY = "Infertility_Treatment_History";

    /**
     * Multiple gestation
     */
    public static final String MULTIPLE_GESTATION = "Multiple_Gestation";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            HOSPITAL_ADDRESS,
            HOSPITAL_NAME,
            VISIT_NO,
            PATIENT_NAME,
            HOME_DISTRICT,
            DOB,
            EDUCATION_LEVEL,
            TRIBE,
            RELIGION,
            OCCUPATION,
            TOWN,
            BLOODPRESSURE,
            PARITY_NO_OF_PREGNANCIES,
            PREGNANCY_OUTCOME,
            PAST_PREGNANCY_HYPERTENSION_HISTORY,
            LAST_NORMAL_MP_DATE,
            PREVIOUS_CAESAREAN,
            HYPERTENSION_BEFORE_PREGNANCY,
            DIABETIC_BEFORE_PREGNANCY,
            CHRONIC_RENAL_DISEASE,
            THYROID_DISEASE,
            SICKLE_CELLS,
            OTHER_CHRONIC_PROBLEM,
            HEADACHE_SYMPTOME,
            EPIGASTRIC_PAIN,
            FEVER,
            NAUSEA_AND_VOMITING,
            VISUAL_DISTURBANCE,
            CHEST_PAIN,
            DIFFICULTY_IN_BREATHING,
            VAGINAL_BLEEDING,
            HYPERTENSION_DRUGS,
            DIABETES_DRUGS,
            IRON_TABLETS,
            FOLIC_ACID_TABLETS,
            OTHER_DRUGS,
            HYPERTENSION_HISTORY_COCS,
            PREECLAMPSIA_FAMILY_HISTORY,
            INFERTILITY_TREATMENT_HISTORY,
            MULTIPLE_GESTATION
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(HOSPITAL_ADDRESS) || c.contains("." + HOSPITAL_ADDRESS)) return true;
            if (c.equals(HOSPITAL_NAME) || c.contains("." + HOSPITAL_NAME)) return true;
            if (c.equals(VISIT_NO) || c.contains("." + VISIT_NO)) return true;
            if (c.equals(PATIENT_NAME) || c.contains("." + PATIENT_NAME)) return true;
            if (c.equals(HOME_DISTRICT) || c.contains("." + HOME_DISTRICT)) return true;
            if (c.equals(DOB) || c.contains("." + DOB)) return true;
            if (c.equals(EDUCATION_LEVEL) || c.contains("." + EDUCATION_LEVEL)) return true;
            if (c.equals(TRIBE) || c.contains("." + TRIBE)) return true;
            if (c.equals(RELIGION) || c.contains("." + RELIGION)) return true;
            if (c.equals(OCCUPATION) || c.contains("." + OCCUPATION)) return true;
            if (c.equals(TOWN) || c.contains("." + TOWN)) return true;
            if (c.equals(BLOODPRESSURE) || c.contains("." + BLOODPRESSURE)) return true;
            if (c.equals(PARITY_NO_OF_PREGNANCIES) || c.contains("." + PARITY_NO_OF_PREGNANCIES)) return true;
            if (c.equals(PREGNANCY_OUTCOME) || c.contains("." + PREGNANCY_OUTCOME)) return true;
            if (c.equals(PAST_PREGNANCY_HYPERTENSION_HISTORY) || c.contains("." + PAST_PREGNANCY_HYPERTENSION_HISTORY)) return true;
            if (c.equals(LAST_NORMAL_MP_DATE) || c.contains("." + LAST_NORMAL_MP_DATE)) return true;
            if (c.equals(PREVIOUS_CAESAREAN) || c.contains("." + PREVIOUS_CAESAREAN)) return true;
            if (c.equals(HYPERTENSION_BEFORE_PREGNANCY) || c.contains("." + HYPERTENSION_BEFORE_PREGNANCY)) return true;
            if (c.equals(DIABETIC_BEFORE_PREGNANCY) || c.contains("." + DIABETIC_BEFORE_PREGNANCY)) return true;
            if (c.equals(CHRONIC_RENAL_DISEASE) || c.contains("." + CHRONIC_RENAL_DISEASE)) return true;
            if (c.equals(THYROID_DISEASE) || c.contains("." + THYROID_DISEASE)) return true;
            if (c.equals(SICKLE_CELLS) || c.contains("." + SICKLE_CELLS)) return true;
            if (c.equals(OTHER_CHRONIC_PROBLEM) || c.contains("." + OTHER_CHRONIC_PROBLEM)) return true;
            if (c.equals(HEADACHE_SYMPTOME) || c.contains("." + HEADACHE_SYMPTOME)) return true;
            if (c.equals(EPIGASTRIC_PAIN) || c.contains("." + EPIGASTRIC_PAIN)) return true;
            if (c.equals(FEVER) || c.contains("." + FEVER)) return true;
            if (c.equals(NAUSEA_AND_VOMITING) || c.contains("." + NAUSEA_AND_VOMITING)) return true;
            if (c.equals(VISUAL_DISTURBANCE) || c.contains("." + VISUAL_DISTURBANCE)) return true;
            if (c.equals(CHEST_PAIN) || c.contains("." + CHEST_PAIN)) return true;
            if (c.equals(DIFFICULTY_IN_BREATHING) || c.contains("." + DIFFICULTY_IN_BREATHING)) return true;
            if (c.equals(VAGINAL_BLEEDING) || c.contains("." + VAGINAL_BLEEDING)) return true;
            if (c.equals(HYPERTENSION_DRUGS) || c.contains("." + HYPERTENSION_DRUGS)) return true;
            if (c.equals(DIABETES_DRUGS) || c.contains("." + DIABETES_DRUGS)) return true;
            if (c.equals(IRON_TABLETS) || c.contains("." + IRON_TABLETS)) return true;
            if (c.equals(FOLIC_ACID_TABLETS) || c.contains("." + FOLIC_ACID_TABLETS)) return true;
            if (c.equals(OTHER_DRUGS) || c.contains("." + OTHER_DRUGS)) return true;
            if (c.equals(HYPERTENSION_HISTORY_COCS) || c.contains("." + HYPERTENSION_HISTORY_COCS)) return true;
            if (c.equals(PREECLAMPSIA_FAMILY_HISTORY) || c.contains("." + PREECLAMPSIA_FAMILY_HISTORY)) return true;
            if (c.equals(INFERTILITY_TREATMENT_HISTORY) || c.contains("." + INFERTILITY_TREATMENT_HISTORY)) return true;
            if (c.equals(MULTIPLE_GESTATION) || c.contains("." + MULTIPLE_GESTATION)) return true;
        }
        return false;
    }

}
