package ua.thespiker.sockets.common.packets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class SendMessagePacket extends PacketBase {

    public String message;

    public SendMessagePacket() {

    }

    public SendMessagePacket(String text) {
        super("MessagePacket");
        message = text;
    }

    @Override
    public void write(DataOutputStream out) throws IOException {
       super.write(out);
        out.writeUTF(message);

    }

    @Override
    public void read(DataInputStream in) throws IOException {
        super.read(in);
        message = in.readUTF();
    }

    @Override
    public void handlePacket() {

    }
}
