package com.pedalpi.buttondynamic.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Effect implements Serializable {
    private final int index;
    private final String name;

    private boolean status;

    public Effect(int index, JSONObject data) {
        this.index = index;
        this.name = prepareName(data);
        this.status = prepareStatus(data);
    }

    private String prepareName(JSONObject data) {
        try {
            return data.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "Nome não localizado";
    }

    private boolean prepareStatus(JSONObject data) {
        try {
            return data.getBoolean("status");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return status;
    }

    public void toggleStatus() {
        this.status = !this.status;
    }

    @Override
    public String toString() {
        return this.index + " - " + this.getName() + " " + (isActive() ? "actived" : "bypass");
    }
}
