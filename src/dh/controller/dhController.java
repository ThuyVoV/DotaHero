package dh.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dh.hero.Hero;
import dh.herodao.HeroDao;

/**
 * Servlet implementation class dhController
 */
@WebServlet("/dhController")
public class dhController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HeroDao heroDao = new HeroDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dhController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Hero hero = new Hero();
		
		hero.setHeroName(request.getParameter("heroName"));
		hero.setAtkType(request.getParameter("atkType"));
		hero.setMainStats(request.getParameter("mainStats"));
		
		hero.setBaseHP(Integer.parseInt(request.getParameter("baseHP")));
		hero.setBaseMP(Integer.parseInt(request.getParameter("baseMP")));
		hero.setBaseAtk(Integer.parseInt(request.getParameter("baseAtk")));
		hero.setBaseArmor(Integer.parseInt(request.getParameter("baseArmor")));
		hero.setBaseMS(Integer.parseInt(request.getParameter("baseMS")));
		hero.setBaseStr(Integer.parseInt(request.getParameter("baseStr")));
		hero.setBaseAgi(Integer.parseInt(request.getParameter("baseAgi")));
		hero.setBaseInt(Integer.parseInt(request.getParameter("baseInt")));
		
		hero.setGainStr(Float.parseFloat(request.getParameter("gainStr")));
		hero.setGainAgi(Float.parseFloat(request.getParameter("gainAgi")));
		hero.setGainInt(Float.parseFloat(request.getParameter("gainInt")));
		
//		try {
//			heroDao.addHero(hero);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		response.sendRedirect("addHero.jsp");
	}

}
