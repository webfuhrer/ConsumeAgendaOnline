/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteconsumidor;

import java.util.ArrayList;

/**
 *
 * @author Mañanas
 */
public class PintaHTML {
    public static String pintarTabla(ArrayList<Contacto> lista_contactos)
    {
        String tabla="<table>";
        tabla+="<tr><th>Nombre</th><th>Email</th></tr>";
        for (Contacto contacto : lista_contactos) {
            tabla+="<tr><td>"+contacto.getNombre()+"</td><td>"+contacto.getEmail()+"</td></tr>";
        }
        tabla+="</table>";
        return tabla;
    }
}
