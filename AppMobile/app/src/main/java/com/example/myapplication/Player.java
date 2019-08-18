package com.example.myapplication;

import com.owlike.genson.annotation.JsonProperty;

public class Player {
    @JsonProperty("id_player")
    private int id;
    @JsonProperty("ypos")// Android studio digère mal les _ donc je les map dans une écriture différente
    private int posY;
    @JsonProperty("xpos")//Forme exact du renvoie JSON
    private int posX;

    private int level;
    private int xp;
    @JsonProperty("pt_vie")
    private int vie;
    private String avatar;

    public Player() {
    }

    public Player(int id,  String avatar, int vie, int level, int xp, int posX, int posY) {
        this.id = id;
        this.avatar = avatar;
        this.vie = vie;
        this.level = level;
        this.xp = xp;
        this.posX = posX;
        this.posY = posY;
    }


    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getvie() {
        return vie;
    }

    public void setvie(int vie) {
        this.vie = vie;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getposX() {
        return posX;
    }

    public void setposX(int posX) {
        this.posX = posX;
    }

    public int getposY() {
        return posY;
    }

    public void setposY(int posY) {
        this.posY = posY;
    }

    @Override
    public String toString() {
        return ""+avatar + ", Vie : " +vie+", Level : "+level+", Experience : "+xp;
    }//C'est ce qui est renvoyé au niveau de la listview
}
