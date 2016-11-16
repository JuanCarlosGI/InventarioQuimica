package models;

import java.util.LinkedList;
import DAL.*;

public class Usuario {
    private String Matricula;
    private String Password;
    private String Nombre;
    private String Rol;
    private String CreadorId;
    private String Correo;

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public String getCreadorId() {
        return CreadorId;
    }

    public void setCreadorId(String CreadorId) {
        this.CreadorId = CreadorId;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
    
}
