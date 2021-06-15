package presentacion;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

import static dominio.SistemaCampeonato.*;

import dominio.SistemaCampeonato;
import dominio.TipoCampeonato;
import negocio.GestorCampeonatoImp;
import negocio.IGestorCampeonato;

public class Principal {

    public static void main(String[] args) {
        menuOpciones();
    }

    public static void menuOpciones() {
        IGestorCampeonato campeonato = new GestorCampeonatoImp();
        
        // Dummy Test
        campeonato.agregarCampeonato("Primera A", LocalDate.of(2021, 1, 1), LocalDate.of(2021, 03, 30), ELIMINATORIAS, TipoCampeonato.APERTURA, 16);
        campeonato.agregarCampeonato("Copa Rugeri", LocalDate.of(2021, 4, 1), LocalDate.of(2021, 05, 30), ELIMINATORIAS, TipoCampeonato.CLAUSURA, 32);
        campeonato.agregarCampeonato("Copa Verano", LocalDate.of(2022, 1, 1), LocalDate.of(2022, 04, 30), TODOS_CONTRA_TODOS, TipoCampeonato.CLAUSURA, 20);
        campeonato.agregarCampeonato("Nacional B", LocalDate.of(2022, 6, 1), LocalDate.of(2022, 10, 30), TODOS_CONTRA_TODOS, TipoCampeonato.APERTURA, 40);
        
        Scanner teclado = new Scanner(System.in);
        int opciones;

        do {
            System.out.printf("%n==MENU OPCIONES=="
                    + "%n1 - %-20s"
                    + "%n2 - %-20s"
                    + "%n3 - %-20s"
                    + "%n4 - %-20s"
                    + "%n5 - %-20s"
                    + "%n6 - %-20s"
                    + "%n0 - %-20S"
                    + "%nIngrese una opcion: ",
                    "Registrar campeonato.",
                    "Modificar campeonato.",
                    "Consultar campeonato.",
                    "Eliminar campeonato.",
                    "Listar campeonatos ordenados por fecha.",
                    "Filtrar campeonatos.",
                    "Salir");
            opciones = Integer.parseInt(teclado.nextLine());

            switch (opciones) {
                case 1:
                    System.out.println("Ingrese el nombre del campeonato: ");

                    String nombre = teclado.nextLine();

                    LocalDate fechaInicio = ingresarFecha(0);
                    LocalDate fechaFin = ingresarFecha(1);

                    SistemaCampeonato sistema = ingresarSistema();
                    TipoCampeonato tipoCamp = ingresarTipoCamp();

                    System.out.println("Ingrese la cantidad de equipos participantes: ");
                    int cantEquipos = Integer.parseInt(teclado.nextLine());

                    campeonato.agregarCampeonato(nombre, fechaInicio, fechaFin, sistema, tipoCamp, cantEquipos);

                    break;
                case 2:
                    System.out.printf("Ingrese el nombre del campeonato a modificar: %n");
                    String nombreCampeonato = teclado.nextLine();
                    LocalDate nuevaFechaFin = ingresarFecha(1);
                    System.out.println("Ingrese la nueva cantidad de equipos participantes: ");
                    int nuevaCantEquipos = Integer.parseInt(teclado.nextLine());
                    campeonato.modificarCampeonato(nombreCampeonato, nuevaFechaFin, nuevaCantEquipos);
                    break;
                case 3:
                    System.out.printf("Ingrese el nombre del campeonato a consultar: %n");
                    String nombreCamp = teclado.nextLine();
                    System.out.printf("%s%n", campeonato.consultarCampeonato(nombreCamp));
                    break;
                case 4:
                    System.out.printf("Ingrese el nombre del campeonato a eliminar: %n");
                    String campeonatoBorrar = teclado.nextLine();
                    campeonato.borrarCampeonato(campeonatoBorrar);
                    break;
                case 5:
                    System.out.printf("%s%n", campeonato.listarCampeonatos());
                    break;
                case 6:
                    System.out.println("Ingrese letras a filtrar: ");
                    String caracteres = teclado.nextLine();
                    System.out.println(campeonato.filtrarCampeonato(caracteres));
                    break;
                case 0:
                    System.out.printf("%S%n", "\nHasta pronto!");
                    break;
                default:
                    System.out.printf("\nLa opcion %d es incorrecta%n", opciones);
            }

        } while (opciones != 0);
        teclado.close();
    }

    public static LocalDate ingresarFecha(int var) {
        Scanner teclado;
        teclado = new Scanner(System.in);
        int anio = 0;
        int nroMes;
        int dia = 0;
        Month mes = null;

        if (var == 0) {
            System.out.println("Ingresar el anio del campeonato: ");
            anio = Integer.parseInt(teclado.nextLine());

            System.out.println("Ingresar el numero del mes:"
                    + "\n1 - Enero\t2 - Febrero\t3 - Marzo"
                    + "\n4 - Abril\t5 - Mayo\t6 - Junio"
                    + "\n7 - Julio\t8 - Agosto\t9 - Septiembre"
                    + "\n10 - Octubre\t11 - Noviembre\t12 - Diciembre");
            nroMes = Integer.parseInt(teclado.nextLine());
            mes = Month.of(nroMes);

            System.out.println("Ingresar el dia de inicio del campeonato: ");
            dia = Integer.parseInt(teclado.nextLine());

            return LocalDate.of(anio, mes, dia);
        } else {
            System.out.println("Ingresar el anio de finalización del campeonato: ");
            anio = Integer.parseInt(teclado.nextLine());

            System.out.println("Ingresar el numero del mes de finalización del campeonato:"
                    + "\n1 - Enero\t2 - Febrero\t3 - Marzo"
                    + "\n4 - Abril\t5 - Mayo\t6 - Junio"
                    + "\n7 - Julio\t8 - Agosto\t9 - Septiembre"
                    + "\n10 - Octubre\t11 - Noviembre\t12 - Diciembre");
            nroMes = Integer.parseInt(teclado.nextLine());
            mes = Month.of(nroMes);

            System.out.println("Ingresar el dia de finalización del campeonato: ");
            dia = Integer.parseInt(teclado.nextLine());

            return LocalDate.of(anio, mes, dia);
        }

    }

    public static SistemaCampeonato ingresarSistema() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresar el Sistema del Campeonato:"
                + "\n1 - Todos contra todos\t2 - Eliminatorias");
        int nroSistema = Integer.parseInt(teclado.nextLine());

        switch (nroSistema) {
            case 1:
                return TODOS_CONTRA_TODOS; //Para usar solo la constante, se debe usar el import static
            case 2:
                return ELIMINATORIAS;
            default:
                return null;
        }
    }

    public static TipoCampeonato ingresarTipoCamp() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresar el Tipo de Campeonato:"
                + "\n1 - Clausura\t2 - Apertura");
        int nroTipo = Integer.parseInt(teclado.nextLine());

        switch (nroTipo) {
            case 1:
                return TipoCampeonato.CLAUSURA;
            case 2:
                return TipoCampeonato.APERTURA;
            default:
                return null;

        }
    }

}
