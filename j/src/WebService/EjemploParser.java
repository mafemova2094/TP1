/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import java.io.File;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author jpfcr8
 */
public class EjemploParser {
    NodeList nodosTitle;
    NodeList nodosArtist;
    public  EjemploParser() throws ParserConfigurationException, SAXException, IOException{
        File fXmlFile = new File("archivo.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(fXmlFile);
        document.getDocumentElement().normalize();
        
         nodosTitle = document.getElementsByTagName("title");
         nodosArtist = document.getElementsByTagName("artist");
        
        
        
    }
    public void imprimir(){
        for(int i=0;i<nodosTitle.getLength();i++){
                Node tNode = (Node) nodosTitle.item(i);
                Node aNode = (Node) nodosArtist.item(i);
                
                System.out.println("Nombre: "+tNode.getTextContent()+" Artista: "+aNode.getTextContent());
        }
        
    }
    
}
