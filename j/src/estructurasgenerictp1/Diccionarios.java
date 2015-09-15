/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estructurasgenerictp1;

import java.util.ArrayList;

/**
 *
 * @author Mau
 * @param <N> llave
 * @param <R> valor
 * @param <A> artista
 * @param <Al> album
 * @param <G> genero
 * @param <D> duracion 
 */
public class Diccionarios <N,R,A,Al,G,D> extends LinkedList <N>{
    
    /**
     * Clase Entry genérico de tipo
     * @param <N> nombre
     * @param <R> ruta
     * @param <A> artista
     * @param <Al> album
     * @param <G> genero
     * @param <D> duracion
     */
    
    private class Entry <N,R,A,Al,G,D>{ 
        
        //atributos
        
        private N nombre;
        private R ruta;
        private A artista;
        private Al album;
        private G genero;
        private D duracion;
        
        //constructor, sólo uno, el cual recibe obligatoriamente dos parámetros
        public Entry(N nombre,R ruta, A artista, Al album, G genero, D duracion){
            this.nombre=nombre;
            this.ruta=ruta;
            this.artista=artista;
            this.album=album;
            this.genero=genero;
            this.duracion=duracion;
        }
        
        //métodos
        
        //Set y Get por cada atributo
        /**
         * Obtiene el nombre
         * @return el nombre de tipo N
         */
        public N getNombre(){
            return this.nombre;
        }
        
        /**
         * Actualiza el nombre
         * @param nombre de tipo N
         */
        public void setNombre(N nombre){
            this.nombre=nombre;
        }
        
        /**
         * Obtiene la ruta
         * @return ruta de tipo R
         */
        
        public R getRuta(){
            return this.ruta;
        }
        
        /**
         * Actualiza la ruta
         * @param ruta de tipo R
         */
        
        public void setRuta(R ruta){
            this.ruta=ruta;
        }
        
        /**
         * Obtiene el artista
         * @return artista de tipo A
         */
        
        public A getArtista(){
            return this.artista;
        }
        
        /**
         * Actualiza el artista
         * @param artista de tipo A 
         */
        
        public void setArtista(A artista){
            this.artista=artista;
        }
        
        /**
         * Obtiene el album 
         * @return album de tipo A
         */
        
        public Al getAlbum(){
            return this.album;
        }
        
        /**
         * Actualiza el album
         * @param album  de tipo Al
         */
        
        public void setAlbum(Al album){
            this.album=album;
        }
        
        /**
         * Obtiene el genero 
         * @return genero de tipo G
         */
        
        public G getGenero(){
            return this.genero;
        }
        
        /**
         * Actualiza el genero
         * @param genero de tipo G
         */
        
        public void setGenero(G genero){
            this.genero=genero;
        }
        
        /**
         * Obtiene la duración
         * @return duracion de tipo D
         */
        
        public D getDuracion(){
            return this.duracion;
        }
        
        /**
         * Actualiza la duración 
         * @param duracion de tipo D
         */
        
        public void setDuracion(D duracion){
            this.duracion=duracion;
        }
        
       
    }
    
    //atributos
    private int size;
    private LinkedList <Entry<N,R,A,Al,G,D>> listaEnlazada = new LinkedList<Entry<N,R,A,Al,G,D>>(); // Inicializa una LinkedList 
    
    //constructor 
    
    public Diccionarios (){
      this.size=0;
    }
    
    //métodos
    
    /**
     * Inserta un nuevo registro (entry). Recibe los siguientes parámetros
     * @param nombre de tipo N
     * @param ruta de tipo R
     * @param artista de tipo A
     * @param album de tipo Al
     * @param genero de tipo G
     * @param duracion de tipo D
     * @return la ruta
     */
    
    public R put(N nombre, R ruta, A artista, Al album, G genero, D duracion){
        listaEnlazada.goToStart();
        listaEnlazada.next();
        while (listaEnlazada.getPos() < listaEnlazada.getSize()) {
            if (listaEnlazada.getElement().getNombre()==nombre && listaEnlazada.getElement().getArtista()==artista) {
                return listaEnlazada.getElement().getRuta();
            } 
            else {
                listaEnlazada.next();
            }
        }
        Entry temp = new Entry(nombre, ruta, artista, album, genero, duracion);
        listaEnlazada.append(temp);
        size++;
        return ruta;  
    }
    
    public R getRuta(){
        if (listaEnlazada.getPos()<listaEnlazada.getSize()-1){
            listaEnlazada.next();
            System.out.println(listaEnlazada.getPos()+"AAAAAAA");
            System.out.println(listaEnlazada.getSize()+"ZZZZ");
            System.out.println(listaEnlazada.getElement().getRuta());
            return listaEnlazada.getElement().getRuta();
        }
        else{
            listaEnlazada.previous();
            return listaEnlazada.getElement().getRuta();
        }
        
        
        
    }
    
    
    
    
    /**
     * 
     * @param nombre de tipo N
     * @return la ruta asociada con la canción y sino existe, null.
     */
    
