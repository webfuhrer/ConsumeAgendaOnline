/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteconsumidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Mañanas
 */
public class Conexion {

	public static String pedirXML(String datos_para_concatenar) {
            //datos_para_concatenar=accion=list
		// TODO Auto-generated method stub
		String url_txt="http://10.2.130.99:8084/ProductorAgendaOnline/ServletProductor"+datos_para_concatenar;
		String aux="";
		try {
			URL direccion=new URL(url_txt);
			URLConnection conexion_web = direccion.openConnection();
	        BufferedReader br = new BufferedReader(new InputStreamReader(conexion_web.getInputStream()));
	        String linea=br.readLine();
	        while(linea!=null)
	        {
	        	
	        	aux+=linea;
	        	linea=br.readLine();
	        }
	        br.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return aux;
	}

}
