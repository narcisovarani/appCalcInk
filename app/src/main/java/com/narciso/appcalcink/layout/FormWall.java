package com.narciso.appcalcink.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.narciso.appcalcink.R;
import com.narciso.appcalcink.data.Data;
import com.narciso.appcalcink.model.Wall;

public class FormWall extends AppCompatActivity implements View.OnClickListener {

    ViewHolder mViewHolder = new ViewHolder();
    private Data mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_wall);

        this.mData = new Data(this);

        this.mViewHolder.text_title = findViewById(R.id.text_title);
        this.mViewHolder.edit_altura = findViewById(R.id.edit_altura);
        this.mViewHolder.edit_largura = findViewById(R.id.edit_largura);
        this.mViewHolder.edit_janelas = findViewById(R.id.edit_janelas);
        this.mViewHolder.edit_portas = findViewById(R.id.edit_portas);
        this.mViewHolder.button_add = findViewById(R.id.button_add);
        this.mViewHolder.button_return = findViewById(R.id.button_return);

        this.mViewHolder.button_add.setOnClickListener(this);
        this.mViewHolder.button_return.setOnClickListener(this);

        int numWall = Integer.parseInt(this.mData.getNumWalls()) + 1;
        String text = "Parede " + numWall;
        this.mViewHolder.text_title.setText(text);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_add) {
            String altura = this.mViewHolder.edit_altura.getText().toString();
            String largura = this.mViewHolder.edit_largura.getText().toString();
            String janelas = this.mViewHolder.edit_janelas.getText().toString();
            String portas = this.mViewHolder.edit_portas.getText().toString();

            if ("".equals(altura) || "".equals(largura) || "".equals(janelas) || "".equals(portas)) {
            } else {
                Intent resultIntent = new Intent();
                Double vAltura = Double.valueOf(altura);
                Double vLargura = Double.valueOf(largura);
                Integer vJanelas = Integer.valueOf(janelas);
                Integer vPortas = Integer.valueOf(portas);

                Gson gson = new Gson();

                Wall wall = new Wall(vAltura, vLargura, vPortas, vJanelas);

                String gsonWall = gson.toJson(wall);

                this.mData.storieString("Wall_" + this.mData.getNumWalls(), gsonWall);
                this.mData.setNumWalls(String.valueOf(Integer.parseInt(this.mData.getNumWalls()) + 1));

                this.setResult(Activity.RESULT_OK, resultIntent);
                this.finish();
            }
        } else if (v.getId() == R.id.button_return) {

            Intent voltar = new Intent();
            this.setResult(Activity.RESULT_CANCELED, voltar);
            this.finish();
        }
    }

    private static class ViewHolder {

        TextView text_title;
        EditText edit_altura;
        EditText edit_largura;
        EditText edit_janelas;
        EditText edit_portas;
        Button button_add;
        Button button_return;
    }
}