    public R get(N nombre){
        listaEnlazada.goToStart();
        listaEnlazada.next();
        while (listaEnlazada.getPos() < listaEnlazada.getSize()) {
            if (listaEnlazada.getElement().getNombre() == nombre) {
                return listaEnlazada.getElement().getRuta();
            } 
            else {
                listaEnlazada.next();
            }
        }
        return null;
    }
    
    /**
     * 
     * @param nombre
     * @return Elimina el registro asociado a la canción si existe, y retorna la ruta
     */
    
    public R remove(N nombre){
        listaEnlazada.goToStart();
        listaEnlazada.next();
        while (listaEnlazada.getPos() < listaEnlazada.getSize()) {
            if (listaEnlazada.getElement().getNombre() == nombre) {
                R temp=listaEnlazada.getElement().getRuta();
                listaEnlazada.remove();
                size--;
                return temp;
            } 
            else {
                listaEnlazada.next();
            }
        }
        return null;
    }
    
    /**
     * 
     * @return Retorna una colección con todas las canciones en el map
     */
    
    public ArrayList nombreSet(){
        ArrayList temp=new ArrayList<N>();
        listaEnlazada.goToStart();
        listaEnlazada.next();
        while (listaEnlazada.getPos() < listaEnlazada.getSize()){
            temp.add(listaEnlazada.getElement().getNombre());
            listaEnlazada.next();
        }
        return temp;
    }
    
    /**
     * 
     * @return  Retorna una colección con todas las rutas en el map
     */
    
    public ArrayList rutaSet(){
        ArrayList temp=new ArrayList<N>();
        listaEnlazada.goToStart();
        listaEnlazada.next();
        while (listaEnlazada.getPos() < listaEnlazada.getSize()){
            temp.add(listaEnlazada.getElement().getRuta());
            listaEnlazada.next();
        }
        return temp;
    }
    
    /**
     * 
     * @return  Retorna una colección con todas las artistas en el map
     */
    public ArrayList artistaSet(){
        ArrayList temp=new ArrayList<N>();
        listaEnlazada.goToStart();
        listaEnlazada.next();
        while (listaEnlazada.getPos() < listaEnlazada.getSize()){
            temp.add(listaEnlazada.getElement().getArtista());
            listaEnlazada.next();
        }
        return temp;
    }
    
    /**
     * 
     * @return  Retorna una colección con todos los albumes en el map
     */
    
    public ArrayList albumSet(){
        ArrayList temp=new ArrayList<N>();
        listaEnlazada.goToStart();
        listaEnlazada.next();
        while (listaEnlazada.getPos() < listaEnlazada.getSize()){
            temp.add(listaEnlazada.getElement().getAlbum());
            listaEnlazada.next();
        }
        return temp;
    }
    
    /**
     * 
     * @return  Retorna una colección con todos los generos en el map
     */
    
    public ArrayList generoSet(){
        ArrayList temp=new ArrayList<N>();
        listaEnlazada.goToStart();
        listaEnlazada.next();
        while (listaEnlazada.getPos() < listaEnlazada.getSize()){
            temp.add(listaEnlazada.getElement().getGenero());
            listaEnlazada.next();
        }
        return temp;
    }
    
    /**
     * 
     * @return  Retorna una colección con todas las duraciones en el map
     */
    
    public ArrayList duracionSet(){
        ArrayList temp=new ArrayList<N>();
        listaEnlazada.goToStart();
        listaEnlazada.next();
        while (listaEnlazada.getPos() < listaEnlazada.getSize()){
            temp.add(listaEnlazada.getElement().getDuracion());
            listaEnlazada.next();
        }
        return temp;
    }
    
    /**
     * 
     * @return Regresa el número de registros en el diccionario
     */
    
    public int size(){
        return this.size;
    }
    
    /**
     * 
     * @return booleano si está vacío o no 
     */
    
    public boolean isEmpty(){
        if(listaEnlazada.isEmpty()==true){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * vacía el diccionario
     */
    
    public void clear(){
        this.size=0;
        LinkedList <Entry<N,R,A,Al,G,D>> temp = new LinkedList<Entry<N,R,A,Al,G,D>>();
        this.listaEnlazada=temp;
    }
    
    /**
     * 
     * @return Regresa una colección que contiene todos los registros (canción,ruta)
     */
    
    public ArrayList entrySet(){
        ArrayList temp= new ArrayList();
        listaEnlazada.goToStart();
        listaEnlazada.next();
        while (listaEnlazada.getPos() < listaEnlazada.getSize()){
            temp.add(listaEnlazada.getElement());
            listaEnlazada.next();
        }
        return temp;
    }
    
     public static void main(String[]args){
        Diccionarios dicc=new Diccionarios();
        System.out.println(dicc.put("1", "2","3","5","4","6"));
        System.out.println(dicc.put("12", "11","7","8","9","0"));
        
        
        System.out.println("**************");
        //System.out.println(dicc.get(3));
        
        System.out.println(dicc.nombreSet());
        
        System.out.println(dicc.getPos());
        dicc.next();
        System.out.println(dicc.getPos());
        System.out.println(dicc.getRuta());
        System.out.println(dicc.getPos());
        System.out.println(dicc.size());
        
        System.out.println(dicc.size());
    }
    
}


