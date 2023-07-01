package com.gmail.mekhanich.andrii;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        BINARY

        try (FileOutputStream binaryFile = new FileOutputStream("data.dat");
             FileChannel binChannel = binaryFile.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(100);

            byte[] outputBytes = "Hello World".getBytes();
            buffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            buffer.putInt(245);
            long int2Pos = int1Pos + Integer.BYTES;
            buffer.putInt(-98765);

            byte[] outputBytes2 = "Nice to meet you!".getBytes();
            buffer.put(outputBytes2);
            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
            buffer.putInt(1000);
//            buffer.put(outputBytes).putInt(245).putInt(-98765).put(outputBytes2).putInt(1000);
            buffer.flip();

            binChannel.write(buffer);

            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();

//            READ IN REVERSE ORDER

            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
            channel.position(int3Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int3 = " + readBuffer.getInt());

            readBuffer.flip();
            channel.position(int2Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int2 = " + readBuffer.getInt());

            readBuffer.flip();
            channel.position(int1Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int1 = " + readBuffer.getInt());

//            COPY FROM FILE TO FILE
            RandomAccessFile copyFile = new RandomAccessFile("dataCopy.dat", "rwd");
            FileChannel copyChannel = copyFile.getChannel();
            channel.position(0);
//            long numTransferred = copyChannel.transferFrom(channel,0, channel.size());
            long numTransferred = channel.transferTo(0, channel.size(), copyChannel);
            System.out.println("Num transferred -> " + numTransferred);

            channel.close();
            copyFile.close();
            copyChannel.close();

//            byte[] outputString = "Hello World!".getBytes();
//            long str1Pos = 0;
//            long new_int1Pos = outputString.length;
//            long new_int2Pos = new_int1Pos+Integer.BYTES;
//            byte[] outputString01 = "Hey! How are you?".getBytes();
//            long str2Pos = new_int2Pos + Integer.BYTES;
//            long new_int3Pos = outputString01.length;
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(245);
//            intBuffer.flip();
//            binChannel.position(new_int1Pos);
//            binChannel.write(intBuffer);
//            intBuffer.flip();
//
//            intBuffer.putInt(-98765);
//            intBuffer.flip();
//            binChannel.position(new_int2Pos);
//            binChannel.write(intBuffer);
//            intBuffer.flip();
//
//            intBuffer.putInt(1000);
//            intBuffer.flip();
//            binChannel.position(new_int3Pos);
//            binChannel.write(intBuffer);
//            intBuffer.flip();
//
//            binChannel.position(str1Pos);
//            binChannel.write(ByteBuffer.wrap(outputString));
//            binChannel.position(str2Pos);
//            binChannel.write(ByteBuffer.wrap(outputString01));

//            ByteBuffer readBuffer = ByteBuffer.allocate(100);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            byte[] inputString = new byte[outputBytes.length];
//            readBuffer.get(inputString);
//            System.out.println("input string is " + new String(inputString));
//            System.out.println("int1 = " + readBuffer.getInt());
//            System.out.println("int2 = " + readBuffer.getInt());
//            byte[] inputString2 = new byte[outputBytes2.length];
//            readBuffer.get(inputString2);
//            System.out.println("input string 2 is " + new String(inputString2));
//            System.out.println("int3 = " + readBuffer.getInt());





////            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
//            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
//
//            buffer.put(outputBytes);
//            buffer.flip();// !!!!!!!!! when use allocate!! SHOULD SWITCH READ/WRITE
//
//            int numBytes = binChannel.write(buffer);
//            System.out.println("NumBytes written was: " + numBytes);
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(245);
//            intBuffer.flip();
//            int newNumBytes = binChannel.write(intBuffer);
//            System.out.println("NumBytes written was: " + newNumBytes);
//
//            intBuffer.flip();//!!!!!
//            intBuffer.putInt(-98765);
//            intBuffer.flip();//!!!!!
//            newNumBytes = binChannel.write(intBuffer);
//
//            System.out.println("NumBytes written was: " + newNumBytes);
//
//            //Reading with java IO
////            RandomAccessFile ra = new RandomAccessFile("data.dat","rwd");
////            byte[] b = new byte[outputBytes.length];
////            ra.read(b);
////            System.out.println(new String(b));
////
////            long int1 = ra.readInt();
////            long int2 = ra.readInt();
////            System.out.println(int1 + ", " + int2);
//
//            //Reading with java NIO
//
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            FileChannel channel = ra.getChannel();
//            outputBytes[0] = 'a';
//            outputBytes[1] = 'b';
//            buffer.flip();
//            long numBytesRead = channel.read(buffer);
//            if (buffer.hasArray()) {
//                System.out.println("byte array = " + new String(buffer.array()));
////                System.out.println("byte array = " + new String(outputBytes) );
//            }
//
////ABSOLUTE READ
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer); // nub bytes in integer
//            System.out.println(intBuffer.getInt(0));
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0));

// RELATIVE READ
//            intBuffer.flip();
//
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());

//            channel.close();
//            ra.close();


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

// STRING READ AND WRITE
//        try{
////            FileInputStream file = new FileInputStream("data.txt");
////            FileChannel channel = file.getChannel();
//            Path dataPath = FileSystems.getDefault().getPath("data.txt");
//            Files.write(dataPath, "\nLine 5".getBytes("UTF-8"), StandardOpenOption.APPEND); //StandardOpenOption.APPEND - for existing file with data
//            List<String> lines = Files.readAllLines(dataPath); // can use second param - StandartCharset.
//
//            for(String line: lines){
//                System.out.println(line);
//            }
//        } catch(IOException ioe){
//            ioe.printStackTrace();
//        }


    }
}