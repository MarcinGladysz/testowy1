package testowy1.cqrs;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional
public abstract class CommandHandler<T extends Command> {

    public abstract void handle(T command);
}
