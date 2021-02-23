package java之文件上传;

import java.io.*;
import java.net.Socket;

public class FileClient {
    private  static InputStream inputStream;
    private static  OutputStream os;
    private static Socket client;
    public static void main(String[] args) throws IOException {

        System.out.println("客户端");
        try {
            client = new Socket("localhost",8888);
            //读取二进制文件
            inputStream = new BufferedInputStream(new FileInputStream("src/1.JPG"));
            //写出数据
            os = new BufferedOutputStream(client.getOutputStream());
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
