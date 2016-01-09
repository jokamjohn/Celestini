package johnkagga.me.celestini.utilites;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by jokamjohn on 1/5/2016.
 */
public class Helper {

    /**
     * Creating a an Alert Dialog
     *
     * @param title   String
     * @param message String
     */
    public static void alertDialog(Context context, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null);

        //Create the Dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * Checking for network access
     *
     * @return boolean
     */
    public static boolean isOnline(Context context) {
        ConnectivityManager manager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Make a toast message
     *
     * @param context Context
     * @param message String
     */
    public static void makeToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG)
                .show();
    }
}
