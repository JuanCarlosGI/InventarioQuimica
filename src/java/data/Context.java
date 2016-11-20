package data;

import models.Usuario;
import models.Pedido;
import models.Laboratorio;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import models.Consumible;
import models.Equipo;
import models.Reactivo;
import models.Material;

/**
 * Clase que será utilzada para obetener acceso a la base de datos.
 * @author Juan Carlos Guzmán Islas.
 */
public final class Context {
    /**
     * String conteniendo el URL de la base de datos.
     */
    private static final String URL =
            "jdbc:mysql://localhost/inventarioquimica";

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
        System.out.println(matricula);
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            try (ResultSet resultSet = statement.executeQuery(""
                    + "SELECT * "
                    + "FROM usuario "
                    + "WHERE matricula = '" + matricula + "';")) {
                if (resultSet.next()) {
                    usuario = new Usuario();
                    usuario.setMatricula(resultSet.getString("matricula"));
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
                    "SELECT * FROM usuario;")) {

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
                    + "INSERT INTO usuario "
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
                    + "UPDATE usuario SET "
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
                    + "DELETE FROM usuario "
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
                    + "FROM pedido "
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
                    "SELECT * FROM pedido;")) {

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
                    + "INSERT INTO pedido "
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
                    + "UPDATE pedido SET "
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
                    + "DELETE FROM pedido "
                    + "WHERE id = " + id + ";");
        } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }

        return true;
    }

    /**
     * Obtiene un laboratorio de la base de datos.
     * @param clave ID del laboratorio a obtener.
     * @return El laboratorio, o nulo si no encuentra un laboratorio con dicha
     * clave.
     */
    public static Laboratorio getLaboratorio(final String clave) {
        Laboratorio laboratorio = null;

        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            try (ResultSet resultSet = statement.executeQuery(""
                    + "SELECT * "
                    + "FROM laboratorio "
                    + "WHERE clave = '" + clave + "';")) {
                if (resultSet.next()) {
                    laboratorio = new Laboratorio();

                    laboratorio.setClave(resultSet.getString("clave"));
                    laboratorio.setNombre(resultSet.getString("nombre"));
                }
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return laboratorio;
    }

    /**
     * Obtiene la lista de todos los laboratorios.
     * @return Lista con todos los laboratorios.
     */
    public static LinkedList<Laboratorio> getLaboratorios() {
        LinkedList<Laboratorio> laboratorios = new LinkedList<>();

        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            try (ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM laboratorio;")) {

                while (resultSet.next()) {
                    Laboratorio laboratorio = new Laboratorio();

                    laboratorio.setClave(resultSet.getString("clave"));
                    laboratorio.setNombre(resultSet.getString("nombre"));

                    laboratorios.add(laboratorio);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return laboratorios;
    }

    /**
     * Crea un nuevo registro en la base de datos con el nuevo laboratorio.
     * @param laboratorio El laboratorio a ser guardado.
     * @return Valor indicando si fue exitoso o no.
     */
    public static boolean insertarLaboratorio(final Laboratorio laboratorio) {
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            statement.executeUpdate(""
                    + "INSERT INTO laboratorio "
                    + "(clave, nombre)"
                    + "VALUES ("
                    + "'" + laboratorio.getClave() + "', "
                    + "'" + laboratorio.getNombre() + "');");
        } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }

        return true;
    }

    /**
     * Actualiza los valores de un laboratorio. Notar que la llave primaria no
     * puede ser editada.
     * @param laboratorio Pedido con los nuevos valores.
     * @return Valor indicando si la operación fue exitosa o no.
     */
    public static boolean actualizarLaboratorio(final Laboratorio laboratorio) {
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            statement.executeUpdate(""
                    + "UPDATE laboratorio SET "
                    + "nombre = '" + laboratorio.getNombre() + "' "
                    + "WHERE clave = " + laboratorio.getClave() + ";");
        } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }

        return true;
    }

    /**
     * Elimina un laboratorio de la base de datos.
     * @param clave ID del laboratorio por eliminar.
     * @return Valor indicando si la operación fue exitosa.
     */
    public static boolean eliminarLaboratorio(final String clave) {
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            statement.executeUpdate(""
                    + "DELETE FROM pedido "
                    + "WHERE clave = " + clave + ";");
        } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }

        return true;
    }

    /**
     * Obtiene un Equipo de la base de datos.
     * @param clave La clave del equipo por obtener.
     * @return El equipo, o nulo si no se encontró.
     */
    public static Equipo getEquipo(final String clave) {
        Equipo equipo = null;

        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            try (ResultSet resultSet = statement.executeQuery(""
                    + "SELECT * "
                    + "FROM equipo "
                    + "WHERE clave = '" + clave + "';")) {
                if (resultSet.next()) {
                    equipo = new Equipo();

                    equipo.setClave(resultSet.getString("clave"));
                    equipo.setNombre(resultSet.getString("nombre"));
                    equipo.setMarca(resultSet.getString("marca"));
                    equipo.setCantidad(resultSet.getInt("cantidad"));
                    equipo.setLocalizacion(resultSet.getString("localizacion"));
                    equipo.setDescripcion(resultSet.getString("descripcion"));
                }
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return equipo;
    }

    /**
     * Obtiene la lista de todos los equipos.
     * @return Lista con todos los equipos.
     */
    public static LinkedList<Equipo> getEquipos() {
        LinkedList<Equipo> equipos = new LinkedList<>();

        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            try (ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM equipo;")) {

                while (resultSet.next()) {
                    Equipo equipo = new Equipo();

                    equipo.setClave(resultSet.getString("clave"));
                    equipo.setNombre(resultSet.getString("nombre"));
                    equipo.setMarca(resultSet.getString("marca"));
                    equipo.setCantidad(resultSet.getInt("cantidad"));
                    equipo.setLocalizacion(resultSet.getString("localizacion"));
                    equipo.setDescripcion(resultSet.getString("descripcion"));

                    equipos.add(equipo);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return equipos;
    }

    /**
     * Crea un nuevo registro en la base de datos con el nuevo equipo.
     * @param equipo El equipo a ser guardado.
     * @return Valor indicando si fue exitoso o no.
     */
    public static boolean insertarEquipo(final Equipo equipo) {
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            statement.executeUpdate(""
                    + "INSERT INTO equipo "
                    + "(clave, nombre, marca, cantidad, localizacion, "
                    + "descripcion) "
                    + "VALUES ("
                    + "'" + equipo.getClave() + "', "
                    + "'" + equipo.getNombre() + "', "
                    + "'" + equipo.getMarca() + "', "
                    + equipo.getCantidad() + ", "
                    + "'" + equipo.getLocalizacion() + "', "
                    + "'" + equipo.getDescripcion() + "');");
        } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }
        return true;
    }
    
    /**
     * Crea un nuevo registro en la base de datos con el nuevo reactivo.
     * @param equipo El reactivo a ser guardado.
     * @return Valor indicando si fue exitoso o no.
     */
    public static boolean insertarReactivo(final Reactivo reactivo) {
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();
            statement.executeUpdate(""
                    + "INSERT INTO reactivo "
                    + "(clave, nombre, marca, presentacion, contenido, localizacion, descripcion, cantidad) "
                    + "VALUES ("
                    + "'" + reactivo.getClave() + "', "
                    + "'" + reactivo.getNombre() + "', "
                    + "'" + reactivo.getMarca() + "', "
                    + "'" + reactivo.getPresentacion() + "', "
                    + "'" + reactivo.getContenido() + "', "
                    + "'" + reactivo.getLocalizacion() + "', "
                    + "'" + reactivo.getDescripcion() + "', "
                    + reactivo.getCantidad() + "');");
            } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }
        return true;
    }

    /**
     * Actualiza los valores de un equipo. Notar que la llave primaria no puede
     * ser editada.
     * @param equipo equipo con los nuevos valores.
     * @return Valor indicando si la operación fue exitosa o no.
     */
    public static boolean actualizarEquipo(final Equipo equipo) {
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            statement.executeUpdate(""
                    + "UPDATE equipo SET "
                    + "nombre = '" + equipo.getNombre() + "', "
                    + "marca = '" + equipo.getMarca() + "', "
                    + "cantidad = " + equipo.getCantidad() + ", "
                    + "localizacion = '" + equipo.getLocalizacion() + "', "
                    + "descripcion = '" + equipo.getDescripcion() + "' "
                    + "WHERE clave = " + equipo.getClave() + ";");
        } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }
        return true;
    }
    /**
     * Obtiene un reactivo dado su clave.
     *
     * @param clave Clave del reactivo que se busca.
     * @return El reactivo correspondiente, o nulo si no existe.
     */
    public static Reactivo getReactivo(final String clave) {
        Reactivo reactivo = null;
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();
            try (ResultSet resultSet = statement.executeQuery(""
                    + "SELECT * "
                    + "FROM reactivo "
                    + "WHERE clave = '" + clave + "';")) {
                if (resultSet.next()) {
                    reactivo = new Reactivo();
                    reactivo.setClave(resultSet.getString("clave"));
                    reactivo.setNombre(resultSet.getString("nombre"));
                    reactivo.setMarca(resultSet.getString("marca"));
                    reactivo.setPresentacion(resultSet.getString("presentacion"));
                    reactivo.setContenido(resultSet.getString("contenido"));
                    reactivo.setLocalizacion(resultSet.getString("localizacion"));
                    reactivo.setDescripcion(resultSet.getString("descripcion"));
                    reactivo.setCantidad(resultSet.getInt("cantidad"));
                }
                }
        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return reactivo;
    }

    /**
     * Elimina un equipo de la base de datos.
     * @param clave ID del laboratorio por eliminar.
     * @return Valor indicando si la operación fue exitosa.
     */
    public static boolean eliminarEquipo(final String clave) {
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            statement.executeUpdate(""
                    + "DELETE FROM equipo "
                    + "WHERE clave = " + clave + ";");
        } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }

        return true;
    }

    /**
     * Obtiene un Material de la base de datos.
     * @param clave La clave del material por obtener.
     * @return El material, o nulo si no se encontró.
     */
    public static Material getMaterial(final String clave) {
        Material material = null;
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            try (ResultSet resultSet = statement.executeQuery(""
                    + "SELECT * "
                    + "FROM material "
                    + "WHERE clave = '" + clave + "';")) {
                if (resultSet.next()) {
                    material = new Material();

                    material.setClave(resultSet.getString("clave"));
                    material.setNombre(resultSet.getString("nombre"));
                    material.setMarca(resultSet.getString("marca"));
                    material.setCantidad(resultSet.getInt("cantidad"));
                    material.setLocalizacion(resultSet.
                            getString("localizacion"));
                    material.setCapacidad(resultSet.getString("capacidad"));
                    material.setDescripcion(resultSet.getString("descripcion"));
                }
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }
        
        return material;
    }
    
    /**
     * Obtiene la lista de todos los reactivos.
     *
     * @return Lista con todos los reactivos.
     */
    public static LinkedList<Reactivo> getReactivos() {
        LinkedList<Reactivo> reactivos = new LinkedList<>();
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            try (ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM reactivo;")) {

                while (resultSet.next()) {
                    Reactivo reactivo = new Reactivo();
                    reactivo.setClave(resultSet.getString("clave"));
                    reactivo.setNombre(resultSet.getString("nombre"));
                    reactivo.setMarca(resultSet.getString("marca"));
                    reactivo.setPresentacion(resultSet.getString("presentacion"));
                    reactivo.setContenido(resultSet.getString("contenido"));
                    reactivo.setLocalizacion(resultSet.getString("localizacion"));
                    reactivo.setDescripcion(resultSet.getString("descripcion"));
                    reactivo.setCantidad(resultSet.getInt("cantidad"));
                    reactivos.add(reactivo);
                }                
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
        return reactivos;
    }

    /**
     * Obtiene la lista de todos los materiales.
     * @return Lista con todos los materiales.
     */
    public static LinkedList<Material> getMateriales() {
        LinkedList<Material> materiales = new LinkedList<>();

        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            try (ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM material;")) {

                while (resultSet.next()) {
                    Material material = new Material();
                    material.setClave(resultSet.getString("clave"));
                    material.setNombre(resultSet.getString("nombre"));
                    material.setMarca(resultSet.getString("marca"));
                    material.setCantidad(resultSet.getInt("cantidad"));
                    material.setLocalizacion(resultSet
                            .getString("localizacion"));
                    material.setCapacidad(resultSet.getString("capacidad"));
                    material.setDescripcion(resultSet.getString("descripcion"));

                    materiales.add(material);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return materiales;
    }
    
    /**
     * Actualiza los valores de un reactivo. Notar que la llave primaria no puede
     * ser editada.
     * @param reactivo Reactivo con los nuevos valores.
     * @return Valor indicando si la operación fue exitosa o no.
     */
    public static boolean actualizarReactivo(final Reactivo reactivo) {
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            statement.executeUpdate(""
                    + "UPDATE reactivo SET "
                    + "marca = '" + reactivo.getNombre() + "', "
                    + "password = '" + reactivo.getMarca() + "', "
                    + "presentacion = '" + reactivo.getPresentacion() + "', "
                    + "contenido = '" + reactivo.getContenido() + "', "
                    + "localizacion = '" + reactivo.getLocalizacion() + "', "
                    + "descripcion = '" + reactivo.getDescripcion() + "', "
                    + "cantidad = " + reactivo.getCantidad() + " "
                    + "WHERE clave = '" + reactivo.getClave() + "';");
                    } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }

        return true;
    
        //return materiales;
    }

    /**
     * Crea un nuevo registro en la base de datos con el nuevo material.
     * @param material El material a ser guardado.
     * @return Valor indicando si fue exitoso o no.
     */
    public static boolean insertarMaterial(final Material material) {
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            statement.executeUpdate(""
                    + "INSERT INTO material "
                    + "(clave, nombre, marca, cantidad, localizacion, "
                    + "descripcion, capacidad) "
                    + "VALUES ("
                    + "'" + material.getClave() + "', "
                    + "'" + material.getNombre() + "', "
                    + "'" + material.getMarca() + "', "
                    + material.getCantidad() + ", "
                    + "'" + material.getLocalizacion() + "', "
                    + "'" + material.getDescripcion() + "', "
                    + "'" + material.getCapacidad() + "');");
        } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }
        return true;
    }

    /**
     * Actualiza los valores de un material. Notar que la llave primaria no
     * puede ser editada.
     * @param material Material con los nuevos valores.
     * @return Valor indicando si la operación fue exitosa o no.
     */
    public static boolean actualizarMaterial(final Material material) {
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            statement.executeUpdate(""
                    + "UPDATE material SET "
                    + "nombre = '" + material.getNombre() + "', "
                    + "marca = '" + material.getMarca() + "', "
                    + "cantidad = " + material.getCantidad() + ", "
                    + "localizacion = '" + material.getLocalizacion() + "', "
                    + "descripcion = '" + material.getDescripcion() + "', "
                    + "capacidad = '" + material.getCapacidad() + "' "
                    + "WHERE clave = " + material.getClave() + ";");

        } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }

        return true;
    }
    
    /**
     * Elimina un reactivo de la base de datos.
     * @param clave Clave del reactivo por eliminar.
     * @return Valor indicando si la operación fue exitosa.
     */
    public static boolean eliminarReactivo(final String clave) {
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            statement.executeUpdate(""
        + "DELETE FROM reactivo "
                    + "WHERE clave = '" + clave + "';");
            } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }

        return true;
    }

    /**
     * Elimina un material de la base de datos.
     * @param clave ID del material por eliminar.
     * @return Valor indicando si la operación fue exitosa.
     */
    public static boolean eliminarMaterial(final String clave) {
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            statement.executeUpdate(""
                    + "DELETE FROM material "
                    + "WHERE clave = " + clave + ";");
        } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }

        return true;
    }
    
    /**
     * Crea un nuevo consumible en la base de datos con el nuevo consumible.
     * @param equipo El consumible a ser guardado.
     * @return Valor indicando si fue exitoso o no.
     */
    public static boolean insertarConsumible(final Consumible consumible) {
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();
            statement.executeUpdate(""
                    + "INSERT INTO consumible "
                    + "(clave, nombre, marca, presentacion, contenido, localizacion, descripcion, cantidad) "
                    + "VALUES ("
                    + "'" + consumible.getClave() + "', "
                    + "'" + consumible.getNombre() + "', "
                    + "'" + consumible.getMarca() + "', "
                    + "'" + consumible.getPresentacion() + "', "
                    + "'" + consumible.getContenido() + "', "
                    + "'" + consumible.getLocalizacion() + "', "
                    + "'" + consumible.getDescripcion() + "', "
                    + consumible.getCantidad() + "');");
            } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }
        return true;
    }
    
    /**
     * Obtiene un consumible dado su clave.
     *
     * @param clave Clave del consumible que se busca.
     * @return El consumible correspondiente, o nulo si no existe.
     */
    public static Consumible getConsumible(final String clave) {
        Consumible consumible = null;
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();
            try (ResultSet resultSet = statement.executeQuery(""
                    + "SELECT * "
                    + "FROM consumible "
                    + "WHERE clave = '" + clave + "';")) {
                if (resultSet.next()) {
                    consumible = new Consumible();
                    consumible.setClave(resultSet.getString("clave"));
                    consumible.setNombre(resultSet.getString("nombre"));
                    consumible.setMarca(resultSet.getString("marca"));
                    consumible.setPresentacion(resultSet.getString("presentacion"));
                    consumible.setContenido(resultSet.getString("contenido"));
                    consumible.setLocalizacion(resultSet.getString("localizacion"));
                    consumible.setDescripcion(resultSet.getString("descripcion"));
                    consumible.setCantidad(resultSet.getInt("cantidad"));
                }
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return consumible;
    }
    
    /**
     * Obtiene la lista de todos los consumible.
     *
     * @return Lista con todos los consumible.
     */
    public static LinkedList<Consumible> getConsumibles() {
        LinkedList<Consumible> consumibles = new LinkedList<>();
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            try (ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM consumible;")) {

                while (resultSet.next()) {
                    Consumible consumible = new Consumible();
                    consumible.setClave(resultSet.getString("clave"));
                    consumible.setNombre(resultSet.getString("nombre"));
                    consumible.setMarca(resultSet.getString("marca"));
                    consumible.setPresentacion(resultSet.getString("presentacion"));
                    consumible.setContenido(resultSet.getString("contenido"));
                    consumible.setLocalizacion(resultSet.getString("localizacion"));
                    consumible.setDescripcion(resultSet.getString("descripcion"));
                    consumible.setCantidad(resultSet.getInt("cantidad"));
                    consumibles.add(consumible);
                }                
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        
        return consumibles;
    }
    
    /**
     * Actualiza los valores de un consumible. Notar que la llave primaria no puede
     * ser editada.
     * @param consumible Consumible con los nuevos valores.
     * @return Valor indicando si la operación fue exitosa o no.
     */
    public static boolean actualizarConsumible(final Consumible consumible) {
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            statement.executeUpdate(""
                    + "UPDATE consumible SET "
                    + "marca = '" + consumible.getNombre() + "', "
                    + "password = '" + consumible.getMarca() + "', "
                    + "presentacion = '" + consumible.getPresentacion() + "', "
                    + "contenido = '" + consumible.getContenido() + "', "
                    + "localizacion = '" + consumible.getLocalizacion() + "', "
                    + "descripcion = '" + consumible.getDescripcion() + "', "
                    + "cantidad = " + consumible.getCantidad() + " "
                    + "WHERE clave = '" + consumible.getClave() + "';");
                    } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }

        return true;
    }
    
    /**
     * Elimina un consumible de la base de datos.
     * @param clave Clave del consumible por eliminar.
     * @return Valor indicando si la operación fue exitosa.
     */
    public static boolean eliminarConsumible(final String clave) {
        try {
            Connection connection;
            connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();

            statement.executeUpdate(""
        + "DELETE FROM consumible "
                    + "WHERE clave = '" + clave + "';");
            } catch (SQLException exception) {
            System.out.println(exception);
            return false;
        }

        return true;
    }
}
