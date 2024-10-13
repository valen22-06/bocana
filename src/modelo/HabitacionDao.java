/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
}
