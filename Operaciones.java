import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Operaciones {

    List<Empleado> listaEmpleados = new ArrayList<>();
   private Integer id;
   private String nombre;
   private String apellido;
   private Integer salario;


    public Operaciones(){
       System.out.println("\n");
    }

    public void añadir(){

        boolean flag = false;

        Iterator<Empleado> it= listaEmpleados.iterator();

        Scanner entrada = new Scanner(System.in);

        System.out.println("\nAÑADIR USUARIO");
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
        System.out.println ("Eliminar Empleado.\n");
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
            System.err.println("El ID que ingreso no existe.\n");
        }


    }

    public void mostrarLista(){
        System.out.println ("Lista de empleados:\n");
        listaEmpleados.stream().forEach(empleado -> System.out.println(empleado + "\n"));

    }

    public void encontrarMayorSalario() {
        System.out.println ("Empleado con mayor salario: \n");
        System.out.println(listaEmpleados.stream()
                .max(Comparator.comparing(Empleado::getSalario))
                .map(Empleado::toString)
                .orElse("No hay empleados para listar"));
        System.out.println("\n");
    }

    public void encontrarMenorSalario() {
        System.out.println ("Empleado con menor salario: \n");
        System.out.println(listaEmpleados.stream()
                .min(Comparator.comparing(Empleado::getSalario))
                .map(Empleado::toString)
                .orElse("No hay empleados para listar"));
        System.out.println("\n");
    }

    public void ordenarEmpleados() {
        System.out.println ("Empleados ordenados por nombre: \n");
       listaEmpleados.stream()
               .sorted(Comparator.comparing(Empleado::getNombre))
               .forEach(System.out::println);
    }

    public void sumarSalarios() {
        System.out.println ("El total de la suma de sueldos mayores a 700000 es: \n");
        Integer sumaSalarios = listaEmpleados.stream()
                .filter(empleado -> empleado.getSalario() > 700000)
                .map(Empleado::getSalario)
                .reduce(0, (acc, salario) -> acc + salario);
        System.out.println(sumaSalarios);
        System.out.println("\n");
    }

    private Stream<Empleado> filtrarEmpleadosA() {
        return listaEmpleados.stream()
                .filter(empleado -> empleado.getApellido().toUpperCase().startsWith("A"));
    }

    public void mostrarEmpleadosA() {
        System.out.print("Número de empleados que su apellido empieza con la letra \"A\" o \"a\" : " + filtrarEmpleadosA().count() + "\n");
        System.out.println("\n");
    }


    public void primerosCincoEmpleados() {
        System.out.println ("\nlos empleados con mayor salario son: \n");
        List<Empleado> primerosEmpleados = listaEmpleados.stream()
                .sorted(Comparator.comparing(Empleado::getSalario, Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toList());
        primerosEmpleados.forEach(empleado -> System.out.println(empleado));
        System.out.println("\n");
    }
}

