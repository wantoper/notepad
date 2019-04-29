package main;

import java.awt.Dimension;
import java.awt.Panel;
import java.awt.TextArea;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class gui {
	static List<File> list = new ArrayList<>();
	static JFrame j = new JFrame();
	
	public static void main(String[] args) {
		
		j.setTitle("test");
		j.setSize(1005, 655);
        j.setLocation(20, 10);
		j.setLayout(null);
		
		filea(new File("D:/java"));
		
		JTabbedPane jt = new JTabbedPane();
		
		
		for(int x =0;x<list.size();x++){
			jt.add( newpane(list.get(x)));
			jt.setTitleAt(x, list.get(x).getName());
		}
		
		j.setContentPane(jt);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
	}

    public static JPanel newpane(File file){
    	JPanel p = new JPanel();
    	JTextArea jt = new JTextArea();
        JScrollPane jsp=new JScrollPane(jt);
        jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        jt.setPreferredSize(new Dimension(980, 580));
    	char[] all = new char[(int) file.length()];
        try (FileReader input = new FileReader(file)) {
            input.read(all);
        } catch (Exception e) {
            e.getMessage();
        }
        jt.setText(new String(all));

        p.add(jsp);
		return p;
    }
	
	
	public static void filea(File file){
		if(file.exists()){
			
			if(file.isFile()){
				if (file.getName().endsWith(".java")) {
	                list.add(file);
	            }
			}
			if(file.isDirectory()){
				File[] temp = file.listFiles();
	            if (temp != null) {
	                for (File file2 : temp) {
	                    filea(file2);
	                }
	            }
			}
			
		}else{
			System.out.println("文件不存在");
		}
	}

}
