package com.kostya_zinoviev.actioncall_intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edNumber;
    private Button actionButton;
    private String numberPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edNumber = findViewById(R.id.phoneEdText);
        actionButton = findViewById(R.id.actionButton);
        actionButton.setOnClickListener(this);
        edNumber.setText("89516913476");
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.actionButton:
                if (TextUtils.isEmpty(edNumber.getText().toString().trim())) {
                    Toast.makeText(this, "Зполните пустое поле!", Toast.LENGTH_SHORT).show();
                    return;
                }
                numberPhone = edNumber.getText().toString();
                    Intent actionPhone = new Intent(Intent.ACTION_DIAL);
                actionPhone.setData(Uri.parse("tel:"+numberPhone));

                    startActivity(actionPhone);
            break;
        }
    }

}
