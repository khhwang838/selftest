package samples.network.omok;

import java.net.*;
import java.io.*;
import java.util.*;

public class OmokServer {
	private ServerSocket server;
	private BManager bMan = new BManager(); // �޽��� �����
	private Random rnd = new Random(); // ��� ���� ���Ƿ� ���ϱ� ���� ����

	public OmokServer() {
	}

	void startServer() { // ������ �����Ѵ�.
		try {
			server = new ServerSocket(7777);
			System.out.println("���������� ��Ǿ���ϴ�.");
			while (true) {

				// Ŭ���̾�Ʈ�� ����� �����带 ��´�.
				Socket socket = server.accept();

				// �����带 ����� �����Ų��.
				Omok_Thread ot = new Omok_Thread(socket);
				ot.start();

				// bMan�� �����带 �߰��Ѵ�.
				bMan.add(ot);

				System.out.println("������ ��: " + bMan.size());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		OmokServer server = new OmokServer();
		server.startServer();
	}

	// Ŭ���̾�Ʈ�� ����ϴ� ������ Ŭ����
	class Omok_Thread extends Thread {
		private int roomNumber = 1; // �� ��ȣ
		private String userName = null; // ����� �̸�
		private Socket socket; // ����

		// ���� �غ� ����, true�̸� ������ ������ �غ� �Ǿ����� �ǹ��Ѵ�.
		private boolean ready = false;

		private BufferedReader reader; // �Է� ��Ʈ��
		private PrintWriter writer; // ��� ��Ʈ��

		Omok_Thread(Socket socket) { // ����
			this.socket = socket;
		}

		Socket getSocket() { // ������ ��ȯ�Ѵ�.
			return socket;
		}

		int getRoomNumber() { // �� ��ȣ�� ��ȯ�Ѵ�.
			return roomNumber;
		}

		String getUserName() { // ����� �̸��� ��ȯ�Ѵ�.
			return userName;
		}

		boolean isReady() { // �غ� ���¸� ��ȯ�Ѵ�.
			return ready;
		}

		public void run() {
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream(), true);

				String msg; // Ŭ���̾�Ʈ�� �޽���

				while ((msg = reader.readLine()) != null) {

					// msg�� "[NAME]"���� ���۵Ǵ� �޽����̸�
					if (msg.startsWith("[NAME]")) {
						userName = msg.substring(6); // userName�� ���Ѵ�.
					}

					// msg�� "[ROOM]"���� ���۵Ǹ� �� ��ȣ�� ���Ѵ�.
					else if (msg.startsWith("[ROOM]")) {
						int roomNum = Integer.parseInt(msg.substring(6));
						if (!bMan.isFull(roomNum)) { // ���� �� ���°� �ƴϸ�

							// ���� ���� �ٸ� ��뿡�� ������� ������ �˸���.
							if (roomNumber != 1)
								bMan.sendToOthers(this, "[EXIT]" + userName);

							// ������� �� �� ��ȣ�� �����Ѵ�.
							roomNumber = roomNum;

							// ����ڿ��� �޽����� �״�� ����Ͽ� ������ �� ������
							// �˸���.
							writer.println(msg);

							// ����ڿ��� �� �濡 �ִ� ����� �̸� ����Ʈ�� ����Ѵ�.
							writer.println(bMan.getNamesInRoom(roomNumber));

							// �� �濡 �ִ� �ٸ� ����ڿ��� ������� ������ �˸���.
							bMan.sendToOthers(this, "[ENTER]" + userName);
						} else
							writer.println("[FULL]"); // ����ڿ� ���� á����
														// �˸���.
					}

					// "[STONE]" �޽����� ����?�� ����Ѵ�.
					else if (roomNumber >= 1 && msg.startsWith("[STONE]"))
						bMan.sendToOthers(this, msg);

					// ��ȭ �޽����� �濡 ����Ѵ�.
					else if (msg.startsWith("[MSG]"))
						bMan.sendToRoom(roomNumber, "[" + userName + "]: " + msg.substring(5));

					// "[START]" �޽����̸�
					else if (msg.startsWith("[START]")) {
						ready = true; // ������ ������ �غ� �Ǿ��.

						// �ٸ� ����ڵ� ������ ������ �غ� �Ǿ�����
						if (bMan.isReady(roomNumber)) {

							// ��� ���� ���ϰ� ����ڿ� ����?�� ����Ѵ�.
							int a = rnd.nextInt(2);
							if (a == 0) {
								writer.println("[COLOR]BLACK");
								bMan.sendToOthers(this, "[COLOR]WHITE");
							} else {
								writer.println("[COLOR]WHITE");
								bMan.sendToOthers(this, "[COLOR]BLACK");
							}
						}
					}

					// ����ڰ� ������ �����ϴ� �޽����� ������
					else if (msg.startsWith("[STOPGAME]"))
						ready = false;

					// ����ڰ� ������ ����ϴ� �޽����� ������
					else if (msg.startsWith("[DROPGAME]")) {
						ready = false;
						// ����?�� ������� ����� �˸���.
						bMan.sendToOthers(this, "[DROPGAME]");
					}

					// ����ڰ� �̰�ٴ� �޽����� ������
					else if (msg.startsWith("[WIN]")) {
						ready = false;
						// ����ڿ��� �޽����� ������.
						writer.println("[WIN]");

						// ����?�� ������ �˸���.
						bMan.sendToOthers(this, "[LOSE]");
					}
				}
			} catch (Exception e) {
			} finally {
				try {
					bMan.remove(this);
					if (reader != null)
						reader.close();
					if (writer != null)
						writer.close();
					if (socket != null)
						socket.close();
					reader = null;
					writer = null;
					socket = null;
					System.out.println(userName + "���� ������ ������ϴ�.");
					System.out.println("������ ��: " + bMan.size());
					// ����ڰ� ������ �������� ���� �濡 �˸���.
					bMan.sendToRoom(roomNumber, "[DISCONNECT]" + userName);
				} catch (Exception e) {
				}
			}
		}
	}

