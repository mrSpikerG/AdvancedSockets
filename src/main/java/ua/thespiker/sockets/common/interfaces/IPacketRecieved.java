package ua.thespiker.sockets.common.interfaces;

import ua.thespiker.sockets.common.packets.PacketBase;

public interface IPacketRecieved {

    void onPacketRecieved(PacketBase packetBase);
}
