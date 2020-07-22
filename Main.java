import java.util.*;


public class Main {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        Integer opcion = 0;
        Operaciones opciones = new Operaciones();

        while (opcion!=5){
            System.out.println ("OPCIONES:");
            System.out.println ("1. Agregar empleado.");
            System.out.println ("2. Eliminar empleado.");
            System.out.println ("3. Actualizar empleado.");
            System.out.println ("4. Listar Empleados.");
            System.out.println ("5. Salir del Programa.");

            try {

                System.out.println ("Seleccionar una opcion del 1 al 5 para realizar la acción que se desea:");
                opcion = in.nextInt();

                switch (opcion){
                    case 1:
                        opciones.añadir();
                        break;
                    case 2:
                        System.out.println ("Eliminar Empleado.\n");
                        opciones.eliminar();
                        break;
                    case 3:
                        opciones.actualizar();
                        break;
                    case 4:
                        System.out.println ("Lista de empleados:");
                        opciones.mostrar();
                        break;
                    case 5:
                        System.out.println ("Terminando ejecución del programa...");
                        break;
                    default:
                        System.out.println ("Por favor ingrese un número del 1 al 5 segun la opción que desea");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println ("Por favor verificar si ha ingresado un valor numerico");
                in.next();
            }

        }



    }

}
