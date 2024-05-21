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
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Ranking extends JPanel implements ActionListener, MouseListener {

    private Image imagenDeFondo;
    private Marco marco;
    private JButton botonAtras;
    private JLabel Posicion1, Posicion2, Posicion3, Posicion4, Posicion5, Gold, Metal, Bronze, nombreranking, fecharanking, puntosranking;

    public Ranking(String rutaImagen, Marco marco) {
        this.marco = marco;
        setLayout(new GridBagLayout());
        setBorder(new EmptyBorder(600, 0, 0, 0));
        imagenDeFondo = new ImageIcon(rutaImagen).getImage();

        String[] Partida_Id_BBDD = {"","",""};
        botonAtras = crearBoton("src/img/Atras_Boton-1.png", 240, 64);
        botonAtras.addActionListener(this);
        botonAtras.addMouseListener(this);
        
        GridBagConstraints gbc = new GridBagConstraints();

        Connection con = bbdd.conectarBaseDatos();
        
        String[] PartidaID_Base = {"NOM_JUGADOR", "PUNTUACION", "FECHA"};
        Partida_Id_BBDD = bbdd.select(con, "SELECT NOM_JUGADOR, PUNTUACION, FECHA"
				+ " FROM( "
				+ "    SELECT NOM_JUGADOR, PUNTUACION, FECHA, ROWNUM AS RN"
				+ "    FROM ("
				+ "        SELECT NOM_JUGADOR, PUNTUACION, FECHA"
				+ "        FROM RANKING"
				+ "        ORDER BY PUNTUACION DESC"
				+ "    )"
				+ ")"
				+ "WHERE RN = 1", PartidaID_Base);
        
        gbc.gridx = 0;
        gbc.gridy = 1;  
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        add(botonAtras, gbc);
        
        if(Partida_Id_BBDD[0].equals("")) {
	        Posicion1 = new JLabel("");
			}else{
				Posicion1 = new JLabel(
						"<html><body><table style=\"width:600px\">" +
					              "<tr>" +
					              "<td style=\"border: 1px solid black; width:33%; text-align: center;\">" + Partida_Id_BBDD[0] + "</td>" +
					              "<td style=\"border: 1px solid black; width:33%; text-align: center;\">" + Partida_Id_BBDD[1] + "</td>" +
					              "<td style=\"border: 1px solid black; width:33%; text-align: center;\">" + Partida_Id_BBDD[2] + "</td>" +
					              "</tr></table></body></html>");
	        }
		gbc.insets = new Insets(-850, 60, 10, 10);
		Posicion1.setOpaque(false);
		Posicion1.setPreferredSize(new Dimension(800, 50));
		Font font = Posicion1.getFont();
		Posicion1.setFont(new Font(font.getName(), Font.PLAIN, 26));
		add(Posicion1, gbc);
		Partida_Id_BBDD[0] = "";
		Partida_Id_BBDD = bbdd.select(con, "SELECT NOM_JUGADOR, PUNTUACION, FECHA"
				+ " FROM( "
				+ "    SELECT NOM_JUGADOR, PUNTUACION, FECHA, ROWNUM AS RN"
				+ "    FROM ("
				+ "        SELECT NOM_JUGADOR, PUNTUACION, FECHA"
				+ "        FROM RANKING"
				+ "        ORDER BY PUNTUACION DESC"
				+ "    )"
				+ ")"
				+ "WHERE RN = 2", PartidaID_Base);
		
		if(Partida_Id_BBDD[0].equals("")) {
	        Posicion2 = new JLabel("");
			}else{
				Posicion2 = new JLabel(
						"<html><body><table style=\"width:600px\">" +
					              "<tr>" +
					              "<td style=\"border: 1px solid black; width:33%; text-align: center;\">" + Partida_Id_BBDD[0] + "</td>" +
					              "<td style=\"border: 1px solid black; width:33%; text-align: center;\">" + Partida_Id_BBDD[1] + "</td>" +
					              "<td style=\"border: 1px solid black; width:33%; text-align: center;\">" + Partida_Id_BBDD[2] + "</td>" +
					              "</tr></table></body></html>");
	        }
		gbc.insets = new Insets(-700, 60, 10, 10);
		Posicion2.setOpaque(false);
		Posicion2.setPreferredSize(new Dimension(800, 50));
		font = Posicion2.getFont();
		Posicion2.setFont(new Font(font.getName(), Font.PLAIN, 26));
		add(Posicion2, gbc);
		Partida_Id_BBDD[0] = "";
		Partida_Id_BBDD = bbdd.select(con, "SELECT NOM_JUGADOR, PUNTUACION, FECHA"
				+ " FROM( "
				+ "    SELECT NOM_JUGADOR, PUNTUACION, FECHA, ROWNUM AS RN"
				+ "    FROM ("
				+ "        SELECT NOM_JUGADOR, PUNTUACION, FECHA"
				+ "        FROM RANKING"
				+ "        ORDER BY PUNTUACION DESC"
				+ "    )"
				+ ")"
				+ "WHERE RN = 3", PartidaID_Base);
		
		if(Partida_Id_BBDD[0].equals("")) {
	        Posicion3 = new JLabel("");
			}else{
				Posicion3 = new JLabel(
						"<html><body><table style=\"width:600px\">" +
					              "<tr>" +
					              "<td style=\"border: 1px solid black; width:33%; text-align: center;\">" + Partida_Id_BBDD[0] + "</td>" +
					              "<td style=\"border: 1px solid black; width:33%; text-align: center;\">" + Partida_Id_BBDD[1] + "</td>" +
					              "<td style=\"border: 1px solid black; width:33%; text-align: center;\">" + Partida_Id_BBDD[2] + "</td>" +
					              "</tr></table></body></html>");
	        }
		gbc.insets = new Insets(-550, 60, 10, 10);
		Posicion3.setOpaque(false);
		Posicion3.setPreferredSize(new Dimension(800, 50));
		font = Posicion3.getFont();
		Posicion3.setFont(new Font(font.getName(), Font.PLAIN, 26));
		add(Posicion3, gbc);
		Partida_Id_BBDD[0] = "";
		Partida_Id_BBDD = bbdd.select(con, "SELECT NOM_JUGADOR, PUNTUACION, FECHA"
				+ " FROM( "
				+ "    SELECT NOM_JUGADOR, PUNTUACION, FECHA, ROWNUM AS RN"
				+ "    FROM ("
				+ "        SELECT NOM_JUGADOR, PUNTUACION, FECHA"
				+ "        FROM RANKING"
				+ "        ORDER BY PUNTUACION DESC"
				+ "    )"
				+ ")"
				+ "WHERE RN = 4", PartidaID_Base);
		
		if(Partida_Id_BBDD[0].equals("")) {
	        Posicion4 = new JLabel("");
			}else{
				Posicion4 = new JLabel(
						"<html><body><table style=\"width:600px\">" +
					              "<tr>" +
					              "<td style=\"border: 1px solid black; width:33%; text-align: center;\">" + Partida_Id_BBDD[0] + "</td>" +
					              "<td style=\"border: 1px solid black; width:33%; text-align: center;\">" + Partida_Id_BBDD[1] + "</td>" +
					              "<td style=\"border: 1px solid black; width:33%; text-align: center;\">" + Partida_Id_BBDD[2] + "</td>" +
					              "</tr></table></body></html>");
	        }
		gbc.insets = new Insets(-400, 60, 10, 10);
		Posicion4.setOpaque(false);
		Posicion4.setPreferredSize(new Dimension(800, 50));
		font = Posicion4.getFont();
		Posicion4.setFont(new Font(font.getName(), Font.PLAIN, 26));
		add(Posicion4, gbc);
		Partida_Id_BBDD[0] = "";
		Partida_Id_BBDD = bbdd.select(con, "SELECT NOM_JUGADOR, PUNTUACION, FECHA"
				+ " FROM( "
				+ "    SELECT NOM_JUGADOR, PUNTUACION, FECHA, ROWNUM AS RN"
				+ "    FROM ("
				+ "        SELECT NOM_JUGADOR, PUNTUACION, FECHA"
				+ "        FROM RANKING"
				+ "        ORDER BY PUNTUACION DESC"
				+ "    )"
				+ ")"
				+ "WHERE RN = 5", PartidaID_Base);
		
		if(Partida_Id_BBDD[0].equals("")) {
	        Posicion5 = new JLabel("");
			}else{
				Posicion5 = new JLabel(
						"<html><body><table style=\"width:600px\">" +
					              "<tr>" +
					              "<td style=\"border: 1px solid black; width:33%; text-align: center;\">" + Partida_Id_BBDD[0] + "</td>" +
					              "<td style=\"border: 1px solid black; width:33%; text-align: center;\">" + Partida_Id_BBDD[1] + "</td>" +
					              "<td style=\"border: 1px solid black; width:33%; text-align: center;\">" + Partida_Id_BBDD[2] + "</td>" +
					              "</tr></table></body></html>");
	        }
		gbc.insets = new Insets(-250, 60, 10, 10);
		Posicion5.setOpaque(false);
		Posicion5.setPreferredSize(new Dimension(800, 50));
		font = Posicion5.getFont();
		Posicion5.setFont(new Font(font.getName(), Font.PLAIN, 26));
		add(Posicion5, gbc);
		
		nombreranking = new JLabel("");
		ImageIcon nr = new ImageIcon("src/img/nombrepuntuaciones.png");
		nombreranking.setIcon(nr);
		gbc.insets = new Insets(-980, -380, 10, 10);
		nombreranking.setPreferredSize(new Dimension(300, 47));
		add(nombreranking, gbc);
		
		puntosranking = new JLabel("");
		ImageIcon pr = new ImageIcon("src/img/puntospuntuaciones.png");
		puntosranking.setIcon(pr);
		gbc.insets = new Insets(-980, 130, 10, 10);
		puntosranking.setPreferredSize(new Dimension(300, 47));
		add(puntosranking, gbc);
		
		fecharanking = new JLabel("");
		ImageIcon fr = new ImageIcon("src/img/fechapuntuaciones.png");
		fecharanking.setIcon(fr);
		gbc.insets = new Insets(-980, 560, 10, 10);
		fecharanking.setPreferredSize(new Dimension(200, 47));
		add(fecharanking, gbc);
		
		
		Gold = new JLabel("");
		ImageIcon Medalla = new ImageIcon("src/img/gold.png");
		Gold.setIcon(Medalla);
		gbc.insets = new Insets(-850, -800, 10, 10);
		Gold.setPreferredSize(new Dimension(48, 47));
		add(Gold, gbc);
		
		
		Metal = new JLabel("");
		ImageIcon Medalla1 = new ImageIcon("src/img/metal.png");
		Metal.setIcon(Medalla1);
		gbc.insets = new Insets(-700, -800, 10, 10);
		Metal.setPreferredSize(new Dimension(37, 47));
		add(Metal, gbc);
		
		Bronze = new JLabel("");
		ImageIcon Medalla2 = new ImageIcon("src/img/bronce.png");
		Bronze.setIcon(Medalla2);
		gbc.insets = new Insets(-550, -800, 10, 10);
		Bronze.setPreferredSize(new Dimension(48, 47));
		add(Bronze, gbc);
        
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonAtras) {
            volverAtras();
        }
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