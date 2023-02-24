package modelos;

import lombok.*;

@Data
@EqualsAndHashCode(exclude = {"temporada"})
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"temporada"})
public class Capitulo{
    private String titulo;
    private Temporada temporada;
    private String sinopsis;
    private int orden;
}
