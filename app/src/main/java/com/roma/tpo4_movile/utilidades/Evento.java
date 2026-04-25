package com.roma.tpo4_movile.utilidades;

/**
 * Usado como un wrapper para datos que son expuestos via LiveData que representan un evento.
 */
public class Evento<T> {
    private T contenido;
    private boolean manejado = false;

    public Evento(T contenido) {
        this.contenido = contenido;
    }

    /**
     * Retorna el contenido y previene su uso nuevamente.
     */
    public T obtenerContenidoSiNoSidoManejado() {
        if (manejado) {
            return null;
        } else {
            manejado = true;
            return contenido;
        }
    }

    /**
     * Retorna el contenido, incluso si ya ha sido manejado.
     */
    public T verContenido() {
        return contenido;
    }
}
