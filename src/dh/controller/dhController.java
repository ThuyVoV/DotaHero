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
		System.out.println("inside dhcontroller " + request.getParameter("strGain") );
		System.out.println("inside dhcontroller " + request.getParameter("agiGain") );
		float x = Float.parseFloat(request.getParameter("agiGain")) + Float.parseFloat(request.getParameter("strGain"));
		System.out.println(x);
		Hero hero = new Hero();
		
		hero.setHeroName(request.getParameter("hname"));
		
		
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
