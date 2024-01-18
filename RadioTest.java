/**
 * Pruebas unitarias para metodos de la clase Radio
 * @author Jose Merida - 201105
 * @author Adrian Lopez - 21357
 * @version 1.0
 * @since 17-01-2024
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
class RadioTest {
    /**
     * Esta prueba unitaria toma 4 casos diferentes para comprobar el funcionamiento correcto del metodo subirEmisora.
     * Se comprueba un caso "normal" donde se debe de subir emisora y un caso donde se encuentra en la emisora "maxima"
     * para ambas bandas "AM" y "FM"
     * @param isFM La banda en la que se encuentra la radio, True para FM y False para AM
     * @param estacionInicial La estacion en la que se encuentra el radio antes de llamar subirEmisora
     * @param estacionEsperada La estacion que se espera que se encuentre el radio luego de llamar subirEmisora
     */
    @ParameterizedTest
    @CsvSource({"true, 87.9, 88.1", "true, 107.9, 87.9", "false, 1600, 1610", "false, 1610, 530"})
    void subirEmisora(boolean isFM, float estacionInicial, float estacionEsperada) {
        Radio radio = new Radio();
        radio.cambiarBanda(isFM);
        radio.setEstacion(estacionInicial);

        radio.subirEmisora();

        assertEquals(estacionEsperada, radio.getEstacion());
    }
    /**
     * Esta prueba unitaria toma 4 casos diferentes para comprobar el funcionamiento correcto del metodo bajarEmisora.
     * Se comprueba con un caso "normal" donde se debe subir emisora y un caso donde se encuentra en la emisora "minima"
     * para ambas bandas "AM" y "FM"
     * @param isFM La banda en la que se encuentra la radio, True para FM y False para AM
     * @param estacionInicial La estacion en la que se encuentra el radio antes de llamar bajarEmisora
     * @param estacionEsperada La estacion que se espera que se encuentre el radio luego de llamar subirEmisora
     */
    @ParameterizedTest
    @CsvSource({"true, 88.1, 87.9", "true, 87.9, 107.9", "false, 530, 1610", "false, 530, 1610"})
    void bajarEmisora(boolean isFM, float estacionInicial, float estacionEsperada){
        Radio radio = new Radio();
        radio.cambiarBanda(isFM);
        radio.setEstacion(estacionInicial);

        radio.bajarEmisora();

        assertEquals(estacionEsperada, radio.getEstacion());
    }
    @ParameterizedTest
    @CsvSource({"20","30", "40"})
    void setVolumen(int volumen){
        Radio radio = new Radio();

        radio.setVolumen(volumen);
        assertEquals(volumen, radio.getVolumen());
    }
}