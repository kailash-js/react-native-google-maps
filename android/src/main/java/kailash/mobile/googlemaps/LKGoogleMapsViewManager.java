package kailash.mobile.googlemaps;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableNativeArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.view.ReactViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class GoogleMapView extends ReactViewGroup {
    public GoogleMapView(final Context context) {
        super(context);        
    }    
}

public class LKGoogleMapsViewManager extends ViewGroupManager<GoogleMapView> {

    public static final String REACT_CLASS = "GoogleMapView";   

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
    public void addView(GoogleMapView parent, View child, int index) {
        throw new RuntimeException("GoogleMapView cannot have subviews");
    }

    @Override
    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder.Builder<String, Object> builder = MapBuilder.builder();       
        return builder.build();
    }   
}
