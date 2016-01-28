package johnkagga.me.celestini.provider.subvisit;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import johnkagga.me.celestini.provider.base.AbstractSelection;

/**
 * Selection for the {@code subvisit} table.
 */
public class SubvisitSelection extends AbstractSelection<SubvisitSelection> {
    @Override
    protected Uri baseUri() {
        return SubvisitColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code SubvisitCursor} object, which is positioned before the first entry, or null.
     */
    public SubvisitCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new SubvisitCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public SubvisitCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code SubvisitCursor} object, which is positioned before the first entry, or null.
     */
    public SubvisitCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new SubvisitCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public SubvisitCursor query(Context context) {
        return query(context, null);
    }


    public SubvisitSelection id(long... value) {
        addEquals("subvisit." + SubvisitColumns._ID, toObjectArray(value));
        return this;
    }

    public SubvisitSelection idNot(long... value) {
        addNotEquals("subvisit." + SubvisitColumns._ID, toObjectArray(value));
        return this;
    }

    public SubvisitSelection orderById(boolean desc) {
        orderBy("subvisit." + SubvisitColumns._ID, desc);
        return this;
    }

    public SubvisitSelection orderById() {
        return orderById(false);
    }

    public SubvisitSelection patientId(String... value) {
        addEquals(SubvisitColumns.PATIENT_ID, value);
        return this;
    }

    public SubvisitSelection patientIdNot(String... value) {
        addNotEquals(SubvisitColumns.PATIENT_ID, value);
        return this;
    }

    public SubvisitSelection patientIdLike(String... value) {
        addLike(SubvisitColumns.PATIENT_ID, value);
        return this;
    }

    public SubvisitSelection patientIdContains(String... value) {
        addContains(SubvisitColumns.PATIENT_ID, value);
        return this;
    }

    public SubvisitSelection patientIdStartsWith(String... value) {
        addStartsWith(SubvisitColumns.PATIENT_ID, value);
        return this;
    }

    public SubvisitSelection patientIdEndsWith(String... value) {
        addEndsWith(SubvisitColumns.PATIENT_ID, value);
        return this;
    }

    public SubvisitSelection orderByPatientId(boolean desc) {
        orderBy(SubvisitColumns.PATIENT_ID, desc);
        return this;
    }

    public SubvisitSelection orderByPatientId() {
        orderBy(SubvisitColumns.PATIENT_ID, false);
        return this;
    }

    public SubvisitSelection anyOtherChronicMedicalProblem(String... value) {
        addEquals(SubvisitColumns.ANY_OTHER_CHRONIC_MEDICAL_PROBLEM, value);
        return this;
    }

    public SubvisitSelection anyOtherChronicMedicalProblemNot(String... value) {
        addNotEquals(SubvisitColumns.ANY_OTHER_CHRONIC_MEDICAL_PROBLEM, value);
        return this;
    }

    public SubvisitSelection anyOtherChronicMedicalProblemLike(String... value) {
        addLike(SubvisitColumns.ANY_OTHER_CHRONIC_MEDICAL_PROBLEM, value);
        return this;
    }

    public SubvisitSelection anyOtherChronicMedicalProblemContains(String... value) {
        addContains(SubvisitColumns.ANY_OTHER_CHRONIC_MEDICAL_PROBLEM, value);
        return this;
    }

    public SubvisitSelection anyOtherChronicMedicalProblemStartsWith(String... value) {
        addStartsWith(SubvisitColumns.ANY_OTHER_CHRONIC_MEDICAL_PROBLEM, value);
        return this;
    }

    public SubvisitSelection anyOtherChronicMedicalProblemEndsWith(String... value) {
        addEndsWith(SubvisitColumns.ANY_OTHER_CHRONIC_MEDICAL_PROBLEM, value);
        return this;
    }

    public SubvisitSelection orderByAnyOtherChronicMedicalProblem(boolean desc) {
        orderBy(SubvisitColumns.ANY_OTHER_CHRONIC_MEDICAL_PROBLEM, desc);
        return this;
    }

    public SubvisitSelection orderByAnyOtherChronicMedicalProblem() {
        orderBy(SubvisitColumns.ANY_OTHER_CHRONIC_MEDICAL_PROBLEM, false);
        return this;
    }

    public SubvisitSelection headPain(String... value) {
        addEquals(SubvisitColumns.HEAD_PAIN, value);
        return this;
    }

    public SubvisitSelection headPainNot(String... value) {
        addNotEquals(SubvisitColumns.HEAD_PAIN, value);
        return this;
    }

    public SubvisitSelection headPainLike(String... value) {
        addLike(SubvisitColumns.HEAD_PAIN, value);
        return this;
    }

    public SubvisitSelection headPainContains(String... value) {
        addContains(SubvisitColumns.HEAD_PAIN, value);
        return this;
    }

    public SubvisitSelection headPainStartsWith(String... value) {
        addStartsWith(SubvisitColumns.HEAD_PAIN, value);
        return this;
    }

    public SubvisitSelection headPainEndsWith(String... value) {
        addEndsWith(SubvisitColumns.HEAD_PAIN, value);
        return this;
    }

    public SubvisitSelection orderByHeadPain(boolean desc) {
        orderBy(SubvisitColumns.HEAD_PAIN, desc);
        return this;
    }

    public SubvisitSelection orderByHeadPain() {
        orderBy(SubvisitColumns.HEAD_PAIN, false);
        return this;
    }

    public SubvisitSelection epigastricPain(String... value) {
        addEquals(SubvisitColumns.EPIGASTRIC_PAIN, value);
        return this;
    }

    public SubvisitSelection epigastricPainNot(String... value) {
        addNotEquals(SubvisitColumns.EPIGASTRIC_PAIN, value);
        return this;
    }

    public SubvisitSelection epigastricPainLike(String... value) {
        addLike(SubvisitColumns.EPIGASTRIC_PAIN, value);
        return this;
    }

    public SubvisitSelection epigastricPainContains(String... value) {
        addContains(SubvisitColumns.EPIGASTRIC_PAIN, value);
        return this;
    }

    public SubvisitSelection epigastricPainStartsWith(String... value) {
        addStartsWith(SubvisitColumns.EPIGASTRIC_PAIN, value);
        return this;
    }

    public SubvisitSelection epigastricPainEndsWith(String... value) {
        addEndsWith(SubvisitColumns.EPIGASTRIC_PAIN, value);
        return this;
    }

    public SubvisitSelection orderByEpigastricPain(boolean desc) {
        orderBy(SubvisitColumns.EPIGASTRIC_PAIN, desc);
        return this;
    }

    public SubvisitSelection orderByEpigastricPain() {
        orderBy(SubvisitColumns.EPIGASTRIC_PAIN, false);
        return this;
    }

    public SubvisitSelection fever(String... value) {
        addEquals(SubvisitColumns.FEVER, value);
        return this;
    }

    public SubvisitSelection feverNot(String... value) {
        addNotEquals(SubvisitColumns.FEVER, value);
        return this;
    }

    public SubvisitSelection feverLike(String... value) {
        addLike(SubvisitColumns.FEVER, value);
        return this;
    }

    public SubvisitSelection feverContains(String... value) {
        addContains(SubvisitColumns.FEVER, value);
        return this;
    }

    public SubvisitSelection feverStartsWith(String... value) {
        addStartsWith(SubvisitColumns.FEVER, value);
        return this;
    }

    public SubvisitSelection feverEndsWith(String... value) {
        addEndsWith(SubvisitColumns.FEVER, value);
        return this;
    }

    public SubvisitSelection orderByFever(boolean desc) {
        orderBy(SubvisitColumns.FEVER, desc);
        return this;
    }

    public SubvisitSelection orderByFever() {
        orderBy(SubvisitColumns.FEVER, false);
        return this;
    }

    public SubvisitSelection nauseaVomiting(String... value) {
        addEquals(SubvisitColumns.NAUSEA_VOMITING, value);
        return this;
    }

    public SubvisitSelection nauseaVomitingNot(String... value) {
        addNotEquals(SubvisitColumns.NAUSEA_VOMITING, value);
        return this;
    }

    public SubvisitSelection nauseaVomitingLike(String... value) {
        addLike(SubvisitColumns.NAUSEA_VOMITING, value);
        return this;
    }

    public SubvisitSelection nauseaVomitingContains(String... value) {
        addContains(SubvisitColumns.NAUSEA_VOMITING, value);
        return this;
    }

    public SubvisitSelection nauseaVomitingStartsWith(String... value) {
        addStartsWith(SubvisitColumns.NAUSEA_VOMITING, value);
        return this;
    }

    public SubvisitSelection nauseaVomitingEndsWith(String... value) {
        addEndsWith(SubvisitColumns.NAUSEA_VOMITING, value);
        return this;
    }

    public SubvisitSelection orderByNauseaVomiting(boolean desc) {
        orderBy(SubvisitColumns.NAUSEA_VOMITING, desc);
        return this;
    }

    public SubvisitSelection orderByNauseaVomiting() {
        orderBy(SubvisitColumns.NAUSEA_VOMITING, false);
        return this;
    }

    public SubvisitSelection visualDisturbances(String... value) {
        addEquals(SubvisitColumns.VISUAL_DISTURBANCES, value);
        return this;
    }

    public SubvisitSelection visualDisturbancesNot(String... value) {
        addNotEquals(SubvisitColumns.VISUAL_DISTURBANCES, value);
        return this;
    }

    public SubvisitSelection visualDisturbancesLike(String... value) {
        addLike(SubvisitColumns.VISUAL_DISTURBANCES, value);
        return this;
    }

    public SubvisitSelection visualDisturbancesContains(String... value) {
        addContains(SubvisitColumns.VISUAL_DISTURBANCES, value);
        return this;
    }

    public SubvisitSelection visualDisturbancesStartsWith(String... value) {
        addStartsWith(SubvisitColumns.VISUAL_DISTURBANCES, value);
        return this;
    }

    public SubvisitSelection visualDisturbancesEndsWith(String... value) {
        addEndsWith(SubvisitColumns.VISUAL_DISTURBANCES, value);
        return this;
    }

    public SubvisitSelection orderByVisualDisturbances(boolean desc) {
        orderBy(SubvisitColumns.VISUAL_DISTURBANCES, desc);
        return this;
    }

    public SubvisitSelection orderByVisualDisturbances() {
        orderBy(SubvisitColumns.VISUAL_DISTURBANCES, false);
        return this;
    }

    public SubvisitSelection chestPain(String... value) {
        addEquals(SubvisitColumns.CHEST_PAIN, value);
        return this;
    }

    public SubvisitSelection chestPainNot(String... value) {
        addNotEquals(SubvisitColumns.CHEST_PAIN, value);
        return this;
    }

    public SubvisitSelection chestPainLike(String... value) {
        addLike(SubvisitColumns.CHEST_PAIN, value);
        return this;
    }

    public SubvisitSelection chestPainContains(String... value) {
        addContains(SubvisitColumns.CHEST_PAIN, value);
        return this;
    }

    public SubvisitSelection chestPainStartsWith(String... value) {
        addStartsWith(SubvisitColumns.CHEST_PAIN, value);
        return this;
    }

    public SubvisitSelection chestPainEndsWith(String... value) {
        addEndsWith(SubvisitColumns.CHEST_PAIN, value);
        return this;
    }

    public SubvisitSelection orderByChestPain(boolean desc) {
        orderBy(SubvisitColumns.CHEST_PAIN, desc);
        return this;
    }

    public SubvisitSelection orderByChestPain() {
        orderBy(SubvisitColumns.CHEST_PAIN, false);
        return this;
    }

    public SubvisitSelection difficultyInBreathing(String... value) {
        addEquals(SubvisitColumns.DIFFICULTY_IN_BREATHING, value);
        return this;
    }

    public SubvisitSelection difficultyInBreathingNot(String... value) {
        addNotEquals(SubvisitColumns.DIFFICULTY_IN_BREATHING, value);
        return this;
    }

    public SubvisitSelection difficultyInBreathingLike(String... value) {
        addLike(SubvisitColumns.DIFFICULTY_IN_BREATHING, value);
        return this;
    }

    public SubvisitSelection difficultyInBreathingContains(String... value) {
        addContains(SubvisitColumns.DIFFICULTY_IN_BREATHING, value);
        return this;
    }

    public SubvisitSelection difficultyInBreathingStartsWith(String... value) {
        addStartsWith(SubvisitColumns.DIFFICULTY_IN_BREATHING, value);
        return this;
    }

    public SubvisitSelection difficultyInBreathingEndsWith(String... value) {
        addEndsWith(SubvisitColumns.DIFFICULTY_IN_BREATHING, value);
        return this;
    }

    public SubvisitSelection orderByDifficultyInBreathing(boolean desc) {
        orderBy(SubvisitColumns.DIFFICULTY_IN_BREATHING, desc);
        return this;
    }

    public SubvisitSelection orderByDifficultyInBreathing() {
        orderBy(SubvisitColumns.DIFFICULTY_IN_BREATHING, false);
        return this;
    }

    public SubvisitSelection vaginalBleedingWithAbdominalPain(String... value) {
        addEquals(SubvisitColumns.VAGINAL_BLEEDING_WITH_ABDOMINAL_PAIN, value);
        return this;
    }

    public SubvisitSelection vaginalBleedingWithAbdominalPainNot(String... value) {
        addNotEquals(SubvisitColumns.VAGINAL_BLEEDING_WITH_ABDOMINAL_PAIN, value);
        return this;
    }

    public SubvisitSelection vaginalBleedingWithAbdominalPainLike(String... value) {
        addLike(SubvisitColumns.VAGINAL_BLEEDING_WITH_ABDOMINAL_PAIN, value);
        return this;
    }

    public SubvisitSelection vaginalBleedingWithAbdominalPainContains(String... value) {
        addContains(SubvisitColumns.VAGINAL_BLEEDING_WITH_ABDOMINAL_PAIN, value);
        return this;
    }

    public SubvisitSelection vaginalBleedingWithAbdominalPainStartsWith(String... value) {
        addStartsWith(SubvisitColumns.VAGINAL_BLEEDING_WITH_ABDOMINAL_PAIN, value);
        return this;
    }

    public SubvisitSelection vaginalBleedingWithAbdominalPainEndsWith(String... value) {
        addEndsWith(SubvisitColumns.VAGINAL_BLEEDING_WITH_ABDOMINAL_PAIN, value);
        return this;
    }

    public SubvisitSelection orderByVaginalBleedingWithAbdominalPain(boolean desc) {
        orderBy(SubvisitColumns.VAGINAL_BLEEDING_WITH_ABDOMINAL_PAIN, desc);
        return this;
    }

    public SubvisitSelection orderByVaginalBleedingWithAbdominalPain() {
        orderBy(SubvisitColumns.VAGINAL_BLEEDING_WITH_ABDOMINAL_PAIN, false);
        return this;
    }

    public SubvisitSelection hypertensionDrugs(String... value) {
        addEquals(SubvisitColumns.HYPERTENSION_DRUGS, value);
        return this;
    }

    public SubvisitSelection hypertensionDrugsNot(String... value) {
        addNotEquals(SubvisitColumns.HYPERTENSION_DRUGS, value);
        return this;
    }

    public SubvisitSelection hypertensionDrugsLike(String... value) {
        addLike(SubvisitColumns.HYPERTENSION_DRUGS, value);
        return this;
    }

    public SubvisitSelection hypertensionDrugsContains(String... value) {
        addContains(SubvisitColumns.HYPERTENSION_DRUGS, value);
        return this;
    }

    public SubvisitSelection hypertensionDrugsStartsWith(String... value) {
        addStartsWith(SubvisitColumns.HYPERTENSION_DRUGS, value);
        return this;
    }

    public SubvisitSelection hypertensionDrugsEndsWith(String... value) {
        addEndsWith(SubvisitColumns.HYPERTENSION_DRUGS, value);
        return this;
    }

    public SubvisitSelection orderByHypertensionDrugs(boolean desc) {
        orderBy(SubvisitColumns.HYPERTENSION_DRUGS, desc);
        return this;
    }

    public SubvisitSelection orderByHypertensionDrugs() {
        orderBy(SubvisitColumns.HYPERTENSION_DRUGS, false);
        return this;
    }

    public SubvisitSelection diabetesDrugs(String... value) {
        addEquals(SubvisitColumns.DIABETES_DRUGS, value);
        return this;
    }

    public SubvisitSelection diabetesDrugsNot(String... value) {
        addNotEquals(SubvisitColumns.DIABETES_DRUGS, value);
        return this;
    }

    public SubvisitSelection diabetesDrugsLike(String... value) {
        addLike(SubvisitColumns.DIABETES_DRUGS, value);
        return this;
    }

    public SubvisitSelection diabetesDrugsContains(String... value) {
        addContains(SubvisitColumns.DIABETES_DRUGS, value);
        return this;
    }

    public SubvisitSelection diabetesDrugsStartsWith(String... value) {
        addStartsWith(SubvisitColumns.DIABETES_DRUGS, value);
        return this;
    }

    public SubvisitSelection diabetesDrugsEndsWith(String... value) {
        addEndsWith(SubvisitColumns.DIABETES_DRUGS, value);
        return this;
    }

    public SubvisitSelection orderByDiabetesDrugs(boolean desc) {
        orderBy(SubvisitColumns.DIABETES_DRUGS, desc);
        return this;
    }

    public SubvisitSelection orderByDiabetesDrugs() {
        orderBy(SubvisitColumns.DIABETES_DRUGS, false);
        return this;
    }

    public SubvisitSelection ironTablets(String... value) {
        addEquals(SubvisitColumns.IRON_TABLETS, value);
        return this;
    }

    public SubvisitSelection ironTabletsNot(String... value) {
        addNotEquals(SubvisitColumns.IRON_TABLETS, value);
        return this;
    }

    public SubvisitSelection ironTabletsLike(String... value) {
        addLike(SubvisitColumns.IRON_TABLETS, value);
        return this;
    }

    public SubvisitSelection ironTabletsContains(String... value) {
        addContains(SubvisitColumns.IRON_TABLETS, value);
        return this;
    }

    public SubvisitSelection ironTabletsStartsWith(String... value) {
        addStartsWith(SubvisitColumns.IRON_TABLETS, value);
        return this;
    }

    public SubvisitSelection ironTabletsEndsWith(String... value) {
        addEndsWith(SubvisitColumns.IRON_TABLETS, value);
        return this;
    }

    public SubvisitSelection orderByIronTablets(boolean desc) {
        orderBy(SubvisitColumns.IRON_TABLETS, desc);
        return this;
    }

    public SubvisitSelection orderByIronTablets() {
        orderBy(SubvisitColumns.IRON_TABLETS, false);
        return this;
    }

    public SubvisitSelection folicAcidTablets(String... value) {
        addEquals(SubvisitColumns.FOLIC_ACID_TABLETS, value);
        return this;
    }

    public SubvisitSelection folicAcidTabletsNot(String... value) {
        addNotEquals(SubvisitColumns.FOLIC_ACID_TABLETS, value);
        return this;
    }

    public SubvisitSelection folicAcidTabletsLike(String... value) {
        addLike(SubvisitColumns.FOLIC_ACID_TABLETS, value);
        return this;
    }

    public SubvisitSelection folicAcidTabletsContains(String... value) {
        addContains(SubvisitColumns.FOLIC_ACID_TABLETS, value);
        return this;
    }

    public SubvisitSelection folicAcidTabletsStartsWith(String... value) {
        addStartsWith(SubvisitColumns.FOLIC_ACID_TABLETS, value);
        return this;
    }

    public SubvisitSelection folicAcidTabletsEndsWith(String... value) {
        addEndsWith(SubvisitColumns.FOLIC_ACID_TABLETS, value);
        return this;
    }

    public SubvisitSelection orderByFolicAcidTablets(boolean desc) {
        orderBy(SubvisitColumns.FOLIC_ACID_TABLETS, desc);
        return this;
    }

    public SubvisitSelection orderByFolicAcidTablets() {
        orderBy(SubvisitColumns.FOLIC_ACID_TABLETS, false);
        return this;
    }

    public SubvisitSelection anyOtherSpecify(String... value) {
        addEquals(SubvisitColumns.ANY_OTHER_SPECIFY, value);
        return this;
    }

    public SubvisitSelection anyOtherSpecifyNot(String... value) {
        addNotEquals(SubvisitColumns.ANY_OTHER_SPECIFY, value);
        return this;
    }

    public SubvisitSelection anyOtherSpecifyLike(String... value) {
        addLike(SubvisitColumns.ANY_OTHER_SPECIFY, value);
        return this;
    }

    public SubvisitSelection anyOtherSpecifyContains(String... value) {
        addContains(SubvisitColumns.ANY_OTHER_SPECIFY, value);
        return this;
    }

    public SubvisitSelection anyOtherSpecifyStartsWith(String... value) {
        addStartsWith(SubvisitColumns.ANY_OTHER_SPECIFY, value);
        return this;
    }

    public SubvisitSelection anyOtherSpecifyEndsWith(String... value) {
        addEndsWith(SubvisitColumns.ANY_OTHER_SPECIFY, value);
        return this;
    }

    public SubvisitSelection orderByAnyOtherSpecify(boolean desc) {
        orderBy(SubvisitColumns.ANY_OTHER_SPECIFY, desc);
        return this;
    }

    public SubvisitSelection orderByAnyOtherSpecify() {
        orderBy(SubvisitColumns.ANY_OTHER_SPECIFY, false);
        return this;
    }

    public SubvisitSelection anyMultipleGestation(String... value) {
        addEquals(SubvisitColumns.ANY_MULTIPLE_GESTATION, value);
        return this;
    }

    public SubvisitSelection anyMultipleGestationNot(String... value) {
        addNotEquals(SubvisitColumns.ANY_MULTIPLE_GESTATION, value);
        return this;
    }

    public SubvisitSelection anyMultipleGestationLike(String... value) {
        addLike(SubvisitColumns.ANY_MULTIPLE_GESTATION, value);
        return this;
    }

    public SubvisitSelection anyMultipleGestationContains(String... value) {
        addContains(SubvisitColumns.ANY_MULTIPLE_GESTATION, value);
        return this;
    }

    public SubvisitSelection anyMultipleGestationStartsWith(String... value) {
        addStartsWith(SubvisitColumns.ANY_MULTIPLE_GESTATION, value);
        return this;
    }

    public SubvisitSelection anyMultipleGestationEndsWith(String... value) {
        addEndsWith(SubvisitColumns.ANY_MULTIPLE_GESTATION, value);
        return this;
    }

    public SubvisitSelection orderByAnyMultipleGestation(boolean desc) {
        orderBy(SubvisitColumns.ANY_MULTIPLE_GESTATION, desc);
        return this;
    }

    public SubvisitSelection orderByAnyMultipleGestation() {
        orderBy(SubvisitColumns.ANY_MULTIPLE_GESTATION, false);
        return this;
    }
}
