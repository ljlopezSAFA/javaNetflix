package utilidades;

import modelos.*;

import java.time.LocalDate;
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

        List<Pelicula> peliculasFiltradas = new ArrayList<>();
        for(Pelicula p : peliculas){
            if(p.getGenero().equals(genero) && p.getPais().equals(pais) && p.getDuracion()>duracionMinima){
                peliculasFiltradas.add(p);
            }
        }
        return  peliculasFiltradas;

//
//        return peliculas
//                .stream()
//                .filter(p-> p.getGenero().equals(genero) && p.getPais().equals(pais) && p.getDuracion()>duracionMinima)
//                .collect(Collectors.toList());
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

        //PRIMERA CONDICIÓN
        boolean fechaInicioCorrecta = usuario.getPlanSubscripcion().getFechaInicio().isBefore(LocalDate.now()) ||
                usuario.getPlanSubscripcion().getFechaInicio().equals(LocalDate.now());

        //TERCERA CONDICIÓN
        boolean fechaFinCorrecta = usuario.getPlanSubscripcion().getFechaFin().isAfter(LocalDate.now());




        //SEGUNDA CONDICION
        boolean tipoPlanValido = false;

//        if(usuario.getPlanSubscripcion().getTipo().equals(Tipo.MENSUAL)){
////            tipoPlanValido = usuario.getPlanSubscripcion().getFechaInicio().plusMonths(1).equals(usuario.getPlanSubscripcion().getFechaFin());
////        }
////        else if(usuario.getPlanSubscripcion().getTipo().equals(Tipo.TRIMESTRAL)){
////            tipoPlanValido = usuario.getPlanSubscripcion().getFechaInicio().plusMonths(3).equals(usuario.getPlanSubscripcion().getFechaFin());
////        }
////        else if(usuario.getPlanSubscripcion().getTipo().equals(Tipo.CUATRIMESTRAL)){
////            tipoPlanValido = usuario.getPlanSubscripcion().getFechaInicio().plusMonths(4).equals(usuario.getPlanSubscripcion().getFechaFin());
////        }
////        else if (usuario.getPlanSubscripcion().getTipo().equals(Tipo.ANUAL)){
////            tipoPlanValido = usuario.getPlanSubscripcion().getFechaInicio().plusMonths(12).equals(usuario.getPlanSubscripcion().getFechaFin());
////        }

        switch (usuario.getPlanSubscripcion().getTipo()){
            case MENSUAL ->  tipoPlanValido = usuario.getPlanSubscripcion().getFechaInicio().plusMonths(1).equals(usuario.getPlanSubscripcion().getFechaFin());
            case TRIMESTRAL -> tipoPlanValido = usuario.getPlanSubscripcion().getFechaInicio().plusMonths(3).equals(usuario.getPlanSubscripcion().getFechaFin());
            case CUATRIMESTRAL ->  tipoPlanValido = usuario.getPlanSubscripcion().getFechaInicio().plusMonths(4).equals(usuario.getPlanSubscripcion().getFechaFin());
            case ANUAL -> tipoPlanValido = usuario.getPlanSubscripcion().getFechaInicio().plusMonths(12).equals(usuario.getPlanSubscripcion().getFechaFin());
        }

        return fechaInicioCorrecta && fechaFinCorrecta && tipoPlanValido;
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


//        List<Capitulo> capitulosFiltrados = new ArrayList<>();
//
//        for(Capitulo c : capitulos){
//            if(c.getTemporada().equals(temporada)){
//                capitulosFiltrados.add(c);
//            }
//        }
//        capitulosFiltrados.sort(Comparator.comparingInt(Capitulo::getOrden));
//        temporada.setCapitulos(capitulosFiltrados);
//        return capitulosFiltrados;

        List<Capitulo> filtrados = capitulos
                .stream()
                .filter(c-> c.getTemporada().equals(temporada))
                .sorted(Comparator.comparingInt(Capitulo::getOrden))
                .collect(Collectors.toList());

        temporada.setCapitulos(filtrados);

        return filtrados;




    }


    /**
     * Devuelve los capítulos de la serie asociados a su número de temporada
     *
     * @param serie
     * @return
     */
    public static Map<Integer, List<Capitulo>> CapitulosPorNumeroTemporada(Serie serie){

        Map<Integer, List<Capitulo>>mapa = new HashMap<>();

        for(Temporada temporada: serie.getTemporadas()){
            mapa.put(temporada.getNumTemporada(), temporada.getCapitulos());
        }
        return mapa;
//
//        return serie.getTemporadas()
//                .stream()
//                .collect(Collectors.toMap(Temporada::getNumTemporada , Temporada::getCapitulos));

    }


    /**
     * Devuelve el mapa de las series del género pasado, con sus capítulos asociados a su número de temporada
     *
     * @param series
     * @param genero
     * @return
     */
    public static Map<Serie,Map<Integer, List<Capitulo>>> CapitulosPorNumeroTemporadaSerieGenero(List<Serie> series, Genero genero){

        Map<Serie,Map<Integer, List<Capitulo>>> mapa = new HashMap<>();

        for(Serie s: series){
            if(s.getGenero().equals(genero)){
                mapa.put(s, CapitulosPorNumeroTemporada(s));

//                Map<Integer, List<Capitulo>> mapaSerie = new HashMap<>();
//
//                for(Temporada t: s.getTemporadas()){
//                    mapaSerie.put(t.getNumTemporada(), t.getCapitulos());
//                }
//
//                mapa.put(s, mapaSerie);

            }

        }
        return mapa;
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

        Map<Serie,Double> mapa = new HashMap<>();

        for(Serie s : series){
            List<Valoracion> valoracionesSerie = new ArrayList<>();

            for(Valoracion v : valoracions){
                if(v.getSerie().equals(s) || s.getCapitulos().contains(v.getCapitulo())){
                    valoracionesSerie.add(v);
                }
            }

            Double totalPuntuacion = 0.0;

            for(Valoracion v : valoracionesSerie){
                totalPuntuacion += v.getRating();
            }


            Double media = totalPuntuacion / valoracionesSerie.size();

            mapa.put(s, media);
        }


        return mapa;


//        return series
//                .stream()
//                .collect(Collectors.toMap(s-> s, s-> valoracions
//                        .stream()
//                        .filter(v-> v.getSerie().equals(s) || s.getCapitulos().contains(v.getCapitulo()))
//                        .mapToInt(Valoracion::getRating).average().getAsDouble()));







    }
}
