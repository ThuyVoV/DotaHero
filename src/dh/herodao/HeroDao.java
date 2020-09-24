package dh.herodao;

import dh.hero.Hero;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDao {
	
	private Connection con = null;
	private PreparedStatement ps= null;
	private Statement st = null;
	private ResultSet rs = null;
	private String database = "dotahero";
	private String table = "herolist";

	String order;
	
	public HeroDao() {
		this.order = "DESC";
		
		//establish connection with JDBC
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/" + database + "?serverTimezone=UTC";
			String uname="root";
			String pass="yogi420tea";
			
			con = DriverManager.getConnection(url,uname,pass);
			
			checkDB();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addHero(Hero hero) throws ClassNotFoundException, SQLException{
		//query to add the hero in
		String addQuery = "INSERT INTO " + table + "(hero_name, atk_type, main_stats, "
				+ "base_hp, base_mp, base_atk, base_armor, base_ms, "
				+ "base_str, base_agi, base_int, gain_str, gain_agi, gain_int) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		
		ps = con.prepareStatement(addQuery);
		
		//replace each ? with its value
		ps.setString(1, hero.getHeroName());
		ps.setString(2, hero.getAtkType());
		ps.setString(3, hero.getMainStats());
		ps.setInt(4, hero.getBaseHP());
		ps.setInt(5, hero.getBaseMP());
		ps.setInt(6,hero.getBaseAtk());
		ps.setInt(7, hero.getBaseArmor());
		ps.setInt(8, hero.getBaseMS());
		ps.setInt(9, hero.getBaseStr());
		ps.setInt(10, hero.getBaseAgi());
		ps.setInt(11, hero.getBaseInt());
		ps.setFloat(12, hero.getGainStr());
		ps.setFloat(13, hero.getBaseAgi());
		ps.setFloat(14, hero.getGainInt());
		ps.executeUpdate();

		System.out.println("successful hero creation");
	}
	
	public void removeHero() {
	
	}
	
	public List<Hero> viewHero(String prevOrderBy, String prevStats, String orderBy) {

		System.out.println("this is prevorderby:" + prevOrderBy);
		System.out.println("this is orderBy: " + orderBy);
		System.out.println("this is order: " + order);
		
		List<Hero> hl = new ArrayList<Hero>();
		
		/*
		 * checks the last column it was sorted by, it is the same column
		 * switch order between ASC and DESC
		 * 
		 * if this is a new column, default to ASC
		 */
		if(orderBy.equals(prevOrderBy)) {
			if(order.equals("ASC"))
				order="DESC";
			else
				order="ASC";
		}
		else {

			order="ASC";
		}
		
		// main_stats has a different query from all the other columns
		if(!orderBy.equals("main_stats")) {
			String viewQuery = "SELECT * FROM " + table + " ORDER BY " + orderBy + " " + order;
			createList(hl, viewQuery);
		}
		else {
			/*
			 * this will call createList 3 times, once here and twice in rotateStats
			 * each time it is called it will grab all the heroes of a specific stats
			 */
			String viewQuery = "SELECT * FROM " + table + " WHERE main_stats = " + "\"" + prevStats + "\"";
			createList(hl,viewQuery);
			rotateStats(hl, prevStats);
		}
			

		
		System.out.println("this is new order: " + order);
		System.out.println();

		return hl;
	}
	
	//creates the list of heroes
	private void createList(List<Hero> hl, String viewQuery){
		
		try{
			ps = con.prepareStatement(viewQuery);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				hl.add( new Hero( rs.getString("hero_name"), rs.getString("atk_type"), rs.getString("main_stats"), 
						Integer.parseInt(rs.getString("base_hp")), Integer.parseInt(rs.getString("base_mp")), 
						Integer.parseInt(rs.getString("base_atk")), Integer.parseInt(rs.getString("base_armor")), 
						Integer.parseInt(rs.getString("base_ms")), Integer.parseInt(rs.getString("base_str")), 
						Integer.parseInt(rs.getString("base_agi")), Integer.parseInt(rs.getString("base_int")), 
						Float.parseFloat(rs.getString("gain_str")), Float.parseFloat(rs.getString("gain_agi")),
						Float.parseFloat( rs.getString("gain_int"))));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * since main_stats has 3 attribute with no specific comparision
	 * we just rotate through the stats
	 */
	private void rotateStats(List<Hero> hl, String prevStats) {
		for(int i = 0; i < 2; i++) {
			if(prevStats.equals("Strength"))
				prevStats="Agility";
			else if (prevStats.equals("Agility"))
				prevStats= "Intelligent";
			else if(prevStats.equals("Intelligent"))
				prevStats= "Strength";
			
			String viewQuery = "SELECT * FROM " + table + " WHERE main_stats = " + "\"" + prevStats + "\"";
			
			createList(hl, viewQuery);
		}
	}
	
	private void checkDB() {
		
		try {

//			rs = con.getMetaData().getCatalogs();
			
			DatabaseMetaData md = con.getMetaData();
			
			rs = md.getTables(null, null, table , null);
			if(rs.next()) {
				System.out.println("this table exists: " + table);
			}
			else {
				System.out.println("this table doesnt exist: " + table);
				String query = "create table " + table +"(id int AUTO_INCREMENT,"
						+ "hero_name varchar(30),"
						+ "atk_type varchar(10),"
						+ "main_stats varchar(15),"
						+ "base_hp int,"
						+ "base_mp int,"
						+ "base_atk int,"
						+ "base_armor int,"
						+ "base_ms int,"
						+ "base_str int,"
						+ "base_agi int,"
						+ "base_int int,"
						+ "gain_str DECIMAL(2,1),"
						+ "gain_agi DECIMAL(2,1),"
						+ "gain_int DECIMAL(2,1),"
						+ "PRIMARY KEY(id)"
						+ ")";
				
				st = con.createStatement();
				
				st.executeUpdate(query);
				System.out.println("table created: "+ table +"\n");
			}

			
//			while(rs.next()) {
//				
//				String DBname = rs.getString(1);
//				
//				System.out.println("hi in rs next");
//				System.out.println("DBname is: " + DBname);
//				System.out.println("rsstring is: " + rs.getString(3));
//				
//				if (DBname.equals(table)) {
//					System.out.println("this table exists: " + table);
//					exist = true;
//				}
//			}
//			
//			if(exist == false) {
//				String query = "create table " + table +"(id int AUTO_INCREMENT,"
//						+ "hero_name varchar(30),"
//						+ "atk_type varchar(10),"
//						+ "main_stats varchar(15),"
//						+ "base_hp int,"
//						+ "base_mp int,"
//						+ "base_atk int,"
//						+ "base_armor int,"
//						+ "base_ms int,"
//						+ "base_str int,"
//						+ "base_agi int,"
//						+ "base_int int,"
//						+ "gain_str DECIMAL(2,1),"
//						+ "gain_agi DECIMAL(2,1),"
//						+ "gain_int DECIMAL(2,1),"
//						+ "PRIMARY KEY(id)"
//						+ ")";
//				
//				st = con.createStatement();
//				
//				st.executeUpdate(query);
//			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	//closes connections
	public void close() {
		try {
			if(con!=null) con.close();
			
			if(ps!=null) ps.close();
			
			if(st!=null) st.close();
			
			if(rs!=null) rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
