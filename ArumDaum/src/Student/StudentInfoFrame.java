package Student;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class StudentInfoFrame extends JFrame{
	
	JPanel borderPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	
	JButton backBtn = new JButton("이전으로");
	JButton logoutBtn = new JButton("로그아웃");
	
	JLabel nameLabel = new JLabel("이름 :");
	JLabel gradeLabel = new JLabel("학번 :");
	JLabel passwordLabel = new JLabel("비밀번호 :");
	JLabel emailLabel = new JLabel("E-MAIL :");
	JLabel phoneLabel = new JLabel("전화번호 :");
	
	JTextField nameField = new JTextField();
	JTextField gradeField = new JTextField();
	JTextField passwordField = new JTextField();
	JTextField emailField = new JTextField();
	JTextField phoneField = new JTextField();

	public StudentInfoFrame() {
		initializeUI();
		addComponentsUI();
		eventHandler();
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
		borderPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "회원 정보"));
		borderPanel.setLayout(null);
		add(borderPanel);
		
		//이름
		nameLabel.setBounds(30, 90, 50, 25);
		nameField.setBounds(130, 90, 120, 25);
		borderPanel.add(nameLabel);
		borderPanel.add(nameField);
		
		//학번
		gradeLabel.setBounds(30, 130, 50, 25);
		gradeField.setBounds(130, 130, 120, 25);
		borderPanel.add(gradeLabel);
		borderPanel.add(gradeField);
		
		//비밀번호
		passwordLabel.setBounds(30, 170, 70, 25);
		passwordField.setBounds(130, 170, 120, 25);
		borderPanel.add(passwordLabel);
		borderPanel.add(passwordField);
		
		//이메일
		emailLabel.setBounds(30, 210, 50, 25);
		emailField.setBounds(130, 210, 120, 25);
		borderPanel.add(emailLabel);
		borderPanel.add(emailField);
		
		//전화번호
		phoneLabel.setBounds(30, 250, 70, 25);
		phoneField.setBounds(130, 250, 120, 25);
		borderPanel.add(phoneLabel);
		borderPanel.add(phoneField);
		
		//button panel
      	buttonPanel.setBounds(20, 410, 440, 40);
      	buttonPanel.setLayout(null);
      	add(buttonPanel);
      	
      	//이전버튼
      	backBtn.setBounds(250, 0, 90, 40);
      	buttonPanel.add(backBtn);
      	
        //로그아웃 버튼
      	logoutBtn.setBounds(350, 0, 90, 40);
      	buttonPanel.add(logoutBtn);
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
}
