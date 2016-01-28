package johnkagga.me.celestini.provider.subvisit;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import johnkagga.me.celestini.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code subvisit} table.
 */
public class SubvisitContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return SubvisitColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable SubvisitSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable SubvisitSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Patient Id
     */
    public SubvisitContentValues putPatientId(@Nullable String value) {
        mContentValues.put(SubvisitColumns.PATIENT_ID, value);
        return this;
    }

    public SubvisitContentValues putPatientIdNull() {
        mContentValues.putNull(SubvisitColumns.PATIENT_ID);
        return this;
    }

    /**
     * Chronic problem
     */
    public SubvisitContentValues putAnyOtherChronicMedicalProblem(@Nullable String value) {
        mContentValues.put(SubvisitColumns.ANY_OTHER_CHRONIC_MEDICAL_PROBLEM, value);
        return this;
    }

    public SubvisitContentValues putAnyOtherChronicMedicalProblemNull() {
        mContentValues.putNull(SubvisitColumns.ANY_OTHER_CHRONIC_MEDICAL_PROBLEM);
        return this;
    }

    public SubvisitContentValues putHeadPain(@Nullable String value) {
        mContentValues.put(SubvisitColumns.HEAD_PAIN, value);
        return this;
    }

    public SubvisitContentValues putHeadPainNull() {
        mContentValues.putNull(SubvisitColumns.HEAD_PAIN);
        return this;
    }

    public SubvisitContentValues putEpigastricPain(@Nullable String value) {
        mContentValues.put(SubvisitColumns.EPIGASTRIC_PAIN, value);
        return this;
    }

    public SubvisitContentValues putEpigastricPainNull() {
        mContentValues.putNull(SubvisitColumns.EPIGASTRIC_PAIN);
        return this;
    }

    /**
     * Fever
     */
    public SubvisitContentValues putFever(@Nullable String value) {
        mContentValues.put(SubvisitColumns.FEVER, value);
        return this;
    }

    public SubvisitContentValues putFeverNull() {
        mContentValues.putNull(SubvisitColumns.FEVER);
        return this;
    }

    /**
     * Nausea and vomiting
     */
    public SubvisitContentValues putNauseaVomiting(@Nullable String value) {
        mContentValues.put(SubvisitColumns.NAUSEA_VOMITING, value);
        return this;
    }

    public SubvisitContentValues putNauseaVomitingNull() {
        mContentValues.putNull(SubvisitColumns.NAUSEA_VOMITING);
        return this;
    }

    public SubvisitContentValues putVisualDisturbances(@Nullable String value) {
        mContentValues.put(SubvisitColumns.VISUAL_DISTURBANCES, value);
        return this;
    }

    public SubvisitContentValues putVisualDisturbancesNull() {
        mContentValues.putNull(SubvisitColumns.VISUAL_DISTURBANCES);
        return this;
    }

    /**
     * Chest pain
     */
    public SubvisitContentValues putChestPain(@Nullable String value) {
        mContentValues.put(SubvisitColumns.CHEST_PAIN, value);
        return this;
    }

    public SubvisitContentValues putChestPainNull() {
        mContentValues.putNull(SubvisitColumns.CHEST_PAIN);
        return this;
    }

    /**
     * Difficulty in breathing
     */
    public SubvisitContentValues putDifficultyInBreathing(@Nullable String value) {
        mContentValues.put(SubvisitColumns.DIFFICULTY_IN_BREATHING, value);
        return this;
    }

    public SubvisitContentValues putDifficultyInBreathingNull() {
        mContentValues.putNull(SubvisitColumns.DIFFICULTY_IN_BREATHING);
        return this;
    }

    public SubvisitContentValues putVaginalBleedingWithAbdominalPain(@Nullable String value) {
        mContentValues.put(SubvisitColumns.VAGINAL_BLEEDING_WITH_ABDOMINAL_PAIN, value);
        return this;
    }

    public SubvisitContentValues putVaginalBleedingWithAbdominalPainNull() {
        mContentValues.putNull(SubvisitColumns.VAGINAL_BLEEDING_WITH_ABDOMINAL_PAIN);
        return this;
    }

    /**
     * Hypertension drugs
     */
    public SubvisitContentValues putHypertensionDrugs(@Nullable String value) {
        mContentValues.put(SubvisitColumns.HYPERTENSION_DRUGS, value);
        return this;
    }

    public SubvisitContentValues putHypertensionDrugsNull() {
        mContentValues.putNull(SubvisitColumns.HYPERTENSION_DRUGS);
        return this;
    }

    /**
     * Diabetes drugs
     */
    public SubvisitContentValues putDiabetesDrugs(@Nullable String value) {
        mContentValues.put(SubvisitColumns.DIABETES_DRUGS, value);
        return this;
    }

    public SubvisitContentValues putDiabetesDrugsNull() {
        mContentValues.putNull(SubvisitColumns.DIABETES_DRUGS);
        return this;
    }

    public SubvisitContentValues putIronTablets(@Nullable String value) {
        mContentValues.put(SubvisitColumns.IRON_TABLETS, value);
        return this;
    }

    public SubvisitContentValues putIronTabletsNull() {
        mContentValues.putNull(SubvisitColumns.IRON_TABLETS);
        return this;
    }

    /**
     * Folic acid tablets
     */
    public SubvisitContentValues putFolicAcidTablets(@Nullable String value) {
        mContentValues.put(SubvisitColumns.FOLIC_ACID_TABLETS, value);
        return this;
    }

    public SubvisitContentValues putFolicAcidTabletsNull() {
        mContentValues.putNull(SubvisitColumns.FOLIC_ACID_TABLETS);
        return this;
    }

    /**
     * Any other drugs
     */
    public SubvisitContentValues putAnyOtherSpecify(@Nullable String value) {
        mContentValues.put(SubvisitColumns.ANY_OTHER_SPECIFY, value);
        return this;
    }

    public SubvisitContentValues putAnyOtherSpecifyNull() {
        mContentValues.putNull(SubvisitColumns.ANY_OTHER_SPECIFY);
        return this;
    }

    public SubvisitContentValues putAnyMultipleGestation(@Nullable String value) {
        mContentValues.put(SubvisitColumns.ANY_MULTIPLE_GESTATION, value);
        return this;
    }

    public SubvisitContentValues putAnyMultipleGestationNull() {
        mContentValues.putNull(SubvisitColumns.ANY_MULTIPLE_GESTATION);
        return this;
    }
}
