package com.epam.tct.web.command;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
    private static final Map<String, Command> commands;

    static {
        commands = new HashMap<>();
        commands.put("loginPage", new ViewLoginPage());
        commands.put("authorization", new AuthorizationPage());
        commands.put("registration", new CommandNotFound());

        commands.put("commandNotFound", new CommandNotFound());



    }
    public static Command getCommand(String commandName) {
      Command command;
      try{
          command = commands.get(commandName);
      }catch (IllegalThreadStateException | NullPointerException e){
          command = commands.get("commandNotFound");
      }

        return  command;
    }
}
