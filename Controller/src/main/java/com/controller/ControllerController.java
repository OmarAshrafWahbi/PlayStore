package com.controller;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/Controller")
public class ControllerController {
    private KafkaTemplate<String, Map<String, Object>> kafkaTemplate;
    private Invoker invoker;

    @PostMapping("Command")
    public String publish(@RequestBody Map<String, Object> request){
        String actionName = (String) request.get("Action");
        try {
            Class CommandClass = Class.forName("com.controller."+actionName+"Command");
            Constructor<CommandExecutor> constructor = CommandClass.getConstructor(KafkaTemplate.class);
            CommandExecutor command = constructor.newInstance(kafkaTemplate);
            invoker.SetCommand(command);
            invoker.ExecuteCommand(request);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return "Success";
    }
}
