import java.net.DatagramSocket;

/**
 * Created by tomek on 16.10.2017..
 */
public class UDPServ {

    public static void main(String []agrs) throws Exception{


    }

    public void run() throws Exception{

        DatagramSocket serverSocket = new DatagramSocket(5001);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        while(true){

        }
    }
}
