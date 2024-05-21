import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class PanelPrincipal extends JPanel implements ActionListener, MouseListener {
	
    Instrucciones lamina_Instrucciones;

    private Image imagenDeFondo;
    private Marco marco;
    private JButton botonInformacion;
    private JButton botonPuntuaciones;
    private JButton botonSalir;
    private JButton botonNuevaPartida;
    JButton botonCargarPartida;

    PanelPrincipal(String rutaImagen, Marco marco) {
        this.marco = marco;
        setLayout(new GridBagLayout());
        setBorder(new EmptyBorder(150, 0, 0, 0));
        imagenDeFondo = new ImageIcon(rutaImagen).getImage();

        botonNuevaPartida = crearBoton("src/img/Nueva_Partida-Boton-1.png", 512, 64);
        botonCargarPartida = crearBoton("src/img/Cargar_Partida-Boton-1.png", 512, 64);
        botonInformacion = crearBoton("src/img/Instrucciones-Boton-1.png", 512, 64);
        botonPuntuaciones = crearBoton("src/img/Puntuaciones-Boton-1.png", 512, 64);
        botonSalir = crearBoton("src/img/Salir-Boton-3.png", 256, 64);

        botonNuevaPartida.addActionListener(this);
        botonNuevaPartida.addMouseListener(this);
        botonCargarPartida.addActionListener(this);
        botonCargarPartida.addMouseListener(this);
        botonInformacion.addActionListener(this);
        botonInformacion.addMouseListener(this);
        botonSalir.addActionListener(this);
        botonSalir.addMouseListener(this);
        botonPuntuaciones.addActionListener(this);
        botonPuntuaciones.addMouseListener(this);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.insets = new Insets(0, 70, 20, 0);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridy = 0;
        add(botonNuevaPartida, gbc);

        gbc.gridy++;
        add(botonCargarPartida, gbc);

        gbc.gridy++;
        add(botonInformacion, gbc);

        gbc.gridy++;
        add(botonPuntuaciones, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(botonSalir, gbc);

        botonInformacion.addActionListener(this);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenDeFondo, 0, 0, getWidth(), getHeight(), this);
    }

    private JButton crearBoton(String rutaImagen, int ancho, int alto) {
        JButton boton = new JButton();
        boton.setPreferredSize(new Dimension(ancho, alto));
        ImageIcon imagenBoton = new ImageIcon(rutaImagen);
        boton.setIcon(new ImageIcon(imagenBoton.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH)));
        return boton;
    }

    public void mouseEntered(MouseEvent e) {

    	JButton boton = (JButton) e.getSource();
        Border customBorder = BorderFactory.createLineBorder(Color.WHITE, 5);
        boton.setBorder(customBorder);
    }

    public void mouseExited(MouseEvent e) {

    	JButton boton = (JButton) e.getSource();
        boton.setBorder(UIManager.getBorder("Button.border"));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

    	if (e.getSource() == botonNuevaPartida) {
    		setVisible(false);
            marco.getContentPane().removeAll(); 
            marco.getContentPane().add(new PantallaDificultad("src/img/PantallaDificultad.png", marco));
            marco.revalidate(); 
            marco.repaint(); 
    	}if (e.getSource() == botonCargarPartida) {
    		
    		setVisible(false);
            marco.getContentPane().removeAll(); 
            marco.getContentPane().add(new PantallaCargarPartida("src/img/FondoPantalla.png", marco));
            marco.revalidate(); 
            marco.repaint(); 
    	}
    	if (e.getSource() == botonInformacion) {
            setVisible(false);
            marco.getContentPane().removeAll(); 
            marco.getContentPane().add(new Instrucciones("src/img/FondoInstrucciones.png", marco));
            marco.revalidate(); 
            marco.repaint(); 
        }
    	if (e.getSource() == botonPuntuaciones) {
    		setVisible(false);
    		marco.getContentPane().removeAll(); 
            marco.getContentPane().add(new Ranking("src/img/FondoPuntuaciones.png", marco));
            marco.revalidate(); 
            marco.repaint();
    	}
        if (e.getSource() == botonSalir) {
        	System.exit(0);
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
}
