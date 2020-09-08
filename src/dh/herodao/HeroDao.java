package dh.herodao;

import dh.hero.Hero;
import java.sql.*;

public class HeroDao {
	
	public void addHero(Hero hero) throws ClassNotFoundException, SQLException{
		
		String query = "INSERT INTO testtable(name) VALUES(?);";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/dotahero?serverTimezone=UTC";
		String uname="root";
		String pass="yogi420tea";
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, hero.getHeroName());
		

	}
}
