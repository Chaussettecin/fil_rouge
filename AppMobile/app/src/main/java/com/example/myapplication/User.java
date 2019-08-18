package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import com.owlike.genson.annotation.JsonProperty;

import java.io.Serializable;


public class User implements Parcelable {

    @JsonProperty("id_utilisateur")// Android studio digère mal les _ donc je les map dans une écriture différente
    private int id;
    private String login;
    private String nom;
    private String mail;
    private String mdp;
    private boolean manager;



    public User(int id,String nom, String mail, String login, String mdp, boolean manager){
        this.id=id;
        this.nom=nom;
        this.mail=mail;
        this.mdp=mdp;
        this.login=login;
        this.manager=manager;
    }
    public User(){

    }

    protected User(Parcel in) {
        id = in.readInt();
        login = in.readString();
        nom = in.readString();
        mail = in.readString();
        //mdp = in.readString();
        //manager = in.readByte() != 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override //Methode implementer par Parcelable
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public int getId() {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) { // Pour permettre de transmettre des infos de page en page
        parcel.writeInt(id);
        parcel.writeString(login);
        parcel.writeString(nom);
        parcel.writeString(mail);
    }
}