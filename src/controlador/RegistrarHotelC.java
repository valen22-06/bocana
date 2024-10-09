/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import modelo.TipoServicio;
import modelo.TipoServicioDao;
import vista.RegistrarHotelV;

/**
 *
 * @author Usuario
 */
public class RegistrarHotelC implements ActionListener {
    

    RegistrarHotelV registrarHotelV = new RegistrarHotelV();
    TipoServicioDao tipoServicioDao = new TipoServicioDao();
    List<TipoServicio> datosTipoServicioDao = tipoServicioDao.listar();
    ArrayList<TipoServicio> datosTipoServicio = new ArrayList<>();

    public RegistrarHotelC(RegistrarHotelV registrarHotelV) {
        this.registrarHotelV = registrarHotelV;
        
        
        
        this.registrarHotelV.bwifi.addActionListener(this);
        
        
        
        this.registrarHotelV.bregistrar.addActionListener(this);
        this.registrarHotelV.setExtendedState(6);
        this.registrarHotelV.setVisible(true);
        this.registrarHotelV.setDefaultCloseOperation(3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registrarHotelV.bwifi){
            
            registrarHotelV.bwifi.setBackground(Color.red);
            datosTipoServicio.add(datosTipoServicioDao.get(0));
            System.out.println("hola");
            if(registrarHotelV.bwifi.getBackground().equals(Color.red)){
                datosTipoServicio.remove(datosTipoServicioDao.get(0));
                System.out.println("hola2");
            }
            
        }
        
        
        
    }
}
