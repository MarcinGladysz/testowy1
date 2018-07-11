package testowy1.cqrs;


import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import testowy1.BeanUtil;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@Service
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
            CommandHandlerAssigment annot = command.getClass().getAnnotation(CommandHandlerAssigment.class);

            CommandHandler handler =
                BeanUtil.getBean(annot.handlerClass());

            handler.handle(command);

    }
}
