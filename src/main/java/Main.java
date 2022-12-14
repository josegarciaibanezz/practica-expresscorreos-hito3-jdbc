import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import expresscorreos.model.Cartero;
import expresscorreos.model.Coche;
import expresscorreos.model.Oficina;

import javax.swing.plaf.SliderUI;

public class Main {
    // @TODO: Sustituya xxxx por los parámetros de su conexión

    private static final String DB_SERVER = "127.0.0.2";

    private static final int DB_PORT = 3306;

    private static final String DB_NAME = "practicabbdd";

    private static final String DB_USER = "root";

    private static final String DB_PASS = "root";

    private static Connection conn;

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://" + DB_SERVER + ":" + DB_PORT + "/" + DB_NAME;
        conn = DriverManager.getConnection(url, DB_USER, DB_PASS);


        nuevoCartero("50564673R","Troski","Lapices");






        // @TODO pruebe sus funciones

        conn.close();
    }

    // @TODO resuelva las siguientes funciones...

    public static void nuevoCartero(String DNI, String nombre, String apellidos) throws SQLException {
        // @TODO: complete este método para que cree un nuevo cartero en la base de datosç
        ResultSet rs = null;

        try {

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO cartero (dni,apellidos,nombre) VALUES (?, ?, ?)");
            stmt.setString(1,DNI);
            stmt.setString(2,apellidos);
            stmt.setString(3,nombre);
            stmt.executeUpdate();




        }catch (SQLException e) { System.out.println("Error al insertar");
        }



    }

    public static List<Cartero> carterosRepartoCochePeriodo(int periodo) {
        // @TODO: complete este método para que muestre por pantalla una lista de carteros que han
        // realizado un reparto con coche en el periodo comprendido por los últimos "periodo" días
        // (implementar para periodo=7)
        // Tenga en cuenta que la consulta a la base de datos le devolverá un ResultSet sobre el que deberá
        // ir iterando y creando un objeto con cada Cartero que cumpla con las condiciones,
        // y añadirlos a la lista
        List <Cartero> carteros = new LinkedList<>();

        return carteros;
    }

    public static List<Oficina> oficinasAsociadasCalle(String calle) {
        // @TODO: complete este método para que muestre por pantalla una lista de las oficinas que
        // dan servicio a la C/Alcalá de Madrid.
        // Tenga en cuenta que la consulta a la base de datos le devolverá un ResultSet sobre el que deberá
        // ir iterando y creando un objeto con cada Oficina que tenga asociada algún segmento de esa calle,
        // y añadirlos a la lista
        List <Oficina> oficinas = new LinkedList<>();

        return oficinas;
    }

    public static String cochesSinUtilizarPeriodo(int periodo) {
        // @TODO: complete este método para que muestre por pantalla una lista de los coches que no se han
        // utilizado en los últimos "periodo" días (implementar para periodo=30)
        List<Coche> lista_coches = new LinkedList<>();
        String coches = "";

        return coches;
    }

}
