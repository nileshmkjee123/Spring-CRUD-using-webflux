package com.example.springwebflux.service;

import com.example.springwebflux.dto.EmployeeDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto);
    Mono<EmployeeDto> getEmployee(String id);
    
    Flux<EmployeeDto> getAllEmployees();
    Mono<EmployeeDto> updateEmployee(String id,EmployeeDto employeeDto);
    Mono<Void> deleteEmployee(String id);
}
