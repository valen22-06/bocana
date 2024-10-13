/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.Dimension;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class HabitacionDao {
    
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar() {
        ArrayList<Habitacion> datosHabitaciones = new ArrayList<Habitacion>();
        String sql = "SELECT h.idHabitacion, h.estado, h.tarifa, h.descripcionBreve, h.descripcionDetallada, h.idTipoHabitacion, tp.descripcion , h.idHotel, ho.nombreHotel"
                + " FROM habitaciones h "
                + "JOIN tipos_habitaciones tp ON tp.idTipoHabitacion = h.idTipoHabitacion "
                + "JOIN hoteles ho ON ho.idHotel = h.idHotel";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Habitacion h = new Habitacion();
                h.setIdHabitacion(rs.getInt(1));
                h.setEstado(rs.getString(2));
                h.setTarifa(rs.getDouble(3));
                h.setDescripcionBreve(rs.getString(4));
                h.setDescripcionDetallada(rs.getString(5));
                
                TipoHabitacion tp = new TipoHabitacion();
                tp.setIdTipoHabitacion(rs.getInt(6));
                tp.setDescripcion(rs.getString(7));
                
                h.setTipoHabitacion(tp);
                h.setIdHotel(rs.getInt(8));
                h.setNombreHotel(rs.getString(9));

                datosHabitaciones.add(h);
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        finally {
            try {
                if (con != null) {
                    con.close();
                }
            }
            catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, sqle.toString());
            }
        }
        return datosHabitaciones;
    }
    
    public List listarImagenes(int idHabitacion) {
        ArrayList<JLabel> fotos = new ArrayList<JLabel>();
        String sql = "SELECT imagen FROM imagenes WHERE idHabitacion = "+idHabitacion;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                byte[] imagenBytes = rs.getBytes("imagen");
                
                JLabel foto = new JLabel();
                foto.setSize(170, 100);
                
                // Convertir el array de bytes a un objeto Image
                InputStream in = new ByteArrayInputStream(imagenBytes);
                ImageIcon ima = new ImageIcon(in.readAllBytes());
                Image imagenEscalada = ima.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH);
                foto.setIcon(new ImageIcon(imagenEscalada));               
                
                fotos.add(foto);
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        finally {
            try {
                if (con != null) {
                    con.close();
                }
            }
            catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, sqle.toString());
            }
        }
        return fotos;
    }
    
    public int setAgregar (Habitacion h){
       String sql = "INSERT INTO habitaciones VALUES (? ,?, ?, ?, ?, ?, ?)";
       
       try{
           con=conectar.getConnection();
           ps=con.prepareStatement(sql);
           

           ps.setInt(1, h.getIdHabitacion());
           ps.setString(2, h.getEstado());
           ps.setDouble(3,h.getTarifa());
           ps.setString(4,h.getDescripcionBreve());
           ps.setString(5, h.getDescripcionDetallada());
           ps.setInt(6, h.getTipoHabitacion().getIdTipoHabitacion());
           ps.setInt(7, h.getIdHotel());
           
           
           
           ps.executeUpdate();
           return 1;
              
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString(),"Error de insercion"+e.getMessage(),JOptionPane.ERROR_MESSAGE);
           return 0;
       } finally {
           try{
               if(con!=null){
                   con.close();
               }
           } catch (SQLException sqle){
               JOptionPane.showMessageDialog(null, sqle.toString());
           }
       }
   }
    
    public int setAgregarImagenes(int idHabitacion, List<byte[]> imagenes){
        String sql = "INSERT INTO imagenes (idHabitacion, imagen) VALUES (?, ?)";
       
        try{
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            
            for (byte[] imagen : imagenes) {
                ps.setInt(1, idHabitacion);
                ps.setBytes(2, imagen); //dato binario
                ps.addBatch(); // Añadir al batch
            }
            
            ps.executeBatch();
            return 1;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(),"Error de insercion"+e.getMessage(),JOptionPane.ERROR_MESSAGE);
            return 0;
        } finally {
            try{
                if(con!=null){
                    con.close();
                }
            } catch (SQLException sqle){
                JOptionPane.showMessageDialog(null, sqle.toString());
            }
        }
    }
    
     public int ultimoId() {
        String sql = "SELECT COUNT(*) FROM habitaciones";
        int numero = 0;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                numero = rs.getInt(1);
            }

            return numero;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error en la consulta " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            return 0;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, sqle.toString());
            }
        }
    }
}
