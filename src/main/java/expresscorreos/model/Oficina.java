package expresscorreos.model;

public class Oficina {

    private int codO;
    private int codCDC;
    private String nomMun;
    private int numero;
    private int piso;
    private char letra;
    private int portal;
    private String nombre_calle;

    public Oficina(){
        this.codO = -1;
        this.codCDC = -1;
        this.nomMun = "";
        this.numero = -1;
        this.piso = -1;
        this.letra = '?';
        this.portal = -1;
        this.nombre_calle = "";
    }
    public Oficina(int codO){
        this.setCodO(codO);
    }
    public Oficina(int codO, int codCDC, String nomMun, int numero, int piso, char letra,int portal, String nombre_calle){
        this.setCodO(codO);
        this.setCodCDC(codCDC);
        this.setNomMun(nomMun);
        this.setNumero(numero);
        this.setPiso(piso);
        this.setLetra(letra);
        this.setPortal(portal);
        this.setNombre_calle(nombre_calle);
    }

    public int getCodO() {
        return codO;
    }

    public void setCodO(int codO) {
        this.codO = codO;
    }

    public int getCodCDC() {
        return codCDC;
    }

    public void setCodCDC(int codCDC) {
        this.codCDC = codCDC;
    }

    public String getNomMun() {
        return nomMun;
    }

    public void setNomMun(String nomMun) {
        this.nomMun = nomMun;
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

    public int getPortal() {
        return portal;
    }

    public void setPortal(int portal) {
        this.portal = portal;
    }

    public String getNombre_calle() {
        return nombre_calle;
    }

    public void setNombre_calle(String nombre_calle) {
        this.nombre_calle = nombre_calle;
    }
}
