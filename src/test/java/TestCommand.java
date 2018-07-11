import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import testowy1.Application;
import testowy1.cqrs.Command;
import testowy1.cqrs.CommandProcessor;
import testowy1.cqrs.TestowaCommand;
import testowy1.cqrs.UpdateCommand;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
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
