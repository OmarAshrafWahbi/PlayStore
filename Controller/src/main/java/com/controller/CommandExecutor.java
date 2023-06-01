package com.controller;

import java.util.Map;

public interface CommandExecutor {
    public void execute(Map<String, Object> request);
}
