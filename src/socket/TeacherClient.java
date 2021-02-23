package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TeacherClient implements Runnable {


    private String ToIp;
    private  int port;
    private DatagramSocket server;

    public TeacherClient(int port) {
        this.port = port;
        try {
            server = new DatagramSocket(this.port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {

             byte[] container = new byte[1024*60];
             DatagramPacket packet = new DatagramPacket(container,0,container.length);
            try {
                server.receive(packet);
                byte[] datas = packet.getData();
                int length = packet.getLength();
                String data = new String(datas, 0, length);
                System.out.println(data);
                if(data.equals("over")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        server.close();
    }
}
