package testowy1.cqrs.commands;


import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testowy1.BeanUtil;

import java.io.IOException;

@Service
@Transactional
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
