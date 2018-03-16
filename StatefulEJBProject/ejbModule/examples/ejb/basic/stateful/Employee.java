package examples.ejb.basic.stateful;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;

import examples.ejb.interceptors.EmployeeClassLogger;
import examples.ejb.interceptors.EmployeeLogger;

/**
 * Session Bean implementation class Employee
 */
@Stateful
@LocalBean
@Interceptors(EmployeeClassLogger.class)
public class Employee implements EmployeeRemote, EmployeeLocal {

	private String name;
	private String address;
	
	public String getName() {
		return name;
	}

	@Interceptors(EmployeeLogger.class)
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	
    /**
     * Default constructor. 
     */
	public Employee () {
		 System.out.println("Stateful-Constructor anropas");
		 }
		 @PostConstruct
		public void init() {
		 System.out.println("Stateful-PostConstruct init() anropas");
		}
		 @PreDestroy
		public void destroy() {
		 System.out.println("Stateful-PreDestroy destroy() anropas");
		}
		@PostActivate
		public void activate() {
		System.out.println("Stateful-PostActivate activate() anropas");
		}
		@PrePassivate
		public void passivate() {
		System.out.println("Stateful-PrePassivate passivate() anropas");
		}
		@Remove
		public void remove() {
		System.out.println("Stateful-Remove remove() anropas");
		}


}
