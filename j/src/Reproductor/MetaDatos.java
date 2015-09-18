package Reproductor;
//Librerias de uso
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.images.Artwork;

/**
 *
 * @author Mau
 */
public class MetaDatos
{
    private String Artista,Album,Titulo,year,BPM,genero,ruta,rutaI=null;
    private Artwork portada;
    private int duracion;
    Tag tag;

    /**
     * Constructor
     */
    public MetaDatos(){
        
    } 

    /**
     * Métodos
     * @param ruta obtener datos de artista, título, género,... 
     */
    public void meta(String ruta){
        this.ruta = ruta;

        File cancion = new File(ruta);
        try {
            AudioFile audioFile = AudioFileIO.read(cancion); // lee la canción
            duracion = audioFile.getAudioHeader().getTrackLength(); //toma el largo de la cnación (duración)
            tag = audioFile.getTag();

        } catch (Exception e) {
            e.printStackTrace();

        }
         try{
                Artista=tag.getFirst(FieldKey.ARTIST); // toma los datos del artista
                if(Artista.equals("")){           // si el artista es igual lo pone desconocido
                        Artista="Desconocido";
                    }
                }catch(KeyNotFoundException e){}
                try{                                 
                    Album=tag.getFirst(FieldKey.ALBUM); // toma los datos del álbum
                    if(Album.equals("")){               // si el album es igual lo pone desconocido
                        Album="Desconocido";
                    }
                }
                catch(KeyNotFoundException e){
                }
                try{Titulo=tag.getFirst(FieldKey.TITLE);      // toma los datos del título
                    if(Titulo.equals("")){                     // si el título de la canción es igual lo pone desconocido
                        Titulo="Desconocido";
                    }
                }
                catch(KeyNotFoundException e){
                }
                try{
                    genero=tag.getFirst(FieldKey.GENRE); // toma los datos del género
                    //System.out.println(genero);
                    if(genero.equals("")||genero.equals("Género desconocido")){ // si el género de la canción es igual lo pone desconocido
                        genero="Desconocido";
                    }
                }catch(KeyNotFoundException e){
                }
                try{
                    BPM = tag.getFirst(FieldKey.FBPM);
                 }
                catch(KeyNotFoundException e){
                }
                 try{portada=tag.getFirstArtwork();
                 
        }
        catch(KeyNotFoundException e){
        }
    }

    /**Función que guarda la imagen 
     *
     */
    public void guardarImagen(){ // método que guarda la imagen 
    try{                         
                InputStream RecibirDatos =new ByteArrayInputStream(portada.getBinaryData()); 
                BufferedImage bImageFromConvert = ImageIO.read(RecibirDatos);
                int w = bImageFromConvert.getWidth();
                int h = bImageFromConvert.getHeight();
                BufferedImage bufim = new BufferedImage(300, 300, bImageFromConvert.getType());
                Graphics2D g = bufim.createGraphics();
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g.drawImage(bImageFromConvert, 0, 0, 300, 300, 0, 0, w, h, null);
                g.dispose();
                rutaI=ruta+".jpg";
                File JPG=new File(rutaI);
                
                ImageIO.write(bufim,"jpg",JPG);
                
                
        
                }catch(Exception e){
                    this.rutaI=null;    
                }
    }

    /**
     *
     * @return Obtiene la ruta de la imagen
     */
    public String getImagen(){
    return this.rutaI;
    }

    /**
     *
     * @return Obtiene el artista de la canción
     */
    public String getArtista(){
    return this.Artista;
    }

    /**
     *
     * @return Obtiene el título de tipo de String
     */
    public String getTitulo(){
    return this.Titulo;
    }

    /**
     *
     * @return Obtiene el álbum de la canción de tipo String
     */
    public String getAlbum(){
    return this.Album;
    }

    /**
     *
     * @return Obtiene la duración de la canción (de tipo int)
     */
    public int getduracion(){
    return duracion;
    }

    /**
     *
     * @return transforma la duración en minutos
     */
    public double getduracionMin(){
    return duracion/60;
    }

    /**
     *
     * @return Obtiene el género de tipo String
     */
    public String getgenero(){
    return this.genero;
    }

    /**
     *
     * @param m Recibe como parámetro un m de tipo String y actualiza el título
     */
    public void setTitulo(String m){
    this.Titulo=m;
    }

    /**
     *
     * @param artista Recibe como parámetro un artiste de tipo String y actualiza el artista si se modifica
     */
    public void setArtista(String artista){
    this.Artista=artista;
    }
   
    /**
     *
     * @param args Prueba 
     */
    public static void main(String args[]){
        
        MetaDatos h=new MetaDatos();
        
        h.meta("C:\\Users\\Ricardo Araya\\Documents\\celular\\celular09-10-14\\card\\musica\\Ricardo Arjona\\Ricardo Arjona1\\desnuda.mp3");
        System.out.println(h.getArtista());
        System.out.println(h.getAlbum());
        System.out.println(h.getTitulo());
        System.out.println(h.getduracion());
        System.out.println(h.getduracionMin());
        System.out.println(h.getgenero());
        
    }
    
   
}