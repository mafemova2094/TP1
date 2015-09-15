/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reproductor;
import java.io.*;
/**
 *
 * @author Ricardo Araya
 */
public class CopiarArchivos {
 
        public void copy(File src, File dst) throws IOException { 
            InputStream in = new FileInputStream(src); 
            OutputStream out = new FileOutputStream(dst); 


            byte[] buf = new byte[1024]; 
            int len; 
            while ((len = in.read(buf)) > 0) { 
                out.write(buf, 0, len); 
            } 
            in.close(); 
            out.close(); 
        }
    

    
        
        
        
    public static void main(String args[]) throws Exception{
        
        File canci = new File("/home/ricardoara07/Documentos/Ricardo_Arjona1/desnuda.mp3");
        
        File ruta = new File("/home/ricardoara07/Música/Ricardo/");
        System.out.println(ruta.isDirectory());
        System.out.println(ruta.setReadable(true));
        System.out.println(ruta.exists());
        System.out.println(ruta.getPath());
        System.out.println(ruta.canWrite());
        System.out.println(canci.isFile());
        CopiarArchivos h=new CopiarArchivos();
        
        
        
        
        
        File dir = new File("Hola");
        dir.mkdir();
        
        File file = new File("Hola\\desnuda.mp3");
        
        h.copy(new File("C:\\Users\\Ricardo Araya\\Documents\\celular\\celular09-10-14\\card\\musica\\Ricardo Arjona\\Ricardo Arjona1\\desnuda.mp3"),new File("Hola\\desnuda.mp3"));
        
        Thread.sleep(9000);
        
        file.delete();
                
                
                
                
    }   
}
