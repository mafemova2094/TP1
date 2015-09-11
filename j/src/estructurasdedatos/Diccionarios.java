/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estructurasdedatos;

import java.util.ArrayList;

/**
 *
 * @author Mau
 * @param <K> llave
 * @param <V> valor
 */
public class Diccionarios <K,V> extends LinkedList <K>{
    
    private class Entry <K,V>{
        //atributos
        
        private K key;
        private V value;
        
        //constructor, sólo uno, el cual recibe obligatoriamente dos parámetros
        public Entry(K key,V value){
            this.key=key;
            this.value=value;
        }
        
        //métodos
        public K getKey(){
            return this.key;
        }
        
        public void setKey(K key){
            this.key=key;
        }
        
        public V getValue(){
            return this.value;
        }
        
        public void setValue(V value){
            this.value=value;
        }
       
    }
    
    //atributos
    private int size;
    private LinkedList <Entry<K,V>> listaEnlazada = new LinkedList<Entry<K,V>>();
    
    //constructor 
    
    public Diccionarios (){
      this.size=0;
    }
    
    //métodos
    
    public V put(K key, V value){
        listaEnlazada.goToStart();
        listaEnlazada.next();
        while (listaEnlazada.getPos() < listaEnlazada.getSize()) {
            if (listaEnlazada.getElement().getKey()==key) {
                listaEnlazada.getElement().setValue(value);
                return listaEnlazada.getElement().getValue();
            } 
            else {
                listaEnlazada.next();
            }
        }
        Entry temp = new Entry(key, value);
        listaEnlazada.append(temp);
        size++;
        return value;  
    }
    
    public V get(K key){
        listaEnlazada.goToStart();
        listaEnlazada.next();
        while (listaEnlazada.getPos() < listaEnlazada.getSize()) {
            if (listaEnlazada.getElement().getKey() == key) {
                return listaEnlazada.getElement().getValue();
            } 
            else {
                listaEnlazada.next();
            }
        }
        return null;
    }
    
    public V remove(K key){
        listaEnlazada.goToStart();
        listaEnlazada.next();
        while (listaEnlazada.getPos() < listaEnlazada.getSize()) {
            if (listaEnlazada.getElement().getKey() == key) {
                V temp=listaEnlazada.getElement().getValue();
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
    
    public String keySet(){
        String temp="";
        listaEnlazada.goToStart();
        listaEnlazada.next();
        while (listaEnlazada.getPos() < listaEnlazada.getSize()){
            temp=temp+listaEnlazada.getElement().getKey();
            listaEnlazada.next();
        }
        return temp;
    }
    
    public String values(){
        String temp="";
        listaEnlazada.goToStart();
        listaEnlazada.next();
        while (listaEnlazada.getPos() < listaEnlazada.getSize()){
            temp=temp+listaEnlazada.getElement().getValue();
            listaEnlazada.next();
        }
        return temp;
    }
    
    public int size(){
        return this.size;
    }
    
    public boolean isEmpty(){
        if(listaEnlazada.isEmpty()==true){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void clear(){
        this.size=0;
        LinkedList <Entry<K,V>> temp = new LinkedList<Entry<K,V>>();
        this.listaEnlazada=temp;
    }
    
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
        System.out.println(dicc.put(1, "Hola soy Fer"));
        System.out.println(dicc.put(2, "Hola, qué haces?"));
        System.out.println(dicc.put(3, "Qué sueño verdad?")); 
        System.out.println(dicc.put(4, "Sí, demasiado"));
        System.out.println("**************");
        System.out.println(dicc.get(3));
        System.out.println(dicc.remove(1));
        System.out.println(dicc.keySet());
        System.out.println(dicc.values());
        System.out.println(dicc.size());
        System.out.println(dicc.isEmpty());
        System.out.println(dicc.put(3, "Demasiado sueño, verdad?"));
        System.out.println(dicc.entrySet());
        dicc.clear();
        System.out.println(dicc.size());
    }
}


