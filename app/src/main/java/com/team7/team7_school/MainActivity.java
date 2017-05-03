package com.team7.team7_school;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
//    private MapStyleOptions mapStyleOptions;
//    private final LatLng northEast = new LatLng(36.540116, -87.359580); //used http://www.latlong.net/
//    private final LatLng southWest = new LatLng(36.530651, -87.344517);

    /***
     *   You cannot instantiate a GoogleMap object directly, rather, you must obtain one from the
     *   getMapAsync() method on a MapFragment or MapView that you have added to your application.
     ***/




    //add table keys
    public static final String KEY_ROWID = "rowid";
    public static final String KEY_DEPARTMENT = "Department";
    public static final String KEY_NAME = "Name";
    public static final String KEY_OFFICE = "Office";
    public static final String KEY_PHONE = "Phone";
    public static final String KEY_EMAIL = "Email";
    public static final String KEY_SPEC = "Specialty";


    private static final String DATABASE_NAME = "majors.sqlite";
    private static final int DB_VERSION = 1;

    public static final String COMPUTERSCIENCE_TABLE = "Computer Science";
    public static final String MATH_TABLE = "Math";
    public static final String BIOLOGY_TABLE = "Biology";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mapStyleOptions = new MapStyleOptions(Integer.toString(R.string.JSONcrap));

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.financeaid) {
            return true;
        }
        if (id == R.id.about) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //According to the default GoogleMap template...
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMinZoomPreference(17f); //takes a float value, the higher it is the closer it gets.
                                        //Seems to become pointless after 20ish I think.
        mMap.setMaxZoomPreference(17f); //More or less disabling zoom this way.
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID); //make it a hybrid map
        // Add a marker near the apsu csci building.
        LatLng apsu = new LatLng(36.533513, -87.350696);    //Apparently Trahern instead of Maynard?
                                                            //It's close enough I guess.
//        LatLngBounds bounds = new LatLngBounds(southWest, northEast); //Needs to be bigger than necessary.
//        mMap.setLatLngBoundsForCameraTarget(bounds); //It's like a rand on the boundaries smh.
//        mMap.addMarker(new MarkerOptions().position(apsu).title("\"Art\" Department lol"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(apsu));
    }

    void AddNewMarker(LatLng location, String title) { //To be used with the onClick.
        mMap.clear();   //Clears the map of markers.
        mMap.addMarker(new MarkerOptions().position(location).title(title)); //plops down a new marker.
    }
}