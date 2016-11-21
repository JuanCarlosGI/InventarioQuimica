package models;

import data.Context;
import java.util.LinkedList;

/**
 * Clase representando a un usuario.
 * @author Juan Carlos Guzmán Islas
 */
public class Usuario {
    /**
     * La matricula del usuario.
     */
    private String matricula;

    /**
     * La contraseña del usuario.
     */
    private String password;

    /**
     * El nombre del usuario.
     */
    private String nombre;

    /**
     * El rol del usuario. Puede ser "administrador", "maestro" o "alumno".
     */
    private String rol;

    /**
     * El ID del creador del usuario.
     */
    private String creadorId;

    /**
     * El correo electrónico del usuario.
     */
    private String correo;

    /**
     * Getter de matricula.
     * @return La matricula del usuario.
     */
    public final String getMatricula() {
        return matricula;
    }

    /**
     * Setter de matricula.
     * @param nuevaMatricula La nueva matrícula.
     */
    public final void setMatricula(final String nuevaMatricula) {
        this.matricula = nuevaMatricula;
    }

    /**
     * Getter de password.
     * @return La contraseña.
     */
    public final String getPassword() {
        return password;
    }

    /**
     * Setter de password.
     * @param nuevaPassword La nueva contraseña.
     */
    public final void setPassword(final String nuevaPassword) {
        this.password = nuevaPassword;
    }

    /**
     * Getter de nombre.
     * @return El nombre.
     */
    public final String getNombre() {
        return nombre;
    }

    /**
     * Setter de nombre.
     * @param nuevoNombre El nuevo nombre.
     */
    public final void setNombre(final String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    /**
     * Getter de rol.
     * @return El rol.
     */
    public final String getRol() {
        return rol;
    }

    /**
     * Setter de rol.
     * @param nuevoRol El nuevo rol.
     */
    public final void setRol(final String nuevoRol) {
        this.rol = nuevoRol;
    }

    /**
     * Getter de creadorId.
     * @return El ID del creador.
     */
    public final String getCreadorId() {
        return creadorId;
    }

    /**
     * Setter de creadorId.
     * @param nuevoCreadorId El nuevo ID.
     */
    public final void setCreadorId(final String nuevoCreadorId) {
        this.creadorId = nuevoCreadorId;
    }

    /**
     * Getter de correo.
     * @return El correo.
     */
    public final String getCorreo() {
        return correo;
    }

    /**
     * Setter de correo.
     * @param nuevoCorreo El nuevo correo.
     */
    public final void setCorreo(final String nuevoCorreo) {
        this.correo = nuevoCorreo;
    }
    
    public final LinkedList<Laboratorio> getImparteLaboratorios() {
        if (!rol.equals("Profesor")) return null;
        
        LinkedList<MaestroLaboratorio> registros = Context.getMaestrosLaboratorios();
        registros.removeIf(r -> !(r.getMaestroId().equals(matricula)));
        
        LinkedList<Laboratorio> resultado = new LinkedList<>();
        for (MaestroLaboratorio registro : registros) {
            resultado.add(Context.getLaboratorio(registro.getLaboratorioId()));
        }
        
        return resultado;
    }
    
    public final LinkedList<Laboratorio> getCursaLaboratorios() {
        if (!rol.equals("Alumno")) return null;
        
        LinkedList<RegistroLaboratorio> registros = Context.getRegistrosLaboratorios();
        registros.removeIf(r -> !(r.getAlumnoId().equals(matricula)));
        
        LinkedList<Laboratorio> resultado = new LinkedList<>();
        for (RegistroLaboratorio registro : registros) {
            resultado.add(Context.getLaboratorio(registro.getLaboratorioId()));
        }
        
        return resultado;
    }
    
    public final LinkedList<Pedido> getPedidos() {
        LinkedList<Pedido> pedidos = Context.getPedidos();
        pedidos.removeIf(p -> !(p.getUsuarioId().equals(matricula)));
        return pedidos;
    }
}
