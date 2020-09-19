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

	static String prevOrderBy;
	private HeroDao heroDao = new HeroDao();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//default sorting order
		if(prevOrderBy==null)
			prevOrderBy = "hero_name";
		
		//passes in the order that was last sorted by and the order to sort by
		List<Hero> hl = heroDao.viewHero(prevOrderBy, request.getParameter("sort"));
		
		//order that was last sorted by
		prevOrderBy = request.getParameter("sort");
//		for(Hero h: hl) {
//			System.out.println(h.getHeroName());
//		}
		
		HttpSession sess = request.getSession();
		sess.setAttribute("heroList", hl);
		
		RequestDispatcher rd = request.getRequestDispatcher("viewHero.jsp");
		rd.forward(request, response);
	}

}
