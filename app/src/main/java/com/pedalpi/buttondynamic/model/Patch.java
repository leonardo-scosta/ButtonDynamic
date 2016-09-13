package com.pedalpi.buttondynamic.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Patch {
    private final JSONObject data;

    public Patch(JSONObject data) {
        this.data = data;
    }

    public String getNome() {
        try {
            return this.data.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "Nome não localizado";
    }

    public List<Effect> getEffects() {
        try {
            List<Effect> effects = new LinkedList<>();
            JSONArray effectsJson = this.data.getJSONArray("effects");

            for (int index = 0; index < effectsJson.length(); index++) {
                JSONObject effectJson = effectsJson.getJSONObject(index);
                effects.add(new Effect(index, effectJson));
            }

            return effects;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
