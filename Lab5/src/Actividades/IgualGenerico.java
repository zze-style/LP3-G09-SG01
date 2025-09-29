package Actividades;

public class IgualGenerico {

    public static <T> boolean esIgualA(T objeto1, T objeto2) {

        if (objeto1 == null && objeto2 == null) {
            return true;
        }

        if (objeto1 == null || objeto2 == null) {
            return false;
        }

        return objeto1.equals(objeto2);
    }
    
public static void main(String[] args) {
        
        System.out.println("Pruebas con Tipos Integrados (Integer, Double)");
        
        Integer i1 = 10;
        Integer i2 = 10;
        System.out.printf("Integer 10 y 10: %s%n", IgualGenerico.esIgualA(i1, i2));

        Integer i3 = 20;
        System.out.printf("Integer 10 y 20: %s%n", IgualGenerico.esIgualA(i1, i3));

        String s1 = "Hola";
        String s2 = "Hola";
        System.out.printf("String 'Hola' y 'Hola': %s%n", IgualGenerico.esIgualA(s1, s2));
        
        String s3 = "Mundo";
        System.out.printf("String 'Hola' y 'Mundo': %s%n", IgualGenerico.esIgualA(s1, s3));
        
        Object o1 = new Object();
        Object o2 = new Object();
        System.out.printf("Dos nuevos Object(): %s%n", IgualGenerico.esIgualA(o1, o2));

        Object o3 = o1;
        System.out.printf("Object o1 y Object o3 (mismo objeto): %s%n", IgualGenerico.esIgualA(o1, o3));

        System.out.println("----------------------------------");
        System.out.println("Pruebas con Null");

        String snull1 = null;
        String snull2 = null;
        System.out.printf("null y null: %s%n", IgualGenerico.esIgualA(snull1, snull2));

        System.out.printf("String 'Hola' y null: %s%n", IgualGenerico.esIgualA(s1, snull1));
        
        System.out.printf("Integer 10 y null: %s%n", IgualGenerico.esIgualA(i1, (Integer) null));
        
         
    }
}