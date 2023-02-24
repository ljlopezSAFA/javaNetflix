package modelos;


import lombok.*;

@Data
@EqualsAndHashCode(exclude = {"usuario","pelicula","serie", "capitulo"})
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"usuario","pelicula","serie", "capitulo"})
public class Valoracion {
    private Usuario usuario;
    private Pelicula pelicula;
    private Serie serie;
    private Capitulo capitulo;
    private String valoracion;
    private int rating;
}
