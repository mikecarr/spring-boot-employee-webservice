package net.mikecarr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import net.mikecarr.ws.employees_web_service.AddEmployeeRequest;
import net.mikecarr.ws.employees_web_service.AddEmployeeResponse;
import net.mikecarr.ws.employees_web_service.Dept;
import net.mikecarr.ws.employees_web_service.Employee;
import net.mikecarr.ws.employees_web_service.GetEmployeeRequest;
import net.mikecarr.ws.employees_web_service.GetEmployeeResponse;


@Endpoint
public class EmployeeEndpoint {
	private static final String NAMESPACE_URI = "http://mikecarr.net/ws/employees-web-service";

	EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeEndpoint(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
	@ResponsePayload
	public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request) {

		GetEmployeeResponse response = new GetEmployeeResponse();
		response.setEmployee(employeeRepository.findEmployee(request.getName()));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployeeRequest")
	@ResponsePayload
	public AddEmployeeResponse addEmployee(@RequestPayload AddEmployeeRequest request) {

		AddEmployeeResponse response = new AddEmployeeResponse();
		Employee employee = employeeRepository.addEmployee(request.getId(), request.getTitle(), request.getDept(), request.getName());
		response.setEmployee(employee);
		return response;
	}

	
}