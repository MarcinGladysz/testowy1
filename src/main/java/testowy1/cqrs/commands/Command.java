package testowy1.cqrs.commands;


import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @Type(value = UpdateCommand.class, name = "UpdateCommand"),
        @Type(value = TestowaCommand.class, name = "TestowaCommand")
})
@AllArgsConstructor
@Getter
@Data
public abstract class Command {
    private String name;
    public Command(){

    }
}
