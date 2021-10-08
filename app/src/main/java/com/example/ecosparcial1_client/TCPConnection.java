package com.example.ecosparcial1_client;

import android.util.Log;

import com.example.ecosparcial1_client.model.Bola;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TCPConnection extends Thread {

    private MainActivity mainA;
    private BufferedReader bfr;
    private BufferedWriter bfw;

    //singleton
   /* private static TCPConnection unicainstancia;

    public static TCPConnection getInstance() {

        if(unicainstancia == null) {

            unicainstancia = new TCPConnection();
            unicainstancia.start();
            Log.d("start", "hola");

        }
        return unicainstancia;
    }

    private TCPConnection(){



    }*/
    //singleton

    //globales
    private Socket socket;

    //lectura
    @Override
    public void run(){

        try {
            socket = new Socket("10.0.2.2", 9000);

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            bfr = new BufferedReader(new InputStreamReader(is));
            bfw = new BufferedWriter(new OutputStreamWriter(os));

            //lectura
            while(true) {

                String msg = bfr.readLine(); //para hasta que haya msg
                Log.d("Mensaje recibido: ", msg);

                //Gson gson = new Gson();

                String line = bfr.readLine();
                Log.e(">>>>", line);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sentMsg(String msg) {

        new Thread(

                () -> {
                    try {
                        bfw.write(msg + "\n");
                        bfw.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }).start();

    }


    public void Main (MainActivity main) {
        this.mainA = main;
    }

}
