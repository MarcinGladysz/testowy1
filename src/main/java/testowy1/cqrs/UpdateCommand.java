package testowy1.cqrs;


@CommandHandlerAssigment(handlerClass = UpdateCommandHandler.class)
public class UpdateCommand extends Command {

    public UpdateCommand(String name1) {
        super(name1);
    }
}
