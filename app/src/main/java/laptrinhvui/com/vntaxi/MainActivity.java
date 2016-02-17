package laptrinhvui.com.vntaxi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Define
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);//Hide title bar default

        // Get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp_Provinces);

        // Preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
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

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Miền Bắc");
        listDataHeader.add("Miền Trung");
        listDataHeader.add("Miền Nam");

        // Adding child data
        //Lào Cai, Yên Bái, Điện Biên, Hoà Bình, Lai Châu, Sơn La
        //Hà Giang, Cao Bằng, Bắc Kạn, Lạng Sơn, Tuyên Quang, Thái Nguyên, Phú Thọ, Bắc Giang, Quảng Ninh
        //Bắc Ninh, Hà Nam, Hà Nội, Hải Dương, Hải Phòng, Hưng Yên, Nam Định, Ninh Bình, Thái Bình, Vĩnh Phúc.
        List<String> mienBac = new ArrayList<String>();
        mienBac.add("Lào Cai");
        mienBac.add("Yên Bái");
        mienBac.add("Điện Biên");
        mienBac.add("Hoà Bình");
        mienBac.add("Lai Châu");
        mienBac.add("Sơn La");
        mienBac.add("Hà Giang");
        mienBac.add("Cao Bằng");
        mienBac.add("Bắc Kạn");
        mienBac.add("Lạng Sơn");
        mienBac.add("Tuyên Quang");
        mienBac.add("Thái Nguyên");
        mienBac.add("Phú Thọ");
        mienBac.add("Bắc Giang");
        mienBac.add("Quảng Ninh");
        mienBac.add("Bắc Ninh");
        mienBac.add("Hà Nam");
        mienBac.add("Hà Nội");
        mienBac.add("Hải Dương");
        mienBac.add("Hải Phòng");
        mienBac.add("Hưng Yên");
        mienBac.add("Nam Định");
        mienBac.add("Ninh Bình");
        mienBac.add("Thái Bình");
        mienBac.add("Vĩnh Phúc");



        List<String> mienTrung = new ArrayList<String>();
        mienTrung.add("The Conjuring");
        mienTrung.add("Despicable Me 2");
        mienTrung.add("Turbo");
        mienTrung.add("Grown Ups 2");
        mienTrung.add("Red 2");
        mienTrung.add("The Wolverine");

        List<String> mienNam = new ArrayList<String>();
        mienNam.add("2 Guns");
        mienNam.add("The Smurfs 2");
        mienNam.add("The Spectacular Now");
        mienNam.add("The Canyons");
        mienNam.add("Europa Report");

        listDataChild.put(listDataHeader.get(0), mienBac); // Header, Child data
        listDataChild.put(listDataHeader.get(1), mienTrung);
        listDataChild.put(listDataHeader.get(2), mienNam);
    }




}
