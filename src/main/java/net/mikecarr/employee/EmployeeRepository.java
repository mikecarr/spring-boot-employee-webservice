package net.mikecarr.employee;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import net.mikecarr.employee.ws.employees_web_service.Dept;
import net.mikecarr.employee.ws.employees_web_service.Employee;

@Component
public class EmployeeRepository {
	private static final Map<String, Employee> employees = new HashMap<>();

	private int getRandomNumber(){
		Random rand = new Random();
		return rand.nextInt(100) + 1;

	}
	@PostConstruct
	public void initData() {
		Employee employee = new Employee();
		employee.setDept(Dept.ENGINEERING);
		employee.setId(getRandomNumber());
		employee.setTitle("Vice President");
		employee.setName("Joe Blow");
		employees.put(employee.getName(), employee);
		
		employee = new Employee();
		employee.setDept(Dept.HR);
		employee.setId(getRandomNumber());
		employee.setTitle("President");
		employee.setName("John Coctostan");
		employees.put(employee.getName(), employee);

		
	}

	public Employee findEmployee(String name) {
	 	Assert.notNull(name, "The employees's name must not be null");
		return employees.get(name);
	}

	public Employee addEmployee(int id, String title, Dept department, String name){
		Employee employee = new Employee();
		employee.setDept(department);
		employee.setId(id);
		employee.setTitle(title);
		employee.setName(name);
		employees.put(employee.getName(), employee);		
		return employee;
	}
}