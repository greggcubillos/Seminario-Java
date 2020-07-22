import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;


public class Operaciones {

    List<Empleado> listaEmpleados = new ArrayList<>();
    Integer id;
    String nombre;
    String apellido;
    Integer salario;


    public Operaciones(){
       System.out.println("\n");
    }

    public void añadir(){

        boolean flag = false;

        Iterator<Empleado> it= listaEmpleados.iterator();

        Scanner entrada = new Scanner(System.in);

        System.out.println("AÑADIR USUARIO");
        System.out.println("Ingrese ID: ");
        id = entrada.nextInt();

        while (it.hasNext()) {

            if (it.next().getId().equals(id)) {
                flag = true;
                System.err.println("El ID ya existe, por favor realice nuevamente el proceso");

            }

        }

        if (!flag) {
            System.out.println("Ingrese nombre: ");
            nombre = entrada.next();
            System.out.println("Ingrese apellido: ");
            apellido = entrada.next();
            System.out.println("Ingrese el salario: ");
            salario = entrada.nextInt();
            System.out.println("El Empleado se ha añadido correctamente.\n");

            listaEmpleados.add(new Empleado(id, nombre, apellido, salario));

        }



    }

    public void actualizar(){


        Integer ida;

        boolean flag = false;

        Iterator<Empleado> it= listaEmpleados.iterator();

        Scanner entrada = new Scanner(System.in);
        
        System.out.println("ACTUALIZAR EMPLEADO");
        System.out.println("Ingrese ID del empleado a modificar: ");
        ida = entrada.nextInt();

        while (it.hasNext()) {

            if (it.next().getId().equals(ida)) {
                flag = true;
                System.out.println("Ingrese nuevo ID: ");
                id = entrada.nextInt();
                System.out.println("Ingrese nuevo nombre: ");
                nombre = entrada.next();
                System.out.println("Ingrese nuevo apellido: ");
                apellido = entrada.next();
                System.out.println("Ingresa nuevo salario: ");
                salario = entrada.nextInt();

                Integer finalSalario = salario;
                listaEmpleados.stream().filter(empleado -> empleado.getId().equals(ida)).forEach(empleado -> {
                    empleado.setId(id);
                    empleado.setNombre(nombre);
                    empleado.setApellido(apellido);
                    empleado.setSalario(salario);
                    System.out.println("Datos de empleado se han actualizados correctamente.\n");
                    System.out.println(empleado + "\n");
                });

            }

        }

        if (!flag) {
            System.err.println("El ID digitado no existe. Cancelando actualización...");

        }

    }

    public void eliminar(){

        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese ID del empleado a eliminar: ");
        Integer id = entrada.nextInt();
        Iterator<Empleado> it= listaEmpleados.iterator();

        boolean flag = false;
        while (it.hasNext()) {

            if (it.next().getId().equals(id)) {
                it.remove();
                flag = true;
                System.out.println("Se realizo la eliminación de los datos del empleado. \n");
            }

        }

        if (!flag) {
            System.err.println("El ID que ingreso no existe.");

        }


    }

    public void mostrar(){
        listaEmpleados.stream().forEach(empleado -> System.out.println(empleado + "\n"));

    }
}

