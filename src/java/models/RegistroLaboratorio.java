package models;

public class RegistroLaboratorio {
    private String maestroId;
    private String alumnoId;
    private String laboratorioId;

    public String getMaestroId() {
        return maestroId;
    }

    public void setMaestroId(String maestroId) {
        this.maestroId = maestroId;
    }

    public String getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(String alumnoId) {
        this.alumnoId = alumnoId;
    }

    public String getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(String laboratorioId) {
        this.laboratorioId = laboratorioId;
    }
    
}
