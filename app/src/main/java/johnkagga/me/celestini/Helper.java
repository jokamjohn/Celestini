package johnkagga.me.celestini;

import android.content.Context;
import android.support.v7.app.AlertDialog;

/**
 * Created by jokamjohn on 1/5/2016.
 */
public class Helper {

    /**
     * Creating a an Alert Dialog
     * @param title String
     * @param message String
     */
    public static void alertDialog(Context context,String title,String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null);

        //Create the Dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
