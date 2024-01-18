/**
 * Interfaz que define los metodos necesarios para simular el funcionamiento de un radio
 * @author Jose Merida - 201105
 * @author Adrian Lopez - 21357
 * @version 1.0
 * @since 17-01-2024
 */

public interface ElMejorRadio {

    /**
     * Metodo para enceder la radio
     */
    void encender();

    /**
     * Metodo para saber si el radio se encuentra encendido
     * @return True si el radio esta encendido, False si esta apagado
     */
    boolean getEncendido();

    /**
     * Metodo para obtener la estacion actualmente sintonizada
     * @return la estacion actualmente sintonizada
     */
    float getEstacion();

    /**
     * Metodo para apagar la radio
     */
    void apagar();

    /**
     * Funcion para cambiar el volumen
     * @param volumen se indica que volumen se desea del 0 al 100
     */
    void setVolumen(int volumen);

    /**
     * Funcion para bambiar de banda am o fm
     * @param banda se indica con un entero que banda se quiere escuchar
     * AM=0 ; FM=1
     */
    void  cambiarBanda(int banda);

    /**
     * Funcion para subir de estación
     */
    void subirEmisora();

    /**
     * Funcion para bajar de estación
     */
    void bajarEmisora();

    /**
     * Funcion para guardar una emisora en la lista de 12 espacios
     * @param posicion indica en que posicion se quiere guardar la emisora
     * @param emisora indica la emisora que se quiere guardar
     */
    void guardarEmisora(int posicion, float emisora);

    /**
     * Metodo para seleccionar una emisora de las emisoras guardadas
     * @param posicion la posicion en la que se encuentra la emisora deseada
     */
    void seleccionarEmisora(int posicion);

    /**
     * Getter para el marametro volumen
     * @return el volumen actual
     */
    int getVolumen();

    /**
     * Nos permite saber si la radio esta en FM o AM
     * @return True para FM, False para AM
     */
    boolean getIsFM();
}
