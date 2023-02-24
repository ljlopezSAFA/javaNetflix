import modelos.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilidades.UtilidadesNetflix;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class UtilidadesNetflixTest {
    
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Pelicula> peliculas = new ArrayList<>();
    private List<Serie> series = new ArrayList<>();
    
    
    @BeforeEach
    public void inicializaDatos(){

        Pelicula p1 = new Pelicula("Avatar","James Cameron",2008, 180, "Aventuras en Pandora", Genero.AVENTURAS, "EEUU");
        Pelicula p2 = new Pelicula("Avatar2","James Cameron",2022, 210, "Aventuras en Pandora", Genero.AVENTURAS, "EEUU");
        Pelicula p3 = new Pelicula("8 Apellidos Vascos","Emilio Martínez-Lázaro",2014, 180, "Una historia peculiar", Genero.COMEDIA, "España");
        Pelicula p4 = new Pelicula("Cars","Disney",2006, 120, "Carreras", Genero.ANIMACION, "EEUU");
        peliculas.addAll(List.of(p1,p2,p3,p4));

        Usuario u1 = new Usuario();
        PlanSubscripcion ps1 = new PlanSubscripcion(Tipo.ANUAL, LocalDate.of(2023,1,20), LocalDate.of(2024,1,20),90.0);
        u1.setPlanSubscripcion(ps1);
        Usuario u2 = new Usuario();
        PlanSubscripcion ps2 = new PlanSubscripcion(Tipo.MENSUAL, LocalDate.of(2023,1,20), LocalDate.of(2024,2,20),90.0);
        u2.setPlanSubscripcion(ps2);
        Usuario u3 = new Usuario();
        PlanSubscripcion ps3 = new PlanSubscripcion(Tipo.MENSUAL, LocalDate.of(2022,1,20), LocalDate.of(2022,2,20),90.0);
        u3.setPlanSubscripcion(ps3);
        Usuario u4 = new Usuario();
        PlanSubscripcion ps4 = new PlanSubscripcion(Tipo.MENSUAL, LocalDate.of(2023,1,27), LocalDate.of(2023,2,27),90.0);
        u4.setPlanSubscripcion(ps4);

        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);
        usuarios.add(u4);

    }


    @Test
    public void testGetPorGeneroPaisDuracion(){
        List<Pelicula> result  = UtilidadesNetflix.getPorGeneroPaisDuracion(peliculas, "EEUU", Genero.AVENTURAS, 170);
        assertEquals(2, result.size());
        assertEquals(Genero.AVENTURAS, result.get(result.size()-1).getGenero());
        assertTrue(result.get(result.size()-1).getDuracion()>170);
        assertEquals("EEUU", result.get(result.size()-1).getPais());
    }

    @Test
    public void testTienePlanSubscripcionValido(){
        assertTrue(UtilidadesNetflix.tienePlanDeSubscripcionValido(usuarios.get(0)));
        assertFalse(UtilidadesNetflix.tienePlanDeSubscripcionValido(usuarios.get(1)));
        assertFalse(UtilidadesNetflix.tienePlanDeSubscripcionValido(usuarios.get(2)));
        assertTrue(UtilidadesNetflix.tienePlanDeSubscripcionValido(usuarios.get(3)));
    }

    @Test
    public void ordenarCapitulosTemporadaTest() {
        //Crear una temporada
        Temporada temporada = new Temporada();
        temporada.setNumTemporada(1);

        //Crear una lista de capítulos
        List<Capitulo> capitulos = new ArrayList<>(Arrays.asList(
                new Capitulo("Capítulo 1", temporada, "Sinopsis del Capítulo 1", 1),
                new Capitulo("Capítulo 2", temporada, "Sinopsis del Capítulo 2", 2),
                new Capitulo("Capítulo 3", temporada, "Sinopsis del Capítulo 3", 3),
                new Capitulo("Capítulo 4", temporada, "Sinopsis del Capítulo 4", 4)
        ));

        temporada.setCapitulos(capitulos);

        //Llamar al método para ordenar los capítulos de la temporada
        List<Capitulo> capitulosOrdenados = UtilidadesNetflix.ordenarCapitulosTemporada(temporada, capitulos);

        //Comprobar que los capítulos han sido ordenados correctamente
        Assertions.assertEquals("Capítulo 1", capitulosOrdenados.get(0).getTitulo());
        Assertions.assertEquals("Capítulo 2", capitulosOrdenados.get(1).getTitulo());
        Assertions.assertEquals("Capítulo 3", capitulosOrdenados.get(2).getTitulo());
        Assertions.assertEquals("Capítulo 4", capitulosOrdenados.get(3).getTitulo());

        //Comprobar que la temporada tiene los capítulos ordenados
        Assertions.assertEquals("Capítulo 1", temporada.getCapitulos().get(0).getTitulo());
        Assertions.assertEquals("Capítulo 2", temporada.getCapitulos().get(1).getTitulo());
        Assertions.assertEquals("Capítulo 3", temporada.getCapitulos().get(2).getTitulo());
        Assertions.assertEquals("Capítulo 4", temporada.getCapitulos().get(3).getTitulo());
    }



    @Test
    public void CapitulosPorNumeroTemporadaTest() {
        //Crear una serie
        Serie serie = new Serie();
        serie.setTitulo("Serie de ejemplo");
        serie.setDirector("Director de ejemplo");
        serie.setAnyoLanzamiento(2022);

        //Crear una temporada
        Temporada temporada1 = new Temporada();
        temporada1.setNumTemporada(1);

        //Crear una lista de capítulos para la temporada 1
        List<Capitulo> capitulosTemporada1 = Arrays.asList(
                new Capitulo("Capítulo 1", temporada1, "Sinopsis del Capítulo 1", 1),
                new Capitulo("Capítulo 2", temporada1, "Sinopsis del Capítulo 2", 2),
                new Capitulo("Capítulo 3", temporada1, "Sinopsis del Capítulo 3", 3),
                new Capitulo("Capítulo 4", temporada1, "Sinopsis del Capítulo 4", 4)
        );

        temporada1.setCapitulos(capitulosTemporada1);

        //Crear una temporada
        Temporada temporada2 = new Temporada();
        temporada2.setNumTemporada(2);

        //Crear una lista de capítulos para latemporada 2
        List<Capitulo> capitulosTemporada2 = Arrays.asList(
                new Capitulo("Capítulo 1", temporada2, "Sinopsis del Capítulo 1", 1),
                new Capitulo("Capítulo 2", temporada2, "Sinopsis del Capítulo 2", 2),
                new Capitulo("Capítulo 3", temporada2, "Sinopsis del Capítulo 3", 3),
                new Capitulo("Capítulo 4", temporada2, "Sinopsis del Capítulo 4", 4)
        );
        temporada2.setCapitulos(capitulosTemporada2);

        //Añadir las temporadas a la serie
        serie.setTemporadas(Arrays.asList(temporada1, temporada2));

        //Obtener un mapa con los capítulos por número de temporada
        Map<Integer, List<Capitulo>> capitulosPorNumeroTemporada = UtilidadesNetflix.CapitulosPorNumeroTemporada(serie);

        //Verificar que la cantidad de temporadas en el mapa sea igual a la cantidad de temporadas de la serie
        Assertions.assertEquals(serie.getTemporadas().size(), capitulosPorNumeroTemporada.size());

        //Verificar que los capítulos de cada temporada sean los correctos
        Assertions.assertEquals(capitulosTemporada1, capitulosPorNumeroTemporada.get(1));
        Assertions.assertEquals(capitulosTemporada2, capitulosPorNumeroTemporada.get(2));
    }

    @Test
    public void testCapitulosPorNumeroTemporadaSerieGenero() {

        //Crear algunas series con diferentes géneros
        Serie serie1 = new Serie("Breaking Bad", "Vince Gilligan", 2008, 5, "Sinopsis de Breaking Bad", Genero.DRAMA, "Estados Unidos",new ArrayList<>(),new ArrayList<>());
        Serie serie2 = new Serie("The Big Bang Theory", "Chuck Lorre", 2007, 12, "Sinopsis de The Big Bang Theory", Genero.COMEDIA, "Estados Unidos",new ArrayList<>(),new ArrayList<>());
        Serie serie3 = new Serie("The Crown", "Peter Morgan", 2016, 4, "Sinopsis de The Crown", Genero.DRAMA, "Reino Unido",new ArrayList<>(),new ArrayList<>());

        //Crear algunas temporadas y capítulos para las series
        Temporada temporada1Serie1 = new Temporada("Temporada 1", 1, 7, new ArrayList<>());
        Temporada temporada2Serie1 = new Temporada("Temporada 2", 2, 13, new ArrayList<>());
        Temporada temporada1Serie2 = new Temporada("Temporada 1", 1, 17, new ArrayList<>());
        Temporada temporada1Serie3 = new Temporada("Temporada 1", 1, 10, new ArrayList<>());

        Capitulo capitulo1Temporada1Serie1 = new Capitulo("Capítulo 1", temporada1Serie1, "Sinopsis del Capítulo 1", 1);
        Capitulo capitulo2Temporada1Serie1 = new Capitulo("Capítulo 2", temporada1Serie1, "Sinopsis del Capítulo 2", 2);
        Capitulo capitulo1Temporada2Serie1 = new Capitulo("Capítulo 1", temporada2Serie1, "Sinopsis del Capítulo 1", 1);
        Capitulo capitulo2Temporada2Serie1 = new Capitulo("Capítulo 2", temporada2Serie1, "Sinopsis del Capítulo 2", 2);
        Capitulo capitulo1Temporada1Serie2 = new Capitulo("Capítulo 1", temporada1Serie2, "Sinopsis del Capítulo 1", 1);
        Capitulo capitulo2Temporada1Serie2 = new Capitulo("Capítulo 2", temporada1Serie2, "Sinopsis del Capítulo 2", 2);

        temporada1Serie1.setCapitulos(Arrays.asList(capitulo1Temporada1Serie1, capitulo2Temporada1Serie1));
        temporada2Serie1.setCapitulos(Arrays.asList(capitulo1Temporada2Serie1, capitulo2Temporada2Serie1));
        temporada1Serie2.setCapitulos(Arrays.asList(capitulo1Temporada1Serie2, capitulo2Temporada1Serie2));

        serie1.setTemporadas(Arrays.asList(temporada1Serie1, temporada2Serie1));
        serie2.setTemporadas(Collections.singletonList(temporada1Serie2));
        serie3.setTemporadas(Collections.singletonList(temporada1Serie3));

        // Crear lista de series y añadir las creadas anteriormente
        List<Serie> listaSeries = Arrays.asList(serie1, serie2, serie3);

        // Obtener el mapa de las series con sus capítulos por número de temporada y género
        Map<Serie, Map<Integer, List<Capitulo>>> mapaSeries = UtilidadesNetflix.CapitulosPorNumeroTemporadaSerieGenero(listaSeries, Genero.DRAMA);

        // Comprobar que la cantidad de series es correcta
        Assertions.assertEquals(2, mapaSeries.size());

        // Comprobar que la cantidad de temporadas de cada serie es correcta
        Assertions.assertEquals(2, mapaSeries.get(serie1).size());
        Assertions.assertEquals(1, mapaSeries.get(serie3).size());

        // Comprobar que la cantidad de capítulos de cada temporada de cada serie es correcta
        Assertions.assertEquals(2, mapaSeries.get(serie1).get(1).size());
        Assertions.assertEquals(2, mapaSeries.get(serie1).get(2).size());
        Assertions.assertEquals(0, mapaSeries.get(serie3).get(1).size());

    }

    @Test
    public void testMediaValoracion() {

        // Crear algunas series con diferentes géneros
        Serie serie1 = new Serie("Breaking Bad", "Vince Gilligan", 2008, 5, "Sinopsis de Breaking Bad", Genero.DRAMA, "Estados Unidos", new ArrayList<>(),new ArrayList<>());
        Serie serie2 = new Serie("The Big Bang Theory", "Chuck Lorre", 2007, 12, "Sinopsis de The Big Bang Theory", Genero.COMEDIA, "Estados Unidos" ,new ArrayList<>(),new ArrayList<>());

        // Crear algunas temporadas y capítulos para las series
        Temporada temporada1Serie1 = new Temporada("Temporada 1", 1, 7,new ArrayList<>());
        Temporada temporada2Serie1 = new Temporada("Temporada 2", 2, 13,new ArrayList<>());
        Temporada temporada1Serie2 = new Temporada("Temporada 1", 1, 17,new ArrayList<>());

        Capitulo capitulo1Temporada1Serie1 = new Capitulo("Capítulo 1", temporada1Serie1, "Sinopsis del Capítulo 1", 1);
        Capitulo capitulo2Temporada1Serie1 = new Capitulo("Capítulo 2", temporada1Serie1, "Sinopsis del Capítulo 2", 2);
        Capitulo capitulo1Temporada2Serie1 = new Capitulo("Capítulo 1", temporada2Serie1, "Sinopsis del Capítulo 1", 1);
        Capitulo capitulo2Temporada2Serie1 = new Capitulo("Capítulo 2", temporada2Serie1, "Sinopsis del Capítulo 2", 2);
        Capitulo capitulo1Temporada1Serie2 = new Capitulo("Capítulo 1", temporada1Serie2, "Sinopsis del Capítulo 1", 1);
        Capitulo capitulo2Temporada1Serie2 = new Capitulo("Capítulo 2", temporada1Serie2, "Sinopsis del Capítulo 2", 2);

        temporada1Serie1.setCapitulos(Arrays.asList(capitulo1Temporada1Serie1, capitulo2Temporada1Serie1));
        temporada2Serie1.setCapitulos(Arrays.asList(capitulo1Temporada2Serie1, capitulo2Temporada2Serie1));
        temporada1Serie2.setCapitulos(Arrays.asList(capitulo1Temporada1Serie2, capitulo2Temporada1Serie2));

        serie1.setTemporadas(Arrays.asList(temporada1Serie1, temporada2Serie1));
        serie2.setTemporadas(Arrays.asList(temporada1Serie2));

        // Crear algunos usuarios y valoraciones para las películas, series y capítulos
        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario();
        Usuario usuario3 = new Usuario();

        Valoracion valoracion1 = new Valoracion(usuario1, null, serie1, capitulo1Temporada1Serie1, "Buena serie", 4);
        Valoracion valoracion2 = new Valoracion(usuario2, null, serie1, capitulo2Temporada1Serie1, "Muy buena serie", 5);
        Valoracion valoracion3 = new Valoracion(usuario3, null, serie2, capitulo1Temporada1Serie2, "Divertida serie", 3);

        List<Valoracion> valoraciones = Arrays.asList(valoracion1, valoracion2, valoracion3);

        // Calcular la media de valoración de las series
        Map<Serie, Double> mediaValoracionSeries = UtilidadesNetflix.mediaValoracion(Arrays.asList(serie1, serie2), valoraciones);

        // Verificar que la media de valoración de las series es correcta
        Assertions.assertEquals(4.5, mediaValoracionSeries.get(serie1));
        Assertions.assertEquals(3.0, mediaValoracionSeries.get(serie2));
    }



    
}
