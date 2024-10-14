/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Usuario
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Usuario;
import modelo.UsuarioDao;
import vista.HotelV;
import vista.IniciarSesionV;
import javax.swing.*;
import java.awt.*;

public class IniciarSesionC
implements ActionListener {
    IniciarSesionV iniciarSesionV = new IniciarSesionV();
    UsuarioDao usuarioDao = new UsuarioDao();
    Usuario usuario = new Usuario();

    public IniciarSesionC(IniciarSesionV iniciarSesionV) {
        this.iniciarSesionV = iniciarSesionV;
        this.iniciarSesionV.biniciarSesion.addActionListener(this);
        this.iniciarSesionV.ver.addActionListener(this);
        this.iniciarSesionV.bcancelar.addActionListener(this);
        this.iniciarSesionV.setExtendedState(6);
        this.iniciarSesionV.setVisible(true);
        this.iniciarSesionV.setDefaultCloseOperation(3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.iniciarSesionV.biniciarSesion) {
            String correo = this.iniciarSesionV.tcorreo.getText();
            String contrasena = this.iniciarSesionV.tcontrasena.getText();
            System.out.println(contrasena.length());
            if (this.iniciarSesion(correo, contrasena) == 1) {
                // empty if block
            }
        }
                if(e.getSource()==iniciarSesionV.bcancelar){
//            HotelV hotel = new HotelV();
//            HotelC hot = new HotelC(hotel);
            usuarioDao.buscarTarjeta(2);
        }
                if(iniciarSesionV.ver.isSelected()){
                    iniciarSesionV.tcontrasena.setEchoChar((char) 0);
                } else {
                    iniciarSesionV.tcontrasena.setEchoChar ('*');
                }
    }

    public int iniciarSesion(String correo, String contrasena) {
        List datosUsuario = this.usuarioDao.listar();
        int r = 0;
        for (int i = 0; i < datosUsuario.size(); ++i) {
            if (((Usuario)datosUsuario.get(i)).getCorreo().equals(correo) && ((Usuario)datosUsuario.get(i)).getContrasena().equals(contrasena)) {
                this.usuario = (Usuario)datosUsuario.get(i);
                System.out.println("Si puede pasar");
                r = 1;
                continue;
            }
            if (((Usuario)datosUsuario.get(i)).getCorreo().equals(correo)) {
                System.out.println("Contrasena incorrecta");
                continue;
            }
            System.out.println("No puede pasar");
        }
        return r;
    }
}

