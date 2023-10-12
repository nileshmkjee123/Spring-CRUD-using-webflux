package com.example.springwebflux.service;

import com.example.springwebflux.dto.EmployeeDto;
import com.example.springwebflux.entity.Employee;
import com.example.springwebflux.mapper.EmployeeMapper;
import com.example.springwebflux.repository.EmployeerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeerRepository employeerRepository;
    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Mono<Employee> savedEmployee = employeerRepository.save(employee);

        return savedEmployee.map((employeeEntity) ->
                EmployeeMapper.maptoEmployeeDto(employeeEntity));
    }
}
