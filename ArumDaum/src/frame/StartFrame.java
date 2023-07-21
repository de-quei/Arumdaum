package frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StartFrame extends JFrame {

	//배경 이미지 상대경로
    JLabel MainBackground = new JLabel(new ImageIcon("./img/loginframe.png"));

    public StartFrame() {
    	//창 초기설정
        this.setSize(1280, 750);
        this.setResizable(false);
        this.setTitle("아름다움");
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        //이미지의 위치, 크기
        MainBackground.setBounds(0, 0, 1280, 720);
        this.add(MainBackground);
        
        //창이 보이게 함.
        this.setVisible(true);
    }

}