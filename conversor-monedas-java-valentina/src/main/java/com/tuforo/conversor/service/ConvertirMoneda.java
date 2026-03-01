package com.tuforo.conversor.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuforo.conversor.model.ConversionResponse;

public class ConvertirMoneda {

    private final ClienteHttp cliente;
    private final ObjectMapper objectMapper;

    public ConvertirMoneda(ClienteHttp cliente) {
        this.cliente = cliente;
        this.objectMapper = new ObjectMapper();
    }

    public double convertir(String monedaOrigen, String monedaDestino, double cantidad) {
        String url = "https://api.exchangerate.host/convert?from=" + monedaOrigen + "&to=" + monedaDestino + "&amount="
                + cantidad;
        String jsonRespuesta = cliente.obtenerRespuesta(url);

        try {
            ConversionResponse respuesta = objectMapper.readValue(jsonRespuesta, ConversionResponse.class);
            if (respuesta.isSuccess()) {
                return respuesta.getResult();
            } else {
                throw new RuntimeException("La API devolvió un resultado fallido (success: false).");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al mapear la respuesta JSON: " + e.getMessage(), e);
        }
    }
}
