package modelos;


import lombok.*;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Valoracion {
    private Usuario usuario;
    private Pelicula pelicula;
    private Serie serie;
    private Capitulo capitulo;
    private String valoracion;
    private int rating;
}