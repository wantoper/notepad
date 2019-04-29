package main;

import java.awt.Dimension;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.RootPaneContainer;

public class gui {

	public static void main(String[] args) {
		JFrame j = new JFrame();
		j.setTitle("test");
		j.setSize(1005, 655);
        j.setLocation(20, 10);
		j.setLayout(null);
		
		JPanel p = new JPanel();
		JTextArea ta = new JTextArea();
        
        //自动换行
        ta.setPreferredSize(new Dimension(980, 580));
        ta.setLineWrap(true);
        JScrollPane sp = new JScrollPane(ta);
        p.add(sp);
        
		
		JPanel p2 = new JPanel();
		
		JTabbedPane jt1 = new JTabbedPane();
		
		jt1.add(p);
		jt1.add(p2);
		
		jt1.setTitleAt(0, "红色tab");
		jt1.setTitleAt(1, "红色tab");
		
		j.setContentPane(jt1);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
	}

}
