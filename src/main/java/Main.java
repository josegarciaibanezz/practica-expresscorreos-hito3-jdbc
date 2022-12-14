import java.sql.*;
import java.util.Iterator;
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

        List<Cartero> carteros = null;
        List<Oficina> oficinas = null;




        nuevoCartero("32799690K","Troski","Lapices");
        carteros = carterosRepartoCochePeriodo(30);
        for (Cartero i: carteros) {
            System.out.println(i.getDNI()+", "+i.getNombre()+", "+i.getApellidos());
        }
        System.out.println();
        System.out.println();

        oficinas = oficinasAsociadasCalle("Calle Alcala");
        for (Oficina i: oficinas) {
            System.out.println(i.getCodO());
        }
        System.out.println();
        System.out.println();

        System.out.println(cochesSinUtilizarPeriodo(30));


        // @TODO pruebe sus funciones

        conn.close();
    }

    // @TODO resuelva las siguientes funciones...

    public static void nuevoCartero(String DNI, String nombre, String apellidos) throws SQLException {
        // @TODO: complete este método para que cree un nuevo cartero en la base de datosç
        Statement stmt = conn.createStatement();

        try {/** Forma 1

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO cartero (dni,apellidos,nombre) VALUES (?, ?, ?)");
            stmt.setString(1,DNI);
            stmt.setString(2,apellidos);
            stmt.setString(3,nombre);
         Forma 2
         */

            stmt.executeUpdate("INSERT IGNORE INTO   cartero (dni,apellidos,nombre) VALUES ('"+DNI+"','"+apellidos+"','"+nombre+"')");
        }catch (SQLException e) { System.out.println("Error al insertar"+e);
        }
        stmt.close();
    }

    public static List<Cartero> carterosRepartoCochePeriodo(int periodo) throws SQLException {
        // @TODO: complete este método para que muestre por pantalla una lista de carteros que han
        // realizado un reparto con coche en el periodo comprendido por los últimos "periodo" días
        // (implementar para periodo=7)
        // Tenga en cuenta que la consulta a la base de datos le devolverá un ResultSet sobre el que deberá
        // ir iterando y creando un objeto con cada Cartero que cumpla con las condiciones,
        // y añadirlos a la lista
        List <Cartero> carteros = new LinkedList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try{
            stmt = conn.createStatement();
            if(stmt.execute("SELECT dni, nombre, apellidos FROM cartero INNER JOIN reparto ON cartero.dni = reparto.dni_cartero " +
                    "                              WHERE " +
                    "                               reparto.fecha_creacion BETWEEN DATE_SUB(NOW(), INTERVAL "+periodo+" DAY) AND NOW()")){ //fecha actual
                rs = stmt.getResultSet();

            }
            while(rs.next()){
                carteros.add(new Cartero(rs.getNString(1),rs.getNString(2),rs.getNString(3)));
            }

        }catch (SQLException e){
            System.out.println("Error para obtener los carteros"+e);
        }

        return carteros;
    }

    public static List<Oficina> oficinasAsociadasCalle(String calle) {
        // @TODO: complete este método para que muestre por pantalla una lista de las oficinas que
        // dan servicio a la C/Alcalá de Madrid.
        // Tenga en cuenta que la consulta a la base de datos le devolverá un ResultSet sobre el que deberá
        // ir iterando y creando un objeto con cada Oficina que tenga asociada algún segmento de esa calle,
        // y añadirlos a la lista
        List <Oficina> oficinas = new LinkedList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try{
            stmt = conn.createStatement();
            if(stmt.execute("SELECT codO FROM oficina " +
                    "WHERE oficina.nombre_calle = '"+calle+"' ")){
                rs = stmt.getResultSet();

            }
            while(rs.next()){
                oficinas.add(new Oficina(rs.getInt(1)));
            }

        }catch (SQLException e){
            System.out.println("Error para obtener las oficinas"+e);
        }

        return oficinas;
    }

    public static String cochesSinUtilizarPeriodo(int periodo) throws SQLException {
        // @TODO: complete este método para que muestre por pantalla una lista de los coches que no se han
        // utilizado en los últimos "periodo" días (implementar para periodo=30)
        List<Coche> lista_coches = new LinkedList<>();
        String coches = "";
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            if(stmt.execute("SELECT matricula FROM reparto WHERE fecha_creacion " +
                                "BETWEEN DATE_SUB(NOW(), INTERVAL "+periodo+" DAY) AND NOW()"))
                rs =stmt.getResultSet();
            while(rs.next()){
                lista_coches.add(new Coche(rs.getNString(1)));
                coches = coches +", "+lista_coches.toString();
            }

        }catch (SQLException e){
            System.out.println("Fallo a la hora de obtener la lista de los coches"+e);

        }


        return coches;
    }

}
