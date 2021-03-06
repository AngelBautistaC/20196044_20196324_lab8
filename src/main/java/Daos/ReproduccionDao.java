package Daos;

import Beans.Reproduccion;

import java.sql.*;
import java.util.ArrayList;

public class ReproduccionDao {

    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";


    public ArrayList<Reproduccion> obtenerListaReproduccion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Reproduccion> listaReproduccion = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT cancion_idcancion,nombre_cancion,banda,count(*) FROM reproduccion\n" +
                     "INNER JOIN cancion on (idcancion=cancion_idcancion)\n" +
                     "group by cancion_idcancion\n" +
                     "having count(*)>2\n" +
                     "order by count(*) DESC;")) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String cancion = rs.getString(2);
                String banda = rs.getString(3);

                listaReproduccion.add(new Reproduccion(id,cancion,banda,0));
            }

        } catch (SQLException e) {
            System.out.println("Error de conexión SQL");
        }
        return listaReproduccion;
    }

    public ArrayList<Reproduccion> obtenerListaCompleta(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Reproduccion> listaCompleta = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select idcancion,nombre_cancion,banda,me_gusta from cancion\n" +
                     "order by idcancion;")) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String cancion = rs.getString(2);
                String banda = rs.getString(3);
                int me_gusta=rs.getInt(4);

                listaCompleta.add(new Reproduccion(id,cancion,banda,me_gusta));
            }

        } catch (SQLException e) {
            System.out.println("Error de conexión SQL");
        }
        return listaCompleta;
    }
    public ArrayList<Reproduccion> obtenerListaCompletaPorBanda(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Reproduccion> listaCompletaPorBanda = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select idcancion,nombre_cancion,banda,me_gusta from cancion\n" +
                     "where banda =\"FOB\" order by idcancion;")) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String cancion = rs.getString(2);
                String banda = rs.getString(3);
                int like = Integer.parseInt(rs.getString(4));

                listaCompletaPorBanda.add(new Reproduccion(id,cancion,banda,like));
            }

        } catch (SQLException e) {
            System.out.println("Erro ción SQL");
        }
        return listaCompletaPorBanda;
    }

    //ESTA PARTE PARA LOS LIKES EN LA BANDA, SE AÑADIO UNA COLUMNA DE LIKES EN LA BASE D EDATOS/MUSICA :
    public void likear(Reproduccion musicid) {

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "UPDATE cancion set me_gusta=1 \n" +
                "where idcancion=?;";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            //System.out.println(musicid.getIdreproduccion());
            pstmt.setInt(1, musicid.getIdreproduccion());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void dislikear(Reproduccion musicid) {

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "UPDATE cancion set me_gusta=0 \n" +
                "where idcancion=?;";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            //System.out.println(musicid.getIdreproduccion());
            pstmt.setInt(1, musicid.getIdreproduccion());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
