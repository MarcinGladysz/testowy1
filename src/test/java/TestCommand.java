import org.junit.Test;
import testowy1.cqrs.Command;
import testowy1.cqrs.CommandProcessor;
import testowy1.cqrs.TestowaCommand;
import testowy1.cqrs.UpdateCommand;

public class TestCommand {

    @Test
    public void commandProccessTest(){
        CommandProcessor processor = new CommandProcessor();
        TestowaCommand command = new TestowaCommand(" testowa command");
        processor.process(command);
        Command commandUpdate = new UpdateCommand(" update command");
        processor.process(commandUpdate);

        processor.process("{\"type\":\"TestowaCommand\",\"name\":\"TestowaCommand\"}");

    }
}
