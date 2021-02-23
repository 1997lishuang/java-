package java之文件上传;

import socket.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
    private  static InputStream inputStream;
    private static OutputStream os;
    private static Socket client;
    public static void main(String[] args) throws IOException {
        System.out.println("服务器");
        try {
            ServerSocket serverSocket =  new ServerSocket(8888);
            client = serverSocket.accept();
            System.out.println("已经建立连接！");
            inputStream = new BufferedInputStream(client.getInputStream());
            os = new BufferedOutputStream(new FileOutputStream("src/2.JPG"));
            byte[] flush = new byte[1024];
            int len = -1;

            while ((len=inputStream.read(flush))!=-1){
                os.write(flush,0,len);
            }
            os.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        inputStream.close();
        os.close();
        client.close();
    }
}
