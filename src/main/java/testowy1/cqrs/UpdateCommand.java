package testowy1.cqrs;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@CommandHandlerAssigment(handlerClass = UpdateCommandHandler.class)
public class UpdateCommand extends Command {

    public UpdateCommand(String name1) {
        super(name1);
    }
}
