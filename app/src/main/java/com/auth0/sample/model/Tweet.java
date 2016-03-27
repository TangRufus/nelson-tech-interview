package com.auth0.sample.model;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cubecnelson on 24/3/16.
 */
public class Tweet {
    private String id;
    private String type;
    private String author;
    private String body;
    private JSONObject json;
    private String created_at;

    public Tweet(JSONObject json) {
        this.json = json;
        try {
            this.id = json.getString("id");
            this.type = json.getString("type");
            this.author = json.getJSONObject("attributes").getString("author");
            this.body = json.getJSONObject("attributes").getString("body");
            this.created_at = json.getJSONObject("attributes").getString("created-at");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.json.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }



}
