/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Usuario;
import vista.AlojamientosV;
import vista.HotelV;
import vista.IniciarSesionV;
import vista.RegistrarV;

/**
 *
 * @author estud
 */
public class HotelC implements ActionListener {

    HotelV hot = new HotelV();
    

    public HotelC(HotelV hotel) {
        this.hot = hotel;
        this.hot.registrar.addActionListener(this);
        this.hot.iniciar.addActionListener(this);
        this.hot.inicio.addActionListener(this);
        this.hot.setExtendedState(6);
        this.hot.setVisible(true);
        this.hot.setDefaultCloseOperation(3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == hot.registrar) {
            hot.dispose();
            RegistrarV regisV = new RegistrarV();
            RegistrarC regisC = new RegistrarC(regisV);
        }

        if (e.getSource() == hot.iniciar) {
            hot.dispose();
            IniciarSesionV iniV = new IniciarSesionV();
            IniciarSesionC iniC = new IniciarSesionC(iniV);

        }

        if (e.getSource() == hot.inicio) {
//            AlojamientosV aloja = new AlojamientosV();
//            AlojamientosC al = new AlojamientosC(aloja);
        }
    }
}
