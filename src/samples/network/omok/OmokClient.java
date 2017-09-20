package samples.network.omok;

import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.geom.*;

class OmokBoard extends Canvas { // �������� �����ϴ� Ŭ����

	public static final int BLACK = 1, WHITE = 1; // ��� ���� ��Ÿ���� ���
	private int[][] map; // ������ �迭
	private int size; // size�� ������ ���� �Ǵ� ���� ����, 15�� ���Ѵ�.
	private int cell; // ������ ũ��(pixel)
	private String info = "���� ����"; // ������ ���� ��Ȳ�� ��Ÿ���� ���ڿ�
	private int color = BLACK; // ������� �� ����

	// true�̸� ����ڰ� ���� ���� �� �ִ� ���¸� �ǹ��ϰ�,
	// false�̸� ����ڰ� ���� ���� �� ��� ���¸� �ǹ��Ѵ�.
	private boolean enable = false;

	private boolean running = false; // ������ ���� ���ΰ��� ��Ÿ���� ����
	private PrintWriter writer; // ����?�� �޽����� ����ϱ� ���� ��Ʈ��
	private Graphics gboard, gbuff; // ĵ������ ���۸� ���� �׷��Ƚ� ��ü
	private Image buff; // ���� ���۸��� ���� ����

	OmokBoard(int s, int c) { // �������� ����(s=15, c=30)
		this.size = s;
		this.cell = c;

		map = new int[size + 2][]; // ���� ũ�⸦ ���Ѵ�.
		for (int i = 0; i < map.length; i++)
			map[i] = new int[size + 2];

		setBackground(new Color(200, 200, 100)); // �������� ������ ���Ѵ�.
		setSize(size * (cell + 1) + size, size * (cell + 1) + size); // ��������
																		// ũ�⸦
																		// ����Ѵ�.

		// �������� ���콺 �̺�Ʈ ó��
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) { // ���콺�� ������
				if (!enable)
					return; // ����ڰ� ���� �� ��� �����̸� ���� ���´�.

				// ���콺�� ��ǥ�� map ��ǥ�� ����Ѵ�.
				int x = (int) Math.round(me.getX() / (double) cell);
				int y = (int) Math.round(me.getY() / (double) cell);

				// ���� ���� �� �ִ� ��ǥ�� �ƴϸ� ���� ���´�.
				if (x == 0 || y == 0 || x == size + 1 || y == size + 1)
					return;

				// �ش� ��ǥ�� �ٸ� ���� ������ ������ ���� ���´�.
				if (map[x][y] == BLACK || map[x][y] == WHITE)
					return;

				// ����?�� ���� ���� ��ǥ�� ����Ѵ�.
				writer.println("[STONE]" + x + " " + y);

				map[x][y] = color;

				// �̰���� �˻��Ѵ�.
				if (check(new Point(x, y), color)) {
					info = "�̰���ϴ�.";
					writer.println("[WIN]");
				}

				else
					info = "��밡 �α⸦ ��ٸ��ϴ�.";
				repaint(); // �������� �׸���.

				// ����ڰ� �� �� ��� ���·� �����.
				// ������� �θ� enable�� true�� �Ǿ� ����ڰ� �� �� �ְ� �ȴ�.
				enable = false;
			}
		});
	}

	public boolean isRunning() { // ������ ���� ���¸� ��ȯ�Ѵ�.
		return running;
	}

	public void startGame(String col) { // ������ �����Ѵ�.
		running = true;
		if (col.equals("BLACK")) { // ���� ���õǾ��� ��
			enable = true;
			color = BLACK;
			info = "���� ����... �μ���.";
		} else { // ���� ���õǾ��� ��
			enable = false;
			color = WHITE;
			info = "���� ����... ��ٸ�����.";
		}
	}

	public void stopGame() { // ������ �����.
		reset(); // �������� �ʱ�ȭ�Ѵ�.
		writer.println("[STOPGAME]"); // ����?�� �޽����� ������.
		enable = false;
		running = false;
	}

	public void putOpponent(int x, int y) { // ������� ���� ���´�.
		map[x][y] = color;
		info = "��밡 �ξ���ϴ�. �μ���.";
		repaint();
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public void setWriter(PrintWriter writer) {
		this.writer = writer;
	}

	public void update(Graphics g) { // repaint�� ȣ���ϸ� �ڵ����� ȣ��ȴ�.
		paint(g); // paint�� ȣ���Ѵ�.
	}

	public void paint(Graphics g) { // ȭ���� �׸���.
		if (gbuff == null) { // ���۰� ������ ���۸� �����.
			buff = createImage(getWidth(), getHeight());
			gbuff = buff.getGraphics();
		}
		drawBoard(g); // �������� �׸���.
	}

	public void reset() { // �������� �ʱ�ȭ��Ų��.
		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map[i].length; j++)
				map[i][j] = 0;
		info = "���� ����";
		repaint();
	}

	private void drawLine() { // �����ǿ� ���� �ߴ´�.
		gbuff.setColor(Color.black);
		for (int i = 1; i <= size; i++) {
			gbuff.drawLine(cell, i * cell, cell * size, i * cell);
			gbuff.drawLine(i * cell, cell, i * cell, cell * size);
		}
	}

	private void drawBlack(int x, int y) { // �� ���� (x, y)�� �׸���.
		Graphics2D gbuff = (Graphics2D) this.gbuff;
		gbuff.setColor(Color.black);
		gbuff.fillOval(x * cell - cell / 2, y * cell - cell / 2, cell, cell);
		gbuff.setColor(Color.white);
		gbuff.drawOval(x * cell - cell / 2, y * cell - cell / 2, cell, cell);
	}

	private void drawWhite(int x, int y) { // �� ���� (x, y)�� �׸���.
		gbuff.setColor(Color.white);
		gbuff.fillOval(x * cell - cell / 2, y * cell - cell / 2, cell, cell);
		gbuff.setColor(Color.black);
		gbuff.drawOval(x * cell - cell / 2, y * cell - cell / 2, cell, cell);
	}

	private void drawStones() { // map ������ ������ ��� �׸���.
		for (int x = 1; x <= size; x++)
			for (int y = 1; y <= size; y++) {
				if (map[x][y] == BLACK)
					drawBlack(x, y);
				else if (map[x][y] == WHITE)
					drawWhite(x, y);
			}
	}

	synchronized private void drawBoard(Graphics g) { // �������� �׸���.
		// ���ۿ� ���� �׸��� ������ �̹����� �����ǿ� �׸���.
		gbuff.clearRect(0, 0, getWidth(), getHeight());
		drawLine();
		drawStones();
		gbuff.setColor(Color.red);
		gbuff.drawString(info, 20, 15);
		g.drawImage(buff, 0, 0, this);
	}

	private boolean check(Point p, int col) {
		if (count(p, 1, 0, col) + count(p, 1, 0, col) == 4)
			return true;
		if (count(p, 0, 1, col) + count(p, 0, 1, col) == 4)
			return true;
		if (count(p, 1, 1, col) + count(p, 1, 1, col) == 4)
			return true;
		if (count(p, 1, 1, col) + count(p, 1, 1, col) == 4)
			return true;
		return false;
	}

	private int count(Point p, int dx, int dy, int col) {
		int i = 0;
		for (; map[p.x + (i + 1) * dx][p.y + (i + 1) * dy] == col; i++)
			;
		return i;
	}
} // OmokBoard ���� ��

