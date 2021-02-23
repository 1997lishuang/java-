package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class StudentClient implements Runnable{

    private int port;
    private int ToPort;
    private String ToIp;
    private DatagramSocket client;
    private BufferedReader reader;

    public StudentClient(int port, int toPort, String toIp) {

        ToPort = toPort;
        ToIp = toIp;

        try {
            client = new DatagramSocket(this.port);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        while (true){

            String data;

            try {
                data  = reader.readLine();
                byte[] bytes = data.getBytes();
                DatagramPacket Packet = new DatagramPacket(bytes,0,bytes.length,
                        new InetSocketAddress(this.ToIp,this.ToPort));
                client.send(Packet);
                if(data.equals("over")){
                     break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        client.close();
    }
}