	class BManager extends Vector { // �޽����� ����ϴ� Ŭ����
		BManager() {
		}

		void add(Omok_Thread ot) { // �����带 �߰��Ѵ�.
			super.add(ot);
		}

		void remove(Omok_Thread ot) { // �����带 �����Ѵ�.
			super.remove(ot);
		}

		Omok_Thread getOT(int i) { // i��° �����带 ��ȯ�Ѵ�.
			return (Omok_Thread) elementAt(i);
		}

		Socket getSocket(int i) { // i��° �������� ������ ��ȯ�Ѵ�.
			return getOT(i).getSocket();
		}

		// i��° ������� ����� Ŭ���̾�Ʈ���� �޽����� ����Ѵ�.
		void sendTo(int i, String msg) {
			try {
				PrintWriter pw = new PrintWriter(getSocket(i).getOutputStream(), true);
				pw.println(msg);
			} catch (Exception e) {
			}
		}

		int getRoomNumber(int i) { // i��° �������� �� ��ȣ�� ��ȯ�Ѵ�.
			return getOT(i).getRoomNumber();
		}

		synchronized boolean isFull(int roomNum) { // ���� á���� �˾ƺ���.
			if (roomNum == 0)
				return false; // ������ ���� �ʴ´�.

			// �ٸ� ���� 2�� �̻� ������ �� ���.
			int count = 0;
			for (int i = 0; i < size(); i++)
				if (roomNum == getRoomNumber(i))
					count++;
			if (count >= 2)
				return true;
			return false;
		}

		// roomNum �濡 msg�� ����Ѵ�.
		void sendToRoom(int roomNum, String msg) {
			for (int i = 0; i < size(); i++)
				if (roomNum == getRoomNumber(i))
					sendTo(i, msg);
		}

		// ot�� ���� �濡 �ִ� �ٸ� ����ڿ��� msg�� ����Ѵ�.
		void sendToOthers(Omok_Thread ot, String msg) {
			for (int i = 0; i < size(); i++)
				if (getRoomNumber(i) == ot.getRoomNumber() && getOT(i) != ot)
					sendTo(i, msg);
		}

		// ������ ������ �غ� �Ǿ�°��� ��ȯ�Ѵ�.
		// �� ���� ����� ��� �غ�� �����̸� true�� ��ȯ�Ѵ�.
		synchronized boolean isReady(int roomNum) {
			int count = 0;
			for (int i = 0; i < size(); i++)
				if (roomNum == getRoomNumber(i) && getOT(i).isReady())
					count++;
			if (count == 2)
				return true;
			return false;
		}

		// roomNum�濡 �ִ� ����ڵ��� �̸��� ��ȯ�Ѵ�.
		String getNamesInRoom(int roomNum) {
			StringBuffer sb = new StringBuffer("[PLAYERS]");
			for (int i = 0; i < size(); i++)
				if (roomNum == getRoomNumber(i))
					sb.append(getOT(i).getUserName() + "\t");
			return sb.toString();
		}
	}
}
