package dh.hero;

public class Hero {
	/*
	 create table herolist(
		id int AUTO_INCREMENT,
	    hero_name varchar(30),
	    atk_type varchar(10),
	    main_stats varchar(15),
	    base_hp int,
	    base_mp int,
	    base_atk int,
	    base_armor int,
	    base_ms int,
	    base_str int,
	    base_agi int,
	    base_int int,
	    gain_str DECIMAL(2,1),
	    gain_agi DECIMAL(2,1),
	    gain_int DECIMAL(2,1),
	    PRIMARY KEY(id)
	);
	 */
	
	private String heroName;
	private String atkType;
	private String mainStats;
	private int baseHP;
	private int baseMP;
	private int baseAtk;
	private int baseArmor;
	private int baseMS;
	private int baseStr;
	private float gainStr;
	private int baseAgi;
	private float gainAgi;
	private int baseInt;
	private float gainInt;
	
	public Hero() {}
	
	public Hero(String heroName, String atkType, String mainStats, int baseHP, int baseMP, int baseAtk, int baseArmor,
			int baseMS, int baseStr, float gainStr, int baseAgi, float gainAgi, int baseInt, float gainInt) {

		this.heroName = heroName;
		this.atkType = atkType;
		this.mainStats = mainStats;
		this.baseHP = baseHP;
		this.baseMP = baseMP;
		this.baseAtk = baseAtk;
		this.baseArmor = baseArmor;
		this.baseMS = baseMS;
		this.baseStr = baseStr;
		this.gainStr = gainStr;
		this.baseAgi = baseAgi;
		this.gainAgi = gainAgi;
		this.baseInt = baseInt;
		this.gainInt = gainInt;
	}
	
	public String getHeroName() {
		return heroName;
	}
	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	public String getAtkType() {
		return atkType;
	}
	public void setAtkType(String atkType) {
		this.atkType = atkType;
	}
	public String getMainStats() {
		return mainStats;
	}
	public void setMainStats(String mainStats) {
		this.mainStats = mainStats;
	}
	public int getBaseHP() {
		return baseHP;
	}
	public void setBaseHP(int baseHP) {
		this.baseHP = baseHP;
	}
	public int getBaseMP() {
		return baseMP;
	}
	public void setBaseMP(int baseMP) {
		this.baseMP = baseMP;
	}
	public int getBaseAtk() {
		return baseAtk;
	}
	public void setBaseAtk(int baseAtk) {
		this.baseAtk = baseAtk;
	}
	public int getBaseArmor() {
		return baseArmor;
	}
	public void setBaseArmor(int baseArmor) {
		this.baseArmor = baseArmor;
	}
	public int getBaseMS() {
		return baseMS;
	}
	public void setBaseMS(int baseMS) {
		this.baseMS = baseMS;
	}
	public int getBaseStr() {
		return baseStr;
	}
	public void setBaseStr(int baseStr) {
		this.baseStr = baseStr;
	}
	public float getGainStr() {
		return gainStr;
	}
	public void setGainStr(float gainStr) {
		this.gainStr = gainStr;
	}
	public int getBaseAgi() {
		return baseAgi;
	}
	public void setBaseAgi(int baseAgi) {
		this.baseAgi = baseAgi;
	}
	public float getGainAgi() {
		return gainAgi;
	}
	public void setGainAgi(float gainAgi) {
		this.gainAgi = gainAgi;
	}
	public int getBaseInt() {
		return baseInt;
	}
	public void setBaseInt(int baseInt) {
		this.baseInt = baseInt;
	}
	public float getGainInt() {
		return gainInt;
	}
	public void setGainInt(float gainInt) {
		this.gainInt = gainInt;
	}

	
	
}
