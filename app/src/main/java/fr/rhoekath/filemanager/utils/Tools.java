package fr.rhoekath.filemanager.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Mickael on 14/11/2014.
 */
public class Tools {
    public static boolean isInternetConnected(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public static enum Type {
        IMAGE (0, "images/"),
        TEXTE (1, "textes/"),
        VIDEO (3, "videos/"),
        AUDIO (4, "audios/");

        private int mediaType = 0;
        private String path = "";

        //Constructeur
        Type(int mediaType, String path){
            this.mediaType = mediaType;
            this.path = path;
        }

        public String toString(){
            return Integer.toString(mediaType);
        }
    }


}
