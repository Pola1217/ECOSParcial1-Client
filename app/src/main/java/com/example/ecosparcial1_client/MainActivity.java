package com.example.ecosparcial1_client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ecosparcial1_client.model.Bola;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BufferedReader bfr;
    private BufferedWriter bfw;
    private EditText groupTxt, cantTxt, posXtxt, posYtxt;

    private Button crearBtn, clearBtn;
    private Button purpleBtn, pinkBtn, tealBtn;

    private int posX, posY, cant, r, g,b;
    private boolean crear, borrar;

    String datos;


    //TCP
    private TCPConnection tcp = new TCPConnection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        groupTxt = findViewById(R.id.nameTxt);
        cantTxt = findViewById(R.id.cantTxt);
        posXtxt = findViewById(R.id.posxTxt);
        posYtxt = findViewById(R.id.posyTxt);
        //acciones
        crearBtn = findViewById(R.id.crearBtn);
        clearBtn = findViewById(R.id.clearBtn);
        //colores
        purpleBtn = findViewById(R.id.purpleBtn);
        pinkBtn = findViewById(R.id.pinkBtn);
        tealBtn = findViewById(R.id.tealBtn);

        //botones
        //colores importancia
        purpleBtn.setOnClickListener(this);
        pinkBtn.setOnClickListener(this);
        tealBtn.setOnClickListener(this);

        //acciones
        crearBtn.setOnClickListener(this);
        clearBtn.setOnClickListener(this);

        tcp.Main(this);
        tcp.start();

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){

            case R.id.purpleBtn:

                r = 136;
                g = 55;
                b = 177;
                Toast.makeText(this, "violet", Toast.LENGTH_LONG).show();

                break;

            case R.id.pinkBtn:

                r = 236;
                g = 63;
                b = 167;
                Toast.makeText(this, "rosa", Toast.LENGTH_LONG).show();

                break;

            case R.id.tealBtn:

                r = 39;
                g = 214;
                b = 190;
                Toast.makeText(this, "teal", Toast.LENGTH_LONG).show();

                break;

            case R.id.crearBtn:

                crear = true;
                borrar = false;

                //pasa int a string
                posX = Integer.parseInt(posXtxt.getText().toString());
                posY = Integer.parseInt(posYtxt.getText().toString());

                //nombre del grupo
                datos = groupTxt.getText().toString();

                //cantidad de bolas
                cant = Integer.parseInt(cantTxt.getText().toString());

                json();

                Toast.makeText(this, "crear", Toast.LENGTH_LONG).show();

                break;

            case R.id.clearBtn:

                crear = false;
                borrar = true;

                json();

                Toast.makeText(this, "borrado", Toast.LENGTH_LONG).show();

                break;

        }

    }

    public void json() {

        Gson gson = new Gson();
        Bola bola = new Bola(posX, posY, r, g, b, datos, crear, borrar, cant);

        String msgs = gson.toJson(bola);
        tcp.sentMsg(msgs);

    }

}