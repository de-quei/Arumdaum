package frame;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class LoginFrame extends JFrame {
	
	boolean loginvaild = false;

	//배경 이미지 상대경로
    JLabel LoginBackground = new JLabel(new ImageIcon("./img/loginframe.png"));
    JTextField sIdText = new JTextField();
    JPasswordField pwText = new JPasswordField();
    JButton loginBtn = new JButton("로그인");

    public LoginFrame() {
        initailzeUI();
        addComponentsUI();
        eventHandler();
        // 창이 보이게 함.
        setVisible(true);
    }
    
    private void initailzeUI(){
    	// 창 초기설정
        setSize(1280, 750);
        setResizable(false);
        setTitle("아름다움");
        setLayout(null);
        setLocationRelativeTo(null);
    }
    
    private void addComponentsUI() {
    	JLabel title = new JLabel("\"아름다움\"");
    	title.setBounds(511, 212, 170, 49); 
    	title.setFont(new Font("Gowun Batang", Font.PLAIN, 32)); 
    	title.setForeground(Color.decode("#1E6525")); 
    	add(title);
    	
    	JLabel subheading = new JLabel(": 책 속에 모든 과거의 영혼이 잠들어 있다.");
    	subheading.setBounds(511, 260, 300, 24);
    	subheading.setFont(new Font("Gowun Batang", Font.PLAIN, 16));
    	add(subheading);
    	
    	JLabel studentId = new JLabel("학번");
    	studentId.setBounds(458, 316, 33, 24);
    	studentId.setFont(new Font("Gowun Batang", Font.PLAIN, 16));
    	add(studentId);
    	
    	// 아이디 입력 필드 위치, 크기 설정
        // (a, b, c, d) --> a,b 위치 / c, d 크기
        sIdText.setBounds(511, 306, 207, 45);
        sIdText.setFont(new Font("Gowun Batang", Font.PLAIN, 18)); // 입력받을 때, 문자 크기 및 폰트 설정
        add(sIdText);

        JLabel password = new JLabel("비밀번호");
    	password.setBounds(427, 379, 65, 24);
    	password.setFont(new Font("Gowun Batang", Font.PLAIN, 16));
    	add(password);
    	
        // 비밀번호 입력 필드 위치, 크기 설정
        pwText.setBounds(511, 369, 207, 45);
        pwText.setFont(new Font("Gowun Batang", Font.PLAIN, 18)); 
        add(pwText);
        
        // 로그인 버튼 위치, 크기 설정
        loginBtn.setBounds(737, 306, 115, 108);
        loginBtn.setBackground(Color.decode("#1E6525")); // 버튼 색상 헥스코드로 설정
        loginBtn.setForeground(Color.WHITE); // 버튼 속 글자 색상 설정
        loginBtn.setFont(new Font("Gowun Batang", Font.BOLD, 16)); // 버튼 속 글자의 폰트 및 스타일, 크기 설정
        add(loginBtn);
        
        // 이미지의 위치, 크기
        LoginBackground.setBounds(0, 0, 1280, 720);
        add(LoginBackground);
    }
    
    private void eventHandler() {
    	// 로그인 버튼에 대한 액션리스너
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int class_num = Integer.parseInt(sIdText.getText()); // 숫자형으로 받는다.
                String password = new String(pwText.getPassword());

                // 로그인 성공
                if (validateLogin(class_num, password)) {
                    // TODO : 로그인에 대한 여러 경우의 수 고려하기
                	// 1. 미입력시 알림 / 아이디 및 비밀번호 오류 / 올바르지 못한 데이터형 입력
                	loginvaild = true;
                    System.out.println("로그인 성공");
                    //로그인이 성공하면 libraryFrame()을 호출한다.
                    openLibraryFrame();
                // 로그인 실패
                }else {
                    System.out.println("로그인 실패");
                }
            }
        });
    }
    
    private boolean validateLogin(int class_num, String password) {
        try {
        	// 데이터베이스 정보
            String dbURL = "jdbc:mysql://localhost:3306/arumdaum?serverTimezone=UTC"; 
            String dbUsername = "root"; 
            String dbPassword = "0000"; 

            // DriverManager을 이용한 데이터베이스 연결
            Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

            String query = "SELECT * FROM student_info WHERE class_num = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, class_num);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
            
        } catch (SQLException ex) {
            return false;
        }
    }
    
    private void openLibraryFrame() {
        // 기존의 창을 지우고
        dispose();
        // LibraryFrmae()을 호출한다.
        new LibraryFrame();
    }

}