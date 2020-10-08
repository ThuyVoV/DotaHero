package dh.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dh.hero.Hero;
import dh.herodao.HeroDao;

/**
 * Servlet implementation class UpdateHeroController
 */
@WebServlet("/UpdateHero")
public class UpdateHeroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HeroDao heroDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateHeroController() {
        super();
        heroDao = new HeroDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.getWriter().append(" in controller Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//original hero is in session "hero"
		//should create a temporary hero to update values
		HttpSession sess = request.getSession();
		Hero hero = (Hero) sess.getAttribute("hero");
		Hero tempHero = new Hero();
		
		tempHero.setHeroName(request.getParameter("heroName"));
		tempHero.setAtkType(request.getParameter("atkType"));
		tempHero.setMainStats(request.getParameter("mainStats"));
		
		tempHero.setBaseHP(Integer.parseInt(request.getParameter("baseHP")));
		tempHero.setBaseMP(Integer.parseInt(request.getParameter("baseMP")));
		tempHero.setBaseAtk(Integer.parseInt(request.getParameter("baseAtk")));
		tempHero.setBaseArmor(Integer.parseInt(request.getParameter("baseArmor")));
		tempHero.setBaseMS(Integer.parseInt(request.getParameter("baseMS")));
		tempHero.setBaseStr(Integer.parseInt(request.getParameter("baseStr")));
		tempHero.setBaseAgi(Integer.parseInt(request.getParameter("baseAgi")));
		tempHero.setBaseInt(Integer.parseInt(request.getParameter("baseInt")));
		
		tempHero.setGainStr(Float.parseFloat(request.getParameter("gainStr")));
		tempHero.setGainAgi(Float.parseFloat(request.getParameter("gainAgi")));
		tempHero.setGainInt(Float.parseFloat(request.getParameter("gainInt")));
		
		System.out.println(hero.getHeroName() +" "+ request.getParameter("heroName"));
		System.out.println(hero.getAtkType() +" "+ request.getParameter("atkType"));
		System.out.println(hero.getMainStats() +" "+ request.getParameter("mainStats"));
		
		System.out.println(hero.getBaseHP() +" "+ "hp: " +request.getParameter("baseHP"));
		System.out.println(hero.getBaseMP() +" "+ "mp: " +request.getParameter("baseMP"));
		System.out.println(hero.getBaseAtk() +" "+ "atk: " +request.getParameter("baseAtk"));
		System.out.println(hero.getBaseArmor()+" "+ "armor: " +request.getParameter("baseArmor"));
		System.out.println(hero.getBaseMS() +" "+ "ms: " +request.getParameter("baseMS"));
		System.out.println(hero.getBaseStr() +" "+ "bstr: " +request.getParameter("baseStr"));
		System.out.println(hero.getBaseAgi() +" "+ "bagi: " +request.getParameter("baseAgi"));
		System.out.println(hero.getBaseInt() +" "+ "bint: " +request.getParameter("baseInt"));
		
		System.out.println(hero.getGainStr() +" "+ "gstr: " +request.getParameter("gainStr"));
		System.out.println(hero.getGainAgi() +" "+ "gagi: " +request.getParameter("gainAgi"));
		System.out.println(hero.getGainInt() +" "+ "gint: " +request.getParameter("gainInt"));
		
		try {
			heroDao.updateHero(hero, tempHero);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
//		doGet(request, response);
	}

}
