/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package index;

import controlador.IniciarSesionC;
import controlador.RegistrarC;
import vista.IniciarSesionV;
import vista.RegistrarV;

/**
 *
 * @author Usuario
 */



public class Index {
    public static void main(String[] args) {
        RegistrarV registrarV = new RegistrarV();
        RegistrarC registrarC = new RegistrarC(registrarV);

//        IniciarSesionV iniciarSesionV = new IniciarSesionV();
//        IniciarSesionC iniciarSesionC = new IniciarSesionC(iniciarSesionV);
    }
}
