package com.example.restaurants.ui.map;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.restaurants.MainActivity;
import com.example.restaurants.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MapFragment extends FragmentActivity implements OnMapReadyCallback {

    private MapViewModel mViewModel;
    private GoogleMap mMap;
    CardView cardViewBack;
    private static final int LOCATION_REQUEST = 500;

    LinearLayout bottomSheetLayout;
    BottomSheetBehavior bottomSheetBehavior;
    TextView text1;

    ImageView telephoneMap;
    ImageView instagramMap;
    ImageView internetMap;


    public static MapFragment newInstance() {
        return new MapFragment();
    }

//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,         //  При добавлении карты этот метод выдавал ошибку
//                             @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.map_fragment, container, false);
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {     // При добавлении карты этот метод выдавал ошибку
//        super.onActivityCreated(savedInstanceState);
//        mViewModel = ViewModelProviders.of(this).get(MapViewModel.class);
//        // TODO: Use the ViewModel
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_fragment);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        text1 = (TextView) findViewById(R.id.bottom_sheet_text1);
        instagramMap = (ImageView) findViewById(R.id.instagram_map);
        internetMap = (ImageView) findViewById(R.id.internet_map);
        telephoneMap = (ImageView) findViewById(R.id.telephone_map);

        cardViewBack = (CardView) findViewById(R.id.cardview_back);
        cardViewBack.setOnClickListener(new View.OnClickListener() {         // КНОПКА - Назад
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapFragment.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);  //убиваем ACtivity при перемещении
                startActivity(intent);
            }
        });




        telephoneMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MapFragment.this);
                builder.setTitle("Веберите телефон")
                        .setItems(R.array.telephones, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which){
                                    case 0: Intent intent = new Intent(Intent.ACTION_DIAL);
                                        intent.setData(Uri.parse("tel: 87473684901"));
                                        startActivity(intent);
                                        break;
                                    case 1: break;
                                    case 2: break;
                                }
                            }
                        }).show();

            }
        });


        instagramMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/veranda_pavlodar/"));
                startActivity(intent);
            }
        });

        bottomSheetLayout = findViewById(R.id.bottom_sheet_layout);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED); //STATE_EXPANDED - сверху, STATE_COLLAPSED - снизу
    //    bottomSheetBehavior.setHideable(true);                            //// false - в нижнем положении строка немного выперает

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng pavlodar = new LatLng(52.281126, 76.971446);

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pavlodar,13));


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST);
            return;
        }

        mMap.setMyLocationEnabled(true);


        Marker marker1 = mMap.addMarker(new MarkerOptions().position(pavlodar).title("Цех АСУП").icon(
                BitmapDescriptorFactory.fromResource(R.drawable.markerorange24)).flat(false).alpha(1));
        marker1.setTag("first");

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if  (marker.getTag() == "first"){
                    text1.setText("Посмотреть меню");
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                return true;
            }
        });

    }
}
