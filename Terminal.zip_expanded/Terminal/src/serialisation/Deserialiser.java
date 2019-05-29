package serialisation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Screen.PlayScreen;
import terminalOverflow.Vector2d;

public class Deserialiser{
	   private GsonBuilder builder = new GsonBuilder();
	
	   private Gson gson = builder.setPrettyPrinting().create();
//	   private Vector2d vect =new Vector2d();
	   private Donnees donnees;
	   private ArrayList<Donnees> al = new ArrayList<>();	
	   public Deserialiser( String fichier) {
	
		   String json="";
		  
		 try{
			 InputStream flux=new FileInputStream("sav.json"); 
			 InputStreamReader lecture=new InputStreamReader(flux);
			 BufferedReader buff=new BufferedReader(lecture);
			 String ligne;
			 donnees=new Donnees();
			 int i=0;
			 while ((ligne=buff.readLine())!=null){
			 	//System.out.println(i+ligne);
			 	json+=ligne;
			 	//i++;
				donnees=gson.fromJson(ligne, Donnees.class);
			 	al.add(donnees);
			 }
			 buff.close(); 
			 }		
			 catch (Exception e){
			 System.out.println(e.toString());
			 }
		 	
		 	// donnees=gson.fromJson(json, Donnees.class);
		 
		 	 
	   }
	   
	   
	   	   
	  
	   
	   public Donnees getDonnees() {
		if (donnees!=null)
			return donnees;
		return null;
	}



	public void setDonnees(Donnees donnees) {
		this.donnees = donnees;
	}

	public ArrayList getListe() {
		return al;
	}

	public static void main(String[] args) {
		   new Deserialiser("testSav.json");
	   }
		
	   
}
