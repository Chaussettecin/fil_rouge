package Serialization;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import UI.*; 
import terminalOverflow.*;
import maps.*;



public class Serialiser {
	

		   GsonBuilder builder = new GsonBuilder();
		
		   Gson gson = builder.create();
		   
	
			
		   public Serialiser(PlayScreen screen, String fichier) {
		
			Donnees toJson = new Donnees(screen); 
			System.out.println(gson.toJson(toJson)); 
			try {
				BufferedWriter sav = new BufferedWriter(new FileWriter(fichier));
				
				sav.write(gson.toJson(screen.j.position));
				
				sav.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		   }
			
		   public Serialiser(PlayScreen screen) {
			   
			   Donnees toJson = new Donnees(screen); 
			   System.out.println(gson.toJson(toJson)); 
			   try {
				   BufferedWriter sav = new BufferedWriter(new FileWriter("sav.json",true));
				   
				  //sav.write(gson.toJson(screen.j.position));
				  sav.write(gson.toJson(toJson)+"\n");
				   
				   sav.close();
			   } catch (IOException e) {
				   // TODO Auto-generated catch block
				   e.printStackTrace();
			   }
			   
			   
		   }
		   
		   
			
			
			

}
