package testowy1.cqrs;

public class UpdateCommandHandler extends CommandHandler<UpdateCommand> {

    @Override
    public void handle(UpdateCommand command) {

        System.out.println("teraz to" + command.getName());
    }
}
