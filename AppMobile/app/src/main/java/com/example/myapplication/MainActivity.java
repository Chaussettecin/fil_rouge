package com.example.myapplication;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.owlike.genson.Genson;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private TextView noexist;//Ce champ est visible que quand une erreur ce produit
    private EditText txtLogin;
    private EditText txtMdp;
    private Button btnConn;

    private User user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            //Recupère les variables dans la vue

        txtLogin =  findViewById(R.id.login);
        txtMdp =  findViewById(R.id.mdp);
        noexist = findViewById(R.id.noexist);
        btnConn = findViewById(R.id.btnConn);
        btnConn.setOnClickListener(btnConnListener);

    }

     private OnClickListener btnConnListener = new OnClickListener() {

         @Override
         public void onClick(View v) {
             final Intent connActivity = new Intent(MainActivity.this,ConnectedActivity.class);
             new Thread(new Runnable(){
                public void run(){
                    HttpURLConnection urlconnection = null;
                    try{

                        String lien ="http://89.93.116.101:7070/api/user/getbylogin/"+txtLogin.getText();


                        URL url = new URL(lien);
                        urlconnection = (HttpURLConnection) url.openConnection();
                        urlconnection.setRequestMethod("GET");

                        final InputStream in = new BufferedInputStream(urlconnection.getInputStream());


                        Scanner scanner = new Scanner(in);
                        // user=null;
                        user = new Genson().deserialize(scanner.nextLine(), User.class);

                        in.close();
                        }catch(Exception e){
                            Log.e("Exchange-JSON","Cannot found http server",e);

                        }finally{
                            if(urlconnection != null) urlconnection.disconnect();
                        }

                        Log.i("Exchange-JSON", "Result ==" +user);

                        runOnUiThread(new Runnable(){
                            @Override
                            public void run(){

                                //Verification que l'utilisateur et bien trouvé et que son mdp est correct sinon noexist s'affiche
                                if (user==null){
                                    noexist.setText("Utilisateur non inscris");
                                    noexist.setVisibility(View.VISIBLE);


                                }else if(user.getMdp().equals(String.valueOf(txtMdp.getText()))){//cast en string le mot de pass inscrit dans la page de connexion
                                    noexist.setVisibility(View.INVISIBLE);
                                    txtLogin.setText(user.getLogin());
                                    txtMdp.setText(user.getMdp());
                                    connActivity.putExtra("User",user);
                                    startActivity(connActivity);
                                }else{
                                    noexist.setText("Mauvais mot de Pass");
                                    noexist.setVisibility(View.VISIBLE);
                                }
                            }
                        });





                }
            }).start();

         }
     };

}

