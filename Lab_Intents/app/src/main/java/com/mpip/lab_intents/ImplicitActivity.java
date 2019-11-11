package com.mpip.lab_intents;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ImplicitActivity extends AppCompatActivity {
    private TextView txtActivities;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);
        txtActivities=findViewById(R.id.textViewImpl);
        getActivities();
    }

    public void getActivities()
    {
        Intent intent=new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> activities = getPackageManager().queryIntentActivities(intent, 0);
        StringBuilder sb=new StringBuilder();
        for(ResolveInfo activity:activities )
        {
            sb.append(activity.activityInfo.name+"\r\n");
        }
        txtActivities.setText(sb.toString());
    }
}
