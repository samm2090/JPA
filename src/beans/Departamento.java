package beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Departamento {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	
	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	@OneToMany(mappedBy="departamento",cascade=CascadeType.PERSIST)
	
	private List<Empleado> empleados = new ArrayList<Empleado>();
	
	public Departamento(String nombre){
		this.nombre=nombre;
	}
	
	public Departamento(){}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombre=" + nombre + ", empleados="
				+ empleados + "]";
	}
	

}
