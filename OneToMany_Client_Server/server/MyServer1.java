import java.net.*;

import java.io.*;

public class MyServer1 {

	public static void main(String args[]) {

		serverOneConnection();

	}

	private static void serverOneConnection() {

		try {

			ServerSocket ss = new ServerSocket(3333);

			Socket s = ss.accept();

			DataInputStream din = new DataInputStream(s.getInputStream());

			DataOutputStream dout = new DataOutputStream(s.getOutputStream());

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String str = "", str2 = "";

			while (!str.equals("stop")) {

				str = din.readUTF();

				System.out.println("client says to server1: " + str);

				System.out.print("Enter message from server1: ");

				str2 = br.readLine();

				dout.writeUTF(str2);

				dout.flush();

			}

			din.close();

			s.close();

			ss.close();

		} catch (IOException e) {

			System.out.println("check client service wether it is running or not");

		}

	}

}
