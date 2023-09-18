package Student;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
	JButton uploadImageBtn = new JButton("사진 업로드");
	
	JLabel nameLabel = new JLabel("이름 :");
	JLabel gradeLabel = new JLabel("학번 :");
	JLabel passwordLabel = new JLabel("비밀번호 :");
	JLabel emailLabel = new JLabel("E-MAIL :");
	JLabel phoneLabel = new JLabel("전화번호 :");
	JLabel imageLabel = new JLabel("프로필 사진 :");
	JLabel uploadedImageLabel = new JLabel(); // 이미지를 표시할 JLabel
	
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
		nameLabel.setBounds(30, 40, 50, 25);
		nameField.setBounds(130, 40, 120, 25);
		borderPanel.add(nameLabel);
		borderPanel.add(nameField);
		
		//학번
		gradeLabel.setBounds(30, 80, 50, 25);
		gradeField.setBounds(130, 80, 120, 25);
		borderPanel.add(gradeLabel);
		borderPanel.add(gradeField);
		
		//비밀번호
		passwordLabel.setBounds(30, 120, 70, 25);
		passwordField.setBounds(130, 120, 120, 25);
		borderPanel.add(passwordLabel);
		borderPanel.add(passwordField);
		
		//이메일
		emailLabel.setBounds(30, 160, 50, 25);
		emailField.setBounds(130, 160, 120, 25);
		borderPanel.add(emailLabel);
		borderPanel.add(emailField);
		
		//전화번호
		phoneLabel.setBounds(30, 200, 70, 25);
		phoneField.setBounds(130, 200, 120, 25);
		borderPanel.add(phoneLabel);
		borderPanel.add(phoneField);
		
		//프로필 사진 업로드 버튼
        imageLabel.setBounds(30, 240, 90, 25);
        uploadImageBtn.setBounds(130, 240, 120, 25);
        borderPanel.add(imageLabel);
        borderPanel.add(uploadImageBtn);
        
        //이미지가 뜨는 라벨
        uploadedImageLabel.setBounds(130, 280, 100, 70); // 이미지 크기와 위치를 조절해주세요.
        borderPanel.add(uploadedImageLabel);
		
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
				openChooseFrame();
			}
		});
		
		// 프로필 사진 업로드 버튼
        uploadImageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    
                    // 선택한 이미지를 JLabel에 표시
                    ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                    uploadedImageLabel.setIcon(imageIcon);
                }
            }
        });
	}
	
	private void openChooseFrame() {
		dispose();
		new ChooseFrame();
	}
}
