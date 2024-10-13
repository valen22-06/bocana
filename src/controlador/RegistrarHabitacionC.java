/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import static controlador.RegistrarC.validarDireccion;
import static controlador.RegistrarC.validarEspaciosNumeros;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import modelo.Habitacion;
import modelo.HabitacionDao;
import modelo.TipoHabitacionDao;
import modelo.TipoHabitacion;
import modelo.TipoServicioDao;
import vista.FotosV;
import vista.RegistrarHabitacionV;

/**
 *
 * @author Usuario
 */
public class RegistrarHabitacionC implements ActionListener{
    RegistrarHabitacionV registrarHabitacionV = new RegistrarHabitacionV();
    
    
    FotosV fotosV ;
    FotosC fotosC ;
    
    boolean flagsuite = true;
    boolean flagestandar = true;
    boolean flagfamiliar = true;
    boolean flagdeluxe = true;
    boolean flageconomica = true;
    boolean flagpresidencial = true;
    
    int idHotel;
    
    List<byte[]> imagenes = new ArrayList<>();
    List<JLabel> fotos = new ArrayList<>();
    
    TipoHabitacionDao tipoHabitacionDao = new TipoHabitacionDao();
    Habitacion habitacion = new Habitacion();
    HabitacionDao habitacionDao = new HabitacionDao();
    List<TipoHabitacion> datosTipoHabitacionDao = tipoHabitacionDao.listar();
    TipoHabitacion tipoHabitacion = new TipoHabitacion();
    
    public RegistrarHabitacionC(RegistrarHabitacionV registrarHabitacionV, int idHotel) {
        this.registrarHabitacionV = registrarHabitacionV;
        this.idHotel=idHotel;
        
        this.registrarHabitacionV.imagenes = imagenes;
        this.registrarHabitacionV.fotos = fotos;
        this.registrarHabitacionV.bcancelar.addActionListener(this);
        this.registrarHabitacionV.bregistrar.addActionListener(this);
        this.registrarHabitacionV.bfotos.addActionListener(this);
        this.registrarHabitacionV.bcargar.addActionListener(this);
        
        
        this.registrarHabitacionV.setExtendedState(6);
        this.registrarHabitacionV.setVisible(true);
        this.registrarHabitacionV.setDefaultCloseOperation(3);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource()== registrarHabitacionV.bfotos){
            fotosV = new FotosV();
            fotosC = new FotosC(fotosV);
        }
        
        if(e.getSource()== registrarHabitacionV.bcargar){
            fotos = fotosC.getFotos();
            imagenes = fotosC.getImagenes();
            
            if(!fotosC.getFotos().isEmpty()){
               for(int i = 0; i<fotos.size();i++){
                   JLabel foto = fotos.get(i);
                   registrarHabitacionV.panelFotos.add(foto);
                
                }
                registrarHabitacionV.panelFotos.revalidate();
                registrarHabitacionV.panelFotos.repaint(); 
            }else{
                JOptionPane.showMessageDialog(fotosV, "No hay fotos para cargar");
            }
        }
        
        if (e.getSource() == registrarHabitacionV.bregistrar) {

            if (!registrarHabitacionV.tdescripcionBreve.getText().toString().isBlank()
                    && !registrarHabitacionV.tdescripcionDetallada.getText().toString().isBlank()
                    && !registrarHabitacionV.ttarifa.getText().toString().isBlank()
                    && !registrarHabitacionV.ttarifa.getText().toString().isBlank()
                    && !registrarHabitacionV.lista.getSelectedItem().toString().isBlank()
                    && !fotos.isEmpty()
                    ) {

                setAdd();

                JOptionPane.showMessageDialog(registrarHabitacionV, "Es bien");
            } else {

                JOptionPane.showMessageDialog(registrarHabitacionV, "Faltan datos por ingresar");

            }
        }
        
    }
    
    
    
    public void setAdd() {
        int resultado = 0;
        int r = 1;
        String estado = "Disponible";
        double tarifa=0;

        try {

            tarifa = Double.parseDouble(registrarHabitacionV.ttarifa.getText().toString());

        } catch (NumberFormatException eN) {
            r = 0;
            JOptionPane.showMessageDialog(registrarHabitacionV, "Error en los datos numéricos: " + eN.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


        String descripcionBreve = "";
        String descripcionDetallada = "";

        try {
            descripcionBreve = registrarHabitacionV.tdescripcionBreve.getText().toString();
            descripcionDetallada = registrarHabitacionV.tdescripcionDetallada.getText().toString();
            //falta agrgarle el numero maximo de palabras
            
        } catch (IllegalArgumentException e) {
            r = 0;
            JOptionPane.showMessageDialog(registrarHabitacionV, "Error: " + e.getMessage());
        }
        
        
        
        for(int i = 0;i<datosTipoHabitacionDao.size();i++){
            if(datosTipoHabitacionDao.get(i).getDescripcion().equals(registrarHabitacionV.lista.getSelectedItem().toString())){
                int idTipoHabitacion = datosTipoHabitacionDao.get(i).getIdTipoHabitacion();
                String descripcion = datosTipoHabitacionDao.get(i).getDescripcion();
                tipoHabitacion.setIdTipoHabitacion(idTipoHabitacion);
                tipoHabitacion.setDescripcion(descripcion);
            }
        }
        int idHabitacion = habitacionDao.ultimoId()+1;
        habitacion.setIdHabitacion(idHabitacion);
        habitacion.setEstado(estado);
        habitacion.setTarifa(tarifa);
        habitacion.setDescripcionBreve(descripcionBreve);
        habitacion.setDescripcionDetallada(descripcionDetallada);
        habitacion.setTipoHabitacion(tipoHabitacion);
        habitacion.setIdHotel(idHotel);
        habitacion.setImagenes(imagenes);
        


        

        if (habitacionDao.setAgregar(habitacion)==1) {
            
            if(habitacionDao.setAgregarImagenes(habitacion.getIdHabitacion(),habitacion.getImagenes())==1){
                JOptionPane.showMessageDialog(registrarHabitacionV, "Habitacion registrada");

            }
            
        } else {
            JOptionPane.showMessageDialog(registrarHabitacionV, "no se insertaron las imagenes");
        }

    }
    
    
    

}
