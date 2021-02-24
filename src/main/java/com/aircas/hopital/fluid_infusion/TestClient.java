package com.aircas.hopital.fluid_infusion;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient {
	 public static void main(String[] args) {
	        try {
	            //发送到8888端口
	            Socket socket=new Socket("127.0.0.1", 8082);
	            //输出流
	            OutputStream outputStream=socket.getOutputStream();
	            PrintWriter printWriter=new PrintWriter(outputStream);
	            printWriter.write("123456789122");
	            printWriter.flush();
	            //关闭资源
	            printWriter.close();
	            outputStream.close();
	            socket.close();
	        } catch (UnknownHostException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
}
