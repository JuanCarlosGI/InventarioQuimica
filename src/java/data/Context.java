package data;

import models.Usuario;
import models.Pedido;
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

    /**
     * Obtiene un pedido dado su ID.
     * @param id ID del pedido que se busca.
     * @return El pedido correspondiente, o nulo si no existe.
     */
    public static Pedido getPedido(final int id) {
        Pedido pedido = null;

        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            try (ResultSet resultSet = statement.executeQuery(""
                    + "SELECT * "
                    + "FROM inventarioquimica.pedido "
                    + "WHERE id = " + id + ";")) {
                if (resultSet.next()) {
                    pedido = new Pedido();

                    pedido.setId(resultSet.getInt("id"));
                    pedido.setUsuarioId(resultSet.getString("usuarioId"));
                    pedido.setStatus(resultSet.getInt("status"));
                    pedido.setLaboratorioId(
                            resultSet.getString("laboratorioId"));
                    pedido.setProfesorId(resultSet.getString("profesorId"));
                    pedido.setFecha(resultSet.getDate("fecha"));
                }
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return pedido;
    }

    /**
     * Obtiene la lista de todos los pedidos.
     * @return Lista con todos los pedidos.
     */
    public static LinkedList<Pedido> getPedidos() {
        LinkedList<Pedido> pedidos = new LinkedList<>();

        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            try (ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM inventarioquimica.pedido;")) {

                while (resultSet.next()) {
                    Pedido pedido = new Pedido();

                    pedido.setId(resultSet.getInt("id"));
                    pedido.setUsuarioId(resultSet.getString("usuarioId"));
                    pedido.setStatus(resultSet.getInt("status"));
                    pedido.setLaboratorioId(
                            resultSet.getString("laboratorioId"));
                    pedido.setProfesorId(resultSet.getString("profesorId"));
                    pedido.setFecha(resultSet.getDate("fecha"));

                    pedidos.add(pedido);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return pedidos;
    }

    /**
     * Crea un nuevo registro en la base de datos con el nuevo pedido.
     * @param pedido El pedido a ser guardado.
     * @return Valor indicando si fue exitoso o no.
     */
    public static boolean insertarPedido(final Pedido pedido) {
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            statement.executeUpdate(""
                    + "INSERT INTO invantarioquimica.pedido "
                    + "(id, usuarioId, profesorId, labratorioId, fecha, status)"
                    + "VALUES ("
                    + pedido.getId() + ", "
                    + "'" + pedido.getUsuarioId() + "', "
                    + "'" + pedido.getProfesorId() + "', "
                    + pedido.getLaboratorioId() + ", "
                    + "'" + pedido.getFecha() + "', "
                    + pedido.getStatus() + ");");
        } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }

        return true;
    }

    /**
     * Actualiza los valores de un pedido. Notar que la llave primaria no puede
     * ser editada.
     * @param pedido Pedido con los nuevos valores.
     * @return Valor indicando si la operación fue exitosa o no.
     */
    public static boolean actualizarPedido(final Pedido pedido) {
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            statement.executeUpdate(""
                    + "UPDATE invantarioquimica.pedido SET "
                    + "usuarioId = '" + pedido.getUsuarioId() + "', "
                    + "profesorId = '" + pedido.getProfesorId() + "', "
                    + "laboratorioId = " + pedido.getLaboratorioId() + ", "
                    + "fecha = '" + pedido.getFecha() + "', "
                    + "status = " + pedido.getStatus() + " "
                    + "WHERE id = " + pedido.getId() + ";");
        } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }

        return true;
    }

    /**
     * Elimina un pedido de la base de datos.
     * @param id ID del pedido por eliminar.
     * @return Valor indicando si la operación fue exitosa.
     */
    public static boolean eliminarPedido(final int id) {
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            statement.executeUpdate(""
                    + "DELETE FROM invantarioquimica.pedido "
                    + "WHERE id = " + id + ";");
        } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }

        return true;
    }
}
