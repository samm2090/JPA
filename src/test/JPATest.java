package test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import beans.Departamento;
import beans.Empleado;

public class JPATest {
	
	private EntityManager manager;
	
	public JPATest(EntityManager manager){
		this.manager = manager;
	}
	
	public static void main(String[] args) {
		EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("persistenceUnit");
		
		EntityManager manager = factory.createEntityManager();
		
		JPATest test = new JPATest(manager);
	
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.crearEmpleados2();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listarEmpleados();
		test.mostrarPrimerEmpleado();

		System.out.println(".. done");


		
	}
	
	private void crearEmpleados() {
		int nroDeEmpleados = manager.createQuery("Select a From Empleado a", Empleado.class).getResultList().size();
		if (nroDeEmpleados == 0) {
			Departamento departamento = new Departamento("Java");
			manager.persist(departamento);

			manager.persist(new Empleado("Bob",departamento));
			manager.persist(new Empleado("Mike",departamento));

		}
	}
	
	private void crearEmpleados2(){
		
		Departamento departamento = new Departamento("Java");
		
		Empleado empleado = new Empleado("Bob");
		Empleado empleado2 = new Empleado("Mike");
		
		List<Empleado> empleados = new ArrayList<Empleado>();
		empleados.add(empleado);
		empleados.add(empleado2);
		
		departamento.setEmpleados(empleados);

		manager.persist(departamento);
	}


	private void listarEmpleados() {
		List<Empleado> resultList = manager.createQuery("Select a From Empleado a", Empleado.class).getResultList();
		manager.createQuery("Select a From Empleado a", Empleado.class).getResultList();
		for (Empleado next : resultList) {
			System.out.println("siguiente empleado: " + next);
		}
	}
	
	private void mostrarPrimerEmpleado(){
		Empleado emp = manager.createQuery("Select a From Empleado a where a.id=1", Empleado.class).getSingleResult();
		
		System.out.println("1 Empleado: " + emp.getNombre());
		
	}


}
