
import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class saveJeux {
	
	
	/// J'avais tenter de faire un mode sauvegarde pour le RPG envoyer à Simon

	private static DumperOptions options;
	private static File saveLocation;
	private static Map<String, Object> data;
	private static Representer representer;
	private static Scanner input;
	private static String path;
	private static Yaml yaml;

	public static void save() {
		path = saveJeux.class.getProtectionDomain().getCodeSource().getLocation().getPath() + ".TFsave";
		path = path.replace(".jar", "_" + joueurs.nom());
		path = path.replaceAll("%20", " ");

		setup();

		//sante
		set("joueurs.sante", joueurs_sante.get());
		set("joueurs.sante_max",joueurs_sante.getOutOf());
		set("joueurs.premiersSecours.Owns", equipement_premiersSecours.get());
		set("stats.premiersSecours.utiliser", equipement_premiersSecours.utiliser());
		set("joueurs.instaSante.possede", equipement_instaSante.get());
		set("stats.instaSante.utiliser",  equipement_instaSante.utiliser);
		set("stats.KO", joueurs_sante.KO());

		//Coins
		set("User.Balance", gold.get());
		set("Bank.Balance", banque.get());
		set("Casino.Winnings", casino.totalGoldrecup);
		set("Casino.Plays", casino.jeuxJouer);
		set("Achievements.Bought_Item", joueurs_mission.boughtItem);
		set("Stats.Money_Spent.Coins", stats.totalCoinsSpent);
		set("Stats.Money_Spent.Interest", stats.coinsSpentOnBankInterest);
		set("Stats.Money_Spent.Weapons", stats.coinsSpentOnWeapons);
		set("Stats.Money_Spent.Health", stats.coinsSpentOnHealth);
		set("Stats.Money_Spent.XP", stats.xpBought);
		set("Bank.Current_Loan.Balance", banque_prets.setPretenCourt());
		set("Bank.Current_Loan.Due", banque_prets.getGrossDue());

		//Xp
		set("User.XP.Level", Xp.getLevel());
		set("User.XP.Needed", Xp.getOutOf());
		set("User.XP.Amount", Xp.get());
		set("User.XP.Total", Xp.total);
		set("User.XP.battleXp", Xp.getBattleXp());

		//Potions
		set("stats.Potions.Survival.Used", Potion.spUsed);
		set("stats.Potions.Recovery.Used", Potion.rpUsed);
		set("User.Potions.Survival", Potion.get("sur"));
		set("User.Potions.Recovery", Potion.get("recovery"));

		//Setting
		set("settings.setting.getDif", setting.getDif());
		set("settings.setting.diffverouillee", setting.diffverouillee);
		set("settings.soluces.active", soluces.active());
		set("settings.soluces.bloquer", soluces.bloquer());
		set("settings.ui.uiDispo", ui.uiDispo);

		//Combats
		set("stats.Kills", stats.tuer);
		set("stats.Total_Kills", stats.totaltuer);
		set("stats.High_Score", stats.highScore);
		set("User.Weapons.Current", equipement_armes.arrayArmes.indexOf(equipement_armes.get()));


		for (int i = 0; i < equipement_armes.arrayArmes.size(); i++) {
			if (equipement_armes.arrayArmes.get(i).possede()) {
				set(("Joueurs.Armes." + i), true);
			} else {
				set(("joueurs.Armes." + i), false);
			}
			set(("joueurs.Armes.Muni." + i), equipement_armes.arrayArmes.get(i).getAmmo());
		}


		set("Joueurs.Pouvoir", equipement_pouvoirs.get());
		set("stats.Pouvoir_utiliser", equipement_pouvoirs.aUtiliser);
		set("stats.Total_degats", stats.totalDegats);
		set("stats.Bullets_Fired", stats.bulletsFired);
		set("stats.Bullets_Hit", stats.bulletsThatHit);

		List<Integer> ownedArmour = new ArrayList<>();

		for (int i = 0; i < Armour.getArmours().size(); i++)
			if (Armour.getArmours().get(i).isOwns())
				ownedArmour.add(i);
		set("User.Armour.Owns", ownedArmour);

		set("User.Armour.Current", Armour.get());

		//Enemy
		set("Battle.Current.Enemy", Enemy.arrayEnemy.indexOf(Enemy.get()));
		set("Battle.Current.Enemy_Health", Enemy.get().getHealth());
		set("Battle.Current.Enemy_Max_Health", Enemy.get().getHealthMax());
		set("Battle.Current.Enemy_First_Aid_Kit", Enemy.get().getFirstAidKit());

		//Achs
		set("Achievements.Money_Maker", Achievements.moneyMaker);
		set("Achievements.Enemy_Slayer", Achievements.enemySlayer);
		set("Achievements.First_Kill", Achievements.firstKill);
		set("Achievements.Time_For_An_Upgrade", Achievements.timeForAnUpgrade);

		List<String> enemiesKilled = new ArrayList<>();

		for (int i = 0; i < Enemy.arrayEnemy.size(); i++)
			if (Achievements.arrayKilled.get(i))
				enemiesKilled.add(Enemy.arrayEnemy.get(i).getName());
		set("Achievements.Enemies_Killed", enemiesKilled);
		set("Achievements.Text_Fighter_Master", Achievements.textFighterMaster);
		set("Achievements.YAY_POWER", Achievements.YAYPOWER);
		set("Achievements.Aww_You_Care_About_Me", Achievements.awwYouCareAboutMe);
		set("Achievements.Slayer", Achievements.slayer);
		set("Achievements.Nobodys_Perfect", Achievements.nobodysPerfect);
		set("Achievements.Making_Money", Achievements.makingMoney);
		set("Achievements.Gambling_Addiction", Achievements.gamblingAddiction);
		set("Achievements.Level_2_Fighter", Achievements.level2Fighter);
		set("Achievements.Level_3_Fighter", Achievements.level3Fighter);
		set("Achievements.Level_4_Fighter", Achievements.level4Fighter);
		set("Achievements.Level_5_Fighter", Achievements.level5Fighter);
		set("Achievements.Level_6_Fighter", Achievements.level6Fighter);
		set("Achievements.Level_7_Fighter", Achievements.level7Fighter);
		set("Achievements.Level_8_Fighter", Achievements.level8Fighter);
		set("Achievements.Level_9_Fighter", Achievements.level9Fighter);
		set("Achievements.Level_10_Fighter", Achievements.level10Fighter);
		set("Achievements.Honest_Player", Achievements.honestPlayer);

		//Autres
		set("stats.Times_Cheated", stats.timesCheated);
		set("stats.Times_Quit", stats.timesQuit);
		set("stats.Items_Crafted", stats.timesCheated);
		set("stats.Games_Played.Dice", stats.jeuxdedesJouer);
		set("stats.Games_Played.Slots", stats.jeuxSlotJouer);

		try {
			if (!saveLocation.exists())
				saveLocation.createNewFile();

			FileWriter writer = new FileWriter(saveLocation);

			writer.write(yaml.dump(data));
			writer.flush();
			writer.close();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	public static boolean load() {
		setup();

		FileReader reader = read(saveLocation);

		if (reader == null) {
			ui.cls();
			ui.println("------------------------------");
			ui.println("Pas de fichier de sauvegarde.  ");
			ui.println("Commencement d'une nouvelle partie");
			ui.println("------------------------------");
			ui.pause();
			
			data = Collections.synchronizedMap(new LinkedHashMap<String, Object>());
			return true;
		}

		data = Collections.synchronizedMap((Map<String, Object>) yaml.load(reader));

		//sante
		joueurs_sante.set(getInteger("joueurs_sante"), getInteger("joueurs_sante"));
		equipement_premiersSecours.set(getInteger("joueurs_sante.FirstAid.Owns"), false);
		equipement_premiersSecours.utiliser = getInteger("stats.FirstAid.Used");
		equipement_instaSante.set(getInteger("joueurs_sante.InstaHealth.Owns"), false);
		equipement_instaSante.utiliser = getInteger("stats.InstaHealth.Used");
		joueurs_sante.nbXKO = getInteger("stats.TimesDied");

		//Gold
		gold.set(getInteger("joueurs.Balance"), false);
		banque.set(getInteger("banque.Balance"), false);
		casino.totalGoldrecup = getInteger("casino.Winnings");
		casino.jeuxJouer = getInteger("casino.Plays");
		joueurs_mission.achatObjets = getBoolean("joueurs_mission.achatObjets");
		stats.totalGoldDepenser = getInteger("stats.totalGoldDepenser.gold");
		stats.golddepenserInteret = getInteger("stats.golddepenserInteret.Interest");
		stats.totalGoldepenserprArmes = getInteger("stats.totalGoldepenserprArmes.Weapons");
		stats.totalGoldepenserprSante = getInteger("stats.totalGoldepenserprSante.Health");
		stats.xpAchetes = getInteger("Stats.Money_Spent.XP");
		banque_prets.setPretenCourt(getInteger("banque.PretenCourt.Balance"));
		banque_prets.setCredit(getInteger("banque.PretenCourt.Due"));

		//Xp
		joueurs_xp.setLevel(getInteger("joueurs_xp.Level"));
		joueurs_xp.setOutOf(getInteger("joueurs_xp.Needed"));
		joueurs_xp.set(getInteger("joueurs_xp.Amount"), false);
		joueurs_xp.totale = getInteger("joueurs_xp.totale");
		joueurs_xp.setCombatXp(getInteger("joueurs_xp.CombatXP"), false);

		//Potions
		equipement_potion.svUtiliser= getInteger("stats.Potions.Survival.Used");
		equipement_potion.restoUtiliser = getInteger("stats.Potions.Recovery.Used");
		equipement_potion.set("Survie", getInteger("joueurs.Potions.Survival"), false);
		equipement_potion.set("Restauration", getInteger("joueurs.Potions.Recovery"), false);

		//Settings
		setting.setDif(getString("setting.Difficulty.Level"), false, false);
		setting.diffverouillee= getBoolean("setting.diffverouillee");
		if(getBoolean("setting.soluces.active")) soluces.active();
		if(getBoolean("setting.soluces.bloquee")) soluces.bloquee();
		ui.uiDispo = getBoolean("setting.uiDispo");

		//Combat
		stats.tuer = getInteger("stats.tuer");
		stats.highScore = getInteger("stats.highScore");
		stats.totaltuer = getInteger("stats.totaltuer");
		equipement_armes.set(getInteger("joueurs.Weapons.Current"));

		for(int i = 0; i < equipement_armes.arrayArmes.size(); i++){
			if (getBoolean("User.Weapons." + i)){
				equipement_armes.arrayArmes.get(i).possede = true;
			}
			equipement_armes.arrayArmes.get(i).setAmmo(getInteger("joueurs.Weapons.Ammo." + i), false);
		}

		equipement_pouvoirs.set(getInteger("User.Power"), false);
		equipement_pouvoirs.aUtiliser= getInteger("Stats.Power.Used");
		equipement_pouvoirs.totalDamageDealt = getInteger("Stats.Damage_Dealt");
		equipement_pouvoirs.bulletsFired = getInteger("Stats.Bullets_Fired");
		equipement_pouvoirs.bulletsThatHit = getInteger("Stats.Bullets_Hit");

		List<Integer> armours = (List<Integer>) getList("User.Armour.Owns");

		for(int i = 0; i < armours.size(); i++)
			equipement_armure.getarmures().get(i).setPossede(true);

		equipement_armure.set(getInteger("User.Armour.Current"));

		//Ennemies
		joueurs_ennemis.set(getInteger("Battle.Current.Enemy"));
		joueurs_ennemis.get().setSante(getInteger("Battle.Current.Enemy_Health"), getInteger("Battle.Current.Enemy_Max_Health"));
		joueurs_ennemis.get().setpremierSoin(getInteger("Battle.Current.Enemy_First_Aid_Kit"));

		//Achs
		joueurs_mission.faiseurdArgent       = getBoolean("joueurs_mission.faiseurdArgent");
		joueurs_mission.leTueur        = getBoolean("joueurs_mission.leTueur");
		joueurs_mission.premierTue         = getBoolean("joueurs_mission.premierTue");
		joueurs_mission.timeForAnUpgrade   = getBoolean("joueurs_mission.Time_For_An_Upgrade");

		List<String> achSet = (List<String>) getList("joueurs_missions.Enemies_Killed");

		for (int i = 0; i < achSet.size(); i++){
			for (int x = 0; x < joueurs_ennemis.arrayEnemies.size(); x++){
				if(joueurs_ennemis.arrayEnemies.get(x).getNom().equals(achSet.get(i))){
					Achievements.arrayKilled.set(x, true);
				}
			}
		}
		joueurs_mission.textFighterMaster 	= getBoolean("Achievements.Text_Fighter_Master");
		joueurs_mission.YAYYAY           	= getBoolean("joueurs_mission.YAYYAY ");
		joueurs_mission.ohohTumedefis  		= getBoolean("joueurs_mission.ohohTumedefis");
		joueurs_mission.leTueur             = getBoolean("joueurs_mission.leTueur");
		joueurs_mission.personnenestParfait = getBoolean("joueurs_mission.personnenestParfait");
		joueurs_mission.faiseurdArgent     = getBoolean("joueurs_mission.faiseurdArgent");
		joueurs_mission.accroJeux  		   = getBoolean("joueurs_mission.accroJeux");
		joueurs_mission.level2Victoire     = getBoolean("joueurs_mission.level2Victoire");
		joueurs_mission.level3Victoire     = getBoolean("joueurs_mission.level3Victoire ");
		joueurs_mission.level4Victoire     = getBoolean("joueurs_mission.level4Victoire");
		joueurs_mission.level5Victoire     = getBoolean("joueurs_mission.level5Victoire");
		joueurs_mission.level6Victoire     = getBoolean("joueurs_mission.level6Victoire");
		joueurs_mission.level7Victoire     = getBoolean("joueurs_mission.level7Victoire");
		joueurs_mission.level8Victoire     = getBoolean("joueurs_mission.level8Victoire");
		joueurs_mission.level9Victoire     = getBoolean("joueurs_mission.level9Victoire");
		joueurs_mission.level10Victoire    = getBoolean("joueurs_mission.level10Victoire");
		joueurs_mission.JoueurHonnete      = getBoolean("joueurs_mission.JoueurHonnete ");

		//Divers
		stats.timesCheated = getInteger("stats.Times_Cheated");
		stats.timesQuit = getInteger("stats.Times_Quit");
		stats.itemsCrafted = getInteger("stats.Items_Crafted");
		stats.jeuxdedesJouer = getInteger("stats.Games_Played.Dice");
		stats.jeuxSlotJouer = getInteger("stats.Games_Played.Slots");

		return true;
	}

	private static void setup() {
		saveLocation = new File(path);

		if (!saveLocation.exists())
			try {
				saveLocation.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}

		setupDumper();

		yaml = new Yaml(representer, options);
		data = Collections.synchronizedMap(new LinkedHashMap<String, Object>());
	}

	private static void setupDumper() {
		options = new DumperOptions();
		representer = new Representer();

		options.setIndent(2);
		options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
		options.setAllowUnicode(Charset.defaultCharset().name().contains("UTF"));
		representer.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
	}

	public static boolean savesPrompt() {
		joueurs.nomSelection();
		path = saveJeux.class.getProtectionDomain().getCodeSource().getLocation().getPath() + ".TFsave";
		path = path.replace(".jar", "_" + joueurs.nom());
		path = path.replaceAll("%20", " ");

		ui.cls();
		ui.println("------------------------------");
		ui.println("Que veux'tu faire ?");
		ui.println("------------------------------");
		ui.println("1) Lancer une sauvegarde");
		ui.println("2) Reprendre une ancienne sauvegarde");
		ui.println("3) Sortie");

		switch (ui.getValidInt()) {
			case 1:
				load();
				break;
			case 2:
				convert();
				break;
			default:
				return false;
		}
		return true;
	}

	public static boolean convert() {
		ui.cls();
		ui.println("------------------------------------");
		ui.println("ATTENTION ");
		ui.println("");
		ui.println("Il est recomandé de faire des ");
		ui.println("sauvegardes de ta partie en court");
		ui.println("avant de continuer.");
		ui.println("------------------------------------");
		ui.println("1) Sortie");
		ui.println("2) Continuer");

		switch(ui.getValidInt()){
			case 1:
				return false;
			case 2:
				break;
			default:
				return false;
		}

		try {
			File file = new File(path);

			if (!file.exists()) {
				ui.println("Fichier non trouver. S'il te plait mets un \"_\" avant ton pseudo..");
				System.exit(0); 
			}

			input = new Scanner(file);

			setup();
			readString();

			//sante
			joueurs_sante.set(readInt(), readInt());
			equipement_premiersSecours.set(readInt(), false);
			equipement_premiersSecours.utiliser = readInt();
			equipement_instaSante.set(readInt(), false);
			equipement_instaSante.utiliser = readInt();
			joueurs_sante.nbXKO = readInt();

			//Money Argent
			gold.set(readInt(), false);
			banque.set(readInt(), false);
			casino.totalGoldrecup = readInt();
			casino.jeuxJouer = readInt();
			joueurs_mission.achatObjets = readBoolean();
			stats.totalGoldDepenser = readInt();
			stats.golddepenserInteret = readInt();
			stats.totalGoldepenserprArmes = readInt();
			stats.totalGoldepenserprSante = readInt();
			stats.xpAchetes = readInt();
			banque_prets.setCurrentLoan(readInt());
			banque_prets.setNetDue(readInt());

			//Xp
			joueurs_xp.setLevel(readInt());
			joueurs_xp.setOutOf(readInt());
			joueurs_xp.set(readInt(), false);
			joueurs_xp.total = readInt();
			joueurs_xp.setBattleXp(readInt(), false);

			//Potions
			equipement_potion.svUtiliser = readInt();
			equipement_potion.restoUtiliser= readInt();
			equipement_potion.set("Survie", readInt(), false);
			equipement_potion.set("Restauration", readInt(), false);


			//réglage
			setting.setDif(input.nextLine(), false, false);
			if (readBoolean()) soluces.activer();
			if (readBoolean()) soluces.bloquee();
			//setting.getDif() = readBoolean();
			ui.uiDispo = readBoolean();

			//Combats
			stats.kills = readInt();
			stats.highScore = readInt();
			stats.totalKills = readInt();
			equipement_armes.set(readInt());
			for (int i = 0; i < equipement_armes.arrayWeapon.size(); i++)
				equipement_armes.arrayWeapon.get(i).owns = readBoolean();
			for (int i = 0; i < equipement_armes.arrayWeapon.size(); i++)
				equipement_armes.arrayWeapon.get(i).setAmmo(readInt(), false);
			equipement_pouvoirs.set(readInt(), false);
			equipement_pouvoirs.used = readInt();
			stats.totalDamageDealt = readInt();
			stats.bulletsFired = readInt();
			stats.bulletsThatHit = readInt();
			for (int i = 0; i < Armour.getArmours().size(); i++)
				Armour.getArmours().get(i).setOwns(readBoolean());
			Armour.set(readInt());

			//Ennemis
			joueurs_ennemis.set(readInt());
			joueurs_ennemis.get().setHealth(readInt(),joueurs_ennemis.get().getHealthMax());

			//Missions
			joueurs_mission.moneyMaker = readBoolean();
			joueurs_mission.enemySlayer = readBoolean();
			joueurs_mission.firstKill = readBoolean();
			joueurs_mission.timeForAnUpgrade = readBoolean();
			for (int i = 0; i < Enemy.arrayEnemy.size(); i++)
			joueurs_mission.arrayKilled.set(i, readBoolean());
			joueurs_mission.textFighterMaster = readBoolean();
			joueurs_mission.YAYPOWER = readBoolean();
			joueurs_mission.awwYouCareAboutMe = readBoolean();
			joueurs_mission.slayer = readBoolean();
			joueurs_mission.nobodysPerfect = readBoolean();
			joueurs_mission.makingMoney = readBoolean();
			joueurs_mission.gamblingAddiction = readBoolean();
			joueurs_mission.level2Fighter = readBoolean();
			joueurs_mission.level3Fighter = readBoolean();
			joueurs_mission.level4Fighter = readBoolean();
			joueurs_mission.level5Fighter = readBoolean();
			joueurs_mission.level6Fighter = readBoolean();
			joueurs_mission.level7Fighter = readBoolean();
			joueurs_mission.level8Fighter = readBoolean();
			joueurs_mission.level9Fighter = readBoolean();
			joueurs_mission.level10Fighter = readBoolean();
			joueurs_mission.honestPlayer = readBoolean();

			//Autres
			stats.timesCheated = readInt();
			stats.timesQuit = readInt();
			stats.itemsCrafted = readInt();
			stats.jeuxdedesJouer = readInt();
			stats.jeuxSlotJouer = readInt();

			save();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return true;
	}

	public static boolean contains(String key) {
		return data.containsKey(key);
	}

	public static boolean exists() {
		return data != null;
	}

	public static boolean getBoolean(String key) {
		Object tempObject = get(key);

		if (tempObject instanceof Boolean)
			return (Boolean) tempObject;
		if (tempObject instanceof String)
			if (tempObject.toString().equalsIgnoreCase("true") || tempObject.toString().equalsIgnoreCase("1"))
				return true;
			else if (tempObject.toString().equalsIgnoreCase("false") || tempObject.toString().equalsIgnoreCase("0"))
				return false;
		if (tempObject instanceof Number)
			if (((Number) tempObject).intValue() == 1)
				return true;
			else if (((Number) tempObject).intValue() == 0)
				return false;
		return false;
	}

	public static boolean hasValue(String key) {
		Object tempObject = data.get(key);

		return (tempObject != null);
	}

	public static boolean isEmpty() {
		return data.isEmpty() || data == null;
	}

	public static byte getByte(String key) {
		Object tempObject = get(key);

		if (tempObject instanceof Byte)
			return (Byte) tempObject;
		if (tempObject instanceof String)
			if (ui.isNb(tempObject.toString()))
				return Byte.parseByte(tempObject.toString());
		if (tempObject instanceof Number)
			return Byte.parseByte(tempObject.toString());
		return -1;
	}

	public static char getChar(String key) {
		Object tempObject = get(key);

		if (tempObject instanceof Character)
			return (Character) tempObject;
		if (tempObject instanceof String)
			return tempObject.toString().charAt(0);
		if (tempObject instanceof Number)
			return tempObject.toString().charAt(0);
		return '\u0000';
	}

	public static double getDouble(String key) {
		Object tempObject = get(key);

		if (tempObject instanceof Double)
			return (Double) tempObject;
		if (tempObject instanceof String)
			if (ui.nbre(tempObject.toString()))
				return Double.parseDouble(tempObject.toString());
		if (tempObject instanceof Number)
			return Double.parseDouble(tempObject.toString());
		return -1;
	}

	public static int getInteger(String key) {
		Object tempObject = get(key);

		if (tempObject instanceof Integer)
			return (Integer) tempObject;
		if (tempObject instanceof String)
			if (ui.isNb(tempObject.toString()))
				return Integer.parseInt(tempObject.toString());
		if (tempObject instanceof Number)
			return Integer.parseInt(tempObject.toString());
		return -1;
	}

	public static List<?> getList(String key) {
		Object tempObject = get(key);

		if (tempObject instanceof List<?>)
			return (List) tempObject;
		return null;
	}

	public static long getLong(String key) {
		Object tempObject = get(key);

		if (tempObject instanceof Long)
			return (Long) tempObject;
		if (tempObject instanceof String)
			if (ui.isNb(tempObject.toString()))
				return Long.parseLong(tempObject.toString());
		if (tempObject instanceof Number)
			return Long.parseLong(tempObject.toString());
		return -1;
	}

	public static Map<?, ?> getMap(String key) {
		Object tempObject = get(key);

		if (tempObject instanceof Map<?, ?>)
			return (Map) tempObject;
		return null;
	}

	public static Map<String, Object> getValues() {
		if (!isEmpty())
			return data;
		return null;
	}

	public static Object get(String key) {
		if (isEmpty())
			return null;

		final String[] nodes = key.split("\\.");
		Map curMap = data;

		for (int i = 0; i <= nodes.length - 1; ++i) {
			Object child = curMap.get(nodes[i]);

			if (child == null) return null;
			else if (!(child instanceof Map)) {
				if (i == nodes.length - 1)
					return child;
				else return null;
			}

			curMap = (Map) child;
		}
		return null;
	}

	public static Set<String> getKeys() {
		if (!isEmpty())
			return data.keySet();
		return new HashSet<>();
	}

	public static short getShort(String key) {
		Object tempObject = get(key);

		if (tempObject instanceof Short)
			return (Short) tempObject;
		if (tempObject instanceof String)
			if (ui.isNb(tempObject.toString()))
				return Short.parseShort(tempObject.toString());
		if (tempObject instanceof Number)
			return Short.parseShort(tempObject.toString());
		return -1;
	}

	public static String getString(String key) {
		Object tempObject = get(key);

		if (tempObject instanceof String)
			return (String) tempObject;
		return null;
	}

	public static FileReader read(File file) {
		try {
			if (!file.exists())
				return null;
			return new FileReader(file);
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		return null;
	}

	/**
	 *
	 * @return next ligne = integer
	 */
	private static int readInt(){
		return Integer.parseInt(input.nextLine());
	}

	/**
	 *
	 * @return boolean
	 */
	private static boolean readBoolean(){
		return Boolean.parseBoolean(input.nextLine());
	}

	/**
	 *
	 * @return the next line as a String
	 */
	private static String readString(){
		return input.nextLine();
	}

  
    public static void set(String key, Object object) {

        if (!exists())
            return;

        final String[] nodes = key.split("\\.");

		Map<String, Object> cur = data;

        for (int i = 0; i <= nodes.length - 2; ++i) {
            Object val = cur.get(nodes[i]);
            if (val == null) {
                val = new LinkedHashMap();
                cur.put(nodes[i], val);
            } else if (!(val instanceof Map)) {
                support.error("Il y a un probleme de sauvegarde avec ta partie.");
            }
			cur = (Map<String, Object>) val;
		}
        cur.put(nodes[nodes.length - 1], object);
    }

}
