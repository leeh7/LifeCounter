package me.davidlee.lifecounter;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;



/**
 * A {@link PreferenceActivity} that presents a set of application settings. On
 * handset devices, settings are presented as a single list. On tablets,
 * settings are split by category, with category headers shown to the left of
 * the list of settings.
 * <p/>
 * See <a href="http://developer.android.com/design/patterns/settings.html">
 * Android Design: Settings</a> for design guidelines and the <a
 * href="http://developer.android.com/guide/topics/ui/settings.html">Settings
 * API Guide</a> for more information on developing a Settings UI.
 */
public class SettingsActivity extends ActionBarActivity {
    /**
     * Determines whether to always show the simplified settings UI, where
     * settings are presented in a single list. When false, settings are shown
     * as a master/detail two-pane view on tablets. When true, a single pane is
     * shown on tablets.
     */
    EditText[] nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final int playerSize=getIntent().getExtras().getInt("Number of Players"); // gets data stored from intent that started activity
        //final because fixed value

        LinearLayout layout= (LinearLayout)findViewById(R.id.playerList); //layout scheme for fixed

        nameList=new EditText[playerSize]; //store array of usernames

        LayoutInflater inflater= getLayoutInflater(); //inflate transforms xml code to java object

        for(int x=0;x<playerSize;x++){// displays each textbox for player name entry
           View v= inflater.inflate(R.layout.player_layout,null); // method to transform xml layout to java, return view object
           TextView entry= (TextView)v.findViewById(R.id.playerDescription); // within view object, textbox for entering name
           entry.setText("Player "+ (x+1)); // setting label of name entry
           nameList[x]= (EditText)v.findViewById(R.id.customName); //adding userinput text box to array
           layout.addView(v); // adds view object to layout, the one with all the userinput text boxes
        }


        Button onward= new Button(this); //refers to itself/ current activity
        onward.setText("Start!");
        layout.addView(onward); //adds button to layout

        onward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //sets click listener, gets usernames then goes to counteractivity to run spinner
                Intent second=new Intent(getApplicationContext(),CounterActivity.class);
                String[] finalList=new String[playerSize];
                for(int y=0;y<playerSize;y++){
                    finalList[y]=nameList[y].getText().toString(); // gets name that person inputted
                }
                second.putExtra("List of Players", finalList); // list of players created in settingsactivity
                second.putExtra("Starting Life Count", getIntent().getExtras().getInt("Life Points")); //life point value from main activity
                startActivity(second);
            }
        });
    }


    /**
     * Shows the simplified settings UI if the device configuration if the
     * device configuration dictates that a simplified, single-pane UI should be
     * shown.
     */

    }

