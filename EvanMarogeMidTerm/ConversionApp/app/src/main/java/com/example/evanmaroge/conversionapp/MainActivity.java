package com.example.evanmaroge.conversionapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText dollarValue;
    TextView francsValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        //getting the variables

        button=findViewById(R.id.convertButton);

        dollarValue=findViewById(R.id.dollarInput);

        francsValue=findViewById(R.id.francsOutput);


        //setting the on click listneer for the button
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                //getting the value of input from user
                String dValue = dollarValue.getText().toString();


                //checking if user input is nothing
                if (dValue.matches("")) {
                    francsValue.setText("please enter a number ");


                }

                //if user input is soemthing, convert it
                else {
                    Double finalValue = Double.parseDouble(dValue);
                    Double franVal = (finalValue * 586.84);

                    francsValue.setText("Your Dollar is Worth " + franVal + " francs");
                }

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

        return super.onOptionsItemSelected(item);
    }
}
