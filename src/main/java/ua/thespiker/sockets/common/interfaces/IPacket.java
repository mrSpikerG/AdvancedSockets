package ua.thespiker.sockets.common.interfaces;

import java.io.*;

public interface IPacket {

     /**
      * Convert class values to bytes
      * @param DataOutputStream
      * @throws IOException
      *
      */
     void write(DataOutputStream out) throws IOException;


     /**
      * Convert bytes to class values
      * @param DataInputStream
      * @throws IOException
      *
      */
     void read(DataInputStream in) throws IOException ;

     /**
      * Do something when packet recieved
      * @throws IOException
      *
      */
     void handlePacket();


}
