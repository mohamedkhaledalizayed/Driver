package driver.itgds.khadametdz.view.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import driver.itgds.khadametdz.R;
import driver.itgds.khadametdz.databinding.ActivityTripDetailsBinding;


public class TripDetailsActivity extends AppCompatActivity {

    private ActivityTripDetailsBinding binding;
    public int status = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_trip_details);

        status = getIntent().getIntExtra("status",0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Trip Details");

        if (status == 1){
            binding.tripStatus.setText("In Progress");
        }else if (status == 2){
            binding.tripStatus.setText("Not Started");
        }else if (status == 3){
            binding.tripStatus.setText("Completed");
        }else if (status == 4) {
            binding.tripStatus.setText("Canceled");
            binding.start.setVisibility(View.GONE);
            binding.stop.setVisibility(View.GONE);
            binding.arrived.setVisibility(View.GONE);
        }

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}