public class OmokClient extends Frame implements Runnable, ActionListener {

	static String IPADDRESS = "localhost";

	private TextArea msgView = new TextArea("", 1, 1, 1); // �޽����� �����ִ�
															// ����
	private TextField sendBox = new TextField(""); // ���� �޽����� ��� ����
	private TextField nameBox = new TextField(); // ����� �̸� ����
	private TextField roomBox = new TextField("0"); // �� ��ȣ ����

	// �濡 ������ �ο��� ���� �����ִ� ���̺�
	private Label pInfo = new Label("����: ��");

	private java.awt.List pList = new java.awt.List(); // ����� ����� �����ִ�
														// ����Ʈ
	private Button startButton = new Button("�뱹 ����"); // �뱹 ���� ��ư
	private Button stopButton = new Button("���"); // ��� ��ư
	private Button enterButton = new Button("�����ϱ�"); // �����ϱ� ��ư
	private Button exitButton = new Button("���Ƿ�"); // ���Ƿ� ��ư

	// ���� ������ �����ִ� ���̺�
	private Label infoView = new Label("< ���ϴ� �ڹ� >", 1);

	private OmokBoard board = new OmokBoard(15, 30); // ������ ��ü
	private BufferedReader reader; // �Է� ��Ʈ��
	private PrintWriter writer; // ��� ��Ʈ��
	private Socket socket; // ����
	private int roomNumber = 1; // �� ��ȣ
	private String userName = null; // ����� �̸�

