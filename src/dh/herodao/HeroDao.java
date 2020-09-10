package dh.herodao;

import dh.hero.Hero;
import java.sql.*;

public class HeroDao {
	
	public void addHero(Hero hero) throws ClassNotFoundException, SQLException{
		
		String query = "INSERT INTO "+ "testtable(hero_name, atk_type, main_stats, "
				+ "base_hp, base_mp, base_atk, base_armor, base_ms, "
				+ "base_str, base_agi, base_int, gain_str, gain_agi, gain_int) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/dotahero?serverTimezone=UTC";
		String uname="root";
		String pass="yogi420tea";
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, hero.getHeroName());
		

	}
}
