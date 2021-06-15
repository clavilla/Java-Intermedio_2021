package dominio;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class Campeonato {

    //CAMPOS
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalDate limiteInscripcion;
    private SistemaCampeonato sistemaCampeonato;
    private TipoCampeonato tipoCampeonato;
    private int cantidadEquipos;
    int duracionCampeonato;

    //CONSTRUCTORES
    public Campeonato() {

    }

    public Campeonato(String nombre, LocalDate fechaInicio, LocalDate fechaFin, SistemaCampeonato sistemaCampeonato,
            TipoCampeonato tipoCampeonato, int cantidadEquipos) {
        super();
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.sistemaCampeonato = sistemaCampeonato;
        this.tipoCampeonato = tipoCampeonato;
        this.cantidadEquipos = cantidadEquipos;
    }

    //METODOS
    public int calcularDuracionCampeonato() {
        duracionCampeonato = (int) DAYS.between(fechaInicio, fechaFin);

        return duracionCampeonato;
    }

    public int cuantasFechas() {
        int cantFechas = 0;

        SistemaCampeonato sist = SistemaCampeonato.TODOS_CONTRA_TODOS;

        if (sist == SistemaCampeonato.TODOS_CONTRA_TODOS) {
            cantFechas = cantidadEquipos - 1;
        } else {
            cantFechas = cantidadEquipos / 4;
        }

        return cantFechas;
    }

    public int cuantosPartidos() {
        int partidos = 0;

        SistemaCampeonato sist = SistemaCampeonato.TODOS_CONTRA_TODOS;

        if (sist == SistemaCampeonato.TODOS_CONTRA_TODOS) {
            partidos = cuantasFechas() * cantidadEquipos / 2;
        } else {
            partidos = cantidadEquipos - 1;
        }

        return partidos;
    }

    public LocalDate limiteInscripcion() {

        limiteInscripcion = DAYS.addTo(fechaInicio, -30);

        return limiteInscripcion;
    }


    //GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDate getLimiteInscripcion() {
        return limiteInscripcion;
    }

    public void setLimiteInscripcion(LocalDate limiteInscripcion) {
        this.limiteInscripcion = limiteInscripcion;
    }

    public SistemaCampeonato getSistemaCampeonato() {
        return sistemaCampeonato;
    }

    public void setSistemaCampeonato(SistemaCampeonato sistemaCampeonato) {
        this.sistemaCampeonato = sistemaCampeonato;
    }

    public TipoCampeonato getTipoCampeonato() {
        return tipoCampeonato;
    }

    public void setTipoCampeonato(TipoCampeonato tipoCampeonato) {
        this.tipoCampeonato = tipoCampeonato;
    }

    public int getCantidadEquipos() {
        return cantidadEquipos;
    }

    public void setCantidadEquipos(int cantidadEquipos) {
        this.cantidadEquipos = cantidadEquipos;
    }

    @Override
    public String toString() {
        return "Campeonato [nombre=" + nombre + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
                + ", sistemaCampeonato=" + sistemaCampeonato + ", tipoCampeonato=" + tipoCampeonato
                + ", cantidadEquipos=" + cantidadEquipos + "]";
    }

}
