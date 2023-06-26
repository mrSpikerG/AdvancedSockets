package ua.thespiker.sockets.common.packets;

import ua.thespiker.sockets.common.interfaces.IPacket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PacketBase implements IPacket {
    public String Name;

    public PacketBase(String name){
        this.Name = name;
    }
    public PacketBase(){}

    @Override
    public void write(DataOutputStream out) throws IOException {
        out.writeUTF(Name);
    }

    @Override
    public void read(DataInputStream in) throws IOException {
        this.Name=in.readUTF();
    }

    @Override
    public void handlePacket() {

    }
}
