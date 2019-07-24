package driver.itgds.khadametdz.view.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.crowdfire.cfalertdialog.CFAlertDialog;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.nabinbhandari.android.permissions.PermissionHandler;
import com.nabinbhandari.android.permissions.Permissions;

import java.util.ArrayList;

import driver.itgds.khadametdz.R;
import driver.itgds.khadametdz.view.fragment.BoardingFragment;
import driver.itgds.khadametdz.view.fragment.BusFragment;
import driver.itgds.khadametdz.view.fragment.BusesOnRouteFragment;
import driver.itgds.khadametdz.view.fragment.ScheduleFragment;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private String pageNameString = "FragInfoPage";
    private BottomNavigationView navigation;
    private DrawerLayout drawer;


    private FrameLayout notification;
    private TextView title;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.custom_toolbar);
        title = findViewById(R.id.toolbar_title);
        notification = findViewById(R.id.notification);
//        title.setText(getResources().getString(R.string.ic_bottom_nav_bus_reservation));

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.frame_container, new BusFragment());
//        transaction.commit();

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,NotificationActivity.class));
            }
        });
        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
//        location();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    private DialogInterface.OnClickListener positiveEnableGPS = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
        }
    };

    private DialogInterface.OnClickListener cancelDialog = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    };


//    public void showImage(View view) {
//        FragmentManager fm = getSupportFragmentManager();
//        BusImageFragment editNameDialogFragment = new BusImageFragment();
//        editNameDialogFragment.show(fm, "");
//        editNameDialogFragment.setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth);
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.profile:
                startActivity(new Intent(MainActivity.this,ProfileActivity.class));
                break;
//
            case R.id.my_wallet:
//                startActivity(new Intent(MainActivity.this, WalletActivity.class));
                break;

            case R.id.history:
                startActivity(new Intent(MainActivity.this, HistoryActivity.class));
                break;

            case R.id.notification:
                startActivity(new Intent(MainActivity.this, NotificationActivity.class));
                break;

            case R.id.settings:
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                break;

            case R.id.terms:
                startActivity(new Intent(MainActivity.this, TermsActivity.class));
                break;

            case R.id.share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "Hey check out my app at: https://play.google.com/store/apps/details?id=com.google.android.apps.plus");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;

            case R.id.logout:
                logout();
                break;
        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bottom_nav_bus_reservation:
                    title.setText(getResources().getString(R.string.ic_bottom_nav_bus_reservation));
                    loadFragment(new BusFragment());
                    pageNameString = "FragReservationPage";
                    return true;
                case R.id.bottom_nav_bus_ticket:
                    loadFragment(new ScheduleFragment());
                    title.setText(getResources().getString(R.string.ic_bottom_nav_bus_ticket));
                    pageNameString = "FragTicketPage";
                    return true;
                case R.id.bottom_nav_bus_info:
                    loadFragment(new BusesOnRouteFragment());
                    title.setText(getResources().getString(R.string.ic_bottom_nav_bus_info));
                    pageNameString = "FragInfoPage";
                    return true;
                case R.id.bottom_nav_bus_help:
                    loadFragment(new BoardingFragment());
                    title.setText(getResources().getString(R.string.ic_bottom_nav_bus_help));
                    pageNameString = "FragHelpPage";
                    return true;
            }
            return false;
        }
    };

    private void logout() {
        CFAlertDialog.Builder builder = new CFAlertDialog.Builder(this)
                .setDialogStyle(CFAlertDialog.CFAlertStyle.ALERT)
                .setTitle("Logout")
                .setMessage("Are You Want To Logout.")
                .addButton("Ok", -1, -1, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.JUSTIFIED, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                }).addButton("Cancel", -1, -1, CFAlertDialog.CFAlertActionStyle.NEGATIVE, CFAlertDialog.CFAlertActionAlignment.JUSTIFIED, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                ;

// Show the alert
        builder.show();
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.ic_profile:
//                startActivity(new Intent(this, ProfileActivity.class));
//                return true;
//
//            default:
                return super.onOptionsItemSelected(item);
        }

    @Override
    public void onBackPressed() {
//        if (pageNameString.equals("FragReservationPage")) {
//            super.onBackPressed();
//        } else {
//            navigation.setSelectedItemId(R.id.bottom_nav_bus_reservation);
//            pageNameString = "FragReservationPage";
//        }
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

}
