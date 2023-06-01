package com.controller;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Invoker {
    private CommandExecutor commExec;
    public void SetCommand(CommandExecutor comm){
        commExec = comm;
    }
    public void ExecuteCommand(Map<String, Object> request){
        commExec.execute(request);
    }

}
