package ua.thespiker.sockets.server;


import ua.thespiker.sockets.common.handlers.PacketHandler;

import java.io.IOException;

public class Main extends Thread {


    private static int port  = 8888;

    public static void main(String [] args) throws IOException {

        // recieve message from server
        Thread packetHandler = new PacketHandler(port);
        packetHandler.start();

        // sending message to server
        Thread demoServer =new DemoServer();
        demoServer.start();
    }
}