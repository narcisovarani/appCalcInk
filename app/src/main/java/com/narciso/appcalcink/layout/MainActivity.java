package com.narciso.appcalcink.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.narciso.appcalcink.R;
import com.narciso.appcalcink.data.Data;
import com.narciso.appcalcink.model.Wall;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ViewHolder mViewHolder = new ViewHolder();
    private Data mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        this.mData = new Data(this);

        if (this.mData.getNumWalls().isEmpty())
            this.mData.setNumWalls("0");

        this.mViewHolder.layout_empty = findViewById(R.id.layout_empty);
        this.mViewHolder.layout_room = findViewById(R.id.layout_room);
        this.mViewHolder.button_add = findViewById(R.id.button_add);
        this.mViewHolder.button_calc = findViewById(R.id.button_calc);

        // PAREDE 1
        this.mViewHolder.layout_wall1 = findViewById(R.id.layout_wall1);
        this.mViewHolder.layout_wall1_header = findViewById(R.id.layout_wall1_header);
        this.mViewHolder.layout_wall1_info = findViewById(R.id.layout_wall1_info);
        this.mViewHolder.layout_wall1_altura = findViewById(R.id.layout_wall1_altura);
        this.mViewHolder.layout_wall1_portas = findViewById(R.id.layout_wall1_portas);
        this.mViewHolder.layout_wall1_janelas = findViewById(R.id.layout_wall1_janelas);
        this.mViewHolder.layout_wall1_largura = findViewById(R.id.layout_wall1_largura);

        // PAREDE 2
        this.mViewHolder.layout_wall2 = findViewById(R.id.layout_wall2);
        this.mViewHolder.layout_wall2_header = findViewById(R.id.layout_wall2_header);
        this.mViewHolder.layout_wall2_info = findViewById(R.id.layout_wall2_info);
        this.mViewHolder.layout_wall2_altura = findViewById(R.id.layout_wall2_altura);
        this.mViewHolder.layout_wall2_portas = findViewById(R.id.layout_wall2_portas);
        this.mViewHolder.layout_wall2_janelas = findViewById(R.id.layout_wall2_janelas);
        this.mViewHolder.layout_wall2_largura = findViewById(R.id.layout_wall2_largura);

        // PAREDE 3
        this.mViewHolder.layout_wall3 = findViewById(R.id.layout_wall3);
        this.mViewHolder.layout_wall3_header = findViewById(R.id.layout_wall3_header);
        this.mViewHolder.layout_wall3_info = findViewById(R.id.layout_wall3_info);
        this.mViewHolder.layout_wall3_altura = findViewById(R.id.layout_wall3_altura);
        this.mViewHolder.layout_wall3_portas = findViewById(R.id.layout_wall3_portas);
        this.mViewHolder.layout_wall3_janelas = findViewById(R.id.layout_wall3_janelas);
        this.mViewHolder.layout_wall3_largura = findViewById(R.id.layout_wall3_largura);

        // PAREDE 4
        this.mViewHolder.layout_wall4 = findViewById(R.id.layout_wall4);
        this.mViewHolder.layout_wall4_header = findViewById(R.id.layout_wall4_header);
        this.mViewHolder.layout_wall4_info = findViewById(R.id.layout_wall4_info);
        this.mViewHolder.layout_wall4_altura = findViewById(R.id.layout_wall4_altura);
        this.mViewHolder.layout_wall4_portas = findViewById(R.id.layout_wall4_portas);
        this.mViewHolder.layout_wall4_janelas = findViewById(R.id.layout_wall4_janelas);
        this.mViewHolder.layout_wall4_largura = findViewById(R.id.layout_wall4_largura);


        this.mViewHolder.button_add.setOnClickListener(this);
        this.mViewHolder.button_calc.setOnClickListener(this);
        this.mViewHolder.layout_wall1_header.setOnClickListener(this);
        this.mViewHolder.layout_wall2_header.setOnClickListener(this);
        this.mViewHolder.layout_wall3_header.setOnClickListener(this);
        this.mViewHolder.layout_wall4_header.setOnClickListener(this);

        showWall();
