package com.epam.tct.web.command;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
    private static final Map<String, Command> commands;

    static {
        commands = new HashMap<>();
        commands.put("loginPage", new GetLoginCommand());
        commands.put("home", new CommandHome());
        commands.put("authorization", new PostLoginCommand());
        commands.put("register", new PostRegistrationCommand());
        commands.put("registration", new GetRegistrationCommand());
        commands.put("commandNotFound", new CommandNotFound());
        commands.put("logout", new LogoutCommand());
        commands.put("adminCabinet", new GetAdminCabinet());
        commands.put("userCabinet", new GetUserCabinet());
        commands.put("create-delivery", new GetCreateDelivery());
        commands.put("postCreateDelivery", new PostCreateDelivery());
        commands.put("userOrdersPage", new UserOrders());
        commands.put("allUserDeliveries", new AllUserDeliveries());
        commands.put("getAllUsersOrders", new GetAllUsersOrders());
        commands.put("changeStatusDelivery", new GetChangeStatusDelivery());
        commands.put("confirmationChangeStatus", new PostChangeStatusDelivery());
        commands.put("displayAllUsers", new DisplayAllUsers());
        commands.put("getOrders", new DisplayOrders());
        commands.put("createOrderByAdmin", new CreateDeliveryByAdmin());

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
