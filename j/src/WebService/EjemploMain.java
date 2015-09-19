/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package WebService; // nombre del paquete

import java.io.IOException; // librería necesaria
import javax.xml.parsers.ParserConfigurationException; // librería necesaria
import org.xml.sax.SAXException; // librería necesaria

/**
 * Clase EjemploMmain
 * @author Mau
 */
public class EjemploMain { // nombre de la clase

    /**
     *
     * @param args
     * @throws ParserConfigurationException Excepción al hacer el parseo
     * @throws SAXException Excepción si no sirve 
     * @throws IOException Excepción sino sirve
     */
    public static void main(String [] args) throws ParserConfigurationException, SAXException, IOException{
        EjemploConexion service = new EjemploConexion(); // Establece conexión con el servidor. Instanciación clase
        XML parser = new XML(); // parseo, intanciación xml
        parser.imprimir(); // imprimir datos ya parseados
    }
    
}
