/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sample.whiteboardapp;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.Session;

/**
 *
 * @author Maurizio Turatti <info@maurizioturatti.com>
 */
@ServerEndpoint("/whiteboardendpoint")
public class MyWhiteboard {

    private static final Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

    @OnMessage
    public String onMessage(String message) {
        return null;
    }

    @OnOpen
    public void onOpen(Session peer) {
        peers.add(peer);
    }

    @OnClose
    public void onClose(Session peer) {
        peers.remove(peer);
    }
}
