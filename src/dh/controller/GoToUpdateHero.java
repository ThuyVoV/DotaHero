package dh.controller;

import java.io.IOException;

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
 * Servlet implementation class GoToEditHero
 */
@WebServlet("/GoToUpdateHero")
public class GoToUpdateHero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HeroDao heroDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoToUpdateHero() {
        super();
        heroDao = new HeroDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Hero hero = heroDao.getHero(request.getParameter("hero"));
		
		HttpSession sess = request.getSession();
		sess.setAttribute("hero", hero);
		
		RequestDispatcher rd = request.getRequestDispatcher("updateHero.jsp");
		rd.forward(request, response);
	}

}
