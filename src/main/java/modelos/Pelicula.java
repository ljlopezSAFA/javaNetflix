package modelos;

import lombok.*;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pelicula {
    private String titulo;
    private String director;
    private int anyoLanzamiento;
    private int duracion;
    private String sinopsis;
    private Genero genero;
    private String pais;

}
