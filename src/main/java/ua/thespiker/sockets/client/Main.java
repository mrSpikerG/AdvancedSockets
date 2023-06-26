package ua.thespiker.sockets.client;

import ua.thespiker.sockets.common.handlers.PacketHandler;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // sending message to server
        Thread demoClient = new DemoClient();
        demoClient.start();

        // recieve message from server
        Thread packetHandler = new PacketHandler(6666);
        packetHandler.start();

    }
}