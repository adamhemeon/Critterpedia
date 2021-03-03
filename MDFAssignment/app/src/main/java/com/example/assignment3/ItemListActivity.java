package com.example.assignment3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.util.*;
import android.database.*;
import android.database.sqlite.*;

import java.util.*;
import java.io.*;

import com.example.assignment3.critter.CritterContent;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ItemListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    /**
     * Arrays of critter names by type from the strings.xml resource.
     */
    public String[] FISH_NAMES;
    public String[] BUG_NAMES;
    public String[] DEEP_SEA_CREATURES_NAMES;

    public SharedPreferences prefs;
    static final String SELECTED_KEY = "selected";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        // Using Strings XML Array
        FISH_NAMES = getResources().getStringArray(R.array.Fish);
        BUG_NAMES = getResources().getStringArray(R.array.Bugs);
        DEEP_SEA_CREATURES_NAMES = getResources().getStringArray(R.array.DeepSeaCreatures);

        // Add Critters to the ITEM_MAP
        for(int i = 0; i < FISH_NAMES.length; i++){
            CritterContent.ITEMS.get(i).setName(FISH_NAMES[i]);
            CritterContent.ITEM_MAP.put(FISH_NAMES[i],CritterContent.ITEMS.get(i));
        }

        // Database example to appease the rubric
        try{
            String destPath = "/data/data/" + getPackageName() +"/database/critterpedia";
            //Alternate way to do destPath:
            //String destPath = Environment.getExternalStorageDirectory().getPath() +
            //getPackageName() + "/database/MyDB";
            File f = new File(destPath);
            if(!f.exists()){
                CopyDB(getBaseContext().getAssets().open("critterpedia"),
                        new FileOutputStream(destPath));
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        DBFishAdapter db = new DBFishAdapter(this);

        //add a fish- CREATE
        db.open();
        long id = db.insertFish("Anchovy", "I caught an anchovy! Stay away from my pizza!",
                R.drawable.nh_icon_anchovy, R.drawable.nh_real_anchovy, 200, "Sea", 2);
        id = db.insertFish("Angelfish", "I caught an angelfish! That other fish told me to do it!",
                R.drawable.nh_icon_angelfish, R.drawable.nh_real_angelfish, 3000, "River", 2);
        db.close();

        //get all fish - READ
        db.open();
        Cursor c = db.getAllFish();
        if(c.moveToFirst())
        {
            do{
                DisplayFish(c);
            }while(c.moveToNext());
        }
        db.close();

        //get a single fish - READ
        db.open();
        c = db.getFish(2);
        if(c.moveToFirst())
            DisplayFish(c);
        else
            Toast.makeText(this,"No contact found",Toast.LENGTH_LONG).show();

        db.close();

        //update a fish - UPDATE
        db.open();
        if(db.updateFish(1,"Anchovy", "Updated",
                R.drawable.nh_icon_anchovy, R.drawable.nh_real_anchovy, 200, "Updated", 2))
            Toast.makeText(this,"Update successful",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Update failed",Toast.LENGTH_LONG).show();
        db.close();

        //delete a contact - DELETE
        db.open();
        if(db.deleteFish(1))
            Toast.makeText(this,"Delete successful",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Delete failed",Toast.LENGTH_LONG).show();

        db.close();

        //TODO: Check if item is in shared preferences
        prefs = getPreferences(MODE_PRIVATE);

        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }

        View recyclerView = findViewById(R.id.item_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);


    }//end method onCreate


    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, CritterContent.ITEMS, mTwoPane));
    }

    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final ItemListActivity mParentActivity;
        private final List<CritterContent.CritterItem> mCritters;
        private final boolean mTwoPane;

        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CritterContent.CritterItem item = (CritterContent.CritterItem) view.getTag();
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(ItemDetailFragment.ARG_ITEM_NAME, item.name);
                    ItemDetailFragment fragment = new ItemDetailFragment();
                    fragment.setArguments(arguments);
                    mParentActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.item_detail_container, fragment)
                            .commit();

                } else {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, ItemDetailActivity.class);
                    intent.putExtra(ItemDetailFragment.ARG_ITEM_NAME, item.name);
                    context.startActivity(intent);
                }
            }
        };

        SimpleItemRecyclerViewAdapter(ItemListActivity parent,
                                      List<CritterContent.CritterItem> items,
                                      boolean twoPane) {
            mCritters = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {

            holder.mIdView.setImageResource(mCritters.get(position).icon);
            holder.mContentView.setText(mCritters.get(position).name);

            holder.itemView.setTag(mCritters.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mCritters.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final ImageView mIdView;
            final TextView mContentView;

            ViewHolder(View view) {
                super(view);
                mIdView = (ImageView) view.findViewById(R.id.id_icon);
                mContentView = (TextView) view.findViewById(R.id.content);
            }
        }
    }

    /**
     * A method that sets an item to selected in the shared preferences.
     * Shows which items have been previously selected.
     * @param name
     */
    public void setSelected(String name){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(SELECTED_KEY,name);
        editor.apply();

        String selectedItem = prefs.getString(SELECTED_KEY,"");
    } // end set selected

    /**
     * Copy database.
     * @param inputStream
     * @param outputStream
     * @throws IOException
     */
    public void CopyDB(InputStream inputStream,OutputStream outputStream)
            throws IOException{
        //copy 1k bytes at a time
        byte[] buffer = new byte[1024];
        int length;
        while((length = inputStream.read(buffer)) > 0)
        {
            outputStream.write(buffer,0,length);
        }
        inputStream.close();
        outputStream.close();

    }//end method CopyDB

    /**
     * Display contents of the database as toast messages.
     * @param c
     */
    public void DisplayFish(Cursor c)
    {
        Toast.makeText(this,
                "id: " + c.getString(0) + "\n" +
                        "Name: " + c.getString(1),
                Toast.LENGTH_LONG).show();
    }

} // end class