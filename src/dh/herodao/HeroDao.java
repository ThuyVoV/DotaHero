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

	String order;
	
	public HeroDao() {
		this.order = "DESC";
		
		//establish connection with JDBC
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/dotahero?serverTimezone=UTC";
			String uname="root";
			String pass="yogi420tea";
			
			con = DriverManager.getConnection(url,uname,pass);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addHero(Hero hero) throws ClassNotFoundException, SQLException{
		//query to add the hero in
		String addQuery = "INSERT INTO " + "herolist(hero_name, atk_type, main_stats, "
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
		

		
		
		if(!orderBy.equals("main_stats")) {
			String viewQuery = "SELECT * FROM herolist ORDER BY " + orderBy + " " + order;
			createList(hl, viewQuery);
		}
		else {
			String viewQuery = "SELECT * FROM herolist WHERE main_stats = " + "\"" + prevStats + "\"";
			createList(hl,viewQuery);
			rotateStats(hl, prevStats);
		}
			

		
		System.out.println("this is new order: " + order);
		System.out.println();
		
		//createList(hl, viewQuery);
		
//		try{
//			ps = con.prepareStatement(viewQuery);
//			rs = ps.executeQuery();
//			
//			while (rs.next()) {
//
//				
//				hl.add( new Hero( rs.getString("hero_name"), rs.getString("atk_type"), rs.getString("main_stats"), 
//						Integer.parseInt(rs.getString("base_hp")), Integer.parseInt(rs.getString("base_mp")), 
//						Integer.parseInt(rs.getString("base_atk")), Integer.parseInt(rs.getString("base_armor")), 
//						Integer.parseInt(rs.getString("base_ms")), Integer.parseInt(rs.getString("base_str")), 
//						Integer.parseInt(rs.getString("base_agi")), Integer.parseInt(rs.getString("base_int")), 
//						Float.parseFloat(rs.getString("gain_str")), Float.parseFloat(rs.getString("gain_agi")),
//						Float.parseFloat( rs.getString("gain_int"))));
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		return hl;
	}
	
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
	
	private void rotateStats(List<Hero> hl, String prevStats) {
		for(int i = 0; i < 2; i++) {
			if(prevStats.equals("Strength"))
				prevStats="Agility";
			else if (prevStats.equals("Agility"))
				prevStats= "Intelligent";
			else if(prevStats.equals("Intelligent"))
				prevStats= "Strength";
			
			String viewQuery = "SELECT * FROM herolist WHERE main_stats = " + "\"" + prevStats + "\"";
			
			createList(hl, viewQuery);
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
