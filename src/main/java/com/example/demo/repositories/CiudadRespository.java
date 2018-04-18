package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Ciudad;

public interface CiudadRespository extends JpaRepository<Ciudad, Long>{

}
