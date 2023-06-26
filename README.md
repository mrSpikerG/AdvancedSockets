# AdvancedSockets
This is my version of advanced socket networking in java


## Usage
ClientHandler - advancedSocket, with them you can send custom packets to server
PacketHandler - advancedSocket, with them you can recieve custom packets from server

Also you can add event onPacketRecieve and do something with recieved packet


## Packets
To create custom packet you need extend PacketBase and override read and write method.
Also you can override handlePacket (optional) 


## Events
To recieve events you must use EventHelper it's can register new class as events
