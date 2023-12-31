package Manager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class MApplicationStatusFrame extends JFrame {

    JPanel borderPanel = new JPanel(); // border를 넣을 panel
    JPanel buttonPanel = new JPanel(); // button을 넣을 panel

    JButton backBtn = new JButton("이전으로");
    JButton checkBtn = new JButton("정보전송");

    JLabel applicationIDLabel = new JLabel("순번 : ");
    JLabel checkLabel = new JLabel("수락여부 : ");
    JLabel checkReasonLabel = new JLabel("사유 : ");

    JTextField applicationIDField = new JTextField();

    // JTable 모델
    String[] header = {"순번", "도서명", "카테고리", "가격", "신청사유", "판단사유", "현황"};
    DefaultTableModel tableModel = new DefaultTableModel(header, 0);
    JTable statusTable = new JTable(tableModel);

    String[] checkOptions = {"접수완료", "배송중", "입고완료", "승인거절"};
    String[] reasonOptions = {"사유충분", "학습용도", "사유불충분", "높은가격", "단종", "불건전콘텐츠"}; //더 있다면 추가할 것.
    
    JComboBox<String> checkBox = new JComboBox<>(checkOptions);
    JComboBox<String> reasonBox = new JComboBox<>(reasonOptions);

    public MApplicationStatusFrame() {
        initializeUI();
        addComponentsUI();
        eventHandler();
        loadApplicationStatus();
        setVisible(true);
    }

    private void initializeUI() {
        // 창 초기설정
        setSize(600, 500);
        setResizable(false);
        setTitle("아름다움");
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addComponentsUI() {
        borderPanel.setBounds(20, 20, 540, 380);
        borderPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "신청 현황"));
        borderPanel.setLayout(null);
        add(borderPanel);

        buttonPanel.setBounds(20, 410, 540, 40);
        add(buttonPanel);

        JScrollPane tableScrollPane = new JScrollPane(statusTable);
        tableScrollPane.setBounds(20, 35, 500, 200);
        borderPanel.add(tableScrollPane);

        // 순번 입력
        applicationIDLabel.setBounds(20, 250, 60, 25);
        applicationIDField.setBounds(90, 250, 80, 25);
        borderPanel.add(applicationIDLabel);
        borderPanel.add(applicationIDField);

        // 수락여부
        checkLabel.setBounds(20, 290, 80, 25);
        checkBox.setBounds(90, 290, 80, 25);
        borderPanel.add(checkLabel);
        borderPanel.add(checkBox);

        // 정보전송 버튼
        checkBtn.setBounds(450, 0, 90, 40);
        buttonPanel.add(checkBtn);
        
        //사유
        checkReasonLabel.setBounds(20, 330, 60, 25);
        reasonBox.setBounds(90, 330, 80, 25);
        borderPanel.add(checkReasonLabel);
        borderPanel.add(reasonBox);

        // panel에 이전버튼 생성
        backBtn.setBounds(350, 0, 90, 40);
        buttonPanel.setLayout(null);
        buttonPanel.add(backBtn);
    }

    private void eventHandler() {
        // 이전버튼
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openChooseFrame();
            }
        });

        // 정보전송 버튼
        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processCheck();
            }
        });
    }

    private void openChooseFrame() {
        dispose();
        new MChooseFrame();
    }

    private void loadApplicationStatus() {
        // 데이터베이스 연결 정보
    	// TODO config.properties로 정보를 숨길 수 있지 않을까?
        String DB_URL = "jdbc:mysql://localhost:3306/arumdaum?useTimezone=true&serverTimezone=UTC";
        String DB_USER = "root";
        String DB_PASSWORD = "0000";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            Statement statement = connection.createStatement();
            String selectQuery = "SELECT * FROM bookApplication order by id desc";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            // JTable 모델 초기화
            tableModel.setRowCount(0);

            // 결과셋을 JTable에 추가
            while (resultSet.next()) {
                String[] rowData = {
                        resultSet.getString("id"),
                        resultSet.getString("title"),
                        resultSet.getString("category"),
                        String.valueOf(resultSet.getInt("price")),
                        resultSet.getString("reason"), 
                        resultSet.getString("checkreason"),
                        resultSet.getString("status")
                };
                tableModel.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processCheck() {
        // 입력된 순번 가져오기
        String applicationID = applicationIDField.getText();

        // 선택된 수락여부 가져오기
        String selectedStatus = (String) checkBox.getSelectedItem();
        String selectedCheck = (String) reasonBox.getSelectedItem();
        
        //필드 체크하기
        if (applicationID.isEmpty() || selectedStatus.isEmpty() || selectedCheck.isEmpty()) {
            // Show a dialog indicating that all fields must be filled
            JOptionPane.showMessageDialog(this, "모든 필드를 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 순번을 기반으로 해당 행을 찾아 수락여부를 업데이트
        int rowIndex = -1; // 찾은 행의 인덱스
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).equals(applicationID)) {
                tableModel.setValueAt(selectedStatus, i, 3);
                tableModel.setValueAt(selectedCheck, i, 4);
                rowIndex = i; // 찾은 행의 인덱스 저장
                break; // 순번은 고유하기 때문에 찾았으면 더 이상 반복할 필요 없음
            }
        }

        // 데이터베이스 업데이트
        updateDatabase(applicationID, selectedStatus, selectedCheck);

        // 순번 입력 필드 초기화
        applicationIDField.setText("");
    }

    
    private void updateDatabase(String applicationID, String selectedStatus, String selectedReason) {
        // 데이터베이스 연결 정보
        String DB_URL = "jdbc:mysql://localhost:3306/arumdaum?useTimezone=true&serverTimezone=UTC";
        String DB_USER = "root";
        String DB_PASSWORD = "0000";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // SQL 쿼리 작성
            String updateQuery = "UPDATE bookApplication SET status = ?, checkreason = ? WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                // 쿼리에 파라미터 설정
                preparedStatement.setString(1, selectedStatus);
                preparedStatement.setString(2, selectedReason);
                preparedStatement.setString(3, applicationID);

                // 쿼리 실행
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
