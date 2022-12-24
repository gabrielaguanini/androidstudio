package models;


import org.json.JSONObject;

public class Datospersonales extends JSONObject{

    private int id;
    private String direccion;
    private String dni;
    private String nombre;
    private int salario;
    private String telefono;

    public Datospersonales() {
    }

    public Datospersonales(String direccion, String dni, String nombre, int salario, String telefono) {
        this.direccion = direccion;
        this.dni = dni;
        this.nombre = nombre;
        this.salario = salario;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion(String direccion) {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre(String nombre) {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


}
