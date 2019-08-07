package com.ardakazanci.androidcustomspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	List<String> listItem = new ArrayList<>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		generateData();
		Spinner spinner = findViewById(R.id.spinner);
		SpinnerAdapter spinnerAdapter = new com.ardakazanci.androidcustomspinner.SpinnerAdapter(MainActivity.this,listItem);
		spinner.setAdapter(spinnerAdapter);
		// Spinner menünün altında kalması sağlanıyor. Dikeyde
		spinner.setDropDownVerticalOffset(100);

	}

	private void generateData() {

		for (int i = 0; i < 10; i++) {

			listItem.add("Item " + i);

		}

	}
}
