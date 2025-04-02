package tudai.prog3.TP1.EJ1;


public class Main {

    public static void main(String[] args) {
	// Ejercicio 1
        MySimpleLinkedList<Integer> list = new MySimpleLinkedList<Integer>();
        MySimpleLinkedList<Integer> list1 = new MySimpleLinkedList<Integer>();
        MySimpleLinkedList<Integer> list2 = new MySimpleLinkedList<Integer>();
        MySimpleLinkedList<Integer> list3 = new MySimpleLinkedList<Integer>();
        MySimpleLinkedList<Integer> list4 = new MySimpleLinkedList<Integer>();
        MySimpleLinkedList<Integer> listComun = new MySimpleLinkedList<Integer>();
        MySimpleLinkedList<Integer> listComunOrdenada = new MySimpleLinkedList<Integer>();
        MySimpleLinkedList<Integer> listSinComunes = new MySimpleLinkedList<Integer>();

        // Verificamos si la lista está vacía
        System.out.println("¿La lista está vacía? " + list1.isEmpty());

        // Insertamos elementos en la lista
        list.insertFront(10);
        list.insertFront(50);
        list.insertFront(30);
        list.insertFront(20);
        list.insertFront(40);
        list.insertFront(60);

        list1.insertFront(10);
        list1.insertFront(50);
        list1.insertFront(30);
        list1.insertFront(20);
        list1.insertFront(40);
        list1.insertFront(60);

        list2.insertFront(110);
        list2.insertFront(30);
        list2.insertFront(70);
        list2.insertFront(90);
        list2.insertFront(10);
        list2.insertFront(50);

        list3.insertFront(10);
        list3.insertFront(20);
        list3.insertFront(30);
        list3.insertFront(40);
        list3.insertFront(50);
        list3.insertFront(60);

        list4.insertFront(10);
        list4.insertFront(30);
        list4.insertFront(50);
        list4.insertFront(70);
        list4.insertFront(90);
        list4.insertFront(110);

        /*Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            Integer i = it.next();
            System.out.println(i);
        }*/

        listComun.hacerListaComun(list1,list2);
        System.out.println("Lista generada por combinacion:");
        for(int i : listComun){
            System.out.println(i);
        }
        System.out.println("Fin de la Lista generada por combinacion");


        listComunOrdenada.hacerListaComunOrdenada(list3,list4);
        System.out.println("Lista generada por combinacion Ordenada:");
        for(int i : listComunOrdenada){
            System.out.println(i);
        }
        System.out.println("Fin de la Lista generada por combinacion Ordenada");

        listSinComunes.hacerListaSinComunes(list3,list4);
        System.out.println("Lista generada de elementos no duplicados:");
        for(int i : listSinComunes){
            System.out.println(i);
        }
        System.out.println("Fin de la Lista generada de elementos no duplicados");

        for(int i : list){
            System.out.println(i);
        }

        // Verificamos el índice de algunos elementos
        System.out.println("Índice de 20: " + list.indexOf(20)); // Debe retornar 1
        System.out.println("Índice de 40: " + list.indexOf(40)); // Debe retornar -1

        // Imprimimos el contenido de la lista
        System.out.println("Contenido de la lista: " + list.toString());

        // Verificamos el tamaño de la lista
        System.out.println("Tamaño de la lista: " + list.size());

        // Extraemos un elemento y lo imprimimos
        Integer extracted = list.extractFront();
        System.out.println("Elemento extraído: " + extracted);

        // Imprimimos el contenido de la lista después de la extracción
        System.out.println("Contenido de la lista después de extraer: " + list.toString());

        // Probamos el método get
        try {
            System.out.println("Elemento en índice 1: " + list.get(1));
            System.out.println("Elemento en índice 0: " + list.get(0));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Verificamos el tamaño de la lista nuevamente
        System.out.println("Tamaño de la lista después de la extracción: " + list.size());

        // Extraemos todos los elementos
        System.out.println("Extrayendo todos los elementos:");
        while (!list.isEmpty()) {
            System.out.println("Elemento extraído: " + list.extractFront());
        }

        // Verificamos si la lista está vacía después de las extracciones
        System.out.println("¿La lista está vacía después de extraer todos los elementos? " + list.isEmpty());


    }
}


/* Ejercicio 2
1- Lista Vinculada (MySimpleLinkedList):
Complejidad: O(1)
Razón: La operación de insertar un elemento al principio solo requiere ajustar el puntero del primer nodo a un nuevo nodo, lo cual es una operación constante.
Array (por ejemplo, ArrayList):
Complejidad: O(n)
Razón: Agregar un elemento al principio de un ArrayList implica desplazar todos los elementos existentes una posición hacia la derecha para hacer espacio para el nuevo elemento.

2- Lista Vinculada (MySimpleLinkedList):
Complejidad: O(n)
Razón: Se debe recorrer la lista desde el inicio hasta llegar al índice deseado, lo que puede tomar tiempo lineal en el peor de los casos.
Array (por ejemplo, ArrayList):
Complejidad: O(1)
Razón: Acceder a un elemento en una posición determinada en un ArrayList se puede hacer en tiempo constante, ya que se puede calcular la dirección de memoria a la que se necesita acceder directamente.

3- Lista Vinculada (MySimpleLinkedList):
Complejidad: O(n)
Razón: La implementación actual de size() recorre todos los nodos de la lista para contar cuántos hay. Si se implementara un contador que se actualiza con cada inserción y extracción, se podría hacer en O(1).
Array (por ejemplo, ArrayList):
Complejidad: O(1)
Razón: La mayoría de las implementaciones de ArrayList mantienen un contador interno que se actualiza automáticamente con cada inserción y eliminación, permitiendo acceder a este número en tiempo constante.

4- Lista Vinculada (MySimpleLinkedList):
Complejidad: O(n)
Razón: Para eliminar un nodo en una posición determinada, se necesita encontrar el nodo previo al que se quiere eliminar, lo que puede requerir recorrer la lista hasta esa posición.
Array (por ejemplo, ArrayList):
Complejidad: O(n)
Razón: Al igual que con la lista vinculada, eliminar un elemento en una posición específica requerirá desplazar todos los elementos después del índice eliminado hacia la izquierda para llenar el hueco, lo que también toma tiempo lineal.

 CONCLUSION:
Operación	                    MySimpleLinkedList	Array (ArrayList)
Insertar al principio	        O(1)	            O(n)
Buscar un elemento en pos.	    O(n)	            O(1)
Determinar cantidad de elem.	O(n)	            O(1)
Borrar un elemento en pos.	    O(n)	            O(n)
*/

