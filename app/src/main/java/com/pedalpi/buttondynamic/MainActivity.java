package com.pedalpi.buttondynamic;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout container = (LinearLayout) findViewById(R.id.container);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            160*2//LinearLayout.LayoutParams.WRAP_CONTENT
        );

        //for (Effect effect : effects) {
        for (int i=0; i<15; i++) {
            Button button = new Button(this);

            button.setTextAppearance(getApplicationContext(), R.style.Effect);

            final int index = i;
            button.setText("Click Here - " + index);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.i("BOTAO", effect.getName() + " clicado");
                    Log.i("BOTAO", "Botão de índice " + index + " clicado");
                }
            });
            container.addView(button, layoutParams);
        }
    }
}
