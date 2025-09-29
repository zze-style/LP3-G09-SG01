package Actividades;

class InvalidSubscriptException extends RuntimeException {
    public InvalidSubscriptException(String mensaje) {
        super(mensaje);
    }
}

public class PruebaMetodoGenerico {

    public static <E> void imprimirArreglo(E[] arregloEntrada) {
        System.out.println("-> Versión ORIGINAL (arreglo completo):");
        for (E elemento : arregloEntrada) {
            System.out.printf("%s ", elemento);
        }
        System.out.println();
    }
    

    public static <E> int imprimirArreglo(E[] arregloEntrada, int subindiceInferior, int subindiceSuperior) 
            throws InvalidSubscriptException {
        
        int tamanoArreglo = arregloEntrada.length;

        if (subindiceInferior < 0 || subindiceInferior >= tamanoArreglo) {
            throw new InvalidSubscriptException(
                    "ERROR: subindiceInferior (" + subindiceInferior + ") está fuera del rango [0, " + (tamanoArreglo - 1) + "].");
        }
        if (subindiceSuperior < 0 || subindiceSuperior >= tamanoArreglo) {
             throw new InvalidSubscriptException(
                    "ERROR: subindiceSuperior (" + subindiceSuperior + ") está fuera del rango [0, " + (tamanoArreglo - 1) + "].");
        }
        
        if (subindiceSuperior <= subindiceInferior) {
            throw new InvalidSubscriptException(
                    "ERROR: subindiceSuperior (" + subindiceSuperior + ") debe ser mayor que subindiceInferior (" + subindiceInferior + ").");
        }
        
        System.out.printf("-> Versión SOBRECARGADA (índices %d a %d):%n", subindiceInferior, subindiceSuperior);
        
        for (int i = subindiceInferior; i <= subindiceSuperior; i++) {
            System.out.printf("%s ", arregloEntrada[i]);
        }
        System.out.println();
        
        return (subindiceSuperior - subindiceInferior) + 1;
    }
    public static void main(String args[]) {

        Integer[] arregloInteger = { 1, 2, 3, 4, 5, 6 };
        Double[] arregloDouble = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
        Character[] arregloCharacter = { 'H', 'O', 'L', 'A' };

        System.out.println("==========================================");
        System.out.println("PRUEBA con arregloInteger (tamaño: " + arregloInteger.length + ")");
        System.out.println("==========================================");

        System.out.println("El arreglo arregloInteger contiene:");
        imprimirArreglo(arregloInteger);
        
        System.out.println("\n--- Casos Válidos ---");
        try {
            int impresos = imprimirArreglo(arregloInteger, 1, 4);
            System.out.println("Elementos impresos: " + impresos);
            
            impresos = imprimirArreglo(arregloInteger, 0, 5);
            System.out.println("Elementos impresos: " + impresos);
            
        } catch (InvalidSubscriptException e) {
            System.err.println("Excepción capturada: " + e.getMessage());
        }

        System.out.println("\n--- Casos Inválidos (Prueba de Excepción) ---");

        try {
            imprimirArreglo(arregloInteger, -1, 4); 
        } catch (InvalidSubscriptException e) {
            System.err.println("Excepción capturada: " + e.getMessage());
        }

        try {
            imprimirArreglo(arregloInteger, 1, 6); 
        } catch (InvalidSubscriptException e) {
            System.err.println("Excepción capturada: " + e.getMessage());
        }
        
        try {
            imprimirArreglo(arregloInteger, 4, 4);
        } catch (InvalidSubscriptException e) {
            System.err.println("Excepción capturada: " + e.getMessage());
        }
        
        try {
            imprimirArreglo(arregloInteger, 5, 3);
        } catch (InvalidSubscriptException e) {
            System.err.println("Excepción capturada: " + e.getMessage());
        }
        
        System.out.println("\n==========================================");
        System.out.println("PRUEBA con arregloCharacter (tamaño: " + arregloCharacter.length + ")");
        System.out.println("==========================================");
        imprimirArreglo(arregloCharacter);
        
        try {
            int impresos = imprimirArreglo(arregloCharacter, 0, 2);
            System.out.println("Elementos impresos: " + impresos);
        } catch (InvalidSubscriptException e) {
            System.err.println("Excepción capturada: " + e.getMessage());
        }

    }
}