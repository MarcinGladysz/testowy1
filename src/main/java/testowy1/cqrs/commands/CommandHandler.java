package testowy1.cqrs.commands;

import org.springframework.stereotype.Service;

@Service
public abstract class CommandHandler<T extends Command> {

    public abstract void handle(T command);
}
