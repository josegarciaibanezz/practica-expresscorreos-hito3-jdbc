package expresscorreos.model;

public class Coche {

    private String matricula;
    private int capacidad;
    private int codO;

    public Coche (){
        this.matricula = "";
        this.capacidad = -1;
        this.codO = -1;
    }

    public Coche(String matricula){
        this.matricula = matricula;
    }

    public Coche(String matricula, int capacidad, int codO){
        this.setMatricula(matricula);
        this.setCapacidad(capacidad);
        this.setCodO(codO);
    }


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCodO() {
        return codO;
    }

    public void setCodO(int codO) {
        this.codO = codO;
    }
}
