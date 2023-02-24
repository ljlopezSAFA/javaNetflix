package modelos;

import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Serie {
    private String titulo;
    private String director;
    private int anyoLanzamiento;
    private int duracion;
    private String sinopsis;
    private Genero genero;
    private String pais;
    private List<Temporada> temporadas;
    private List<Capitulo> capitulos;
}