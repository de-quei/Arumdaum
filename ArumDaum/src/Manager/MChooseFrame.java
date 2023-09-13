package Manager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MChooseFrame extends JFrame {

	JButton sInfo = new JButton("회원 관리");
    JButton search = new JButton("도서 등록");
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
        setSize(500, 200);
        setResizable(false);
        setTitle("관리자 화면");
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addComponentsUI() {
    	
        // 버튼 위치 및 크기 설정
        search.setBounds(40, 60, 100, 30);
        check.setBounds(140, 60, 100, 30);
        status.setBounds(240, 60, 100, 30);
        sInfo.setBounds(340, 60, 100, 30);

        // 프레임에 버튼 추가
        add(search);
        add(check);
        add(status);
        add(sInfo);
    }
    
    private void eventHandler() {
    	
    }
    
}
