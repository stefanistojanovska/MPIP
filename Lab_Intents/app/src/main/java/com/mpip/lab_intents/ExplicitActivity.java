package com.mpip.lab_intents;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ExplicitActivity extends AppCompatActivity {
   private Button ok;
   private Button nok;
   private EditText editText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);
        ok=(Button)findViewById(R.id.btnOk);
        nok=(Button)findViewById(R.id.btnNok);
        editText=(EditText)findViewById(R.id.editText);
        initListeners();



    }



    public void initListeners()
    {

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent();
                intent.putExtra("tekst",editText.getText().toString());
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
        nok.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent=new Intent();
                setResult(RESULT_CANCELED,intent);
                //Intent intent=getIntent();
                finish();
            }
        });
    }


}
