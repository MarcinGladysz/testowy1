package testowy1.cqrs;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@CommandHandlerAssigment(handlerClass = TestowyHandler.class)
public class TestowaCommand extends Command {

    public TestowaCommand(String name1) {
        super(name1);
    }
    public TestowaCommand(){
        super();
    }
}