	public OmokClient(String title) { // ����
		super(title);
		setLayout(null); // ���̾ƿ��� ������� �ʴ´�.

		// ���� ������Ʈ�� ���ϰ� ��ġ�Ѵ�.
		msgView.setEditable(false);
		infoView.setBounds(10, 30, 480, 30);
		infoView.setBackground(new Color(200, 200, 255));
		board.setLocation(10, 70);
		add(infoView);
		add(board);
		Panel p = new Panel();
		p.setBackground(new Color(200, 255, 255));
		p.setLayout(new GridLayout(3, 3));
		p.add(new Label("��   ��:", 2));
		p.add(nameBox);
		p.add(new Label("�� ��ȣ:", 2));
		p.add(roomBox);
		p.add(enterButton);
		p.add(exitButton);
		enterButton.setEnabled(false);
		p.setBounds(500, 30, 250, 70);

		Panel p2 = new Panel();
		p2.setBackground(new Color(255, 255, 100));
		p2.setLayout(new BorderLayout());
		Panel p2_1 = new Panel();
		p2_1.add(startButton);
		p2_1.add(stopButton);
		p2.add(pInfo, "North");
		p2.add(pList, "Center");
		p2.add(p2_1, "South");
		startButton.setEnabled(false);
		stopButton.setEnabled(false);
		p2.setBounds(500, 110, 250, 180);

		Panel p3 = new Panel();
		p3.setLayout(new BorderLayout());
		p3.add(msgView, "Center");
		p3.add(sendBox, "South");
		p3.setBounds(500, 300, 250, 250);

		add(p);
		add(p2);
		add(p3);

		// �̺�Ʈ �����ʸ� ����Ѵ�.
		sendBox.addActionListener(this);
		enterButton.addActionListener(this);
		exitButton.addActionListener(this);
		startButton.addActionListener(this);
		stopButton.addActionListener(this);

		// ������ �ݱ� ó��
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	// ������Ʈ���� �׼� �̺�Ʈ ó��
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == sendBox) { // �޽��� �Է� �����̸�
			String msg = sendBox.getText();
			if (msg.length() == 0)
				return;
			if (msg.length() >= 30)
				msg = msg.substring(0, 30);
			try {
				writer.println("[MSG]" + msg);
				sendBox.setText("");
			} catch (Exception ie) {
			}
		}

		else if (ae.getSource() == enterButton) { // �����ϱ� ��ư�̸�
			try {

				if (Integer.parseInt(roomBox.getText()) < 1) {
					infoView.setText("���ȣ�� �߸�Ǿ���ϴ�. 1�̻�");
					return;
				}
				writer.println("[ROOM]" + Integer.parseInt(roomBox.getText()));
				msgView.setText("");
			} catch (Exception ie) {
				infoView.setText("�Է��Ͻ� ���׿� ���� �ҽ��ϴ�.");
			}
		}

		else if (ae.getSource() == exitButton) { // ���Ƿ� ��ư�̸�
			try {
				goToWaitRoom();
				startButton.setEnabled(false);
				stopButton.setEnabled(false);
			} catch (Exception e) {
			}
		}

		else if (ae.getSource() == startButton) { // �뱹 ���� ��ư�̸�
			try {
				writer.println("[START]");
				infoView.setText("����� ������ ��ٸ��ϴ�.");
				startButton.setEnabled(false);
			} catch (Exception e) {
			}
		}

