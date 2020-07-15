package ejercicio1;

public class Cadenas {


        public static void main(String args[]){
            String cadena = "     1  2          3         14        5  y  u      6   7               ";
            String[ ] matriz = cadena.trim().split("\\s+");

            int suma = 0;

            for (int i = 0; i < matriz.length; i++){

                String caracteres = matriz[i];

                if (verificacion(caracteres) == true) {

                    int numero = Integer.parseInt(caracteres);
                    suma = numero + suma;

                }else {
                    System.err.println(" ''" + caracteres + "'' no es un número");
                }
            }

            System.out.println("La suma de los números de la cadena es: " + suma);




        }

        public static boolean verificacion(String cadena) {
            boolean resultado;

            try {
                Integer.parseInt(cadena);
                resultado = true;
            } catch (NumberFormatException exception) {
                resultado = false;
            }

            return resultado;

        }
    }
