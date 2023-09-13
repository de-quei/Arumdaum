package Student;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ChooseFrame extends JFrame {
	
    JButton application = new JButton("도서 신청");
    JButton check = new JButton("도서 검색");
    JButton status = new JButton("신청 현황");
    JButton sInfo = new JButton("회원 정보");
    
    JPanel welcome = new JPanel();

    public ChooseFrame() {
        initializeUI();
        addComponentsUI();
        eventHandler();
        setVisible(true);
    }

    private void initializeUI() {
        // 창 초기설정
        setSize(500, 200);
        setResizable(false);
        setTitle("아름다움");
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addComponentsUI() {
    	
    	// TODO : 명언이 나올 패널 (파일 입출력 혹은 데이터베이스)
    	welcome.setBounds(40, 25, 400, 70);
    	welcome.setBorder(new LineBorder(Color.BLACK, 1));
    	welcome.setBackground(Color.WHITE);
    	add(welcome);
    	
        // 버튼 위치 및 크기 설정
        application.setBounds(40, 100, 100, 30);
        check.setBounds(140, 100, 100, 30);
        status.setBounds(240, 100, 100, 30);
        sInfo.setBounds(340, 100, 100, 30);

        // 프레임에 버튼 추가
        add(application);
        add(check);
        add(status);
        add(sInfo);
    }
    
    private void eventHandler() {
        application.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openBookApplicationFrame();
            }
        });
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	openBookStatusFrame();
            }
        });
        status.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	openApplicationStatusFrame();
            }
        });
        sInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	openStudentInfoFrame();
            }
        });
        
    }
    
    private void openBookApplicationFrame() {
    	dispose();
    	new BookApplicationFrame();
    }
    
    private void openBookStatusFrame() {
    	dispose();
    	new BookStatusFrame();
    }
    
    private void openApplicationStatusFrame() {
    	dispose();
    	new ApplicationStatusFrame();
    }
    
    private void openStudentInfoFrame() {
    	dispose();
    	new StudentInfoFrame();
    }
}
