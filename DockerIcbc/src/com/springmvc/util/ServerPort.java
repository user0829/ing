package com.springmvc.util;




	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.net.ServerSocket;
	import java.net.Socket;
	import java.security.KeyStore.Entry;
	import java.util.HashMap;

	/**
	 * ���������--���̣߳������ͻ�������
	 * @author Administrator
	 *
	 */
	public class ServerPort {
		//��Ҫ���пͻ��˵��б�
		public static HashMap<String,ClientThread> clients=new HashMap<String,ClientThread>();
		public static void main(String[] args) throws IOException {
			ServerSocket server=new ServerSocket(36786);
			System.out.println("服务端36786开启");
			while(true){
				Socket s=server.accept();
				ClientThread clientThread=new ClientThread(s);
				clientThread.start();
			}
			
		}
	}
	/**
	 * Ϊ�ͻ����ṩ�̷߳���
	 * @author Administrator
	 *
	 */
	class ClientThread extends Thread{
		/**
		 * ���������
		 * �û���
		 * �û�IP��ַ
		 * socket
		 */
		//�����������ȡ�ͻ�����Ϣ�Ķ�ȡ��
		private BufferedReader reader;
		//������������ͻ��˷�����Ϣ��д����
		private PrintWriter writer;
		//��ǰ�ͻ��˵��û���
		private String userName;
		//��ǰ�ͻ��˵�IP��ַ
		private String userIp;
		//��ǰ�ͻ��˶�Ӧ��socket����
		private Socket socket;
		public ClientThread(Socket socket){
			this.socket=socket;
			try {
				reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void sendMessage(String message){
		
		}
		@Override
		public void run(){

			while(true){
					try {
						System.out.println(reader.readLine());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			}
					
		}
		
		
		public BufferedReader getReader() {
			return reader;
		}

		public void setReader(BufferedReader reader) {
			this.reader = reader;
		}

		public PrintWriter getWriter() {
			return writer;
		}

		public void setWriter(PrintWriter writer) {
			this.writer = writer;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserIp() {
			return userIp;
		}

		public void setUserIp(String userIp) {
			this.userIp = userIp;
		}


		public Socket getSocket() {
			return socket;
		}


		public void setSocket(Socket socket) {
			this.socket = socket;
		}
		
	}


