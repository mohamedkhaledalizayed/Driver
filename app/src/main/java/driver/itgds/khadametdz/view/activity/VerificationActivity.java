package driver.itgds.khadametdz.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import driver.itgds.khadametdz.R;

public class VerificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
    }

    public void verify(View view) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
