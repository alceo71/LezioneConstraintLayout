package com.example.lezioneconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class Placeholder1Activity extends AppCompatActivity {

    Placeholder placeholder;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeholder1);

        placeholder = findViewById(R.id.placeholder);
        constraintLayout = findViewById(R.id.constraintLayout);
    }


    public void cambiaView(View view){

        ViewGroup.LayoutParams params = view.getLayoutParams();

        Log.d("MIO", "click su " + params.width);

        params.width = 420;
        params.height = 420;
        view.setLayoutParams(params);
        view.requestLayout();

        if(placeholder.getContent() != null){
            ViewGroup.LayoutParams params2 = placeholder.getContent().getLayoutParams();
            params2.width = 210;
            params2.height = 210;
            placeholder.getContent().setLayoutParams(params2);
            placeholder.getContent().requestLayout();
        }

        TransitionManager.beginDelayedTransition(constraintLayout);
        placeholder.setContentId(view.getId());
    }

}
