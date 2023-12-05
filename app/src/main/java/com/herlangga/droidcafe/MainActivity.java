package com.herlangga.droidcafe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.preference.PreferenceManager;

import com.herlangga.droidcafe.databinding.ActivityMainBinding;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PreferenceManager.setDefaultValues(this, R.xml.pref_general, false);
        PreferenceManager.setDefaultValues(this, R.xml.pref_notification, false);
        PreferenceManager.setDefaultValues(this, R.xml.pref_data_sync, false);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String marketPref = sharedPref.getString("sync_frequency", "-1");
        String message = getString(R.string.market_message) + marketPref;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_order) {
            displayToast(getString(R.string.action_order_message));
        }
        if (id == R.id.action_favorites) {
            displayToast(getString(R.string.action_favorites_message));
        }
        if (id == R.id.action_contact) {
            displayToast(getString(R.string.action_contact_message));
        }
        if (id == R.id.action_status) {
            displayToast(getString(R.string.action_status_message));
        }
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
    /**
     * Shows a message that the donut image was clicked.
     */
    public void showDonutOrder(View view) {
        showFoodOrder(getString(R.string.donut_order_message));
    }
    public void showIceCreamOrder(View view) {
        showFoodOrder(getString(R.string.ice_cream_order_message));
    }
    /**
     * Shows a message that the froyo image was clicked.
     */
    public void showFroyoOrder(View view) {
        showFoodOrder(getString(R.string.froyo_order_message));
    }
    public void showFoodOrder(String message) {
        displayToast(message);
    }
}