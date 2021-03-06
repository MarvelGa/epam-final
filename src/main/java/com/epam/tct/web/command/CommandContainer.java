package com.epam.tct.web.command;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
    private static final Logger logger = Logger.getLogger(CommandContainer.class);
    public static final Map<String, Command> commands;

    static {
        commands = new HashMap<>();
        commands.put("loginPage", new GetLoginCommand());
        commands.put("home", new CommandHome());
        commands.put("authorization", new PostLoginCommand());
        commands.put("register", new PostRegistrationCommand());
        commands.put("registration", new GetRegistrationCommand());
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
        commands.put("listDeliveries", new ListDeliveries());
        commands.put("commandNotFound", new CommandNotFound());
        commands.put("aboutUs", new AboutUs());

        logger.debug("Command container was successfully initialized");
        logger.trace("Number of commands --> " + commands.size());
    }


    public static Command getCommand(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            logger.trace("Command not found, name --> " + commandName);
            return commands.get("commandNotFound");
        }
        return commands.get(commandName);
    }
}
