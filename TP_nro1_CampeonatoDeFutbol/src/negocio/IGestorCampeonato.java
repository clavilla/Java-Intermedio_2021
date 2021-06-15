package negocio;

import java.time.LocalDate;

import dominio.SistemaCampeonato;
import dominio.TipoCampeonato;

public interface IGestorCampeonato {

    //METODOS ABSTRACTOS
    //01
    void agregarCampeonato(String nombreCampeonato, LocalDate fechaInicio, LocalDate fechaFin, SistemaCampeonato sistemaCamp, TipoCampeonato tipoCamp, int cantEquipos);

    //02
    void modificarCampeonato(String nombreCampeonato, LocalDate nuevaFechaFin, int nuevaCantEquipos);

    //03
    String consultarCampeonato(String nombreCamp);

    //04
    void borrarCampeonato(String campeonatoBorrar);

    //05
    String listarCampeonatos();

    //06
    String filtrarCampeonato(String caracteres);
}
