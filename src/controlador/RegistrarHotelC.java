/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import static controlador.RegistrarC.validarDireccion;
import static controlador.RegistrarC.validarEspaciosNumeros;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Hotel;
import modelo.TipoServicio;
import modelo.TipoServicioDao;
import vista.RegistrarHotelV;

/**
 *
 * @author Usuario
 */
public class RegistrarHotelC implements ActionListener {

    RegistrarHotelV registrarHotelV = new RegistrarHotelV();
    Hotel hotel = new Hotel();
    TipoServicioDao tipoServicioDao = new TipoServicioDao();
    List<TipoServicio> datosTipoServicioDao = tipoServicioDao.listar();
    ArrayList<TipoServicio> datosTipoServicio = new ArrayList<>();

    boolean flagwifi = true;
    boolean flaggym = true;
    boolean flagpiscina = true;
    boolean flagac = true;
    boolean flagrecepcion24horas = true;
    boolean flagrestaurante = true;
    boolean flagplaya = true;
    boolean flagsauna = true;
    boolean flagbar = true;

    public RegistrarHotelC(RegistrarHotelV registrarHotelV) {
        this.registrarHotelV = registrarHotelV;

        this.registrarHotelV.bwifi.addActionListener(this);
        this.registrarHotelV.bgym.addActionListener(this);
        this.registrarHotelV.bpiscina.addActionListener(this);
        this.registrarHotelV.bac.addActionListener(this);
        this.registrarHotelV.brecepcion24horas.addActionListener(this);
        this.registrarHotelV.brestaurante.addActionListener(this);
        this.registrarHotelV.bplaya.addActionListener(this);
        this.registrarHotelV.bsauna.addActionListener(this);
        this.registrarHotelV.bbar.addActionListener(this);
        this.registrarHotelV.bregistrar.addActionListener(this);

        this.registrarHotelV.bregistrar.addActionListener(this);
        this.registrarHotelV.setExtendedState(6);
        this.registrarHotelV.setVisible(true);
        this.registrarHotelV.setDefaultCloseOperation(3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == registrarHotelV.bwifi) {
            
            if(seleccionarTipoServicio(flagwifi, registrarHotelV.bwifi)==1){
                flagwifi = false;
            }else{
                flagwifi = true;
            }
        }

        if (e.getSource() == registrarHotelV.bgym) {

            if(seleccionarTipoServicio(flaggym, registrarHotelV.bgym)==1){
                flaggym = false;
            }else{
                flaggym = true;
            }

        }

        if (e.getSource() == registrarHotelV.bpiscina) {

            if(seleccionarTipoServicio(flagpiscina, registrarHotelV.bpiscina)==1){
                flagpiscina = false;
            }else{
                flagpiscina = true;
            }
        }

        if (e.getSource() == registrarHotelV.bac) {

            if(seleccionarTipoServicio(flagac, registrarHotelV.bac)==1){
                flagac = false;
            }else{
                flagac = true;
            }
        }

        if (e.getSource() == registrarHotelV.brecepcion24horas) {

            if(seleccionarTipoServicio(flagrecepcion24horas, registrarHotelV.brecepcion24horas)==1){
                flagrecepcion24horas = false;
            }else{
                flagrecepcion24horas = true;
            }
        }

        if (e.getSource() == registrarHotelV.brestaurante) {

            if(seleccionarTipoServicio(flagrestaurante, registrarHotelV.brestaurante)==1){
                flagrestaurante = false;
            }else{
                flagrestaurante = true;
            }
        }

        if (e.getSource() == registrarHotelV.bplaya) {

            if(seleccionarTipoServicio(flagplaya, registrarHotelV.bplaya)==1){
                flagplaya = false;
            }else{
                flagplaya = true;
            }
        }

        if (e.getSource() == registrarHotelV.bsauna) {

            if(seleccionarTipoServicio(flagsauna, registrarHotelV.bsauna)==1){
                flagsauna = false;
            }else{
                flagsauna = true;
            }
        }

        if (e.getSource() == registrarHotelV.bbar) {

            if(seleccionarTipoServicio(flagbar, registrarHotelV.bbar)==1){
                flagbar = false;
            }else{
                flagbar = true;
            }
        }

        if (e.getSource() == registrarHotelV.bregistrar) {

            if (!registrarHotelV.tnit.getText().toString().isEmpty()
                    && !registrarHotelV.tnombreHotel.getText().toString().isEmpty()
                    && !registrarHotelV.tdireccion.getText().toString().isEmpty()
                    && !registrarHotelV.tnumeroHabitaciones.getText().toString().isEmpty()) {

                setAdd();

//                JOptionPane.showMessageDialog(vista, "Es bien");
            } else {

                JOptionPane.showMessageDialog(registrarHotelV, "Faltan datos por ingresar");

            }
        }

    }
    
    public int seleccionarTipoServicio(boolean flag, JButton boton){
        int r = 1;
        int i = (int) boton.getClientProperty("valor");
        
        if (flag) {

            boton.setBackground(Color.lightGray);
            datosTipoServicio.add(datosTipoServicioDao.get(i));
            r=1;
        } else {
            boton.setBackground(Color.white);
            datosTipoServicio.remove(datosTipoServicioDao.get(i));
            r=0;
        }
        
        return r;
    }
    
    public void setAdd() {
        int resultado = 0;
        int r = 1;
        int nit = 0;
        int numeroHabitaciones = 0;
        int idRol = 2;

        try {

            nit = Integer.parseInt(registrarHotelV.tnit.getText().toString());

            numeroHabitaciones = Integer.parseInt(registrarHotelV.tnumeroHabitaciones.getText().toString());

        } catch (NumberFormatException eN) {
            r = 0;
            JOptionPane.showMessageDialog(registrarHotelV, "Error en los datos numéricos: " + eN.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


        String nombreHotel = "";

        try {
            nombreHotel = registrarHotelV.tnombreHotel.getText().toString();
            validarEspaciosNumeros(nombreHotel);


        } catch (IllegalArgumentException e) {
            r = 0;
            JOptionPane.showMessageDialog(registrarHotelV, "Error: " + e.getMessage());
        }

        String direccion = "";
        try {
            direccion = registrarHotelV.tdireccion.getText().toString();
            validarDireccion(registrarHotelV.tdireccion.getText().toString());
            
            JOptionPane.showMessageDialog(registrarHotelV, "La direccion es valida");
        } catch (IllegalArgumentException e) {
            r = 0;
            JOptionPane.showMessageDialog(registrarHotelV, "Error: " + e.getMessage());
        }

        hotel.setNit(nit);
        hotel.setNombreHotel(nombreHotel);
        hotel.setDireccion(direccion);
        hotel.setNumeroHabitaciones(numeroHabitaciones);


//        if (r == 1) {
//            resultado = usuarioDao.setAgregar(usuario);
//        }
//
//        if (resultado == 1) {
//            JOptionPane.showMessageDialog(registrarHotelV, "Hotel registrado");
//        } else {
//            JOptionPane.showMessageDialog(registrarHotelV, "Error de insercion" + JOptionPane.ERROR_MESSAGE);
//        }

    }

}
