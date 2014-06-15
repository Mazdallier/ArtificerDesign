package ad.Genis231.Player;

import net.minecraft.potion.Potion;

public enum PlayerRace {
	// ID,Potion1,level,Potion2,Level
	HUMAN("Human", 0, 0, 0, 0), //
	DWARF("Dwarf", 1, Potion.digSpeed.getId(), Potion.nightVision.getId(), 1), //
	ELF("Elf", 2, Potion.moveSpeed.getId(), Potion.waterBreathing.getId(), 1), //
	ORC("Orc", 3, Potion.damageBoost.getId(), Potion.fireResistance.getId(), 1); //
	
	private String name;
	private int id;
	private int Potion1;
	private int Potion2;
	private int Level;
	private static final PlayerRace[] RaceList = { HUMAN, DWARF, ELF, ORC };
	
	PlayerRace(String name, int id, int pot1, int pot2, int level) {
		this.name = name;
		this.id = id;
		this.Potion1 = pot1;
		this.Potion2 = pot2;
		this.Level = level;
	}
	
	public static PlayerRace getRace(int id) {
		return RaceList[id];
	}
	
	public String getName() {
		return name;
	}
	
	public int getID() {
		return id;
	}
	
	public int getPot1() {
		return this.Potion1;
	}
	
	public int getPot2() {
		return this.Potion2;
	}
	
	public int getLevel() {
		return this.Level;
	}
}
