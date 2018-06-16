package com.example.evanmaroge.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button sms;
    Button phn,web,email, map,share;
    Button active;
    MenuItem help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sms = findViewById(R.id.SmsButton);
        phn = findViewById(R.id.PhoneButton);
        web = findViewById(R.id.WebButton);
        email = findViewById(R.id.EmailButton);
        map =findViewById(R.id.MapButton);
        share = findViewById(R.id.ShareButton);

        active = findViewById(R.id.ActivityButton);
        help = findViewById(R.id.action_help);


        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent (Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:"+ Uri.encode("7148242135")));
                intent.putExtra("sms_body", "hello");
                startActivity(intent);

            }
        });
        phn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:7148242135"));
                startActivity(intent);

            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent web = new Intent (Intent.ACTION_VIEW,Uri.parse("http://IGN.com"));
                startActivity(web);

            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String geoUri = String.format("geo:39.899533, -77.036476");
                Uri geo = Uri.parse(geoUri);
                Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                startActivity(geoMap);

            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"CS639");
                intent.putExtra(Intent.EXTRA_TEXT, "join CS639");
                startActivity(Intent.createChooser(intent, "share the love"));
            }
        });
        active.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(view.getContext(), NewActivity.class);
                startActivity(intent);

            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_help) {
            startItNow();


        }

        return super.onOptionsItemSelected(item);
    }

    private void startItNow() {
        final Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);

    }
}
