import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

JFrame frame = new JFrame("CACA");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Button b = new Button("Gola");
b.setSize(60, 60);
b.setLocation(400,400);
frame.getContentPane().add(b);

JTextField texto = new JTextField();
texto.setSize(200, 200);
texto.setLocation(500, 400);
texto.setText("dasasd");
frame.getContentPane().add(texto);
JTextField a = new JTextField();

a.setText(texto.getText());
a.setSize(20, 5);

JPanel pane = new JPanel();
pane.setBorder(BorderFactory.createLineBorder(Color.black));
pane.setSize(50, 50);
pane.setLocation(100,100);
frame.getContentPane().add(pane);
JPanel pane2 = new JPanel();
pane2.setBorder(BorderFactory.createLineBorder(Color.black));
pane2.setSize(200, 200);
pane2.setLocation(200, 400);
pane2.add(a);
frame.getContentPane().add(pane2);
frame.setSize(800, 600);

JMenu j = new JMenu("Archivo");
frame.getContentPane().add(j);
JMenuBar menuBar = new JMenuBar();
frame.getContentPane().add(menuBar);

frame.setVisible(true);
	    }
		
	}


