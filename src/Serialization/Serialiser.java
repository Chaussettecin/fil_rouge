package Serialization;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Main.PlayScreen; 

public class Serialiser {
	
	GsonBuilder builder = new GsonBuilder();
	Gson gson = builder.create();
		   
	
	public Serialiser(PlayScreen screen, String fichier) {
		
	Donnees toJson = new Donnees(screen); 
	System.out.println(gson.toJson(toJson)); 
			
		try {
			
			BufferedWriter sav = new BufferedWriter(new FileWriter(fichier));
				
			sav.write(gson.toJson(screen.persD.position));
			sav.close();
			
		} catch (IOException e) {
				e.printStackTrace();
		}
			
	}
			
	public Serialiser(PlayScreen screen) {
			   
		Donnees toJson = new Donnees(screen); 
		System.out.println(gson.toJson(toJson)); 
			   
		try {
				BufferedWriter sav = new BufferedWriter(new FileWriter("sav.json",true));
				   
				sav.write(gson.toJson(toJson)+"\n");
				sav.close();
	
		} catch (IOException e) {
				 
				   e.printStackTrace();
		}
			   		   
	}
		   
		 		
}
