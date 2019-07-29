package com.jessicathornsby.collectionwidget;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class ConfigActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_activity);
        setResult(RESULT_CANCELED);
        Button setupWidget = (Button) findViewById(R.id.setupWidget);
        setupWidget.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                handleSetupWidget();
            }
        });
        Button configButton = (Button) findViewById(R.id.configButton);
        configButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                handleConfigWidget();
            }
        });

    }

    private void handleSetupWidget() {
        showAppWidget();

    }

    private void handleConfigWidget() {
        Toast.makeText(ConfigActivity.this,
                "Configuration options", Toast.LENGTH_LONG).show();

    }

    int appWidgetId;
    private void showAppWidget() {
        appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            appWidgetId = extras.getInt(
                    AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);

            if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
                finish();
            }

            //TO do: Perform the configuration//

            Intent resultValue = new Intent();
            resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
            setResult(RESULT_OK, resultValue);
            finish();
        }
    }
}