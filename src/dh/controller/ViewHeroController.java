package dh.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dh.hero.Hero;
import dh.herodao.HeroDao;

/**
 * Servlet implementation class ViewHeroController
 */
@WebServlet("/ViewHeroController")
public class ViewHeroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String prevOrderBy;
	private String prevStats;
	private HeroDao heroDao;
	
	public ViewHeroController() {
		prevOrderBy = "hero_name";
		prevStats = "Strength";
		heroDao = new HeroDao();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//default sorting order, default sort by stats
//		if(prevOrderBy==null)
//			prevOrderBy = "hero_name";
//		
//		if(prevStats==null)
//			this.prevStats = "Strength";
		
		System.out.println("old prevStats " + this.prevStats);
		
		//if first time clicking on main_stats column sort by str first
		if(this.prevOrderBy.equals("main_stats"))
			getStats();
		else
			prevStats = "Strength";
			
		System.out.println("new prevStats " + this.prevStats);
		
		//passes in the order that was last sorted by and the stats and the order to sort by
		List<Hero> hl = heroDao.viewHero(prevOrderBy, this.prevStats, request.getParameter("sort"));
		
		//order that was last sorted by
		prevOrderBy = request.getParameter("sort");

		
		HttpSession sess = request.getSession();
		sess.setAttribute("heroList", hl);
		
		RequestDispatcher rd = request.getRequestDispatcher("viewHero.jsp");
		rd.forward(request, response);
	}
	
	//rotates between stats
	private void getStats() {
		if(this.prevStats.equals("Strength"))
			this.prevStats="Agility";
		else if (this.prevStats.equals("Agility"))
			this.prevStats= "Intelligent";
		else if(this.prevStats.equals("Intelligent"))
			this.prevStats= "Strength";
	}

}
