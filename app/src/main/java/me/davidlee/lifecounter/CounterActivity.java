package me.davidlee.lifecounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * Created by leeh7 on 4/25/2015.
 */
public class CounterActivity extends ActionBarActivity {
    int[] lifeVals;
    @Override

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        // declare all the views and objects/buttons
        int lifeTotal= getIntent().getExtras().getInt("Starting Life Count");
        String[] playerList = getIntent().getExtras().getStringArray("List of Players");
        Button minusOne= (Button)findViewById(R.id.minusOne);
        Button minusFive=(Button)findViewById(R.id.minusFive);
        final Spinner list= (Spinner)findViewById(R.id.spinner);
        final TextView lifeCount=(TextView)findViewById(R.id.life);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, playerList); //array adapter specifies to spinner its appearance, uses android.r.layout from settingsactivity

        lifeVals= new int [playerList.length]; //sets lifevalues for each player
        for(int x=0;x<playerList.length;x++){
            lifeVals[x]=lifeTotal;
        }
        lifeCount.setText(""+lifeTotal);

        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //listener for every time changing of spinner option, selected item shows its value
            @Override // use designated method in class instead of method in superclass
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                lifeCount.setText(""+lifeVals[i]); //DAT CHEAP THING
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        minusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // sets onclick listener for -1 button
                int lifeNum= list.getSelectedItemPosition();
                if(lifeVals[lifeNum]>0)
                    lifeVals[lifeNum]--;
                lifeCount.setText(""+lifeVals[lifeNum]);
            }
        });

        minusFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {// same thing as above thing
                int lifeNum=list.getSelectedItemPosition();
                if(lifeVals[lifeNum]>=5)
                    lifeVals[lifeNum]-=5;
                lifeCount.setText(""+lifeVals[lifeNum]);
            }
        });


        list.setAdapter(spinnerArrayAdapter);// set array adapter to spinner, gives to spinner

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.life_counter_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(id==R.id.newSession)
        {
            Intent first=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(first);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
