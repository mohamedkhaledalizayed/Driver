package driver.itgds.khadametdz.view.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.nabinbhandari.android.permissions.PermissionHandler;
import com.nabinbhandari.android.permissions.Permissions;

import java.io.File;
import java.util.ArrayList;

import driver.itgds.khadametdz.R;
import driver.itgds.khadametdz.databinding.ActivityProfileBinding;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_profile);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Profile");
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void editPhoto(View view) {
        checkPermission();
    }

    private void checkPermission() {
        String[] permissions = {Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE};
        Permissions.check(this/*context*/, permissions, null/*rationale*/, null/*options*/, new PermissionHandler() {
                    @Override
                    public void onGranted() {
                        EasyImage.openChooserWithGallery(ProfileActivity.this,"Take Picture", 0);
                    }

                    @Override
                    public void onDenied(Context context, ArrayList<String> deniedPermissions) {
                    }
                }

        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {
            @Override
            public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type) {
                //Some error handling
            }

            @Override
            public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {
                binding.userPhoto.setImageURI(Uri.fromFile(imageFile));
            }

        });
    }

    public void editProfile(View view) {
        startActivity(new Intent(this,EditProfileActivity.class));
    }
}
