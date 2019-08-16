package Shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Inventory.Item;
import Inventory.Sort;
import Inventory.Potion;
import Inventory.Armure;
import Inventory.ItemType;
import Inventory.ArmeItem;
import Inventory.ArmesMelees;
import Inventory.ArmesDistance;

import Util.JSON.Json;
import Util.JSON.JsonArray;
import Util.JSON.JsonObject;


//--- Boutique -
public class Shop {
	
	private List<Item> shopItems;
	private static String descArmDist;
	private static final String descArmMel = null;
	private static final String description = null;
	
	
//---  POTIONS / ARMES / ARMURES // SORTS  ---
	private static List<Sort> armeSortsItems = new ArrayList<>();
  	private static List<Armure> armureItems = new ArrayList<>();
  	private static List<Potion> potionItems = new ArrayList<>();
  	
	private static List<ArmesDistance> armeDistItems = new ArrayList<>();
	private static List<ArmesMelees> armeMelItems = new ArrayList<>();
  	private static HashMap<Integer, Item> allItemsById = new HashMap<>();
  
  	public Shop() {
      initItemList();
  	}
  
  	private void initItemList(){
      
	  Scanner scanner = new Scanner(getClass().getResourceAsStream("/Resources/Items.json"));
      scanner.useDelimiter("\\A");

      if (!scanner.hasNext()) {
          // 0 items
          return;
      }

      String jsonText = scanner.next();

      JsonArray items = (JsonArray) Json.parse(jsonText);

      for (int i = 0; i < items.size(); ++i) {
          
    	  JsonObject currentItemData = (JsonObject) items.get(i);

          String itemType = currentItemData.get("type").asString();
          int id = currentItemData.get("id").asInt();
          
          String nom = currentItemData.get("nom").asString();
          int prix = currentItemData.get("prix").asInt();

          Item actuelItem = null;
          boolean siArme = false;

          switch (itemType) {
          
              case "armeMelee": // Je ne comprend pas le probleme :s a voir
            	  actuelItem = new ArmesMelees(id, nom, prix, descArmMel);
            	  siArme = true;
                  break;
             
              case "armeDistance":
            	  actuelItem = new ArmesDistance(id, nom, prix, descArmDist, null);
            	  siArme = true;
                  break;
              
              case "potion":
            	  actuelItem = new Potion(id, nom, prix,description, null);
                  break;
          }

          if (siArme) {
              
        	  ArmeItem itemArme = (ArmeItem) actuelItem;
              JsonObject weaponData = currentItemData.get("armedata").asObject();
              //itemArme.setRequiredStrength(weaponData.get("requiredstrength").asInt());
              //itemArme.setRequiredDexterity(weaponData.get("requireddexterity").asInt());

              //actuelItem.add(itemArme);
          }
          else {
              potionItems.add((Potion) actuelItem);
          }

          allItemsById.put(id, actuelItem);
      }
  }

  public static Item getItemById(int id) { return allItemsById.get(id);}
  
/*
 * Montre les objets dans une liste --  
 */
  public static String showItemList(){
	  
      StringBuilder sb = new StringBuilder();
      
      sb.append("#### ARMES MELEES ####\n");
      
      for (int i = 0; i < armeMelItems.size(); i++) {
          sb.append(armeMelItems.get(i).toString()).append("\n");
      }
      
      sb.append("#### ARMES DISTANCES ####\n");
      
      for (int i = 0; i < armeDistItems.size(); i++) {
          sb.append(armeDistItems.get(i).toString()).append("\n");
      }
      
      sb.append("#### SORTS ####\n");
      
     /* for (int i = 0; i < Sort.; i++) {
          sb.append(Sort.get(i).toString()).append("\n");
      }*/
      
      sb.append("#### POTIONS ####\n");
      
      for (int i = 0; i < potionItems.size(); i++) {
          sb.append(potionItems.get(i).toString()).append("\n");
      }
      
      System.out.println(sb.toString());
	return descArmDist;
  } 
  
/*
 * Vente des objets => qui permet � l'equipe de se faire de l'argent 
 */
  public static void sellItem(Item item){
	  
      if ( item.getType() == ItemType.ARME_DISTANCE || 
   		   item.getType() == ItemType.ARME_MELEE ||
   		   item.getType() == ItemType.ARMURE || 
   		   item.getType() == ItemType.SORT){
    	  
          ArmeItem.remove((ArmeItem) item);
      
      } else if (item.getType() == ItemType.POTION ){
          potionItems.remove((Potion) item);
      
      }
      allItemsById.remove(item.getID(), item);
      
  }
  

  
//--- Achat des objets --- 
  public static void buyItem(Item item){
      
	  if ( item.getType() == ItemType.ARME_DISTANCE || 
		   item.getType() == ItemType.ARME_MELEE ||
		   item.getType() == ItemType.ARMURE || 
		   item.getType() == ItemType.SORT){
	   
          ArmeItem.add((ArmeItem)item);
          
      } else if (item.getType() == ItemType.POTION ){
          potionItems.add((Potion) item);
      
      }
      allItemsById.put(item.getID(), item); 
      
  }
  
//-- Sauvegarde en Json  des objets
  	public void saveToJSON(JsonObject json) { }

  	public static List<Sort> getArmeSortsItems() {return armeSortsItems;}

  	public static void setArmeSortsItems(List<Sort> armeSortsItems) {
	 Shop.armeSortsItems = armeSortsItems;
  	}

  	public static List<Armure> getArmureItems() {return armureItems;}
	
  	
  	public static void setArmureItems(List<Armure> armureItems) {
	  Shop.armureItems = armureItems;
  	}

  	public List<Item> getShopItems() { return shopItems; }

  	public void setShopItems(List<Item> shopItems) {
  		this.shopItems = shopItems;
  	}      
      

}
