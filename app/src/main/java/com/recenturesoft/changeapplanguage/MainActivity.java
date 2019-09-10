package com.recenturesoft.changeapplanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.recenturesoft.changeapplanguage.custom.PrefUtils;
import com.recenturesoft.changeapplanguage.model.AppConstants;
import com.recenturesoft.changeapplanguage.model.LanguageType;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private LinearLayout llArabic,llHindi,llEnglish;
    private ImageView imgSelect2,imgSelect3,imgSelect1;

    private TextView txtChooseLanguage;

    private Button btnUpdate;

    private String selectedLanguage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUpdate= (Button) findViewById(R.id.btnUpdate);

        txtChooseLanguage= (TextView) findViewById(R.id.txtChooseLanguage);

        try {
            selectedLanguage= PrefUtils.getLanguage(MainActivity.this).languageType;
            Log.e("Selected language",selectedLanguage);
        } catch (Exception e) {
            Log.e("eeror",e+"");
            selectedLanguage=AppConstants.English;
            e.printStackTrace();
        }



        llArabic= (LinearLayout) findViewById(R.id.llArabic);
        llHindi= (LinearLayout) findViewById(R.id.llHindi);
        llEnglish= (LinearLayout) findViewById(R.id.llEnglish);

        imgSelect1= (ImageView) findViewById(R.id.imgSelect1);
        imgSelect2= (ImageView) findViewById(R.id.imgSelect2);
        imgSelect3= (ImageView) findViewById(R.id.imgSelect3);

        updateData();

        llArabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgSelect1.setVisibility(View.GONE);
                imgSelect2.setVisibility(View.GONE);
                imgSelect3.setVisibility(View.VISIBLE);
                txtChooseLanguage.setText("اختر لغتك");
                btnUpdate.setText("અપડેટ");
                selectedLanguage=AppConstants.ARABIC;
            }
        });

        llHindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imgSelect1.setVisibility(View.GONE);
                imgSelect2.setVisibility(View.VISIBLE);
                imgSelect3.setVisibility(View.GONE);
                txtChooseLanguage.setText("अपनी भाषा चुनें");
                btnUpdate.setText("تحديث");
                selectedLanguage=AppConstants.HINDI;
            }
        });

        llEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgSelect1.setVisibility(View.VISIBLE);
                imgSelect2.setVisibility(View.GONE);
                imgSelect3.setVisibility(View.GONE);
                txtChooseLanguage.setText("Choose your language");
                btnUpdate.setText("UPDATE");
                selectedLanguage=AppConstants.English;
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LanguageType languageType=new LanguageType();
                if(selectedLanguage.equalsIgnoreCase(AppConstants.English)){
                    languageType.languageType=AppConstants.English;
                    PrefUtils.setLanguage(languageType,MainActivity.this);
                    Log.e("Selected language",PrefUtils.getLanguage(MainActivity.this).languageType);
                    Configuration config = new Configuration();
                    config.locale = Locale.ENGLISH;
                    getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                }else if(selectedLanguage.equalsIgnoreCase(AppConstants.HINDI)){
                    languageType.languageType=AppConstants.HINDI;
                    PrefUtils.setLanguage(languageType,MainActivity.this);
                    Log.e("Selected language",PrefUtils.getLanguage(MainActivity.this).languageType);
                    Configuration config = new Configuration();
                    config.locale = Locale.FRENCH;
                    getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                }else if(selectedLanguage.equalsIgnoreCase(AppConstants.ARABIC)){
                    languageType.languageType=AppConstants.ARABIC;
                    PrefUtils.setLanguage(languageType,MainActivity.this);

                    Log.e("Selected language", PrefUtils.getLanguage(MainActivity.this).languageType);
                    Configuration config = new Configuration();
                    config.locale = Locale.GERMANY;
                    getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                }

                Intent i=new Intent(getApplicationContext(),LanguageActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    private void updateData() {
        if(selectedLanguage.equalsIgnoreCase(AppConstants.English)){
            imgSelect1.setVisibility(View.VISIBLE);
            imgSelect2.setVisibility(View.GONE);
            imgSelect3.setVisibility(View.GONE);
            txtChooseLanguage.setText("Choose your language");
            btnUpdate.setText("UPDATE");

        }else if(selectedLanguage.equalsIgnoreCase(AppConstants.HINDI)){
            imgSelect1.setVisibility(View.GONE);
            imgSelect2.setVisibility(View.VISIBLE);
            imgSelect3.setVisibility(View.GONE);
            txtChooseLanguage.setText("अपनी भाषा चुनें");
            btnUpdate.setText("अपडेट");
        }else if(selectedLanguage.equalsIgnoreCase(AppConstants.ARABIC)){
            imgSelect1.setVisibility(View.GONE);
            imgSelect2.setVisibility(View.GONE);
            imgSelect3.setVisibility(View.VISIBLE);
            txtChooseLanguage.setText("اختر لغتك");
            btnUpdate.setText("تحديث");
        }
    }
}
