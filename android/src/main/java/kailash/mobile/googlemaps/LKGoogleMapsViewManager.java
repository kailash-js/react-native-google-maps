package kailash.mobile.googlemaps;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;
import java.util.Random;

class ViewAttacherGroup extends ReactViewGroup {

    public ViewAttacherGroup(Context context) {
        super(context);

        this.setWillNotDraw(true);
        this.setVisibility(VISIBLE);
        this.setAlpha(0.0f);
        this.setRemoveClippedSubviews(false);

        this.setOverflow("hidden"); // Change to ViewProps.HIDDEN until RN 0.57 is base
    }

    // This should make it more performant, avoid trying to hard to overlap layers with opacity.
    @Override
    public boolean hasOverlappingRendering() {
        return false;
    }
}

class GoogleMapView extends MapView implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    public GoogleMap map;

    public GoogleMapView(final Context context) {
        super(context);
        Log.w("map", "init map");
        super.onCreate(null);
        super.onResume();
        super.getMapAsync(this);
    }
    public static double randFloat(double min, double max) {

        Random rand = new Random();

        return rand.nextDouble() * (max - min) + min;

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.w("map", "onMapReady");
        this.map = googleMap;
        googleMap.setOnMarkerClickListener(this);

        for(int i=0;i<5000;i++){
            MarkerOptions markerOption = new MarkerOptions()
                    .position(new LatLng(randFloat(1.1233438, 37.4233438), randFloat(-10.0728817, -122.5728817)))
                    .title("Marker").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
            Marker m = googleMap.addMarker(markerOption);
        }

        //googleMap.getUiSettings().setAllGesturesEnabled(false);
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.4233438, -122.0728817), 5));
    }

    @Override
    public boolean onMarkerClick(final Marker marker) {
        Log.w("map", "market clicked");
        return true;
    }
}


public class LKGoogleMapsViewManager extends ViewGroupManager<GoogleMapView> {

    public static final String REACT_CLASS = "KLGoogleMapsView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected GoogleMapView createViewInstance(ThemedReactContext themedReactContext) {
        GoogleMapView view = new GoogleMapView(themedReactContext);
        return view;
    }

    @Override
    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder.Builder<String, Object> builder = MapBuilder.builder();       
        return builder.build();
    }
}
