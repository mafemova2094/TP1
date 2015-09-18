/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import estructurasgenerictp1.LinkedList2Argumentos;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;





/**
 *
 * @author Ricardo Araya
 */
public class XML {
    
    
    NodeList nodosTitle;
    NodeList nodosArtist;
    public  XML() throws ParserConfigurationException, SAXException, IOException{
        
    }
    
    public void Prueba() throws ParserConfigurationException, SAXException, IOException{
        File fXmlFile = new File("archivo.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(fXmlFile);
        document.getDocumentElement().normalize();
        
         nodosTitle = document.getElementsByTagName("title");
         nodosArtist = document.getElementsByTagName("artist");
    }
    
    public LinkedList2Argumentos imprimir(){
        LinkedList2Argumentos lista=new LinkedList2Argumentos<>();
        for(int i=0;i<nodosTitle.getLength();i++){
                Node tNode = (Node) nodosTitle.item(i);
                Node aNode = (Node) nodosArtist.item(i);
                String titulo=tNode.getTextContent();
                String artista=aNode.getTextContent();
                System.out.println("Titulo "+titulo+" Artista "+artista);
                lista.append(titulo,artista);
        }
        return lista;
    }
    
    
    public void obtenerXML(String eleccion, String banda) throws IOException{
        String bandaNueva = banda.replace(" ", "%20");
        String direc="http://musicbrainz.org/ws/2/cdstub/?query="+eleccion+":"+bandaNueva;
        URL url = new URL(direc);
        URLConnection connection = url.openConnection();
        
        BufferedReader reader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
        
        //Una vez realizada la búsqueda, 
        BufferedWriter out = new BufferedWriter(new FileWriter("archivo.xml"));
        out.write(reader.readLine());
        out.close();
    
    }
    
    
    public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException{
        XML h=new XML();
        h.obtenerXML("artist", "Ricardo Arjona");
        h.Prueba();
        h.imprimir();
        
    }
}
