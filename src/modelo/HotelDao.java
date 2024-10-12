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
public class HotelDao {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    
//    public List listar() {
//        ArrayList<Hotel> datosHotel = new ArrayList<Hotel>();
//        String sql = "SELECT * FROM hoteles";
//
//        try {
//            con = conectar.getConnection();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            
//            while (rs.next()) {
//                Hotel h = new Hotel();
//                h.setIdHotel(rs.getInt(1));
//                h.setNit(rs.getInt(2));
//                h.setNombreHotel(rs.getString(3));
//                h.setDireccion(rs.getString(4));
//                h.setNumeroHabitaciones(rs.getInt(5));
//                h.setDescripcionBreve(rs.getString(6));
//                
//                
//                ArrayList<TipoServicio> servicios = new ArrayList<TipoServicio>();
//                
//                String sqlS = "SELECT ts.idTipoServicio, ts.descripcion FROM tipos_servicios ts " +
//                              "JOIN hoteles_tipos_servicios hts ON ts.idTipoServicio = hts.idTipoServicio " +
//                              "WHERE hts.idHotel = " + h.getIdHotel();
//                
//                PreparedStatement psS = con.prepareStatement(sqlS);
//                ResultSet rsS = psS.executeQuery();
//
//                while (rsS.next()) {
//                    TipoServicio tp = new TipoServicio();
//                    tp.setIdTipoServicio(rsS.getInt(1));
//                    tp.setDescripcion(rsS.getString(2));
//                    servicios.add(tp);
//                }
//
//                
//                h.setServicios(servicios);
//
//                
//                datosHotel.add(h);
//
//                
//                rsS.close();
//                psS.close();
//            }
//        }
//        catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.toString());
//        }
//        finally {
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            }
//            catch (SQLException sqle) {
//                JOptionPane.showMessageDialog(null, sqle.toString());
//            }
//        }
//        
//        
//       
//        return datosHotel;
//    }
    
//    public int setAgregar (Hotel h){
//       String sql = "INSERT INTO usuarios(nit, nombreHotel, direccion, numeroHabitaciones, idOfertaEspecial, idResenia) VALUES (?,?,?,?,?,?)";
//       
//       try{
//           con=conectar.getConnection();
//           ps=con.prepareStatement(sql);
//           
//
//            
//            ps.setInt(1, h.getNit());
//            ps.setString(2, h.getNombreHotel());
//            ps.setString(3, h.getDireccion());
//            ps.setInt(4, h.getNumeroHabitaciones());
////            ps.setInt(5, h.getIdOfertaEspecial());
////            ps.setInt(6, h.getIdResenia()); 
//           
//           ps.executeUpdate();
//           return 1;
//              
//       } catch (SQLException e) {
//           JOptionPane.showMessageDialog(null, e.toString(),"Error de insercion"+e.getMessage(),JOptionPane.ERROR_MESSAGE);
//           return 0;
//       } finally {
//           try{
//               if(con!=null){
//                   con.close();
//               }
//           } catch (SQLException sqle){
//               JOptionPane.showMessageDialog(null, sqle.toString());
//           }
//       }
//   }
}
