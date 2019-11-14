package com.nghia02253.myandroid;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class HomeActivity extends AppCompatActivity {

    int REQUEST_CODE_CAMERA = 123;
    CheckBox int_id, double_id, string_id, all;
    Button test, hint, btnListUser, btnCamera;
    TextView tvUrlGoogle, tvSMS, tvCall, tvLoadImage, tvLoadContentInternet, tvLoadContentRSS,
            tvLoadJSON, tvLoadJSONLanguage, tvLoadJSONArrayObject, tvVolleyString, tvVolleyObject,
            tvMediaPlay, tvSQLite, tvFragment;
    ImageView imageViewProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();

        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Trang chủ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        tvUrlGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://dichvucong.thanhhoa.gov.vn"));
                startActivity(intent);
            }
        });

        tvSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body", "");
                intent.setData(Uri.parse("sms:0984688886"));
                startActivity(intent);
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnListUser.startAnimation(animAlpha);
                btnCamera.startAnimation(animRotate);
                //Kiem tra cap quyen Camera khi su dung
                ActivityCompat.requestPermissions(HomeActivity.this, new String[]{Manifest.permission.CAMERA}, REQUEST_CODE_CAMERA);
            }
        });
        tvLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, LoadImageInternet.class));
            }
        });
        tvLoadContentInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, LoadContentActivity.class));
            }
        });
        tvLoadContentRSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, LoadRssActivity.class));
            }
        });
        tvLoadJSON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, LoadJSONActivity.class));
            }
        });
        tvLoadJSONLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, LoadJSONLanguageActivity.class));
            }
        });
        tvLoadJSONArrayObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, LoadJSONArrayObjectActivity.class));
            }
        });
        tvVolleyString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, VolleyStringActivity.class));
            }
        });
        tvVolleyObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, VolleyObjectActivity.class));
            }
        });
        tvMediaPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, MediaAudioActivity.class));
            }
        });
        tvSQLite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, DatabaseActivity.class));
            }
        });
        tvFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, FragmentActivity.class));
            }
        });
        /*
        tvCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:0987654321"));
                startActivity(intent);
            }
        });
        */

    }

    //Kiem tra ket qua nguoi dung cap quyen cho camera
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if( requestCode == REQUEST_CODE_CAMERA && grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, REQUEST_CODE_CAMERA);
        } else {
            Toast.makeText(this, "Bạn cần cấp quyền sử dụng camera cho ứng dụng", Toast.LENGTH_SHORT).show();
            //Redirect tới cấu hình cấp quyền CAMERA
            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            Uri uri = Uri.fromParts("package", getPackageName(), null);
            intent.setData(uri);
            startActivity(intent);
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data != null) {
            Bitmap imageView = (Bitmap) data.getExtras().get("data");
            imageViewProfile.setImageBitmap(imageView);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
    //Listener nhận sự kiện khi các Checkbox thay đổi trạng thái
    CompoundButton.OnCheckedChangeListener m_listener
            = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (compoundButton == all)
            {
                detachListener();
                int_id.setEnabled(!b);
                double_id.setEnabled(!b);
                string_id.setEnabled(!b);

                int_id.setChecked(b);
                double_id.setChecked(b);
                string_id.setChecked(b);
                attachListener();
            }
            else {
                Toast.makeText(compoundButton.getContext(),
                        compoundButton.getText() + " | "
                                + compoundButton.isChecked(),
                        Toast.LENGTH_SHORT).show();
            }
        }
    };

    //Gán Listener vào CheckBox
    void attachListener()
    {
        int_id.setOnCheckedChangeListener(m_listener);
        double_id.setOnCheckedChangeListener(m_listener);
        string_id.setOnCheckedChangeListener(m_listener);
        all.setOnCheckedChangeListener(m_listener);

    }
    //Bỏ các Listener khỏi CheckBox
    void detachListener()
    {
        int_id.setOnCheckedChangeListener(null);
        double_id.setOnCheckedChangeListener(null);
        string_id.setOnCheckedChangeListener(null);
        all.setOnCheckedChangeListener(null);

    }


    void init() {
        int_id    = findViewById(R.id.int_id);
        double_id = findViewById(R.id.double_id);
        string_id = findViewById(R.id.string_id);
        all       = findViewById(R.id.all);
        btnListUser = findViewById(R.id.btnListUser);
        tvUrlGoogle = findViewById(R.id.tvUrlGoogle);
        tvSMS = findViewById(R.id.tvSMS);
        tvCall = findViewById(R.id.tvCall);
        tvLoadImage = findViewById(R.id.tvLoadImageInternet);
        tvLoadContentInternet = findViewById(R.id.tvLoadContentInternet);
        tvLoadContentRSS = findViewById(R.id.tvLoadContentRSS);
        tvLoadJSON = findViewById(R.id.tvLoadJSON);
        tvLoadJSONLanguage = findViewById(R.id.tvLoadJSONLanguage);
        tvLoadJSONArrayObject = findViewById(R.id.tvLoadJSONArrayObject);
        tvVolleyString = findViewById(R.id.tvVolleyString);
        tvVolleyObject = findViewById(R.id.tvVolleyObject);
        tvMediaPlay = findViewById(R.id.tvMediaPlay);
        tvSQLite = findViewById(R.id.tvSQLite);
        tvFragment = findViewById(R.id.tvFragment);
        btnCamera = findViewById(R.id.btnCamera);
        imageViewProfile = findViewById(R.id.imageViewProfile);
        attachListener();


        test = findViewById(R.id.test);
        hint  = findViewById(R.id.hint);

        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detachListener();
                int_id.setChecked(false);
                double_id.setChecked(false);
                all.setChecked(false);
                attachListener();
                string_id.setChecked(true);

            }
        });

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mgs = "";
                if (!int_id.isChecked() &&
                        !double_id.isChecked() &&
                        string_id.isChecked())
                    mgs = "Đúng, chúc mừng";
                else
                    mgs = "Sai rồi";

                Toast.makeText(view.getContext(),
                        mgs,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onClickListUsers(View v) {
        Intent myIntent = new Intent(getBaseContext(), ListUserActivity.class);
        startActivity(myIntent);
    }

}
