package Serialization;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Deserialiser{
	   
	private GsonBuilder builder = new GsonBuilder();
	private Gson gson = builder.setPrettyPrinting().create();
	private Donnees donnees;
	private ArrayList<Donnees> al = new ArrayList<>();	
	  
	
	public Deserialiser( String fichier) {
	
		String json="";
		  
		 try {
			 
			 InputStream flux=new FileInputStream("sav.json"); 
			 InputStreamReader lecture=new InputStreamReader(flux);
			 BufferedReader buff=new BufferedReader(lecture);
			 String ligne;
			 donnees=new Donnees();
			 int i=0;
			 
			 while ((ligne=buff.readLine())!=null){

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
		 	
		 
	   }
	   
	  
	public Donnees getDonnees() {
		
		if (donnees!=null)
			return donnees;
		return null;
	}

	public void setDonnees(Donnees donnees) {
		this.donnees = donnees;
	}

	public ArrayList<Donnees> getListe() {
		return al;
	}

	/*public static void main(String[] args) {
		   new Deserialiser("testSav.json");
	   }*/
		   
}
