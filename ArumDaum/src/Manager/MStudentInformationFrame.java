package Manager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class MStudentInformationFrame extends JFrame{
	
	JPanel borderPanel = new JPanel(); 
	JPanel buttonPanel = new JPanel(); // button을 넣을 panel
	
	JButton backBtn = new JButton("이전으로");
	
	//임시데이터입니다.
    DefaultTableModel tableModel;
    JTable resultTable;
    
    String[] header = {"학번", "이름", "비밀번호", "학년", "학과"};
    String[][] contents = {};
	
	public MStudentInformationFrame(){
		initializeUI();
		addComponentsUI();
		eventHandler();
		loadDataFromDatabase();
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
		//border panel
		borderPanel.setBounds(20, 20, 440, 380);
		borderPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "회원 관리"));
		borderPanel.setLayout(null);
		add(borderPanel);
		
		// JTable을 DefaultTableModel로 초기화합니다.
	    tableModel = new DefaultTableModel(contents, header);

	    // JTable을 DefaultTableModel로 설정합니다.
	    resultTable = new JTable(tableModel);

	    // JScrollPane을 사용하여 JTable을 감싸기
	    JScrollPane tableScrollPane = new JScrollPane(resultTable);
	    tableScrollPane.setBounds(25, 35, 390, 320);
	    borderPanel.add(tableScrollPane);
				
		//button panel
      	buttonPanel.setBounds(20, 410, 440, 40);
      	add(buttonPanel);
      	
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
				openMChooseFrame();
			}
		});
	}
	
	private void openMChooseFrame() {
		dispose();
		new MChooseFrame();
	}
	
	private void loadDataFromDatabase() {
        // 데이터베이스 연결 URL, 사용자 이름 및 비밀번호를 정의합니다.
        String dbUrl = "jdbc:mysql://localhost:3306/arumdaum?useTimezone=true&serverTimezone=UTC";
        String dbUser = "root";
        String dbPassword = "0000";

        try {
            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM student_info"; 
            ResultSet resultSet = statement.executeQuery(query);

            // 테이블의 기존 데이터를 지웁니다.
            tableModel.setRowCount(0);

            // 데이터베이스에서 가져온 데이터로 JTable을 채웁니다.
            while (resultSet.next()) {
                String classNum = resultSet.getString("class_num"); 
                String stuName = resultSet.getString("stu_name");
                String password = resultSet.getString("password");
                String grade = resultSet.getString("grade");
                String department = resultSet.getString("department");

                // JTable에 새로운 행을 추가합니다.
                tableModel.addRow(new String[]{classNum, stuName, password, grade, department});
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
