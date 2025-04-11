package tudai.prog3.TP2.EJ3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Ejercicio 3
        Implemente un algoritmo recursivo que convierta un número en notación decimal a su
        equivalente en notación binaria.
        */
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese un número

        System.out.print("Por favor, ingrese un número: ");
        // Leer el número ingresado (por ejemplo, un entero)
        int numero = scanner.nextInt();

        MySimpleLinkedList<Integer> list = convertDecimalToBinary(numero);

        System.out.println(list);

        System.out.print("Por favor, ingrese un número: ");
        int numero1 = scanner.nextInt();

        ArrayList list1 = fibonacci(numero1);

        System.out.println(list1);

        // Cerrar el scanner
        scanner.close();
    }

    //EJ3 CONVERTIR A BINARIO
    public static MySimpleLinkedList<Integer> convertDecimalToBinary(int numero) {
        MySimpleLinkedList<Integer> list = new MySimpleLinkedList<Integer>();

        if (numero == 0) {
            list.insertFront(0);
            return list;
        }

        while (numero > 0) {
            int resto = numero % 2;
            list.insertFront(resto);
            numero = numero / 2;
        }

        return list;
    }

    //EJ4 Fibonacci
    public static ArrayList fibonacci(int numero) {
        ArrayList list = new ArrayList(numero);

        if (numero <= 0) {
            return list; // Retorna lista vacía si el número no es positivo
        }

        // Inicializa los primeros dos números de la secuencia
        int aux1 = 0;
        int aux2 = 1;

        // Insertar el primer número de la secuencia
        list.add(aux1);

        // Si hay al menos un número más en la secuencia
        if (numero > 1) {
            list.add(aux2);
        }

        // Generar los siguientes números de Fibonacci
        for (int i = 2; i < numero; i++) {
            int num = aux1 + aux2;
            list.add(num);
            aux1 = aux2;
            aux2 = num;
        }
        return list;
    }
}
