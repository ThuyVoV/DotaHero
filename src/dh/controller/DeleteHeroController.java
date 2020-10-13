package dh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dh.hero.Hero;
import dh.herodao.HeroDao;

/**
 * Servlet implementation class DeleteHeroController
 */
@WebServlet("/DeleteHero")
public class DeleteHeroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HeroDao heroDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteHeroController() {
        super();
        heroDao = new HeroDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		Hero hero = (Hero) sess.getAttribute("hero");
		
		//getting the confirmation string
		String confirm = "Delete " + hero.getHeroName();
		
		//checking if it matches the confirmation string
		if(confirm.equals(request.getParameter("confirm"))) {
			System.out.println("the hero id is: " + heroDao.getHeroID(hero.getHeroName()));
			heroDao.deleteHero(heroDao.getHeroID(hero.getHeroName()));
			response.sendRedirect("successfulDeletePage.jsp");
		}
		else {
			boolean deletionFail = true;
			sess.setAttribute("deletion", true);
			response.sendRedirect("deleteConfirmPage.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
