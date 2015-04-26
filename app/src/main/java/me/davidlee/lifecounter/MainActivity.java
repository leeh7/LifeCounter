package me.davidlee.lifecounter;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;




public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // tells android what activity layout to use
        Button starting= (Button) findViewById(R.id.button);
        final EditText playerCount= (EditText)findViewById(R.id.editPlayerCount);
        final EditText lifeCount= (EditText)findViewById(R.id.lifeCount);
        starting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent myIntent = new Intent(getApplicationContext(),SettingsActivity.class);
                myIntent.putExtra("Number of Players", Integer.parseInt(playerCount.getText().toString()));
                Intent intent= myIntent.putExtra("Life Points", Integer.parseInt(lifeCount.getText().toString()));
                startActivity(myIntent);
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


        return super.onOptionsItemSelected(item);
    }
}
