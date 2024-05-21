import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;

import javax.print.attribute.AttributeSet;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class PantallaDificultad extends JPanel implements ActionListener, MouseListener{

	private Image imagenDeFondo;
    private Marco marco;
    private JButton botonAtras, Dificultad1, Dificultad2, Dificultad3;
    private JTextField Texto;
    
    public static String NombreJugador;
    public static int Dificultad;
    
    public PantallaDificultad(String rutaImagen, Marco marco) {
    	
        this.marco = marco;
        setLayout(new GridBagLayout());
        setBorder(new EmptyBorder(600, 0, 0, 0));
        imagenDeFondo = new ImageIcon(rutaImagen).getImage();

        botonAtras = crearBoton("src/img/Atras_Boton-1.png", 240, 64);
        Dificultad1 = crearBoton("src/img/BotonFacil.png", 240, 64);
        Dificultad2 = crearBoton("src/img/BotonNormal.png", 240, 64);
        Dificultad3 = crearBoton("src/img/BotonDificil.png", 240, 64);
        botonAtras.addActionListener(this);
        botonAtras.addMouseListener(this);
        Dificultad1.addActionListener(this);
        Dificultad1.addMouseListener(this);
        Dificultad2.addActionListener(this);
        Dificultad2.addMouseListener(this);
        Dificultad3.addActionListener(this);
        Dificultad3.addMouseListener(this);
        
        Texto = new JTextField(15);
        Texto.setText("Nombre Jugador");
        Texto.setForeground(Color.GRAY);
        
        Texto.setOpaque(false);  
        Texto.setBorder(null); 
        
        Dimension size = new Dimension(192, 64);
        Texto.setPreferredSize(size);
        
        Font font = Texto.getFont();
        Texto.setFont(new Font(font.getName(), Font.BOLD, 26));
        
        Texto.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (Texto.getText().equals("Nombre Jugador")) {
                	Texto.setText("");
                	Texto.setForeground(Color.BLACK); 
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Texto.getText().isEmpty()) {
                	Texto.setText("Nombre Jugador");
                	Texto.setForeground(Color.GRAY); 
                }
            }
        });
        
        Texto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NombreJugador = Texto.getText();
            }
        });
        
        GridBagConstraints gbc = new GridBagConstraints();
  
        gbc.gridx = 0;
        gbc.gridy = 1;  
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        add(botonAtras, gbc);
        
        gbc.insets = new Insets(-200, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        add(Texto, gbc);

        gbc.insets = new Insets(-450, -900, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        add(Dificultad1, gbc);
 
        gbc.insets = new Insets(-450, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        add(Dificultad2, gbc);

        gbc.insets = new Insets(-450, 900, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        add(Dificultad3, gbc);
        
        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke("ESCAPE"), "volverAtras");
        ActionMap actionMap = getActionMap();
        actionMap.put("volverAtras", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverAtras();
            }
        });
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenDeFondo, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
    
    private JButton crearBoton(String rutaImagen, int ancho, int alto) {
        JButton boton = new JButton();
        boton.setPreferredSize(new Dimension(ancho, alto));
        ImageIcon imagenBoton = new ImageIcon(rutaImagen);
        boton.setIcon(new ImageIcon(imagenBoton.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH)));
        return boton;
    }
    
    private void volverAtras() {
        setVisible(false);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.getContentPane().removeAll();
        frame.add(new PanelPrincipal("src/img/FondoPantallaCompleto-1.png", marco));
        frame.revalidate();
        frame.repaint();
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonAtras) {
            volverAtras();
        }else if (e.getSource() == Dificultad1) {
        	NombreJugador = Texto.getText();
        	if(NombreJugador.length() <= 16 || NombreJugador.equals(null)) {
        	setVisible(false);
        	Dificultad = 1;
            marco.getContentPane().removeAll(); 
            marco.getContentPane().add(new PantallaPartida("src/img/BackGround_Marks_1.png", marco));
            marco.revalidate(); 
            marco.repaint();
        	}
        }else if (e.getSource() == Dificultad2) {
        	            NombreJugador = Texto.getText();
        	if(NombreJugador.length() <= 16 || NombreJugador.equals(null)) {
        	setVisible(false);
        	Dificultad = 2;
            marco.getContentPane().removeAll(); 
            marco.getContentPane().add(new PantallaPartida("src/img/BackGround_Marks_1.png", marco));
            marco.revalidate(); 
            marco.repaint();
        	}
        }else if (e.getSource() == Dificultad3) {
        	NombreJugador = Texto.getText();
        	if(NombreJugador.length() <= 16 || NombreJugador.equals(null)) {
        	setVisible(false);
        	Dificultad = 3;
            marco.getContentPane().removeAll(); 
            marco.getContentPane().add(new PantallaPartida("src/img/BackGround_Marks_1.png", marco));
            marco.revalidate(); 
            marco.repaint();
        	}
        }
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

    	JButton boton = (JButton) e.getSource();
        Border customBorder = BorderFactory.createLineBorder(Color.WHITE, 5);
        boton.setBorder(customBorder);
    }

    public void mouseExited(MouseEvent e) {

    	JButton boton = (JButton) e.getSource();
        boton.setBorder(UIManager.getBorder("Button.border"));
    }
}
