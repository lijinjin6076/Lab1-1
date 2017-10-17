package orz;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

public class all extends Component {
    public void mainpage(){
        onz trick = new onz();
        UIManager.put("Button.font", new Font("宋体",Font.PLAIN, 25));
        JFrame frame = new JFrame("Java是世界上最好的语言");
        JButton button1 = new JButton("读入新文本");
        JButton button2 = new JButton("展示有向图");
        JButton button3 = new JButton("查询桥接词");
        JButton button4 = new JButton("生成新文本");
        JButton button5 = new JButton("最短路径");
        JButton button6 = new JButton("随机游走");
        frame.setSize(530, 440);
        frame.setLocation(new Point(100, 100));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.add(button1); frame.add(button2); frame.add(button3);
        frame.add(button4); frame.add(button5); frame.add(button6);
        button1.setBounds(30, 30, 160, 40);
        button2.setBounds(30, 90, 160, 40);
        button3.setBounds(30, 150, 160, 40);
        button4.setBounds(30, 210, 160, 40);
        button5.setBounds(30, 270, 160, 40);
        button6.setBounds(30, 330, 160, 40);
        frame.setVisible(true);

        class buListen1 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File("/"));
                chooser.showOpenDialog(all.this);
                String path = chooser.getSelectedFile().getPath();
                try {
                    trick.readin(path);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                System.out.println(path);
            }
        }
        button1.addActionListener(new buListen1());

        class buListen2 implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }
        button2.addActionListener(new buListen2());

        class buListen3 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }
        button3.addActionListener(new buListen3());

        class buListen4 implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }
        button4.addActionListener(new buListen4());

        class buListen5 implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                button6.setVisible(true);
            }
        }
        button5.addActionListener(new buListen5());

        class buListen6 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                button6.setVisible(false);
            }
        }
        button6.addActionListener(new buListen6());

    }

}
