package Student;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class ApplicationStatusFrame extends JFrame{
	
	JPanel borderPanel = new JPanel(); // border를 넣을 panel
	JPanel buttonPanel = new JPanel(); // button을 넣을 panel
	
	JButton backBtn = new JButton("이전으로");
	
	// JTable 모델
	String[] header = {"순번", "도서명", "카테고리", "신청현황"}; // 중간에 신청일자..
	DefaultTableModel tableModel = new DefaultTableModel(header, 0);
	JTable statusTable = new JTable(tableModel);

	public ApplicationStatusFrame() {
		initializeUI();
		addComponentsUI();
		eventHandler();
		loadApplicationStatus();
		setVisible(true);
	}
	
	
	private void initializeUI() {
        // 창 초기설정
        setSize(500, 500);
        setResizable(false);
        setTitle("아름다움");
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
	private void addComponentsUI() {
		borderPanel.setBounds(20, 20, 440, 380);
		borderPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "신청 현황"));
		borderPanel.setLayout(null);
		add(borderPanel);
		
		buttonPanel.setBounds(20, 410, 440, 40);
		//buttonPanel.setBorder(new LineBorder(Color.BLACK));
		add(buttonPanel);
		
		JScrollPane tableScrollPane = new JScrollPane(statusTable);
        tableScrollPane.setBounds(20, 40, 400, 310);
        borderPanel.add(tableScrollPane);
        
        //panel에 이전버튼 생성
        backBtn.setBounds(350, 0, 90, 40);
        buttonPanel.setLayout(null);
        buttonPanel.add(backBtn);
	}
	
	private void eventHandler() {
		//이전버튼
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openChooseFrame();
			}
		});
	}
	
	private void openChooseFrame() {
		dispose();
		new ChooseFrame();
	}
	
	private void loadApplicationStatus() {
        // 데이터베이스 연결 정보
		String DB_URL = "jdbc:mysql://localhost:3306/arumdaum?useTimezone=true&serverTimezone=UTC";
        String DB_USER = "root";
        String DB_PASSWORD = "0000";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            Statement statement = connection.createStatement();
            String selectQuery = "SELECT * FROM bookApplication";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            // JTable 모델 초기화
            tableModel.setRowCount(0);

            // 결과셋을 JTable에 추가
            while (resultSet.next()) {
                String[] rowData = {
                		//TODO:null은 나중에 구현할 것
                        resultSet.getString("id"),
                        resultSet.getString("title"),
                        resultSet.getString("category"),
                        resultSet.getString("status") //TODO 사유 JComboBox로 볼 수 있게 개발하기
                };
                tableModel.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
