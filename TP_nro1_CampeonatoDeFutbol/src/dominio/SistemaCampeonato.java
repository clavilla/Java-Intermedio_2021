package dominio;

public enum SistemaCampeonato {

    TODOS_CONTRA_TODOS("Se juega una cantidad de fechas igual a la cantidad de equipos menos uno"),
    ELIMINATORIAS("Se organizan tantos partidos como sean necesarios para finalizar con dos equipos jugando la final");

    private final String caracteristica;

    private SistemaCampeonato(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getCaracteristica() {
        return caracteristica;
    }
}
