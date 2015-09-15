
package WebService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class EjemploConexion {
    public static void main(String[] args) throws MalformedURLException, IOException{
        // Para cambiar el tipo de búsqueda, solo cambia en el link lo que dice "artist" por "album" o "title"
        // lo que va después de los dos puntos, por ejemplo aquí metallica, es la busqueda ingresada.
        URL url = new URL("http://musicbrainz.org/ws/2/cdstub/?query=title:metallica");
        URLConnection connection = url.openConnection();
        
        BufferedReader reader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
        
        //Una vez realizada la búsqueda, 
        BufferedWriter out = new BufferedWriter(new FileWriter("archivo.xml"));
        out.write(reader.readLine());
        out.close();
    }
    
}
