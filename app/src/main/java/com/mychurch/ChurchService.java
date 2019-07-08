package com.mychurch;



import com.google.android.gms.common.api.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class ChurchService {

    public static void findChurch(String holyBook, String bookChapter, String bookVerseFrom, String bookVerseTo, Callback callback){

        OkHttpClient client = new OkHttpClient.Builder().build();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BIBLE_Base_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.BIBLE_BOOK_QUERY_PARAMETER, holyBook);
        urlBuilder.addQueryParameter(Constants.BIBLE_CHAPTER_QUERY_PARAMETER, bookChapter);
        urlBuilder.addQueryParameter(Constants.BIBLE_VERSE_QUERY_PARAMETER ,bookVerseFrom);
        urlBuilder.addQueryParameter(Constants.BIBLE_VERSETO_QUERY_PARAMETER, bookVerseTo);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url)
                .header("X-RapidAPI-Host",  Constants.BIBLE_TOKEN)
                .header("X-RapidAPI-Key", Constants.BIBLE_TOKEN).build();
    Call call = client.newCall(request);
    call.enqueue(callback);
    }

    public ArrayList<Church> processResults(Response response) {
        ArrayList<Church> dailies = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            JSONObject bibleJSON = new JSONObject(jsonData);
            JSONArray xtianJSON = bibleJSON.getJSONArray("xtian");


            if (response.isSuccessful()){
                for (int i = 0; i < xtianJSON.length(); i++){
                    JSONObject churchJSON = xtianJSON.getJSONObject(i);
                    String holyBook = churchJSON.getString("Book");
                    String bookChapter = churchJSON.getString("chapter");
                    String bookVerseFrom = churchJSON.getString("VerseFrom");
                    String getBookVerseTo = (String) churchJSON.get("VerseTo");
                }
                Church church = new Church("Genesis", "two", "10", "15");
                dailies.add(church);
            }

    }
    catch (IOException e){
e.printStackTrace();
    }catch (JSONException e){
        e.printStackTrace();
    }
    return dailies;
}

