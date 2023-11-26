package co.edu.unbosque.Task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase que representa un estudiante en el sistema.
 */
@Entity
@Table(name = "estudiante")
public class EstudianteModel {

    @Id
    private String identificacion;
    private String nombre;
    private String apellidos;
    private String email;
    private String facultad;

    /**
     * Constructor vacío de la clase EstudianteModel.
     */
    public EstudianteModel() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor de la clase EstudianteModel.
     * 
     * @param identificacion La identificación del estudiante.
     * @param nombre         El nombre del estudiante.
     * @param apellidos      Los apellidos del estudiante.
     * @param email          El email del estudiante.
     * @param facultad       La facultad del estudiante.
     */
    public EstudianteModel(String identificacion, String nombre, String apellidos, String email, String facultad) {

        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.facultad = facultad;
    }

    /**
     * Obtiene la identificación del estudiante.
     * 
     * @return La identificación del estudiante.
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * Establece la identificación del estudiante.
     * 
     * @param identificacion La identificación del estudiante.
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * Obtiene el nombre del estudiante.
     * 
     * @return El nombre del estudiante.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estudiante.
     * 
     * @param nombre El nombre del estudiante.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del estudiante.
     * 
     * @return Los apellidos del estudiante.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del estudiante.
     * 
     * @param apellidos Los apellidos del estudiante.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el email del estudiante.
     * 
     * @return El email del estudiante.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email del estudiante.
     * 
     * @param email El email del estudiante.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la facultad del estudiante.
     * 
     * @return La facultad del estudiante.
     */
    public String getFacultad() {
        return facultad;
    }

    /**
     * Establece la facultad del estudiante.
     * 
     * @param facultad La facultad del estudiante.
     */
    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    /**
     * Devuelve una representación en cadena de caracteres del estudiante.
     * 
     * @return La representación en cadena de caracteres del estudiante.
     */
    @Override
    public String toString() {
        return "Estudiante [identificacion=" + identificacion + ", nombre=" + nombre + ", apellidos=" + apellidos
                + ", email=" + email + ", facultad=" + facultad + "]";
    }

}
