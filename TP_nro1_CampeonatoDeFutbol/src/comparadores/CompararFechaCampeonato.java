package comparadores;


import java.util.Comparator;
import dominio.Campeonato;

public class CompararFechaCampeonato implements Comparator<Campeonato> {

    @Override
    public int compare(Campeonato camp1, Campeonato camp2) {
        return camp1.getFechaInicio().compareTo(camp2.getFechaInicio());
    }
    
}