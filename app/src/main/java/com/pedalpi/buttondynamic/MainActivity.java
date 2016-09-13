package com.pedalpi.buttondynamic;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.pedalpi.buttondynamic.model.Effect;
import com.pedalpi.buttondynamic.model.Patch;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {

    public static final String EFFECT = "EFFECT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout container = (LinearLayout) findViewById(R.id.container);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            160*2//LinearLayout.LayoutParams.WRAP_CONTENT
        );

        JSONObject json = lerJson("json/teste.json");
        Patch patch = new Patch(json);

        for (final Effect effect : patch.getEffects()) {
            Button button = new Button(this);

            button.setTextAppearance(getApplicationContext(), R.style.Effect);

            // Exemplo: effect.toggleStatus();
            button.setBackgroundColor(effect.isActive() ? Color.GREEN : Color.RED);

            button.setText(patch.getNome() + " - " + effect.getName());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("BOTAO", "Effect selected: " + effect);
                    abrirTelaEfeito(effect);
                }
            });
            container.addView(button, layoutParams);
        }
    }

    private void abrirTelaEfeito(Effect effect) {
        Intent intent = new Intent(getBaseContext(), MainActivity2.class);
        intent.putExtra(MainActivity.EFFECT, effect);
        startActivity(intent);
    }

    private JSONObject lerJson(String nomeDoArquivo) {
        try {
            InputStream is = getAssets().open(nomeDoArquivo);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            String jsonString = new String(buffer, "UTF-8");
            return new JSONObject(jsonString);

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
