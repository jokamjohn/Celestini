package johnkagga.me.celestini.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import johnkagga.me.celestini.BuildConfig;
import johnkagga.me.celestini.provider.newvisit.NewvisitColumns;
import johnkagga.me.celestini.provider.subvisit.SubvisitColumns;

public class celestiniSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = celestiniSQLiteOpenHelper.class.getSimpleName();

    public static final String DATABASE_FILE_NAME = "celestini.db";
    private static final int DATABASE_VERSION = 1;
    private static celestiniSQLiteOpenHelper sInstance;
    private final Context mContext;
    private final celestiniSQLiteOpenHelperCallbacks mOpenHelperCallbacks;

    // @formatter:off
    public static final String SQL_CREATE_TABLE_NEWVISIT = "CREATE TABLE IF NOT EXISTS "
            + NewvisitColumns.TABLE_NAME + " ( "
            + NewvisitColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NewvisitColumns.HOSPITAL_ADDRESS + " TEXT, "
            + NewvisitColumns.HOSPITAL_NAME + " TEXT, "
            + NewvisitColumns.VISIT_NO + " INTEGER, "
            + NewvisitColumns.PATIENT_NAME + " TEXT, "
            + NewvisitColumns.HOME_DISTRICT + " TEXT, "
            + NewvisitColumns.DOB + " INTEGER, "
            + NewvisitColumns.EDUCATION_LEVEL + " TEXT, "
            + NewvisitColumns.TRIBE + " TEXT, "
            + NewvisitColumns.RELIGION + " TEXT, "
            + NewvisitColumns.OCCUPATION + " TEXT, "
            + NewvisitColumns.TOWN + " TEXT, "
            + NewvisitColumns.BLOODPRESSURE + " TEXT, "
            + NewvisitColumns.PARITY_NO_OF_PREGNANCIES + " INTEGER, "
            + NewvisitColumns.PREGNANCY_OUTCOME + " TEXT, "
            + NewvisitColumns.PAST_PREGNANCY_HYPERTENSION_HISTORY + " TEXT, "
            + NewvisitColumns.LAST_NORMAL_MP_DATE + " TEXT, "
            + NewvisitColumns.PREVIOUS_CAESAREAN + " TEXT, "
            + NewvisitColumns.HYPERTENSION_BEFORE_PREGNANCY + " TEXT, "
            + NewvisitColumns.DIABETIC_BEFORE_PREGNANCY + " TEXT, "
            + NewvisitColumns.CHRONIC_RENAL_DISEASE + " TEXT, "
            + NewvisitColumns.THYROID_DISEASE + " TEXT, "
            + NewvisitColumns.SICKLE_CELLS + " TEXT, "
            + NewvisitColumns.OTHER_CHRONIC_PROBLEM + " TEXT, "
            + NewvisitColumns.HEADACHE_SYMPTOME + " TEXT, "
            + NewvisitColumns.EPIGASTRIC_PAIN + " TEXT, "
            + NewvisitColumns.FEVER + " TEXT, "
            + NewvisitColumns.NAUSEA_AND_VOMITING + " TEXT, "
            + NewvisitColumns.VISUAL_DISTURBANCE + " TEXT, "
            + NewvisitColumns.CHEST_PAIN + " TEXT, "
            + NewvisitColumns.DIFFICULTY_IN_BREATHING + " TEXT, "
            + NewvisitColumns.VAGINAL_BLEEDING + " TEXT, "
            + NewvisitColumns.HYPERTENSION_DRUGS + " TEXT, "
            + NewvisitColumns.DIABETES_DRUGS + " TEXT, "
            + NewvisitColumns.IRON_TABLETS + " TEXT, "
            + NewvisitColumns.FOLIC_ACID_TABLETS + " TEXT, "
            + NewvisitColumns.OTHER_DRUGS + " TEXT, "
            + NewvisitColumns.HYPERTENSION_HISTORY_COCS + " TEXT, "
            + NewvisitColumns.PREECLAMPSIA_FAMILY_HISTORY + " TEXT, "
            + NewvisitColumns.INFERTILITY_TREATMENT_HISTORY + " TEXT, "
            + NewvisitColumns.MULTIPLE_GESTATION + " TEXT "
            + " );";

    public static final String SQL_CREATE_TABLE_SUBVISIT = "CREATE TABLE IF NOT EXISTS "
            + SubvisitColumns.TABLE_NAME + " ( "
            + SubvisitColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + SubvisitColumns.PATIENT_ID + " TEXT, "
            + SubvisitColumns.ANY_OTHER_CHRONIC_MEDICAL_PROBLEM + " TEXT, "
            + SubvisitColumns.HEAD_PAIN + " TEXT, "
            + SubvisitColumns.EPIGASTRIC_PAIN + " TEXT, "
            + SubvisitColumns.FEVER + " TEXT, "
            + SubvisitColumns.NAUSEA_VOMITING + " TEXT, "
            + SubvisitColumns.VISUAL_DISTURBANCES + " TEXT, "
            + SubvisitColumns.CHEST_PAIN + " TEXT, "
            + SubvisitColumns.DIFFICULTY_IN_BREATHING + " TEXT, "
            + SubvisitColumns.VAGINAL_BLEEDING_WITH_ABDOMINAL_PAIN + " TEXT, "
            + SubvisitColumns.HYPERTENSION_DRUGS + " TEXT, "
            + SubvisitColumns.DIABETES_DRUGS + " TEXT, "
            + SubvisitColumns.IRON_TABLETS + " TEXT, "
            + SubvisitColumns.FOLIC_ACID_TABLETS + " TEXT, "
            + SubvisitColumns.ANY_OTHER_SPECIFY + " TEXT, "
            + SubvisitColumns.ANY_MULTIPLE_GESTATION + " TEXT "
            + " );";

    // @formatter:on

    public static celestiniSQLiteOpenHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = newInstance(context.getApplicationContext());
        }
        return sInstance;
    }

    private static celestiniSQLiteOpenHelper newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }


    /*
     * Pre Honeycomb.
     */
    private static celestiniSQLiteOpenHelper newInstancePreHoneycomb(Context context) {
        return new celestiniSQLiteOpenHelper(context);
    }

    private celestiniSQLiteOpenHelper(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
        mContext = context;
        mOpenHelperCallbacks = new celestiniSQLiteOpenHelperCallbacks();
    }


    /*
     * Post Honeycomb.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static celestiniSQLiteOpenHelper newInstancePostHoneycomb(Context context) {
        return new celestiniSQLiteOpenHelper(context, new DefaultDatabaseErrorHandler());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private celestiniSQLiteOpenHelper(Context context, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, errorHandler);
        mContext = context;
        mOpenHelperCallbacks = new celestiniSQLiteOpenHelperCallbacks();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate");
        mOpenHelperCallbacks.onPreCreate(mContext, db);
        db.execSQL(SQL_CREATE_TABLE_NEWVISIT);
        db.execSQL(SQL_CREATE_TABLE_SUBVISIT);
        mOpenHelperCallbacks.onPostCreate(mContext, db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            setForeignKeyConstraintsEnabled(db);
        }
        mOpenHelperCallbacks.onOpen(mContext, db);
    }

    private void setForeignKeyConstraintsEnabled(SQLiteDatabase db) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            setForeignKeyConstraintsEnabledPreJellyBean(db);
        } else {
            setForeignKeyConstraintsEnabledPostJellyBean(db);
        }
    }

    private void setForeignKeyConstraintsEnabledPreJellyBean(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setForeignKeyConstraintsEnabledPostJellyBean(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mOpenHelperCallbacks.onUpgrade(mContext, db, oldVersion, newVersion);
    }
}
