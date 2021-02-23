package socket;

public class Client {

    public static void main(String[] args) {

        new Thread(new StudentClient(7777,8888,"localhost")).start();
        new Thread(new TeacherClient(9999)).start();

    }
}
