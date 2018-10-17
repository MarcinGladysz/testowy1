import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import testowy1.Application;
import testowy1.cqrs.commands.Command;
import testowy1.cqrs.commands.CommandProcessor;
import testowy1.cqrs.commands.TestowaCommand;
import testowy1.cqrs.commands.UpdateCommand;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class TestCommand {

    @Autowired
    CommandProcessor processor;

    @Test
    public void commandProccessTest(){
        TestowaCommand command = new TestowaCommand();
        command.setName(" testowa command");
        processor.process(command);
        Command commandUpdate = new UpdateCommand();
        commandUpdate.setName(" update command");
        processor.process(commandUpdate);

        processor.process("{\"type\":\"TestowaCommand\",\"name\":\"TestowaCommand\"}");

    }
}
