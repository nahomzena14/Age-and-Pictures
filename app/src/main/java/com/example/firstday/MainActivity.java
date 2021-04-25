package com.example.firstday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button addButton;
    private Button minusButton;
    private ImageView imageView;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.count_view);
        textView.setText(getString(R.string.counter,count));
        addButton = findViewById(R.id.plus_button);
        minusButton = findViewById(R.id.minus_button);
        imageView = findViewById(R.id.person_image);

        if(count == 0) {
            minusButton.setEnabled(false);
        }

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                textView.setTextColor(Color.RED);
                textView.setText(getString(R.string.counter,count));
                checkCount(imageView);
                minusButton.setEnabled(true);
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count == 0) {
                    minusButton.setEnabled(false);
                }
                count--;
                checkCount(imageView);
                textView.setTextColor(Color.BLUE);
                textView.setText(getString(R.string.counter, count));
                if(count == 0) {
                    minusButton.setEnabled(false);
                }
            }
        });
    }

    // change picture based on age(count)
    public void checkCount(ImageView imageView){
        //0-2 = babies
        if(count>=0 && count <=2){
            imageView.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.baby_pics));
        }
        //3-16 = children
        if(count>=3 && count <=16){
            imageView.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.child_pics));
        }
        //17-30 = young adults
        if(count>=17 && count <=30){
            imageView.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.young_adult_pic));
        }
        //31-45 = middle aged adults
        if(count>=31 && count <=45){
            imageView.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.middleage_pic));
        }
        //45> = old adults
        if(count>=46){
            imageView.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.oldadult_pic));
        }
    }

}