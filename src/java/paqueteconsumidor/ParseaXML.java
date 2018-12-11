/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteconsumidor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Mañanas
 */
public class ParseaXML {

	public static Document convertirStringEnDocument(String xml) {
		// TODO Auto-generated method stub
		SAXBuilder builder=new SAXBuilder();
		InputStream stream;
		Document documento=null;
		try {
			stream = new ByteArrayInputStream(xml.trim().getBytes("UTF-8"));
			documento=builder.build(stream);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
				return documento;
	}
	public static ArrayList<Contacto> parsearXML(Document documento) {
		ArrayList<Contacto> lista=new ArrayList();
		Element elemento_raiz=documento.getRootElement();
                        List<Element> elementos_contacto=elemento_raiz.getChildren();
                        for (Element element : elementos_contacto) {
                            Element elemento_nombre=element.getChild("nombre");
                            Element elemento_email=element.getChild("email");
                            String nombre=elemento_nombre.getValue();
                            String email=elemento_email.getValue();
                            Contacto c=new Contacto(nombre, email);
                            lista.add(c);
            }
                        
                        return lista;
			
	}

}
