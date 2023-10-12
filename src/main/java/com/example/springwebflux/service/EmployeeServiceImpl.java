package com.example.springwebflux.service;

import com.example.springwebflux.dto.EmployeeDto;
import com.example.springwebflux.entity.Employee;
import com.example.springwebflux.mapper.EmployeeMapper;
import com.example.springwebflux.repository.EmployeerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeerRepository employeerRepository;
    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Mono<Employee> savedEmployee = employeerRepository.save(employee);

        return savedEmployee.map(EmployeeMapper::maptoEmployeeDto);
    }

    @Override
    public Mono<EmployeeDto> getEmployee(String id) {
        Mono<Employee> savedEmployee = employeerRepository.findById(id);
        return savedEmployee.map(
                (EmployeeMapper::maptoEmployeeDto)
        );
    }

    @Override
    public Flux<EmployeeDto> getAllEmployees() {
        Flux<Employee> employees= employeerRepository.findAll();
        return employees.map(
                (EmployeeMapper::maptoEmployeeDto)
        );
    }

    @Override
    public Mono<EmployeeDto> updateEmployee(String id,EmployeeDto employeeDto) {
        Mono<Employee> employee = employeerRepository.findById(id);
       Mono<Employee> updatedEmployee =  employee.flatMap(
            (existingEmployee)->{existingEmployee.setFirstName(employeeDto.getFirstName());
            existingEmployee.setLastName(employeeDto.getLastName());
            existingEmployee.setEmail(employeeDto.getEmail());
            return    employeerRepository.save(existingEmployee);
            });
            return updatedEmployee.map(EmployeeMapper::maptoEmployeeDto);
    }

    @Override
    public Mono<Void> deleteEmployee(String id) {

        return employeerRepository.deleteById(id);

    }

    @Override
    public Mono<Void> deleteAllEmployees() {
        return employeerRepository.deleteAll();
    }
}
