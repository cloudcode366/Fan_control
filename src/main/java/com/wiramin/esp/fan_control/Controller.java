package com.wiramin.esp.fan_control;

import com.wiramin.esp.fan_control.entity.State;
import com.wiramin.esp.fan_control.service.FanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/fan")
@RequiredArgsConstructor
@CrossOrigin
public class Controller {
    
    private final FanService fanService;
    
    @PostMapping("/turn-on/{id}")
    public ResponseEntity<String> turnOn( @PathVariable Integer id){
        fanService.turnOn(id);
        return ResponseEntity.ok("Turn On");
    }
    
    @GetMapping("/get-state")
    public ResponseEntity<List<State>> getState(){
        List<State> states = fanService.getAllStates()
                .stream()
                .map(state -> new State(state.getId(), state.getState()))
                .collect(Collectors.toList());
        fanService.turnOffAll();
        return ResponseEntity.ok(states);
    }
    
    @GetMapping("/refresh")
    public ResponseEntity<String> refresh(){
        return ResponseEntity.ok("Refresh");
    }
}
