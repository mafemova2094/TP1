/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estructurasgenerictp1;

/**
 * Clase ArrayList
 * @author Mau
 */
public class ArrayList { // clase ArrayList
    
    private Object[] elements; // atributo elements de tipo Object
    private int max; // atributo max de tipo int
    private int size; // atributo size de tipo int
    private int pos; // atributo pos de tipo int

    /**
     *
     * @param max Recibe como entrada un parámetro max de tipop int
     */
    
    // constructor
    public ArrayList (int max) { // arreglo especial 
        this.elements = new Object[max]; // instanciación
        this.max = max; // máximo del arreglo
        this.size = 0; // size en 0
        this.pos = 0; // pos en 0
    }

    /*
     * Los elementos se almacenan en posiciones contiguas, por lo tanto para insertar en medio de
     * elementos deben moverse los elementos para crear un espacio.
     * Al insertar en la posición i, deben moverse n-1 elementos.
     */

    /**
     * Entrada:
     * @param element de tipo Object
     * Al ser void no retorna nada
     * Restricciones: si size==max del arreglo retornar "List is full"
     */
    
    
    public void insert(Object element) { // inserta el elemento en pos
        if (this.size == this.max){ // restricción
            System.out.println("List is full");
            return;
        }

        for (int i = this.size; i > this.pos; i--){
            this.elements[i] = this.elements[i - 1];
        }

        this.elements[this.pos] = element;
        this.size++;
    }

    /**
     * Entrada: 
     * @param element de tipo Object
     * Salidas: por ser un void no devuelve nada
     * Restricciones: si size==max del arreglo retornar "List is full"
     */
    
    public void append(Object element){ // agrega el elemento al final del arreglo
        if (this.size == this.max){
            System.out.println("List is full");
            return;
        }

        this.elements[this.size] = element;
        this.size++;
    }

    /**
     * No recibe ningún parámetro como entrada
     * Salidas: por ser un void no devuelve nada
     * Restricciones: si size==0 del arreglo retornar "List is empty"
     */
    
    public void remove(){ // eliminar un elemento de acuerdo a la posición
        if (this.size == 0){
            System.out.println("List is empty");
            return;
        }

        if (this.pos < 0 || this.pos >= this.size) {
            System.out.println("Index out of bounds");
            return;
        }

        for (int i = this.pos; i < this.size -1; i++){
            this.elements[i] = this.elements[i + i];
        }

        this.size--;
    }

    /**
     * Salidas: por ser un void no devuelve nada
     * No recibe ningún parámetro como entrada
     */
    public void clear() {
        this.elements = new Object[this.max];
        this.size = 0;
        this.pos = 0;

    }

    /**
     * No recibe ningún parámetro como entrada
     * @return Consulta un elemento 
     */
    public Object getElement(){
        if (this.pos < 0 || this.pos >= this.size) {
            System.out.println("Index out of bounds");
            return null;
        }

        return this.elements[this.pos];
    }

    /**
     * Ir al inicio 
     * No recibe ningún parámetro como entrada
     * Por ser void no devuelve nada
     */
    public void goToStart(){
        this.pos = 0;
    }

    /**
     * Ir al dinal
     * No recibe ningún parámetro como entrada
     * Por ser void no devuelve nada 
     */
    public void goToEnd(){
        this.pos = this.size - 1;
    }

    /**
     * Por ser void no devuelve nada
     * Ir a una posición determinada
     * @param pos de tipo int
     */
    public void goToPos(int pos){
        if (pos < 0 || pos >= this.size) {
            System.out.println("Index out of bounds");
            return;
        }
        this.pos = pos;
    }

    /**
     * No recibe ningún parámetro como entrada
     * Por ser un void no devuelve nada
     * Ir a la posición anterior
     */
    public void previous() {
        if (this.pos > 0) {
            this.pos--;
        }
    }

    /**
     * No recibe ningún parámetro como entrada
     * Por ser un void no devuelve nada
     * Ir a la posición siguiente
     */
    public void next(){
        if (this.pos < this.size) {
            pos++;
        }
    }

    /**
     * No recibe ningún parámetro como entrada
     * @return Consulta la posición devuelve pos de tipo int 
     */
    public int getPos() {
        return this.pos;
    }

    /**
     * No recibe ningún parámetro como entrada
     * @return Consulta el tamaño devuelve size de tipo int 
     */
    public int getSize(){
        return this.size;
    }
    
    public String toString(){
        String result = "";
        for(int i = 0; i < this.size; i++){
            result+= " " + this.elements[i].toString();
        }
        return result;
    }

    /**
     * Prueba de los métodos anteriores
     * @param args
     */
    public static void main(String[] args) {
        ArrayList list = new ArrayList(10);
        list.append(5);
        list.insert(7);
        System.out.println(list.toString());
        list.goToStart();
        list.insert(8);
        System.out.println(list.toString());
        list.next();
        list.remove();
        System.out.println(list.toString());
        list.insert(10);
        System.out.println(list.toString());

        System.out.println("Recorrer la lista ***");
        //recorrer la lista
        for (list.goToStart(); list.getPos() < list.getSize(); list.next()){
            System.out.println("Elemento #" + list.getPos() + ", valor: " + list.getElement());
        }
    }
    
    
}
