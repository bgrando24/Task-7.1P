package com.example.task_71p;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class NewAdvertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new_advert);

//        Component references

        EditText itemNameEditText = findViewById(R.id.itemNameEditText);
        EditText itemPhoneEditText = findViewById(R.id.itemPhoneEditText);
        EditText itemDescrtiptionMultiLine = findViewById(R.id.itemDescriptionMultiLine);
        EditText itemDate = findViewById(R.id.itemDate);
        EditText itemLocationEditText = findViewById(R.id.itemLocationEditText);

//        for getting which radio button (post type) is selected
        RadioButton lostRadioButton = findViewById(R.id.lostRadioButton);
        RadioButton foundRadioButton = findViewById(R.id.foundRadioButton);

//        submit button
        Button submitNewAdvertButton = findViewById(R.id.submitNewAdvertButton);
        submitNewAdvertButton.setOnClickListener(v -> {
            String itemName = itemNameEditText.getText().toString();
            String itemPhone = itemPhoneEditText.getText().toString();
            String itemDescription = itemDescrtiptionMultiLine.getText().toString();
            String submissionDate = itemDate.getText().toString();
            String itemLocation = itemLocationEditText.getText().toString();
            String postType;

            if (lostRadioButton.isChecked()) {
                postType = "Lost";
            } else if (foundRadioButton.isChecked()) {
                postType = "Found";
            } else {
                Snackbar.make(v, "Select post type", Snackbar.LENGTH_LONG).show();
                return;
            }

            if (itemName.isEmpty()) {
                itemNameEditText.setError("Item name is required");
                return;
            }
            if (itemPhone.isEmpty()) {
                itemPhoneEditText.setError("Phone number is required");
                return;
            }
            if (itemDescription.isEmpty()) {
                itemDescrtiptionMultiLine.setError("Description is required");
                return;
            }
            if (submissionDate.isEmpty()) {
                itemDate.setError("Date is required");
                return;
            }
            if (itemLocation.isEmpty()) {
                itemLocationEditText.setError("Location is required");
                return;
            }

//            all checks passed, insert data in db
            LostFoundItem lostFoundItem = new LostFoundItem(postType, itemName, itemPhone, itemDescription, submissionDate, itemLocation);
            DataManager dm = new DataManager(this);
            boolean wasSuccessful = dm.addLostFoundItem(lostFoundItem);
            if (wasSuccessful) {
                Toast.makeText(this, "Advert submitted", Toast.LENGTH_LONG).show();
                Intent showAllIntent = new Intent(this, ShowAllActivity.class);
                startActivity(showAllIntent);
            } else {
                Toast.makeText(this, "Failed to submit advert", Toast.LENGTH_LONG).show();
            }
        });

    }
}