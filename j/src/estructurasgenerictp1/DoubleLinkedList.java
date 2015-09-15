/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package j;

/**
 *
 * @author Mau
 * @param <T>
 */
public class DoubleLinkedList <T> {
    
    private class Node <E> { // Clase nodo de  tipo E
        //atributos
        private E element; // Elemento de tipo E
        private Node<E> next; // Nodo de tipo E
        private Node<E> previous; // Nodo de tipo E
        
        public Node (){
            this.element=null; //nodo especial
            this.next=null;
            this.previous=null;
        }
        
        public Node (E element){ // nodo que recibe un elemento de tipo E
            this.element=element;
            this.next=null;
            this.previous=null;
        }
        
        public Node (E element, Node<E> previous, Node<E> next){ // nodo que recibe un elemento de tipo E, y dos punteros
            this.element=element;
            this.next=next; 
            this.previous=previous;
        }
        
        //métodos 
        public E getElement(){ // consultar un elemento
            return this.element;
        }
        
        public void setElement (E element){ // Actualiza un elemento. Por ser un void no se devuelve nada. Se recibe un elemento de tipo E como parámetro.
            this.element=element; 
            
        }
         public Node<E> getNext(){ // Obtener el siguiente elemento
            return this.next;
        }
        
        public void setNext (Node<E> next){ // Actualizar el siguiente elemento. Por ser un void no se devuelve nada. Se recibe un elemento de tipo E como parámetro.
            this.next=next; 
        }
        
        public Node<E> getPrevious(){ // Obtener el previo elemento
            return this.previous;
        }
        
        public void setPrevious (Node<E> previous){ // Actualizar el anterior elemento
            this.previous=previous;
        }
      
    }
    
    // atrtibutos
    
    private Node<T> head; // indica la cabeza del nodo
    private Node<T> current; // puntero actual del nodo
    private Node<T> tail; // indica la cola del nodo
    private int size; // indica el tamaño 
    private int pos; // indica la posición
    
    // constructores
    
    public DoubleLinkedList() { // nodo especial en el cual el current es igual al tail y a la cabeza
        this.head=new Node<T>();
        this.current=this.tail=this.head;
        this.pos=-1;
        this.size=0;
    }
    
    // métodos
    
    /**
     * Inserta un elemento. Crea un nuevo nodo para poderlo insertar en el current
     * @param element debe ser de tipo T
     */
        
    public void insert(T element){
        if(this.size==0){
          Node <T> temp=new Node <>(element,this.current,this.current.getNext());
          this.current.setNext(temp);
          this.tail=temp;
          size++;
        }
        else{
          Node <T> temp=new Node <>(element,this.current,this.current.getNext());
          this.current.setNext(temp);
          Node <T> temp1=temp.getNext();
          temp1.setPrevious(temp);
          if(this.current==this.tail){
              this.tail=temp;
          }
          size++;
        }
    }
    
    /**
     * Concatena un elemento en la lista doblemente enlazada. Se concatena al final.
     * @param element debe ser de tipo T
     */
    public void append(T element){
        Node temp=new Node <T>(element,this.tail,this.tail.getNext());
        this.tail.setNext(temp);
        this.tail=temp;
        size++;
    }
    
    /**
     * Obtiene el elemento
     * @return el elemento que está en el current
     */
    public T getElement(){
        return this.current.getElement();
    }
    
    /**
     * elimina un elemento
     */
    public void remove(){
        if(this.current==this.head){
            System.out.println("No es posible eliminar");
            return;
        }
        Node <T> temp=this.current.getPrevious();
        Node <T> temp1=this.current.getNext();
        temp.setNext(temp1);
        if(this.current==this.tail){
            this.current=this.tail=temp;
            size--;
        }
        else{
            temp1.setPrevious(temp);
            this.current=temp;
            size--;
        }
    }
    
    /**
     * Modifica el elemento
     * @param element de tipo T
     */
    public void updateElement(T element){
        this.current.setElement(element);
    }  
    
    /**
     * Vacía la lista
     */
    public void clear(){
        this.head=new Node<T>();
        this.current=this.tail=this.head;
        this.pos=-1;
        this.size=0;
    }
    
    /**
     *
     * @return ir al elemento siguiente
     */
    public Node <T> next(){
        this.current=this.current.getNext();
        pos++;
        return this.current;
    }
    
    /**
     *
     * @return ir al elemento anterior
     */
    public Node<T> previous(){
        this.current=this.current.getPrevious();
        pos--;
        return this.current;
    } 
    
    /**
     *
     * @return el tamaño
     */
    public int getSize(){
        return this.size;
    }
    
    /**
     *
     * @return la posición actual
     */
    public int getPos(){
        return this.pos;
    }
    
    /**
     * mover al principio de la lista
     */
    public void goToStart(){
        this.current=this.head;
        this.pos=-1;
    }
    
    /**
     * mover al final de la lista
     */
    public void goToEnd(){
        this.current=this.tail;
        this.pos=size-1;
    }
    
    /**
     *
     * @param args
     */
    public static void main(String [] args){
        DoubleLinkedList dll=new DoubleLinkedList();
        dll.insert(1);
        dll.insert(2);
        dll.insert(3);
        dll.insert(4);
        dll.append(5);
        dll.next();
        System.out.println(dll.getElement());
        System.out.println(dll.getSize());
        System.out.println(dll.getPos());
        dll.updateElement(7);
        System.out.println(dll.getElement());
        dll.goToEnd();
        dll.remove();
        dll.previous();
        System.out.println(dll.getElement());
        System.out.println(dll.getPos());
        dll.goToStart();
        dll.next();
        System.out.println(dll.getElement());
        dll.next();
        System.out.println(dll.getElement());
    }
}

