package com.example.critterpedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    // Variables
    List<CritterItem> itemsList = new ArrayList<CritterItem>();
    Map<String, CritterItem> itemMap = new HashMap<String, CritterItem>();
    String profileName;

    // Controls
    TextView tvAppName, tvProfileName;
    ImageView ivAppIcon, ivAvatar;
    EditText etName;
    Button btnExplore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup
        populateCritters();

        // Controls
        tvAppName = findViewById(R.id.tvAppName);
        tvProfileName  = findViewById(R.id.tvProfileName);
        etName = findViewById(R.id.etName);
        ivAppIcon = findViewById(R.id.ivAppIcon);
        ivAvatar = findViewById(R.id.ivAvatar);
        btnExplore = findViewById(R.id.btnExplore);

        // Listeners
        btnExplore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get the user-entered name
                profileName = etName.getText().toString();

                // Validate name is not empty
                if (!profileName.isEmpty()) {
                    //Intent i = new Intent(v,CritterListActivity.class); // Goto CritterDetail Activity
                    Intent i = new Intent("CritterListActivity");
                    Bundle extras = new Bundle();
                    extras.putString("NAME",profileName); // Bundle the user-entered name
                    //extras.putParcelable("ITEMS", (Parcelable) itemsList);
                    i.putExtras(extras); // Put bundle in the intent
                    startActivityForResult(i,1);
                } else {
                    Toast.makeText(MainActivity.this,"Name cannot be empty",
                            Toast.LENGTH_SHORT).show(); // Validate
                }
            }
        });
    }

    /* ---- Stubs for Activity Lifestyle Code ---- */
    @Override
    protected void onStart(){
        super.onStart();

        // Put onStart code here

        // Test
        // Toast notification on start
        // Toast.makeText(MainActivity.this,"On Start",Toast.LENGTH_SHORT).show();

    }//end onStart

    @Override
    protected void onResume(){
        super.onResume();

        // Put onResume code here

        // Test
        // Toast notification on resume
        // Toast.makeText(MainActivity.this,"On Resume",Toast.LENGTH_SHORT).show();

    }//end onResume

    @Override
    protected void onPause(){
        super.onPause();

        // Put onPause code here

        // Test
        // Toast notification on pause
        // Toast.makeText(MainActivity.this,"On Pause",Toast.LENGTH_SHORT).show();

    }//end onPause

    @Override
    protected void onRestart(){
        super.onRestart();

        // Put onRestart code here

        // Test
        // Toast notification on restart
        // Toast.makeText(MainActivity.this,"On Restart",Toast.LENGTH_SHORT).show();

    }//end onRestart

    @Override
    protected void onStop(){
        super.onStop();

        // Put onStop code here

        // Test
        // Toast notification on stop
        // Toast.makeText(MainActivity.this,"On Stop",Toast.LENGTH_SHORT).show();

    }//end onStop

    @Override
    protected void onDestroy(){
        super.onDestroy();

        // Put onDestroy code here

        // Test
        // Toast notification on destroy
        // Toast.makeText(MainActivity.this,"On Destroy",Toast.LENGTH_SHORT).show();

    }//end onDestroy

    /**
     * Add a critter item to both the ITEMS collection and map hash to ITEM_MAP.
     * @param item
     */
    private void addItem(CritterItem item) {
        itemsList.add(item);
        itemMap.put(item.name, item);
    }

    /**
     * Populates the list of critters with fixed data.
     */
    private void populateCritters(){
        FishItem anchovy = new FishItem("Anchovy", "I caught an anchovy! Stay away from my pizza!",
                R.drawable.nh_icon_anchovy, R.drawable.nh_real_anchovy, 200, "Sea", 2);
        addItem(anchovy);

        FishItem angelfish = new FishItem("Angelfish", "I caught an angelfish! That other fish told me to do it!",
                R.drawable.nh_icon_angelfish, R.drawable.nh_real_angelfish, 3000, "River", 2);
        addItem(angelfish);

        FishItem arapaima = new FishItem("Arapaima", "I caught an arapaima! How did it get here? Arapaiknow!",
                R.drawable.nh_icon_arapaima, R.drawable.nh_real_arapiama, 10000, "River", 6);
        addItem(arapaima);

        FishItem arowana = new FishItem("Arowana", "I caught an arowana! I'd make a joke, but I don't 'wana.",
                R.drawable.nh_icon_arowana, R.drawable.nh_real_arowana, 10000, "River", 4);
        addItem(arowana);

        FishItem barredknifejaw = new FishItem("Barred Knifejaw", "I caught a barred knifejaw! They must have a hard time eating!",
                R.drawable.nh_icon_barredknifejaw, R.drawable.nh_real_barredknifejaw, 5000, "Sea", 3);
        addItem(barredknifejaw);

        FishItem barreleye = new FishItem("Barreleye", "I caught a barreleye! Like eyeing fish in a barrel!",
                R.drawable.nh_icon_barreleye, R.drawable.nh_real_barreleye, 15000, "Sea", 2);
        addItem(barreleye);

        FishItem betta = new FishItem("Betta", "I caught a betta! I betta not drop it!",
                R.drawable.nh_icon_betta, R.drawable.nh_real_betta, 2500, "River", 2);
        addItem(betta);

        FishItem bitterling = new FishItem("Bitterling", "I caught a bitterling! It's mad at me, but only a little.",
                R.drawable.nh_icon_bitterling, R.drawable.nh_real_bitterling, 900, "River", 1);
        addItem(bitterling);

        FishItem blackbass = new FishItem("Black Bass", "I caught a black bass! The most metal of all fish!",
                R.drawable.nh_icon_blackbass, R.drawable.nh_real_blackbass, 400, "River", 4);
        addItem(blackbass);

        FishItem blowfish = new FishItem("Blowfish", "I caught a blowfish! I'm blown away!",
                R.drawable.nh_icon_blowfish, R.drawable.nh_real_blowfish, 5000, "Sea", 3);
        addItem(blowfish);
    }
}