/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Usuario;
import vista.VerReservasV;

/**
 *
 * @author Usuario
 */
public class VerReservasC implements ActionListener{
    VerReservasV verReservasV = new VerReservasV();
    Usuario usuario = new Usuario();
    public VerReservasC(VerReservasV verReservasV, Usuario usuario){
        this.verReservasV=verReservasV;
        this.usuario=usuario;
        
        
        
        this.verReservasV.bvolver.addActionListener(this);
        this.verReservasV.setExtendedState(6);
        this.verReservasV.setVisible(true);
        this.verReservasV.setDefaultCloseOperation(3);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
    }
}