		else if (ae.getSource() == stopButton) { // ��� ��ư�̸�
			try {
				writer.println("[DROPGAME]");
				endGame("����Ͽ����ϴ�.");
			} catch (Exception e) {
			}
		}
	}

	void goToWaitRoom() { // ���Ƿ� ��ư�� ������ ȣ��ȴ�.
		if (userName == null) {
			String name = nameBox.getText().trim();
			if (name.length() <= 2 || name.length() > 10) {
				infoView.setText("�̸��� �߸�Ǿ���ϴ�. 3~10��");
				nameBox.requestFocus();
				return;
			}
			userName = name;
			writer.println("[NAME]" + userName);
			nameBox.setText(userName);
			nameBox.setEditable(false);
		}
		msgView.setText("");
		writer.println("[ROOM]0");
		infoView.setText("���ǿ� �����ϼ̽��ϴ�.");
		roomBox.setText("0");
		enterButton.setEnabled(true);
		exitButton.setEnabled(false);
	}

	public void run() {
		String msg; // �����κ����� �޽���
		try {
			while ((msg = reader.readLine()) != null) {

				if (msg.startsWith("[STONE]")) { // ������� ���� ���� ��ǥ
					String temp = msg.substring(7);
					int x = Integer.parseInt(temp.substring(0, temp.indexOf(" ")));
					int y = Integer.parseInt(temp.substring(temp.indexOf(" ") + 1));
					board.putOpponent(x, y); // ������� ���� �׸���.
					board.setEnable(true); // ����ڰ� ���� ���� �� �ֵ��� �Ѵ�.
				}

				else if (msg.startsWith("[ROOM]")) { // �濡 ����
					if (!msg.equals("[ROOM]0")) { // ������ �ƴ� ���̸�
						enterButton.setEnabled(false);
						exitButton.setEnabled(true);
						infoView.setText(msg.substring(6) + "�� �濡 �����ϼ̽��ϴ�.");
					} else
						infoView.setText("���ǿ� �����ϼ̽��ϴ�.");

					roomNumber = Integer.parseInt(msg.substring(6)); // �� ��ȣ
																		// ����

					if (board.isRunning()) { // ������ �������� �����̸�
						board.stopGame(); // ������ ������Ų��.
					}
				}

				else if (msg.startsWith("[FULL]")) { // ���� �� �����̸�
					infoView.setText("���� ���� ������ �� ����ϴ�.");
				}

				else if (msg.startsWith("[PLAYERS]")) { // �濡 �ִ� ����� ���
					nameList(msg.substring(9));
				}

				else if (msg.startsWith("[ENTER]")) { // �մ� ����
					pList.add(msg.substring(7));
					playersInfo();
					msgView.append("[" + msg.substring(7) + "]���� �����Ͽ����ϴ�.\n");
				} else if (msg.startsWith("[EXIT]")) { // �մ� ����
					pList.remove(msg.substring(6)); // ����Ʈ���� ����
					playersInfo(); // �ο���� �ٽ� ����Ͽ� �����ش�.
					msgView.append("[" + msg.substring(6) + "]���� �ٸ� ������ �����Ͽ����ϴ�.\n");
					if (roomNumber != 0)
						endGame("��밡 �������ϴ�.");
				}

				else if (msg.startsWith("[DISCONNECT]")) { // �մ� ���� ����
					pList.remove(msg.substring(12));
					playersInfo();
					msgView.append("[" + msg.substring(12) + "]���� ������ ������ϴ�.\n");
					if (roomNumber != 0)
						endGame("��밡 �������ϴ�.");
				}

				else if (msg.startsWith("[COLOR]")) { // ���� ���� �ο��޴´�.
					String color = msg.substring(7);
					board.startGame(color); // ������ �����Ѵ�.
					if (color.equals("BLACK"))
						infoView.setText("�浹�� ��ҽ��ϴ�.");
					else
						infoView.setText("�鵹�� ��ҽ��ϴ�.");
					stopButton.setEnabled(true); // ��� ��ư Ȱ��ȭ
				}

				else if (msg.startsWith("[DROPGAME]")) // ��밡 ����ϸ�
					endGame("��밡 ����Ͽ����ϴ�.");

				else if (msg.startsWith("[WIN]")) // �̰�����
					endGame("�̰���ϴ�.");

				else if (msg.startsWith("[LOSE]")) // ������
					endGame("�����ϴ�.");

				// ��ӵ� �޽����� �ƴϸ� �޽��� ������ �����ش�.
				else
					msgView.append(msg + "\n");
			}
		} catch (IOException ie) {
			msgView.append(ie + "\n");
		}
		msgView.append("������ ������ϴ�.");
	}

	private void endGame(String msg) { // ������ �����Ű�� �޼ҵ�
		infoView.setText(msg);
		startButton.setEnabled(false);
		stopButton.setEnabled(false);

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		} // 2�ʰ� ���

		if (board.isRunning())
			board.stopGame();
		if (pList.getItemCount() == 2)
			startButton.setEnabled(true);
	}

	private void playersInfo() { // �濡 �ִ� �������� ���� �����ش�.
		int count = pList.getItemCount();
		if (roomNumber == 0)
			pInfo.setText("����: " + count + "��");
		else
			pInfo.setText(roomNumber + " �� ��: " + count + "��");

		// �뱹 ���� ��ư�� Ȱ��ȭ ���¸� �����Ѵ�.
		if (count == 2 && roomNumber != 0)
			startButton.setEnabled(true);
		else
			startButton.setEnabled(false);
	}

	// ����� ����Ʈ���� ����ڵ��� �����Ͽ� pList�� �߰��Ѵ�.
	private void nameList(String msg) {
		pList.removeAll();
		StringTokenizer st = new StringTokenizer(msg, "\t");
		while (st.hasMoreElements())
			pList.add(st.nextToken());
		playersInfo();
	}

	private void connect() { // ����
		try {
			msgView.append("������ ������ ��û�մϴ�.\n");
			socket = new Socket(IPADDRESS, 7777);
			msgView.append("���� ����.\n");
			msgView.append("�̸��� �Է��ϰ� ���Ƿ� �����ϼ���.\n");
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);
			new Thread(this).start();
			board.setWriter(writer);
		} catch (Exception e) {
			msgView.append(e + "\n\n���� ����..\n");
		}
	}

	public static void main(String[] args) {
		OmokClient client = new OmokClient("��Ʈ��ũ ���� ����");
		client.setSize(760, 560);
		client.setVisible(true);
		client.connect();
	}
}
