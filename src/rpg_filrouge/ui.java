package rpg_filrouge;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ui {


public static boolean uiDispo = true;
private static Scanner in = new Scanner(System.in);

  
public static boolean nbre(String string) {
    if (string == null) {
    	return false;
    }

    int taille = string.length();
    if (taille == 1) {
         return false;
     }

    int i = 0;
    if (string.charAt(0) == '-') {
        if (taille < 3) {
        	return false;
        }
        i = 1;
     }

    int numOfDot = 0;
    for (; i < taille; i++) {
       char c = string.charAt(i);
       if (c == '.')
    	   numOfDot++;
       else if (c == '/')
    	   return false;
       else if (c < '.' || c > '9') {
           return false;
       }
    }
    return (numOfDot == 1);
  }//fin classe nbre

 public static boolean isNb(String string) {
      
	 if (string == null) return false;
	 int taille = string.length();

     if (taille == 0) return false;
     int i = 0;

     if (string.charAt(0) == '-') {
    	 if (taille == 1) return false;
        	i = 1;
      }

      for (; i < taille; i++) {
    	  char c = string.charAt(i);
    	  if (c <= '/' || c >= ':') return false;
      }
      return true;
    } // fin isnbre
   
    public static void print(String input) {
        System.out.print(input);
    }

    public static void println(String input) {
        print(input + "\n");
    }

    public static void print(int input) {
        print(input + "");
    }

    public static void println(int input) {
        print(input + "\n");
    }

    public static void print(boolean input) {
        print(input + "");
    }

    public static void println(boolean input) {
        print(input + "\n");
    }

    public static void print(double input) {
        print(input + "");
    }

    public static void println(double input) {
        print(input + "\n");
    }

    public static void println() {
        print("\n");
    }

   //clear ecran
   public static void msg(String msg) {
      if (msg == null || msg.equals("")) {
           cls();
           pause();
      }
      cls();
      println(msg);
      pause();
   }
 
 //Erreur
  public static void popup(String body, String titre, int msgType) {
     if (uiDispo) {
        JOptionPane.showMessageDialog(null, body, titre, msgType);
     } else {
        msg(body);
     }
  }

    
  public static int popupConfirmation(String body, String titre) {
     if (uiDispo ) {
         return JOptionPane.showConfirmDialog(null, body, titre, JOptionPane.YES_NO_OPTION);
     } else {
     cls();
     println(body);
     println("(O/N)");
           
     Scanner in = new Scanner(System.in);

     while (!in.hasNextLine()) {
           in.nextLine();
     }

     String valide = in.nextLine();
           valide = valide.toUpperCase();
     if (valide.isEmpty()) {
        return 1;
     }
     char input = valide.charAt(0);
     cls();
     if (input == 'O') return 0;
     return 1;
    }//fin if
  }
   
 
//Clear ecran
 public static void cls() {
	 try {
        if (System.getProperty("os.name").contains("Windows"))
        	new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
        	Runtime.getRuntime().exec("clear");
      } catch (IOException | InterruptedException exception) {
      for (int i = 1; i < 50; i++)
         println("\n");
      }
  }

  public static int getValidInt() {
     while (!in.hasNextInt()) {
         in.nextLine();
     }
     return in.nextInt();
   }

   public static String getValidString() {
        in.reset();
        return in.next();
   }

    
 //Mettre en pause le jeux en appuyant sur entrée 
   public static void pause() {
	   
	   try {
    		Scanner pauseScan = new Scanner(System.in);
    		String temp = pauseScan.nextLine();
            println(temp);

	   } catch (Exception e) {
	   }	
   }

   	public static int confirmPopup(String string, String string2) {
	return 0;
   	}
}
