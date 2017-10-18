package orz;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.regex.*;

public class all extends Component {
    JLabel slabel1 = new JLabel("Word1:");
    JLabel slabel2 = new JLabel("Word2:");
    JLabel slabel3 = new JLabel("新文本：");
    JTextField word1txt = new JTextField();
    JTextField word2txt = new JTextField();
    JTextField textField = new JTextField();
    JButton sbutton1 = new JButton("查询");
    JButton sbutton2 = new JButton("查询");
    JButton sbutton3 = new JButton("查询");

    public void mainpage(){
        onz trick = new onz(); boolean che = true;
        /*
        while (che){
            try {
                trick.readin(getpath());
                che = false;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }*/
        UIManager.put("Button.font", new Font("宋体",Font.PLAIN, 25));
        JFrame frame = new JFrame("Java是世界上最好的语言");
        JButton button1 = new JButton("读入新文本");
        JButton button2 = new JButton("展示有向图");
        JButton button3 = new JButton("查询桥接词");
        JButton button4 = new JButton("生成新文本");
        JButton button5 = new JButton("最短路径");
        JButton button6 = new JButton("随机游走");
        JTextArea area = new JTextArea();
        frame.setSize(670, 440);
        frame.setLocation(new Point(100, 100));
        //frame.setResizable(false);
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
        area.setBounds(220, 70, 375, 300);
        area.setLineWrap(true); area.setWrapStyleWord(true);
        area.setFont(new Font("宋体",Font.PLAIN, 20));
        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setBounds(220, 70, 375, 300);
        frame.add(scrollPane);
        area.setEditable(false);

        frame.add(slabel1); frame.add(slabel2); frame.add(slabel3);
        frame.add(word1txt); frame.add(word2txt); frame.add(textField);
        frame.add(sbutton1); frame.add(sbutton2); frame.add(sbutton3);
        slabel1.setBounds(220, 30, 41, 25);
        word1txt.setBounds(263,30,100,25);
        slabel2.setBounds(380, 30, 41, 25);
        word2txt.setBounds(423,30,100,25);
        slabel3.setBounds(220, 30, 52, 25);
        textField.setBounds(272,30,261,25);
        sbutton1.setBounds(535,30,60,24);
        sbutton2.setBounds(535,30,60,24);
        sbutton3.setBounds(535,30,60,24);
        mmp();



        frame.setVisible(true);



        class buListen1 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = getpath();
                try {
                    trick.readin(path);
                    area.setText("文件："+ path);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        }
        button1.addActionListener(new buListen1());

        class buListen2 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    trick.showDirectedGraph(trick.nextnode, trick.pointarray, trick.top);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        button2.addActionListener(new buListen2());

        class buListen3 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                mmp(); sbutton1.setVisible(true);
                slabel1.setVisible(true); slabel2.setVisible(true);
                word1txt.setVisible(true); word2txt.setVisible(true);
            }
        }
        button3.addActionListener(new buListen3());

        class buListen4 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) { mmp();
                slabel3.setVisible(true); textField.setVisible(true); sbutton2.setVisible(true);
            }
        }
        button4.addActionListener(new buListen4());

        class buListen5 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                mmp(); sbutton3.setVisible(true);
                slabel1.setVisible(true); word1txt.setVisible(true);
                slabel2.setVisible(true); word2txt.setVisible(true);
            }
        }
        button5.addActionListener(new buListen5());

        class buListen6 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {mmp();

            }
        }
        button6.addActionListener(new buListen6());

        class sbuListen1 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                String word1 = word1txt.getText();
                String word2 = word2txt.getText();
                String string = area.getText();
                string =  string + "\n" + trick.queryBridgeWords(word1, word2);
                area.setText(string);
            }
        }
        sbutton1.addActionListener(new sbuListen1());

        class sbuListen2 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtstr = textField.getText();
                String string = area.getText();
                string = string + "\n" + trick.generateNewText(txtstr);
                area.setText(string);
            }
        }
        sbutton2.addActionListener(new sbuListen2());

        class sbuListen3 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String word1 = word1txt.getText();
                String word2 = word2txt.getText();
                String string = area.getText();
                string =  string + "\n" + trick.calcShortestPath(word1, word2);
                area.setText(string);
            }
        }
        sbutton3.addActionListener(new sbuListen3());
    }
    private void mmp(){
        slabel1.setVisible(false);
        slabel2.setVisible(false);
        slabel3.setVisible(false);
        word1txt.setVisible(false);
        word2txt.setVisible(false);
        textField.setVisible(false);
        sbutton1.setVisible(false);
        sbutton2.setVisible(false);
        sbutton3.setVisible(false);
    }

    private String getpath(String titel){
        JFileChooser chooser = new JFileChooser(titel);
        chooser.setCurrentDirectory(new File("/"));
        chooser.showOpenDialog(all.this);
        String path = chooser.getSelectedFile().getPath();
        return path;
    }
    private String getpath(){ return getpath("打开");}
    /*
    private void dotconfig() throws IOException {
        String path = System.getProperty("user.dir");
        File file = new File(path+"/config");
        if (file.exists()){
            InputStream inputStream = new FileInputStream(file); String string;
            try (Scanner scanner = new Scanner(inputStream, "UTF-8")) {
                string = scanner.useDelimiter("\\A").next();
            }
            String patt = "[DotPath=*]";
            Pattern r = Pattern.compile(patt);
            Matcher m = r.matcher(string);
            if (m.find())   ;//hjgjkyhkgkhjgggggggggggggggggggggggggggggggggggggggggggggggggggyutugugjggyugkjhgtuy
            else ;
        }
        else{
            file.createNewFile();
            String con = getpath("打开dot.exe所在位置");
        }
    }*/
}
