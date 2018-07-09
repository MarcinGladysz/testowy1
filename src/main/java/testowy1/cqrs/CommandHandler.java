package testowy1.cqrs;

public abstract class CommandHandler<T extends Command> {
    public abstract void handle(T command);
}
