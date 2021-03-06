package com.example.roskata.dentalclinicimperial;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);

        setSupportActionBar(myToolbar);


        getSupportActionBar().setTitle("Dental Center Imperial");
        getSupportActionBar().setIcon(getDrawable(R.drawable.imperial_logo));

        //View Pager
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 3500, 5000);

        final TextView web = (TextView) findViewById(R.id.web);
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myWeblink = new Intent(Intent.ACTION_VIEW);
                myWeblink.setData(Uri.parse("http://www.dentalimperial.com"));
                startActivity(myWeblink);
            }
        });

        final TextView map = (TextView) findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://goo.gl/maps/pDDf7AAHCWk"));
                startActivity(myWebLink);
            }

        });

        final TextView calendar = (TextView) findViewById(R.id.working_days);
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("http://www.dentalimperial.com/contacts"));
                startActivity(myWebLink);
            }
        });

        final ImageView fb_link = (ImageView) findViewById(R.id.fb_icon);
        fb_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://www.facebook.com/dentalimperial/m"));
                startActivity(myWebLink);
            }
        });


    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem(2);
                    } else if (viewPager.getCurrentItem() == 2) {
                        viewPager.setCurrentItem(3);
                    } else if (viewPager.getCurrentItem() == 3) {
                        viewPager.setCurrentItem(4);
                    } else if (viewPager.getCurrentItem() == 4) {
                        viewPager.setCurrentItem(5);
                    } else if (viewPager.getCurrentItem() == 5) {
                        viewPager.setCurrentItem(6);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });

        }
    }


}
