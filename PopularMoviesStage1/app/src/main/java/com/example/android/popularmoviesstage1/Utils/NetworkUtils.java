package com.example.android.popularmoviesstage1.Utils;

import android.util.Log;

import java.io.IOException;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;


/**
 * These utilities will be used to communicate with the MovieDb
 */
public class NetworkUtils {


    //·····························Constants························

    private static final String TAG = NetworkUtils.class.getSimpleName();


    //·····························Methods···························

    /**
     * Construye la URl dependiendo del parametro con el cual se busca filtrar la información.
     * @param filterQuery an example of a filter query is popularity.desc
     * @return resulting URL
     */
    public static String buildUrl(String filterQuery){


        String first = "http://api.themoviedb.org/3/movie/";

        //String firstPart = "https://api.themoviedb.org/3/discover/movie?page=1&include_video=false&include_adult=false&sort_by=";

        //TODO REMEMBER TO REMOVE YOUR API KEY!!!!!
        String lastPart = "?api_key=";
        String key = "API_KEY";
        String result = first+filterQuery+lastPart + key;

        Log.v(TAG, "Built Url " + result);

        return result;
    }


    //Con este método creo el String con el Response del Http Retrofit
    public static String getResponseFromHttpUrl(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/octet-stream");
        RequestBody body = RequestBody.create(mediaType, "{}");
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response = client.newCall(request).execute();

        String ans = response.body().string();

        Log.v(TAG, "URL RESPONSE" + ans);
        return ans;
    }
}
