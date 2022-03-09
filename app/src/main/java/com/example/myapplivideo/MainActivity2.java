package com.example.myapplivideo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.VideoView;


public class MainActivity2 extends AppCompatActivity {

    private  static final int GRABAR_VIDEO = 1;
    private VideoView pp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        pp=findViewById(R.id.videoView);
    }
    public void grabarVideo(View v)

    {
        Intent intent=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(intent, GRABAR_VIDEO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==GRABAR_VIDEO && resultCode==RESULT_OK)
        {
            Uri grabarUri=data.getData();
            pp.setVideoURI(grabarUri);
            pp.start();
        }
    }
}