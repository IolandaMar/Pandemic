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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class PantallaGanado extends JPanel implements ActionListener, MouseListener{

	 private Image imagenDeFondo;
	    private Marco marco;
	    private JButton botonMenuInicio;
	    private JLabel Puntuaciones;

	    public PantallaGanado(String rutaImagen, Marco marco) {
	        this.marco = marco;
	        setLayout(new GridBagLayout());
	        setBorder(new EmptyBorder(600, 0, 0, 0));
	        imagenDeFondo = new ImageIcon(rutaImagen).getImage();

	        botonMenuInicio = crearBoton("src/img/Atras_Boton-1.png", 240, 64);
	        botonMenuInicio.addActionListener(this);
	        botonMenuInicio.addMouseListener(this);

	        GridBagConstraints gbc = new GridBagConstraints();
	        
	        Puntuaciones = new JLabel("<html><div>Puntuacion = "+ PantallaPartida.getPuntuacion() + "</div></html>");
	        Puntuaciones.setFont(new Font("Arial", Font.BOLD, 46));
			gbc.insets = new Insets(-400, 0, 0, 0); // Margen exterior
			Puntuaciones.setOpaque(false);
			Puntuaciones.setBorder(BorderFactory.createEmptyBorder());
			Puntuaciones.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
			Puntuaciones.setHorizontalAlignment(SwingConstants.CENTER);
			Puntuaciones.setPreferredSize(new Dimension(500, 100));
			Puntuaciones.setForeground(Color.BLACK);
			add(Puntuaciones, gbc);

	        gbc.gridx = 0;
	        gbc.gridy = 1;  
	        gbc.insets = new Insets(0, 0, 0, 0);
	        gbc.anchor = GridBagConstraints.CENTER;
	        add(botonMenuInicio, gbc);
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(imagenDeFondo, 0, 0, getWidth(), getHeight(), this);
	    }

	    @Override
	    public Dimension getPreferredSize() {
	        return new Dimension(800, 600); // Adjust dimensions as needed
	    }

	    private JButton crearBoton(String rutaImagen, int ancho, int alto) {
	        JButton boton = new JButton();
	        boton.setPreferredSize(new Dimension(ancho, alto));
	        ImageIcon imagenBoton = new ImageIcon(rutaImagen);
	        boton.setIcon(new ImageIcon(imagenBoton.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH)));
	        return boton;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == botonMenuInicio) {
	            setVisible(false);
	            marco.getContentPane().removeAll();
	            marco.add(new PanelPrincipal("src/img/FondoPantallaCompleto-1.png", marco));
	            marco.revalidate();
	            marco.repaint();
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
