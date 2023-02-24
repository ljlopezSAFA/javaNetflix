package modelos;

import lombok.*;
import java.util.List;

@Data
@EqualsAndHashCode(exclude = {"capitulos"})
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Temporada {
    private String titulo;
    private int numTemporada;
    private int numCapitulos;
    private List<Capitulo> capitulos;

}
