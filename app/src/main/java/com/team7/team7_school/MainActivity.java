package com.team7.team7_school;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
   public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

        private GoogleMap mMap;
//    private MapStyleOptions mapStyleOptions;
//    private final LatLng northEast = new LatLng(36.540116, -87.359580); //used http://www.latlong.net/
//    private final LatLng southWest = new LatLng(36.530651, -87.344517);

        /***
         *   You cannot instantiate a GoogleMap object directly, rather, you must obtain one from the
         *   getMapAsync() method on a MapFragment or MapView that you have added to your application.
         ***/

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
            LatLng apsu = new LatLng(36.533513, -87.350696);    //Apparently Trahern instead of Maynard? //It's close enough I guess.
            LatLng csci = new LatLng(36.533308, -87.349807);
            LatLng science = new LatLng(36.532963, -87.350775);

//        LatLngBounds bounds = new LatLngBounds(southWest, northEast); //Needs to be bigger than necessary.
//        mMap.setLatLngBoundsForCameraTarget(bounds); //It's like a rand on the boundaries smh.
            mMap.addMarker(new MarkerOptions().position(apsu).title("Trahern: \"Art\" Department lol"));
            mMap.addMarker(new MarkerOptions().position(csci).title("Maynard: Math and CSCI"));
            mMap.addMarker(new MarkerOptions().position(science).title("SunnyD: Actual Science Building"));

            mMap.moveCamera(CameraUpdateFactory.newLatLng(apsu));
        }

//        //Search function didn't pan out.
//        void AddNewMarker(LatLng location, String title) { //To be used with the onClick.
//            mMap.clear();   //Clears the map of markers.
//            mMap.addMarker(new MarkerOptions().position(location).title(title)); //plops down a new marker.
//        }

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
        if (id == R.id.about) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage(Html.fromHtml("<html>" +
                    "<h1>Developers: Briana Schmidt and Zachary Pigott</h1>" + "</html>")).
                    setTitle("About").
                    setPositiveButton("OK", null);
            builder.create().show();
            return true;
        }
        if (id == R.id.com) {
            Intent intent = new Intent(this, Computer.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}