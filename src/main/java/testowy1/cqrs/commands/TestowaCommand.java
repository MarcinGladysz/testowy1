package testowy1.cqrs.commands;



@CommandHandlerAssigment(handlerClass = TestowyHandler.class)
public class TestowaCommand extends Command {
    public TestowaCommand(){
        super();
    }
}
