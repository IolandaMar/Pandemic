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
import java.sql.Connection;

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

public class PantallaCargarPartida extends JPanel implements ActionListener, MouseListener{

	private Image imagenDeFondo;
    private Marco marco;
    private JButton botonAtras, Partida_1, Partida_2, Partida_3, Borrar1, Borrar2, Borrar3;
    public static int NumeroPartidaGuardada = 0;
    
    public static boolean CargarPartida = false;
    
    private JLabel Partida_1Label, Partida_2Label, Partida_3Label;
    
    public static String[] Partida_Id_BBDD;
    
    public PantallaCargarPartida(String rutaImagen, Marco marco) {
        this.marco = marco;
        setLayout(new GridBagLayout());
        setBorder(new EmptyBorder(600, 0, 0, 0));
        imagenDeFondo = new ImageIcon(rutaImagen).getImage();

        botonAtras = crearBoton("src/img/Atras_Boton-1.png", 240, 64);
        Partida_1 = crearBoton("src/img/Partida1.png", 240, 64);
        Partida_2 = crearBoton("src/img/Partida2.png", 240, 64);
        Partida_3 = crearBoton("src/img/Partida3.png", 240, 64);
        Borrar1 = crearBoton("src/img/Basura.png", 48, 48);
        Borrar2 = crearBoton("src/img/Basura.png", 48, 48);
        Borrar3 = crearBoton("src/img/Basura.png", 48, 48);
        botonAtras.addActionListener(this);
        botonAtras.addMouseListener(this);
        Partida_1.addActionListener(this);
        Partida_1.addMouseListener(this);
        Partida_2.addActionListener(this);
        Partida_2.addMouseListener(this);
        Partida_3.addActionListener(this);
        Partida_3.addMouseListener(this);

        GridBagConstraints gbc = new GridBagConstraints();

        Connection con = bbdd.conectarBaseDatos();
    	String[] NombreJugador_Base = {"NOM_JUGADOR"};
		String[] NombreJugador_BBDD = bbdd.select(con, "SELECT NOM_JUGADOR FROM PARTIDA WHERE PARTIDA_ID = "+ 0 +"", NombreJugador_Base);
		String NombreJugador = "  Vacio";
		if(NombreJugador_BBDD[0].equals("")) {
		}else {
			NombreJugador = NombreJugador_BBDD[0];
		}
		
        Partida_1Label = new JLabel("  "+NombreJugador+"");
        Font font = Partida_1Label.getFont();
        Partida_1Label.setFont(new Font(font.getName(), Font.BOLD, 26));
        Partida_1Label.setForeground(Color.WHITE);
		gbc.gridx = 0; // Columna
		gbc.gridy = 0; // Fila
		gbc.insets = new Insets(-600, -900, 10, 10); // Margen exterior
		Partida_1Label.setOpaque(false);
		Partida_1Label.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		Partida_1Label.setVisible(true); // Ocultar la etiqueta inicialmente
		Partida_1Label.setPreferredSize(new Dimension(200, 50));
		add(Partida_1Label, gbc);
		
		NombreJugador_BBDD = bbdd.select(con, "SELECT NOM_JUGADOR FROM PARTIDA WHERE PARTIDA_ID = "+ 1 +"", NombreJugador_Base);
			NombreJugador = "  Vacio";
			if(NombreJugador_BBDD[0].equals("")) {
			}else {
				NombreJugador = NombreJugador_BBDD[0];
			}
		
		Partida_2Label = new JLabel("  "+NombreJugador+"");
		font = Partida_2Label.getFont();
        Partida_2Label.setFont(new Font(font.getName(), Font.BOLD, 26));
        Partida_2Label.setForeground(Color.WHITE);
		gbc.insets = new Insets(-600, 0, 10, 10); // Margen exterior
		Partida_2Label.setOpaque(false);
		Partida_2Label.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		Partida_2Label.setVisible(true); // Ocultar la etiqueta inicialmente
		Partida_2Label.setPreferredSize(new Dimension(200, 50));
		add(Partida_2Label, gbc);
		
		NombreJugador_BBDD = bbdd.select(con, "SELECT NOM_JUGADOR FROM PARTIDA WHERE PARTIDA_ID = "+ 2 +"", NombreJugador_Base);
			NombreJugador = "  Vacio";
			if(NombreJugador_BBDD[0].equals("")) {
			}else {
				NombreJugador = NombreJugador_BBDD[0];
			}
			
		Partida_3Label = new JLabel("  "+NombreJugador+"");
		font = Partida_3Label.getFont();
        Partida_3Label.setFont(new Font(font.getName(), Font.BOLD, 26));
        Partida_3Label.setForeground(Color.WHITE);
		gbc.insets = new Insets(-600, 900, 10, 10); // Margen exterior
		Partida_3Label.setOpaque(false);
		Partida_3Label.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		Partida_3Label.setVisible(true); // Ocultar la etiqueta inicialmente
		Partida_3Label.setPreferredSize(new Dimension(200, 50));
		add(Partida_3Label, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;  
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        add(botonAtras, gbc);
        
        gbc.insets = new Insets(-550, -900, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        add(Partida_1, gbc);
        
        gbc.insets = new Insets(-555, -600, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        Borrar1.setBorderPainted(false);
        Borrar1.setContentAreaFilled(false);
        add(Borrar1, gbc);
        Borrar1.addActionListener(this);
        Borrar1.addMouseListener(this);
        
        gbc.insets = new Insets(-550, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        add(Partida_2, gbc);
        
        gbc.insets = new Insets(-555, 300, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        Borrar2.setBorderPainted(false);
        Borrar2.setContentAreaFilled(false);
        add(Borrar2, gbc);
        Borrar2.addActionListener(this);
        Borrar2.addMouseListener(this);
          
        gbc.insets = new Insets(-550, 900, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        add(Partida_3, gbc);
        
        gbc.insets = new Insets(-555, 1200, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        Borrar3.setBorderPainted(false);
        Borrar3.setContentAreaFilled(false);
        add(Borrar3, gbc);
        Borrar3.addActionListener(this);
        Borrar3.addMouseListener(this);
        
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
        }else if (e.getSource() == Partida_1) {
        	Connection con = bbdd.conectarBaseDatos();
        	String[] PartidaID_Base = {"PARTIDA_ID"};
    		Partida_Id_BBDD = bbdd.select(con, "SELECT PARTIDA_ID FROM PARTIDA WHERE PARTIDA_ID = "+ 0 +"", PartidaID_Base);
    		
    		if(Integer.parseInt(Partida_Id_BBDD[0]) == 0) {
    			CargarPartida = true;
    			marco.getContentPane().removeAll(); 
                marco.getContentPane().add(new PantallaPartida("src/img/BackGround_Marks_1.png", marco));
                marco.revalidate(); 
                marco.repaint();
    		}else {
    			
    		}
        }else if (e.getSource() == Partida_2) {
        	Connection con = bbdd.conectarBaseDatos();
        	String[] PartidaID_Base = {"PARTIDA_ID"};
    		Partida_Id_BBDD = bbdd.select(con, "SELECT PARTIDA_ID FROM PARTIDA WHERE PARTIDA_ID = "+ 1 +"", PartidaID_Base);
    		
    		if(Integer.parseInt(Partida_Id_BBDD[0]) == 1) {
    			CargarPartida = true;
    			marco.getContentPane().removeAll(); 
                marco.getContentPane().add(new PantallaPartida("src/img/BackGround_Marks_1.png", marco));
                marco.revalidate(); 
                marco.repaint();
    		}else {
    			
    		}
        }else if (e.getSource() == Partida_3) {
        	Connection con = bbdd.conectarBaseDatos();
        	String[] PartidaID_Base = {"PARTIDA_ID"};
    		Partida_Id_BBDD = bbdd.select(con, "SELECT PARTIDA_ID FROM PARTIDA WHERE PARTIDA_ID = "+ 2 +"", PartidaID_Base);
    		
    		if(Integer.parseInt(Partida_Id_BBDD[0]) == 2) {
    			CargarPartida = true;
    			marco.getContentPane().removeAll(); 
                marco.getContentPane().add(new PantallaPartida("src/img/BackGround_Marks_1.png", marco));
                marco.revalidate(); 
                marco.repaint();
    		}else {
    			
    		}
        }else if (e.getSource() == Borrar1) {
        	Connection con = bbdd.conectarBaseDatos();
        	String[] PartidaID_Base = {"PARTIDA_ID"};
    		Partida_Id_BBDD = bbdd.select(con, "SELECT PARTIDA_ID FROM PARTIDA WHERE PARTIDA_ID = "+ 0 +"", PartidaID_Base);
    		if(Integer.parseInt(Partida_Id_BBDD[0]) == 0) {
    			bbdd.delete(con, "DELETE FROM VACUNA WHERE PARTIDA_ID = "+Partida_Id_BBDD[0]+"");
    			bbdd.delete(con, "DELETE FROM CIUDAD WHERE PARTIDA_ID = "+Partida_Id_BBDD[0]+"");
    			bbdd.delete(con, "DELETE FROM PARTIDA WHERE PARTIDA_ID = "+Partida_Id_BBDD[0]+"");
    			Partida_1Label.setText(" Vacio ");
    		}else {
    			
    		}
        }else if (e.getSource() == Borrar2) {
        	Connection con = bbdd.conectarBaseDatos();
        	String[] PartidaID_Base = {"PARTIDA_ID"};
    		Partida_Id_BBDD = bbdd.select(con, "SELECT PARTIDA_ID FROM PARTIDA WHERE PARTIDA_ID = "+ 1 +"", PartidaID_Base);
    		if(Integer.parseInt(Partida_Id_BBDD[0]) == 1) {
    			bbdd.delete(con, "DELETE FROM VACUNA WHERE PARTIDA_ID = "+Partida_Id_BBDD[0]+"");
    			bbdd.delete(con, "DELETE FROM CIUDAD WHERE PARTIDA_ID = "+Partida_Id_BBDD[0]+"");
    			bbdd.delete(con, "DELETE FROM PARTIDA WHERE PARTIDA_ID = "+Partida_Id_BBDD[0]+"");
    			Partida_2Label.setText(" Vacio ");
    		}else {
    			
    		}
        }else if (e.getSource() == Borrar3) {
        	Connection con = bbdd.conectarBaseDatos();
        	String[] PartidaID_Base = {"PARTIDA_ID"};
    		Partida_Id_BBDD = bbdd.select(con, "SELECT PARTIDA_ID FROM PARTIDA WHERE PARTIDA_ID = "+ 2 +"", PartidaID_Base);
    		if(Integer.parseInt(Partida_Id_BBDD[0]) == 2) {
    			bbdd.delete(con, "DELETE FROM VACUNA WHERE PARTIDA_ID = "+Partida_Id_BBDD[0]+"");
    			bbdd.delete(con, "DELETE FROM CIUDAD WHERE PARTIDA_ID = "+Partida_Id_BBDD[0]+"");
    			bbdd.delete(con, "DELETE FROM PARTIDA WHERE PARTIDA_ID = "+Partida_Id_BBDD[0]+"");
    			Partida_3Label.setText(" Vacio ");
    		}else {
    			
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
        ImageIcon imagenIcono;
        if(e.getSource() == Borrar1) {
        	 String rutaImagen = "src/img/BasuraCerrado.png"; 
 		    imagenIcono = new ImageIcon(rutaImagen); 
 		   Borrar1.setIcon(new ImageIcon(imagenIcono.getImage().getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH)));
        } else if(e.getSource() == Borrar2) {
       	 String rutaImagen = "src/img/BasuraCerrado.png"; 
		    imagenIcono = new ImageIcon(rutaImagen); 
		   Borrar2.setIcon(new ImageIcon(imagenIcono.getImage().getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH)));
       }else if(e.getSource() == Borrar3) {
         	 String rutaImagen = "src/img/BasuraCerrado.png"; 
 		    imagenIcono = new ImageIcon(rutaImagen); 
 		   Borrar3.setIcon(new ImageIcon(imagenIcono.getImage().getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH)));
        }
    }

    public void mouseExited(MouseEvent e) {

    	JButton boton = (JButton) e.getSource();
        boton.setBorder(UIManager.getBorder("Button.border"));
        ImageIcon imagenIcono;
        if(e.getSource() == Borrar1) {
       	 String rutaImagen = "src/img/Basura.png"; 
		    imagenIcono = new ImageIcon(rutaImagen); 
		   Borrar1.setIcon(new ImageIcon(imagenIcono.getImage().getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH)));
       }else if(e.getSource() == Borrar2) {
         	 String rutaImagen = "src/img/Basura.png"; 
 		    imagenIcono = new ImageIcon(rutaImagen); 
 		   Borrar2.setIcon(new ImageIcon(imagenIcono.getImage().getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH)));
        }else if(e.getSource() == Borrar3) {
        	 String rutaImagen = "src/img/Basura.png"; 
		    imagenIcono = new ImageIcon(rutaImagen); 
		   Borrar3.setIcon(new ImageIcon(imagenIcono.getImage().getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH)));
       }
    }
}
