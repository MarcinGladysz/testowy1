package testowy1.cqrs;


import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class CommandProcessor {


    public void process(String jsonString){

        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();

        try {
           Command command = mapper.readValue(jsonString,Command.class);
           process(command);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void process(Command command) {
        try {
        CommandHandlerAssigment annot = command.getClass().getAnnotation(CommandHandlerAssigment.class);
            CommandHandler handler = annot.handlerClass().getDeclaredConstructor().newInstance();
            handler.handle(command);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
