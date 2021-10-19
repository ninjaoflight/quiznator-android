package net.xravn.quiznator.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.appcenter.distribute.Distribute;

import net.xravn.quiznator.BuildConfig;
import net.xravn.quiznator.R;

public class MainActivity extends AppCompatActivity {
    
    Button btnLoadURL;
    TextView txtURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize SDK
        if (!BuildConfig.APPCENTER_APP_SECRET.equals("")) {
            // Use APPCENTER_APP_SECRET environment variable if it exists
            AppCenter.start(getApplication(), BuildConfig.APPCENTER_APP_SECRET,
                    Analytics.class, Crashes.class, Distribute.class);
        }
        if (BuildConfig.DEBUG) {
            AppCenter.setLogLevel(Log.VERBOSE);
        }

        configure();

    }

    void configure(){
        btnLoadURL = (Button) findViewById(R.id.btnLoadURL);
        txtURL = (TextView) findViewById(R.id.txtURL);

        btnLoadURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBtnLoadUrlClick();
            }
        });
    }

    void onBtnLoadUrlClick(){
        Intent intent = new Intent(this, QuizSelection.class);
        startActivity(intent);
    }
}