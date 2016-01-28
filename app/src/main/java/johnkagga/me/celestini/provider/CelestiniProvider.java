package johnkagga.me.celestini.provider;

import java.util.Arrays;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import johnkagga.me.celestini.BuildConfig;
import johnkagga.me.celestini.provider.base.BaseContentProvider;
import johnkagga.me.celestini.provider.newvisit.NewvisitColumns;
import johnkagga.me.celestini.provider.subvisit.SubvisitColumns;

public class CelestiniProvider extends BaseContentProvider {
    private static final String TAG = CelestiniProvider.class.getSimpleName();

    private static final boolean DEBUG = BuildConfig.DEBUG;

    private static final String TYPE_CURSOR_ITEM = "vnd.android.cursor.item/";
    private static final String TYPE_CURSOR_DIR = "vnd.android.cursor.dir/";

    public static final String AUTHORITY = "johnkagga.me.celestini.provider";
    public static final String CONTENT_URI_BASE = "content://" + AUTHORITY;

    private static final int URI_TYPE_NEWVISIT = 0;
    private static final int URI_TYPE_NEWVISIT_ID = 1;

    private static final int URI_TYPE_SUBVISIT = 2;
    private static final int URI_TYPE_SUBVISIT_ID = 3;



    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        URI_MATCHER.addURI(AUTHORITY, NewvisitColumns.TABLE_NAME, URI_TYPE_NEWVISIT);
        URI_MATCHER.addURI(AUTHORITY, NewvisitColumns.TABLE_NAME + "/#", URI_TYPE_NEWVISIT_ID);
        URI_MATCHER.addURI(AUTHORITY, SubvisitColumns.TABLE_NAME, URI_TYPE_SUBVISIT);
        URI_MATCHER.addURI(AUTHORITY, SubvisitColumns.TABLE_NAME + "/#", URI_TYPE_SUBVISIT_ID);
    }

    @Override
    protected SQLiteOpenHelper createSqLiteOpenHelper() {
        return celestiniSQLiteOpenHelper.getInstance(getContext());
    }

    @Override
    protected boolean hasDebug() {
        return DEBUG;
    }

    @Override
    public String getType(Uri uri) {
        int match = URI_MATCHER.match(uri);
        switch (match) {
            case URI_TYPE_NEWVISIT:
                return TYPE_CURSOR_DIR + NewvisitColumns.TABLE_NAME;
            case URI_TYPE_NEWVISIT_ID:
                return TYPE_CURSOR_ITEM + NewvisitColumns.TABLE_NAME;

            case URI_TYPE_SUBVISIT:
                return TYPE_CURSOR_DIR + SubvisitColumns.TABLE_NAME;
            case URI_TYPE_SUBVISIT_ID:
                return TYPE_CURSOR_ITEM + SubvisitColumns.TABLE_NAME;

        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if (DEBUG) Log.d(TAG, "insert uri=" + uri + " values=" + values);
        return super.insert(uri, values);
    }

    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {
        if (DEBUG) Log.d(TAG, "bulkInsert uri=" + uri + " values.length=" + values.length);
        return super.bulkInsert(uri, values);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "update uri=" + uri + " values=" + values + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.update(uri, values, selection, selectionArgs);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "delete uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.delete(uri, selection, selectionArgs);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if (DEBUG)
            Log.d(TAG, "query uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs) + " sortOrder=" + sortOrder
                    + " groupBy=" + uri.getQueryParameter(QUERY_GROUP_BY) + " having=" + uri.getQueryParameter(QUERY_HAVING) + " limit=" + uri.getQueryParameter(QUERY_LIMIT));
        return super.query(uri, projection, selection, selectionArgs, sortOrder);
    }

    @Override
    protected QueryParams getQueryParams(Uri uri, String selection, String[] projection) {
        QueryParams res = new QueryParams();
        String id = null;
        int matchedId = URI_MATCHER.match(uri);
        switch (matchedId) {
            case URI_TYPE_NEWVISIT:
            case URI_TYPE_NEWVISIT_ID:
                res.table = NewvisitColumns.TABLE_NAME;
                res.idColumn = NewvisitColumns._ID;
                res.tablesWithJoins = NewvisitColumns.TABLE_NAME;
                res.orderBy = NewvisitColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_SUBVISIT:
            case URI_TYPE_SUBVISIT_ID:
                res.table = SubvisitColumns.TABLE_NAME;
                res.idColumn = SubvisitColumns._ID;
                res.tablesWithJoins = SubvisitColumns.TABLE_NAME;
                res.orderBy = SubvisitColumns.DEFAULT_ORDER;
                break;

            default:
                throw new IllegalArgumentException("The uri '" + uri + "' is not supported by this ContentProvider");
        }

        switch (matchedId) {
            case URI_TYPE_NEWVISIT_ID:
            case URI_TYPE_SUBVISIT_ID:
                id = uri.getLastPathSegment();
        }
        if (id != null) {
            if (selection != null) {
                res.selection = res.table + "." + res.idColumn + "=" + id + " and (" + selection + ")";
            } else {
                res.selection = res.table + "." + res.idColumn + "=" + id;
            }
        } else {
            res.selection = selection;
        }
        return res;
    }
}
