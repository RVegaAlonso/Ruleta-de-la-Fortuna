package juego;

import java.util.ArrayList;
import java.util.Scanner;

public class Panel {
    private static Scanner input = new Scanner(System.in);
    static String panelJugadorAdivinar;
    static String PistaJugador;
    static int aciertosJugador = 0;

    static ArrayList listaFrases = new ArrayList<String>();
    static ArrayList listaPistas = new ArrayList<String>();

    static ArrayList panelMuestraJugador = new ArrayList<Character>();
    static ArrayList panelOculto = new ArrayList<Character>();
    
    private static String pista;
    private static String frase;
    static int generador;
    public static char[] extraerNumeroAciertos;

    static void IniciarPanelJuego(){
        panelJugadorAdivinar = generarFrase();
        PistaJugador =  generarPista();
        System.out.println("    ");
        System.out.println("|======== Pista ========|");
        System.out.println("\n\n    " + PistaJugador + "\n\n");
        System.out.println("|=======================|");
    }




    public static void comprobarLetraJugador(char LetraEnviadaJugador){

        /*System.out.println(panelJugadorAdivinar);*/


        int lenghtPanelJugador = panelJugadorAdivinar.length();

        int posicionLetraOcultar = 0;
        
        char[] characterStringConvert;
        characterStringConvert  = panelJugadorAdivinar.toCharArray();

        for (int i = 0; i < lenghtPanelJugador; i++){

            posicionLetraOcultar++;

            if(characterStringConvert[i] == LetraEnviadaJugador){
                aciertosJugador++;
                char characterAcertadoJugador = characterStringConvert[i];
                
                /* Pasa la letra a el array oculto */
                panelOculto.set(posicionLetraOcultar - 1, characterAcertadoJugador);
            }
        }

        System.out.println("\nHas acertado "+ aciertosJugador + " letras");
        /*String[][] panelParaMostrar= new String [lenghtPanelJugador][2];*/
    }


    

    public static int extraerNumeroAciertos(){
        return aciertosJugador;
    }

    public static void resetCacheAciertos(){
        aciertosJugador = 0;
    }


    public static int random(){
        generador = new java.util.Random().nextInt(8);
        return generador;
    }
    
    public static void insertArrayListFrase(){
        listaFrases.add("Bocadillo de tortilla");
        listaFrases.add("Jamon asado con patatas");
        listaFrases.add("Clara de limon");
        listaFrases.add("Mario Bros");
        listaFrases.add("Pablo Motos");
        listaFrases.add("Si tu me dices ven");
        listaFrases.add("Abel Ramon Caballero Alvarez");
        listaFrases.add("Teclado y raton");
    }

    public static void insertArrayListPista(){
        listaPistas.add("Pincho de bar");
        listaPistas.add("Plato asado"); /*No fallo*/
        listaPistas.add("Bebida fría");
        listaPistas.add("Juego de un fontanero muy famoso");
        listaPistas.add("Presentador español");
        listaPistas.add("Éxito del cigala");
        listaPistas.add("Skater, B-Boy, bmxer, fresstyler y fanático de las led");
        listaFrases.add("Periféricos del ordenador");
    }


    public static String generarFrase() {
        /*
         ! Se necesita generar siempre la frase para poder obtener la Pista
        */


        generador = random();
        insertArrayListFrase();
        frase = (String) listaFrases.get(generador);
        return frase;
    }

    public static String generarPista(){
        insertArrayListPista();
        String PistaJugador = (String) listaPistas.get(generador);
        borrarPanel();
        return PistaJugador;
    }
    
   public static void borrarPanel() {
        listaFrases.remove(generador);
        listaPistas.remove(generador);
    }

    public static boolean resolverPanel() {
        System.out.println("Introduce tu intento de resolución: ");
        String intentoResolverJugador = input.nextLine();
        boolean comprobacionIntentoResolucion;

        if(intentoResolverJugador.equals(frase)){
            comprobacionIntentoResolucion = true;
            System.out.println("Has resuelto el panel,muy bien");
        }else{
            System.out.println("No has acertado, lo siento");
            comprobacionIntentoResolucion = false;
        }

        return comprobacionIntentoResolucion;
    }

    public static void generarArrayListFrase(){
        char[] characterPanel;
        characterPanel = frase.toCharArray();

        for (int i = 0; i < frase.length(); i++){
            panelMuestraJugador.add(characterPanel[i]);

            if (characterPanel[i] == ' '){
                panelOculto.add(' ');
            } else{
                panelOculto.add('*');
            }
        }
    }


    public static void mostrarPanel(){

        System.out.println("\n Panel Oculto \n");
        for (int i = 0; i < panelOculto.size();i++) {
            System.out.print(panelOculto.get(i));
        }
        System.out.println("\n");
    }

    public static void borrarPanelOculto(){
        panelOculto.clear();
    }
}
