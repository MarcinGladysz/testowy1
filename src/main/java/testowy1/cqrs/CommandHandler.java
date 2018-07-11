package testowy1.cqrs;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public abstract class CommandHandler<T extends Command> {
    @Transactional
    public abstract void handle(T command);
}
