package com.example.intentstarter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int[] btnList = {R.id.emailBtn, R.id.messageBtn, R.id.webPageBtn
            , R.id.mapBtn, R.id.webSearchBtn};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i: btnList) {
            findViewById(i).setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);

        switch (view.getId()) {
            case R.id.emailBtn:
                intent.setData(Uri.parse("mailto:derrfgh4563@gmail.com"));
                intent.putExtra(Intent.EXTRA_CC, new String[]{"pikachu@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "I love you");
                intent.putExtra(Intent.EXTRA_TEXT,
                        "I love pikachu so much, so I love you so much.\n" +
                        "Will you become my first pokemon?\n" +
                        "I promise I will treat you very nice!");

                break;
            case R.id.messageBtn:
                intent.setData(Uri.parse("sms:0988-474423"));
                intent.putExtra("sms_body", "you are the coolest man I have ever seen!!!");
                break;
            case R.id.webPageBtn:
                intent.setData(Uri.parse("https://www.google.com"));
                break;
            case R.id.mapBtn:
                intent.setData(Uri.parse("geo:25.047095, 121.517308"));
                break;
            case R.id.webSearchBtn:
                intent.setAction(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "pikachu");
        }

        startActivity(intent);
    }
}
