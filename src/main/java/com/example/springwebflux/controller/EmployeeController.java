package com.example.springwebflux.controller;

import com.example.springwebflux.dto.EmployeeDto;
import com.example.springwebflux.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto)
    {
        return employeeService.saveEmployee(employeeDto);
    }

    @GetMapping("/{id}")
    public Mono<EmployeeDto> getEmployee(@PathVariable("id") String employeeId)
    {
        return employeeService.getEmployee(employeeId);
    }

    @GetMapping
    public Flux<EmployeeDto> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{id}")
    public Mono<EmployeeDto> updateEmployee(@PathVariable("id") String id,@RequestBody EmployeeDto employeeDto)
    {
       return employeeService.updateEmployee(id,employeeDto);
    }
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public Mono<Void> deleteEmployee(@PathVariable("id") String employeeId)
    { return employeeService.deleteEmployee(employeeId);

    }

    @DeleteMapping
    public Mono<Void> deleteAllEmployee()
    { return employeeService.deleteAllEmployees();

    }
}
