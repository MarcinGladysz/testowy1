package testowy1.cqrs;

import org.springframework.stereotype.Service;

@Service
public class TestowyHandler extends CommandHandler<TestowaCommand> {

    @Override
    public void handle(TestowaCommand command) {
        System.out.println("JEJEJE" + command.getName());

    }
}
