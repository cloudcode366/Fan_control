package com.wiramin.esp.fan_control.service.impl;

import com.wiramin.esp.fan_control.entity.State;
import com.wiramin.esp.fan_control.repository.StateRepo;
import com.wiramin.esp.fan_control.service.FanService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FanServiceImpl implements FanService {
    private final StateRepo stateRepo;
    
    public void turnOn(Integer fanId) {
        State state1 = stateRepo.findById(fanId).orElseThrow();
        state1.setState(true);
        stateRepo.save(state1);
    }
    
    public void turnOffAll() {
        List<State> state1 = stateRepo.findAll();
        for (State state : state1) {
            state.setState(false);
        }
        stateRepo.saveAll(state1);
    }
    
    public List<State> getAllStates() {
        return stateRepo.findAll();
    }
}
