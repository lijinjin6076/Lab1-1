package orz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class omz {
    String path = "";
    public String ddr(){
        //UIManager.put("Button.font", new Font("宋体", Font.PLAIN, 10));
        //UIManager.put("Label.font", new java.awt.Font("宋体", Font.PLAIN, 18));
        JFrame frame = new JFrame("路径获取");
        frame.setSize(600, 700);
        frame.setResizable(false);
        frame.setLocation(new Point(100, 100));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        JLabel label1 = new JLabel("请输入路径：");
        JTextArea textField = new JTextArea();
        JButton btn1 = new JButton("确定");
        frame.add(label1);
        frame.add(textField);
        frame.add(btn1);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C;/"));
        frame.add(fileChooser);

        label1.setBounds(20, 20, 80, 20);
        textField.setBounds(100, 20, 300, 20);
        btn1.setBounds(400, 20, 60, 20);
        fileChooser.setBounds(20, 100, 500, 300);
        label1.setFont(new Font("宋体", Font.PLAIN, 13));
        btn1.setFont(new Font("宋体", Font.PLAIN, 13));
        frame.setVisible(true);
        class butterListen implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                File file = new File(path);
                if (file.exists()) path = text;
                else {

                }
            }
        }

        butterListen butterlisten = new butterListen();
        btn1.addActionListener(butterlisten);
        return path;
    }

    /*class butterListen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //
        }
    }*/
}
