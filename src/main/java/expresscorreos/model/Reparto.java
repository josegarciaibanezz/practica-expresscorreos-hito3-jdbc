package expresscorreos.model;

public class Reparto {

    private int id;
    private String fecha_creacion;
    private String matricula;
    private int id_ruta;
    private String dni_cartero;

    public Reparto(){
        this.id = -1;
        this.fecha_creacion = "";
        this.matricula = "";
        this.id_ruta = -1;
        this.dni_cartero = "";
    }

    public Reparto(int id, String fecha_creacion, String matricula, int id_ruta, String dni_cartero){
        this.setId(id);
        this.setFecha_creacion(fecha_creacion);
        this.setMatricula(matricula);
        this.setId_ruta(id_ruta);
        this.setDni_cartero(dni_cartero);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(int id_ruta) {
        this.id_ruta = id_ruta;
    }

    public String getDni_cartero() {
        return dni_cartero;
    }

    public void setDni_cartero(String dni_cartero) {
        this.dni_cartero = dni_cartero;
    }
}
