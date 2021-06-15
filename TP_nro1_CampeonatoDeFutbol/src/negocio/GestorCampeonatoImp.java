package negocio;

import java.time.LocalDate;

import datos.*;
import dominio.*;
import java.util.StringTokenizer;
import java.util.regex.*;

public class GestorCampeonatoImp implements IGestorCampeonato {

    //CAMPO
    private final IAccesoDatos datos;

    //CONSTRUCTOR
    public GestorCampeonatoImp() {
        datos = new AccesoDatosImpl();
    }

    //01
    @Override
    public void agregarCampeonato(String nombreCampeonato, LocalDate fechaInicio, LocalDate fechaFin,
            SistemaCampeonato sistemaCamp, TipoCampeonato tipoCamp, int cantEquipos) {

        Campeonato nuevoCampeonato = new Campeonato(nombreCampeonato, fechaInicio, fechaFin, sistemaCamp, tipoCamp, cantEquipos);

        datos.guardar(nuevoCampeonato);
    }

    //02
    @Override
    public void modificarCampeonato(String nombreCampeonato, LocalDate nuevaFechaFin, int nuevaCantEquipos) {
        datos.modificar(nombreCampeonato, nuevaFechaFin, nuevaCantEquipos);

    }

    //03
    @Override
    public String consultarCampeonato(String nombreCamp) {
        String informacion = "\nLas especificaciones del " + nombreCamp + " son: ";
        Campeonato campInfo = datos.buscarUnCampeonato(nombreCamp);
        
        if(campInfo != null){
            informacion += "\n";
            informacion += "\nNombre: " + campInfo.getNombre();
            informacion += "\nFecha Inicio: " + campInfo.getFechaInicio() + " / Fecha ingresada de Finalización: " + campInfo.getFechaFin();
            informacion += "\nDuración: " + campInfo.calcularDuracionCampeonato() + " días";
            informacion += "\nFecha límite de inscripción: " + campInfo.limiteInscripcion();
            informacion += "\nTipo y sistema de campeonato: " + campInfo.getTipoCampeonato() + " - Sistema: " + campInfo.getSistemaCampeonato();
            informacion += "\nCaracterísticas del sist. de camp.: " + campInfo.getSistemaCampeonato().getCaracteristica();
            informacion += "\nCantidad Equipos: " + campInfo.getCantidadEquipos();
            informacion += "\nCantidad de Fechas: " + campInfo.cuantasFechas();
            informacion += "\nCant Partidos: " + campInfo.cuantosPartidos();
        }
        return informacion;

    }

    //04
    @Override
    public void borrarCampeonato(String campeonatoBorrar) {
        datos.borrar(campeonatoBorrar);

    }

    //05
    @Override
    public String listarCampeonatos() {
        Campeonato[] campeonatos = datos.listar();
        String listado = "__LISTADO__\n[\n";

        for (Campeonato campeonato : campeonatos) {
            if (campeonato != null) {
                listado += campeonato + "\n";
            }
        }

        listado += "]";

        return listado;
    }

    //06
    @Override
    public String filtrarCampeonato(String caracteres){
        String nombreCampeonatos = datos.filtrar();
        String filtrado = "";

        Pattern pat = Pattern.compile(".*" +caracteres+ ".*");
        Matcher mat = pat.matcher(tokenizer(nombreCampeonatos));

        while(mat.find()){
            filtrado += mat.group() + "\n";
            
        }
        return filtrado;
    }
    
    private String tokenizer(String nomCamps){
        StringTokenizer token = new StringTokenizer(nomCamps, ",");
        String unToken ="";
        while(token.hasMoreTokens()){
            unToken += token.nextToken() + "\n";
        }
        System.out.println("TOKEN: " + unToken);
        return unToken;
    }

}
