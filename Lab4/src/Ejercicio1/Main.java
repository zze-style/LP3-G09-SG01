package Ejercicio1;

public class Main {
    public static void main(String[] args) {
        LeerEntrada lector = new LeerEntrada(System.in);

        while (true) {
            try {
                char c = lector.getChar();
                lector.procesar(c);

            } catch (VocalException | NumException | WhiteException e) {
                System.out.println(e.getMessage());

            } catch (OutputException e) {
                System.out.println("Programa terminado.");
                break;

            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                break;
            }
        }
    }
}
