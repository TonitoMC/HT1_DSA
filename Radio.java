/**
 * Clase que simula el funcionamiento de una radio
 * @author Jose Merida - 201105
 * @author Adrian Lopez - 21357
 * @version 1.0
 * @since 17-01-2024
 */

public class Radio implements ElMejorRadio {
    int volumen=50;
    Float estacion=87.9f;
    Float[] lista;
    Boolean isFM=true;
    Boolean isEncendido=false;

    /**
     * Constructor para la clase Radio, crea el nuevo objeto y la lista de 12 valores para guardar emisoras
     */
    public Radio() {
        lista = new Float[12];
    }

    /**
     * Getter para el atributo isEncendido
     * @return boolean isEncendido, True si el radio se encuentra encendido y False si se encuentra apagado
     */
    public boolean getEncendido() {
        return this.isEncendido;
    }

    /**
     * Getter para el atributo Volumen
     * @return int Volumen
     */
    public int getVolumen() {
        return this.volumen;
    }

    /**
     * Getter para la lista de emisoras
     * @return list lista, lista de emisoras guardadas
     */
    public Float[] getLista() {
        return this.lista;
    }

    /**
     * Getter para la estacion actual
     * @return float estacion, la estacion sintonizada actualmente
     */
    public float getEstacion() {
        return this.estacion;
    }
    /**
     * Metodo para cambiar estacion a una de las estaciones guardadas
     * @param posicion int correspondiente a la posicion de la emisora deseada
     */
    public void seleccionarEmisora(int posicion){
        //Cambia la estacion a la estacion almacenada en el indice de la lista correspondiente
        float estacionDeseada = lista[posicion];
        this.estacion = estacionDeseada;
        //Cambia la banda acorde a la que pertenece la estacion almacenada
        if (estacion < 200){
            cambiarBanda(true);
        } else{
            cambiarBanda(false);
        }
    }
    /**
     * Metodo para cambiar de estacion a una estacion especifica
     * @param estacion float de la estacion a la que se desea cambiar
     */
    public void setEstacion(Float estacion) {
        if (estacion < 200){
            cambiarBanda(true);
            this.estacion = estacion;
        } else{
            cambiarBanda(false);
            this.estacion = estacion;
        }
    }

    /**
     * Getter para isFM
     * @return True si se esta sintonizando FM, False para AM
     */
    public boolean getIsFM() {
        return this.isFM;
    }

    /**
     * Setter para isFM
     * @param isFM True para FM, False para AM
     */
    public void cambiarBanda(Boolean isFM) {
        this.isFM = isFM;
    }

    /**
     * Enciende el radio, cambia el estado de isEncendido a true
     */
    public void encender(){
        this.isEncendido=true;
    }

    /**
     * Apaga el radio, cambia el estado de isEncendido a false
     */
    public void apagar(){
        this.isEncendido=false;
    }

    /**
     * Setter para el atributo volumen
     * @param volumen se indica que volumen se desea del 0 al 100
     */
    public void setVolumen(int volumen){
        this.volumen=volumen;
    }

    /**
     * Cambia de banda y regresa a la estacion con menor frecuencia de la banda
     * @param banda se indica con un entero que banda se quiere escuchar, 1 para FM 0 para AM
     * AM=0 ; FM=1
     */
    public void cambiarBanda(int banda){
        if (banda==1){
            this.isFM=true;
            this.estacion=87.9f;
        }
        if (banda==0){
            this.isFM=false;
            this.estacion=530f;
        }
    }

    /**
     * Cambia de emisora a la siguiente emisora mayor, regresa a la menor si se intenta subir mas alla del limite
     */
    public void subirEmisora(){
        if (this.isFM==true){
            if (this.estacion == 107.9f){
                setEstacion(87.9f);
            }
            else {
                this.estacion = this.estacion + 0.2f;
            }
        }
        if(this.isFM==false){
            if(this.estacion == 1610f) {
                setEstacion(530f);
            }
            else{
                this.estacion = this.estacion + 10;
            }
        }
    }

    /**
     * Cambia de emisora a la siguiente emisora menor, regresa a la emisora mas alta luego de llegar al limite
     */
    public void bajarEmisora(){
        if (this.isFM==true){
            if (this.estacion == 87.9f){
                setEstacion(107.9f);
            }
            else {
                this.estacion = this.estacion - 0.2f;
            }
        }
        if(this.isFM==false){
            if (this.estacion == 530f){
                setEstacion(1610f);
            }
            else {
                this.estacion = this.estacion - 10;
            }
        }
    }

    /**
     * Guarda una emisora en la posicion indicada de la lista
     * @param posicion indica en que posicion se quiere guardar la emisora
     * @param estacion indica la emisora que se quiere guardar
     */
    public void guardarEmisora(int posicion, float estacion){
        this.lista[posicion] = estacion;
        System.out.println("Número " + estacion + " ingresado en la posición " + posicion);
    }
}