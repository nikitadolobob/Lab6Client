package client;

import Commands.Command;
import Commands.Receiver;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

public class ServerSender {
    private Command command;

    public ServerSender(Command command){
        this.command = command;
    }

    public void sendToServer(){
        try{
            //send
            DatagramChannel channel = DatagramChannel.open();
            channel.configureBlocking(false);

            InetSocketAddress address = new InetSocketAddress("localhost", 9875);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(command);
            byte[] sendData = baos.toByteArray();

            ByteBuffer buffer = ByteBuffer.wrap(sendData);
            channel.send(buffer, address);


            //recieve
            long timer = 5000000;
            while(true){
                if(timer == 0) break;
                try {
                    ByteBuffer receiveBuffer = ByteBuffer.allocate(4096);
                    channel.receive(receiveBuffer);
                    receiveBuffer.flip();
                    byte[] receiveData = new byte[receiveBuffer.remaining()];
                    receiveBuffer.get(receiveData);

                    ByteArrayInputStream bis = new ByteArrayInputStream(receiveData);
                    ObjectInputStream ois = new ObjectInputStream(bis);
                    Receiver receiver = (Receiver) ois.readObject();

                    ois.close();
                    bis.close();

                    System.out.println(receiver.getLine());

                    channel.close();
                    break;
                }catch (Exception e){
                    timer--;
                    continue;
                }

            }
            if(timer == 0){
                System.out.println("Can not recieve answer from server");
                return;
            }

        } catch (IOException e) {
            System.out.println("Something went wrong while sending data to the server");
        }
    }
}
