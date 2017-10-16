import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by tomek on 16.10.2017..
 */
public class UDPServ {

    public static void main(String []agrs) throws Exception{

        UDPServ udpServ = new UDPServ();
        udpServ.run();
    }

    public void run() throws Exception{

        DatagramSocket serverSocket = new DatagramSocket(5001);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        while(true){

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            String message = new String(receivePacket.getData());

            System.out.println("From client: "+message);

            InetAddress IPAddr = receivePacket.getAddress();
            int port = receivePacket.getPort();

            String modifiedMessage = message.toUpperCase();
            sendData = modifiedMessage.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddr, port);
            serverSocket.send(sendPacket);
        }
    }
}
