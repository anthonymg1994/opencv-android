package com.avfdezz.opencvdroid;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.avfdezz.opencvdroid.cameracontrol.Tutorial3Activity;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button bBlob;
    private Button bPuzzle15;
    private Button bCameraControl;
    private Button bImageMan;
    private static final int PERMISSION_CAMERA = 1;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bBlob = findViewById(R.id.b_blob);
        bPuzzle15 = findViewById(R.id.b_puzzle15);
        bCameraControl = findViewById(R.id.button3);
        bImageMan = findViewById(R.id.b_manipulation);

        bBlob.setOnClickListener(this);
        bCameraControl.setOnClickListener(this);
        bPuzzle15.setOnClickListener(this);
        bImageMan.setOnClickListener(this);


        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    PERMISSION_CAMERA);
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_CAMERA: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                }
                return;
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.b_blob:
                intent = new Intent(MainActivity.this, ColorBlobDetectionActivity.class);
                startActivity(intent);
                break;
            case R.id.b_puzzle15:
                intent = new Intent(MainActivity.this, SetActivity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(MainActivity.this, Tutorial3Activity.class);
                startActivity(intent);
                break;
            case R.id.b_manipulation:
                intent = new Intent(MainActivity.this, ImageManipulationsActivity.class);
                startActivity(intent);
                break;
            default:
                Toast.makeText(this, "Favor de seleccionar uno de los botones", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
