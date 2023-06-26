package ua.thespiker.sockets.client;

import ua.thespiker.sockets.common.interfaces.IPacketRecieved;
import ua.thespiker.sockets.common.packets.PacketBase;
import ua.thespiker.sockets.common.packets.SendMessagePacket;

public class DemoEventListener implements IPacketRecieved {
    @Override
    public void onPacketRecieved(PacketBase packetBase) {
        if(packetBase instanceof SendMessagePacket){
            System.out.println("Message: "+((SendMessagePacket)packetBase).message);
        }
    }
}
