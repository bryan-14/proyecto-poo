package unicaes.tallerautomotriz.tallerautomotriz.paylod;

import lombok.*;

import java.io.Serializable;

@Builder
@ToString
@Data

public class MessageReponse implements Serializable {

    private String mensaje;

    private String data;
}
