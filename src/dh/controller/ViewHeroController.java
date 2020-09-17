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

	HeroDao heroDao = new HeroDao();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Hero> hl = heroDao.viewHero();
		
		HttpSession sess = request.getSession();
		sess.setAttribute("heroList", hl);
		
		RequestDispatcher rd = request.getRequestDispatcher("viewHero.jsp");
		rd.forward(request, response);
		

		System.out.println("I'm in here, VHC doGet");
	}

}
