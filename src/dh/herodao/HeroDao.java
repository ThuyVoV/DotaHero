package dh.herodao;

import dh.hero.Hero;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDao {
	
	Connection con = null;
	PreparedStatement ps= null;
	Statement st = null;
	
	public HeroDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/dotahero?serverTimezone=UTC";
			String uname="root";
			String pass="yogi420tea";
			
			con = DriverManager.getConnection(url,uname,pass);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addHero(Hero hero) throws ClassNotFoundException, SQLException{
		
		String query = "INSERT INTO "+ "herolist(hero_name, atk_type, main_stats, "
				+ "base_hp, base_mp, base_atk, base_armor, base_ms, "
				+ "base_str, base_agi, base_int, gain_str, gain_agi, gain_int) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		
	
		ps = con.prepareStatement(query);
		
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
		
		close();
	}
	
	public void removeHero() {
	
	}
	
	public List<Hero> viewHero() {
		List<Hero> hl = new ArrayList<Hero>();
		
		
		close();
		return hl;
		
	}
	
	//closes connections
	public void close() {
		
		try {
			if(con!=null)
				con.close();
			
			if(ps!=null)
				ps.close();
			
			if(st!=null)
				st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
