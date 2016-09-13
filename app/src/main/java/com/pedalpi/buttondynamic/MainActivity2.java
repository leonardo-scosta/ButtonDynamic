package com.pedalpi.buttondynamic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.pedalpi.buttondynamic.model.Effect;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Effect effect = (Effect) getIntent().getSerializableExtra(MainActivity.EFFECT);

        Button effectButton = (Button) findViewById(R.id.effect);
        effectButton.setText(effect.toString());
    }
}
