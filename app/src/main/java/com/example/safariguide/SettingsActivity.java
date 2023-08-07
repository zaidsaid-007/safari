package com.example.safariguide;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private Switch switchNotification;
    private Switch switchSound;
    private Switch switchVibration;
    private SeekBar seekBarVolume;
    private TextView textVolume;
    private Spinner spinnerLanguage;
    private Button btnSave;

    private int currentVolume = 50;
    private boolean isNotificationEnabled = true;
    private boolean isSoundEnabled = true;
    private boolean isVibrationEnabled = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        switchNotification = findViewById(R.id.switchNotification);
        switchSound = findViewById(R.id.switchSound);
        switchVibration = findViewById(R.id.switchVibration);
        seekBarVolume = findViewById(R.id.seekBarVolume);
        textVolume = findViewById(R.id.textVolume);
        spinnerLanguage = findViewById(R.id.spinnerLanguage);
        btnSave = findViewById(R.id.btnSave);

        // Initialize the UI with the current settings
        switchNotification.setChecked(isNotificationEnabled);
        switchSound.setChecked(isSoundEnabled);
        switchVibration.setChecked(isVibrationEnabled);
        seekBarVolume.setProgress(currentVolume);
        textVolume.setText("Volume: " + currentVolume);

        // Volume seek bar listener
        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentVolume = progress;
                textVolume.setText("Volume: " + currentVolume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }
        });

        // Spinner for language selection
        ArrayAdapter<CharSequence> languageAdapter = ArrayAdapter.createFromResource(this,
                R.array.languages_array, android.R.layout.simple_spinner_item);
        languageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLanguage.setAdapter(languageAdapter);
        spinnerLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLanguage = parent.getItemAtPosition(position).toString();
                Toast.makeText(SettingsActivity.this, "Selected Language: " + selectedLanguage,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        // Save button click listener
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save the settings and show a toast message
                saveSettings();
                String message = "Settings saved!";
                Toast.makeText(SettingsActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveSettings() {
        // Save the current settings to your preferences or database
        isNotificationEnabled = switchNotification.isChecked();
        isSoundEnabled = switchSound.isChecked();
        isVibrationEnabled = switchVibration.isChecked();
        // Save the other settings as needed
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Apply any logic needed when the activity resumes
        // For example, update the UI based on the saved settings
        switchNotification.setChecked(isNotificationEnabled);
        switchSound.setChecked(isSoundEnabled);
        switchVibration.setChecked(isVibrationEnabled);
        seekBarVolume.setProgress(currentVolume);
        textVolume.setText("Volume: " + currentVolume);
    }
}
