package event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCreatedEvent {
    private String EventId;
    private UUID CustomerId;
    private String name;
    private String email;
}
