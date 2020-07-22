public class Empleado {

    private Integer id;
    private String nombre;
    private String apellido;
    private Integer salario;

    public Empleado(Integer id, String nombre, String apellido, Integer salario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }


    @Override
    public String toString(){
        return "id:" + getId() + " nombre:" + getNombre() + " apellido:" + getApellido() + " salario:" + getSalario();
    }


}
