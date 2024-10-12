/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.TarjetaV;

/**
 *
 * @author estud
 */
public class TarjetaC implements ActionListener{
    public TarjetaV tarjetaV = new TarjetaV();
    
    public TarjetaC(TarjetaV tarV){
        this.tarjetaV = tarV;
        this.tarjetaV.cancelar.addActionListener(this);
        this.tarjetaV.continuar.addActionListener(this);
        this.tarjetaV.setExtendedState(6);
        this.tarjetaV.setVisible(true);
        this.tarjetaV.setDefaultCloseOperation(3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==tarjetaV.continuar){
                System.out.print("Funciona loco");
            }
            if(e.getSource()==tarjetaV.cancelar){
                System.out.print("Tambien funciona loco");
            }
    }
    
    
}
