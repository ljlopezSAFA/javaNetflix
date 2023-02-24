package utilidades;

import modelos.*;

import java.util.*;
import java.util.stream.Collectors;

public class UtilidadesNetflix {

    public UtilidadesNetflix() {
    }

    /**
     *
     * Devuelve todas las películas cuyo género y país coninciden con los pasados
     * y cuya duración es mayor a la que se manda
     *
     * @param peliculas
     * @param pais
     * @param genero
     * @param duracionMinima
     * @return
     */
    public static List<Pelicula> getPorGeneroPaisDuracion(List<Pelicula> peliculas, String pais, Genero genero, int duracionMinima){
        return  new ArrayList<>();
    }


    /**
     * Devuelve si el plan de subscripcion del usuario es válido para ser válido tiene que cumplir lo siguiente
     *
     * -> Que la fecha de inicio sea anterior o igual a la actual.
     * -> Que la fecha de fin coincida sumandole a la fecha inicio los meses del tipo de plan.
     * -> Que la fecha de fin sea posteiror a la fecha actual.
     *
     * @param usuario
     * @return
     */
    public static boolean  tienePlanDeSubscripcionValido(Usuario usuario){
        return false;
    }


    /**
     * Devuelvo de los capítulos pasados, los que son de la temporada indicada, ordenados por orden.
     * Finalmente establece a la temporada los capítulos ordenados.
     *
     * @param temporada
     * @param capitulos
     * @return
     */
    public static List<Capitulo> ordenarCapitulosTemporada(Temporada temporada, List<Capitulo> capitulos){
        return new ArrayList<>();
    }


    /**
     * Devuelve los capítulos de la serie asociados a su número de temporada
     *
     * @param serie
     * @return
     */
    public static Map<Integer, List<Capitulo>> CapitulosPorNumeroTemporada(Serie serie){
        return new HashMap<>();
    }


    /**
     * Devuelve el mapa de las series del género pasado, con sus capítulos asociados a su número de temporada
     *
     * @param series
     * @param genero
     * @return
     */
    public static Map<Serie,Map<Integer, List<Capitulo>>> CapitulosPorNumeroTemporadaSerieGenero(List<Serie> series, Genero genero){
        return new HashMap<>();
    }


    /**
     * Devuelve el mapa de la media de valoracion por serie, que se calcula de las valoraciones aportadas
     * que pertenezcan a la serie o capítulos de la serie y calcule la media todas sus valoraciones por serie
     *
     * @param series
     * @param valoracions
     * @return
     */
    public static Map<Serie, Double> mediaValoracion(List<Serie> series,List<Valoracion> valoracions){
        return new HashMap<>();
    }
}
