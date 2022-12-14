package expresscorreos.model;

public class Direccion {
    private int numero;
    private int piso;
    private char letra;
    private String nombre_calle;

    public Direccion (){
        this.numero = -1;
        this.piso = -1;
        this.letra = '?';
        this.nombre_calle = "";
    }
    public Direccion (int numero, int piso, char letra, String nombre_calle){
        this.setNumero(numero);
        this.setPiso(piso);
        this.setLetra(letra);
        this.setNombre_calle(nombre_calle);
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public String getNombre_calle() {
        return nombre_calle;
    }

    public void setNombre_calle(String nombre_calle) {
        this.nombre_calle = nombre_calle;
    }
}
