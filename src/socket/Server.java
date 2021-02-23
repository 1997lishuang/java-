package socket;

public class Server {
    public static void main(String[] args) {
        new Thread(new TeacherClient(8888)).start();
        new Thread(new StudentClient(6666,9999,"localhost")).start();
    }
}
