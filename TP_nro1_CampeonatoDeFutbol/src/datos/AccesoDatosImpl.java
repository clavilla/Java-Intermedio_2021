package datos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import comparadores.*;
import dominio.Campeonato;

public class AccesoDatosImpl implements IAccesoDatos {

    //CAMPO
    private final List<Campeonato> arregloCampeonatos;

    //CONSTRUCTOR
    public AccesoDatosImpl() {
        arregloCampeonatos = new ArrayList<>();
    }

    //01
    @Override
    public void guardar(Campeonato campeonato) {
        arregloCampeonatos.add(campeonato);
    }

    //02
    @Override
    public void modificar(String nombreCampeonato, LocalDate nuevaFechaFin, int nuevaCantEquipos) {
        Campeonato campModificar = buscarUnCampeonato(nombreCampeonato);
        campModificar.setFechaFin(nuevaFechaFin);
        campModificar.setCantidadEquipos(nuevaCantEquipos);
    }

    //03
    @Override
    public Campeonato buscarUnCampeonato(String nombrecampeonato) {
        for (Campeonato miCampeonato : arregloCampeonatos) {
            if (miCampeonato.getNombre().equals(nombrecampeonato)) {
                return miCampeonato;
            }
        }
        return null;
    }
    
    //04
    @Override
    public void borrar(String nombreCampeonato) {
        Campeonato campBorrar = buscarUnCampeonato(nombreCampeonato);
        arregloCampeonatos.remove(campBorrar);
    }

    //05
    @Override
    public Campeonato[] listar() {
        arregloCampeonatos.sort(new CompararFechaCampeonato());
        return arregloCampeonatos.toArray(new Campeonato[0]);
    }
    
    //06
    @Override
    public String filtrar() {
       String nombCampeonatos = "";
        for (Campeonato miCampeonato : arregloCampeonatos) {
            nombCampeonatos += miCampeonato.getNombre() + ", ";

        }
        return nombCampeonatos;
    }
    


}
