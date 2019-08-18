package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.owlike.genson.Genson;
import com.owlike.genson.stream.ObjectReader;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConnectedActivity extends AppCompatActivity {
    private User user;
    private List<Player> players = new ArrayList<>();
    private TextView txtNom;
    private ListView lvPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent(); // Récupération des données utilisateurs
        setContentView(R.layout.activity_connected);
        lvPlayers = (ListView)findViewById(R.id.players);
        user = intent.getParcelableExtra("User");
        txtNom =  findViewById(R.id.nom);

        txtNom.setText("Bonjour "+user.getNom()+", Voici tes Héros :");//Message d'accueil personnalisé

        new Thread(new Runnable(){
            public void run(){
                Log.i("lo", String.valueOf(user.getId()));
                HttpURLConnection urlconnection = null;
                try{

                    String lien ="http://89.93.116.101:7070/api/user/getplayerbyiduser/"+user.getId();
                    Log.i("lo", lien);

                    URL url = new URL(lien);
                    urlconnection = (HttpURLConnection) url.openConnection();
                    urlconnection.setRequestMethod("GET");

                    final InputStream in = new BufferedInputStream(urlconnection.getInputStream());


                    Scanner scanner = new Scanner(in);
                    Genson genson = new Genson();
                    List<Object> temp = genson.deserialize(in,List.class);//Récupération des données Player provenant de l'API (il peut y avoir plus player pour un utilisateur

                    for (int i=0;i<temp.size();i++) {
                        String p = genson.serialize(temp.get(i));
                        players.add(genson.deserialize(p, Player.class));
                        Log.i("doc", players.get(i).getAvatar()); // création de La List de Player
                    }

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



                    }
                });





            }
        }).start();
        ArrayAdapter<Player> arrayAdapter //Injection dans la listView des données Players
                = new ArrayAdapter<Player>(this,android.R.layout.simple_list_item_1,players);
        lvPlayers.setAdapter(arrayAdapter);
    }


};



