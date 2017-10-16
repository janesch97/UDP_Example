import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by tomek on 16.10.2017..
 */
public class UDPClient {

    public static void main(String []args) throws Exception{

        UDPClient udpClient = new UDPClient();
        udpClient.run();
    }

    public void run() throws Exception{

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        DatagramSocket clientSocket = new DatagramSocket();
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        String message = bufferedReader.readLine();
        sendData = message.getBytes();

        InetAddress IPAddr = InetAddress.getByName("localhost");

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddr, 5001);
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        String modifiedMessage = new String(receivePacket.getData());
        System.out.println("From server: "+modifiedMessage);

        clientSocket.close();
    }
}
