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

                listaReproduccion.add(new Reproduccion(id,cancion,banda));
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
             ResultSet rs = stmt.executeQuery("SELECT idcancion,nombre_cancion,banda from cancion\n" +
                     "order by idcancion;")) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String cancion = rs.getString(2);
                String banda = rs.getString(3);

                listaCompleta.add(new Reproduccion(id,cancion,banda));
            }

        } catch (SQLException e) {
            System.out.println("Error de conexión SQL");
        }
        return listaCompleta;
    }




}
