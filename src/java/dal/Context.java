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
     * String conteniendo el URL de la base de datos.
     */
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";

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
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            try (ResultSet resultSet = statement.executeQuery(""
                    + "SELECT * "
                    + "FROM inventarioquimica.usuario "
                    + "WHERE matricula = '" + matricula + "';")) {
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
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
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

    /**
     * Crea un nuevo registro en la base de datos con el nuevo usuario.
     * @param usuario El usuario a ser guardado.
     * @return Valor indicando si fue exitoso o no.
     */
    public static boolean insertarUsuario(final Usuario usuario) {
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            statement.executeUpdate(""
                    + "INSERT INTO invantarioquimica.usuario "
                    + "(matricula, nombre, password, rol, creadorId, correo) "
                    + "VALUES ("
                    + "'" + usuario.getMatricula() + "', "
                    + "'" + usuario.getNombre() + "', "
                    + "'" + usuario.getPassword() + "', "
                    + "'" + usuario.getRol() + "', "
                    + "'" + usuario.getCreadorId() + "', "
                    + "'" + usuario.getCorreo() + "');");
        } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }

        return true;
    }

    /**
     * Actualiza los valores de un usuario. Notar que la llave primaria no puede
     * ser editada.
     * @param usuario Usuario con los nuevos valores.
     * @return Valor indicando si la operación fue exitosa o no.
     */
    public static boolean actualizarUsuario(final Usuario usuario) {
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            statement.executeUpdate(""
                    + "UPDATE invantarioquimica.usuario SET "
                    + "nombre = '" + usuario.getNombre() + "', "
                    + "password = '" + usuario.getPassword() + "', "
                    + "rol = '" + usuario.getRol() + "', "
                    + "creadorId = '" + usuario.getCreadorId() + "', "
                    + "correo = '" + usuario.getCorreo() + "' "
                    + "WHERE matricula = '" + usuario.getMatricula() + "';");
        } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }

        return true;
    }

    /**
     * Elimina un usuario de la base de datos.
     * @param matricula MAtricula del alumno por eliminar.
     * @return Valor indicando si la operación fue exitosa.
     */
    public static boolean eliminarUsuario(final String matricula) {
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            statement.executeUpdate(""
                    + "DELETE FROM invantarioquimica.usuario "
                    + "WHERE matricula = '" + matricula + "';");
        } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }

        return true;
    }
}
