/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package index;

import controlador.AlojamientosC;
import controlador.IniciarSesionC;
import controlador.RegistrarC;
import controlador.RegistrarHotelC;
import javax.swing.JFrame;
import vista.FotosV;
import controlador.FotosC;
import controlador.HotelC;
import controlador.MetodoDePagoC;
import controlador.TarjetaC;
import vista.AlojamientosV;
import vista.HotelV;
import vista.IniciarSesionV;
import vista.MetodoDePagoV;
import vista.RegistrarHotelV;
import vista.RegistrarV;
import vista.TarjetaV;

/**
 *
 * @author Usuario
 */
public class Index {

    public static void main(String[] args) {
//        RegistrarV registrarV = new RegistrarV();
//        RegistrarC registrarC = new RegistrarC(registrarV);

//        IniciarSesionV iniciarSesionV = new IniciarSesionV();
//        IniciarSesionC iniciarSesionC = new IniciarSesionC(iniciarSesionV);
//        HotelV hotel = new HotelV();
//        HotelC hot = new HotelC(hotel);
//    MetodoDePagoV mp = new MetodoDePagoV();
//    MetodoDePagoC mep = new MetodoDePagoC(mp);
        TarjetaV tarjetaV = new TarjetaV();
        TarjetaC tarjetaC = new TarjetaC(tarjetaV);

//       
//         RegistrarHotelV registrarHotelV = new RegistrarHotelV();
//        RegistrarHotelC registrarC = new RegistrarHotelC(registrarHotelV);
//Fotos fotos = new Fotos();
//FotosC fotosc = new FotosC(fotos); 
        AlojamientosV aloja = new AlojamientosV();
        AlojamientosC al = new AlojamientosC(aloja);
    }
}
