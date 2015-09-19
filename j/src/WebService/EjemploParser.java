/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService; // nombre del paquete

import java.io.File; // librería requerida
import java.io.IOException; // librería requerida
import javax.swing.table.DefaultTableModel; // librería requerida
import javax.xml.parsers.DocumentBuilder; // librería requerida
import javax.xml.parsers.DocumentBuilderFactory; // librería requerida 
import javax.xml.parsers.ParserConfigurationException; // librería requerida Configuración parseo
import org.w3c.dom.Node; // librería requerida nodo
import org.w3c.dom.Document; // librería requerida documento
import org.w3c.dom.NodeList; // librería requerida nodo lista
import org.xml.sax.SAXException; // librería requerida excepción

/**
 *
 * @author Mau
 */
public class EjemploParser { // nombre de la clase
    NodeList nodosTitle; // atributo
    NodeList nodosArtist; // atributo

    /**
     * No recibe ningún argumento como entrada
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public  EjemploParser() throws ParserConfigurationException, SAXException, IOException{
        File fXmlFile = new File("archivo.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(fXmlFile);
        document.getDocumentElement().normalize();
        
         nodosTitle = document.getElementsByTagName("title"); // variable donde se obtiene el elemento por tag
         nodosArtist = document.getElementsByTagName("artist"); // variable donde se obtiene el elemento por tag 
        
        
        
    }

    /**
     * No recibe ningún parámetro como entrada
     * Método imprimimr 
     */
    public void imprimir(){
        for(int i=0;i<nodosTitle.getLength();i++){ // ciclo mientras el índice sea menos que el largo de los "nodosTitle" (tag)
                Node tNode = (Node) nodosTitle.item(i);
                Node aNode = (Node) nodosArtist.item(i);
                
                System.out.println("Nombre: "+tNode.getTextContent()+" Artista: "+aNode.getTextContent()); // Imprime en pantalla la información
        }
        
    }
    
}
