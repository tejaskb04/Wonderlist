package com.falak_tejas.wonderlist;

/**
 * Created by Falak on 9/23/17.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

import java.util.ArrayList;
import java.util.List;

public class CategoryMainActivity extends AppCompatActivity {
    List items = new ArrayList();
    //ItemAdapter adapter;
    private Button addItemBtn;
    private final int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;
    String titleCat;
    ScrollView scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_main);

        titleCat = getIntent().getStringExtra("Category title");

        items.add("Tokyo");
        items.add("London");
        items.add("Buenos Aires");
        items.add("Paris");
        items.add("New York City");
        items.add("Seattle");
        items.add("Miami");
        items.add("St. Petersburg");

        scroll = (ScrollView) findViewById(R.id.scrollItem);

        for(int i = 0; i < items.size(); i++){
            Button item = new Button(this);
            String title = items.get(i).toString();
            item.setText(title);
            scroll.addView(item);
        }
        //adapter = new ItemAdapter(items, this);
        //listItem.setAdapter(adapter);
        TextView title = (TextView) findViewById(R.id.catTitle);
        title.setTextSize(32);
        title.setText(titleCat);


        addItemBtn = (Button) findViewById(R.id.btn_add_item);
        addItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent =
                            new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                                    .build(CategoryMainActivity.this);
                    startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE);

                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                System.out.println("hi");
                Place place = PlaceAutocomplete.getPlace(CategoryMainActivity.this, data);
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(CategoryMainActivity.this, data);
                System.out.println(status);
            } else if (resultCode == RESULT_CANCELED) {
                //System.out.println("hi");
                // Do Nothing
            }
        }
    }
}
