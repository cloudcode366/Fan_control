package com.wiramin.esp.fan_control.service;

import com.wiramin.esp.fan_control.entity.State;

import java.util.List;

public interface FanService {
    void turnOn(Integer fanId);
    void turnOffAll();
    List<State> getAllStates();
}
