import java.util.*;


public class Main {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        Integer opcion = 0;
        Operaciones opciones = new Operaciones();

        while (opcion!=11){
            System.out.println ("OPCIONES:");
            System.out.println ("1. Agregar empleado.");
            System.out.println ("2. Eliminar empleado.");
            System.out.println ("3. Actualizar empleado.");
            System.out.println ("4. Listar Empleados.");
            System.out.println ("5. Listar empleado de mayor salario.");
            System.out.println ("6. Listar empleado de menor salario.");
            System.out.println ("7. Orden");
            System.out.println ("8. Suma de salarios");
            System.out.println ("9. Total de apellidos que Empiezan con \"A\" o \"a\" ");
            System.out.println ("10. Empleados de mayor salario.");
            System.out.println ("11. Salir del Programa.");

            try {
                System.out.println("\n");
                System.out.println ("Seleccionar una opcion del 1 al 11 para realizar la acción que se desea:");
                opcion = in.nextInt();

                switch (opcion){
                    case 1:
                        opciones.añadir();
                        break;
                    case 2:
                        opciones.eliminar();
                        break;
                    case 3:
                        opciones.actualizar();
                        break;
                    case 4:
                        opciones.mostrarLista();
                        break;
                    case 5:
                        opciones.encontrarMayorSalario();
                        break;
                    case 6:
                        opciones.encontrarMenorSalario();
                        break;
                    case 7:
                        opciones.ordenarEmpleados();
                        break;
                    case 8:
                        opciones.sumarSalarios();
                        break;
                    case 9:
                       // System.out.println ("Total de nombres que empiezan con A o a");
                        opciones.mostrarEmpleadosA();
                        break;
                    case 10:
                        opciones.primerosCincoEmpleados();
                        break;
                    case 11:
                        System.out.println ("Terminando ejecución del programa...");
                        break;

                    default:
                        System.out.println ("Por favor ingrese un número del 1 al 11 segun la opción que desea");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println ("Por favor verificar si ha ingresado un valor numerico");
                in.next();
            }

        }



    }

}
