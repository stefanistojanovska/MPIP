package com.mpip.lab_intents;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    private Button btnExplicit;
    private TextView textBox;
    private Button btnImplicit;
    private Button btnShare;
    private Button btnImage;
    //Logger logger=Logger.getLogger("MainActivity");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnExplicit=(Button)findViewById(R.id.button1);
        textBox=findViewById(R.id.textView);
        btnImplicit=(Button)findViewById(R.id.button2);
        btnShare=findViewById(R.id.button3);
        btnImage=findViewById(R.id.button4);
        initListeners();

    }

    public void initListeners() {
        btnExplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivityExplicitly();
            }
        });

        btnImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivityImplicitly();
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareContent();
            }
        });

        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });

    }
    void launchActivityExplicitly()
    {
        startActivityForResult(new Intent(MainActivity.this, ExplicitActivity.class), 1);
    }

    void launchActivityImplicitly()
    {

        Intent intent = new Intent();
        //Intent intent=new Intent();
        intent.setAction("mk.ukim.finki.mpip.IMPLICIT_ACTION");
        intent.addCategory("android.intent.category.DEFAULT");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    void shareContent()
    {
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_SUBJECT," MPiP Send Title");
        intent.putExtra(Intent.EXTRA_TEXT,"Content send from MainActivity");
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent,"Share with:"));
    }

    void selectImage()
    {
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent,"Select image with:"),2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,@Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //textBox.setText(getIntent().getStringExtra("text"));
                    //textBox.setText("sfg");
                    textBox.setText(data.getExtras().getString("tekst"));

            } else if (resultCode == RESULT_CANCELED) {
                textBox.setText("Otkazano");
            }
        }
        if(requestCode==2)
        {
            if(resultCode==RESULT_OK)
            {
                Uri image=data.getData();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setDataAndType(image, "image/*");
                startActivity(intent);
            }
        }



    }
}
