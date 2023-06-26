package ua.thespiker.sockets.common.helpers;

import ua.thespiker.sockets.common.interfaces.IPacketRecieved;
import ua.thespiker.sockets.common.packets.PacketBase;

import java.util.ArrayList;
import java.util.List;

public class EventHelper {

    private static EventHelper helper = null;

    public static EventHelper getHelper() {
        if(helper==null){
            helper = new EventHelper();
        }
        return helper;
    }

    private List<IPacketRecieved> eventListeners;

    public EventHelper() {
        this.eventListeners = new ArrayList<IPacketRecieved>();
    }

    public void addMyEventListener(IPacketRecieved evtListener) {
        this.eventListeners.add(evtListener);
    }

    public void recievePacket(PacketBase packet) {
        eventListeners.forEach((el) -> el.onPacketRecieved(packet));
    }
}
