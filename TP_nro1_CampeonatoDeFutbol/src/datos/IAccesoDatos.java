package datos;

import java.time.LocalDate;

import dominio.Campeonato;

public interface IAccesoDatos {

    //CAMPOS CONSTANTES
    //METODOS ABSTRACTOS
    //01
    void guardar(Campeonato campeonato);

    //02
    void modificar(String nombreCampeonato, LocalDate nuevaFechaFin, int nuevaCantEquipos);
    
    //03
    Campeonato buscarUnCampeonato(String nombrecampeonato);

    //04
    void borrar(String nombreCampeonato);

    //05
    Campeonato[] listar();
    
    //06
    String filtrar();

}
