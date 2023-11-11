package Manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Student.BookApplicationFrame;
import Student.ChooseFrame;

public class MChooseFrame extends JFrame {

	//JButton sInfo = new JButton("회원 관리");
    JButton registration = new JButton("도서 등록");
    JButton check = new JButton("도서 현황");
    JButton status = new JButton("신청 현황");
    
    JPanel welcome = new JPanel();

    public MChooseFrame() {
        initializeUI();
        addComponentsUI();
        eventHandler();
        setVisible(true);
    }

    private void initializeUI() {
        // 창 초기설정
        setSize(400, 200);
        setResizable(false);
        setTitle("관리자 화면");
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addComponentsUI() {
    	
        // 버튼 위치 및 크기 설정
        registration.setBounds(40, 50, 100, 50);
        check.setBounds(140, 50, 100, 50);
        status.setBounds(240, 50, 100, 50);
        //sInfo.setBounds(340, 50, 100, 50);

        // 프레임에 버튼 추가
        add(registration);
        add(check);
        add(status);
        //add(sInfo);
    }
    
    private void eventHandler() {
    	registration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openBookRegistrationFrame();
            }
        });
    	status.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			openMApplicationStatusFrame();
    		}
    	});
//    	sInfo.addActionListener(new ActionListener() {
//    		@Override
//    		public void actionPerformed(ActionEvent e) {
//    			openMStudentInformationFrame();
//    		}
//    	});
    	check.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			openMBookStatusFrame();
    		}
    	});
    }
    
    private void openBookRegistrationFrame() {
    	dispose();
    	new MBookRegistrationFrame();
    }
    
//    private void openMStudentInformationFrame() {
//    	dispose();
//    	new MStudentInformationFrame();
//    }
    private void openMApplicationStatusFrame() {
    	dispose();
    	new MApplicationStatusFrame();
    }
    
    private void openMBookStatusFrame() {
    	dispose();
    	new MBookStatusFrame();
    }
}
