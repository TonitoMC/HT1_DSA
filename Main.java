/**
 * Este programa tiene como funcionalidad simular el funcionamiento de una radio
 * @author Jose Merida - 201105
 * @author Adrian Lopez - 21357
 * @version 1.0
 * @since 17-01-2024
 */
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    /*
     * Funcion para desplegar el menu y leer la respuesta
     */
    private static int desplegarMenu() {
        int opcion=0;
        while(opcion>9 || opcion<1){
            System.out.println("\n\n Escoja una opcion del menú");
            System.out.println("1. Prende el radio");
            System.out.println("2. Cambia de AM a FM/ de FM a AM");
            System.out.println("3. Subir en el dial de las emisoras. Al llegar al final del dial inicia nuevamente.");
            System.out.println("4. Bajar en el dial de las emisoras. Al llegar al final del dial inicia nuevamente.");
            System.out.println("5. Guardar una emisora en uno de los 12 botones            ");
            System.out.println("6. Selecciona una de las emisoras guardadas");
            System.out.println("7. Establecer volumen");
            System.out.println("8. Apagar el radio");
            System.out.println("9. Cierra el menú");

            scan = new Scanner(System.in);
            try{opcion = scan.nextInt();}
            catch(Exception e){System.out.println("Ivalido");}
        }
        return opcion;
    }

    /*
     * Funcion para verificar todas las variables del radio e imprimirlas
     */
    public static void estadoRadio(Radio rad){
        String encendido="OF";
        String banda="";
        if(rad.getEncendido()==true){
            encendido="ON";
        }
        if(rad.getEncendido()==false){
            encendido="OF";
        }
        if(rad.getIsFM()==true){
            banda="FM";
        }
        if(rad.getIsFM()==false){
            banda="AM";
        }

        System.out.println("\n\n ON/OF: "+encendido);
        System.out.println("Volumen: "+ rad.getVolumen());
        System.out.println("Banda: "+ banda);
        System.out.println("Estación: "+ rad.getEstacion());
        System.out.println("Lista de guardadas: ");
        System.out.println(rad.getLista());

    }

    public static void main(String[] args){

        int opcion=0;
        Radio rad= new Radio();

        /*
         * Se ejecuta la logica en un ciclo while hasta que se oprima 9 para salir del menu
         */
        while(opcion!=9){
            estadoRadio(rad);
            opcion=desplegarMenu();

            if (opcion==1){
                rad.encender();
            }

            else if (opcion==2 && rad.getEncendido()==true){
                int respuesta;
                System.out.println("Oprima 1 para FM o 0 para AM");
                respuesta = scan.nextInt();
                rad.cambiarBanda(respuesta);
            }

            else if (opcion==3 && rad.getEncendido()==true ){
                rad.subirEmisora();
            }

            else if(opcion==4 && rad.getEncendido()==true){
                rad.bajarEmisora();
            }

            else if(opcion==5 && rad.getEncendido()==true){
                int posicion;
                float estacion;
                System.out.println("La lista de estaciones guardadas es la siguiente:");
                System.out.println(rad.getLista());
                System.out.println("¿En que posición desea guardar la estación");
                posicion = scan.nextInt();
                while(posicion<0||posicion>11){
                    System.out.println("Posicion invalida, vuelva a intentarlo");
                    System.out.println("¿En que posición desea guardar la estación?");
                    posicion = scan.nextInt();
                }
                System.out.println("¿Que estación desea guardar?");
                estacion = scan.nextFloat();
                rad.guardarEmisora(posicion, estacion);
                System.out.println(rad.getLista());
            }

            else if(opcion==6 && rad.getEncendido()==true){
                int posicion;
                System.out.println("¿Cual es la posicón de estación que quiere escuchar?");
                posicion = scan.nextInt();
                while(posicion<0||posicion>11){
                    System.out.println("Posicion invalida, vuelva a intentarlo");
                    System.out.println("¿Cual es la posicón de estación que quiere escuchar?");
                    posicion = scan.nextInt();
                }
                rad.seleccionarEmisora(posicion);
            }

            else if(opcion==7 && rad.getEncendido()==true){
                int respuesta;
                System.out.println("¿Que volumen desea (enteros del 0 al 100)?");
                respuesta = scan.nextInt();
                while(respuesta>100 || respuesta<0){
                    System.out.println("Respuesta invalida ¿Que volumen desea (enteros del 0 al 100)?");
                    respuesta = scan.nextInt();
                }
                rad.setVolumen(respuesta);
            }
            else if (opcion==8 ){
                rad.apagar();
            }
            else if(opcion==9){
                break;
            }
            else{
                System.out.println("Debe encender la radio primero");
            }

        }
    }
}
