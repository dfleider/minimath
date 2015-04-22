import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MainGUI {

    String      appName     = "MiniMath";
    MainGUI     mainGUI;
    MenuExp     newFrame    = new MenuExp();
    JButton     enviarComando;
    JTextField  mensajeComando;
    JTextArea   commandBox;
    JTextField  usernameChooser;
    MenuExp     preFrame;
   

    public static void main(String[] args) {
         

    	
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager
                            .getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                MainGUI mainGUI = new MainGUI();
                mainGUI.preDisplay();
            }
        });
    }

    public void preDisplay() {
        newFrame.setVisible(false);
        //newFrame.setResizable(false);
        newFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 

        preFrame = new MenuExp();
        preFrame.setSize(300, 300);
        JButton enterServer = new JButton("Ingresar a MiniMath");
        enterServer.addActionListener(new EntrarProgramaButtonListener());
        JPanel prePanel = new JPanel(new BorderLayout());

        BufferedImage logo;
    	try {
    		
    		logo = ImageIO.read(new File("logo.jpg"));
    		
    	    JLabel picLogo = new JLabel(new ImageIcon(logo));

    	    prePanel.add(picLogo,BorderLayout.CENTER);

    	    System.out.println("Funco");
    
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		System.out.println("no abrio");
    	}

        preFrame.add(BorderLayout.CENTER, prePanel);
        preFrame.add(BorderLayout.SOUTH, enterServer);
       
        preFrame.setVisible(true);
        
    }
    public Dimension getPreferredSize() {
        return new Dimension(100, 600);
    }
    public void display() {
    	//BorderLayout principal = new BorderLayout();
    	JPanel panelCentral = new JPanel(new BorderLayout());
    	//panelCentral.setLayout();
    	panelCentral.setBackground(Color.CYAN);
    	//panelCentral.setSize(600, 200);
        JPanel panelMensajes = new JPanel(new BorderLayout());
        JPanel panelGraficos = new JPanel(new BorderLayout());
        //panelMensajes.setLayout(new BorderLayout());
        //panelMensajes.setSize(600, 400);
        //panelGraficos.setLayout(new BorderLayout());
        //panelGraficos.setSize(600, 400);
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.setBackground(Color.BLUE);
        
        //panelGraficos.setLayout(new BorderLayout());
        
        mensajeComando = new JTextField(10);
        mensajeComando.requestFocusInWindow();

        enviarComando = new JButton("Send Command");
        enviarComando.addActionListener(new EnviarComandoButtonListener());

        commandBox = new JTextArea();
        //commandBox.setSize(300, 300);
        commandBox.setEditable(false);
        commandBox.setFont(new Font("Serif", Font.PLAIN, 15));
        commandBox.setLineWrap(true);
        commandBox.setSize(300, 500);

        panelMensajes.add(new JScrollPane(commandBox), BorderLayout.WEST);


        southPanel.add(mensajeComando, BorderLayout.EAST);
        southPanel.add(enviarComando, BorderLayout.WEST);

        panelMensajes.add(southPanel,BorderLayout.SOUTH);
        JButton botonGrafico = new JButton();
        botonGrafico.setLayout(null);
        botonGrafico.setBounds(350, 100, 50, 50);
        panelGraficos.setBackground(Color.BLACK);
        panelCentral.getPreferredSize();
        newFrame.add(botonGrafico);
        newFrame.add(panelCentral,BorderLayout.CENTER);

        
        newFrame.add(panelMensajes, BorderLayout.BEFORE_LINE_BEGINS);
        newFrame.setDefaultCloseOperation(MenuExp.EXIT_ON_CLOSE);

        newFrame.setVisible(true);
        newFrame.add(BorderLayout.LINE_END,panelGraficos);
        BufferedImage imagenWn;
    	try {
    		
    		imagenWn = ImageIO.read(new File("felipe.jpg"));
    		
    	    JLabel picLabel = new JLabel(new ImageIcon(imagenWn.getSubimage(300, 100, 300, 300)));

    	    panelGraficos.add(picLabel,BorderLayout.NORTH);

    	    System.out.println("Funco");
    
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		System.out.println("no abrio");
    	}
     
 
    }
    

    class EnviarComandoButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (mensajeComando.getText().length() < 1) {
                // do nothing
            } else if (mensajeComando.getText().equals(".clear")) {
                commandBox.setText("Cleared all messages\n");
                mensajeComando.setText("");
            } else {
                commandBox.append(lineaComando + mensajeComando.getText()
                        + "\n");
                mensajeComando.setText("");
            }
            mensajeComando.requestFocusInWindow();
        }
    }

    String  lineaComando;

    class EntrarProgramaButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            
        	lineaComando="> ";

            if (lineaComando.length() < 1) {
                System.out.println("IngreseComando");
            } else {
                preFrame.setVisible(false);
                display();
            }
        }

    }
    
    
}