//        this.mViewHolder.room.getWall(0).setAltura(50.00);
//        this.mViewHolder.layout_wall1_altura.setText(this.mViewHolder.room.getWall(0).getAltura().toString());

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_add) {
            Intent add = new Intent(this, FormWall.class);
            startActivityForResult(add, 37);

        } else if (v.getId() == R.id.layout_wall1_header) {
            if (this.mViewHolder.layout_wall1_info.getVisibility() == View.VISIBLE){
                this.mViewHolder.layout_wall1_info.setVisibility(View.GONE);
            } else {
                this.mViewHolder.layout_wall1_info.setVisibility(View.VISIBLE);
                this.mViewHolder.layout_wall2_info.setVisibility(View.GONE);
                this.mViewHolder.layout_wall3_info.setVisibility(View.GONE);
                this.mViewHolder.layout_wall4_info.setVisibility(View.GONE);

            }
        } else if (v.getId() == R.id.layout_wall2_header) {
            if (this.mViewHolder.layout_wall2_info.getVisibility() == View.VISIBLE){
                this.mViewHolder.layout_wall2_info.setVisibility(View.GONE);
            } else {
                this.mViewHolder.layout_wall2_info.setVisibility(View.VISIBLE);
                this.mViewHolder.layout_wall1_info.setVisibility(View.GONE);
                this.mViewHolder.layout_wall3_info.setVisibility(View.GONE);
                this.mViewHolder.layout_wall4_info.setVisibility(View.GONE);
            }
        }
        else if (v.getId() == R.id.layout_wall3_header) {
            if (this.mViewHolder.layout_wall3_info.getVisibility() == View.VISIBLE){
                this.mViewHolder.layout_wall3_info.setVisibility(View.GONE);
            } else {
                this.mViewHolder.layout_wall3_info.setVisibility(View.VISIBLE);
                this.mViewHolder.layout_wall2_info.setVisibility(View.GONE);
                this.mViewHolder.layout_wall1_info.setVisibility(View.GONE);
                this.mViewHolder.layout_wall4_info.setVisibility(View.GONE);
            }
        }
        else if (v.getId() == R.id.layout_wall4_header) {
            if (this.mViewHolder.layout_wall4_info.getVisibility() == View.VISIBLE){
                this.mViewHolder.layout_wall4_info.setVisibility(View.GONE);
            } else {
                this.mViewHolder.layout_wall4_info.setVisibility(View.VISIBLE);
                this.mViewHolder.layout_wall2_info.setVisibility(View.GONE);
                this.mViewHolder.layout_wall3_info.setVisibility(View.GONE);
                this.mViewHolder.layout_wall1_info.setVisibility(View.GONE);
            }
        }

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 37) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "Parede Adicionada", Toast.LENGTH_LONG).show();

                showWall();
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "CANCELOU", Toast.LENGTH_LONG).show();
            }
        }
    }



    private void showWall() {
        Gson gson = new Gson();

        Wall parede_1 = gson.fromJson(this.mData.getStoreString("Wall_0"), Wall.class);
        Wall parede_2 = gson.fromJson(this.mData.getStoreString("Wall_1"), Wall.class);
        Wall parede_3 = gson.fromJson(this.mData.getStoreString("Wall_2"), Wall.class);
        Wall parede_4 = gson.fromJson(this.mData.getStoreString("Wall_3"), Wall.class);

        mViewHolder.layout_empty.setVisibility(View.VISIBLE);
        mViewHolder.layout_room.setVisibility(View.VISIBLE);

        if (parede_1 != null) {
            this.mViewHolder.layout_wall1_altura.setText(String.valueOf(parede_1.getAltura()));
            this.mViewHolder.layout_wall1_largura.setText(String.valueOf(parede_1.getLargura()));
            this.mViewHolder.layout_wall1_janelas.setText(String.valueOf(parede_1.getJanelas()));
            this.mViewHolder.layout_wall1_portas.setText(String.valueOf(parede_1.getPortas()));
            mViewHolder.layout_wall1.setVisibility(View.VISIBLE);
            mViewHolder.layout_empty.setVisibility(View.GONE);
        } else {
            mViewHolder.layout_wall1.setVisibility(View.GONE);
        }

        if (parede_2 != null) {
            mViewHolder.layout_wall2.setVisibility(View.VISIBLE);
            this.mViewHolder.layout_wall2_altura.setText(String.valueOf(parede_2.getAltura()));
            this.mViewHolder.layout_wall2_largura.setText(String.valueOf(parede_2.getLargura()));
            this.mViewHolder.layout_wall2_janelas.setText(String.valueOf(parede_2.getJanelas()));
            this.mViewHolder.layout_wall2_portas.setText(String.valueOf(parede_2.getPortas()));
        }

        if (parede_3 != null) {
            mViewHolder.layout_wall3.setVisibility(View.VISIBLE);
            this.mViewHolder.layout_wall3_altura.setText(String.valueOf(parede_3.getAltura()));
            this.mViewHolder.layout_wall3_largura.setText(String.valueOf(parede_3.getLargura()));
            this.mViewHolder.layout_wall3_janelas.setText(String.valueOf(parede_3.getJanelas()));
            this.mViewHolder.layout_wall3_portas.setText(String.valueOf(parede_3.getPortas()));
        }

        if (parede_4 != null) {
            this.mViewHolder.layout_wall4_altura.setText(String.valueOf(parede_4.getAltura()));
            this.mViewHolder.layout_wall4_largura.setText(String.valueOf(parede_4.getLargura()));
            this.mViewHolder.layout_wall4_janelas.setText(String.valueOf(parede_4.getJanelas()));
            this.mViewHolder.layout_wall4_portas.setText(String.valueOf(parede_4.getPortas()));
            mViewHolder.layout_wall4.setVisibility(View.VISIBLE);
            mViewHolder.button_calc.setVisibility(View.VISIBLE);
            mViewHolder.button_add.setVisibility(View.GONE);
        }
    }

    private static class ViewHolder {

        RelativeLayout layout_empty;
        RelativeLayout layout_room;
        Button button_add;
        Button button_calc;

        RelativeLayout layout_wall1;
        RelativeLayout layout_wall1_header;
        RelativeLayout layout_wall1_info;
        TextView layout_wall1_altura;
        TextView layout_wall1_portas;
        TextView layout_wall1_janelas;
        TextView layout_wall1_largura;

        RelativeLayout layout_wall2;
        RelativeLayout layout_wall2_header;
        RelativeLayout layout_wall2_info;
        TextView layout_wall2_altura;
        TextView layout_wall2_portas;
        TextView layout_wall2_janelas;
        TextView layout_wall2_largura;

        RelativeLayout layout_wall3;
        RelativeLayout layout_wall3_header;
        RelativeLayout layout_wall3_info;
        TextView layout_wall3_altura;
        TextView layout_wall3_portas;
        TextView layout_wall3_janelas;
        TextView layout_wall3_largura;

        RelativeLayout layout_wall4;
        RelativeLayout layout_wall4_header;
        RelativeLayout layout_wall4_info;
        TextView layout_wall4_altura;
        TextView layout_wall4_portas;
        TextView layout_wall4_janelas;
        TextView layout_wall4_largura;
    }

}