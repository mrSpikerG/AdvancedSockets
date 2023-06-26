package ua.thespiker.sockets.common;

import ua.thespiker.sockets.common.packets.PacketBase;
import ua.thespiker.sockets.common.packets.SendMessagePacket;

import java.util.ArrayList;
import java.util.List;

public class PacketRegister {
    private static List<PacketBase> packets = null;

    public static void registerPacket(PacketBase packet){
        packets.add(packet);
    }

    public static List<PacketBase> getPackets() {
        if(packets == null){
            packets = new ArrayList<>();
            packets.add(new SendMessagePacket(""));
        }
        return packets;
    }
}
