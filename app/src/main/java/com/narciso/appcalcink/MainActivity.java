package com.narciso.appcalcink;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewHolder.room.init();
        this.mViewHolder.layout_empty = findViewById(R.id.layout_empty);
        this.mViewHolder.layout_room = findViewById(R.id.layout_room);
        this.mViewHolder.button_add = findViewById(R.id.button_add);

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
        this.mViewHolder.layout_wall1_header.setOnClickListener(this);

        this.mViewHolder.room.getWall(0).setAltura(50.00);
        this.mViewHolder.layout_wall1_altura.setText(this.mViewHolder.room.getWall(0).getAltura().toString());

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_add) {
            this.mViewHolder.layout_empty.setVisibility(View.GONE);
            this.mViewHolder.layout_room.setVisibility(View.VISIBLE);
            this.mViewHolder.layout_wall1.setVisibility(View.VISIBLE);
        } else if (v.getId() == R.id.layout_wall1_header) {
            this.mViewHolder.layout_wall1_info.setVisibility(View.VISIBLE);
        }

    }

    private static class ViewHolder {
        Room room = new Room();

        RelativeLayout layout_empty;
        RelativeLayout layout_room;
        Button button_add;

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