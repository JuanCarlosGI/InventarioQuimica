package dal;

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
     * Constructor privado para asegurar que nadie instancie la clase.
     */
    private Context() {
    }

    /**
     * Obtiene un usuario dado su matricula.
     *
     * @param matricula Matricula del usuario que se busca.
     * @return El usuario correspondiente, o nulo si no existe.
     */
    public static Usuario getUsuario(final String matricula) {
        Usuario usuario = null;

        try {
            String url = "jdbc:mysql://localhost:3306/mysql";
            Connection connection;
            connection = DriverManager.getConnection(url, "root", "");
            Statement statement = connection.createStatement();

            try (ResultSet resultSet = statement.executeQuery(""
                    + "SELECT * "
                    + "FROM inventarioquimica.usuario "
                    + "WHERE matricula = " + matricula + ";")) {
                if (resultSet.next()) {
                    usuario = new Usuario();
                    usuario.setMatricula(resultSet.getString("id"));
                    usuario.setNombre(resultSet.getString("nombre"));
                    usuario.setPassword(resultSet.getString("password"));
                    usuario.setRol(resultSet.getString("rol"));
                    usuario.setCreadorId(resultSet.getString("creadorId"));
                    usuario.setCorreo(resultSet.getString("correo"));
                }
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return usuario;
    }

    /**
     * Obtiene la lista de todos los usuarios.
     *
     * @return Lista con todos los usuarios.
     */
    public static LinkedList<Usuario> getUsuarios() {
        LinkedList<Usuario> usuarios = new LinkedList<>();

        try {
            String url = "jdbc:mysql://localhost:3306/mysql";
            Connection connection;
            connection = DriverManager.getConnection(url, "root", "");
            Statement statement = connection.createStatement();

            try (ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM inventarioquimica.usuario;")) {

                while (resultSet.next()) {
                    Usuario usuario = new Usuario();

                    usuario.setMatricula(resultSet.getString("matricula"));
                    usuario.setNombre(resultSet.getString("nombre"));
                    usuario.setPassword(resultSet.getString("password"));
                    usuario.setRol(resultSet.getString("rol"));
                    usuario.setCreadorId(resultSet.getString("creadorId"));
                    usuario.setCorreo(resultSet.getString("correo"));

                    usuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return usuarios;
    }
}
