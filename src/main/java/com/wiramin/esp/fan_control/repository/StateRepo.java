package com.wiramin.esp.fan_control.repository;

import com.wiramin.esp.fan_control.entity.State;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepo extends JpaRepository<State, Integer> {
    Optional<State> findById(Integer id);
    
}
