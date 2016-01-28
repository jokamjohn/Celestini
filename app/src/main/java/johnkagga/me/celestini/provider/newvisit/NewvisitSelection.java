package johnkagga.me.celestini.provider.newvisit;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import johnkagga.me.celestini.provider.base.AbstractSelection;

/**
 * Selection for the {@code newvisit} table.
 */
public class NewvisitSelection extends AbstractSelection<NewvisitSelection> {
    @Override
    protected Uri baseUri() {
        return NewvisitColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code NewvisitCursor} object, which is positioned before the first entry, or null.
     */
    public NewvisitCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new NewvisitCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public NewvisitCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code NewvisitCursor} object, which is positioned before the first entry, or null.
     */
    public NewvisitCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new NewvisitCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public NewvisitCursor query(Context context) {
        return query(context, null);
    }


    public NewvisitSelection id(long... value) {
        addEquals("newvisit." + NewvisitColumns._ID, toObjectArray(value));
        return this;
    }

    public NewvisitSelection idNot(long... value) {
        addNotEquals("newvisit." + NewvisitColumns._ID, toObjectArray(value));
        return this;
    }

    public NewvisitSelection orderById(boolean desc) {
        orderBy("newvisit." + NewvisitColumns._ID, desc);
        return this;
    }

    public NewvisitSelection orderById() {
        return orderById(false);
    }

    public NewvisitSelection hospitalAddress(String... value) {
        addEquals(NewvisitColumns.HOSPITAL_ADDRESS, value);
        return this;
    }

    public NewvisitSelection hospitalAddressNot(String... value) {
        addNotEquals(NewvisitColumns.HOSPITAL_ADDRESS, value);
        return this;
    }

    public NewvisitSelection hospitalAddressLike(String... value) {
        addLike(NewvisitColumns.HOSPITAL_ADDRESS, value);
        return this;
    }

    public NewvisitSelection hospitalAddressContains(String... value) {
        addContains(NewvisitColumns.HOSPITAL_ADDRESS, value);
        return this;
    }

    public NewvisitSelection hospitalAddressStartsWith(String... value) {
        addStartsWith(NewvisitColumns.HOSPITAL_ADDRESS, value);
        return this;
    }

    public NewvisitSelection hospitalAddressEndsWith(String... value) {
        addEndsWith(NewvisitColumns.HOSPITAL_ADDRESS, value);
        return this;
    }

    public NewvisitSelection orderByHospitalAddress(boolean desc) {
        orderBy(NewvisitColumns.HOSPITAL_ADDRESS, desc);
        return this;
    }

    public NewvisitSelection orderByHospitalAddress() {
        orderBy(NewvisitColumns.HOSPITAL_ADDRESS, false);
        return this;
    }

    public NewvisitSelection hospitalName(String... value) {
        addEquals(NewvisitColumns.HOSPITAL_NAME, value);
        return this;
    }

    public NewvisitSelection hospitalNameNot(String... value) {
        addNotEquals(NewvisitColumns.HOSPITAL_NAME, value);
        return this;
    }

    public NewvisitSelection hospitalNameLike(String... value) {
        addLike(NewvisitColumns.HOSPITAL_NAME, value);
        return this;
    }

    public NewvisitSelection hospitalNameContains(String... value) {
        addContains(NewvisitColumns.HOSPITAL_NAME, value);
        return this;
    }

    public NewvisitSelection hospitalNameStartsWith(String... value) {
        addStartsWith(NewvisitColumns.HOSPITAL_NAME, value);
        return this;
    }

    public NewvisitSelection hospitalNameEndsWith(String... value) {
        addEndsWith(NewvisitColumns.HOSPITAL_NAME, value);
        return this;
    }

    public NewvisitSelection orderByHospitalName(boolean desc) {
        orderBy(NewvisitColumns.HOSPITAL_NAME, desc);
        return this;
    }

    public NewvisitSelection orderByHospitalName() {
        orderBy(NewvisitColumns.HOSPITAL_NAME, false);
        return this;
    }

    public NewvisitSelection visitNo(Integer... value) {
        addEquals(NewvisitColumns.VISIT_NO, value);
        return this;
    }

    public NewvisitSelection visitNoNot(Integer... value) {
        addNotEquals(NewvisitColumns.VISIT_NO, value);
        return this;
    }

    public NewvisitSelection visitNoGt(int value) {
        addGreaterThan(NewvisitColumns.VISIT_NO, value);
        return this;
    }

    public NewvisitSelection visitNoGtEq(int value) {
        addGreaterThanOrEquals(NewvisitColumns.VISIT_NO, value);
        return this;
    }

    public NewvisitSelection visitNoLt(int value) {
        addLessThan(NewvisitColumns.VISIT_NO, value);
        return this;
    }

    public NewvisitSelection visitNoLtEq(int value) {
        addLessThanOrEquals(NewvisitColumns.VISIT_NO, value);
        return this;
    }

    public NewvisitSelection orderByVisitNo(boolean desc) {
        orderBy(NewvisitColumns.VISIT_NO, desc);
        return this;
    }

    public NewvisitSelection orderByVisitNo() {
        orderBy(NewvisitColumns.VISIT_NO, false);
        return this;
    }

    public NewvisitSelection patientName(String... value) {
        addEquals(NewvisitColumns.PATIENT_NAME, value);
        return this;
    }

    public NewvisitSelection patientNameNot(String... value) {
        addNotEquals(NewvisitColumns.PATIENT_NAME, value);
        return this;
    }

    public NewvisitSelection patientNameLike(String... value) {
        addLike(NewvisitColumns.PATIENT_NAME, value);
        return this;
    }

    public NewvisitSelection patientNameContains(String... value) {
        addContains(NewvisitColumns.PATIENT_NAME, value);
        return this;
    }

    public NewvisitSelection patientNameStartsWith(String... value) {
        addStartsWith(NewvisitColumns.PATIENT_NAME, value);
        return this;
    }

    public NewvisitSelection patientNameEndsWith(String... value) {
        addEndsWith(NewvisitColumns.PATIENT_NAME, value);
        return this;
    }

    public NewvisitSelection orderByPatientName(boolean desc) {
        orderBy(NewvisitColumns.PATIENT_NAME, desc);
        return this;
    }

    public NewvisitSelection orderByPatientName() {
        orderBy(NewvisitColumns.PATIENT_NAME, false);
        return this;
    }

    public NewvisitSelection homeDistrict(String... value) {
        addEquals(NewvisitColumns.HOME_DISTRICT, value);
        return this;
    }

    public NewvisitSelection homeDistrictNot(String... value) {
        addNotEquals(NewvisitColumns.HOME_DISTRICT, value);
        return this;
    }

    public NewvisitSelection homeDistrictLike(String... value) {
        addLike(NewvisitColumns.HOME_DISTRICT, value);
        return this;
    }

    public NewvisitSelection homeDistrictContains(String... value) {
        addContains(NewvisitColumns.HOME_DISTRICT, value);
        return this;
    }

    public NewvisitSelection homeDistrictStartsWith(String... value) {
        addStartsWith(NewvisitColumns.HOME_DISTRICT, value);
        return this;
    }

    public NewvisitSelection homeDistrictEndsWith(String... value) {
        addEndsWith(NewvisitColumns.HOME_DISTRICT, value);
        return this;
    }

    public NewvisitSelection orderByHomeDistrict(boolean desc) {
        orderBy(NewvisitColumns.HOME_DISTRICT, desc);
        return this;
    }

    public NewvisitSelection orderByHomeDistrict() {
        orderBy(NewvisitColumns.HOME_DISTRICT, false);
        return this;
    }

    public NewvisitSelection dob(Date... value) {
        addEquals(NewvisitColumns.DOB, value);
        return this;
    }

    public NewvisitSelection dobNot(Date... value) {
        addNotEquals(NewvisitColumns.DOB, value);
        return this;
    }

    public NewvisitSelection dob(Long... value) {
        addEquals(NewvisitColumns.DOB, value);
        return this;
    }

    public NewvisitSelection dobAfter(Date value) {
        addGreaterThan(NewvisitColumns.DOB, value);
        return this;
    }

    public NewvisitSelection dobAfterEq(Date value) {
        addGreaterThanOrEquals(NewvisitColumns.DOB, value);
        return this;
    }

    public NewvisitSelection dobBefore(Date value) {
        addLessThan(NewvisitColumns.DOB, value);
        return this;
    }

    public NewvisitSelection dobBeforeEq(Date value) {
        addLessThanOrEquals(NewvisitColumns.DOB, value);
        return this;
    }

    public NewvisitSelection orderByDob(boolean desc) {
        orderBy(NewvisitColumns.DOB, desc);
        return this;
    }

    public NewvisitSelection orderByDob() {
        orderBy(NewvisitColumns.DOB, false);
        return this;
    }

    public NewvisitSelection educationLevel(String... value) {
        addEquals(NewvisitColumns.EDUCATION_LEVEL, value);
        return this;
    }

    public NewvisitSelection educationLevelNot(String... value) {
        addNotEquals(NewvisitColumns.EDUCATION_LEVEL, value);
        return this;
    }

    public NewvisitSelection educationLevelLike(String... value) {
        addLike(NewvisitColumns.EDUCATION_LEVEL, value);
        return this;
    }

    public NewvisitSelection educationLevelContains(String... value) {
        addContains(NewvisitColumns.EDUCATION_LEVEL, value);
        return this;
    }

    public NewvisitSelection educationLevelStartsWith(String... value) {
        addStartsWith(NewvisitColumns.EDUCATION_LEVEL, value);
        return this;
    }

    public NewvisitSelection educationLevelEndsWith(String... value) {
        addEndsWith(NewvisitColumns.EDUCATION_LEVEL, value);
        return this;
    }

    public NewvisitSelection orderByEducationLevel(boolean desc) {
        orderBy(NewvisitColumns.EDUCATION_LEVEL, desc);
        return this;
    }

    public NewvisitSelection orderByEducationLevel() {
        orderBy(NewvisitColumns.EDUCATION_LEVEL, false);
        return this;
    }

    public NewvisitSelection tribe(String... value) {
        addEquals(NewvisitColumns.TRIBE, value);
        return this;
    }

    public NewvisitSelection tribeNot(String... value) {
        addNotEquals(NewvisitColumns.TRIBE, value);
        return this;
    }

    public NewvisitSelection tribeLike(String... value) {
        addLike(NewvisitColumns.TRIBE, value);
        return this;
    }

    public NewvisitSelection tribeContains(String... value) {
        addContains(NewvisitColumns.TRIBE, value);
        return this;
    }

    public NewvisitSelection tribeStartsWith(String... value) {
        addStartsWith(NewvisitColumns.TRIBE, value);
        return this;
    }

    public NewvisitSelection tribeEndsWith(String... value) {
        addEndsWith(NewvisitColumns.TRIBE, value);
        return this;
    }

    public NewvisitSelection orderByTribe(boolean desc) {
        orderBy(NewvisitColumns.TRIBE, desc);
        return this;
    }

    public NewvisitSelection orderByTribe() {
        orderBy(NewvisitColumns.TRIBE, false);
        return this;
    }

    public NewvisitSelection religion(String... value) {
        addEquals(NewvisitColumns.RELIGION, value);
        return this;
    }

    public NewvisitSelection religionNot(String... value) {
        addNotEquals(NewvisitColumns.RELIGION, value);
        return this;
    }

    public NewvisitSelection religionLike(String... value) {
        addLike(NewvisitColumns.RELIGION, value);
        return this;
    }

    public NewvisitSelection religionContains(String... value) {
        addContains(NewvisitColumns.RELIGION, value);
        return this;
    }

    public NewvisitSelection religionStartsWith(String... value) {
        addStartsWith(NewvisitColumns.RELIGION, value);
        return this;
    }

    public NewvisitSelection religionEndsWith(String... value) {
        addEndsWith(NewvisitColumns.RELIGION, value);
        return this;
    }

    public NewvisitSelection orderByReligion(boolean desc) {
        orderBy(NewvisitColumns.RELIGION, desc);
        return this;
    }

    public NewvisitSelection orderByReligion() {
        orderBy(NewvisitColumns.RELIGION, false);
        return this;
    }

    public NewvisitSelection occupation(String... value) {
        addEquals(NewvisitColumns.OCCUPATION, value);
        return this;
    }

    public NewvisitSelection occupationNot(String... value) {
        addNotEquals(NewvisitColumns.OCCUPATION, value);
        return this;
    }

    public NewvisitSelection occupationLike(String... value) {
        addLike(NewvisitColumns.OCCUPATION, value);
        return this;
    }

    public NewvisitSelection occupationContains(String... value) {
        addContains(NewvisitColumns.OCCUPATION, value);
        return this;
    }

    public NewvisitSelection occupationStartsWith(String... value) {
        addStartsWith(NewvisitColumns.OCCUPATION, value);
        return this;
    }

    public NewvisitSelection occupationEndsWith(String... value) {
        addEndsWith(NewvisitColumns.OCCUPATION, value);
        return this;
    }

    public NewvisitSelection orderByOccupation(boolean desc) {
        orderBy(NewvisitColumns.OCCUPATION, desc);
        return this;
    }

    public NewvisitSelection orderByOccupation() {
        orderBy(NewvisitColumns.OCCUPATION, false);
        return this;
    }

    public NewvisitSelection town(String... value) {
        addEquals(NewvisitColumns.TOWN, value);
        return this;
    }

    public NewvisitSelection townNot(String... value) {
        addNotEquals(NewvisitColumns.TOWN, value);
        return this;
    }

    public NewvisitSelection townLike(String... value) {
        addLike(NewvisitColumns.TOWN, value);
        return this;
    }

    public NewvisitSelection townContains(String... value) {
        addContains(NewvisitColumns.TOWN, value);
        return this;
    }

    public NewvisitSelection townStartsWith(String... value) {
        addStartsWith(NewvisitColumns.TOWN, value);
        return this;
    }

    public NewvisitSelection townEndsWith(String... value) {
        addEndsWith(NewvisitColumns.TOWN, value);
        return this;
    }

    public NewvisitSelection orderByTown(boolean desc) {
        orderBy(NewvisitColumns.TOWN, desc);
        return this;
    }

    public NewvisitSelection orderByTown() {
        orderBy(NewvisitColumns.TOWN, false);
        return this;
    }

    public NewvisitSelection bloodpressure(String... value) {
        addEquals(NewvisitColumns.BLOODPRESSURE, value);
        return this;
    }

    public NewvisitSelection bloodpressureNot(String... value) {
        addNotEquals(NewvisitColumns.BLOODPRESSURE, value);
        return this;
    }

    public NewvisitSelection bloodpressureLike(String... value) {
        addLike(NewvisitColumns.BLOODPRESSURE, value);
        return this;
    }

    public NewvisitSelection bloodpressureContains(String... value) {
        addContains(NewvisitColumns.BLOODPRESSURE, value);
        return this;
    }

    public NewvisitSelection bloodpressureStartsWith(String... value) {
        addStartsWith(NewvisitColumns.BLOODPRESSURE, value);
        return this;
    }

    public NewvisitSelection bloodpressureEndsWith(String... value) {
        addEndsWith(NewvisitColumns.BLOODPRESSURE, value);
        return this;
    }

    public NewvisitSelection orderByBloodpressure(boolean desc) {
        orderBy(NewvisitColumns.BLOODPRESSURE, desc);
        return this;
    }

    public NewvisitSelection orderByBloodpressure() {
        orderBy(NewvisitColumns.BLOODPRESSURE, false);
        return this;
    }

    public NewvisitSelection parityNoOfPregnancies(Integer... value) {
        addEquals(NewvisitColumns.PARITY_NO_OF_PREGNANCIES, value);
        return this;
    }

    public NewvisitSelection parityNoOfPregnanciesNot(Integer... value) {
        addNotEquals(NewvisitColumns.PARITY_NO_OF_PREGNANCIES, value);
        return this;
    }

    public NewvisitSelection parityNoOfPregnanciesGt(int value) {
        addGreaterThan(NewvisitColumns.PARITY_NO_OF_PREGNANCIES, value);
        return this;
    }

    public NewvisitSelection parityNoOfPregnanciesGtEq(int value) {
        addGreaterThanOrEquals(NewvisitColumns.PARITY_NO_OF_PREGNANCIES, value);
        return this;
    }

    public NewvisitSelection parityNoOfPregnanciesLt(int value) {
        addLessThan(NewvisitColumns.PARITY_NO_OF_PREGNANCIES, value);
        return this;
    }

    public NewvisitSelection parityNoOfPregnanciesLtEq(int value) {
        addLessThanOrEquals(NewvisitColumns.PARITY_NO_OF_PREGNANCIES, value);
        return this;
    }

    public NewvisitSelection orderByParityNoOfPregnancies(boolean desc) {
        orderBy(NewvisitColumns.PARITY_NO_OF_PREGNANCIES, desc);
        return this;
    }

    public NewvisitSelection orderByParityNoOfPregnancies() {
        orderBy(NewvisitColumns.PARITY_NO_OF_PREGNANCIES, false);
        return this;
    }

    public NewvisitSelection pregnancyOutcome(String... value) {
        addEquals(NewvisitColumns.PREGNANCY_OUTCOME, value);
        return this;
    }

    public NewvisitSelection pregnancyOutcomeNot(String... value) {
        addNotEquals(NewvisitColumns.PREGNANCY_OUTCOME, value);
        return this;
    }

    public NewvisitSelection pregnancyOutcomeLike(String... value) {
        addLike(NewvisitColumns.PREGNANCY_OUTCOME, value);
        return this;
    }

    public NewvisitSelection pregnancyOutcomeContains(String... value) {
        addContains(NewvisitColumns.PREGNANCY_OUTCOME, value);
        return this;
    }

    public NewvisitSelection pregnancyOutcomeStartsWith(String... value) {
        addStartsWith(NewvisitColumns.PREGNANCY_OUTCOME, value);
        return this;
    }

    public NewvisitSelection pregnancyOutcomeEndsWith(String... value) {
        addEndsWith(NewvisitColumns.PREGNANCY_OUTCOME, value);
        return this;
    }

    public NewvisitSelection orderByPregnancyOutcome(boolean desc) {
        orderBy(NewvisitColumns.PREGNANCY_OUTCOME, desc);
        return this;
    }

    public NewvisitSelection orderByPregnancyOutcome() {
        orderBy(NewvisitColumns.PREGNANCY_OUTCOME, false);
        return this;
    }

    public NewvisitSelection pastPregnancyHypertensionHistory(String... value) {
        addEquals(NewvisitColumns.PAST_PREGNANCY_HYPERTENSION_HISTORY, value);
        return this;
    }

    public NewvisitSelection pastPregnancyHypertensionHistoryNot(String... value) {
        addNotEquals(NewvisitColumns.PAST_PREGNANCY_HYPERTENSION_HISTORY, value);
        return this;
    }

    public NewvisitSelection pastPregnancyHypertensionHistoryLike(String... value) {
        addLike(NewvisitColumns.PAST_PREGNANCY_HYPERTENSION_HISTORY, value);
        return this;
    }

    public NewvisitSelection pastPregnancyHypertensionHistoryContains(String... value) {
        addContains(NewvisitColumns.PAST_PREGNANCY_HYPERTENSION_HISTORY, value);
        return this;
    }

    public NewvisitSelection pastPregnancyHypertensionHistoryStartsWith(String... value) {
        addStartsWith(NewvisitColumns.PAST_PREGNANCY_HYPERTENSION_HISTORY, value);
        return this;
    }

    public NewvisitSelection pastPregnancyHypertensionHistoryEndsWith(String... value) {
        addEndsWith(NewvisitColumns.PAST_PREGNANCY_HYPERTENSION_HISTORY, value);
        return this;
    }

    public NewvisitSelection orderByPastPregnancyHypertensionHistory(boolean desc) {
        orderBy(NewvisitColumns.PAST_PREGNANCY_HYPERTENSION_HISTORY, desc);
        return this;
    }

    public NewvisitSelection orderByPastPregnancyHypertensionHistory() {
        orderBy(NewvisitColumns.PAST_PREGNANCY_HYPERTENSION_HISTORY, false);
        return this;
    }

    public NewvisitSelection lastNormalMpDate(String... value) {
        addEquals(NewvisitColumns.LAST_NORMAL_MP_DATE, value);
        return this;
    }

    public NewvisitSelection lastNormalMpDateNot(String... value) {
        addNotEquals(NewvisitColumns.LAST_NORMAL_MP_DATE, value);
        return this;
    }

    public NewvisitSelection lastNormalMpDateLike(String... value) {
        addLike(NewvisitColumns.LAST_NORMAL_MP_DATE, value);
        return this;
    }

    public NewvisitSelection lastNormalMpDateContains(String... value) {
        addContains(NewvisitColumns.LAST_NORMAL_MP_DATE, value);
        return this;
    }

    public NewvisitSelection lastNormalMpDateStartsWith(String... value) {
        addStartsWith(NewvisitColumns.LAST_NORMAL_MP_DATE, value);
        return this;
    }

    public NewvisitSelection lastNormalMpDateEndsWith(String... value) {
        addEndsWith(NewvisitColumns.LAST_NORMAL_MP_DATE, value);
        return this;
    }

    public NewvisitSelection orderByLastNormalMpDate(boolean desc) {
        orderBy(NewvisitColumns.LAST_NORMAL_MP_DATE, desc);
        return this;
    }

    public NewvisitSelection orderByLastNormalMpDate() {
        orderBy(NewvisitColumns.LAST_NORMAL_MP_DATE, false);
        return this;
    }

    public NewvisitSelection previousCaesarean(String... value) {
        addEquals(NewvisitColumns.PREVIOUS_CAESAREAN, value);
        return this;
    }

    public NewvisitSelection previousCaesareanNot(String... value) {
        addNotEquals(NewvisitColumns.PREVIOUS_CAESAREAN, value);
        return this;
    }

    public NewvisitSelection previousCaesareanLike(String... value) {
        addLike(NewvisitColumns.PREVIOUS_CAESAREAN, value);
        return this;
    }

    public NewvisitSelection previousCaesareanContains(String... value) {
        addContains(NewvisitColumns.PREVIOUS_CAESAREAN, value);
        return this;
    }

    public NewvisitSelection previousCaesareanStartsWith(String... value) {
        addStartsWith(NewvisitColumns.PREVIOUS_CAESAREAN, value);
        return this;
    }

    public NewvisitSelection previousCaesareanEndsWith(String... value) {
        addEndsWith(NewvisitColumns.PREVIOUS_CAESAREAN, value);
        return this;
    }

    public NewvisitSelection orderByPreviousCaesarean(boolean desc) {
        orderBy(NewvisitColumns.PREVIOUS_CAESAREAN, desc);
        return this;
    }

    public NewvisitSelection orderByPreviousCaesarean() {
        orderBy(NewvisitColumns.PREVIOUS_CAESAREAN, false);
        return this;
    }

    public NewvisitSelection hypertensionBeforePregnancy(String... value) {
        addEquals(NewvisitColumns.HYPERTENSION_BEFORE_PREGNANCY, value);
        return this;
    }

    public NewvisitSelection hypertensionBeforePregnancyNot(String... value) {
        addNotEquals(NewvisitColumns.HYPERTENSION_BEFORE_PREGNANCY, value);
        return this;
    }

    public NewvisitSelection hypertensionBeforePregnancyLike(String... value) {
        addLike(NewvisitColumns.HYPERTENSION_BEFORE_PREGNANCY, value);
        return this;
    }

    public NewvisitSelection hypertensionBeforePregnancyContains(String... value) {
        addContains(NewvisitColumns.HYPERTENSION_BEFORE_PREGNANCY, value);
        return this;
    }

    public NewvisitSelection hypertensionBeforePregnancyStartsWith(String... value) {
        addStartsWith(NewvisitColumns.HYPERTENSION_BEFORE_PREGNANCY, value);
        return this;
    }

    public NewvisitSelection hypertensionBeforePregnancyEndsWith(String... value) {
        addEndsWith(NewvisitColumns.HYPERTENSION_BEFORE_PREGNANCY, value);
        return this;
    }

    public NewvisitSelection orderByHypertensionBeforePregnancy(boolean desc) {
        orderBy(NewvisitColumns.HYPERTENSION_BEFORE_PREGNANCY, desc);
        return this;
    }

    public NewvisitSelection orderByHypertensionBeforePregnancy() {
        orderBy(NewvisitColumns.HYPERTENSION_BEFORE_PREGNANCY, false);
        return this;
    }

    public NewvisitSelection diabeticBeforePregnancy(String... value) {
        addEquals(NewvisitColumns.DIABETIC_BEFORE_PREGNANCY, value);
        return this;
    }

    public NewvisitSelection diabeticBeforePregnancyNot(String... value) {
        addNotEquals(NewvisitColumns.DIABETIC_BEFORE_PREGNANCY, value);
        return this;
    }

    public NewvisitSelection diabeticBeforePregnancyLike(String... value) {
        addLike(NewvisitColumns.DIABETIC_BEFORE_PREGNANCY, value);
        return this;
    }

    public NewvisitSelection diabeticBeforePregnancyContains(String... value) {
        addContains(NewvisitColumns.DIABETIC_BEFORE_PREGNANCY, value);
        return this;
    }

    public NewvisitSelection diabeticBeforePregnancyStartsWith(String... value) {
        addStartsWith(NewvisitColumns.DIABETIC_BEFORE_PREGNANCY, value);
        return this;
    }

    public NewvisitSelection diabeticBeforePregnancyEndsWith(String... value) {
        addEndsWith(NewvisitColumns.DIABETIC_BEFORE_PREGNANCY, value);
        return this;
    }

    public NewvisitSelection orderByDiabeticBeforePregnancy(boolean desc) {
        orderBy(NewvisitColumns.DIABETIC_BEFORE_PREGNANCY, desc);
        return this;
    }

    public NewvisitSelection orderByDiabeticBeforePregnancy() {
        orderBy(NewvisitColumns.DIABETIC_BEFORE_PREGNANCY, false);
        return this;
    }

    public NewvisitSelection chronicRenalDisease(String... value) {
        addEquals(NewvisitColumns.CHRONIC_RENAL_DISEASE, value);
        return this;
    }

    public NewvisitSelection chronicRenalDiseaseNot(String... value) {
        addNotEquals(NewvisitColumns.CHRONIC_RENAL_DISEASE, value);
        return this;
    }

    public NewvisitSelection chronicRenalDiseaseLike(String... value) {
        addLike(NewvisitColumns.CHRONIC_RENAL_DISEASE, value);
        return this;
    }

    public NewvisitSelection chronicRenalDiseaseContains(String... value) {
        addContains(NewvisitColumns.CHRONIC_RENAL_DISEASE, value);
        return this;
    }

    public NewvisitSelection chronicRenalDiseaseStartsWith(String... value) {
        addStartsWith(NewvisitColumns.CHRONIC_RENAL_DISEASE, value);
        return this;
    }

    public NewvisitSelection chronicRenalDiseaseEndsWith(String... value) {
        addEndsWith(NewvisitColumns.CHRONIC_RENAL_DISEASE, value);
        return this;
    }

    public NewvisitSelection orderByChronicRenalDisease(boolean desc) {
        orderBy(NewvisitColumns.CHRONIC_RENAL_DISEASE, desc);
        return this;
    }

    public NewvisitSelection orderByChronicRenalDisease() {
        orderBy(NewvisitColumns.CHRONIC_RENAL_DISEASE, false);
        return this;
    }

    public NewvisitSelection thyroidDisease(String... value) {
        addEquals(NewvisitColumns.THYROID_DISEASE, value);
        return this;
    }

    public NewvisitSelection thyroidDiseaseNot(String... value) {
        addNotEquals(NewvisitColumns.THYROID_DISEASE, value);
        return this;
    }

    public NewvisitSelection thyroidDiseaseLike(String... value) {
        addLike(NewvisitColumns.THYROID_DISEASE, value);
        return this;
    }

    public NewvisitSelection thyroidDiseaseContains(String... value) {
        addContains(NewvisitColumns.THYROID_DISEASE, value);
        return this;
    }

    public NewvisitSelection thyroidDiseaseStartsWith(String... value) {
        addStartsWith(NewvisitColumns.THYROID_DISEASE, value);
        return this;
    }

    public NewvisitSelection thyroidDiseaseEndsWith(String... value) {
        addEndsWith(NewvisitColumns.THYROID_DISEASE, value);
        return this;
    }

    public NewvisitSelection orderByThyroidDisease(boolean desc) {
        orderBy(NewvisitColumns.THYROID_DISEASE, desc);
        return this;
    }

    public NewvisitSelection orderByThyroidDisease() {
        orderBy(NewvisitColumns.THYROID_DISEASE, false);
        return this;
    }

    public NewvisitSelection sickleCells(String... value) {
        addEquals(NewvisitColumns.SICKLE_CELLS, value);
        return this;
    }

    public NewvisitSelection sickleCellsNot(String... value) {
        addNotEquals(NewvisitColumns.SICKLE_CELLS, value);
        return this;
    }

    public NewvisitSelection sickleCellsLike(String... value) {
        addLike(NewvisitColumns.SICKLE_CELLS, value);
        return this;
    }

    public NewvisitSelection sickleCellsContains(String... value) {
        addContains(NewvisitColumns.SICKLE_CELLS, value);
        return this;
    }

    public NewvisitSelection sickleCellsStartsWith(String... value) {
        addStartsWith(NewvisitColumns.SICKLE_CELLS, value);
        return this;
    }

    public NewvisitSelection sickleCellsEndsWith(String... value) {
        addEndsWith(NewvisitColumns.SICKLE_CELLS, value);
        return this;
    }

    public NewvisitSelection orderBySickleCells(boolean desc) {
        orderBy(NewvisitColumns.SICKLE_CELLS, desc);
        return this;
    }

    public NewvisitSelection orderBySickleCells() {
        orderBy(NewvisitColumns.SICKLE_CELLS, false);
        return this;
    }

    public NewvisitSelection otherChronicProblem(String... value) {
        addEquals(NewvisitColumns.OTHER_CHRONIC_PROBLEM, value);
        return this;
    }

    public NewvisitSelection otherChronicProblemNot(String... value) {
        addNotEquals(NewvisitColumns.OTHER_CHRONIC_PROBLEM, value);
        return this;
    }

    public NewvisitSelection otherChronicProblemLike(String... value) {
        addLike(NewvisitColumns.OTHER_CHRONIC_PROBLEM, value);
        return this;
    }

    public NewvisitSelection otherChronicProblemContains(String... value) {
        addContains(NewvisitColumns.OTHER_CHRONIC_PROBLEM, value);
        return this;
    }

    public NewvisitSelection otherChronicProblemStartsWith(String... value) {
        addStartsWith(NewvisitColumns.OTHER_CHRONIC_PROBLEM, value);
        return this;
    }

    public NewvisitSelection otherChronicProblemEndsWith(String... value) {
        addEndsWith(NewvisitColumns.OTHER_CHRONIC_PROBLEM, value);
        return this;
    }

    public NewvisitSelection orderByOtherChronicProblem(boolean desc) {
        orderBy(NewvisitColumns.OTHER_CHRONIC_PROBLEM, desc);
        return this;
    }

    public NewvisitSelection orderByOtherChronicProblem() {
        orderBy(NewvisitColumns.OTHER_CHRONIC_PROBLEM, false);
        return this;
    }

    public NewvisitSelection headacheSymptome(String... value) {
        addEquals(NewvisitColumns.HEADACHE_SYMPTOME, value);
        return this;
    }

    public NewvisitSelection headacheSymptomeNot(String... value) {
        addNotEquals(NewvisitColumns.HEADACHE_SYMPTOME, value);
        return this;
    }

    public NewvisitSelection headacheSymptomeLike(String... value) {
        addLike(NewvisitColumns.HEADACHE_SYMPTOME, value);
        return this;
    }

    public NewvisitSelection headacheSymptomeContains(String... value) {
        addContains(NewvisitColumns.HEADACHE_SYMPTOME, value);
        return this;
    }

    public NewvisitSelection headacheSymptomeStartsWith(String... value) {
        addStartsWith(NewvisitColumns.HEADACHE_SYMPTOME, value);
        return this;
    }

    public NewvisitSelection headacheSymptomeEndsWith(String... value) {
        addEndsWith(NewvisitColumns.HEADACHE_SYMPTOME, value);
        return this;
    }

    public NewvisitSelection orderByHeadacheSymptome(boolean desc) {
        orderBy(NewvisitColumns.HEADACHE_SYMPTOME, desc);
        return this;
    }

    public NewvisitSelection orderByHeadacheSymptome() {
        orderBy(NewvisitColumns.HEADACHE_SYMPTOME, false);
        return this;
    }

    public NewvisitSelection epigastricPain(String... value) {
        addEquals(NewvisitColumns.EPIGASTRIC_PAIN, value);
        return this;
    }

    public NewvisitSelection epigastricPainNot(String... value) {
        addNotEquals(NewvisitColumns.EPIGASTRIC_PAIN, value);
        return this;
    }

    public NewvisitSelection epigastricPainLike(String... value) {
        addLike(NewvisitColumns.EPIGASTRIC_PAIN, value);
        return this;
    }

    public NewvisitSelection epigastricPainContains(String... value) {
        addContains(NewvisitColumns.EPIGASTRIC_PAIN, value);
        return this;
    }

    public NewvisitSelection epigastricPainStartsWith(String... value) {
        addStartsWith(NewvisitColumns.EPIGASTRIC_PAIN, value);
        return this;
    }

    public NewvisitSelection epigastricPainEndsWith(String... value) {
        addEndsWith(NewvisitColumns.EPIGASTRIC_PAIN, value);
        return this;
    }

    public NewvisitSelection orderByEpigastricPain(boolean desc) {
        orderBy(NewvisitColumns.EPIGASTRIC_PAIN, desc);
        return this;
    }

    public NewvisitSelection orderByEpigastricPain() {
        orderBy(NewvisitColumns.EPIGASTRIC_PAIN, false);
        return this;
    }

    public NewvisitSelection fever(String... value) {
        addEquals(NewvisitColumns.FEVER, value);
        return this;
    }

    public NewvisitSelection feverNot(String... value) {
        addNotEquals(NewvisitColumns.FEVER, value);
        return this;
    }

    public NewvisitSelection feverLike(String... value) {
        addLike(NewvisitColumns.FEVER, value);
        return this;
    }

    public NewvisitSelection feverContains(String... value) {
        addContains(NewvisitColumns.FEVER, value);
        return this;
    }

    public NewvisitSelection feverStartsWith(String... value) {
        addStartsWith(NewvisitColumns.FEVER, value);
        return this;
    }

    public NewvisitSelection feverEndsWith(String... value) {
        addEndsWith(NewvisitColumns.FEVER, value);
        return this;
    }

    public NewvisitSelection orderByFever(boolean desc) {
        orderBy(NewvisitColumns.FEVER, desc);
        return this;
    }

    public NewvisitSelection orderByFever() {
        orderBy(NewvisitColumns.FEVER, false);
        return this;
    }

    public NewvisitSelection nauseaAndVomiting(String... value) {
        addEquals(NewvisitColumns.NAUSEA_AND_VOMITING, value);
        return this;
    }

    public NewvisitSelection nauseaAndVomitingNot(String... value) {
        addNotEquals(NewvisitColumns.NAUSEA_AND_VOMITING, value);
        return this;
    }

    public NewvisitSelection nauseaAndVomitingLike(String... value) {
        addLike(NewvisitColumns.NAUSEA_AND_VOMITING, value);
        return this;
    }

    public NewvisitSelection nauseaAndVomitingContains(String... value) {
        addContains(NewvisitColumns.NAUSEA_AND_VOMITING, value);
        return this;
    }

    public NewvisitSelection nauseaAndVomitingStartsWith(String... value) {
        addStartsWith(NewvisitColumns.NAUSEA_AND_VOMITING, value);
        return this;
    }

    public NewvisitSelection nauseaAndVomitingEndsWith(String... value) {
        addEndsWith(NewvisitColumns.NAUSEA_AND_VOMITING, value);
        return this;
    }

    public NewvisitSelection orderByNauseaAndVomiting(boolean desc) {
        orderBy(NewvisitColumns.NAUSEA_AND_VOMITING, desc);
        return this;
    }

    public NewvisitSelection orderByNauseaAndVomiting() {
        orderBy(NewvisitColumns.NAUSEA_AND_VOMITING, false);
        return this;
    }

    public NewvisitSelection visualDisturbance(String... value) {
        addEquals(NewvisitColumns.VISUAL_DISTURBANCE, value);
        return this;
    }

    public NewvisitSelection visualDisturbanceNot(String... value) {
        addNotEquals(NewvisitColumns.VISUAL_DISTURBANCE, value);
        return this;
    }

    public NewvisitSelection visualDisturbanceLike(String... value) {
        addLike(NewvisitColumns.VISUAL_DISTURBANCE, value);
        return this;
    }

    public NewvisitSelection visualDisturbanceContains(String... value) {
        addContains(NewvisitColumns.VISUAL_DISTURBANCE, value);
        return this;
    }

    public NewvisitSelection visualDisturbanceStartsWith(String... value) {
        addStartsWith(NewvisitColumns.VISUAL_DISTURBANCE, value);
        return this;
    }

    public NewvisitSelection visualDisturbanceEndsWith(String... value) {
        addEndsWith(NewvisitColumns.VISUAL_DISTURBANCE, value);
        return this;
    }

    public NewvisitSelection orderByVisualDisturbance(boolean desc) {
        orderBy(NewvisitColumns.VISUAL_DISTURBANCE, desc);
        return this;
    }

    public NewvisitSelection orderByVisualDisturbance() {
        orderBy(NewvisitColumns.VISUAL_DISTURBANCE, false);
        return this;
    }

    public NewvisitSelection chestPain(String... value) {
        addEquals(NewvisitColumns.CHEST_PAIN, value);
        return this;
    }

    public NewvisitSelection chestPainNot(String... value) {
        addNotEquals(NewvisitColumns.CHEST_PAIN, value);
        return this;
    }

    public NewvisitSelection chestPainLike(String... value) {
        addLike(NewvisitColumns.CHEST_PAIN, value);
        return this;
    }

    public NewvisitSelection chestPainContains(String... value) {
        addContains(NewvisitColumns.CHEST_PAIN, value);
        return this;
    }

    public NewvisitSelection chestPainStartsWith(String... value) {
        addStartsWith(NewvisitColumns.CHEST_PAIN, value);
        return this;
    }

    public NewvisitSelection chestPainEndsWith(String... value) {
        addEndsWith(NewvisitColumns.CHEST_PAIN, value);
        return this;
    }

    public NewvisitSelection orderByChestPain(boolean desc) {
        orderBy(NewvisitColumns.CHEST_PAIN, desc);
        return this;
    }

    public NewvisitSelection orderByChestPain() {
        orderBy(NewvisitColumns.CHEST_PAIN, false);
        return this;
    }

    public NewvisitSelection difficultyInBreathing(String... value) {
        addEquals(NewvisitColumns.DIFFICULTY_IN_BREATHING, value);
        return this;
    }

    public NewvisitSelection difficultyInBreathingNot(String... value) {
        addNotEquals(NewvisitColumns.DIFFICULTY_IN_BREATHING, value);
        return this;
    }

    public NewvisitSelection difficultyInBreathingLike(String... value) {
        addLike(NewvisitColumns.DIFFICULTY_IN_BREATHING, value);
        return this;
    }

    public NewvisitSelection difficultyInBreathingContains(String... value) {
        addContains(NewvisitColumns.DIFFICULTY_IN_BREATHING, value);
        return this;
    }

    public NewvisitSelection difficultyInBreathingStartsWith(String... value) {
        addStartsWith(NewvisitColumns.DIFFICULTY_IN_BREATHING, value);
        return this;
    }

    public NewvisitSelection difficultyInBreathingEndsWith(String... value) {
        addEndsWith(NewvisitColumns.DIFFICULTY_IN_BREATHING, value);
        return this;
    }

    public NewvisitSelection orderByDifficultyInBreathing(boolean desc) {
        orderBy(NewvisitColumns.DIFFICULTY_IN_BREATHING, desc);
        return this;
    }

    public NewvisitSelection orderByDifficultyInBreathing() {
        orderBy(NewvisitColumns.DIFFICULTY_IN_BREATHING, false);
        return this;
    }

    public NewvisitSelection vaginalBleeding(String... value) {
        addEquals(NewvisitColumns.VAGINAL_BLEEDING, value);
        return this;
    }

    public NewvisitSelection vaginalBleedingNot(String... value) {
        addNotEquals(NewvisitColumns.VAGINAL_BLEEDING, value);
        return this;
    }

    public NewvisitSelection vaginalBleedingLike(String... value) {
        addLike(NewvisitColumns.VAGINAL_BLEEDING, value);
        return this;
    }

    public NewvisitSelection vaginalBleedingContains(String... value) {
        addContains(NewvisitColumns.VAGINAL_BLEEDING, value);
        return this;
    }

    public NewvisitSelection vaginalBleedingStartsWith(String... value) {
        addStartsWith(NewvisitColumns.VAGINAL_BLEEDING, value);
        return this;
    }

    public NewvisitSelection vaginalBleedingEndsWith(String... value) {
        addEndsWith(NewvisitColumns.VAGINAL_BLEEDING, value);
        return this;
    }

    public NewvisitSelection orderByVaginalBleeding(boolean desc) {
        orderBy(NewvisitColumns.VAGINAL_BLEEDING, desc);
        return this;
    }

    public NewvisitSelection orderByVaginalBleeding() {
        orderBy(NewvisitColumns.VAGINAL_BLEEDING, false);
        return this;
    }

    public NewvisitSelection hypertensionDrugs(String... value) {
        addEquals(NewvisitColumns.HYPERTENSION_DRUGS, value);
        return this;
    }

    public NewvisitSelection hypertensionDrugsNot(String... value) {
        addNotEquals(NewvisitColumns.HYPERTENSION_DRUGS, value);
        return this;
    }

    public NewvisitSelection hypertensionDrugsLike(String... value) {
        addLike(NewvisitColumns.HYPERTENSION_DRUGS, value);
        return this;
    }

    public NewvisitSelection hypertensionDrugsContains(String... value) {
        addContains(NewvisitColumns.HYPERTENSION_DRUGS, value);
        return this;
    }

    public NewvisitSelection hypertensionDrugsStartsWith(String... value) {
        addStartsWith(NewvisitColumns.HYPERTENSION_DRUGS, value);
        return this;
    }

    public NewvisitSelection hypertensionDrugsEndsWith(String... value) {
        addEndsWith(NewvisitColumns.HYPERTENSION_DRUGS, value);
        return this;
    }

    public NewvisitSelection orderByHypertensionDrugs(boolean desc) {
        orderBy(NewvisitColumns.HYPERTENSION_DRUGS, desc);
        return this;
    }

    public NewvisitSelection orderByHypertensionDrugs() {
        orderBy(NewvisitColumns.HYPERTENSION_DRUGS, false);
        return this;
    }

    public NewvisitSelection diabetesDrugs(String... value) {
        addEquals(NewvisitColumns.DIABETES_DRUGS, value);
        return this;
    }

    public NewvisitSelection diabetesDrugsNot(String... value) {
        addNotEquals(NewvisitColumns.DIABETES_DRUGS, value);
        return this;
    }

    public NewvisitSelection diabetesDrugsLike(String... value) {
        addLike(NewvisitColumns.DIABETES_DRUGS, value);
        return this;
    }

    public NewvisitSelection diabetesDrugsContains(String... value) {
        addContains(NewvisitColumns.DIABETES_DRUGS, value);
        return this;
    }

    public NewvisitSelection diabetesDrugsStartsWith(String... value) {
        addStartsWith(NewvisitColumns.DIABETES_DRUGS, value);
        return this;
    }

    public NewvisitSelection diabetesDrugsEndsWith(String... value) {
        addEndsWith(NewvisitColumns.DIABETES_DRUGS, value);
        return this;
    }

    public NewvisitSelection orderByDiabetesDrugs(boolean desc) {
        orderBy(NewvisitColumns.DIABETES_DRUGS, desc);
        return this;
    }

    public NewvisitSelection orderByDiabetesDrugs() {
        orderBy(NewvisitColumns.DIABETES_DRUGS, false);
        return this;
    }

    public NewvisitSelection ironTablets(String... value) {
        addEquals(NewvisitColumns.IRON_TABLETS, value);
        return this;
    }

    public NewvisitSelection ironTabletsNot(String... value) {
        addNotEquals(NewvisitColumns.IRON_TABLETS, value);
        return this;
    }

    public NewvisitSelection ironTabletsLike(String... value) {
        addLike(NewvisitColumns.IRON_TABLETS, value);
        return this;
    }

    public NewvisitSelection ironTabletsContains(String... value) {
        addContains(NewvisitColumns.IRON_TABLETS, value);
        return this;
    }

    public NewvisitSelection ironTabletsStartsWith(String... value) {
        addStartsWith(NewvisitColumns.IRON_TABLETS, value);
        return this;
    }

    public NewvisitSelection ironTabletsEndsWith(String... value) {
        addEndsWith(NewvisitColumns.IRON_TABLETS, value);
        return this;
    }

    public NewvisitSelection orderByIronTablets(boolean desc) {
        orderBy(NewvisitColumns.IRON_TABLETS, desc);
        return this;
    }

    public NewvisitSelection orderByIronTablets() {
        orderBy(NewvisitColumns.IRON_TABLETS, false);
        return this;
    }

    public NewvisitSelection folicAcidTablets(String... value) {
        addEquals(NewvisitColumns.FOLIC_ACID_TABLETS, value);
        return this;
    }

    public NewvisitSelection folicAcidTabletsNot(String... value) {
        addNotEquals(NewvisitColumns.FOLIC_ACID_TABLETS, value);
        return this;
    }

    public NewvisitSelection folicAcidTabletsLike(String... value) {
        addLike(NewvisitColumns.FOLIC_ACID_TABLETS, value);
        return this;
    }

    public NewvisitSelection folicAcidTabletsContains(String... value) {
        addContains(NewvisitColumns.FOLIC_ACID_TABLETS, value);
        return this;
    }

    public NewvisitSelection folicAcidTabletsStartsWith(String... value) {
        addStartsWith(NewvisitColumns.FOLIC_ACID_TABLETS, value);
        return this;
    }

    public NewvisitSelection folicAcidTabletsEndsWith(String... value) {
        addEndsWith(NewvisitColumns.FOLIC_ACID_TABLETS, value);
        return this;
    }

    public NewvisitSelection orderByFolicAcidTablets(boolean desc) {
        orderBy(NewvisitColumns.FOLIC_ACID_TABLETS, desc);
        return this;
    }

    public NewvisitSelection orderByFolicAcidTablets() {
        orderBy(NewvisitColumns.FOLIC_ACID_TABLETS, false);
        return this;
    }

    public NewvisitSelection otherDrugs(String... value) {
        addEquals(NewvisitColumns.OTHER_DRUGS, value);
        return this;
    }

    public NewvisitSelection otherDrugsNot(String... value) {
        addNotEquals(NewvisitColumns.OTHER_DRUGS, value);
        return this;
    }

    public NewvisitSelection otherDrugsLike(String... value) {
        addLike(NewvisitColumns.OTHER_DRUGS, value);
        return this;
    }

    public NewvisitSelection otherDrugsContains(String... value) {
        addContains(NewvisitColumns.OTHER_DRUGS, value);
        return this;
    }

    public NewvisitSelection otherDrugsStartsWith(String... value) {
        addStartsWith(NewvisitColumns.OTHER_DRUGS, value);
        return this;
    }

    public NewvisitSelection otherDrugsEndsWith(String... value) {
        addEndsWith(NewvisitColumns.OTHER_DRUGS, value);
        return this;
    }

    public NewvisitSelection orderByOtherDrugs(boolean desc) {
        orderBy(NewvisitColumns.OTHER_DRUGS, desc);
        return this;
    }

    public NewvisitSelection orderByOtherDrugs() {
        orderBy(NewvisitColumns.OTHER_DRUGS, false);
        return this;
    }

    public NewvisitSelection hypertensionHistoryCocs(String... value) {
        addEquals(NewvisitColumns.HYPERTENSION_HISTORY_COCS, value);
        return this;
    }

    public NewvisitSelection hypertensionHistoryCocsNot(String... value) {
        addNotEquals(NewvisitColumns.HYPERTENSION_HISTORY_COCS, value);
        return this;
    }

    public NewvisitSelection hypertensionHistoryCocsLike(String... value) {
        addLike(NewvisitColumns.HYPERTENSION_HISTORY_COCS, value);
        return this;
    }

    public NewvisitSelection hypertensionHistoryCocsContains(String... value) {
        addContains(NewvisitColumns.HYPERTENSION_HISTORY_COCS, value);
        return this;
    }

    public NewvisitSelection hypertensionHistoryCocsStartsWith(String... value) {
        addStartsWith(NewvisitColumns.HYPERTENSION_HISTORY_COCS, value);
        return this;
    }

    public NewvisitSelection hypertensionHistoryCocsEndsWith(String... value) {
        addEndsWith(NewvisitColumns.HYPERTENSION_HISTORY_COCS, value);
        return this;
    }

    public NewvisitSelection orderByHypertensionHistoryCocs(boolean desc) {
        orderBy(NewvisitColumns.HYPERTENSION_HISTORY_COCS, desc);
        return this;
    }

    public NewvisitSelection orderByHypertensionHistoryCocs() {
        orderBy(NewvisitColumns.HYPERTENSION_HISTORY_COCS, false);
        return this;
    }

    public NewvisitSelection preeclampsiaFamilyHistory(String... value) {
        addEquals(NewvisitColumns.PREECLAMPSIA_FAMILY_HISTORY, value);
        return this;
    }

    public NewvisitSelection preeclampsiaFamilyHistoryNot(String... value) {
        addNotEquals(NewvisitColumns.PREECLAMPSIA_FAMILY_HISTORY, value);
        return this;
    }

    public NewvisitSelection preeclampsiaFamilyHistoryLike(String... value) {
        addLike(NewvisitColumns.PREECLAMPSIA_FAMILY_HISTORY, value);
        return this;
    }

    public NewvisitSelection preeclampsiaFamilyHistoryContains(String... value) {
        addContains(NewvisitColumns.PREECLAMPSIA_FAMILY_HISTORY, value);
        return this;
    }

    public NewvisitSelection preeclampsiaFamilyHistoryStartsWith(String... value) {
        addStartsWith(NewvisitColumns.PREECLAMPSIA_FAMILY_HISTORY, value);
        return this;
    }

    public NewvisitSelection preeclampsiaFamilyHistoryEndsWith(String... value) {
        addEndsWith(NewvisitColumns.PREECLAMPSIA_FAMILY_HISTORY, value);
        return this;
    }

    public NewvisitSelection orderByPreeclampsiaFamilyHistory(boolean desc) {
        orderBy(NewvisitColumns.PREECLAMPSIA_FAMILY_HISTORY, desc);
        return this;
    }

    public NewvisitSelection orderByPreeclampsiaFamilyHistory() {
        orderBy(NewvisitColumns.PREECLAMPSIA_FAMILY_HISTORY, false);
        return this;
    }

    public NewvisitSelection infertilityTreatmentHistory(String... value) {
        addEquals(NewvisitColumns.INFERTILITY_TREATMENT_HISTORY, value);
        return this;
    }

    public NewvisitSelection infertilityTreatmentHistoryNot(String... value) {
        addNotEquals(NewvisitColumns.INFERTILITY_TREATMENT_HISTORY, value);
        return this;
    }

    public NewvisitSelection infertilityTreatmentHistoryLike(String... value) {
        addLike(NewvisitColumns.INFERTILITY_TREATMENT_HISTORY, value);
        return this;
    }

    public NewvisitSelection infertilityTreatmentHistoryContains(String... value) {
        addContains(NewvisitColumns.INFERTILITY_TREATMENT_HISTORY, value);
        return this;
    }

    public NewvisitSelection infertilityTreatmentHistoryStartsWith(String... value) {
        addStartsWith(NewvisitColumns.INFERTILITY_TREATMENT_HISTORY, value);
        return this;
    }

    public NewvisitSelection infertilityTreatmentHistoryEndsWith(String... value) {
        addEndsWith(NewvisitColumns.INFERTILITY_TREATMENT_HISTORY, value);
        return this;
    }

    public NewvisitSelection orderByInfertilityTreatmentHistory(boolean desc) {
        orderBy(NewvisitColumns.INFERTILITY_TREATMENT_HISTORY, desc);
        return this;
    }

    public NewvisitSelection orderByInfertilityTreatmentHistory() {
        orderBy(NewvisitColumns.INFERTILITY_TREATMENT_HISTORY, false);
        return this;
    }

    public NewvisitSelection multipleGestation(String... value) {
        addEquals(NewvisitColumns.MULTIPLE_GESTATION, value);
        return this;
    }

    public NewvisitSelection multipleGestationNot(String... value) {
        addNotEquals(NewvisitColumns.MULTIPLE_GESTATION, value);
        return this;
    }

    public NewvisitSelection multipleGestationLike(String... value) {
        addLike(NewvisitColumns.MULTIPLE_GESTATION, value);
        return this;
    }

    public NewvisitSelection multipleGestationContains(String... value) {
        addContains(NewvisitColumns.MULTIPLE_GESTATION, value);
        return this;
    }

    public NewvisitSelection multipleGestationStartsWith(String... value) {
        addStartsWith(NewvisitColumns.MULTIPLE_GESTATION, value);
        return this;
    }

    public NewvisitSelection multipleGestationEndsWith(String... value) {
        addEndsWith(NewvisitColumns.MULTIPLE_GESTATION, value);
        return this;
    }

    public NewvisitSelection orderByMultipleGestation(boolean desc) {
        orderBy(NewvisitColumns.MULTIPLE_GESTATION, desc);
        return this;
    }

    public NewvisitSelection orderByMultipleGestation() {
        orderBy(NewvisitColumns.MULTIPLE_GESTATION, false);
        return this;
    }
}
