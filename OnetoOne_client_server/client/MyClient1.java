import java.net.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;

public class MyClient1 {
	public static void main(String args[]) throws ParseException {
		clientConnection();
	}

	private static void clientConnection() throws ParseException {
		try {
			String f = "/home/ubuntu/siva/config.json";
			// "C:/Users/dell/Downloads/clientserverdemo/src/main/resources/config.json";
			Object o = new JSONParser().parse(new FileReader(f));

			JSONObject j = (JSONObject) o;

			String hostname1 = (String) j.get("hostname");
			String portnum1 = (String) j.get("port1");
			String portnum2 = (String) j.get("port2");
			Socket s = new Socket(hostname1, Integer.parseInt(portnum1));

			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			Socket s1 = new Socket(hostname1, Integer.parseInt(portnum2));

			DataInputStream din1 = new DataInputStream(s1.getInputStream());
			DataOutputStream dout1 = new DataOutputStream(s1.getOutputStream());

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String str = "", str2 = "";
			while (!str.equals("stop")) {
				System.out.print("Enter message to broadcast: ");
				str = br.readLine();
				dout.writeUTF(str);
				dout1.writeUTF(str);
				dout.flush();
				dout1.flush();
				str2 = din.readUTF();

				System.out.println("Server1 says: " + str2);
				str2 = din1.readUTF();
				System.out.println("Server2 says: " + str2);
			}

			dout.close();
			s.close();

		} catch (IOException e) {
			System.out.println("Client excpecting some server connection please run server first");
		}
	}
}
