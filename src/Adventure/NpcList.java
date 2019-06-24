package Adventure;

import java.util.ArrayList;
import java.util.Random;

public class NpcList {

	 public Random rand = new Random();
	    
	 	ArrayList<String> humanMaleList = new ArrayList<>();
	    ArrayList<String> humanFemaleList = new ArrayList<>();
	    ArrayList<String> elfMaleList = new ArrayList<>();
	    ArrayList<String> elfFemaleList = new ArrayList<>();
	    ArrayList<String> nainMaleList = new ArrayList<>();
	    ArrayList<String> naineFemaleList = new ArrayList<>();
	    ArrayList<String> orcList = new ArrayList<>();

	   
	 public void createNameLists() {
	        
	     //- Humain liste PNJ--
	        humanMaleList.add("Galov");
	        humanMaleList.add("Senek");
	      
	     //-- Humaine liste PNJ
	        humanFemaleList.add("Taysa");
	        humanFemaleList.add("Ninel");
	       
	     //-- Elfe liste PNJ
	        elfMaleList.add("Kireth");
	        elfMaleList.add("Zelfin");
	       
	        
	     //-- Elfe girl liste PNJ
	        elfFemaleList.add("Ylwen");
	        elfFemaleList.add("Asaviel");
	        elfFemaleList.add("Indil");
	        //elfFemaleList.add("");
	        
	     //-- nain male non PNJ
	        nainMaleList.add("Xubrym");
	        nainMaleList.add("Hragnir");
	        nainMaleList.add("Krurin");
	       
	     //-- naine female names
	        nainMaleList.add("Xubi");
	        nainMaleList.add("Hirnhild");
	        //dwarfFemaleList.add("");
	       
	        //--  Orc nom png 
	        orcList.add("Balanwyr");
	        orcList.add("Tokugraw");
	        orcList.add("Gruudran");
	        //orcList.add("");
	       
	}


}
