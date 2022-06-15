package Servlets;

import Beans.Reproduccion;
import Daos.ReproduccionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MusicasPorBanda", value = "/listaCancionesPorBanda")
public class MusicasPorBanda extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReproduccionDao reproduccionDao= new ReproduccionDao();
        ArrayList<Reproduccion> listaCompletaPorBanda =reproduccionDao.obtenerListaCompletaPorBanda();
        request.setAttribute("listaCompletaPorBanda",listaCompletaPorBanda);
        RequestDispatcher view =request.getRequestDispatcher("listaCancionesPorBanda.jsp");
        view.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}