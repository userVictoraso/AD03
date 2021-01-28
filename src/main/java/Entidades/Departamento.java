package Entidades;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "LOCALIZACION")
    private String localizacion;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Empleado> empleados;

    public Departamento() {

    }

    public Departamento(String nombre, String localizacion) {
        this.nombre = nombre;
        this.localizacion = localizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", localizacion='" + localizacion + '\'' +
                '}';
    }
}

