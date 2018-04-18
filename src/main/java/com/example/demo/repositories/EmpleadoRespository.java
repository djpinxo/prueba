package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Ciudad;
import com.example.demo.domain.Empleado;

public interface EmpleadoRespository extends JpaRepository<Empleado, Long>{

}
