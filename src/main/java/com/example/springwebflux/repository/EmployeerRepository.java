package com.example.springwebflux.repository;

import com.example.springwebflux.entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmployeerRepository extends ReactiveCrudRepository<Employee,String> {
}
