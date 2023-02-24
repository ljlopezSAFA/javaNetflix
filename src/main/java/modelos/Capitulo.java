package modelos;

import lombok.*;

@Data
@EqualsAndHashCode(exclude = {"temporada"})
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Capitulo{
    private String titulo;
    private Temporada temporada;
    private String sinopsis;
    private int orden;
}
