package driver.itgds.khadametdz.view.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import driver.itgds.khadametdz.R;
import driver.itgds.khadametdz.databinding.ActivityForgetPasswordBinding;

public class ForgetPasswordActivity extends AppCompatActivity {


    private ActivityForgetPasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_forget_password);

    }

    public void send(View view) {
        startActivity(new Intent(this, VerificationActivity.class));
    }

    public void sms(View view) {
        binding.verifyBy.setHint("Phone Number");
    }

    public void email(View view) {
        binding.verifyBy.setHint("Email");
    }
}
