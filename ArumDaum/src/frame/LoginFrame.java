package frame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {

	//배경 이미지 상대경로
    JLabel MainBackground = new JLabel(new ImageIcon("./img/loginframe.png"));
    JTextField sIdText = new JTextField();
    JPasswordField pwText = new JPasswordField();
    JButton loginBtn = new JButton("로그인");

    public LoginFrame() {
        // 창 초기설정
        setSize(1280, 750);
        setResizable(false);
        setTitle("아름다움");
        setLayout(null);
        setLocationRelativeTo(null);

        // 아이디 입력 필드 위치, 크기 설정
        //(a, b, c, d) --> a,b 위치 / c, d 크기
        sIdText.setBounds(511, 306, 207, 45);
        sIdText.setFont(new Font("Gowun Batang", Font.PLAIN, 18)); // 입력받을 때, 문자 크기 및 폰트 설정
        add(sIdText);

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
        
        //이미지의 위치, 크기
        MainBackground.setBounds(0, 0, 1280, 720);
        add(MainBackground);
        
        //창이 보이게 함.
        setVisible(true);
    }

}