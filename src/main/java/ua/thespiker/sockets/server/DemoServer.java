package ua.thespiker.sockets.server;

import ua.thespiker.sockets.common.handlers.ClientHandler;
import ua.thespiker.sockets.common.helpers.EventHelper;
import ua.thespiker.sockets.common.packets.SendMessagePacket;

import java.io.IOException;
import java.util.Scanner;

public class DemoServer extends Thread {

    private ClientHandler handler;
    public DemoServer(){
        handler = new ClientHandler(6666,"127.0.0.1");
        EventHelper.getHelper().addMyEventListener(new DemoEventListener());

    }
    @Override
    public void run() {
        try {
            Scanner scan = new Scanner(System.in);
            while (true) {
                System.out.println("Write 'done' if exit");
                String answ = scan.nextLine();

                if (answ.equals("done")) {
                    break;
                }
                handler.sendPacket(new SendMessagePacket(answ));
            }

            handler.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
