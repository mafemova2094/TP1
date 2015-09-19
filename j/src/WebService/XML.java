/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService; // nombre del paquete

import estructurasgenerictp1.LinkedList2Argumentos; // importación de la linkedList 
import java.io.File; // librería requerida para entrada y salida de archivos
import javax.xml.parsers.DocumentBuilder; // librería requerida para la contrucción de documentos parseados
import javax.xml.parsers.DocumentBuilderFactory; // librería requerida para la contrucción de documentos parseados
import javax.xml.parsers.ParserConfigurationException; // librería requerida para la contrucción de documentos parseados
import org.w3c.dom.Node; // librería requerida
import org.w3c.dom.Document; // librería requerida
import org.w3c.dom.NodeList; // librería requerida
import org.xml.sax.SAXException; // librería requerida

import java.io.BufferedReader; // librería requerida
import java.io.BufferedWriter; // librería requerida
import java.io.FileWriter; // librería requerida
import java.io.IOException; // librería requerida
import java.io.InputStreamReader; // librería requerida entrada del StreamReader
import java.net.URL; // librería requerida para manejo de URL en Java
import java.net.URLConnection; // librería requerida para concetarse con el servidor





/**
 *
 * @author Ricardo Araya
 */
public class XML { // nombre de la clase
    
    
    NodeList nodosTitle; // atributo de tipo NodeList
    NodeList nodosArtist; // atributo de tipo NodeList

    /**
     * Entrada: No recibe ningún parámetro como entrada
     * Restricciones:
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public  XML() throws ParserConfigurationException, SAXException, IOException{
        
    }
    
    /**
     * Entrada: No recibe ningún parámetro como entrada
     * Restricciones:
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public void Prueba() throws ParserConfigurationException, SAXException, IOException{
        File fXmlFile = new File("archivo.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(fXmlFile);
        document.getDocumentElement().normalize();
        
         nodosTitle = document.getElementsByTagName("title");
         nodosArtist = document.getElementsByTagName("artist");
    }
    
    /**
     * Entrada: No recibe ningún parámetro como entrada
     * @return una lista de tipo LinkedList2Argumentos 
     */
    public LinkedList2Argumentos imprimir(){ // imprimir nombre del método el cuañ reotna una lista con los datos 
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
    
    /**
     * Entradas:
     * @param eleccion de tipo Str
     * @param banda de tipo Str
     * restricción: @throws IOException
     * 
     * Por ser un void no retorna nada
     *
     */
    public void obtenerXML(String eleccion, String banda) throws IOException{ // obtenerXML es el nombre de la funcióon que no devuelve nada
        String bandaNueva = banda.replace(" ", "%20");
        String direc="http://musicbrainz.org/ws/2/cdstub/?query="+eleccion+":"+bandaNueva;
        URL url = new URL(direc); // instanciación URL
        URLConnection connection = url.openConnection();
        
        BufferedReader reader= new BufferedReader(new InputStreamReader(connection.getInputStream())); // instanciación reader
        
        //Una vez realizada la búsqueda, 
        BufferedWriter out = new BufferedWriter(new FileWriter("archivo.xml")); // instanciación out
        out.write(reader.readLine());
        out.close();
    
    }
    
    /**
     * Entrada:
     * @param args
     * Restricciones:
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * Prueba de los métodos de arriba
     */
    public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException{
        XML h=new XML();
        h.obtenerXML("artist", "Ricardo Arjona");
        h.Prueba();
        h.imprimir();
        
    }
}
