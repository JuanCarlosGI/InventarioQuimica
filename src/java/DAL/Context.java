package DAL;

import models.Usuario;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Clase que será utilzada para obetener acceso a la base de datos.
 * @author Juan Carlos Guzmán Islas.
 */
public final class Context {
    /**
     * Statement que será usado para ejecutar consultas a la base de datos.
     */
    private static Statement statement;

    //  Static constructor
    static {
        try {
            String url = "jdbc:mysql://localhost:3306/mysql";

            Connection connection;
            connection = DriverManager.getConnection(url, "root", "");

            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Constructor privado para asegurar que nadie instancie la clase.
     */
    private Context() { }

    /**
     * Obtiene un usuario dado su matricula.
     * @param matricula Matricula del usuario que se busca.
     * @return El usuario correspondiente, o nulo si no existe.
     */
    public static Usuario getUsuario(final String matricula) {
        Usuario usuario = null;

        try {
            ResultSet results = statement.executeQuery(""
                    + "SELECT * "
                    + "FROM inventarioquimica.usuario "
                    + "WHERE matricula = " + matricula + ";");

            if (results.next()) {
                usuario = new Usuario();

                usuario.setMatricula(results.getString("id"));
                usuario.setNombre(results.getString("nombre"));
                usuario.setPassword(results.getString("password"));
                usuario.setRol(results.getString("rol"));
                usuario.setCreadorId(results.getString("creadorId"));
                usuario.setCorreo(results.getString("correo"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return usuario;
    }

    /**
     * Obtiene la lista de todos los usuarios.
     * @return Lista con todos los usuarios.
     */
    public static LinkedList<Usuario> getUsuarios() {
        LinkedList<Usuario> usuarios = new LinkedList<>();

        try {
            ResultSet results = statement.executeQuery(
                    "SELECT * FROM inventarioquimica.usuario;");

            while (results.next()) {
                Usuario usuario = new Usuario();

                usuario.setMatricula(results.getString("matricula"));
                usuario.setNombre(results.getString("nombre"));
                usuario.setPassword(results.getString("password"));
                usuario.setRol(results.getString("rol"));
                usuario.setCreadorId(results.getString("creadorId"));
                usuario.setCorreo(results.getString("correo"));

                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return usuarios;
    }
}
