package com.example.trashspot;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageButton IB_bag,IB_trolley,IB_truck ,type[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final boolean[] bag = {false};
        final boolean[] tro = { false };
        final boolean[] truc = { false };
        type = new ImageButton[11];
        boolean[] type_selct = {false,false,false,false,false,false,false,false,false,false,false};
        type[0] = findViewById(R.id.IB_house);
        type[1] = findViewById(R.id.IB_auto);
        type[2] = findViewById(R.id.IB_cons);
        type[3] = findViewById(R.id.IB_plas);
        type[4] = findViewById(R.id.IB_elec);
        type[5] = findViewById(R.id.IB_org);
        type[6] = findViewById(R.id.IB_met);
        type[7] = findViewById(R.id.IB_liq);
        type[8] = findViewById(R.id.IB_tox);
        type[9] = findViewById(R.id.IB_ani);
        type[10] = findViewById(R.id.IB_glas);
        IB_bag = findViewById(R.id.IB_size_bag);
        IB_trolley = findViewById(R.id.IB_size_trolley);
        IB_truck = findViewById(R.id.IB_size_truck);

        getSupportFragmentManager().beginTransaction().hide(FragmentManager.findFragment(findViewById(R.id.fragment))).commit();

        findViewById(R.id.btn_spot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1);
            }
        });

        findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,submitActivity.class);
                startActivity(intent);
            }
        });

        IB_bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!bag[0]){
                    IB_bag.setBackground(getDrawable(R.drawable.round_button_selected));
                    IB_bag.setImageDrawable(getDrawable(R.drawable.garbagebagwhite));
                    IB_trolley.setBackground(getDrawable(R.drawable.round_button));
                    IB_trolley.setImageDrawable(getDrawable(R.drawable.trolley));
                    IB_truck.setBackground(getDrawable(R.drawable.round_button));
                    IB_truck.setImageDrawable(getDrawable(R.drawable.garbagetruck));
                    bag[0] =true;
                    truc[0] =false;
                    tro[0] =false;
                }else{
                    IB_bag.setBackground(getDrawable(R.drawable.round_button));
                    IB_bag.setImageDrawable(getDrawable(R.drawable.garbagebag));
                    bag[0]=false;
                }
            }
        });

        IB_trolley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tro[0]){
                    IB_bag.setBackground(getDrawable(R.drawable.round_button));
                    IB_bag.setImageDrawable(getDrawable(R.drawable.garbagebag));
                    IB_trolley.setBackground(getDrawable(R.drawable.round_button_selected));
                    IB_trolley.setImageDrawable(getDrawable(R.drawable.trolleywhite));
                    IB_truck.setBackground(getDrawable(R.drawable.round_button));
                    IB_truck.setImageDrawable(getDrawable(R.drawable.garbagetruck));
                    bag[0] =false;
                    truc[0] =false;
                    tro[0] =true;
                }else{
                    IB_trolley.setBackground(getDrawable(R.drawable.round_button));
                    IB_trolley.setImageDrawable(getDrawable(R.drawable.trolley));
                    tro[0]=false;
                }
            }
        });

        IB_truck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!truc[0]){
                    IB_bag.setBackground(getDrawable(R.drawable.round_button));
                    IB_bag.setImageDrawable(getDrawable(R.drawable.garbagebag));
                    IB_trolley.setBackground(getDrawable(R.drawable.round_button));
                    IB_trolley.setImageDrawable(getDrawable(R.drawable.trolley));
                    IB_truck.setBackground(getDrawable(R.drawable.round_button_selected));
                    IB_truck.setImageDrawable(getDrawable(R.drawable.garbagetruckwhite));
                    bag[0] =false;
                    truc[0] =true;
                    tro[0] =false;
                }else{
                    IB_truck.setBackground(getDrawable(R.drawable.round_button));
                    IB_truck.setImageDrawable(getDrawable(R.drawable.garbagetruck));
                    truc[0]=false;
                }
            }
        });

        type[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!type_selct[0]){
                    type[0].setBackground(getDrawable(R.drawable.round_button_selected));
                    type_selct[0]=true;
                    type[0].setImageDrawable(getDrawable(R.drawable.cleaningtools));
                }else{
                    type[0].setBackground(getDrawable(R.drawable.round_button));
                    type_selct[0]=false;
                    type[0].setImageDrawable(getDrawable(R.drawable.cleaningtoolsdark));
                }
            }
        });

        type[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!type_selct[1]){
                    type[1].setBackground(getDrawable(R.drawable.round_button_selected));
                    type_selct[1]=true;
                    type[1].setImageDrawable(getDrawable(R.drawable.brake));
                }else{
                    type[1].setBackground(getDrawable(R.drawable.round_button));
                    type_selct[1]=false;
                    type[1].setImageDrawable(getDrawable(R.drawable.brakedark));
                }
            }
        });

        type[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!type_selct[2]){
                    type[2].setBackground(getDrawable(R.drawable.round_button_selected));
                    type_selct[2]=true;
                    type[2].setImageDrawable(getDrawable(R.drawable.garbagedark));
                }else{
                    type[2].setBackground(getDrawable(R.drawable.round_button));
                    type_selct[2]=false;
                    type[2].setImageDrawable(getDrawable(R.drawable.garbage));
                }
            }
        });

        type[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!type_selct[3]){
                    type[3].setBackground(getDrawable(R.drawable.round_button_selected));
                    type_selct[3]=true;
                    type[3].setImageDrawable(getDrawable(R.drawable.plasticwhite));
                }else{
                    type[3].setBackground(getDrawable(R.drawable.round_button));
                    type_selct[3]=false;
                    type[3].setImageDrawable(getDrawable(R.drawable.plastic));
                }
            }
        });

        type[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!type_selct[4]){
                    type[4].setBackground(getDrawable(R.drawable.round_button_selected));
                    type_selct[4]=true;
                    type[4].setImageDrawable(getDrawable(R.drawable.tvwhite));
                }else{
                    type[4].setBackground(getDrawable(R.drawable.round_button));
                    type_selct[4]=false;
                    type[4].setImageDrawable(getDrawable(R.drawable.tvdark));
                }
            }
        });

        type[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!type_selct[5]){
                    type[5].setBackground(getDrawable(R.drawable.round_button_selected));
                    type_selct[5]=true;
                    type[5].setImageDrawable(getDrawable(R.drawable.trashbinwhite));
                }else{
                    type[5].setBackground(getDrawable(R.drawable.round_button));
                    type_selct[5]=false;
                    type[5].setImageDrawable(getDrawable(R.drawable.trashbin));
                }
            }
        });

        type[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!type_selct[6]){
                    type[6].setBackground(getDrawable(R.drawable.round_button_selected));
                    type_selct[6]=true;
                    type[6].setImageDrawable(getDrawable(R.drawable.rubbishwhite));
                }else{
                    type[6].setBackground(getDrawable(R.drawable.round_button));
                    type_selct[6]=false;
                    type[6].setImageDrawable(getDrawable(R.drawable.rubbishdark));
                }
            }
        });

        type[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!type_selct[7]){
                    type[7].setBackground(getDrawable(R.drawable.round_button_selected));
                    type_selct[7]=true;
                    type[7].setImageDrawable(getDrawable(R.drawable.kerosenewhite));
                }else{
                    type[7].setBackground(getDrawable(R.drawable.round_button));
                    type_selct[7]=false;
                    type[7].setImageDrawable(getDrawable(R.drawable.kerosene));
                }
            }
        });

        type[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!type_selct[8]){
                    type[8].setBackground(getDrawable(R.drawable.round_button_selected));
                    type_selct[8]=true;
                    type[8].setImageDrawable(getDrawable(R.drawable.toxicwhite));
                }else{
                    type[8].setBackground(getDrawable(R.drawable.round_button));
                    type_selct[8]=false;
                    type[8].setImageDrawable(getDrawable(R.drawable.toxic));
                }
            }
        });

        type[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!type_selct[9]){
                    type[9].setBackground(getDrawable(R.drawable.round_button_selected));
                    type_selct[9]=true;
                    type[9].setImageDrawable(getDrawable(R.drawable.deadbird));
                }else{
                    type[9].setBackground(getDrawable(R.drawable.round_button));
                    type_selct[9]=false;
                    type[9].setImageDrawable(getDrawable(R.drawable.deadbirddark));
                }
            }
        });

        type[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!type_selct[10]){
                    type[10].setBackground(getDrawable(R.drawable.round_button_selected));
                    type_selct[10]=true;
                    type[10].setImageDrawable(getDrawable(R.drawable.bottlewhite));
                }else{
                    type[10].setBackground(getDrawable(R.drawable.round_button));
                    type_selct[10]=false;
                    type[10].setImageDrawable(getDrawable(R.drawable.bottle));
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                ((ImageView)findViewById(R.id.iv_scan)).setImageBitmap((Bitmap) data.getExtras().get("data"));
                findViewById(R.id.btn_spot).setVisibility(View.GONE);
                findViewById(R.id.iv_img).setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().show(FragmentManager.findFragment(findViewById(R.id.fragment))).commit();

            }
        }
    }
}