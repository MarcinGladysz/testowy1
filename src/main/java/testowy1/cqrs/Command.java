package testowy1.cqrs;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @Type(value = UpdateCommand.class, name = "UpdateCommand"),
        @Type(value = TestowaCommand.class, name = "TestowaCommand")
})
@AllArgsConstructor
@Getter
@Data
public class Command {
    private String name;
    public Command(){

    }
}
