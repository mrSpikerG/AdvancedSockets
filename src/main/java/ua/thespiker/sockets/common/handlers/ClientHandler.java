package ua.thespiker.sockets.common.handlers;

import ua.thespiker.sockets.common.interfaces.IPacket;
import ua.thespiker.sockets.common.packets.PacketBase;
import ua.thespiker.sockets.common.packets.SendMessagePacket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler {

    private String serverName;
    private int port;
    private Socket client;

    public ClientHandler(int portVar, String ip) {
        port = portVar;
        serverName = ip;
        StartServer();
    }


    public void StartServer() {
        boolean isStart = false;
        while (!isStart) {
            try {
                isStart = true;
                client = new Socket(serverName, port);
                System.out.println("Подключение к " + serverName + " на порт " + port);

                System.out.println("Просто подключается к " + client.getRemoteSocketAddress());


                Thread.sleep(100);
            } catch (IOException e) {
                isStart = false;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void sendPacket(PacketBase packet) throws IOException {
        PacketBase base = new PacketBase();
        base.Name = packet.Name;
        sendOnePacket(base);
        sendOnePacket(packet);
    }

    private void sendOnePacket(IPacket packet) throws IOException {
        packet.write(new DataOutputStream(client.getOutputStream()));
    }

    public void close() throws IOException {
        client.close();
    }
}
