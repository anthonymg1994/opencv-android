package com.avfdezz.opencvdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.avfdezz.opencvdroid.cameracontrol.Tutorial3Activity;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button bBlob;
    private Button bPuzzle15;
    private Button bTest;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bBlob = findViewById(R.id.b_blob);
        bPuzzle15 = findViewById(R.id.b_puzzle15);
        bTest = findViewById(R.id.button3);

        bBlob.setOnClickListener(this);
        bTest.setOnClickListener(this);
        bPuzzle15.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.b_blob:
                intent = new Intent(MainActivity.this, ColorBlobDetectionActivity.class);
                startActivity(intent);
                break;
            case R.id.b_puzzle15:
                intent = new Intent(MainActivity.this, Puzzle15Activity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(MainActivity.this, Tutorial3Activity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}
