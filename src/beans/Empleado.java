package beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Empleado {
	
	@Id
	@GeneratedValue
	private Long id;

	private String nombre;
		
	@ManyToOne
	private Departamento departamento;
	
	public Empleado(){	}
	
	public Empleado(String nombre){
		this.nombre = nombre;
		
	}
	
	public Empleado(String nombre, Departamento depa){
		this.nombre = nombre;
		this.departamento = depa;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", departamento="
				+ departamento + "]";
	}
	

}
