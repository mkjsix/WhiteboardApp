/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sample.whiteboardapp;

import java.io.StringReader;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import javax.json.JsonObject;
import javax.json.Json;
import javax.json.JsonException;

/**
 *
 * @author Maurizio Turatti <info@maurizioturatti.com>
 */
public class FigureDecoder implements Decoder.Text<Figure> {

    @Override
    public Figure decode(String text) throws DecodeException {
        JsonObject jsonObject = Json.createReader(new StringReader(text)).readObject();
        return new Figure(jsonObject);
    }

    @Override
    public boolean willDecode(String text) {
        try {
            Json.createReader(new StringReader(text)).readObject();
            return true;
        } catch (JsonException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public void init(EndpointConfig config) {
        System.out.println("init");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
