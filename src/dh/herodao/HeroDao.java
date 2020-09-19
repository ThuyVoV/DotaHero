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
//	String order = "DESC";
	
	public HeroDao() {
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
		
		String addQuery = "INSERT INTO " + "herolist(hero_name, atk_type, main_stats, "
				+ "base_hp, base_mp, base_atk, base_armor, base_ms, "
				+ "base_str, base_agi, base_int, gain_str, gain_agi, gain_int) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		
		ps = con.prepareStatement(addQuery);
		
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
	static String order = "DESC";
	public List<Hero> viewHero(String orderBy) {
		List<Hero> hl = new ArrayList<Hero>();
		String viewQuery = "SELECT * FROM herolist ORDER BY "+orderBy+" "+order;
//		String viewQuery = "SELECT * FROM herolist ORDER BY ? ?";
		
		
		if(order.equalsIgnoreCase("desc"))
			order = "ASC";
		else
			order = "DESC";
		
		System.out.println("\nthis is order:" + order);
		
		try{
			ps = con.prepareStatement(viewQuery);
//			ps.setString(1, orderBy);
//			ps.setString(2, "ASC");

			rs = ps.executeQuery();
			
			while (rs.next()) {
//				Hero hero = new Hero();
				
//				hero.setHeroName(rs.getString("hero_name"));
//				hero.setAtkType(rs.getString("atk_type"));
//				hero.setMainStats(rs.getString("main_stats"));
//				
//				System.out.println(hero.getHeroName()+" "+hero.getAtkType()+" "+hero.getMainStats());
				
				hl.add( new Hero( rs.getString("hero_name"), rs.getString("atk_type"), rs.getString("main_stats"), 
						Integer.parseInt(rs.getString("base_hp")), Integer.parseInt(rs.getString("base_mp")), 
						Integer.parseInt(rs.getString("base_atk")), Integer.parseInt(rs.getString("base_armor")), 
						Integer.parseInt(rs.getString("base_ms")), Integer.parseInt(rs.getString("base_str")), 
						Integer.parseInt(rs.getString("base_agi")), Integer.parseInt(rs.getString("base_int")), 
						Float.parseFloat(rs.getString("gain_str")), Float.parseFloat(rs.getString("gain_agi")),
						Float.parseFloat( rs.getString("gain_int"))));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return hl;
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
