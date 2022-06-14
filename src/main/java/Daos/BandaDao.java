package Daos;

import Beans.Banda;
import Beans.Reproduccion;

import java.sql.*;
import java.util.ArrayList;

public class BandaDao {

    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";


    public ArrayList<Banda> obtenerListaBandas(String filter) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql="SELECT * FROM banda where nombre_banda LIKE \"%y\"";

        ArrayList<Banda> listaBandas = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1,filter);
            try(ResultSet rs = pstmt.executeQuery()){
                while (rs.next()) {
                    String idBanda = rs.getString(1);
                    String nombre_banda = rs.getString(2);
                    int idlider = rs.getInt(3);

                    listaBandas.add(new Banda(idBanda,nombre_banda,idlider));
                }}

        } catch (SQLException e) {
            System.out.println("Error de conexión SQL");
        }
        return listaBandas; }
}

/*
    //En este caso se usa preparedStatement

   */


