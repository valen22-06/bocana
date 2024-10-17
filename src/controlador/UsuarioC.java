/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import modelo.Usuario;
import vista.AlojamientosV;
import vista.EditarUsuarioV;
import vista.RegistrarHotelV;
import vista.UsuarioV;

/**
 *
 * @author Usuario
 */
public class UsuarioC implements ActionListener{
    
    UsuarioV usuariov = new UsuarioV();
    Usuario usuario= new Usuario();
    
    public UsuarioC(UsuarioV usuariov, Usuario usuario) {
        this.usuariov = usuariov;
        this.usuario = usuario;
        
        this.usuariov.lnombreUsuario.setText(usuario.getNombre1()+" "+usuario.getApellido1());
        
        if(usuario.getIdRol()==4){
            this.usuariov.lverAlojamientos = new JLabel("Ver alojamientos");
            this.usuariov.lverAlojamientos.setFont(new Font("Times New Roman", 0, 30));

            this.usuariov.gbc.gridy = 7;
            this.usuariov.gbc.gridwidth = 1;
            this.usuariov.gbc.anchor = GridBagConstraints.WEST;
            this.usuariov.panel.add(this.usuariov.lverAlojamientos, this.usuariov.gbc);

            this.usuariov.bverAlojamientos = new JButton("Ver");
            this.usuariov.bverAlojamientos.setFont(new Font("Times New Roman", 0, 20));
            this.usuariov.bverAlojamientos.setContentAreaFilled(false);

            this.usuariov.gbc.gridy = 8;
            this.usuariov.gbc.gridwidth = 2;
            this.usuariov.gbc.anchor = GridBagConstraints.WEST;
            this.usuariov.panel.add(this.usuariov.bverAlojamientos, this.usuariov.gbc);
            this.usuariov.bverAlojamientos.addActionListener(this);
        }
        
        
        this.usuariov.beditarPerfil.addActionListener(this);
        this.usuariov.bverReservas.addActionListener(this);
        this.usuariov.bagregarAlojamiento.addActionListener(this);
        this.usuariov.beliminarPerfil.addActionListener(this);
        this.usuariov.bvolver.addActionListener(this);
        this.usuariov.bcerrarSesion.addActionListener(this);

        this.usuariov.setExtendedState(6);
        this.usuariov.setVisible(true);
        this.usuariov.setDefaultCloseOperation(3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==usuariov.bagregarAlojamiento){
            
            RegistrarHotelV registrarHotelV = new RegistrarHotelV();
            RegistrarHotelC registrarHotelC = new RegistrarHotelC(registrarHotelV,usuario);
            usuariov.setVisible(false);
        }
        
        if(e.getSource()==usuariov.beditarPerfil){
            
            EditarUsuarioV editarUsuarioV = new EditarUsuarioV();
            EditarUsuarioC editarUsuarioC = new EditarUsuarioC(editarUsuarioV,usuario);
            usuariov.setVisible(false);
        }
        
        
        if(e.getSource()==usuariov.bvolver){
            AlojamientosV alojamientosV = new AlojamientosV();
            AlojamientosC alojamientosC = new AlojamientosC(alojamientosV,usuario);
            usuariov.setVisible(false);
        }
        
        if(e.getSource()==usuariov.bcerrarSesion){
            usuario = new Usuario();
            usuario.setIdRol(3);
            AlojamientosV alojamientosV = new AlojamientosV();
            AlojamientosC alojamientosC = new AlojamientosC(alojamientosV,usuario);
            usuariov.setVisible(false);
        }
    }
}
