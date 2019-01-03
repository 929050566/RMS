package com.aowin.stuff.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	private static ArrayList<Socket> arr;

	public Server() {
		arr = new ArrayList<Socket>();
		try {
			ServerSocket server = new ServerSocket(6667);
			Socket s = null;
			while (true) {
				s = server.accept();
				arr.add(s);
				new ServerThread(s, arr).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 接受信息 并 发送给所有
	}
}

// 接收数据 并 转发所以在线的客户端
class ServerThread extends Thread {

	private Socket s;
	private ArrayList<Socket> arr;

	public ServerThread(Socket s, ArrayList<Socket> arr) {
		this.s = s;
		this.arr = arr;
	}

	@Override
	public void run() {

		// 获得当前客户端发送的信息
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			int i =0;
			while (s.isConnected()) {
				String meaasge = br.readLine();
				//System.err.println(i++);
				// 将信息转发
				PrintWriter pw = null;
				for (Socket socket : arr) {
					pw = new PrintWriter(socket.getOutputStream());
					pw.println(meaasge);
					pw.flush();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Test{
	public static void main(String[] args) {
		new Server();
	}
}