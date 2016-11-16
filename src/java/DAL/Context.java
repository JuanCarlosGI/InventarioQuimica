package DAL;

import models.*;
import java.sql.*;
import java.util.LinkedList;

public class Context {
    private static Connection Connection;
    private static Statement Statement;
    
    //  Static constructor
    static {
        try {
            String url = "jdbc:mysql://localhost:3306/mysql";
            Connection = DriverManager.getConnection(url,"root", "");
            Statement = Connection.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    public static Usuario GetUsuario(String matricula){
        Usuario usuario = null;
        
        try {
            ResultSet results = Statement.executeQuery(""
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
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
        }
        
        return usuario;
    }
    
    public static LinkedList<Usuario> GetUsuarios() {
        LinkedList<Usuario> usuarios = new LinkedList<>();

        try {
            ResultSet results = Statement.executeQuery(
                    "SELECT * FROM inventarioquimica.usuario;");
            
            while(results.next()) {
                Usuario usuario = new Usuario();
                
                usuario.setMatricula(results.getString("matricula"));
                usuario.setNombre(results.getString("nombre"));
                usuario.setPassword(results.getString("password"));
                usuario.setRol(results.getString("rol"));
                usuario.setCreadorId(results.getString("creadorId"));
                
                usuarios.add(usuario);
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
        }
        
        return usuarios;
    }
    
    /*
    public static LinkedList<Pedido> GetPedidosForUsuario(String usuarioId) {
        LinkedList<Pedido> pedidosForUsuario = new LinkedList<>();

        try {
            ResultSet results = Statement.executeQuery(""
                    + "SELECT * "
                    + "FROM InventarioQuimica.Pedido "
                    + "WHERE UsuarioId = " + usuarioId + ";");
            
            while(results.next()) {
                Pedido pedido = new Pedido();
                
                pedido.setId(results.getInt("Id"));
                pedido.setUsuarioId(results.getString("UsarioId"));
                
                pedidosForUsuario.add(pedido);
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
        }
        
        return pedidosForUsuario;
    }
*/
}
