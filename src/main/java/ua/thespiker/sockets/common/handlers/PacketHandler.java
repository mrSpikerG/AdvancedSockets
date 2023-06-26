package ua.thespiker.sockets.common.handlers;

import ua.thespiker.sockets.common.PacketRegister;
import ua.thespiker.sockets.common.helpers.DataHelper;
import ua.thespiker.sockets.common.helpers.EventHelper;
import ua.thespiker.sockets.common.packets.PacketBase;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.List;

public class PacketHandler extends Thread {

    private ServerSocket serverSocket;
    private Socket server;

    public PacketHandler(int port) throws IOException {
        serverSocket = new ServerSocket(port);

    }

    @Override
    public void run() {
        try {
            server = serverSocket.accept();
            while (true) {
                PacketBase packetBase = new PacketBase();
                recievePacket(packetBase);
            }
        } catch (Exception e) {
            System.out.println("exception");
            e.printStackTrace();
        }
    }

    public void recievePacket(PacketBase packet) throws Exception {
        packet.read(new DataInputStream(server.getInputStream()));
        List<PacketBase> temp = PacketRegister.getPackets();
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).Name.equals(packet.Name)) {
                packet = DataHelper.create(temp.get(i).getClass());
                packet.read(new DataInputStream(server.getInputStream()));
                EventHelper.getHelper().recievePacket(packet);
            }
        }

        packet.handlePacket();


    }
}
