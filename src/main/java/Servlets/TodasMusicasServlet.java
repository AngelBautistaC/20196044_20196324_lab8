package Servlets;

import Beans.Reproduccion;
import Daos.ReproduccionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TodasMusicasServlet", value = "/listaCanciones")
public class TodasMusicasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReproduccionDao reproduccionDao= new ReproduccionDao();
        ArrayList<Reproduccion> listaCompleta=reproduccionDao.obtenerListaCompleta();
        request.setAttribute("listaCompleta",listaCompleta);
        RequestDispatcher view =request.getRequestDispatcher("listaCanciones.jsp");
        view.forward(request,response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReproduccionDao reproduccionDao= new ReproduccionDao();
        String action = request.getParameter("a") == null ? "lista" : request.getParameter("a");

        if ("likear".equals(action)) {
            Reproduccion reproduccion = leerParametrosRequest(request);
            reproduccionDao.likear(reproduccion);
            response.sendRedirect(request.getContextPath() + "/listaCanciones");
        }
        if ("dislike".equals(action)) {
            Reproduccion reproduccion = leerParametrosRequest1(request);
            reproduccionDao.dislikear(reproduccion);
            response.sendRedirect(request.getContextPath() + "/listaCanciones");
        }

    }
    public Reproduccion leerParametrosRequest(HttpServletRequest request) {
        int idreproduccion= Integer.parseInt(request.getParameter("idcancion"));
        String cancion=request.getParameter("cancion");
        String banda=request.getParameter("banda");
        int like = Integer.parseInt(request.getParameter("like"));
        Reproduccion reproduccion= new Reproduccion();
        reproduccion.setLike(like);
        reproduccion.setBanda(banda);
        reproduccion.setCancion(cancion);
        reproduccion.setIdreproduccion(idreproduccion);
        return reproduccion;
    }
    public Reproduccion leerParametrosRequest1(HttpServletRequest request) {
        int idreproduccion= Integer.parseInt(request.getParameter("idcancion1"));
        String cancion=request.getParameter("cancion1");
        String banda=request.getParameter("banda1");
        int like = Integer.parseInt(request.getParameter("like1"));
        Reproduccion reproduccion= new Reproduccion();
        reproduccion.setLike(like);
        reproduccion.setBanda(banda);
        reproduccion.setCancion(cancion);
        reproduccion.setIdreproduccion(idreproduccion);
        return reproduccion;
    }
}
