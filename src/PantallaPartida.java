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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashSet;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class PantallaPartida extends JPanel implements ActionListener, MouseListener {

	public static Connection con;
	
	private static int VirusSanFrancisco = 0, VirusChicago = 0, VirusAtlanta = 0, VirusMontreal = 0, 
            VirusNuevaYork = 0, VirusWashington = 0, VirusLondres = 0, VirusMadrid = 0, 
            VirusParis = 0, VirusEssen = 0, VirusMilan = 0, VirusSanPetersburgo = 0, 
            VirusLosAngeles = 0, VirusMiami = 0, VirusMexico = 0, VirusBogota = 0, 
            VirusLima = 0, VirusSantiago = 0, VirusBuenosAires = 0, VirusSaoPaulo = 0, 
            VirusLagos = 0, VirusKinsasa = 0, VirusJartum = 0, VirusJohannesburgo = 0, 
            VirusArgel = 0, VirusCairo = 0, VirusRiad = 0, VirusEstambul = 0, VirusBagdad = 0, 
            VirusMoscu = 0, VirusTeheran = 0, VirusKarachi = 0, VirusBombay = 0, 
            VirusNuevaDelhi = 0, VirusCalcuta = 0, VirusMadras = 0, VirusYakarta = 0, 
            VirusBangkok = 0, VirusHongKong = 0, VirusShanghai = 0, VirusPekin = 0, 
            VirusSeul = 0, VirusTokio = 0, VirusOsaka = 0, VirusTaipei = 0, 
            VirusHoChiMinh = 0, VirusManila = 0, VirusSidney = 0;
	private Image imagenDeFondo;
	private ImageIcon carta;
	private Marco marco;
	private JButton SanFrancisco, Chicago, Atlanta, Montreal, NuevaYork, Washington, Londres, Madrid, Paris, Essen,
					Milan, SanPetersburgo, LosAngeles, Miami, Mexico, Bogota, Lima, Santiago, BuenosAires, SaoPaulo, Lagos,
					Kinsasa, Jartum, Johannesburgo, Argel, Cairo, Riad, Estambul, Bagdad, Moscu, Teheran, Karachi, Bombay,
					NuevaDelhi, Calcuta, Madras, Yakarta, Bangkok, HongKong, Shanghai, Pekin, Seul, Tokio, Osaka, Taipei,
					HoChiMinh, Manila, Sidney, DesarrollarCura, CurarCiudad, CuraAzul, CuraNegro, CuraAmarillo, CuraRojo,
					Opciones, GuardarPartida, VolverMenu, PasarTurno, Cuarentena;
	
	private JLabel SanFranciscoLabel, ChicagoLabel, AtlantaLabel, MontrealLabel, NuevaYorkLabel, WashingtonLabel,
					LondresLabel, MadridLabel, ParisLabel, EssenLabel, MilanLabel, SanPetersburgoLabel, LosAngelesLabel,
					MiamiLabel, MexicoLabel, BogotaLabel, LimaLabel, SantiagoLabel, BuenosAiresLabel, SaoPauloLabel, LagosLabel,
					KinsasaLabel, JartumLabel, JohannesburgoLabel, ArgelLabel, CairoLabel, RiadLabel, EstambulLabel,
					BagdadLabel, MoscuLabel, TeheranLabel, KarachiLabel, BombayLabel, NuevaDelhiLabel, CalcutaLabel,
					MadrasLabel, YakartaLabel, BangkokLabel, HongKongLabel, ShanghaiLabel, PekinLabel, SeulLabel, TokioLabel,
					OsakaLabel, TaipeiLabel, HoChiMinhLabel, ManilaLabel, SidneyLabel, LabelIntentos, AzulLabel, NegroLabel,
					AmarilloLabel, RojoLabel, Nivel1, Nivel2, Nivel3, Nivel4, Nivel5, VirusTotales, VirusActual, LabelNoMasPartida;
	
	private JLabel SanFranciscoExclamation, ChicagoExclamation, AtlantaExclamation, MontrealExclamation, NuevaYorkExclamation, 
				    WashingtonExclamation, LondresExclamation, MadridExclamation, ParisExclamation, EssenExclamation, 
				    MilanExclamation, SanPetersburgoExclamation, LosAngelesExclamation, MiamiExclamation, MexicoExclamation, 
				    BogotaExclamation, LimaExclamation, SantiagoExclamation, BuenosAiresExclamation, SaoPauloExclamation, 
				    LagosExclamation, KinsasaExclamation, JartumExclamation, JohannesburgoExclamation, ArgelExclamation, 
				    CairoExclamation, RiadExclamation, EstambulExclamation, BagdadExclamation, MoscuExclamation, TeheranExclamation, 
				    KarachiExclamation, BombayExclamation, NuevaDelhiExclamation, CalcutaExclamation, MadrasExclamation, 
				    YakartaExclamation, BangkokExclamation, HongKongExclamation, ShanghaiExclamation, PekinExclamation, 
				    SeulExclamation, TokioExclamation, OsakaExclamation, TaipeiExclamation, HoChiMinhExclamation, ManilaExclamation, 
				    SidneyExclamation;

	private boolean SanFranciscoCuarentena, ChicagoCuarentena, AtlantaCuarentena, MontrealCuarentena, NuevaYorkCuarentena, WashingtonCuarentena, LondresCuarentena, MadridCuarentena, ParisCuarentena, EssenCuarentena,
	MilanCuarentena, SanPetersburgoCuarentena, LosAngelesCuarentena, MiamiCuarentena, MexicoCuarentena, BogotaCuarentena, LimaCuarentena, SantiagoCuarentena, BuenosAiresCuarentena, SaoPauloCuarentena, LagosCuarentena,
	KinsasaCuarentena, JartumCuarentena, JohannesburgoCuarentena, ArgelCuarentena, CairoCuarentena, RiadCuarentena, EstambulCuarentena, BagdadCuarentena, MoscuCuarentena, TeheranCuarentena, KarachiCuarentena, BombayCuarentena,
	NuevaDelhiCuarentena, CalcutaCuarentena, MadrasCuarentena, YakartaCuarentena, BangkokCuarentena, HongKongCuarentena, ShanghaiCuarentena, PekinCuarentena, SeulCuarentena, TokioCuarentena, OsakaCuarentena, TaipeiCuarentena,
	HoChiMinhCuarentena, ManilaCuarentena, SidneyCuarentena = false;
	
	int VirusTotalesInt;
	int Niveles = 0;
	
	int[] arrayRandom1 = new int[6];
	int[] arrayRandom2 = new int[12];
	int[] arrayRandom3 = new int[20];
	
	int[] arraysumaRandom1 = new int[3];
	int[] arraysumaRandom2 = new int[4];
	int[] arraysumaRandom3 = new int[5];

	private int Intentos = 4;
	private static double PorcentajeDesarrolloAzul;
	private static double PorcentajeDesarrolloNegro;
	private static double PorcentajeDesarrolloAmarillo;
	private static double PorcentajeDesarrolloRojo;
	
	private static int Puntuacion = 0;
	private static int Ronda = 0;
	private static int Partida_ID;

public PantallaPartida(String rutaImagen, Marco marco) {
	
		Connection con = bbdd.conectarBaseDatos();
		String[] PartidaID_Base = {"MAX(PARTIDA_ID)"};
		
		String[] Partida_Id_BBDD = bbdd.select(con, "SELECT MAX(PARTIDA_ID) FROM PARTIDA", PartidaID_Base);
		
		if(Partida_Id_BBDD[0] == null) {
			Partida_ID = 0;
		}else {
			Partida_ID = Integer.parseInt(Partida_Id_BBDD[0]) + 1;
		}
		
		if(PantallaCargarPartida.CargarPartida == true) {
			
		}else {
			Ronda = 0;
			setPuntuacion(0);
			Niveles = 0;
			
			if (PantallaDificultad.Dificultad == 1) {
				Random rand = new Random();
				HashSet<Integer> numerosGenerados = new HashSet<>();
				for (int i = 0; i < arrayRandom1.length; i++) {
					int numeroAleatorio;
					do {
						numeroAleatorio = rand.nextInt(48);
					} while (numerosGenerados.contains(numeroAleatorio));
					numerosGenerados.add(numeroAleatorio);
					arrayRandom1[i] = numeroAleatorio;
				}
			} else if (PantallaDificultad.Dificultad == 2) {
				Random rand = new Random();
				HashSet<Integer> numerosGenerados = new HashSet<>();
				for (int i = 0; i < arrayRandom2.length; i++) {
					int numeroAleatorio;
					do {
						numeroAleatorio = rand.nextInt(48);
					} while (numerosGenerados.contains(numeroAleatorio));
					numerosGenerados.add(numeroAleatorio);
					arrayRandom2[i] = numeroAleatorio;
				}
			} else if (PantallaDificultad.Dificultad == 3) {
				Random rand = new Random();
				HashSet<Integer> numerosGenerados = new HashSet<>();
				for (int i = 0; i < arrayRandom3.length; i++) {
					int numeroAleatorio;
					do {
						numeroAleatorio = rand.nextInt(48);
					} while (numerosGenerados.contains(numeroAleatorio));
					numerosGenerados.add(numeroAleatorio);
					arrayRandom3[i] = numeroAleatorio;
				}
			}
		}
		
		this.marco = marco;
		setLayout(new GridBagLayout());

		SanFrancisco = crearBoton("src/img/CiudadAzul.png", 32, 32);
		Chicago = crearBoton("src/img/CiudadAzul.png", 32, 32);
		Atlanta = crearBoton("src/img/CiudadAzul.png", 32, 32);
		Montreal = crearBoton("src/img/CiudadAzul.png", 32, 32);
		NuevaYork = crearBoton("src/img/CiudadAzul.png", 32, 32);
		Washington = crearBoton("src/img/CiudadAzul.png", 32, 32);
		Londres = crearBoton("src/img/CiudadAzul.png", 32, 32);
		Madrid = crearBoton("src/img/CiudadAzul.png", 32, 32);
		Paris = crearBoton("src/img/CiudadAzul.png", 32, 32);
		Essen = crearBoton("src/img/CiudadAzul.png", 32, 32);
		Milan = crearBoton("src/img/CiudadAzul.png", 32, 32);
		SanPetersburgo = crearBoton("src/img/CiudadAzul.png", 32, 32);
		LosAngeles = crearBoton("src/img/CiudadAmarillo.png", 32, 32);
		Miami = crearBoton("src/img/CiudadAmarillo.png", 32, 32);
		Mexico = crearBoton("src/img/CiudadAmarillo.png", 32, 32);
		Bogota = crearBoton("src/img/CiudadAmarillo.png", 32, 32);
		Lima = crearBoton("src/img/CiudadAmarillo.png", 32, 32);
		Santiago = crearBoton("src/img/CiudadAmarillo.png", 32, 32);
		BuenosAires = crearBoton("src/img/CiudadAmarillo.png", 32, 32);
		SaoPaulo = crearBoton("src/img/CiudadAmarillo.png", 32, 32);
		Lagos = crearBoton("src/img/CiudadAmarillo.png", 32, 32);
		Kinsasa = crearBoton("src/img/CiudadAmarillo.png", 32, 32);
		Jartum = crearBoton("src/img/CiudadAmarillo.png", 32, 32);
		Johannesburgo = crearBoton("src/img/CiudadAmarillo.png", 32, 32);
		Argel = crearBoton("src/img/CiudadNegro.png", 32, 32);
		Cairo = crearBoton("src/img/CiudadNegro.png", 32, 32);
		Riad = crearBoton("src/img/CiudadNegro.png", 32, 32);
		Estambul = crearBoton("src/img/CiudadNegro.png", 32, 32);
		Bagdad = crearBoton("src/img/CiudadNegro.png", 32, 32);
		Moscu = crearBoton("src/img/CiudadNegro.png", 32, 32);
		Teheran = crearBoton("src/img/CiudadNegro.png", 32, 32);
		Karachi = crearBoton("src/img/CiudadNegro.png", 32, 32);
		Bombay = crearBoton("src/img/CiudadNegro.png", 32, 32);
		NuevaDelhi = crearBoton("src/img/CiudadNegro.png", 32, 32);
		Calcuta = crearBoton("src/img/CiudadNegro.png", 32, 32);
		Madras = crearBoton("src/img/CiudadNegro.png", 32, 32);
		Yakarta = crearBoton("src/img/CiudadRojo.png", 32, 32);
		Bangkok = crearBoton("src/img/CiudadRojo.png", 32, 32);
		HongKong = crearBoton("src/img/CiudadRojo.png", 32, 32);
		Shanghai = crearBoton("src/img/CiudadRojo.png", 32, 32);
		Pekin = crearBoton("src/img/CiudadRojo.png", 32, 32);
		Seul = crearBoton("src/img/CiudadRojo.png", 32, 32);
		Tokio = crearBoton("src/img/CiudadRojo.png", 32, 32);
		Osaka = crearBoton("src/img/CiudadRojo.png", 32, 32);
		Taipei = crearBoton("src/img/CiudadRojo.png", 32, 32);
		HoChiMinh = crearBoton("src/img/CiudadRojo.png", 32, 32);
		Manila = crearBoton("src/img/CiudadRojo.png", 32, 32);
		Sidney = crearBoton("src/img/CiudadRojo.png", 32, 32);

		Opciones = crearBoton("src/img/OpcionesBoton.png", 32, 32);
		GuardarPartida = crearBoton("src/img/GuardarPartida_Boton.png", 256, 32);
		VolverMenu = crearBoton("src/img/Boton-Menu.png", 128, 32);
		PasarTurno = crearBoton("src/img/PasarTurno_Boton.png", 192, 24);

		DesarrollarCura = crearBoton("src/img/DesarrollarCura_Boton.png", 192, 48);
		CurarCiudad = crearBoton("src/img/CurarCiudad_Boton.png", 192, 48);
		Cuarentena = crearBoton("src/img/Cuarentena_Boton.png", 192, 48);

		CuraAzul = crearBoton("src/img/Cura_Boton.png", 64, 64);
		CuraAmarillo = crearBoton("src/img/Cura_Boton.png", 64, 64);
		CuraNegro = crearBoton("src/img/Cura_Boton.png", 64, 64);
		CuraRojo = crearBoton("src/img/Cura_Boton.png", 64, 64);

		GuardarPartida.addActionListener(this);
		VolverMenu.addActionListener(this);
		DesarrollarCura.addActionListener(this);
		CurarCiudad.addActionListener(this);
		Cuarentena.addActionListener(this);
		PasarTurno.addActionListener(this);
		
		if(PantallaCargarPartida.CargarPartida == false) {
			VirusSanFrancisco = CantidadVirus("SanFrancisco");
			VirusChicago = CantidadVirus("Chicago");
			VirusAtlanta = CantidadVirus("Atlanta");
			VirusMontreal = CantidadVirus("Montreal");
			VirusNuevaYork = CantidadVirus("NuevaYork");
			VirusWashington = CantidadVirus("Washington");
			VirusLondres = CantidadVirus("Londres");
			VirusMadrid = CantidadVirus("Madrid");
			VirusParis = CantidadVirus("Paris");
			VirusEssen = CantidadVirus("Essen");
			VirusMilan = CantidadVirus("Milan");
			VirusSanPetersburgo = CantidadVirus("SanPetersburgo");
			VirusLosAngeles = CantidadVirus("LosAngeles");
			VirusMiami = CantidadVirus("Miami");
			VirusMexico = CantidadVirus("Mexico");
			VirusBogota = CantidadVirus("Bogota");
			VirusLima = CantidadVirus("Lima");
			VirusSantiago = CantidadVirus("Santiago");
			VirusBuenosAires = CantidadVirus("BuenosAires");
			VirusSaoPaulo = CantidadVirus("SaoPaulo");
			VirusLagos = CantidadVirus("Lagos");
			VirusKinsasa = CantidadVirus("Kinsasa");
			VirusJartum = CantidadVirus("Jartum");
			VirusJohannesburgo = CantidadVirus("Johannesburgo");
			VirusArgel = CantidadVirus("Argel");
			VirusCairo = CantidadVirus("Cairo");
			VirusRiad = CantidadVirus("Riad");
			VirusEstambul = CantidadVirus("Estambul");
			VirusBagdad = CantidadVirus("Bagdad");
			VirusMoscu = CantidadVirus("Moscu");
			VirusTeheran = CantidadVirus("Teheran");
			VirusKarachi = CantidadVirus("Karachi");
			VirusBombay = CantidadVirus("Bombay");
			VirusNuevaDelhi = CantidadVirus("NuevaDelhi");
			VirusCalcuta = CantidadVirus("Calcuta");
			VirusMadras = CantidadVirus("Madras");
			VirusYakarta = CantidadVirus("Yakarta");
			VirusBangkok = CantidadVirus("Bangkok");
			VirusHongKong = CantidadVirus("HongKong");
			VirusShanghai = CantidadVirus("Shanghai");
			VirusPekin = CantidadVirus("Pekin");
			VirusSeul = CantidadVirus("Seul");
			VirusTokio = CantidadVirus("Tokio");
			VirusOsaka = CantidadVirus("Osaka");
			VirusTaipei = CantidadVirus("Taipei");
			VirusHoChiMinh = CantidadVirus("HoChiMinh");
			VirusManila = CantidadVirus("Manila");
			VirusSidney = CantidadVirus("Sidney");
			
			PorcentajeDesarrolloAzul = 0;
			PorcentajeDesarrolloNegro = 0;
			PorcentajeDesarrolloAmarillo = 0;
			PorcentajeDesarrolloRojo = 0;
		}
		
		GridBagConstraints gbc = new GridBagConstraints();
		imagenDeFondo = new ImageIcon(rutaImagen).getImage();
		
		SanFranciscoLabel = new JLabel();
		gbc.gridx = 0; 
		gbc.gridy = 0;
		gbc.insets = new Insets(380, -1105, 10, 10); 
		SanFranciscoLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_SanFrancisco.png");
		SanFranciscoLabel.setIcon(carta);
		SanFranciscoLabel.setVerticalTextPosition(SwingConstants.CENTER); 
		SanFranciscoLabel.setHorizontalTextPosition(SwingConstants.CENTER); 
		SanFranciscoLabel.setVisible(false);
		SanFranciscoLabel.setPreferredSize(new Dimension(200, 300));
		add(SanFranciscoLabel, gbc);

		ChicagoLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10);
		ChicagoLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Chicago.png");
		ChicagoLabel.setIcon(carta);
		ChicagoLabel.setVerticalTextPosition(SwingConstants.CENTER); 
		ChicagoLabel.setHorizontalTextPosition(SwingConstants.CENTER); 
		ChicagoLabel.setVisible(false); 
		ChicagoLabel.setPreferredSize(new Dimension(200, 300));
		add(ChicagoLabel, gbc);

		AtlantaLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); 
		AtlantaLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Atlanta.png");
		AtlantaLabel.setIcon(carta);
		AtlantaLabel.setVerticalTextPosition(SwingConstants.CENTER); 
		AtlantaLabel.setHorizontalTextPosition(SwingConstants.CENTER); 
		AtlantaLabel.setVisible(false); 
		AtlantaLabel.setPreferredSize(new Dimension(200, 300));
		add(AtlantaLabel, gbc);

		MontrealLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); 
		MontrealLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Montreal.png");
		MontrealLabel.setIcon(carta);
		MontrealLabel.setVerticalTextPosition(SwingConstants.CENTER); 
		MontrealLabel.setHorizontalTextPosition(SwingConstants.CENTER); 
		MontrealLabel.setVisible(false); 
		MontrealLabel.setPreferredSize(new Dimension(200, 300));
		add(MontrealLabel, gbc);

		NuevaYorkLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); 
		NuevaYorkLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_NuevaYork.png");
		NuevaYorkLabel.setIcon(carta);
		NuevaYorkLabel.setVerticalTextPosition(SwingConstants.CENTER); 
		NuevaYorkLabel.setHorizontalTextPosition(SwingConstants.CENTER); 
		NuevaYorkLabel.setVisible(false); 
		NuevaYorkLabel.setPreferredSize(new Dimension(200, 300));
		add(NuevaYorkLabel, gbc);

		WashingtonLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); 
		WashingtonLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Washington.png");
		WashingtonLabel.setIcon(carta);
		WashingtonLabel.setVerticalTextPosition(SwingConstants.CENTER); 
		WashingtonLabel.setHorizontalTextPosition(SwingConstants.CENTER); 
		WashingtonLabel.setVisible(false);
		WashingtonLabel.setPreferredSize(new Dimension(200, 300));
		add(WashingtonLabel, gbc);

		LondresLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); 
		LondresLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Londres.png");
		LondresLabel.setIcon(carta);
		LondresLabel.setVerticalTextPosition(SwingConstants.CENTER); 
		LondresLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		LondresLabel.setVisible(false); 
		LondresLabel.setPreferredSize(new Dimension(200, 300));
		add(LondresLabel, gbc);

		MadridLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); 
		MadridLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Madrid.png");
		MadridLabel.setIcon(carta);
		MadridLabel.setVerticalTextPosition(SwingConstants.CENTER); 
		MadridLabel.setHorizontalTextPosition(SwingConstants.CENTER); 
		MadridLabel.setVisible(false); 
		MadridLabel.setPreferredSize(new Dimension(200, 300));
		add(MadridLabel, gbc);

		ParisLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10);
		ParisLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Paris.png");
		ParisLabel.setIcon(carta);
		ParisLabel.setVerticalTextPosition(SwingConstants.CENTER); 
		ParisLabel.setHorizontalTextPosition(SwingConstants.CENTER); 
		ParisLabel.setVisible(false); 
		ParisLabel.setPreferredSize(new Dimension(200, 300));
		add(ParisLabel, gbc);

		EssenLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); 
		EssenLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Essen.png");
		EssenLabel.setIcon(carta);
		EssenLabel.setVerticalTextPosition(SwingConstants.CENTER); 
		EssenLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		EssenLabel.setVisible(false);
		EssenLabel.setPreferredSize(new Dimension(200, 300));
		add(EssenLabel, gbc);

		MilanLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10);
		MilanLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Milan.png");
		MilanLabel.setIcon(carta);
		MilanLabel.setVerticalTextPosition(SwingConstants.CENTER); 
		MilanLabel.setHorizontalTextPosition(SwingConstants.CENTER); 
		MilanLabel.setVisible(false); 
		MilanLabel.setPreferredSize(new Dimension(200, 300));
		add(MilanLabel, gbc);

		SanPetersburgoLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		SanPetersburgoLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_SanPetersburgo.png");
		SanPetersburgoLabel.setIcon(carta);
		SanPetersburgoLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		SanPetersburgoLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		SanPetersburgoLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		SanPetersburgoLabel.setPreferredSize(new Dimension(200, 300));
		add(SanPetersburgoLabel, gbc);

		LosAngelesLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		LosAngelesLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_LosAngeles.png");
		LosAngelesLabel.setIcon(carta);
		LosAngelesLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		LosAngelesLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		LosAngelesLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		LosAngelesLabel.setPreferredSize(new Dimension(200, 300));
		add(LosAngelesLabel, gbc);

		MiamiLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		MiamiLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Miami.png");
		MiamiLabel.setIcon(carta);
		MiamiLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		MiamiLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		MiamiLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		MiamiLabel.setPreferredSize(new Dimension(200, 300));
		add(MiamiLabel, gbc);

		MexicoLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		MexicoLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Mexico.png");
		MexicoLabel.setIcon(carta);
		MexicoLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		MexicoLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		MexicoLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		MexicoLabel.setPreferredSize(new Dimension(200, 300));
		add(MexicoLabel, gbc);

		BogotaLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		BogotaLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Bogota.png");
		BogotaLabel.setIcon(carta);
		BogotaLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		BogotaLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		BogotaLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		BogotaLabel.setPreferredSize(new Dimension(200, 300));
		add(BogotaLabel, gbc);

		LimaLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		LimaLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Lima.png");
		LimaLabel.setIcon(carta);
		LimaLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		LimaLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		LimaLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		LimaLabel.setPreferredSize(new Dimension(200, 300));
		add(LimaLabel, gbc);

		SantiagoLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		SantiagoLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Santiago.png");
		SantiagoLabel.setIcon(carta);
		SantiagoLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		SantiagoLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		SantiagoLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		SantiagoLabel.setPreferredSize(new Dimension(200, 300));
		add(SantiagoLabel, gbc);

		BuenosAiresLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		BuenosAiresLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_BuenosAires.png");
		BuenosAiresLabel.setIcon(carta);
		BuenosAiresLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		BuenosAiresLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		BuenosAiresLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		BuenosAiresLabel.setPreferredSize(new Dimension(200, 300));
		add(BuenosAiresLabel, gbc);

		SaoPauloLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		SaoPauloLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_SaoPaulo.png");
		SaoPauloLabel.setIcon(carta);
		SaoPauloLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		SaoPauloLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		SaoPauloLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		SaoPauloLabel.setPreferredSize(new Dimension(200, 300));
		add(SaoPauloLabel, gbc);

		LagosLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		LagosLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Lagos.png");
		LagosLabel.setIcon(carta);
		LagosLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		LagosLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		LagosLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		LagosLabel.setPreferredSize(new Dimension(200, 300));
		add(LagosLabel, gbc);

		KinsasaLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		KinsasaLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Kinsasa.png");
		KinsasaLabel.setIcon(carta);
		KinsasaLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		KinsasaLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		KinsasaLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		KinsasaLabel.setPreferredSize(new Dimension(200, 300));
		add(KinsasaLabel, gbc);

		JartumLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		JartumLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Jartum.png");
		JartumLabel.setIcon(carta);
		JartumLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		JartumLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		JartumLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		JartumLabel.setPreferredSize(new Dimension(200, 300));
		add(JartumLabel, gbc);

		JohannesburgoLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		JohannesburgoLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Johannesburgo.png");
		JohannesburgoLabel.setIcon(carta);
		JohannesburgoLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		JohannesburgoLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		JohannesburgoLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		JohannesburgoLabel.setPreferredSize(new Dimension(200, 300));
		add(JohannesburgoLabel, gbc);

		ArgelLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		ArgelLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Argel.png");
		ArgelLabel.setIcon(carta);
		ArgelLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		ArgelLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		ArgelLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		ArgelLabel.setPreferredSize(new Dimension(200, 300));
		add(ArgelLabel, gbc);

		CairoLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		CairoLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Cairo.png");
		CairoLabel.setIcon(carta);
		CairoLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		CairoLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		CairoLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		CairoLabel.setPreferredSize(new Dimension(200, 300));
		add(CairoLabel, gbc);

		RiadLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		RiadLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Riad.png");
		RiadLabel.setIcon(carta);
		RiadLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		RiadLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		RiadLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		RiadLabel.setPreferredSize(new Dimension(200, 300));
		add(RiadLabel, gbc);

		EstambulLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		EstambulLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Estambul.png");
		EstambulLabel.setIcon(carta);
		EstambulLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		EstambulLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		EstambulLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		EstambulLabel.setPreferredSize(new Dimension(200, 300));
		add(EstambulLabel, gbc);

		BagdadLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		BagdadLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Bagdad.png");
		BagdadLabel.setIcon(carta);
		BagdadLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		BagdadLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		BagdadLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		BagdadLabel.setPreferredSize(new Dimension(200, 300));
		add(BagdadLabel, gbc);

		MoscuLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		MoscuLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Moscu.png");
		MoscuLabel.setIcon(carta);
		MoscuLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		MoscuLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		MoscuLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		MoscuLabel.setPreferredSize(new Dimension(200, 300));
		add(MoscuLabel, gbc);

		TeheranLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		TeheranLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Teheran.png");
		TeheranLabel.setIcon(carta);
		TeheranLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		TeheranLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		TeheranLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		TeheranLabel.setPreferredSize(new Dimension(200, 300));
		add(TeheranLabel, gbc);

		KarachiLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		KarachiLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Karachi.png");
		KarachiLabel.setIcon(carta);
		KarachiLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		KarachiLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		KarachiLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		KarachiLabel.setPreferredSize(new Dimension(200, 300));
		add(KarachiLabel, gbc);

		BombayLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		BombayLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Bombay.png");
		BombayLabel.setIcon(carta);
		BombayLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		BombayLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		BombayLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		BombayLabel.setPreferredSize(new Dimension(200, 300));
		add(BombayLabel, gbc);

		NuevaDelhiLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		NuevaDelhiLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_NuevaDelhi.png");
		NuevaDelhiLabel.setIcon(carta);
		NuevaDelhiLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		NuevaDelhiLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		NuevaDelhiLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		NuevaDelhiLabel.setPreferredSize(new Dimension(200, 300));
		add(NuevaDelhiLabel, gbc);

		CalcutaLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		CalcutaLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Calcuta.png");
		CalcutaLabel.setIcon(carta);
		CalcutaLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		CalcutaLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		CalcutaLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		CalcutaLabel.setPreferredSize(new Dimension(200, 300));
		add(CalcutaLabel, gbc);

		MadrasLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		MadrasLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Madras.png");
		MadrasLabel.setIcon(carta);
		MadrasLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		MadrasLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		MadrasLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		MadrasLabel.setPreferredSize(new Dimension(200, 300));
		add(MadrasLabel, gbc);

		YakartaLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		YakartaLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Yakarta.png");
		YakartaLabel.setIcon(carta);
		YakartaLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		YakartaLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		YakartaLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		YakartaLabel.setPreferredSize(new Dimension(200, 300));
		add(YakartaLabel, gbc);

		BangkokLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		BangkokLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Bangkok.png");
		BangkokLabel.setIcon(carta);
		BangkokLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		BangkokLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		BangkokLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		BangkokLabel.setPreferredSize(new Dimension(200, 300));
		add(BangkokLabel, gbc);

		HongKongLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		HongKongLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_HongKong.png");
		HongKongLabel.setIcon(carta);
		HongKongLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		HongKongLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		HongKongLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		HongKongLabel.setPreferredSize(new Dimension(200, 300));
		add(HongKongLabel, gbc);

		ShanghaiLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		ShanghaiLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Shanghai.png");
		ShanghaiLabel.setIcon(carta);
		ShanghaiLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		ShanghaiLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		ShanghaiLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		ShanghaiLabel.setPreferredSize(new Dimension(200, 300));
		add(ShanghaiLabel, gbc);

		PekinLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		PekinLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Pekin.png");
		PekinLabel.setIcon(carta);
		PekinLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		PekinLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		PekinLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		PekinLabel.setPreferredSize(new Dimension(200, 300));
		add(PekinLabel, gbc);

		SeulLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		SeulLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Seul.png");
		SeulLabel.setIcon(carta);
		SeulLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		SeulLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		SeulLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		SeulLabel.setPreferredSize(new Dimension(200, 300));
		add(SeulLabel, gbc);

		TokioLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		TokioLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Tokio.png");
		TokioLabel.setIcon(carta);
		TokioLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		TokioLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		TokioLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		TokioLabel.setPreferredSize(new Dimension(200, 300));
		add(TokioLabel, gbc);

		OsakaLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		OsakaLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Osaka.png");
		OsakaLabel.setIcon(carta);
		OsakaLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		OsakaLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		OsakaLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		OsakaLabel.setPreferredSize(new Dimension(200, 300));
		add(OsakaLabel, gbc);

		TaipeiLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		TaipeiLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Taipei.png");
		TaipeiLabel.setIcon(carta);
		TaipeiLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		TaipeiLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		TaipeiLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		TaipeiLabel.setPreferredSize(new Dimension(200, 300));
		add(TaipeiLabel, gbc);

		HoChiMinhLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		HoChiMinhLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_HoChiMinh.png");
		HoChiMinhLabel.setIcon(carta);
		HoChiMinhLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		HoChiMinhLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		HoChiMinhLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		HoChiMinhLabel.setPreferredSize(new Dimension(200, 300));
		add(HoChiMinhLabel, gbc);

		ManilaLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		ManilaLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Manila.png");
		ManilaLabel.setIcon(carta);
		ManilaLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		ManilaLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		ManilaLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		ManilaLabel.setPreferredSize(new Dimension(200, 300));
		add(ManilaLabel, gbc);

		SidneyLabel = new JLabel();
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		SidneyLabel.setOpaque(true);
		carta = new ImageIcon("src/img/Cartas/Carta_Sidney.png");
		SidneyLabel.setIcon(carta);
		SidneyLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		SidneyLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		SidneyLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		SidneyLabel.setPreferredSize(new Dimension(200, 300));
		add(SidneyLabel, gbc);

		AzulLabel = new JLabel("<html><br><br><br><br><br><div>"+ PorcentajeDesarrolloAzul + " %</div></html>");
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		AzulLabel.setOpaque(true);
		Font font = AzulLabel.getFont();
		AzulLabel.setFont(new Font(font.getName(), Font.BOLD, 26));
		carta = new ImageIcon("src/img/Cartas/CartaAzul.png");
		AzulLabel.setIcon(carta);
		AzulLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		AzulLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		AzulLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		AzulLabel.setPreferredSize(new Dimension(200, 300));
		add(AzulLabel, gbc);

		NegroLabel = new JLabel("<html><br><br><br><br><br><div>"+ PorcentajeDesarrolloNegro + " %</div></html>");
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		NegroLabel.setOpaque(true);
		font = NegroLabel.getFont();
		NegroLabel.setFont(new Font(font.getName(), Font.BOLD, 26));
		carta = new ImageIcon("src/img/Cartas/CartaNegro.png");
		NegroLabel.setIcon(carta);
		NegroLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		NegroLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		NegroLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		NegroLabel.setPreferredSize(new Dimension(200, 300));
		add(NegroLabel, gbc);

		AmarilloLabel = new JLabel("<html><br><br><br><br><br><div>"+ PorcentajeDesarrolloAmarillo + " %</div></html>");
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		AmarilloLabel.setOpaque(true);
		font = AmarilloLabel.getFont();
		AmarilloLabel.setFont(new Font(font.getName(), Font.BOLD, 26));
		carta = new ImageIcon("src/img/Cartas/CartaAmarillo.png");
		AmarilloLabel.setIcon(carta);
		AmarilloLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		AmarilloLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		AmarilloLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		AmarilloLabel.setPreferredSize(new Dimension(200, 300));
		add(AmarilloLabel, gbc);

		RojoLabel = new JLabel("<html><br><br><br><br><br><div>"+ PorcentajeDesarrolloRojo + " %</div></html>");
		gbc.insets = new Insets(380, -1105, 10, 10); // Margen exterior
		RojoLabel.setOpaque(true);
		font = RojoLabel.getFont();
		RojoLabel.setFont(new Font(font.getName(), Font.BOLD, 26));
		carta = new ImageIcon("src/img/Cartas/CartaRojo.png");
		RojoLabel.setIcon(carta);
		RojoLabel.setVerticalTextPosition(SwingConstants.CENTER); // Centrar el texto verticalmente
		RojoLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
		RojoLabel.setVisible(false); // Ocultar la etiqueta inicialmente
		RojoLabel.setPreferredSize(new Dimension(200, 300));
		add(RojoLabel, gbc);

		LabelIntentos = new JLabel("Movimientos = " + Intentos + "");
		LabelIntentos.setFont(new Font("Arial", Font.BOLD, 24));
		gbc.insets = new Insets(-600, -1092, 10, 10); // Margen exterior
		LabelIntentos.setOpaque(false);
		LabelIntentos.setBorder(BorderFactory.createEmptyBorder());
		LabelIntentos.setPreferredSize(new Dimension(200, 50));
		LabelIntentos.setForeground(Color.BLACK);
		add(LabelIntentos, gbc);
		
		VirusTotales = new JLabel("Virus Totales = " + VirusTotalesInt + "");
		VirusTotales.setFont(new Font("Arial", Font.BOLD, 26));
		gbc.insets = new Insets(-600, -550, 10, 10); // Margen exterior
		VirusTotales.setOpaque(false);
		VirusTotales.setBorder(BorderFactory.createEmptyBorder());
		VirusTotales.setPreferredSize(new Dimension(300, 50));
		VirusTotales.setForeground(Color.WHITE);
		add(VirusTotales, gbc);
		
		VirusActual = new JLabel(" ");
		VirusActual.setFont(new Font("Arial", Font.BOLD, 26));
		gbc.insets = new Insets(-600, 200, 10, 10); // Margen exterior
		VirusActual.setOpaque(false);
		VirusActual.setBorder(BorderFactory.createEmptyBorder());
		VirusActual.setPreferredSize(new Dimension(300, 50));
		VirusActual.setForeground(Color.WHITE);
		VirusActual.setVisible(false);
		add(VirusActual, gbc);
		
		Nivel1 = new JLabel();
        gbc.insets = new Insets(600, -780, 10, 10); // Margen exterior
        Nivel1.setOpaque(false);
        carta = new ImageIcon("src/img/Nivel1O.png");
        Nivel1.setIcon(carta);
        Nivel1.setBorder(BorderFactory.createEmptyBorder());
        Nivel1.setPreferredSize(new Dimension(64, 64));
        add(Nivel1, gbc);
        
        Nivel2 = new JLabel();
        gbc.insets = new Insets(500, -680, 10, 10); // Margen exterior
        Nivel2.setOpaque(false);
        carta = new ImageIcon("src/img/Nivel2O.png");
        Nivel2.setIcon(carta);
        Nivel2.setBorder(BorderFactory.createEmptyBorder());
        Nivel2.setPreferredSize(new Dimension(64, 64));
        add(Nivel2, gbc);
        
        Nivel3 = new JLabel();
        gbc.insets = new Insets(400, -780, 10, 10); // Margen exterior
        Nivel3.setOpaque(false);
        carta = new ImageIcon("src/img/Nivel3O.png");
        Nivel3.setIcon(carta);
        Nivel3.setBorder(BorderFactory.createEmptyBorder());
        Nivel3.setPreferredSize(new Dimension(64, 64));
        add(Nivel3, gbc);
        
        Nivel4 = new JLabel();
        gbc.insets = new Insets(300, -680, 10, 10); // Margen exterior
        Nivel4.setOpaque(false);
        carta = new ImageIcon("src/img/Nivel4O.png");
        Nivel4.setIcon(carta);
        Nivel4.setBorder(BorderFactory.createEmptyBorder());
        Nivel4.setPreferredSize(new Dimension(64, 64));
        add(Nivel4, gbc);
        
        Nivel5 = new JLabel();
        gbc.insets = new Insets(200, -780, 10, 10); // Margen exterior
        Nivel5.setOpaque(false);
        carta = new ImageIcon("src/img/Nivel5O.png");
        Nivel5.setIcon(carta);
        Nivel5.setBorder(BorderFactory.createEmptyBorder());
        Nivel5.setPreferredSize(new Dimension(64, 64));
        add(Nivel5, gbc);
        
		LabelNoMasPartida = new JLabel("");
        LabelNoMasPartida.setFont(new Font("Arial", Font.BOLD, 14));
        LabelNoMasPartida.setForeground(Color.WHITE);
        gbc.insets = new Insets(-550, 1000, 0, 0); 
        LabelNoMasPartida.setOpaque(false);
        LabelNoMasPartida.setBorder(BorderFactory.createEmptyBorder());
        LabelNoMasPartida.setPreferredSize(new Dimension(320, 32));
        LabelNoMasPartida.setVisible(true);
        add(LabelNoMasPartida, gbc);

		gbc.insets = new Insets(-280, -710, 10, 10); // Margen exterior
		add(SanFrancisco, gbc);
		SanFrancisco.addActionListener(this);
		SanFranciscoExclamation = createLabel(gbc, -350, -710);
		
		gbc.insets = new Insets(-300, -580, 10, 10); // Margen exterior
		add(Chicago, gbc);
		Chicago.addActionListener(this);
		ChicagoExclamation = createLabel(gbc, -370, -580);

		gbc.insets = new Insets(-210, -515, 10, 10); // Margen exterior
		add(Atlanta, gbc);
		Atlanta.addActionListener(this);
		AtlantaExclamation = createLabel(gbc, -280, -515);

		gbc.insets = new Insets(-330, -455, 10, 10); // Margen exterior
		add(Montreal, gbc);
		Montreal.addActionListener(this);
		MontrealExclamation = createLabel(gbc, -400, -455);

		gbc.insets = new Insets(-300, -340, 10, 10); // Margen exterior
		add(NuevaYork, gbc);
		NuevaYork.addActionListener(this);
		NuevaYorkExclamation = createLabel(gbc, -370, -340);

		gbc.insets = new Insets(-210, -400, 10, 10); // Margen exterior
		add(Washington, gbc);
		Washington.addActionListener(this);
		WashingtonExclamation = createLabel(gbc, -280, -400);

		gbc.insets = new Insets(-400, 70, 10, 10); // Margen exterior
		add(Londres, gbc);
		Londres.addActionListener(this);
		LondresExclamation = createLabel(gbc, -470, 70);

		gbc.insets = new Insets(-250, 90, 10, 10); // Margen exterior
		add(Madrid, gbc);
		Madrid.addActionListener(this);
		MadridExclamation = createLabel(gbc, -320, 90);

		gbc.insets = new Insets(-330, 140, 10, 10); // Margen exterior
		add(Paris, gbc);
		Paris.addActionListener(this);
		ParisExclamation = createLabel(gbc, -400, 140);

		gbc.insets = new Insets(-450, 200, 10, 10); // Margen exterior
		add(Essen, gbc);
		Essen.addActionListener(this);
		EssenExclamation = createLabel(gbc, -520, 200);

		gbc.insets = new Insets(-330, 240, 10, 10); // Margen exterior
		add(Milan, gbc);
		Milan.addActionListener(this);
		MilanExclamation = createLabel(gbc, -400, 240);

		gbc.insets = new Insets(-400, 330, 10, 10); // Margen exterior
		add(SanPetersburgo, gbc);
		SanPetersburgo.addActionListener(this);
		SanPetersburgoExclamation = createLabel(gbc, -470, 330);

		gbc.insets = new Insets(-180, -730, 10, 10); // Margen exterior
		add(LosAngeles, gbc);
		LosAngeles.addActionListener(this);
		LosAngelesExclamation = createLabel(gbc, -250, -730);

		gbc.insets = new Insets(-70, -450, 10, 10); // Margen exterior
		add(Miami, gbc);
		Miami.addActionListener(this);
		MiamiExclamation = createLabel(gbc, -140, -450);

		gbc.insets = new Insets(-90, -650, 10, 10); // Margen exterior
		add(Mexico, gbc);
		Mexico.addActionListener(this);
		MexicoExclamation = createLabel(gbc, -160, -650);

		gbc.insets = new Insets(80, -440, 10, 10); // Margen exterior
		add(Bogota, gbc);
		Bogota.addActionListener(this);
		BogotaExclamation = createLabel(gbc, 10, -440);

		gbc.insets = new Insets(260, -465, 10, 10); // Margen exterior
		add(Lima, gbc);
		Lima.addActionListener(this);
		LimaExclamation = createLabel(gbc, 190, -465);

		gbc.insets = new Insets(420, -410, 10, 10); // Margen exterior
		add(Santiago, gbc);
		Santiago.addActionListener(this);
		SantiagoExclamation = createLabel(gbc, 330, -410);

		gbc.insets = new Insets(310, -240, 10, 10); // Margen exterior
		add(BuenosAires, gbc);
		BuenosAires.addActionListener(this);
		BuenosAiresExclamation = createLabel(gbc, 220, -240);

		gbc.insets = new Insets(455, -325, 10, 10); // Margen exterior
		add(SaoPaulo, gbc);
		SaoPaulo.addActionListener(this);
		SaoPauloExclamation = createLabel(gbc, 365, -325);

		gbc.insets = new Insets(45, 100, 10, 10); // Margen exterior
		add(Lagos, gbc);
		Lagos.addActionListener(this);
		LagosExclamation = createLabel(gbc, -25, 100);

		gbc.insets = new Insets(220, 235, 10, 10); // Margen exterior
		add(Kinsasa, gbc);
		Kinsasa.addActionListener(this);
		KinsasaExclamation = createLabel(gbc, 150, 235);

		gbc.insets = new Insets(70, 330, 10, 10); // Margen exterior
		add(Jartum, gbc);
		Jartum.addActionListener(this);
		JartumExclamation = createLabel(gbc, 0, 330);

		gbc.insets = new Insets(435, 305, 10, 10); // Margen exterior
		add(Johannesburgo, gbc);
		Johannesburgo.addActionListener(this);
		JohannesburgoExclamation = createLabel(gbc, 365, 305);

		gbc.insets = new Insets(-135, 150, 10, 10); // Margen exterior
		add(Argel, gbc);
		Argel.addActionListener(this);
		ArgelExclamation = createLabel(gbc, -205, 150);

		gbc.insets = new Insets(-115, 315, 10, 10); // Margen exterior
		add(Cairo, gbc);
		Cairo.addActionListener(this);
		CairoExclamation = createLabel(gbc, -185, 315);

		gbc.insets = new Insets(-30, 460, 10, 10); // Margen exterior
		add(Riad, gbc);
		Riad.addActionListener(this);
		RiadExclamation = createLabel(gbc, -100, 460);

		gbc.insets = new Insets(-250, 290, 10, 10); // Margen exterior
		add(Estambul, gbc);
		Estambul.addActionListener(this);
		EstambulExclamation = createLabel(gbc, -320, 290);

		gbc.insets = new Insets(-210, 430, 10, 10); // Margen exterior
		add(Bagdad, gbc);
		Bagdad.addActionListener(this);
		BagdadExclamation = createLabel(gbc, -280, 430);

		gbc.insets = new Insets(-320, 410, 10, 10); // Margen exterior
		add(Moscu, gbc);
		Moscu.addActionListener(this);
		MoscuExclamation = createLabel(gbc, -390, 410);

		gbc.insets = new Insets(-260, 550, 10, 10); // Margen exterior
		add(Teheran, gbc);
		Teheran.addActionListener(this);
		TeheranExclamation = createLabel(gbc, -330, 550);

		gbc.insets = new Insets(-120, 570, 10, 10); // Margen exterior
		add(Karachi, gbc);
		Karachi.addActionListener(this);
		KarachiExclamation = createLabel(gbc, -190, 570);

		gbc.insets = new Insets(40, 595, 10, 10); // Margen exterior
		add(Bombay, gbc);
		Bombay.addActionListener(this);
		BombayExclamation = createLabel(gbc, -30, 595);

		gbc.insets = new Insets(-190, 655, 10, 10); // Margen exterior
		add(NuevaDelhi, gbc);
		NuevaDelhi.addActionListener(this);
		NuevaDelhiExclamation = createLabel(gbc, -260, 655);

		gbc.insets = new Insets(-150, 735, 10, 10); // Margen exterior
		add(Calcuta, gbc);
		Calcuta.addActionListener(this);
		CalcutaExclamation = createLabel(gbc, -220, 735);

		gbc.insets = new Insets(100, 710, 10, 10); // Margen exterior
		add(Madras, gbc);
		Madras.addActionListener(this);
		MadrasExclamation = createLabel(gbc, 30, 710);

		gbc.insets = new Insets(200, 820, 10, 10); // Margen exterior
		add(Yakarta, gbc);
		Yakarta.addActionListener(this);
		YakartaExclamation = createLabel(gbc, 130, 820);

		gbc.insets = new Insets(-40, 790, 10, 10); // Margen exterior
		add(Bangkok, gbc);
		Bangkok.addActionListener(this);
		BangkokExclamation = createLabel(gbc, -110, 790);

		gbc.insets = new Insets(-85, 880, 10, 10); // Margen exterior
		add(HongKong, gbc);
		HongKong.addActionListener(this);
		HongKongExclamation = createLabel(gbc, -155, 880);

		gbc.insets = new Insets(-200, 900, 10, 10); // Margen exterior
		add(Shanghai, gbc);
		Shanghai.addActionListener(this);
		ShanghaiExclamation = createLabel(gbc, -270, 900);

		gbc.insets = new Insets(-320, 880, 10, 10); // Margen exterior
		add(Pekin, gbc);
		Pekin.addActionListener(this);
		PekinExclamation = createLabel(gbc, -390, 880);

		gbc.insets = new Insets(-290, 970, 10, 10); // Margen exterior
		add(Seul, gbc);
		Seul.addActionListener(this);
		SeulExclamation = createLabel(gbc, -360, 970);

		gbc.insets = new Insets(-230, 1080, 10, 10); // Margen exterior
		add(Tokio, gbc);
		Tokio.addActionListener(this);
		TokioExclamation = createLabel(gbc, -300, 1080);

		gbc.insets = new Insets(-130, 1075, 10, 10); // Margen exterior
		add(Osaka, gbc);
		Osaka.addActionListener(this);
		OsakaExclamation = createLabel(gbc, -200, 1075);

		gbc.insets = new Insets(-105, 995, 10, 10); // Margen exterior
		add(Taipei, gbc);
		Taipei.addActionListener(this);
		TaipeiExclamation = createLabel(gbc, -175, 995);

		gbc.insets = new Insets(115, 905, 10, 10); // Margen exterior
		add(HoChiMinh, gbc);
		HoChiMinh.addActionListener(this);
		HoChiMinhExclamation = createLabel(gbc, 45, 905);

		gbc.insets = new Insets(140, 1040, 10, 10); // Margen exterior
		add(Manila, gbc);
		Manila.addActionListener(this);
		ManilaExclamation = createLabel(gbc, 70, 1040);

		gbc.insets = new Insets(440, 1125, 10, 10); // Margen exterior
		add(Sidney, gbc);
		Sidney.addActionListener(this);
		SidneyExclamation = createLabel(gbc, 370, 1125);
		
		SanFrancisco.addMouseListener(this);
		Chicago.addMouseListener(this);
		Atlanta.addMouseListener(this);
		Montreal.addMouseListener(this);
		NuevaYork.addMouseListener(this);
		Washington.addMouseListener(this);
		Londres.addMouseListener(this);
		Madrid.addMouseListener(this);
		Paris.addMouseListener(this);
		Essen.addMouseListener(this);
		Milan.addMouseListener(this);
		SanPetersburgo.addMouseListener(this);
		LosAngeles.addMouseListener(this);
		Miami.addMouseListener(this);
		Mexico.addMouseListener(this);
		Bogota.addMouseListener(this);
		Lima.addMouseListener(this);
		Santiago.addMouseListener(this);
		BuenosAires.addMouseListener(this);
		SaoPaulo.addMouseListener(this);
		Lagos.addMouseListener(this);
		Kinsasa.addMouseListener(this);
		Jartum.addMouseListener(this);
		Johannesburgo.addMouseListener(this);
		Argel.addMouseListener(this);
		Cairo.addMouseListener(this);
		Riad.addMouseListener(this);
		Estambul.addMouseListener(this);
		Bagdad.addMouseListener(this);
		Moscu.addMouseListener(this);
		Teheran.addMouseListener(this);
		Karachi.addMouseListener(this);
		Bombay.addMouseListener(this);
		NuevaDelhi.addMouseListener(this);
		Calcuta.addMouseListener(this);
		Madras.addMouseListener(this);
		Yakarta.addMouseListener(this);
		Bangkok.addMouseListener(this);
		HongKong.addMouseListener(this);
		Shanghai.addMouseListener(this);
		Pekin.addMouseListener(this);
		Seul.addMouseListener(this);
		Tokio.addMouseListener(this);
		Osaka.addMouseListener(this);
		Taipei.addMouseListener(this);
		HoChiMinh.addMouseListener(this);
		Manila.addMouseListener(this);
		Sidney.addMouseListener(this);
		CuraAzul.addMouseListener(this);
		CuraAmarillo.addMouseListener(this);
		CuraRojo.addMouseListener(this);
		CuraNegro.addMouseListener(this);
		Opciones.addMouseListener(this);
		PasarTurno.addMouseListener(this);
		DesarrollarCura.addMouseListener(this);
		CurarCiudad.addMouseListener(this);
		Cuarentena.addMouseListener(this);
		GuardarPartida.addMouseListener(this);
		VolverMenu.addMouseListener(this);

		gbc.insets = new Insets(-420, -1105, 10, 10); // Margen exterior
		add(DesarrollarCura, gbc);

		gbc.insets = new Insets(-280, -1105, 10, 10); // Margen exterior
		add(CurarCiudad, gbc);
		
		gbc.insets = new Insets(-140, -1105, 10, 10); // Margen exterior
		add(Cuarentena, gbc);

		gbc.insets = new Insets(0, -1255, 10, 10); // Margen exterior
		add(CuraAzul, gbc);
		CuraAzul.addActionListener(this);

		gbc.insets = new Insets(0, -1155, 10, 10); // Margen exterior
		add(CuraAmarillo, gbc);
		CuraAmarillo.addActionListener(this);

		gbc.insets = new Insets(0, -1055, 10, 10); // Margen exterior
		add(CuraNegro, gbc);
		CuraNegro.addActionListener(this);

		gbc.insets = new Insets(0, -955, 10, 10); // Margen exterior
		add(CuraRojo, gbc);
		CuraRojo.addActionListener(this);

		gbc.insets = new Insets(-600, 1270, 10, 10); // Margen exterior
		add(Opciones, gbc);
		Opciones.addActionListener(this);

		gbc.insets = new Insets(-600, 950, 10, 10); // Margen exterior
		add(GuardarPartida, gbc);
		GuardarPartida.setVisible(false);
		
		gbc.insets = new Insets(-600, 550, 10, 10); // Margen exterior
		add(VolverMenu, gbc);
		VolverMenu.setVisible(false);
		
		gbc.insets = new Insets(-520, -1105, 10, 10); // Margen exterior
		add(PasarTurno, gbc);

if(PantallaCargarPartida.CargarPartida == true) {
			
			int Partida_IDCargada = Integer.parseInt(PantallaCargarPartida.Partida_Id_BBDD[0]);
			
			String[] Moviments_Base = {"PARTIDA_ID", "TOTAL_MOVIMENTS", "TOTAL_VIRUS", "NIVEL_BROTE", "DIFICULTAD", "RONDA", "NOM_JUGADOR"};
			String[] Partida_BBDD = bbdd.select(con, "SELECT PARTIDA_ID, TOTAL_MOVIMENTS, TOTAL_VIRUS, NIVEL_BROTE, DIFICULTAD, RONDA, NOM_JUGADOR FROM PARTIDA WHERE PARTIDA_ID = "+ Partida_IDCargada +"", Moviments_Base);
			
			Partida_ID = Integer.parseInt(Partida_BBDD[0]);
			Intentos = Integer.parseInt(Partida_BBDD[1]);
			VirusTotalesInt = Integer.parseInt(Partida_BBDD[2]);
			Niveles = Integer.parseInt(Partida_BBDD[3]);
			PantallaDificultad.Dificultad = Integer.parseInt(Partida_BBDD[4]);
			Ronda = Integer.parseInt(Partida_BBDD[5]);
			PantallaDificultad.NombreJugador = Partida_BBDD[6];
			
			String[] Ciudades_Base = {"CANTIDAD_VIRUS", "CUARENTENA"};
			
			String[] Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = "+ Partida_IDCargada +" AND NOMBRE_CIUDAD = '"+ "SanFrancisco"+"'", Ciudades_Base);
			VirusSanFrancisco = Integer.parseInt(Ciudades_BBDD[0]);
			SanFranciscoCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);

			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = "+ Partida_IDCargada +" AND NOMBRE_CIUDAD = '"+ "Chicago"+"'", Ciudades_Base);
			VirusChicago = Integer.parseInt(Ciudades_BBDD[0]);
			ChicagoCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = "+ Partida_IDCargada +" AND NOMBRE_CIUDAD = '"+ "Atlanta"+"'", Ciudades_Base);
			VirusAtlanta = Integer.parseInt(Ciudades_BBDD[0]);
			AtlantaCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = "+ Partida_IDCargada +" AND NOMBRE_CIUDAD = '"+ "Montreal"+"'", Ciudades_Base);
			VirusMontreal = Integer.parseInt(Ciudades_BBDD[0]);
			MontrealCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = "+ Partida_IDCargada +" AND NOMBRE_CIUDAD = '"+ "NuevaYork"+"'", Ciudades_Base);
			VirusNuevaYork = Integer.parseInt(Ciudades_BBDD[0]);
			NuevaYorkCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = "+ Partida_IDCargada +" AND NOMBRE_CIUDAD = '"+ "Washington"+"'", Ciudades_Base);
			VirusWashington = Integer.parseInt(Ciudades_BBDD[0]);
			WashingtonCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = "+ Partida_IDCargada +" AND NOMBRE_CIUDAD = '"+ "Londres"+"'", Ciudades_Base);
			VirusLondres = Integer.parseInt(Ciudades_BBDD[0]);
			LondresCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = "+ Partida_IDCargada +" AND NOMBRE_CIUDAD = '"+ "Madrid"+"'", Ciudades_Base);
			VirusMadrid = Integer.parseInt(Ciudades_BBDD[0]);
			MadridCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = "+ Partida_IDCargada +" AND NOMBRE_CIUDAD = '"+ "Paris"+"'", Ciudades_Base);
			VirusParis = Integer.parseInt(Ciudades_BBDD[0]);
			ParisCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Essen'", Ciudades_Base);
			VirusEssen = Integer.parseInt(Ciudades_BBDD[0]);
			EssenCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Milan'", Ciudades_Base);
			VirusMilan = Integer.parseInt(Ciudades_BBDD[0]);
			MilanCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'SanPetersburgo'", Ciudades_Base);
			VirusSanPetersburgo = Integer.parseInt(Ciudades_BBDD[0]);
			SanPetersburgoCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'LosAngeles'", Ciudades_Base);
			VirusLosAngeles = Integer.parseInt(Ciudades_BBDD[0]);
			LosAngelesCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Miami'", Ciudades_Base);
			VirusMiami = Integer.parseInt(Ciudades_BBDD[0]);
			MiamiCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Mexico'", Ciudades_Base);
			VirusMexico = Integer.parseInt(Ciudades_BBDD[0]);
			MexicoCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Bogota'", Ciudades_Base);
			VirusBogota = Integer.parseInt(Ciudades_BBDD[0]);
			BogotaCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Lima'", Ciudades_Base);
			VirusLima = Integer.parseInt(Ciudades_BBDD[0]);
			LimaCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Santiago'", Ciudades_Base);
			VirusSantiago = Integer.parseInt(Ciudades_BBDD[0]);
			SantiagoCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'BuenosAires'", Ciudades_Base);
			VirusBuenosAires = Integer.parseInt(Ciudades_BBDD[0]);
			BuenosAiresCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'SaoPaulo'", Ciudades_Base);
			VirusSaoPaulo = Integer.parseInt(Ciudades_BBDD[0]);
			SaoPauloCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Lagos'", Ciudades_Base);
			VirusLagos = Integer.parseInt(Ciudades_BBDD[0]);
			LagosCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Kinsasa'", Ciudades_Base);
			VirusKinsasa = Integer.parseInt(Ciudades_BBDD[0]);
			KinsasaCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Jartum'", Ciudades_Base);
			VirusJartum = Integer.parseInt(Ciudades_BBDD[0]);
			JartumCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Johannesburgo'", Ciudades_Base);
			VirusJohannesburgo = Integer.parseInt(Ciudades_BBDD[0]);
			JohannesburgoCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Argel'", Ciudades_Base);
			VirusArgel = Integer.parseInt(Ciudades_BBDD[0]);
			ArgelCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Cairo'", Ciudades_Base);
			VirusCairo = Integer.parseInt(Ciudades_BBDD[0]);
			CairoCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Riad'", Ciudades_Base);
			VirusRiad = Integer.parseInt(Ciudades_BBDD[0]);
			RiadCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Estambul'", Ciudades_Base);
			VirusEstambul = Integer.parseInt(Ciudades_BBDD[0]);
			EstambulCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Bagdad'", Ciudades_Base);
			VirusBagdad = Integer.parseInt(Ciudades_BBDD[0]);
			BagdadCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Moscu'", Ciudades_Base);
			VirusMoscu = Integer.parseInt(Ciudades_BBDD[0]);
			MoscuCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Teheran'", Ciudades_Base);
			VirusTeheran = Integer.parseInt(Ciudades_BBDD[0]);
			TeheranCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Karachi'", Ciudades_Base);
			VirusKarachi = Integer.parseInt(Ciudades_BBDD[0]);
			KarachiCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Bombay'", Ciudades_Base);
			VirusBombay = Integer.parseInt(Ciudades_BBDD[0]);
			BombayCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'NuevaDelhi'", Ciudades_Base);
			VirusNuevaDelhi = Integer.parseInt(Ciudades_BBDD[0]);
			NuevaDelhiCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Calcuta'", Ciudades_Base);
			VirusCalcuta = Integer.parseInt(Ciudades_BBDD[0]);
			CalcutaCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Madras'", Ciudades_Base);
			VirusMadras = Integer.parseInt(Ciudades_BBDD[0]);
			MadrasCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Yakarta'", Ciudades_Base);
			VirusYakarta = Integer.parseInt(Ciudades_BBDD[0]);
			YakartaCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Bangkok'", Ciudades_Base);
			VirusBangkok = Integer.parseInt(Ciudades_BBDD[0]);
			BangkokCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'HongKong'", Ciudades_Base);
			VirusHongKong = Integer.parseInt(Ciudades_BBDD[0]);
			HongKongCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Shanghai'", Ciudades_Base);
			VirusShanghai = Integer.parseInt(Ciudades_BBDD[0]);
			ShanghaiCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Pekin'", Ciudades_Base);
			VirusPekin = Integer.parseInt(Ciudades_BBDD[0]);
			PekinCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Seul'", Ciudades_Base);
			VirusSeul = Integer.parseInt(Ciudades_BBDD[0]);
			SeulCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Tokio'", Ciudades_Base);
			VirusTokio = Integer.parseInt(Ciudades_BBDD[0]);
			TokioCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Osaka'", Ciudades_Base);
			VirusOsaka = Integer.parseInt(Ciudades_BBDD[0]);
			OsakaCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Taipei'", Ciudades_Base);
			VirusTaipei = Integer.parseInt(Ciudades_BBDD[0]);
			TaipeiCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'HoChiMinh'", Ciudades_Base);
			VirusHoChiMinh = Integer.parseInt(Ciudades_BBDD[0]);
			HoChiMinhCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Manila'", Ciudades_Base);
			VirusManila = Integer.parseInt(Ciudades_BBDD[0]);
			ManilaCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			
			Ciudades_BBDD = bbdd.select(con, "SELECT CANTIDAD_VIRUS, CUARENTENA FROM CIUDAD WHERE PARTIDA_ID = " + Partida_IDCargada + " AND NOMBRE_CIUDAD = 'Sidney'", Ciudades_Base);
			VirusSidney = Integer.parseInt(Ciudades_BBDD[0]);
			SidneyCuarentena = Boolean.parseBoolean(Ciudades_BBDD[1]);
			String rutaImagenCuarentena = "src/img/CiudadCuarentena.png";
			if (SanFranciscoCuarentena == true) {
			    SanFrancisco.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (ChicagoCuarentena == true) {
			    Chicago.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (AtlantaCuarentena == true) {
			    Atlanta.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (MontrealCuarentena == true) {
			    Montreal.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (NuevaYorkCuarentena == true) {
			    NuevaYork.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (WashingtonCuarentena == true) {
			    Washington.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (LondresCuarentena == true) {
			    Londres.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (MadridCuarentena == true) {
			    Madrid.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (ParisCuarentena == true) {
			    Paris.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (EssenCuarentena == true) {
			    Essen.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (MilanCuarentena == true) {
			    Milan.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (SanPetersburgoCuarentena == true) {
			    SanPetersburgo.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (LosAngelesCuarentena == true) {
			    LosAngeles.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (MiamiCuarentena == true) {
			    Miami.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (MexicoCuarentena == true) {
			    Mexico.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (BogotaCuarentena == true) {
			    Bogota.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (LimaCuarentena == true) {
			    Lima.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (SantiagoCuarentena == true) {
			    Santiago.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (BuenosAiresCuarentena == true) {
			    BuenosAires.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (SaoPauloCuarentena == true) {
			    SaoPaulo.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (LagosCuarentena == true) {
			    Lagos.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (KinsasaCuarentena == true) {
			    Kinsasa.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (JartumCuarentena == true) {
			    Jartum.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (JohannesburgoCuarentena == true) {
			    Johannesburgo.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (ArgelCuarentena == true) {
			    Argel.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (CairoCuarentena == true) {
			    Cairo.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (RiadCuarentena == true) {
			    Riad.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (EstambulCuarentena == true) {
			    Estambul.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (BagdadCuarentena == true) {
			    Bagdad.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (MoscuCuarentena == true) {
			    Moscu.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (TeheranCuarentena == true) {
			    Teheran.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (KarachiCuarentena == true) {
			    Karachi.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (BombayCuarentena == true) {
			    Bombay.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (NuevaDelhiCuarentena == true) {
			    NuevaDelhi.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (CalcutaCuarentena == true) {
			    Calcuta.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (MadrasCuarentena == true) {
			    Madras.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (YakartaCuarentena == true) {
			    Yakarta.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (BangkokCuarentena == true) {
			    Bangkok.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (HongKongCuarentena == true) {
			    HongKong.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (ShanghaiCuarentena == true) {
			    Shanghai.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (PekinCuarentena == true) {
			    Pekin.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (SeulCuarentena == true) {
			    Seul.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (TokioCuarentena == true) {
			    Tokio.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (OsakaCuarentena == true) {
			    Osaka.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (TaipeiCuarentena == true) {
			    Taipei.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (HoChiMinhCuarentena == true) {
			    HoChiMinh.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (ManilaCuarentena == true) {
			    Manila.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			if (SidneyCuarentena == true) {
			    Sidney.setIcon(new ImageIcon(rutaImagenCuarentena));
			}
			
			String[] Desarrollo_Base = {"PORCENTAJE_DESARROLLO"};
			String[] Desarrollo_BBDD = bbdd.select(con, "SELECT PORCENTAJE_DESARROLLO FROM VACUNA WHERE PARTIDA_ID = "+ Partida_IDCargada +" AND COLOR_VIRUS = 'Azul'", Desarrollo_Base);
			PorcentajeDesarrolloAzul = Double.parseDouble(Desarrollo_BBDD[0]);
			
			Desarrollo_BBDD = bbdd.select(con, "SELECT PORCENTAJE_DESARROLLO FROM VACUNA WHERE PARTIDA_ID = "+ Partida_IDCargada +" AND COLOR_VIRUS = 'Amarillo'", Desarrollo_Base);
			PorcentajeDesarrolloAmarillo = Double.parseDouble(Desarrollo_BBDD[0]);
			
			Desarrollo_BBDD = bbdd.select(con, "SELECT PORCENTAJE_DESARROLLO FROM VACUNA WHERE PARTIDA_ID = "+ Partida_IDCargada +" AND COLOR_VIRUS = 'Negro'", Desarrollo_Base);
			PorcentajeDesarrolloNegro = Double.parseDouble(Desarrollo_BBDD[0]);
			
			Desarrollo_BBDD = bbdd.select(con, "SELECT PORCENTAJE_DESARROLLO FROM VACUNA WHERE PARTIDA_ID = "+ Partida_IDCargada +" AND COLOR_VIRUS = 'Rojo'", Desarrollo_Base);
			PorcentajeDesarrolloRojo = Double.parseDouble(Desarrollo_BBDD[0]);
			
			AzulLabel.setText("<html><br><br><br><br><br><div>"
					+ PorcentajeDesarrolloAzul + " %</div></html>");
			AmarilloLabel.setText("<html><br><br><br><br><br><div>"
					+ PorcentajeDesarrolloAmarillo + " %</div></html>");
			NegroLabel.setText("<html><br><br><br><br><br><div>"
					+ PorcentajeDesarrolloNegro + " %</div></html>");
			RojoLabel.setText("<html><br><br><br><br><br><div>"
					+ PorcentajeDesarrolloRojo + " %</div></html>");
			asignarNivel(Niveles);
			pintarMatraz();
			
			PantallaCargarPartida.CargarPartida = false;
		}
		
		LabelIntentos.setText("Movimientos = " + Intentos + "");
		calcularVirusTotales();
		setVisible(true);
	}

	private JLabel createLabel(GridBagConstraints gbc,  int topInset, int leftInset) {
		ImageIcon carta = new ImageIcon("src/img/Exclamacion.png");
		JLabel label = new JLabel();
	    gbc.insets = new Insets(topInset, leftInset, 10, 10);
	    label.setIcon(carta);
	    label.setOpaque(false);
	    label.setBorder(BorderFactory.createEmptyBorder());
	    label.setPreferredSize(new Dimension(32, 32));
	    label.setVisible(false);
	    add(label, gbc);
	    return label;
	}

	private int CantidadVirus(String nombreciudad) {

		String[] Ciudades = { "SanFrancisco", "Chicago", "Atlanta", "Montreal", "NuevaYork", "Washington", "Londres",
				"Madrid", "Paris", "Essen", "Milan", "SanPetersburgo", "LosAngeles", "Miami", "Mexico", "Bogota",
				"Lima", "Santiago", "BuenosAires", "SaoPaulo", "Lagos", "Kinsasa", "Jartum", "Johannesburgo", "Argel",
				"Cairo", "Riad", "Estambul", "Bagdad", "Moscu", "Teheran", "Karachi", "Bombay", "NuevaDelhi", "Calcuta",
				"Madras", "Yakarta", "Bangkok", "HongKong", "Shanghai", "Pekin", "Seul", "Tokio", "Osaka", "Taipei",
				"HoChiMinh", "Manila", "Sidney" };

		// Facil: 1 de 3, 2 de 2, 3 de 1
		// Normal 2 de 3, 4 de 2, 6 de 1
		// Dificil 4 de 3, 6 de 2, 10 de 1

		if (PantallaDificultad.Dificultad == 1) {

			if (nombreciudad == Ciudades[arrayRandom1[0]]) {
				return 3;
			}
			if (nombreciudad == Ciudades[arrayRandom1[1]] || nombreciudad == Ciudades[arrayRandom1[2]]) {
				return 2;
			}
			if (nombreciudad == Ciudades[arrayRandom1[3]] || nombreciudad == Ciudades[arrayRandom1[4]]
					|| nombreciudad == Ciudades[arrayRandom1[5]]) {
				return 1;
			} else {
				return 0;
			}

		} else if (PantallaDificultad.Dificultad == 2) {

			if (nombreciudad == Ciudades[arrayRandom2[0]] || nombreciudad == Ciudades[arrayRandom2[1]]) {
				return 3;
			}
			if (nombreciudad == Ciudades[arrayRandom2[2]] || nombreciudad == Ciudades[arrayRandom2[3]]
					|| nombreciudad == Ciudades[arrayRandom2[4]] || nombreciudad == Ciudades[arrayRandom2[5]]) {
				return 2;
			}
			if (nombreciudad == Ciudades[arrayRandom2[6]] || nombreciudad == Ciudades[arrayRandom2[7]]
					|| nombreciudad == Ciudades[arrayRandom2[8]] || nombreciudad == Ciudades[arrayRandom2[9]]
					|| nombreciudad == Ciudades[arrayRandom2[10]] || nombreciudad == Ciudades[arrayRandom2[11]]) {
				return 1;
			} else {
				return 0;
			}

		} else if (PantallaDificultad.Dificultad == 3) {
			if (nombreciudad == Ciudades[arrayRandom3[0]] || nombreciudad == Ciudades[arrayRandom3[1]]
					|| nombreciudad == Ciudades[arrayRandom3[2]] || nombreciudad == Ciudades[arrayRandom3[3]]) {
				return 3;
			}
			if (nombreciudad == Ciudades[arrayRandom3[4]] || nombreciudad == Ciudades[arrayRandom3[5]]
					|| nombreciudad == Ciudades[arrayRandom3[6]] || nombreciudad == Ciudades[arrayRandom3[7]]
					|| nombreciudad == Ciudades[arrayRandom3[8]] || nombreciudad == Ciudades[arrayRandom3[9]]) {
				return 2;
			}
			if (nombreciudad == Ciudades[arrayRandom3[10]] || nombreciudad == Ciudades[arrayRandom3[11]]
					|| nombreciudad == Ciudades[arrayRandom3[12]] || nombreciudad == Ciudades[arrayRandom3[13]]
					|| nombreciudad == Ciudades[arrayRandom3[14]] || nombreciudad == Ciudades[arrayRandom3[15]]
					|| nombreciudad == Ciudades[arrayRandom3[16]] || nombreciudad == Ciudades[arrayRandom3[17]]
					|| nombreciudad == Ciudades[arrayRandom3[18]] || nombreciudad == Ciudades[arrayRandom3[19]]) {
				return 1;
			} else {
				return 0;
			}
		}
		return 0;
	}
	
	private int SumarVirus(String nombreciudad) {

		String[] Ciudades = { "SanFrancisco", "Chicago", "Atlanta", "Montreal", "NuevaYork", "Washington", "Londres",
				"Madrid", "Paris", "Essen", "Milan", "SanPetersburgo", "LosAngeles", "Miami", "Mexico", "Bogota",
				"Lima", "Santiago", "BuenosAires", "SaoPaulo", "Lagos", "Kinsasa", "Jartum", "Johannesburgo", "Argel",
				"Cairo", "Riad", "Estambul", "Bagdad", "Moscu", "Teheran", "Karachi", "Bombay", "NuevaDelhi", "Calcuta",
				"Madras", "Yakarta", "Bangkok", "HongKong", "Shanghai", "Pekin", "Seul", "Tokio", "Osaka", "Taipei",
				"HoChiMinh", "Manila", "Sidney" };

		// Facil: 3 - Normal 4 - Dificil 5

		if (PantallaDificultad.Dificultad == 1) {

			if (nombreciudad == Ciudades[arraysumaRandom1[0]] || nombreciudad == Ciudades[arraysumaRandom1[1]] || nombreciudad == Ciudades[arraysumaRandom1[2]]) {
				if (nombreciudad.equals("SanFrancisco") || nombreciudad.equals("Chicago") || nombreciudad.equals("Atlanta") || nombreciudad.equals("Montreal") || nombreciudad.equals("NuevaYork") 
						|| nombreciudad.equals("Washington") || nombreciudad.equals("Londres") || nombreciudad.equals("Madrid") || nombreciudad.equals("Paris") || nombreciudad.equals("Essen") || nombreciudad.equals("Milan") 
						|| nombreciudad.equals("SanPetersburgo")) {
					if(PorcentajeDesarrolloAzul >= 100) {
						return 0;
					}else {
						return 1;
					}
				} else if (nombreciudad.equals("LosAngeles") || nombreciudad.equals("Miami") || nombreciudad.equals("Mexico") || nombreciudad.equals("Bogota") || nombreciudad.equals("Lima") || nombreciudad.equals("Santiago") 
						|| nombreciudad.equals("BuenosAires") || nombreciudad.equals("SaoPaulo") || nombreciudad.equals("Lagos") || nombreciudad.equals("Kinsasa") 
						|| nombreciudad.equals("Jartum") || nombreciudad.equals("Johannesburgo")) {
					if(PorcentajeDesarrolloAmarillo >= 100) {
						return 0;
					}else {
						return 1;
					}
				} else if (nombreciudad.equals("Argel") || nombreciudad.equals("Cairo") || nombreciudad.equals("Riad") || nombreciudad.equals("Estambul") || nombreciudad.equals("Bagdad") 
						|| nombreciudad.equals("Moscu") || nombreciudad.equals("Teheran") || nombreciudad.equals("Karachi") || nombreciudad.equals("Bombay") || nombreciudad.equals("NuevaDelhi") 
						|| nombreciudad.equals("Calcuta") || nombreciudad.equals("Madras")) {
					if(PorcentajeDesarrolloNegro >= 100) {
						return 0;
					}else {
						return 1;
					}
				} else if (nombreciudad.equals("Yakarta") || nombreciudad.equals("Bangkok") || nombreciudad.equals("HongKong") 
						|| nombreciudad.equals("Shanghai") || nombreciudad.equals("Pekin") || nombreciudad.equals("Seul") || nombreciudad.equals("Tokio") || nombreciudad.equals("Osaka") || nombreciudad.equals("Taipei") 
						|| nombreciudad.equals("HoChiMinh") || nombreciudad.equals("Manila") || nombreciudad.equals("Sidney")) {
					if(PorcentajeDesarrolloRojo >= 100) {
						return 0;
					}else {
						return 1;
					}
				}else {
					return 1;	
				}
			} else {
				return 0;
			}

		} else if (PantallaDificultad.Dificultad == 2) {

			if (nombreciudad == Ciudades[arraysumaRandom2[0]] || nombreciudad == Ciudades[arraysumaRandom2[1]] || nombreciudad == Ciudades[arraysumaRandom2[2]] || nombreciudad == Ciudades[arraysumaRandom2[3]]) {
				if (nombreciudad.equals("SanFrancisco") || nombreciudad.equals("Chicago") || nombreciudad.equals("Atlanta") || nombreciudad.equals("Montreal") || nombreciudad.equals("NuevaYork") 
						|| nombreciudad.equals("Washington") || nombreciudad.equals("Londres") || nombreciudad.equals("Madrid") || nombreciudad.equals("Paris") || nombreciudad.equals("Essen") || nombreciudad.equals("Milan") 
						|| nombreciudad.equals("SanPetersburgo")) {
					if(PorcentajeDesarrolloAzul >= 100) {
						return 0;
					}else {
						return 1;
					}
				} else if (nombreciudad.equals("LosAngeles") || nombreciudad.equals("Miami") || nombreciudad.equals("Mexico") || nombreciudad.equals("Bogota") || nombreciudad.equals("Lima") || nombreciudad.equals("Santiago") 
						|| nombreciudad.equals("BuenosAires") || nombreciudad.equals("SaoPaulo") || nombreciudad.equals("Lagos") || nombreciudad.equals("Kinsasa") 
						|| nombreciudad.equals("Jartum") || nombreciudad.equals("Johannesburgo")) {
					if(PorcentajeDesarrolloAmarillo >= 100) {
						return 0;
					}else {
						return 1;
					}
				} else if (nombreciudad.equals("Argel") || nombreciudad.equals("Cairo") || nombreciudad.equals("Riad") || nombreciudad.equals("Estambul") || nombreciudad.equals("Bagdad") 
						|| nombreciudad.equals("Moscu") || nombreciudad.equals("Teheran") || nombreciudad.equals("Karachi") || nombreciudad.equals("Bombay") || nombreciudad.equals("NuevaDelhi") 
						|| nombreciudad.equals("Calcuta") || nombreciudad.equals("Madras")) {
					if(PorcentajeDesarrolloNegro >= 100) {
						return 0;
					}else {
						return 1;
					}
				} else if (nombreciudad.equals("Yakarta") || nombreciudad.equals("Bangkok") || nombreciudad.equals("HongKong") 
						|| nombreciudad.equals("Shanghai") || nombreciudad.equals("Pekin") || nombreciudad.equals("Seul") || nombreciudad.equals("Tokio") || nombreciudad.equals("Osaka") || nombreciudad.equals("Taipei") 
						|| nombreciudad.equals("HoChiMinh") || nombreciudad.equals("Manila") || nombreciudad.equals("Sidney")) {
					if(PorcentajeDesarrolloRojo >= 100) {
						return 0;
					}else {
						return 1;
					}
				}else {
					return 1;	
				}
			} else {
				return 0;
			}

		} else if (PantallaDificultad.Dificultad == 3) {
			if (nombreciudad == Ciudades[arraysumaRandom3[0]] || nombreciudad == Ciudades[arraysumaRandom3[1]] || nombreciudad == Ciudades[arraysumaRandom3[2]] || nombreciudad == Ciudades[arraysumaRandom3[3]] || nombreciudad == Ciudades[arraysumaRandom3[4]]) {
				if (nombreciudad.equals("SanFrancisco") || nombreciudad.equals("Chicago") || nombreciudad.equals("Atlanta") || nombreciudad.equals("Montreal") || nombreciudad.equals("NuevaYork") 
						|| nombreciudad.equals("Washington") || nombreciudad.equals("Londres") || nombreciudad.equals("Madrid") || nombreciudad.equals("Paris") || nombreciudad.equals("Essen") || nombreciudad.equals("Milan") 
						|| nombreciudad.equals("SanPetersburgo")) {
					if(PorcentajeDesarrolloAzul >= 100) {
						return 0;
					}else {
						return 1;
					}
				} else if (nombreciudad.equals("LosAngeles") || nombreciudad.equals("Miami") || nombreciudad.equals("Mexico") || nombreciudad.equals("Bogota") || nombreciudad.equals("Lima") || nombreciudad.equals("Santiago") 
						|| nombreciudad.equals("BuenosAires") || nombreciudad.equals("SaoPaulo") || nombreciudad.equals("Lagos") || nombreciudad.equals("Kinsasa") 
						|| nombreciudad.equals("Jartum") || nombreciudad.equals("Johannesburgo")) {
					if(PorcentajeDesarrolloAmarillo >= 100) {
						return 0;
					}else {
						return 1;
					}
				} else if (nombreciudad.equals("Argel") || nombreciudad.equals("Cairo") || nombreciudad.equals("Riad") || nombreciudad.equals("Estambul") || nombreciudad.equals("Bagdad") 
						|| nombreciudad.equals("Moscu") || nombreciudad.equals("Teheran") || nombreciudad.equals("Karachi") || nombreciudad.equals("Bombay") || nombreciudad.equals("NuevaDelhi") 
						|| nombreciudad.equals("Calcuta") || nombreciudad.equals("Madras")) {
					if(PorcentajeDesarrolloNegro >= 100) {
						return 0;
					}else {
						return 1;
					}
				} else if (nombreciudad.equals("Yakarta") || nombreciudad.equals("Bangkok") || nombreciudad.equals("HongKong") 
						|| nombreciudad.equals("Shanghai") || nombreciudad.equals("Pekin") || nombreciudad.equals("Seul") || nombreciudad.equals("Tokio") || nombreciudad.equals("Osaka") || nombreciudad.equals("Taipei") 
						|| nombreciudad.equals("HoChiMinh") || nombreciudad.equals("Manila") || nombreciudad.equals("Sidney")) {
					if(PorcentajeDesarrolloRojo >= 100) {
						return 0;
					}else {
						return 1;
					}
				}else {
					return 1;	
				}
			} else {
				return 0;
			}
		}
		return 0;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imagenDeFondo, 0, 0, getWidth(), getHeight(), this);
	}

	public Dimension getPreferredSize() {
		return new Dimension(800, 600);
	}

	private JButton crearBoton(String rutaImagen, int ancho, int alto) {
		JButton boton = new JButton();
		boton.setPreferredSize(new Dimension(ancho, alto));
		ImageIcon imagenBoton = new ImageIcon(rutaImagen);
		boton.setIcon(
				new ImageIcon(imagenBoton.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH)));
		boton.setBorderPainted(false);
		boton.setContentAreaFilled(false);
		return boton;
	}

	public void obtenerVirusActivo(String virusActivo) {

		if (Intentos >= 4) {
			if (PantallaDificultad.Dificultad == 1) {
				if (AzulLabel.isVisible() && virusActivo.equals("Azul")
						&& PantallaPartida.PorcentajeDesarrolloAzul < 100) {
					PantallaPartida.PorcentajeDesarrolloAzul = PantallaPartida.PorcentajeDesarrolloAzul + 25;
					AzulLabel.setText("<html><br><br><br><br><br><div>"
							+ PorcentajeDesarrolloAzul + " %</div></html>");
					Intentos = Intentos - 4;
					LabelIntentos.setText("Movimientos = " + Intentos + "");
				} else if (NegroLabel.isVisible() && virusActivo.equals("Negro")
						&& PantallaPartida.PorcentajeDesarrolloNegro < 100) {
					PantallaPartida.PorcentajeDesarrolloNegro = PantallaPartida.PorcentajeDesarrolloNegro + 25;
					NegroLabel.setText("<html><br><br><br><br><br><div>"
							+ PorcentajeDesarrolloNegro + " %</div></html>");
					Intentos = Intentos - 4;
					LabelIntentos.setText("Movimientos = " + Intentos + "");
				} else if (AmarilloLabel.isVisible() && virusActivo.equals("Amarillo")
						&& PantallaPartida.PorcentajeDesarrolloAmarillo < 100) {
					PantallaPartida.PorcentajeDesarrolloAmarillo = PantallaPartida.PorcentajeDesarrolloAmarillo + 25;
					AmarilloLabel.setText("<html><br><br><br><br><br><div>"
							+ PantallaPartida.PorcentajeDesarrolloAmarillo + " %</div></html>");
					Intentos = Intentos - 4;
					LabelIntentos.setText("Movimientos = " + Intentos + "");
				} else if (RojoLabel.isVisible() && virusActivo.equals("Rojo")
						&& PantallaPartida.PorcentajeDesarrolloRojo < 100) {
					PantallaPartida.PorcentajeDesarrolloRojo = PantallaPartida.PorcentajeDesarrolloRojo + 25;
					RojoLabel.setText("<html><br><br><br><br><br><div>"
							+ PantallaPartida.PorcentajeDesarrolloRojo + " %</div></html>");
					Intentos = Intentos - 4;
					LabelIntentos.setText("Movimientos = " + Intentos + "");
				}
			} else if (PantallaDificultad.Dificultad == 2) {
				if (AzulLabel.isVisible() && virusActivo.equals("Azul")
						&& PantallaPartida.PorcentajeDesarrolloAzul < 100) {
					PantallaPartida.PorcentajeDesarrolloAzul = PantallaPartida.PorcentajeDesarrolloAzul + 20;
					AzulLabel.setText("<html><br><br><br><br><br><div>"
							+ PorcentajeDesarrolloAzul + " %</div></html>");
					Intentos = Intentos - 4;
					LabelIntentos.setText("Movimientos = " + Intentos + "");
				} else if (NegroLabel.isVisible() && virusActivo.equals("Negro")
						&& PantallaPartida.PorcentajeDesarrolloNegro < 100) {
					PantallaPartida.PorcentajeDesarrolloNegro = PantallaPartida.PorcentajeDesarrolloNegro + 20;
					NegroLabel.setText("<html><br><br><br><br><br><div>"
							+ PorcentajeDesarrolloNegro + " %</div></html>");
					Intentos = Intentos - 4;
					LabelIntentos.setText("Movimientos = " + Intentos + "");
				} else if (AmarilloLabel.isVisible() && virusActivo.equals("Amarillo")
						&& PantallaPartida.PorcentajeDesarrolloAmarillo < 100) {
					PantallaPartida.PorcentajeDesarrolloAmarillo = PantallaPartida.PorcentajeDesarrolloAmarillo + 20;
					AmarilloLabel.setText("<html><br><br><br><br><br><div>"
							+ PantallaPartida.PorcentajeDesarrolloAmarillo + " %</div></html>");
					Intentos = Intentos - 4;
					LabelIntentos.setText("Movimientos = " + Intentos + "");
				} else if (RojoLabel.isVisible() && virusActivo.equals("Rojo")
						&& PantallaPartida.PorcentajeDesarrolloRojo < 100) {
					PantallaPartida.PorcentajeDesarrolloRojo = PantallaPartida.PorcentajeDesarrolloRojo + 20;
					RojoLabel.setText("<html><br><br><br><br><br><div>"
							+ PantallaPartida.PorcentajeDesarrolloRojo + " %</div></html>");
					Intentos = Intentos - 4;
					LabelIntentos.setText("Movimientos = " + Intentos + "");
				}
			} else if (PantallaDificultad.Dificultad == 3) {
				if (AzulLabel.isVisible() && virusActivo.equals("Azul")
						&& PantallaPartida.PorcentajeDesarrolloAzul < 100) {
					PantallaPartida.PorcentajeDesarrolloAzul = PantallaPartida.PorcentajeDesarrolloAzul + 12.5;
					AzulLabel.setText("<html><br><br><br><br><br><div>"
							+ PorcentajeDesarrolloAzul + " %</div></html>");
					Intentos = Intentos - 4;
					LabelIntentos.setText("Movimientos = " + Intentos + "");
				} else if (NegroLabel.isVisible() && virusActivo.equals("Negro")
						&& PantallaPartida.PorcentajeDesarrolloNegro < 100) {
					PantallaPartida.PorcentajeDesarrolloNegro = PantallaPartida.PorcentajeDesarrolloNegro + 12.5;
					NegroLabel.setText("<html><br><br><br><br><br><div>"
							+ PorcentajeDesarrolloNegro + " %</div></html>");
					Intentos = Intentos - 4;
					LabelIntentos.setText("Movimientos = " + Intentos + "");
				} else if (AmarilloLabel.isVisible() && virusActivo.equals("Amarillo")
						&& PantallaPartida.PorcentajeDesarrolloAmarillo < 100) {
					PantallaPartida.PorcentajeDesarrolloAmarillo = PantallaPartida.PorcentajeDesarrolloAmarillo + 12.5;
					AmarilloLabel.setText("<html><br><br><br><br><br><div>"
							+ PantallaPartida.PorcentajeDesarrolloAmarillo + " %</div></html>");
					Intentos = Intentos - 4;
					LabelIntentos.setText("Movimientos = " + Intentos + "");
				} else if (RojoLabel.isVisible() && virusActivo.equals("Rojo")
						&& PantallaPartida.PorcentajeDesarrolloRojo < 100) {
					PantallaPartida.PorcentajeDesarrolloRojo = PantallaPartida.PorcentajeDesarrolloRojo + 12.5;
					RojoLabel.setText("<html><br><br><br><br><br><div>"
							+ PantallaPartida.PorcentajeDesarrolloRojo + " %</div></html>");
					Intentos = Intentos - 4;
					LabelIntentos.setText("Movimientos = " + Intentos + "");
				}
			}
		}

	}

	public void obtenerCiudadActiva(String ciudadActiva) {

		if (SanFranciscoLabel.isVisible() && ciudadActiva.equals("SanFrancisco")
				&& PantallaPartida.VirusSanFrancisco >= 1 && PorcentajeDesarrolloAzul >= 100) {
			PantallaPartida.VirusSanFrancisco = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (ChicagoLabel.isVisible() && ciudadActiva.equals("Chicago") && PantallaPartida.VirusChicago >= 1 && PorcentajeDesarrolloAzul >= 100) {
			PantallaPartida.VirusChicago = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (AtlantaLabel.isVisible() && ciudadActiva.equals("Atlanta") && PantallaPartida.VirusAtlanta >= 1 && PorcentajeDesarrolloAzul >= 100) {
			PantallaPartida.VirusAtlanta = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (MontrealLabel.isVisible() && ciudadActiva.equals("Montreal") && PantallaPartida.VirusMontreal >= 1 && PorcentajeDesarrolloAzul >= 100) {
			PantallaPartida.VirusMontreal = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (NuevaYorkLabel.isVisible() && ciudadActiva.equals("NuevaYork")
				&& PantallaPartida.VirusNuevaYork >= 1 && PorcentajeDesarrolloAzul >= 100) {
			PantallaPartida.VirusNuevaYork = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (WashingtonLabel.isVisible() && ciudadActiva.equals("Washington")
				&& PantallaPartida.VirusWashington >= 1 && PorcentajeDesarrolloAzul >= 100) {
			PantallaPartida.VirusWashington = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (LondresLabel.isVisible() && ciudadActiva.equals("Londres") && PantallaPartida.VirusLondres >= 1 && PorcentajeDesarrolloAzul >= 100) {
			PantallaPartida.VirusLondres = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (MadridLabel.isVisible() && ciudadActiva.equals("Madrid") && PantallaPartida.VirusMadrid >= 1 && PorcentajeDesarrolloAzul >= 100) {
			PantallaPartida.VirusMadrid = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (ParisLabel.isVisible() && ciudadActiva.equals("Paris") && PantallaPartida.VirusParis >= 1 && PorcentajeDesarrolloAzul >= 100) {
			PantallaPartida.VirusParis = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (EssenLabel.isVisible() && ciudadActiva.equals("Essen") && PantallaPartida.VirusEssen >= 1 && PorcentajeDesarrolloAzul >= 100) {
			PantallaPartida.VirusEssen = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (MilanLabel.isVisible() && ciudadActiva.equals("Milan") && PantallaPartida.VirusMilan >= 1 && PorcentajeDesarrolloAzul >= 100) {
			PantallaPartida.VirusMilan = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (SanPetersburgoLabel.isVisible() && ciudadActiva.equals("SanPetersburgo")
				&& PantallaPartida.VirusSanPetersburgo >= 1 && PorcentajeDesarrolloAzul >= 100) {
			PantallaPartida.VirusSanPetersburgo = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (LosAngelesLabel.isVisible() && ciudadActiva.equals("LosAngeles")
				&& PantallaPartida.VirusLosAngeles >= 1 && PorcentajeDesarrolloAmarillo >= 100) {
			PantallaPartida.VirusLosAngeles = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (MiamiLabel.isVisible() && ciudadActiva.equals("Miami") && PantallaPartida.VirusMiami >= 1 && PorcentajeDesarrolloAmarillo >= 100) {
			PantallaPartida.VirusMiami = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (MexicoLabel.isVisible() && ciudadActiva.equals("Mexico") && PantallaPartida.VirusMexico >= 1 && PorcentajeDesarrolloAmarillo >= 100) {
			PantallaPartida.VirusMexico = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (BogotaLabel.isVisible() && ciudadActiva.equals("Bogota") && PantallaPartida.VirusBogota >= 1 && PorcentajeDesarrolloAmarillo >= 100) {
			PantallaPartida.VirusBogota = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (LimaLabel.isVisible() && ciudadActiva.equals("Lima") && PantallaPartida.VirusLima >= 1 && PorcentajeDesarrolloAmarillo >= 100) {
			PantallaPartida.VirusLima = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (SantiagoLabel.isVisible() && ciudadActiva.equals("Santiago") && PantallaPartida.VirusSantiago >= 1 && PorcentajeDesarrolloAmarillo >= 100) {
			PantallaPartida.VirusSantiago = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (BuenosAiresLabel.isVisible() && ciudadActiva.equals("BuenosAires")
				&& PantallaPartida.VirusBuenosAires >= 1 && PorcentajeDesarrolloAmarillo >= 100) {
			PantallaPartida.VirusBuenosAires = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (SaoPauloLabel.isVisible() && ciudadActiva.equals("SaoPaulo") && PantallaPartida.VirusSaoPaulo >= 1 && PorcentajeDesarrolloAmarillo >= 100) {
			PantallaPartida.VirusSaoPaulo = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (LagosLabel.isVisible() && ciudadActiva.equals("Lagos") && PantallaPartida.VirusLagos >= 1 && PorcentajeDesarrolloAmarillo >= 100) {
			PantallaPartida.VirusLagos = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (KinsasaLabel.isVisible() && ciudadActiva.equals("Kinsasa") && PantallaPartida.VirusKinsasa >= 1 && PorcentajeDesarrolloAmarillo >= 100) {
			PantallaPartida.VirusKinsasa = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (JartumLabel.isVisible() && ciudadActiva.equals("Jartum") && PantallaPartida.VirusJartum >= 1 && PorcentajeDesarrolloAmarillo >= 100) {
			PantallaPartida.VirusJartum = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (JohannesburgoLabel.isVisible() && ciudadActiva.equals("Johannesburgo")
				&& PantallaPartida.VirusJohannesburgo >= 1 && PorcentajeDesarrolloAmarillo >= 100) {
			PantallaPartida.VirusJohannesburgo = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		}else if (ArgelLabel.isVisible() && ciudadActiva.equals("Argel") && PantallaPartida.VirusArgel >= 1 && PorcentajeDesarrolloNegro >= 100) {
			PantallaPartida.VirusArgel = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (CairoLabel.isVisible() && ciudadActiva.equals("Cairo") && PantallaPartida.VirusCairo >= 1 && PorcentajeDesarrolloNegro >= 100) {
			PantallaPartida.VirusCairo = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (RiadLabel.isVisible() && ciudadActiva.equals("Riad") && PantallaPartida.VirusRiad >= 1 && PorcentajeDesarrolloNegro >= 100) {
			PantallaPartida.VirusRiad = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (EstambulLabel.isVisible() && ciudadActiva.equals("Estambul") && PantallaPartida.VirusEstambul >= 1 && PorcentajeDesarrolloNegro >= 100) {
			PantallaPartida.VirusEstambul = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (BagdadLabel.isVisible() && ciudadActiva.equals("Bagdad") && PantallaPartida.VirusBagdad >= 1 && PorcentajeDesarrolloNegro >= 100) {
			PantallaPartida.VirusBagdad = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (MoscuLabel.isVisible() && ciudadActiva.equals("Moscu") && PantallaPartida.VirusMoscu >= 1 && PorcentajeDesarrolloNegro >= 100) {
			PantallaPartida.VirusMoscu = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (TeheranLabel.isVisible() && ciudadActiva.equals("Teheran") && PantallaPartida.VirusTeheran >= 1 && PorcentajeDesarrolloNegro >= 100) {
			PantallaPartida.VirusTeheran = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (KarachiLabel.isVisible() && ciudadActiva.equals("Karachi") && PantallaPartida.VirusKarachi >= 1 && PorcentajeDesarrolloNegro >= 100) {
			PantallaPartida.VirusKarachi = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (BombayLabel.isVisible() && ciudadActiva.equals("Bombay") && PantallaPartida.VirusBombay >= 1 && PorcentajeDesarrolloNegro >= 100) {
			PantallaPartida.VirusBombay = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (NuevaDelhiLabel.isVisible() && ciudadActiva.equals("NuevaDelhi")
				&& PantallaPartida.VirusNuevaDelhi >= 1 && PorcentajeDesarrolloNegro >= 100) {
			PantallaPartida.VirusNuevaDelhi = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (CalcutaLabel.isVisible() && ciudadActiva.equals("Calcuta") && PantallaPartida.VirusCalcuta >= 1 && PorcentajeDesarrolloNegro >= 100) {
			PantallaPartida.VirusCalcuta = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (MadrasLabel.isVisible() && ciudadActiva.equals("Madras") && PantallaPartida.VirusMadras >= 1 && PorcentajeDesarrolloNegro >= 100) {
			PantallaPartida.VirusMadras = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		}else if (YakartaLabel.isVisible() && ciudadActiva.equals("Yakarta") && PantallaPartida.VirusYakarta >= 1 && PorcentajeDesarrolloRojo >= 100) {
			PantallaPartida.VirusYakarta = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (BangkokLabel.isVisible() && ciudadActiva.equals("Bangkok") && PantallaPartida.VirusBangkok >= 1 && PorcentajeDesarrolloRojo >= 100) {
			PantallaPartida.VirusBangkok = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (HongKongLabel.isVisible() && ciudadActiva.equals("HongKong") && PantallaPartida.VirusHongKong >= 1 && PorcentajeDesarrolloRojo >= 100) {
			PantallaPartida.VirusHongKong = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (ShanghaiLabel.isVisible() && ciudadActiva.equals("Shanghai") && PantallaPartida.VirusShanghai >= 1 && PorcentajeDesarrolloRojo >= 100) {
			PantallaPartida.VirusShanghai = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (PekinLabel.isVisible() && ciudadActiva.equals("Pekin") && PantallaPartida.VirusPekin >= 1 && PorcentajeDesarrolloRojo >= 100) {
			PantallaPartida.VirusPekin = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (SeulLabel.isVisible() && ciudadActiva.equals("Seul") && PantallaPartida.VirusSeul >= 1 && PorcentajeDesarrolloRojo >= 100) {
			PantallaPartida.VirusSeul = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (TokioLabel.isVisible() && ciudadActiva.equals("Tokio") && PantallaPartida.VirusTokio >= 1 && PorcentajeDesarrolloRojo >= 100) {
			PantallaPartida.VirusTokio = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (OsakaLabel.isVisible() && ciudadActiva.equals("Osaka") && PantallaPartida.VirusOsaka >= 1 && PorcentajeDesarrolloRojo >= 100) {
			PantallaPartida.VirusOsaka = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (TaipeiLabel.isVisible() && ciudadActiva.equals("Taipei") && PantallaPartida.VirusTaipei >= 1 && PorcentajeDesarrolloRojo >= 100) {
			PantallaPartida.VirusTaipei = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (HoChiMinhLabel.isVisible() && ciudadActiva.equals("HoChiMinh")
				&& PantallaPartida.VirusHoChiMinh >= 1 && PorcentajeDesarrolloRojo >= 100) {
			PantallaPartida.VirusHoChiMinh = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (ManilaLabel.isVisible() && ciudadActiva.equals("Manila") && PantallaPartida.VirusManila >= 1 && PorcentajeDesarrolloRojo >= 100) {
			PantallaPartida.VirusManila = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (SidneyLabel.isVisible() && ciudadActiva.equals("Sidney") && PantallaPartida.VirusSidney >= 1 && PorcentajeDesarrolloRojo >= 100) {
			PantallaPartida.VirusSidney = 0;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		}
		
		else if (SanFranciscoLabel.isVisible() && ciudadActiva.equals("SanFrancisco")
				&& PantallaPartida.VirusSanFrancisco >= 1) {
			PantallaPartida.VirusSanFrancisco--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (ChicagoLabel.isVisible() && ciudadActiva.equals("Chicago") && PantallaPartida.VirusChicago >= 1) {
			PantallaPartida.VirusChicago--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (AtlantaLabel.isVisible() && ciudadActiva.equals("Atlanta") && PantallaPartida.VirusAtlanta >= 1) {
			PantallaPartida.VirusAtlanta--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (MontrealLabel.isVisible() && ciudadActiva.equals("Montreal") && PantallaPartida.VirusMontreal >= 1) {
			PantallaPartida.VirusMontreal--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (NuevaYorkLabel.isVisible() && ciudadActiva.equals("NuevaYork")
				&& PantallaPartida.VirusNuevaYork >= 1) {
			PantallaPartida.VirusNuevaYork--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (WashingtonLabel.isVisible() && ciudadActiva.equals("Washington")
				&& PantallaPartida.VirusWashington >= 1) {
			PantallaPartida.VirusWashington--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (LondresLabel.isVisible() && ciudadActiva.equals("Londres") && PantallaPartida.VirusLondres >= 1) {
			PantallaPartida.VirusLondres--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (MadridLabel.isVisible() && ciudadActiva.equals("Madrid") && PantallaPartida.VirusMadrid >= 1) {
			PantallaPartida.VirusMadrid--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (ParisLabel.isVisible() && ciudadActiva.equals("Paris") && PantallaPartida.VirusParis >= 1) {
			PantallaPartida.VirusParis--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (EssenLabel.isVisible() && ciudadActiva.equals("Essen") && PantallaPartida.VirusEssen >= 1) {
			PantallaPartida.VirusEssen--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (MilanLabel.isVisible() && ciudadActiva.equals("Milan") && PantallaPartida.VirusMilan >= 1) {
			PantallaPartida.VirusMilan--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (SanPetersburgoLabel.isVisible() && ciudadActiva.equals("SanPetersburgo")
				&& PantallaPartida.VirusSanPetersburgo >= 1) {
			PantallaPartida.VirusSanPetersburgo--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (LosAngelesLabel.isVisible() && ciudadActiva.equals("LosAngeles")
				&& PantallaPartida.VirusLosAngeles >= 1) {
			PantallaPartida.VirusLosAngeles--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (MiamiLabel.isVisible() && ciudadActiva.equals("Miami") && PantallaPartida.VirusMiami >= 1) {
			PantallaPartida.VirusMiami--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (MexicoLabel.isVisible() && ciudadActiva.equals("Mexico") && PantallaPartida.VirusMexico >= 1) {
			PantallaPartida.VirusMexico--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (BogotaLabel.isVisible() && ciudadActiva.equals("Bogota") && PantallaPartida.VirusBogota >= 1) {
			PantallaPartida.VirusBogota--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (LimaLabel.isVisible() && ciudadActiva.equals("Lima") && PantallaPartida.VirusLima >= 1) {
			PantallaPartida.VirusLima--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (SantiagoLabel.isVisible() && ciudadActiva.equals("Santiago") && PantallaPartida.VirusSantiago >= 1) {
			PantallaPartida.VirusSantiago--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (BuenosAiresLabel.isVisible() && ciudadActiva.equals("BuenosAires")
				&& PantallaPartida.VirusBuenosAires >= 1) {
			PantallaPartida.VirusBuenosAires--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (SaoPauloLabel.isVisible() && ciudadActiva.equals("SaoPaulo") && PantallaPartida.VirusSaoPaulo >= 1) {
			PantallaPartida.VirusSaoPaulo--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (LagosLabel.isVisible() && ciudadActiva.equals("Lagos") && PantallaPartida.VirusLagos >= 1) {
			PantallaPartida.VirusLagos--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (KinsasaLabel.isVisible() && ciudadActiva.equals("Kinsasa") && PantallaPartida.VirusKinsasa >= 1) {
			PantallaPartida.VirusKinsasa--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (JartumLabel.isVisible() && ciudadActiva.equals("Jartum") && PantallaPartida.VirusJartum >= 1) {
			PantallaPartida.VirusJartum--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (JohannesburgoLabel.isVisible() && ciudadActiva.equals("Johannesburgo")
				&& PantallaPartida.VirusJohannesburgo >= 1) {
			PantallaPartida.VirusJohannesburgo--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (ArgelLabel.isVisible() && ciudadActiva.equals("Argel") && PantallaPartida.VirusArgel >= 1) {
			PantallaPartida.VirusArgel--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (CairoLabel.isVisible() && ciudadActiva.equals("Cairo") && PantallaPartida.VirusCairo >= 1) {
			PantallaPartida.VirusCairo--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (RiadLabel.isVisible() && ciudadActiva.equals("Riad") && PantallaPartida.VirusRiad >= 1) {
			PantallaPartida.VirusRiad--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (EstambulLabel.isVisible() && ciudadActiva.equals("Estambul") && PantallaPartida.VirusEstambul >= 1) {
			PantallaPartida.VirusEstambul--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (BagdadLabel.isVisible() && ciudadActiva.equals("Bagdad") && PantallaPartida.VirusBagdad >= 1) {
			PantallaPartida.VirusBagdad--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (MoscuLabel.isVisible() && ciudadActiva.equals("Moscu") && PantallaPartida.VirusMoscu >= 1) {
			PantallaPartida.VirusMoscu--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (TeheranLabel.isVisible() && ciudadActiva.equals("Teheran") && PantallaPartida.VirusTeheran >= 1) {
			PantallaPartida.VirusTeheran--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (KarachiLabel.isVisible() && ciudadActiva.equals("Karachi") && PantallaPartida.VirusKarachi >= 1) {
			PantallaPartida.VirusKarachi--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (BombayLabel.isVisible() && ciudadActiva.equals("Bombay") && PantallaPartida.VirusBombay >= 1) {
			PantallaPartida.VirusBombay--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (NuevaDelhiLabel.isVisible() && ciudadActiva.equals("NuevaDelhi")
				&& PantallaPartida.VirusNuevaDelhi >= 1) {
			PantallaPartida.VirusNuevaDelhi--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (CalcutaLabel.isVisible() && ciudadActiva.equals("Calcuta") && PantallaPartida.VirusCalcuta >= 1) {
			PantallaPartida.VirusCalcuta--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (MadrasLabel.isVisible() && ciudadActiva.equals("Madras") && PantallaPartida.VirusMadras >= 1) {
			PantallaPartida.VirusMadras--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (YakartaLabel.isVisible() && ciudadActiva.equals("Yakarta") && PantallaPartida.VirusYakarta >= 1) {
			PantallaPartida.VirusYakarta--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (BangkokLabel.isVisible() && ciudadActiva.equals("Bangkok") && PantallaPartida.VirusBangkok >= 1) {
			PantallaPartida.VirusBangkok--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (HongKongLabel.isVisible() && ciudadActiva.equals("HongKong") && PantallaPartida.VirusHongKong >= 1) {
			PantallaPartida.VirusHongKong--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (ShanghaiLabel.isVisible() && ciudadActiva.equals("Shanghai") && PantallaPartida.VirusShanghai >= 1) {
			PantallaPartida.VirusShanghai--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (PekinLabel.isVisible() && ciudadActiva.equals("Pekin") && PantallaPartida.VirusPekin >= 1) {
			PantallaPartida.VirusPekin--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (SeulLabel.isVisible() && ciudadActiva.equals("Seul") && PantallaPartida.VirusSeul >= 1) {
			PantallaPartida.VirusSeul--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (TokioLabel.isVisible() && ciudadActiva.equals("Tokio") && PantallaPartida.VirusTokio >= 1) {
			PantallaPartida.VirusTokio--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (OsakaLabel.isVisible() && ciudadActiva.equals("Osaka") && PantallaPartida.VirusOsaka >= 1) {
			PantallaPartida.VirusOsaka--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (TaipeiLabel.isVisible() && ciudadActiva.equals("Taipei") && PantallaPartida.VirusTaipei >= 1) {
			PantallaPartida.VirusTaipei--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (HoChiMinhLabel.isVisible() && ciudadActiva.equals("HoChiMinh")
				&& PantallaPartida.VirusHoChiMinh >= 1) {
			PantallaPartida.VirusHoChiMinh--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (ManilaLabel.isVisible() && ciudadActiva.equals("Manila") && PantallaPartida.VirusManila >= 1) {
			PantallaPartida.VirusManila--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		} else if (SidneyLabel.isVisible() && ciudadActiva.equals("Sidney") && PantallaPartida.VirusSidney >= 1) {
			PantallaPartida.VirusSidney--;
			Intentos--;
			LabelIntentos.setText("Movimientos = " + Intentos + "");
		}
		calcularVirusTotales();
	}
	
	public void ponerEnCuarentena(String ciudadActiva) {
		String rutaImagenBoton = "src/img/CiudadCuarentena.png";
		if (SanFranciscoLabel.isVisible() && ciudadActiva.equals("SanFrancisco")) {
		    SanFranciscoCuarentena = true;
		    SanFrancisco.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (ChicagoLabel.isVisible() && ciudadActiva.equals("Chicago")) {
		    ChicagoCuarentena = true;
		    Chicago.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (AtlantaLabel.isVisible() && ciudadActiva.equals("Atlanta")) {
		    AtlantaCuarentena = true;
		    Atlanta.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (MontrealLabel.isVisible() && ciudadActiva.equals("Montreal")) {
		    MontrealCuarentena = true;
		    Montreal.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (NuevaYorkLabel.isVisible() && ciudadActiva.equals("NuevaYork")) {
		    NuevaYorkCuarentena = true;
		    NuevaYork.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (WashingtonLabel.isVisible() && ciudadActiva.equals("Washington")) {
		    WashingtonCuarentena = true;
		    Washington.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (LondresLabel.isVisible() && ciudadActiva.equals("Londres")) {
		    LondresCuarentena = true;
		    Londres.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (MadridLabel.isVisible() && ciudadActiva.equals("Madrid")) {
		    MadridCuarentena = true;
		    Madrid.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (ParisLabel.isVisible() && ciudadActiva.equals("Paris")) {
		    ParisCuarentena = true;
		    Paris.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (EssenLabel.isVisible() && ciudadActiva.equals("Essen")) {
		    EssenCuarentena = true;
		    Essen.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (MilanLabel.isVisible() && ciudadActiva.equals("Milan")) {
		    MilanCuarentena = true;
		    Milan.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (SanPetersburgoLabel.isVisible() && ciudadActiva.equals("SanPetersburgo")) {
		    SanPetersburgoCuarentena = true;
		    SanPetersburgo.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (LosAngelesLabel.isVisible() && ciudadActiva.equals("LosAngeles")) {
		    LosAngelesCuarentena = true;
		    LosAngeles.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (MiamiLabel.isVisible() && ciudadActiva.equals("Miami")) {
		    MiamiCuarentena = true;
		    Miami.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (MexicoLabel.isVisible() && ciudadActiva.equals("Mexico")) {
		    MexicoCuarentena = true;
		    Mexico.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (BogotaLabel.isVisible() && ciudadActiva.equals("Bogota")) {
		    BogotaCuarentena = true;
		    Bogota.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (LimaLabel.isVisible() && ciudadActiva.equals("Lima")) {
		    LimaCuarentena = true;
		    Lima.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (SantiagoLabel.isVisible() && ciudadActiva.equals("Santiago")) {
		    SantiagoCuarentena = true;
		    Santiago.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (BuenosAiresLabel.isVisible() && ciudadActiva.equals("BuenosAires")) {
		    BuenosAiresCuarentena = true;
		    BuenosAires.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (SaoPauloLabel.isVisible() && ciudadActiva.equals("SaoPaulo")) {
		    SaoPauloCuarentena = true;
		    SaoPaulo.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (LagosLabel.isVisible() && ciudadActiva.equals("Lagos")) {
		    LagosCuarentena = true;
		    Lagos.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (KinsasaLabel.isVisible() && ciudadActiva.equals("Kinsasa")) {
		    KinsasaCuarentena = true;
		    Kinsasa.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (JartumLabel.isVisible() && ciudadActiva.equals("Jartum")) {
		    JartumCuarentena = true;
		    Jartum.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (JohannesburgoLabel.isVisible() && ciudadActiva.equals("Johannesburgo")) {
		    JohannesburgoCuarentena = true;
		    Johannesburgo.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (ArgelLabel.isVisible() && ciudadActiva.equals("Argel")) {
		    ArgelCuarentena = true;
		    Argel.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (CairoLabel.isVisible() && ciudadActiva.equals("Cairo")) {
		    CairoCuarentena = true;
		    Cairo.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (RiadLabel.isVisible() && ciudadActiva.equals("Riad")) {
		    RiadCuarentena = true;
		    Riad.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (EstambulLabel.isVisible() && ciudadActiva.equals("Estambul")) {
		    EstambulCuarentena = true;
		    Estambul.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (BagdadLabel.isVisible() && ciudadActiva.equals("Bagdad")) {
		    BagdadCuarentena = true;
		    Bagdad.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (MoscuLabel.isVisible() && ciudadActiva.equals("Moscu")) {
		    MoscuCuarentena = true;
		    Moscu.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (TeheranLabel.isVisible() && ciudadActiva.equals("Teheran")) {
		    TeheranCuarentena = true;
		    Teheran.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (KarachiLabel.isVisible() && ciudadActiva.equals("Karachi")) {
		    KarachiCuarentena = true;
		    Karachi.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (BombayLabel.isVisible() && ciudadActiva.equals("Bombay")) {
		    BombayCuarentena = true;
		    Bombay.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (NuevaDelhiLabel.isVisible() && ciudadActiva.equals("NuevaDelhi")) {
		    NuevaDelhiCuarentena = true;
		    NuevaDelhi.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (CalcutaLabel.isVisible() && ciudadActiva.equals("Calcuta")) {
		    CalcutaCuarentena = true;
		    Calcuta.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (MadrasLabel.isVisible() && ciudadActiva.equals("Madras")) {
		    MadrasCuarentena = true;
		    Madras.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (YakartaLabel.isVisible() && ciudadActiva.equals("Yakarta")) {
		    YakartaCuarentena = true;
		    Yakarta.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (BangkokLabel.isVisible() && ciudadActiva.equals("Bangkok")) {
		    BangkokCuarentena = true;
		    Bangkok.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (HongKongLabel.isVisible() && ciudadActiva.equals("HongKong")) {
		    HongKongCuarentena = true;
		    HongKong.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (ShanghaiLabel.isVisible() && ciudadActiva.equals("Shanghai")) {
		    ShanghaiCuarentena = true;
		    Shanghai.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (PekinLabel.isVisible() && ciudadActiva.equals("Pekin")) {
		    PekinCuarentena = true;
		    Pekin.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (SeulLabel.isVisible() && ciudadActiva.equals("Seul")) {
		    SeulCuarentena = true;
		    Seul.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (TokioLabel.isVisible() && ciudadActiva.equals("Tokio")) {
		    TokioCuarentena = true;
		    Tokio.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (OsakaLabel.isVisible() && ciudadActiva.equals("Osaka")) {
		    OsakaCuarentena = true;
		    Osaka.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (TaipeiLabel.isVisible() && ciudadActiva.equals("Taipei")) {
		    TaipeiCuarentena = true;
		    Taipei.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (HoChiMinhLabel.isVisible() && ciudadActiva.equals("HoChiMinh")) {
		    HoChiMinhCuarentena = true;
		    HoChiMinh.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (ManilaLabel.isVisible() && ciudadActiva.equals("Manila")) {
		    ManilaCuarentena = true;
		    Manila.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (SidneyLabel.isVisible() && ciudadActiva.equals("Sidney")) {
		    SidneyCuarentena = true;
		    Sidney.setIcon(new ImageIcon(rutaImagenBoton));
		}
	}

	public void mostrarEtiqueta(JLabel etiqueta) {
		String rutaImagenBoton;
		String rutaImagenCuarentena = "src/img/CiudadCuarentena.png";
		rutaImagenBoton = "src/img/CiudadAzul.png";
		
		if(SanFranciscoCuarentena == false) {
			SanFranciscoLabel.setVisible(false);
			SanFrancisco.setIcon(new ImageIcon(rutaImagenBoton));
		}else if (SanFranciscoCuarentena == true) {
			SanFranciscoLabel.setVisible(false);
			SanFrancisco.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if(ChicagoCuarentena == false) {
			ChicagoLabel.setVisible(false);
			Chicago.setIcon(new ImageIcon(rutaImagenBoton));
		}else if(ChicagoCuarentena == true) {
			ChicagoLabel.setVisible(false);
			Chicago.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (AtlantaCuarentena == false) {
		    AtlantaLabel.setVisible(false);
		    Atlanta.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (AtlantaCuarentena == true) {
		    AtlantaLabel.setVisible(false);
		    Atlanta.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (MontrealCuarentena == false) {
		    MontrealLabel.setVisible(false);
		    Montreal.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (MontrealCuarentena == true) {
		    MontrealLabel.setVisible(false);
		    Montreal.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (NuevaYorkCuarentena == false) {
		    NuevaYorkLabel.setVisible(false);
		    NuevaYork.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (NuevaYorkCuarentena == true) {
		    NuevaYorkLabel.setVisible(false);
		    NuevaYork.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (WashingtonCuarentena == false) {
		    WashingtonLabel.setVisible(false);
		    Washington.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (WashingtonCuarentena == true) {
		    WashingtonLabel.setVisible(false);
		    Washington.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (LondresCuarentena == false) {
		    LondresLabel.setVisible(false);
		    Londres.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (LondresCuarentena == true) {
		    LondresLabel.setVisible(false);
		    Londres.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (MadridCuarentena == false) {
		    MadridLabel.setVisible(false);
		    Madrid.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (MadridCuarentena == true) {
		    MadridLabel.setVisible(false);
		    Madrid.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (ParisCuarentena == false) {
		    ParisLabel.setVisible(false);
		    Paris.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (ParisCuarentena == true) {
		    ParisLabel.setVisible(false);
		    Paris.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (EssenCuarentena == false) {
		    EssenLabel.setVisible(false);
		    Essen.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (EssenCuarentena == true) {
		    EssenLabel.setVisible(false);
		    Essen.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (MilanCuarentena == false) {
		    MilanLabel.setVisible(false);
		    Milan.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (MilanCuarentena == true) {
		    MilanLabel.setVisible(false);
		    Milan.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (SanPetersburgoCuarentena == false) {
		    SanPetersburgoLabel.setVisible(false);
		    SanPetersburgo.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (SanPetersburgoCuarentena == true) {
		    SanPetersburgoLabel.setVisible(false);
		    SanPetersburgo.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		rutaImagenBoton = "src/img/CiudadAmarillo.png";
		if (LosAngelesCuarentena == false) {
		    LosAngelesLabel.setVisible(false);
		    LosAngeles.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (LosAngelesCuarentena == true) {
		    LosAngelesLabel.setVisible(false);
		    LosAngeles.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (MiamiCuarentena == false) {
		    MiamiLabel.setVisible(false);
		    Miami.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (MiamiCuarentena == true) {
		    MiamiLabel.setVisible(false);
		    Miami.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (MexicoCuarentena == false) {
		    MexicoLabel.setVisible(false);
		    Mexico.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (MexicoCuarentena == true) {
		    MexicoLabel.setVisible(false);
		    Mexico.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (BogotaCuarentena == false) {
		    BogotaLabel.setVisible(false);
		    Bogota.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (BogotaCuarentena == true) {
		    BogotaLabel.setVisible(false);
		    Bogota.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (LimaCuarentena == false) {
		    LimaLabel.setVisible(false);
		    Lima.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (LimaCuarentena == true) {
		    LimaLabel.setVisible(false);
		    Lima.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (SantiagoCuarentena == false) {
		    SantiagoLabel.setVisible(false);
		    Santiago.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (SantiagoCuarentena == true) {
		    SantiagoLabel.setVisible(false);
		    Santiago.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (BuenosAiresCuarentena == false) {
		    BuenosAiresLabel.setVisible(false);
		    BuenosAires.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (BuenosAiresCuarentena == true) {
		    BuenosAiresLabel.setVisible(false);
		    BuenosAires.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (SaoPauloCuarentena == false) {
		    SaoPauloLabel.setVisible(false);
		    SaoPaulo.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (SaoPauloCuarentena == true) {
		    SaoPauloLabel.setVisible(false);
		    SaoPaulo.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (LagosCuarentena == false) {
		    LagosLabel.setVisible(false);
		    Lagos.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (LagosCuarentena == true) {
		    LagosLabel.setVisible(false);
		    Lagos.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (KinsasaCuarentena == false) {
		    KinsasaLabel.setVisible(false);
		    Kinsasa.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (KinsasaCuarentena == true) {
		    KinsasaLabel.setVisible(false);
		    Kinsasa.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (JartumCuarentena == false) {
		    JartumLabel.setVisible(false);
		    Jartum.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (JartumCuarentena == true) {
		    JartumLabel.setVisible(false);
		    Jartum.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (JohannesburgoCuarentena == false) {
		    JohannesburgoLabel.setVisible(false);
		    Johannesburgo.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (JohannesburgoCuarentena == true) {
		    JohannesburgoLabel.setVisible(false);
		    Johannesburgo.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		rutaImagenBoton = "src/img/CiudadNegro.png";
		if (ArgelCuarentena == false) {
		    ArgelLabel.setVisible(false);
		    Argel.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (ArgelCuarentena == true) {
		    ArgelLabel.setVisible(false);
		    Argel.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (CairoCuarentena == false) {
		    CairoLabel.setVisible(false);
		    Cairo.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (CairoCuarentena == true) {
		    CairoLabel.setVisible(false);
		    Cairo.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (RiadCuarentena == false) {
		    RiadLabel.setVisible(false);
		    Riad.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (RiadCuarentena == true) {
		    RiadLabel.setVisible(false);
		    Riad.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (EstambulCuarentena == false) {
		    EstambulLabel.setVisible(false);
		    Estambul.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (EstambulCuarentena == true) {
		    EstambulLabel.setVisible(false);
		    Estambul.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (BagdadCuarentena == false) {
		    BagdadLabel.setVisible(false);
		    Bagdad.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (BagdadCuarentena == true) {
		    BagdadLabel.setVisible(false);
		    Bagdad.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (MoscuCuarentena == false) {
		    MoscuLabel.setVisible(false);
		    Moscu.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (MoscuCuarentena == true) {
		    MoscuLabel.setVisible(false);
		    Moscu.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (TeheranCuarentena == false) {
		    TeheranLabel.setVisible(false);
		    Teheran.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (TeheranCuarentena == true) {
		    TeheranLabel.setVisible(false);
		    Teheran.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (KarachiCuarentena == false) {
		    KarachiLabel.setVisible(false);
		    Karachi.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (KarachiCuarentena == true) {
		    KarachiLabel.setVisible(false);
		    Karachi.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (BombayCuarentena == false) {
		    BombayLabel.setVisible(false);
		    Bombay.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (BombayCuarentena == true) {
		    BombayLabel.setVisible(false);
		    Bombay.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (NuevaDelhiCuarentena == false) {
		    NuevaDelhiLabel.setVisible(false);
		    NuevaDelhi.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (NuevaDelhiCuarentena == true) {
		    NuevaDelhiLabel.setVisible(false);
		    NuevaDelhi.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (CalcutaCuarentena == false) {
		    CalcutaLabel.setVisible(false);
		    Calcuta.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (CalcutaCuarentena == true) {
		    CalcutaLabel.setVisible(false);
		    Calcuta.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (MadrasCuarentena == false) {
		    MadrasLabel.setVisible(false);
		    Madras.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (MadrasCuarentena == true) {
		    MadrasLabel.setVisible(false);
		    Madras.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		rutaImagenBoton = "src/img/CiudadRojo.png";
		if (YakartaCuarentena == false) {
		    YakartaLabel.setVisible(false);
		    Yakarta.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (YakartaCuarentena == true) {
		    YakartaLabel.setVisible(false);
		    Yakarta.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (BangkokCuarentena == false) {
		    BangkokLabel.setVisible(false);
		    Bangkok.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (BangkokCuarentena == true) {
		    BangkokLabel.setVisible(false);
		    Bangkok.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (HongKongCuarentena == false) {
		    HongKongLabel.setVisible(false);
		    HongKong.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (HongKongCuarentena == true) {
		    HongKongLabel.setVisible(false);
		    HongKong.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (ShanghaiCuarentena == false) {
		    ShanghaiLabel.setVisible(false);
		    Shanghai.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (ShanghaiCuarentena == true) {
		    ShanghaiLabel.setVisible(false);
		    Shanghai.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (PekinCuarentena == false) {
		    PekinLabel.setVisible(false);
		    Pekin.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (PekinCuarentena == true) {
		    PekinLabel.setVisible(false);
		    Pekin.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (SeulCuarentena == false) {
		    SeulLabel.setVisible(false);
		    Seul.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (SeulCuarentena == true) {
		    SeulLabel.setVisible(false);
		    Seul.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (TokioCuarentena == false) {
		    TokioLabel.setVisible(false);
		    Tokio.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (TokioCuarentena == true) {
		    TokioLabel.setVisible(false);
		    Tokio.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (OsakaCuarentena == false) {
		    OsakaLabel.setVisible(false);
		    Osaka.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (OsakaCuarentena == true) {
		    OsakaLabel.setVisible(false);
		    Osaka.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (TaipeiCuarentena == false) {
		    TaipeiLabel.setVisible(false);
		    Taipei.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (TaipeiCuarentena == true) {
		    TaipeiLabel.setVisible(false);
		    Taipei.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (HoChiMinhCuarentena == false) {
		    HoChiMinhLabel.setVisible(false);
		    HoChiMinh.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (HoChiMinhCuarentena == true) {
		    HoChiMinhLabel.setVisible(false);
		    HoChiMinh.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (ManilaCuarentena == false) {
		    ManilaLabel.setVisible(false);
		    Manila.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (ManilaCuarentena == true) {
		    ManilaLabel.setVisible(false);
		    Manila.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (SidneyCuarentena == false) {
		    SidneyLabel.setVisible(false);
		    Sidney.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (SidneyCuarentena == true) {
		    SidneyLabel.setVisible(false);
		    Sidney.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		
		AzulLabel.setVisible(false);
		NegroLabel.setVisible(false);
		AmarilloLabel.setVisible(false);
		RojoLabel.setVisible(false);
		etiqueta.setVisible(true);
	}
	
	public void quitarCuarentena(JLabel etiqueta) {
		String rutaImagenBoton;
		String rutaImagenCuarentena = "src/img/CiudadCuarentena.png";
		rutaImagenBoton = "src/img/CiudadAzul.png";
		
		if(SanFranciscoCuarentena == false) {
			SanFrancisco.setIcon(new ImageIcon(rutaImagenBoton));
		}else if (SanFranciscoCuarentena == true) {
			SanFrancisco.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if(ChicagoCuarentena == false) {
			Chicago.setIcon(new ImageIcon(rutaImagenBoton));
		}else if(ChicagoCuarentena == true) {
			Chicago.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (AtlantaCuarentena == false) {
		    Atlanta.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (AtlantaCuarentena == true) {
		    Atlanta.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (MontrealCuarentena == false) {
		    Montreal.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (MontrealCuarentena == true) {
		    Montreal.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (NuevaYorkCuarentena == false) {
		    NuevaYork.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (NuevaYorkCuarentena == true) {
		    NuevaYork.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (WashingtonCuarentena == false) {
		    Washington.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (WashingtonCuarentena == true) {
		    Washington.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (LondresCuarentena == false) {
		    Londres.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (LondresCuarentena == true) {
		    Londres.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (MadridCuarentena == false) {
		    Madrid.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (MadridCuarentena == true) {
		    Madrid.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (ParisCuarentena == false) {
		    Paris.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (ParisCuarentena == true) {
		    Paris.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (EssenCuarentena == false) {
		    Essen.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (EssenCuarentena == true) {
		    Essen.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (MilanCuarentena == false) {
		    Milan.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (MilanCuarentena == true) {
		    Milan.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (SanPetersburgoCuarentena == false) {
		    SanPetersburgo.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (SanPetersburgoCuarentena == true) {
		    SanPetersburgo.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		rutaImagenBoton = "src/img/CiudadAmarillo.png";
		if (LosAngelesCuarentena == false) {
		    LosAngeles.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (LosAngelesCuarentena == true) {
		    LosAngeles.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (MiamiCuarentena == false) {
		    Miami.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (MiamiCuarentena == true) {
		    Miami.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (MexicoCuarentena == false) {
		    Mexico.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (MexicoCuarentena == true) {
		    Mexico.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (BogotaCuarentena == false) {
		    Bogota.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (BogotaCuarentena == true) {
		    Bogota.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (LimaCuarentena == false) {
		    Lima.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (LimaCuarentena == true) {
		    Lima.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (SantiagoCuarentena == false) {
		    Santiago.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (SantiagoCuarentena == true) {
		    Santiago.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (BuenosAiresCuarentena == false) {
		    BuenosAires.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (BuenosAiresCuarentena == true) {
		    BuenosAires.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (SaoPauloCuarentena == false) {
		    SaoPaulo.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (SaoPauloCuarentena == true) {
		    SaoPaulo.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (LagosCuarentena == false) {
		    Lagos.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (LagosCuarentena == true) {
		    Lagos.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (KinsasaCuarentena == false) {
		    Kinsasa.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (KinsasaCuarentena == true) {
		    Kinsasa.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (JartumCuarentena == false) {
		    Jartum.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (JartumCuarentena == true) {
		    Jartum.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (JohannesburgoCuarentena == false) {
		    Johannesburgo.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (JohannesburgoCuarentena == true) {
		    Johannesburgo.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		rutaImagenBoton = "src/img/CiudadNegro.png";
		if (ArgelCuarentena == false) {
		    Argel.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (ArgelCuarentena == true) {
		    Argel.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (CairoCuarentena == false) {
		    Cairo.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (CairoCuarentena == true) {
		    Cairo.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (RiadCuarentena == false) {
		    Riad.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (RiadCuarentena == true) {
		    Riad.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (EstambulCuarentena == false) {
		    Estambul.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (EstambulCuarentena == true) {
		    Estambul.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (BagdadCuarentena == false) {
		    Bagdad.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (BagdadCuarentena == true) {
		    Bagdad.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (MoscuCuarentena == false) {
		    Moscu.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (MoscuCuarentena == true) {
		    Moscu.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (TeheranCuarentena == false) {
		    Teheran.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (TeheranCuarentena == true) {
		    Teheran.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (KarachiCuarentena == false) {
		    Karachi.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (KarachiCuarentena == true) {
		    Karachi.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (BombayCuarentena == false) {
		    Bombay.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (BombayCuarentena == true) {
		    Bombay.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (NuevaDelhiCuarentena == false) {
		    NuevaDelhi.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (NuevaDelhiCuarentena == true) {
		    NuevaDelhi.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (CalcutaCuarentena == false) {
		    Calcuta.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (CalcutaCuarentena == true) {
		    Calcuta.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (MadrasCuarentena == false) {
		    Madras.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (MadrasCuarentena == true) {
		    Madras.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		rutaImagenBoton = "src/img/CiudadRojo.png";
		if (YakartaCuarentena == false) {
		    Yakarta.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (YakartaCuarentena == true) {
		    Yakarta.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (BangkokCuarentena == false) {
		    Bangkok.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (BangkokCuarentena == true) {
		    Bangkok.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (HongKongCuarentena == false) {
		    HongKong.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (HongKongCuarentena == true) {
		    HongKong.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (ShanghaiCuarentena == false) {
		    Shanghai.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (ShanghaiCuarentena == true) {
		    Shanghai.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (PekinCuarentena == false) {
		    Pekin.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (PekinCuarentena == true) {
		    Pekin.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (SeulCuarentena == false) {
		    Seul.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (SeulCuarentena == true) {
		    Seul.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (TokioCuarentena == false) {
		    Tokio.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (TokioCuarentena == true) {
		    Tokio.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (OsakaCuarentena == false) {
		    Osaka.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (OsakaCuarentena == true) {
		    Osaka.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (TaipeiCuarentena == false) {
		    Taipei.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (TaipeiCuarentena == true) {
		    Taipei.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (HoChiMinhCuarentena == false) {
		    HoChiMinh.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (HoChiMinhCuarentena == true) {
		    HoChiMinh.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (ManilaCuarentena == false) {
		    Manila.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (ManilaCuarentena == true) {
		    Manila.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
		if (SidneyCuarentena == false) {
		    Sidney.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (SidneyCuarentena == true) {
		    Sidney.setIcon(new ImageIcon(rutaImagenCuarentena));
		}
	}
	
	public boolean verificarTodosCeros(String[] ciudades) {
	    for (String ciudad : ciudades) {
	        if (!ciudad.equals("0")) {
	            return false;
	        }
	    }
	    return true;
	}
	
	private void calcularVirusTotales() {
		VirusTotalesInt = VirusSanFrancisco + VirusChicago + VirusAtlanta + VirusMontreal + VirusNuevaYork + VirusWashington + VirusLondres + VirusMadrid + VirusParis + VirusEssen +
				VirusMilan + VirusSanPetersburgo + VirusLosAngeles + VirusMiami + VirusMexico + VirusBogota + VirusLima + VirusSantiago + VirusBuenosAires + VirusSaoPaulo + 
				VirusLagos + VirusKinsasa + VirusJartum + VirusJohannesburgo + VirusArgel + VirusCairo + VirusRiad + VirusEstambul + VirusBagdad + VirusMoscu + VirusTeheran + 
				VirusKarachi + VirusBombay + VirusNuevaDelhi + VirusCalcuta + VirusMadras + VirusYakarta + VirusBangkok + VirusHongKong + VirusShanghai + VirusPekin + 
				VirusSeul + VirusTokio + VirusOsaka + VirusTaipei + VirusHoChiMinh + VirusManila + VirusSidney;
		VirusTotales.setText("Virus Totales = " + VirusTotalesInt + "");
	}
	
	private void asignarNivel(int nivel) {
	    ImageIcon carta;
	    switch (nivel) {
	        case 1:
	            carta = new ImageIcon("src/img/Nivel1.png");
	            Nivel1.setIcon(carta);
	            break;
	        case 2:
	        	carta = new ImageIcon("src/img/Nivel1.png");
	            Nivel1.setIcon(carta);
	            carta = new ImageIcon("src/img/Nivel2.png");
	            Nivel2.setIcon(carta);
	            break;
	        case 3:
	        	carta = new ImageIcon("src/img/Nivel1.png");
	            Nivel1.setIcon(carta);
	            carta = new ImageIcon("src/img/Nivel2.png");
	            Nivel2.setIcon(carta);
	            carta = new ImageIcon("src/img/Nivel3.png");
	            Nivel3.setIcon(carta);
	            break;
	        case 4:
	        	carta = new ImageIcon("src/img/Nivel1.png");
	            Nivel1.setIcon(carta);
	            carta = new ImageIcon("src/img/Nivel2.png");
	            Nivel2.setIcon(carta);
	            carta = new ImageIcon("src/img/Nivel3.png");
	            Nivel3.setIcon(carta);
	            carta = new ImageIcon("src/img/Nivel4.png");
	            Nivel4.setIcon(carta);
	            break;
	        case 5:
	        	carta = new ImageIcon("src/img/Nivel1.png");
	            Nivel1.setIcon(carta);
	            carta = new ImageIcon("src/img/Nivel2.png");
	            Nivel2.setIcon(carta);
	            carta = new ImageIcon("src/img/Nivel3.png");
	            Nivel3.setIcon(carta);
	            carta = new ImageIcon("src/img/Nivel4.png");
	            Nivel4.setIcon(carta);
	            carta = new ImageIcon("src/img/Nivel5.png");
	            Nivel5.setIcon(carta);
	            break;
	        case 6:
	        	setVisible(false);
	            marco.getContentPane().removeAll();
	            marco.add(new PantallaPerdido("src/img/PantallaPerdido.png", marco));
	            marco.revalidate();
	            marco.repaint();
	        default:
	            break;
	    }
	}

	public void actionPerformed(ActionEvent e) {
		String rutaImagenBoton;
		rutaImagenBoton = "src/img/CiudadBlanco.png";
		if (e.getSource() == SanFrancisco) {
			mostrarEtiqueta(SanFranciscoLabel);
			SanFrancisco.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Chicago) {
			mostrarEtiqueta(ChicagoLabel);
			Chicago.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Atlanta) {
			mostrarEtiqueta(AtlantaLabel);
			Atlanta.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Montreal) {
			mostrarEtiqueta(MontrealLabel);
			Montreal.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == NuevaYork) {
			mostrarEtiqueta(NuevaYorkLabel);
			NuevaYork.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Washington) {
			mostrarEtiqueta(WashingtonLabel);
			Washington.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Londres) {
			mostrarEtiqueta(LondresLabel);
			Londres.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Madrid) {
			mostrarEtiqueta(MadridLabel);
			Madrid.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Paris) {
			mostrarEtiqueta(ParisLabel);
			Paris.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Essen) {
			mostrarEtiqueta(EssenLabel);
			Essen.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Milan) {
			mostrarEtiqueta(MilanLabel);
			Milan.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == SanPetersburgo) {
			mostrarEtiqueta(SanPetersburgoLabel);
			SanPetersburgo.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == LosAngeles) {
			mostrarEtiqueta(LosAngelesLabel);
			LosAngeles.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Miami) {
			mostrarEtiqueta(MiamiLabel);
			Miami.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Mexico) {
			mostrarEtiqueta(MexicoLabel);
			Mexico.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Bogota) {
			mostrarEtiqueta(BogotaLabel);
			Bogota.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Lima) {
			mostrarEtiqueta(LimaLabel);
			Lima.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Santiago) {
			mostrarEtiqueta(SantiagoLabel);
			Santiago.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == BuenosAires) {
			mostrarEtiqueta(BuenosAiresLabel);
			BuenosAires.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == SaoPaulo) {
			mostrarEtiqueta(SaoPauloLabel);
			SaoPaulo.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Lagos) {
			mostrarEtiqueta(LagosLabel);
			Lagos.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Kinsasa) {
			mostrarEtiqueta(KinsasaLabel);
			Kinsasa.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Jartum) {
			mostrarEtiqueta(JartumLabel);
			Jartum.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Johannesburgo) {
			mostrarEtiqueta(JohannesburgoLabel);
			Johannesburgo.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Argel) {
			mostrarEtiqueta(ArgelLabel);
			Argel.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Cairo) {
			mostrarEtiqueta(CairoLabel);
			Cairo.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Riad) {
			mostrarEtiqueta(RiadLabel);
			Riad.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Estambul) {
			mostrarEtiqueta(EstambulLabel);
			Estambul.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Bagdad) {
			mostrarEtiqueta(BagdadLabel);
			Bagdad.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Moscu) {
			mostrarEtiqueta(MoscuLabel);
			Moscu.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Teheran) {
			mostrarEtiqueta(TeheranLabel);
			Teheran.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Karachi) {
			mostrarEtiqueta(KarachiLabel);
			Karachi.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Bombay) {
			mostrarEtiqueta(BombayLabel);
			Bombay.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == NuevaDelhi) {
			mostrarEtiqueta(NuevaDelhiLabel);
			NuevaDelhi.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Calcuta) {
			mostrarEtiqueta(CalcutaLabel);
			Calcuta.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Madras) {
			mostrarEtiqueta(MadrasLabel);
			Madras.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Yakarta) {
			mostrarEtiqueta(YakartaLabel);
			Yakarta.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Bangkok) {
			mostrarEtiqueta(BangkokLabel);
			Bangkok.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == HongKong) {
			mostrarEtiqueta(HongKongLabel);
			HongKong.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Shanghai) {
			mostrarEtiqueta(ShanghaiLabel);
			Shanghai.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Pekin) {
			mostrarEtiqueta(PekinLabel);
			Pekin.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Seul) {
			mostrarEtiqueta(SeulLabel);
			Seul.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Tokio) {
			mostrarEtiqueta(TokioLabel);
			Tokio.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Osaka) {
			mostrarEtiqueta(OsakaLabel);
			Osaka.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Taipei) {
			mostrarEtiqueta(TaipeiLabel);
			Taipei.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == HoChiMinh) {
			mostrarEtiqueta(HoChiMinhLabel);
			HoChiMinh.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Manila) {
			mostrarEtiqueta(ManilaLabel);
			Manila.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == Sidney) {
			mostrarEtiqueta(SidneyLabel);
			Sidney.setIcon(new ImageIcon(rutaImagenBoton));
		} else if (e.getSource() == CuraAzul) {
			mostrarEtiqueta(AzulLabel);
		} else if (e.getSource() == CuraNegro) {
			mostrarEtiqueta(NegroLabel);
		} else if (e.getSource() == CuraAmarillo) {
			mostrarEtiqueta(AmarilloLabel);
		} else if (e.getSource() == CuraRojo) {
			mostrarEtiqueta(RojoLabel);
		}
		if (e.getSource() == CurarCiudad) {
			if (Intentos >= 1) {
				
				String[] ciudades = { "SanFrancisco", "Chicago", "Atlanta", "Montreal", "NuevaYork", "Washington",
						"Londres", "Madrid", "Paris", "Essen", "Milan", "SanPetersburgo", "LosAngeles", "Miami",
						"Mexico", "Bogota", "Lima", "Santiago", "BuenosAires", "SaoPaulo", "Lagos", "Kinsasa", "Jartum",
						"Johannesburgo", "Argel", "Cairo", "Riad", "Estambul", "Bagdad", "Moscu", "Teheran", "Karachi",
						"Bombay", "NuevaDelhi", "Calcuta", "Madras", "Yakarta", "Bangkok", "HongKong", "Shanghai",
						"Pekin", "Seul", "Tokio", "Osaka", "Taipei", "HoChiMinh", "Manila", "Sidney" };

				for (String ciudad : ciudades) {
					obtenerCiudadActiva(ciudad);
				}
			}
		}
		if (e.getSource() == DesarrollarCura) {
			if (Intentos >= 1) {
				String[] virus = { "Negro", "Amarillo", "Rojo", "Azul" };

				for (String cura : virus) {
					obtenerVirusActivo(cura);
				}
				pintarMatraz();
			}
		}if (e.getSource() == Cuarentena) {
			if (Intentos >= 1) {
				String[] ciudades = { "SanFrancisco", "Chicago", "Atlanta", "Montreal", "NuevaYork", "Washington",
						"Londres", "Madrid", "Paris", "Essen", "Milan", "SanPetersburgo", "LosAngeles", "Miami",
						"Mexico", "Bogota", "Lima", "Santiago", "BuenosAires", "SaoPaulo", "Lagos", "Kinsasa", "Jartum",
						"Johannesburgo", "Argel", "Cairo", "Riad", "Estambul", "Bagdad", "Moscu", "Teheran", "Karachi",
						"Bombay", "NuevaDelhi", "Calcuta", "Madras", "Yakarta", "Bangkok", "HongKong", "Shanghai",
						"Pekin", "Seul", "Tokio", "Osaka", "Taipei", "HoChiMinh", "Manila", "Sidney" };

				for (String ciudad : ciudades) {
					ponerEnCuarentena(ciudad);
				}
				Intentos = Intentos -2;
				LabelIntentos.setText("Movimientos = " + Intentos + "");
			}
		}
		if (e.getSource() == Opciones) {
			if (GuardarPartida.isVisible()) {
				GuardarPartida.setVisible(false);
				VolverMenu.setVisible(false);
			} else if (!GuardarPartida.isVisible()) {
				GuardarPartida.setVisible(true);
				VolverMenu.setVisible(true);
			}
		}
		if(e.getSource() == GuardarPartida || e.getSource() == VolverMenu) {
			
			if(Partida_ID > 2) {
				LabelNoMasPartida.setText("NO SE PUEDEN GUARDAR MAS PARTIDAS");
	            Timer timer = new Timer(2000, new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	LabelNoMasPartida.setText("");
	                }
	            });
	            timer.setRepeats(false); 
	            timer.start();
	            
	            if(e.getSource() == VolverMenu) {
					setVisible(false);
		            marco.getContentPane().removeAll();
		            marco.add(new PanelPrincipal("src/img/FondoPantallaCompleto-1.png", marco));
		            marco.revalidate();
		            marco.repaint();
	            }
			}else{
				con = bbdd.conectarBaseDatos();
			
			bbdd.delete(con, "DELETE FROM VACUNA WHERE PARTIDA_ID = "+Partida_ID+"");
			bbdd.delete(con, "DELETE FROM CIUDAD WHERE PARTIDA_ID = "+Partida_ID+"");
			bbdd.delete(con, "DELETE FROM PARTIDA WHERE PARTIDA_ID = "+Partida_ID+"");
			
			bbdd.insert(con, "INSERT INTO PARTIDA(PARTIDA_ID, NOM_JUGADOR, TOTAL_MOVIMENTS, TOTAL_VIRUS, NIVEL_BROTE, DIFICULTAD, RONDA) "
					+ "VALUES("+Partida_ID+", '"+PantallaDificultad.NombreJugador+"', "+ Intentos +", "+VirusTotalesInt+", "+Niveles+", "+PantallaDificultad.Dificultad+", "+Ronda+")");
			
			String Ciudades[][] = {
				    {"SanFrancisco", String.valueOf(VirusSanFrancisco), String.valueOf(SanFranciscoCuarentena)},
				    {"Chicago", String.valueOf(VirusChicago), String.valueOf(ChicagoCuarentena)},
				    {"Atlanta", String.valueOf(VirusAtlanta), String.valueOf(AtlantaCuarentena)},
				    {"Montreal", String.valueOf(VirusMontreal), String.valueOf(MontrealCuarentena)},
				    {"NuevaYork", String.valueOf(VirusNuevaYork), String.valueOf(NuevaYorkCuarentena)},
				    {"Washington", String.valueOf(VirusWashington), String.valueOf(WashingtonCuarentena)},
				    {"Londres", String.valueOf(VirusLondres), String.valueOf(LondresCuarentena)},
				    {"Madrid", String.valueOf(VirusMadrid), String.valueOf(MadridCuarentena)},
				    {"Paris", String.valueOf(VirusParis), String.valueOf(ParisCuarentena)},
				    {"Essen", String.valueOf(VirusEssen), String.valueOf(EssenCuarentena)},
				    {"Milan", String.valueOf(VirusMilan), String.valueOf(MilanCuarentena)},
				    {"SanPetersburgo", String.valueOf(VirusSanPetersburgo), String.valueOf(SanPetersburgoCuarentena)},
				    {"LosAngeles", String.valueOf(VirusLosAngeles), String.valueOf(LosAngelesCuarentena)},
				    {"Miami", String.valueOf(VirusMiami), String.valueOf(MiamiCuarentena)},
				    {"Mexico", String.valueOf(VirusMexico), String.valueOf(MexicoCuarentena)},
				    {"Bogota", String.valueOf(VirusBogota), String.valueOf(BogotaCuarentena)},
				    {"Lima", String.valueOf(VirusLima), String.valueOf(LimaCuarentena)},
				    {"Santiago", String.valueOf(VirusSantiago), String.valueOf(SantiagoCuarentena)},
				    {"BuenosAires", String.valueOf(VirusBuenosAires), String.valueOf(BuenosAiresCuarentena)},
				    {"SaoPaulo", String.valueOf(VirusSaoPaulo), String.valueOf(SaoPauloCuarentena)},
				    {"Lagos", String.valueOf(VirusLagos), String.valueOf(LagosCuarentena)},
				    {"Kinsasa", String.valueOf(VirusKinsasa), String.valueOf(KinsasaCuarentena)},
				    {"Jartum", String.valueOf(VirusJartum), String.valueOf(JartumCuarentena)},
				    {"Johannesburgo", String.valueOf(VirusJohannesburgo), String.valueOf(JohannesburgoCuarentena)},
				    {"Argel", String.valueOf(VirusArgel), String.valueOf(ArgelCuarentena)},
				    {"Cairo", String.valueOf(VirusCairo), String.valueOf(CairoCuarentena)},
				    {"Riad", String.valueOf(VirusRiad), String.valueOf(RiadCuarentena)},
				    {"Estambul", String.valueOf(VirusEstambul), String.valueOf(EstambulCuarentena)},
				    {"Bagdad", String.valueOf(VirusBagdad), String.valueOf(BagdadCuarentena)},
				    {"Moscu", String.valueOf(VirusMoscu), String.valueOf(MoscuCuarentena)},
				    {"Teheran", String.valueOf(VirusTeheran), String.valueOf(TeheranCuarentena)},
				    {"Karachi", String.valueOf(VirusKarachi), String.valueOf(KarachiCuarentena)},
				    {"Bombay", String.valueOf(VirusBombay), String.valueOf(BombayCuarentena)},
				    {"NuevaDelhi", String.valueOf(VirusNuevaDelhi), String.valueOf(NuevaDelhiCuarentena)},
				    {"Calcuta", String.valueOf(VirusCalcuta), String.valueOf(CalcutaCuarentena)},
				    {"Madras", String.valueOf(VirusMadras), String.valueOf(MadrasCuarentena)},
				    {"Yakarta", String.valueOf(VirusYakarta), String.valueOf(YakartaCuarentena)},
				    {"Bangkok", String.valueOf(VirusBangkok), String.valueOf(BangkokCuarentena)},
				    {"HongKong", String.valueOf(VirusHongKong), String.valueOf(HongKongCuarentena)},
				    {"Shanghai", String.valueOf(VirusShanghai), String.valueOf(ShanghaiCuarentena)},
				    {"Pekin", String.valueOf(VirusPekin), String.valueOf(PekinCuarentena)},
				    {"Seul", String.valueOf(VirusSeul), String.valueOf(SeulCuarentena)},
				    {"Tokio", String.valueOf(VirusTokio), String.valueOf(TokioCuarentena)},
				    {"Osaka", String.valueOf(VirusOsaka), String.valueOf(OsakaCuarentena)},
				    {"Taipei", String.valueOf(VirusTaipei), String.valueOf(TaipeiCuarentena)},
				    {"HoChiMinh", String.valueOf(VirusHoChiMinh), String.valueOf(HoChiMinhCuarentena)},
				    {"Manila", String.valueOf(VirusManila), String.valueOf(ManilaCuarentena)},
				    {"Sidney", String.valueOf(VirusSidney), String.valueOf(SidneyCuarentena)}
				};
			
			for (String[] ciudadInfo : Ciudades) {
			    String ciudad = ciudadInfo[0];
			    String virus = ciudadInfo[1];
			    int virusInt = Integer.parseInt(virus);
			    String cuarentena = ciudadInfo[2];
			    
			    bbdd.insert(con, "INSERT INTO CIUDAD(PARTIDA_ID, NOMBRE_CIUDAD, CANTIDAD_VIRUS, CUARENTENA)"
						+ "VALUES("+Partida_ID+", '"+ ciudad +"', "+virusInt+", '"+cuarentena+"')");
			}
			
			String Vacunas[][] = {
					{"Azul", String.valueOf(PorcentajeDesarrolloAzul)},
					{"Amarillo", String.valueOf(PorcentajeDesarrolloAmarillo)},
					{"Negro", String.valueOf(PorcentajeDesarrolloNegro)},
					{"Rojo", String.valueOf(PorcentajeDesarrolloRojo)}
			};
			
			for (String[] vacunaInfo : Vacunas) {
			    String vacuna = vacunaInfo[0];
			    String porcentaje = vacunaInfo[1];
			    double virusDouble = Double.parseDouble(porcentaje);

			    bbdd.insert(con, "INSERT INTO VACUNA(PARTIDA_ID, COLOR_VIRUS, PORCENTAJE_DESARROLLO)"
						+ "VALUES("+Partida_ID+", '"+ vacuna +"', "+virusDouble+")");
			}
			
			if(e.getSource() == VolverMenu) {
				setVisible(false);
	            marco.getContentPane().removeAll();
	            marco.add(new PanelPrincipal("src/img/FondoPantallaCompleto-1.png", marco));
	            marco.revalidate();
	            marco.repaint();
			}
			}
		}
		if (e.getSource() == PasarTurno) {
			
			if(VirusTotalesInt == 0 || (PorcentajeDesarrolloAzul >= 100 && PorcentajeDesarrolloAmarillo >= 100 && PorcentajeDesarrolloNegro >= 100 && PorcentajeDesarrolloRojo >= 100)) {
				if(Niveles <= 0) {
					setPuntuacion(getPuntuacion() + 100);
				}else if(Niveles == 1) {
					setPuntuacion(getPuntuacion() + 75);
				}else if(Niveles == 2) {
					setPuntuacion(getPuntuacion() + 50);
				}else if(Niveles == 3) {
					setPuntuacion(getPuntuacion() + 30);
				}else if(Niveles == 4) {
					setPuntuacion(getPuntuacion() + 15);
				}else if(Niveles >= 5) {
					setPuntuacion(getPuntuacion() + 5);
				}
				if(PorcentajeDesarrolloAzul >= 100) {
					setPuntuacion(getPuntuacion() + 50);
				} else {
					setPuntuacion(getPuntuacion() + 150);
				}
				if(PorcentajeDesarrolloAmarillo >= 100) {
					setPuntuacion(getPuntuacion() + 50);
				} else {
					setPuntuacion(getPuntuacion() + 150);
				}
				if(PorcentajeDesarrolloNegro >= 100) {
					setPuntuacion(getPuntuacion() + 50);
				} else {
					setPuntuacion(getPuntuacion() + 150);
				}
				if(PorcentajeDesarrolloRojo >= 100) {
					setPuntuacion(getPuntuacion() + 50);
				} else {
					setPuntuacion(getPuntuacion() + 150);
				}
				if(Ronda <= 30) {
					setPuntuacion(getPuntuacion() + 250);
				}else if (Ronda > 30 && Ronda <= 45) {
					setPuntuacion(getPuntuacion() + 100);
				}else if (Ronda > 45 && Ronda <= 60) {
					setPuntuacion(getPuntuacion() + 50);
				}else if (Ronda > 60 && Ronda <= 85) {
					setPuntuacion(getPuntuacion() + 25);
				}else if (Ronda > 85 ) {
					setPuntuacion(getPuntuacion() + 10);
				}
				if(PantallaDificultad.Dificultad == 1) {
					setPuntuacion(getPuntuacion() + 50);
				}else if(PantallaDificultad.Dificultad == 2) {
					setPuntuacion(getPuntuacion() + 175);
				}else if(PantallaDificultad.Dificultad == 3) {
					setPuntuacion(getPuntuacion() + 300);
				}
				Connection con = bbdd.conectarBaseDatos();
				bbdd.insert(con, "INSERT INTO RANKING(NOM_JUGADOR, FECHA, PUNTUACION) VALUES('"+PantallaDificultad.NombreJugador+"', SYSDATE, "+getPuntuacion()+")");
				
				bbdd.delete(con, "DELETE FROM VACUNA WHERE PARTIDA_ID = "+Partida_ID+"");
				bbdd.delete(con, "DELETE FROM CIUDAD WHERE PARTIDA_ID = "+Partida_ID+"");
				bbdd.delete(con, "DELETE FROM PARTIDA WHERE PARTIDA_ID = "+Partida_ID+"");
				
				setVisible(false);
	            marco.getContentPane().removeAll();
	            marco.add(new PantallaGanado("src/img/PantallaGanado.png", marco));
	            marco.revalidate();
	            marco.repaint();
			}
			
			else if (Intentos <= 0) {
				Intentos = Intentos + 4;
				LabelIntentos.setText("Movimientos = " + Intentos + "");
				
				SanFranciscoCuarentena = false;
				ChicagoCuarentena = false;
				AtlantaCuarentena = false;
				MontrealCuarentena = false;
				NuevaYorkCuarentena = false;
				WashingtonCuarentena = false;
				LondresCuarentena = false;
				MadridCuarentena = false;
				ParisCuarentena = false;
				EssenCuarentena = false;
				MilanCuarentena = false;
				SanPetersburgoCuarentena = false;
				LosAngelesCuarentena = false;
				MiamiCuarentena = false;
				MexicoCuarentena = false;
				BogotaCuarentena = false;
				LimaCuarentena = false;
				SantiagoCuarentena = false;
				BuenosAiresCuarentena = false;
				SaoPauloCuarentena = false;
				LagosCuarentena = false;
				KinsasaCuarentena = false;
				JartumCuarentena = false;
				JohannesburgoCuarentena = false;
				ArgelCuarentena = false;
				CairoCuarentena = false;
				RiadCuarentena = false;
				EstambulCuarentena = false;
				BagdadCuarentena = false;
				MoscuCuarentena = false;
				TeheranCuarentena = false;
				KarachiCuarentena = false;
				BombayCuarentena = false;
				NuevaDelhiCuarentena = false;
				CalcutaCuarentena = false;
				MadrasCuarentena = false;
				YakartaCuarentena = false;
				BangkokCuarentena = false;
				HongKongCuarentena = false;
				ShanghaiCuarentena = false;
				PekinCuarentena = false;
				SeulCuarentena = false;
				TokioCuarentena = false;
				OsakaCuarentena = false;
				TaipeiCuarentena = false;
				HoChiMinhCuarentena = false;
				ManilaCuarentena = false;
				SidneyCuarentena = false;
				
				JLabel[] CiudadLabel = {SanFranciscoLabel, ChicagoLabel, AtlantaLabel, MontrealLabel, NuevaYorkLabel, WashingtonLabel,
						LondresLabel, MadridLabel, ParisLabel, EssenLabel, MilanLabel, SanPetersburgoLabel, LosAngelesLabel,
						MiamiLabel, MexicoLabel, BogotaLabel, LimaLabel, SantiagoLabel, BuenosAiresLabel, SaoPauloLabel, LagosLabel,
						KinsasaLabel, JartumLabel, JohannesburgoLabel, ArgelLabel, CairoLabel, RiadLabel, EstambulLabel,
						BagdadLabel, MoscuLabel, TeheranLabel, KarachiLabel, BombayLabel, NuevaDelhiLabel, CalcutaLabel,
						MadrasLabel, YakartaLabel, BangkokLabel, HongKongLabel, ShanghaiLabel, PekinLabel, SeulLabel, TokioLabel,
						OsakaLabel, TaipeiLabel, HoChiMinhLabel, ManilaLabel, SidneyLabel};
				
				for (JLabel Labelciudad : CiudadLabel) {
					quitarCuarentena(Labelciudad);
				}
				
				if (PantallaDificultad.Dificultad == 1) {
					Random rand = new Random();
					HashSet<Integer> numerosGenerados = new HashSet<>();
					for (int i = 0; i < arraysumaRandom1.length; i++) {
						int numeroAleatorio;
						do {
							numeroAleatorio = rand.nextInt(48);
						} while (numerosGenerados.contains(numeroAleatorio));
						numerosGenerados.add(numeroAleatorio);
						arraysumaRandom1[i] = numeroAleatorio;
					}
				} else if (PantallaDificultad.Dificultad == 2) {
					Random rand = new Random();
					HashSet<Integer> numerosGenerados = new HashSet<>();
					for (int i = 0; i < arraysumaRandom2.length; i++) {
						int numeroAleatorio;
						do {
							numeroAleatorio = rand.nextInt(48);
						} while (numerosGenerados.contains(numeroAleatorio));
						numerosGenerados.add(numeroAleatorio);
						arraysumaRandom2[i] = numeroAleatorio;
					}
				} else if (PantallaDificultad.Dificultad == 3) {
					Random rand = new Random();
					HashSet<Integer> numerosGenerados = new HashSet<>();
					for (int i = 0; i < arraysumaRandom3.length; i++) {
						int numeroAleatorio;
						do {
							numeroAleatorio = rand.nextInt(48);
						} while (numerosGenerados.contains(numeroAleatorio));
						numerosGenerados.add(numeroAleatorio);
						arraysumaRandom3[i] = numeroAleatorio;
					}
				}
				if(SanFranciscoCuarentena == false) {
					int SumarVirusSanFrancisco = SumarVirus("SanFrancisco");
				VirusSanFrancisco = VirusSanFrancisco + SumarVirusSanFrancisco;
				if(SumarVirusSanFrancisco == 1) {
					ExclamationApeares(SanFranciscoExclamation);
				}
				if(VirusSanFrancisco >= 4) {
					VirusSanFrancisco--;
					VirusChicago ++;
					if(VirusChicago >= 4) {
						VirusChicago--;
						Niveles ++;
						asignarNivel(Niveles);
					} 
					VirusLosAngeles ++;
					if(VirusLosAngeles >= 4) {
					    VirusLosAngeles--;
					    Niveles ++;
					    asignarNivel(Niveles);
					}
					VirusManila++;
					if(VirusManila >= 4) {
					    VirusManila--;
					    Niveles++;
					    asignarNivel(Niveles);
					} 
					VirusTokio++;
					if(VirusTokio >= 4) {
					    VirusTokio--;
					    Niveles++;
					    asignarNivel(Niveles);
					} 
				}
				}

				if(ChicagoCuarentena == false) {
				    int SumarVirusChicago = SumarVirus("Chicago");
				    VirusChicago = VirusChicago + SumarVirusChicago;
				    if(SumarVirusChicago == 1) {
				        ExclamationApeares(ChicagoExclamation);
				    }
				if(VirusChicago >= 4) {
					VirusChicago--;
					VirusSanFrancisco++;
					if(VirusSanFrancisco >= 4) {
					    VirusSanFrancisco--;
					    Niveles++;
					    asignarNivel(Niveles);
					} 
					VirusMontreal++;
					if(VirusMontreal >= 4) {
					    VirusMontreal--;
					    Niveles++;
					    asignarNivel(Niveles);
					} 
					VirusAtlanta++;
					if(VirusAtlanta >= 4) {
					    VirusAtlanta--;
					    Niveles++;
					    asignarNivel(Niveles);
					} 
					VirusMexico++;
					if(VirusMexico >= 4) {
					    VirusMexico--;
					    Niveles++;
					    asignarNivel(Niveles);
					} 
					VirusLosAngeles ++;
					if(VirusLosAngeles >= 4) {
					    VirusLosAngeles--;
					    Niveles ++;
					    asignarNivel(Niveles);
					} 
				}
				}

				if(AtlantaCuarentena == false) {
				    int SumarVirusAtlanta = SumarVirus("Atlanta");
				    VirusAtlanta = VirusAtlanta + SumarVirusAtlanta;
				    if(SumarVirusAtlanta == 1) {
				        ExclamationApeares(AtlantaExclamation);
				    }
				if(VirusAtlanta >= 4) {
				    VirusAtlanta--;
				    VirusSanFrancisco ++;
				    if(VirusSanFrancisco >= 4) {
				        VirusSanFrancisco--;
				        Niveles ++;
				        asignarNivel(Niveles);
				    } 
				    VirusMiami ++;
				    if(VirusMiami >= 4) {
				        VirusMiami--;
				        Niveles ++;
				        asignarNivel(Niveles);
				    } 
				    VirusWashington++;
				    if(VirusWashington >= 4) {
				        VirusWashington--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				} 
				}

				if(MontrealCuarentena == false) {
				    int SumarVirusMontreal = SumarVirus("Montreal");
				    VirusMontreal = VirusMontreal + SumarVirusMontreal;
				    if(SumarVirusMontreal == 1) {
				        ExclamationApeares(MontrealExclamation);
				    }
				if(VirusMontreal >= 4) {
				    VirusMontreal--;
				    VirusChicago ++;
				    if(VirusChicago >= 4) {
				        VirusChicago--;
				        Niveles ++;
				        asignarNivel(Niveles);
				    } 
				    VirusNuevaYork++;
				    if(VirusNuevaYork >= 4) {
				        VirusNuevaYork--;
				        Niveles ++;
				        asignarNivel(Niveles);
				    } 
				    VirusWashington++;
				    if(VirusWashington >= 4) {
				        VirusWashington--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				}
				}
				
				if(NuevaYorkCuarentena == false) {
				    int SumarVirusNuevaYork = SumarVirus("NuevaYork");
				    VirusNuevaYork = VirusNuevaYork + SumarVirusNuevaYork;
				    if(SumarVirusNuevaYork == 1) {
				        ExclamationApeares(NuevaYorkExclamation);
				    }
				if(VirusNuevaYork >= 4) {
				    VirusNuevaYork--;
				    VirusMontreal++;
				    if(VirusMontreal >= 4) {
				        VirusMontreal--;
				        Niveles ++;
				        asignarNivel(Niveles);
				    } 
				    VirusWashington++;
				    if(VirusWashington >= 4) {
				        VirusWashington--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusLondres++;
				    if(VirusLondres >= 4) {
				        VirusLondres--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusMadrid++;
				    if(VirusMadrid >= 4) {
				        VirusMadrid--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				}
				}

				if(WashingtonCuarentena == false) {
				    int SumarVirusWashington = SumarVirus("Washington");
				    VirusWashington = VirusWashington + SumarVirusWashington;
				    if(SumarVirusWashington == 1) {
				        ExclamationApeares(WashingtonExclamation);
				    }
				if(VirusWashington >= 4) {
				    VirusWashington--;
				    VirusMontreal++;
				    if(VirusMontreal >= 4) {
				        VirusMontreal--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusNuevaYork++;
				    if(VirusNuevaYork >= 4) {
				        VirusNuevaYork--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusAtlanta++;
				    if(VirusAtlanta >= 4) {
				        VirusAtlanta--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusMiami++;
				    if(VirusMiami >= 4) {
				        VirusMiami--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				}
				}

				if(LondresCuarentena == false) {
				    int SumarVirusLondres = SumarVirus("Londres");
				    VirusLondres = VirusLondres + SumarVirusLondres;
				    if(SumarVirusLondres == 1) {
				        ExclamationApeares(LondresExclamation);
				    }
				if(VirusLondres >= 4) {
				    VirusLondres--;
				    VirusNuevaYork++;
				    if(VirusNuevaYork >= 4) {
				        VirusNuevaYork--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusMadrid++;
				    if(VirusMadrid >= 4) {
				        VirusMadrid--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusParis++;
				    if(VirusParis >= 4) {
				        VirusParis--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusEssen++;
				    if(VirusEssen >= 4) {
				        VirusEssen--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				}
				}
				
				if(MadridCuarentena == false) {
				    int SumarVirusMadrid = SumarVirus("Madrid");
				    VirusMadrid = VirusMadrid + SumarVirusMadrid;
				    if(SumarVirusMadrid == 1) {
				        ExclamationApeares(MadridExclamation);
				    }
				if(VirusMadrid >= 4) {
				    VirusMadrid--;
				    VirusNuevaYork++;
				    if(VirusNuevaYork >= 4) {
				        VirusNuevaYork--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				    VirusLondres++;
				    if(VirusLondres >= 4) {
				        VirusLondres--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				    VirusParis++;
				    if(VirusParis >= 4) {
				        VirusParis--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusSaoPaulo++;
				    if(VirusSaoPaulo >= 4) {
				        VirusSaoPaulo--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusArgel++;
				    if(VirusArgel >= 4) {
				        VirusArgel--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				}
				}

				if(ParisCuarentena == false) {
				    int SumarVirusParis = SumarVirus("Paris");
				    VirusParis = VirusParis + SumarVirusParis;
				    if(SumarVirusParis == 1) {
				        ExclamationApeares(ParisExclamation);
				    }
				if(VirusParis >= 4) {
				    VirusParis--;
				    VirusMadrid ++;
				    if(VirusMadrid >= 4) {
				        VirusMadrid--;
				        Niveles ++;
				        asignarNivel(Niveles);
				    } 
				    VirusLondres ++;
				    if(VirusLondres >= 4) {
				        VirusLondres--;
				        Niveles ++;
				        asignarNivel(Niveles);
				    } 
				    VirusEssen++;
				    if(VirusEssen >= 4) {
				        VirusEssen--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusArgel++;
				    if(VirusArgel >= 4) {
				        VirusArgel--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusMilan++;
				    if(VirusMilan >= 4) {
				        VirusMilan--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				}
				}

				if(EssenCuarentena == false) {
				    int SumarVirusEssen = SumarVirus("Essen");
				    VirusEssen = VirusEssen + SumarVirusEssen;
				    if(SumarVirusEssen == 1) {
				        ExclamationApeares(EssenExclamation);
				    }
				if(VirusEssen >= 4) {
				    VirusEssen--;
				    VirusLondres++;
				    if(VirusLondres >= 4) {
				        VirusLondres--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusParis++;
				    if(VirusParis >= 4) {
				        VirusParis--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusSanPetersburgo++;
				    if(VirusSanPetersburgo >= 4) {
				        VirusSanPetersburgo--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusMilan++;
				    if(VirusMilan >= 4) {
				        VirusMilan--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				}
				}

				if(MilanCuarentena == false) {
				    int SumarVirusMilan = SumarVirus("Milan");
				    VirusMilan = VirusMilan + SumarVirusMilan;
				    if(SumarVirusMilan == 1) {
				        ExclamationApeares(MilanExclamation);
				    }
				if(VirusMilan >= 4) {
				    VirusMilan--;
				    VirusEssen++;
				    if(VirusEssen >= 4) {
				        VirusEssen--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusParis++;
				    if(VirusParis >= 4) {
				        VirusParis--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusEstambul++;
				    if(VirusEstambul >= 4) {
				        VirusEstambul--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				}
				}

				if(SanPetersburgoCuarentena == false) {
				    int SumarVirusSanPetersburgo = SumarVirus("SanPetersburgo");
				    VirusSanPetersburgo = VirusSanPetersburgo + SumarVirusSanPetersburgo;
				    if(SumarVirusSanPetersburgo == 1) {
				        ExclamationApeares(SanPetersburgoExclamation);
				    }
				if(VirusSanPetersburgo >= 4) {
				    VirusSanPetersburgo--;
				    VirusEssen++;
				    if(VirusEssen >= 4) {
				        VirusEssen--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				    VirusEstambul++;
				    if(VirusEstambul >= 4) {
				        VirusEstambul--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusMoscu++;
				    if(VirusMoscu >= 4) {
				        VirusMoscu--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				}
				}

				if(LosAngelesCuarentena == false) {
				    int SumarVirusLosAngeles = SumarVirus("LosAngeles");
				    VirusLosAngeles = VirusLosAngeles + SumarVirusLosAngeles;
				    if(SumarVirusLosAngeles == 1) {
				        ExclamationApeares(LosAngelesExclamation);
				    }
				if(VirusLosAngeles >= 4) {
				    VirusLosAngeles--;
				    VirusMexico++;
				    if(VirusMexico >= 4) {
				        VirusMexico--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusManila++;
				    if(VirusManila >= 4) {
				        VirusManila--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusSidney++;
				    if(VirusSidney >= 4) {
				        VirusSidney--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				}
				}

				if(MiamiCuarentena == false) {
				    int SumarVirusMiami = SumarVirus("Miami");
				    VirusMiami = VirusMiami + SumarVirusMiami;
				    if(SumarVirusMiami == 1) {
				        ExclamationApeares(MiamiExclamation);
				    }
				if(VirusMiami >= 4) {
				    VirusMiami--;
				    VirusWashington++;
				    if(VirusWashington >= 4) {
				        VirusWashington--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusAtlanta++;
				    if(VirusAtlanta >= 4) {
				        VirusAtlanta--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusMexico++;
				    if(VirusMexico >= 4) {
				        VirusMexico--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusBogota++;
				    if(VirusBogota >= 4) {
				        VirusBogota--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				} 
				}

				if(MexicoCuarentena == false) {
				    int SumarVirusMexico = SumarVirus("Mexico");
				    VirusMexico = VirusMexico + SumarVirusMexico;
				    if(SumarVirusMexico == 1) {
				        ExclamationApeares(MexicoExclamation);
				    }
				if(VirusMexico >= 4) {
				    VirusMexico--;
				    VirusLosAngeles ++;
					if(VirusLosAngeles >= 4) {
					    VirusLosAngeles--;
					    Niveles ++;
					    asignarNivel(Niveles);
					} 
					VirusMiami++;
					if(VirusMiami >= 4) {
					    VirusMiami--;
					    Niveles++;
					    asignarNivel(Niveles);
					} 
					VirusChicago++;
					if(VirusChicago >= 4) {
					    VirusChicago--;
					    Niveles++;
					    asignarNivel(Niveles);
					} 
					VirusBogota++;
					if(VirusBogota >= 4) {
					    VirusBogota--;
					    Niveles++;
					    asignarNivel(Niveles);
					} 
					VirusLima++;
					if(VirusLima >= 4) {
					    VirusLima--;
					    Niveles++;
					    asignarNivel(Niveles);
					} 
				}
				}
				
				if(BogotaCuarentena == false) {
				    int SumarVirusBogota = SumarVirus("Bogota");
				    VirusBogota = VirusBogota + SumarVirusBogota;
				    if(SumarVirusBogota == 1) {
				        ExclamationApeares(BogotaExclamation);
				    }
				if(VirusBogota >= 4) {
				    VirusBogota--;
				    VirusMiami++;
				    if(VirusMiami >= 4) {
				        VirusMiami--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusMexico++;
				    if(VirusMexico >= 4) {
				        VirusMexico--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusLima++;
				    if(VirusLima >= 4) {
				        VirusLima--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusSaoPaulo++;
				    if(VirusSaoPaulo >= 4) {
				        VirusSaoPaulo--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusBuenosAires++;
				    if(VirusBuenosAires >= 4) {
				        VirusBuenosAires--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				}
				}
				
				if(LimaCuarentena == false) {
				    int SumarVirusLima = SumarVirus("Lima");
				    VirusLima = VirusLima + SumarVirusLima;
				    if(SumarVirusLima == 1) {
				        ExclamationApeares(LimaExclamation);
				    }
				if(VirusLima >= 4) {
				    VirusLima--;
				    VirusMexico++;
				    if(VirusMexico >= 4) {
				        VirusMexico--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				    VirusBogota++;
				    if(VirusBogota >= 4) {
				        VirusBogota--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusSantiago++;
				    if(VirusSantiago >= 4) {
				        VirusSantiago--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				}
				}
				
				if(SantiagoCuarentena == false) {
				    int SumarVirusSantiago = SumarVirus("Santiago");
				    VirusSantiago = VirusSantiago + SumarVirusSantiago;
				    if(SumarVirusSantiago == 1) {
				        ExclamationApeares(SantiagoExclamation);
				    }
				if(VirusSantiago >= 4) {
				    VirusSantiago--;
				    VirusLima++;
				    if(VirusLima >= 4) {
				        VirusLima--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				}
				}

				if(BuenosAiresCuarentena == false) {
				    int SumarVirusBuenosAires = SumarVirus("BuenosAires");
				    VirusBuenosAires = VirusBuenosAires + SumarVirusBuenosAires;
				    if(SumarVirusBuenosAires == 1) {
				        ExclamationApeares(BuenosAiresExclamation);
				    }
				if(VirusBuenosAires >= 4) {
				    VirusBuenosAires--;
				    VirusSaoPaulo++;
				    if(VirusSaoPaulo >= 4) {
				        VirusSaoPaulo--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				    VirusBogota++;
				    if(VirusBogota >= 4) {
				        VirusBogota--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				}
				}

				if(SaoPauloCuarentena == false) {
				    int SumarVirusSaoPaulo = SumarVirus("SaoPaulo");
				    VirusSaoPaulo = VirusSaoPaulo + SumarVirusSaoPaulo;
				    if(SumarVirusSaoPaulo == 1) {
				        ExclamationApeares(SaoPauloExclamation);
				    }
				if(VirusSaoPaulo >= 4) {
				    VirusSaoPaulo--;
				    VirusBogota++;
				    if(VirusBogota >= 4) {
				        VirusBogota--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				    VirusBuenosAires++;
				    if(VirusBuenosAires >= 4) {
				        VirusBuenosAires--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusLagos++;
				    if(VirusLagos >= 4) {
				        VirusLagos--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				    VirusMadrid++;
				    if(VirusMadrid >= 4) {
				        VirusMadrid--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				}
				}
				
				if(LagosCuarentena == false) {
				    int SumarVirusLagos = SumarVirus("Lagos");
				    VirusLagos = VirusLagos + SumarVirusLagos;
				    if(SumarVirusLagos == 1) {
				        ExclamationApeares(LagosExclamation);
				    }
				if(VirusLagos >= 4) {
				    VirusLagos--;
				    VirusSaoPaulo++;
				    if(VirusSaoPaulo >= 4) {
				        VirusSaoPaulo--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusKinsasa++;
				    if(VirusKinsasa >= 4) {
				        VirusKinsasa--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusJartum++;
				    if(VirusJartum >= 4) {
				        VirusJartum--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				} 
				}
				
				if(KinsasaCuarentena == false) {
				    int SumarVirusKinsasa = SumarVirus("Kinsasa");
				    VirusKinsasa = VirusKinsasa + SumarVirusKinsasa;
				    if(SumarVirusKinsasa == 1) {
				        ExclamationApeares(KinsasaExclamation);
				    }
				if(VirusKinsasa >= 4) {
				    VirusKinsasa--;
				    VirusLagos++;
				    if(VirusLagos >= 4) {
				        VirusLagos--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusJartum++;
				    if(VirusJartum >= 4) {
				        VirusJartum--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusJohannesburgo++;
				    if(VirusJohannesburgo >= 4) {
				        VirusJohannesburgo--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				} 
				}
				
				if(JartumCuarentena == false) {
				    int SumarVirusJartum = SumarVirus("Jartum");
				    VirusJartum = VirusJartum + SumarVirusJartum;
				    if(SumarVirusJartum == 1) {
				        ExclamationApeares(JartumExclamation);
				    }
				if(VirusJartum >= 4) {
				    VirusJartum--;
				    VirusCairo++;
				    if(VirusCairo >= 4) {
				        VirusCairo--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusLagos++;
				    if(VirusLagos >= 4) {
				        VirusLagos--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				    VirusKinsasa++;
				    if(VirusKinsasa >= 4) {
				        VirusKinsasa--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusJohannesburgo++;
				    if(VirusJohannesburgo >= 4) {
				        VirusJohannesburgo--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				} 
				}
				
				if(JohannesburgoCuarentena == false) {
				    int SumarVirusJohannesburgo = SumarVirus("Johannesburgo");
				    VirusJohannesburgo = VirusJohannesburgo + SumarVirusJohannesburgo;
				    if(SumarVirusJohannesburgo == 1) {
				        ExclamationApeares(JohannesburgoExclamation);
				    }
				if(VirusJohannesburgo >= 4) {
				    VirusJohannesburgo--;
				    VirusKinsasa++;
				    if(VirusKinsasa >= 4) {
				        VirusKinsasa--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				    VirusJartum++;
				    if(VirusJartum >= 4) {
				        VirusJartum--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				} 
				}
				
				if(ArgelCuarentena == false) {
				    int SumarVirusArgel = SumarVirus("Argel");
				    VirusArgel = VirusArgel + SumarVirusArgel;
				    if(SumarVirusArgel == 1) {
				        ExclamationApeares(ArgelExclamation);
				    }
				if(VirusArgel >= 4) {
				    VirusArgel--;
				    VirusMadrid++;
				    if(VirusMadrid >= 4) {
				        VirusMadrid--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				    VirusParis++;
				    if(VirusParis >= 4) {
				        VirusParis--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusEstambul++;
				    if(VirusEstambul >= 4) {
				        VirusEstambul--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				    VirusCairo++;
				    if(VirusCairo >= 4) {
				        VirusCairo--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				} 
				}

				if(CairoCuarentena == false) {
				    int SumarVirusCairo = SumarVirus("Cairo");
				    VirusCairo = VirusCairo + SumarVirusCairo;
				    if(SumarVirusCairo == 1) {
				        ExclamationApeares(CairoExclamation);
				    }
				if(VirusCairo >= 4) {
				    VirusCairo--;
				    VirusArgel++;
				    if(VirusArgel >= 4) {
				        VirusArgel--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusEstambul++;
				    if(VirusEstambul >= 4) {
				        VirusEstambul--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusBagdad++;
				    if(VirusBagdad >= 4) {
				        VirusBagdad--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				}
				}

				if(RiadCuarentena == false) {
				    int SumarVirusRiad = SumarVirus("Riad");
				    VirusRiad = VirusRiad + SumarVirusRiad;
				    if(SumarVirusRiad == 1) {
				        ExclamationApeares(RiadExclamation);
				    }
				if(VirusRiad >= 4) {
				    VirusRiad--;
				    VirusCairo++;
				    if(VirusCairo >= 4) {
				        VirusCairo--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				    VirusBagdad++;
				    if(VirusBagdad >= 4) {
				        VirusBagdad--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusKarachi++;
				    if(VirusKarachi >= 4) {
				        VirusKarachi--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				} 
				}

				if(EstambulCuarentena == false) {
				    int SumarVirusEstambul = SumarVirus("Estambul");
				    VirusEstambul = VirusEstambul + SumarVirusEstambul;
				    if(SumarVirusEstambul == 1) {
				        ExclamationApeares(EstambulExclamation);
				    }
				if(VirusEstambul >= 4) {
				    VirusEstambul--;
				    VirusArgel++;
				    if(VirusArgel >= 4) {
				        VirusArgel--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				    VirusMoscu++;
				    if(VirusMoscu >= 4) {
				        VirusMoscu--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				    VirusBagdad++;
				    if(VirusBagdad >= 4) {
				        VirusBagdad--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				    VirusCairo++;
				    if(VirusCairo >= 4) {
				        VirusCairo--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				}
				}

				if(BagdadCuarentena == false) {
				    int SumarVirusBagdad = SumarVirus("Bagdad");
				    VirusBagdad = VirusBagdad + SumarVirusBagdad;
				    if(SumarVirusBagdad == 1) {
				        ExclamationApeares(BagdadExclamation);
				    }
				if(VirusBagdad >= 4) {
				    VirusBagdad--;
				    VirusEstambul++;
				    if(VirusEstambul >= 4) {
				        VirusEstambul--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusKarachi++;
				    if(VirusKarachi >= 4) {
				        VirusKarachi--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusRiad++;
				    if(VirusRiad >= 4) {
				        VirusRiad--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusCairo++;
				    if(VirusCairo >= 4) {
				        VirusCairo--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				} 
				}

				if(MoscuCuarentena == false) {
				    int SumarVirusMoscu = SumarVirus("Moscu");
				    VirusMoscu = VirusMoscu + SumarVirusMoscu;
				    if(SumarVirusMoscu == 1) {
				        ExclamationApeares(MoscuExclamation);
				    }
				if(VirusMoscu >= 4) {
				    VirusMoscu--;
				    VirusTeheran++;
				    if(VirusTeheran >= 4) {
				        VirusTeheran--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusEstambul++;
				    if(VirusEstambul >= 4) {
				        VirusEstambul--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusSanPetersburgo++;
				    if(VirusSanPetersburgo >= 4) {
				        VirusSanPetersburgo--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				} 
				}

				if(TeheranCuarentena == false) {
				    int SumarVirusTeheran = SumarVirus("Teheran");
				    VirusTeheran = VirusTeheran + SumarVirusTeheran;
				    if(SumarVirusTeheran == 1) {
				        ExclamationApeares(TeheranExclamation);
				    }
				if(VirusTeheran >= 4) {
				    VirusTeheran--;
				    VirusMoscu++;
				    if(VirusMoscu >= 4) {
				        VirusMoscu--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusBagdad++;
				    if(VirusBagdad >= 4) {
				        VirusBagdad--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				    VirusKarachi++;
				    if(VirusKarachi >= 4) {
				        VirusKarachi--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusNuevaDelhi++;
				    if(VirusNuevaDelhi >= 4) {
				        VirusNuevaDelhi--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				} 
				}

				if(KarachiCuarentena == false) {
				    int SumarVirusKarachi = SumarVirus("Karachi");
				    VirusKarachi = VirusKarachi + SumarVirusKarachi;
				    if(SumarVirusKarachi == 1) {
				        ExclamationApeares(KarachiExclamation);
				    }
				if(VirusKarachi >= 4) {
				    VirusKarachi--;
				    VirusTeheran++;
				    if(VirusTeheran >= 4) {
				        VirusTeheran--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusBagdad++;
				    if(VirusBagdad >= 4) {
				        VirusBagdad--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusNuevaDelhi++;
				    if(VirusNuevaDelhi >= 4) {
				        VirusNuevaDelhi--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusRiad++;
				    if(VirusRiad >= 4) {
				        VirusRiad--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusBombay++;
				    if(VirusBombay >= 4) {
				        VirusBombay--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				} 
				}

				if(BombayCuarentena == false) {
				    int SumarVirusBombay = SumarVirus("Bombay");
				    VirusBombay = VirusBombay + SumarVirusBombay;
				    if(SumarVirusBombay == 1) {
				        ExclamationApeares(BombayExclamation);
				    }
				if(VirusBombay >= 4) {
				    VirusBombay--;
				    VirusKarachi++;
				    if(VirusKarachi >= 4) {
				        VirusKarachi--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusNuevaDelhi++;
				    if(VirusNuevaDelhi >= 4) {
				        VirusNuevaDelhi--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusMadras++;
				    if(VirusMadras >= 4) {
				        VirusMadras--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				} 
				}
				
				if(NuevaDelhiCuarentena == false) {
				    int SumarVirusNuevaDelhi = SumarVirus("NuevaDelhi");
				    VirusNuevaDelhi = VirusNuevaDelhi + SumarVirusNuevaDelhi;
				    if(SumarVirusNuevaDelhi == 1) {
				        ExclamationApeares(NuevaDelhiExclamation);
				    }
				if(VirusNuevaDelhi >= 4) {
				    VirusNuevaDelhi--;
				    VirusTeheran++;
				    if(VirusTeheran >= 4) {
				        VirusTeheran--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusKarachi++;
				    if(VirusKarachi >= 4) {
				        VirusKarachi--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusBombay++;
				    if(VirusBombay >= 4) {
				        VirusBombay--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusMadras++;
				    if(VirusMadras >= 4) {
				        VirusMadras--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusCalcuta++;
				    if(VirusCalcuta >= 4) {
				        VirusCalcuta--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				} 
				}
				
				if(CalcutaCuarentena == false) {
				    int SumarVirusCalcuta = SumarVirus("Calcuta");
				    VirusCalcuta = VirusCalcuta + SumarVirusCalcuta;
				    if(SumarVirusCalcuta == 1) {
				        ExclamationApeares(CalcutaExclamation);
				    }
				if(VirusCalcuta >= 4) {
				    VirusCalcuta--;
				    VirusNuevaDelhi++;
				    if(VirusNuevaDelhi >= 4) {
				        VirusNuevaDelhi--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				    VirusHongKong++;
				    if(VirusHongKong >= 4) {
				        VirusHongKong--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				    VirusMadras++;
				    if(VirusMadras >= 4) {
				        VirusMadras--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusBangkok++;
				    if(VirusBangkok >= 4) {
				        VirusBangkok--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				} 
				}

				if(MadrasCuarentena == false) {
				    int SumarVirusMadras = SumarVirus("Madras");
				    VirusMadras = VirusMadras + SumarVirusMadras;
				    if(SumarVirusMadras == 1) {
				        ExclamationApeares(MadrasExclamation);
				    }
				if(VirusMadras >= 4) {
				    VirusMadras--;
				    VirusBombay++;
				    if(VirusBombay >= 4) {
				        VirusBombay--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusNuevaDelhi++;
				    if(VirusNuevaDelhi >= 4) {
				        VirusNuevaDelhi--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusCalcuta++;
				    if(VirusCalcuta >= 4) {
				        VirusCalcuta--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusBangkok++;
				    if(VirusBangkok >= 4) {
				        VirusBangkok--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusYakarta++;
				    if(VirusYakarta >= 4) {
				        VirusYakarta--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				}
				}
				
				if(YakartaCuarentena == false) {
				    int SumarVirusYakarta = SumarVirus("Yakarta");
				    VirusYakarta = VirusYakarta + SumarVirusYakarta;
				    if(SumarVirusYakarta == 1) {
				        ExclamationApeares(YakartaExclamation);
				    }
				if(VirusYakarta >= 4) {
				    VirusYakarta--;
				    VirusMadras++;
				    if(VirusMadras >= 4) {
				        VirusMadras--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusBangkok++;
				    if(VirusBangkok >= 4) {
				        VirusBangkok--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusHoChiMinh++;
				    if(VirusHoChiMinh >= 4) {
				        VirusHoChiMinh--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusSidney++;
				    if(VirusSidney >= 4) {
				        VirusSidney--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				} 
				}
				
				if(BangkokCuarentena == false) {
				    int SumarVirusBangkok = SumarVirus("Bangkok");
				    VirusBangkok = VirusBangkok + SumarVirusBangkok;
				    if(SumarVirusBangkok == 1) {
				        ExclamationApeares(BangkokExclamation);
				    }
				if(VirusBangkok >= 4) {
				    VirusBangkok--;
				    VirusYakarta++;
				    if(VirusYakarta >= 4) {
				        VirusYakarta--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusCalcuta++;
				    if(VirusCalcuta >= 4) {
				        VirusCalcuta--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusMadras++;
				    if(VirusMadras >= 4) {
				        VirusMadras--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusHoChiMinh++;
				    if(VirusHoChiMinh >= 4) {
				        VirusHoChiMinh--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusHongKong++;
				    if(VirusHongKong >= 4) {
				        VirusHongKong--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				} 
				}

				if(HongKongCuarentena == false) {
				    int SumarVirusHongKong = SumarVirus("HongKong");
				    VirusHongKong = VirusHongKong + SumarVirusHongKong;
				    if(SumarVirusHongKong == 1) {
				        ExclamationApeares(HongKongExclamation);
				    }
				if(VirusHongKong >= 4) {
				    VirusHongKong--;
				    VirusBangkok++;
				    if(VirusBangkok >= 4) {
				        VirusBangkok--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusHoChiMinh++;
				    if(VirusHoChiMinh >= 4) {
				        VirusHoChiMinh--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusTaipei++;
				    if(VirusTaipei >= 4) {
				        VirusTaipei--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusManila++;
				    if(VirusManila >= 4) {
				        VirusManila--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusShanghai++;
				    if(VirusShanghai >= 4) {
				        VirusShanghai--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				}
				}
				
				if(ShanghaiCuarentena == false) {
				    int SumarVirusShanghai = SumarVirus("Shanghai");
				    VirusShanghai = VirusShanghai + SumarVirusShanghai;
				    if(SumarVirusShanghai == 1) {
				        ExclamationApeares(ShanghaiExclamation);
				    }
				if(VirusShanghai >= 4) {
				    VirusShanghai--;
				    VirusPekin++;
				    if(VirusPekin >= 4) {
				        VirusPekin--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusHongKong++;
				    if(VirusHongKong >= 4) {
				        VirusHongKong--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				    VirusSeul++;
				    if(VirusSeul >= 4) {
				        VirusSeul--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusTokio++;
				    if(VirusTokio >= 4) {
				        VirusTokio--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusTaipei++;
				    if(VirusTaipei >= 4) {
				        VirusTaipei--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				}
				}
				
				if(PekinCuarentena == false) {
				    int SumarVirusPekin = SumarVirus("Pekin");
				    VirusPekin = VirusPekin + SumarVirusPekin;
				    if(SumarVirusPekin == 1) {
				        ExclamationApeares(PekinExclamation);
				    }
				if(VirusPekin >= 4) {
				    VirusPekin--;
				    VirusSeul++;
				    if(VirusSeul >= 4) {
				        VirusSeul--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusShanghai++;
				    if(VirusShanghai >= 4) {
				        VirusShanghai--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				} 
				}

				if(SeulCuarentena == false) {
				    int SumarVirusSeul = SumarVirus("Seul");
				    VirusSeul = VirusSeul + SumarVirusSeul;
				    if(SumarVirusSeul == 1) {
				        ExclamationApeares(SeulExclamation);
				    }
				if(VirusSeul >= 4) {
				    VirusSeul--;
				    VirusPekin++;
				    if(VirusPekin >= 4) {
				        VirusPekin--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusTokio++;
				    if(VirusTokio >= 4) {
				        VirusTokio--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				} 
				}
				
				if(TokioCuarentena == false) {
				    int SumarVirusTokio = SumarVirus("Tokio");
				    VirusTokio = VirusTokio + SumarVirusTokio;
				    if(SumarVirusTokio == 1) {
				        ExclamationApeares(TokioExclamation);
				    }
				if(VirusTokio >= 4) {
				    VirusTokio--;
				    VirusSanFrancisco++;
				    if(VirusSanFrancisco >= 4) {
				        VirusSanFrancisco--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusSeul++;
				    if(VirusSeul >= 4) {
				        VirusSeul--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusOsaka++;
				    if(VirusOsaka >= 4) {
				        VirusOsaka--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusShanghai++;
				    if(VirusShanghai >= 4) {
				        VirusShanghai--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				} 
				}

				if(OsakaCuarentena == false) {
				    int SumarVirusOsaka = SumarVirus("Osaka");
				    VirusOsaka = VirusOsaka + SumarVirusOsaka;
				    if(SumarVirusOsaka == 1) {
				        ExclamationApeares(OsakaExclamation);
				    }
				if(VirusOsaka >= 4) {
				    VirusOsaka--;
				    VirusTokio++;
				    if(VirusTokio >= 4) {
				        VirusTokio--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusTaipei++;
				    if(VirusTaipei >= 4) {
				        VirusTaipei--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				}
				}

				if(TaipeiCuarentena == false) {
				    int SumarVirusTaipei = SumarVirus("Taipei");
				    VirusTaipei = VirusTaipei + SumarVirusTaipei;
				    if(SumarVirusTaipei == 1) {
				        ExclamationApeares(TaipeiExclamation);
				    }
				if(VirusTaipei >= 4) {
				    VirusTaipei--;
				    VirusOsaka++;
				    if(VirusOsaka >= 4) {
				        VirusOsaka--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusShanghai++;
				    if(VirusShanghai >= 4) {
				        VirusShanghai--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusHongKong++;
				    if(VirusHongKong >= 4) {
				        VirusHongKong--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusManila++;
				    if(VirusManila >= 4) {
				        VirusManila--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				}
				}

				if(HoChiMinhCuarentena == false) {
				    int SumarVirusHoChiMinh = SumarVirus("HoChiMinh");
				    VirusHoChiMinh = VirusHoChiMinh + SumarVirusHoChiMinh;
				    if(SumarVirusHoChiMinh == 1) {
				        ExclamationApeares(HoChiMinhExclamation);
				    }
				if(VirusHoChiMinh >= 4) {
				    VirusHoChiMinh--;
				    VirusYakarta++;
				    if(VirusYakarta >= 4) {
				        VirusYakarta--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				    VirusBangkok++;
				    if(VirusBangkok >= 4) {
				        VirusBangkok--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				    VirusHongKong++;
				    if(VirusHongKong >= 4) {
				        VirusHongKong--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusManila++;
				    if(VirusManila >= 4) {
				        VirusManila--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				} 
				}

				if(ManilaCuarentena == false) {
				    int SumarVirusManila = SumarVirus("Manila");
				    VirusManila = VirusManila + SumarVirusManila;
				    if(SumarVirusManila == 1) {
				        ExclamationApeares(ManilaExclamation);
				    }
				if(VirusManila >= 4) {
				    VirusManila--;
				    VirusSanFrancisco++;
				    if(VirusSanFrancisco >= 4) {
				        VirusSanFrancisco--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusHoChiMinh++;
				    if(VirusHoChiMinh >= 4) {
				        VirusHoChiMinh--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusTaipei++;
				    if(VirusTaipei >= 4) {
				        VirusTaipei--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusHongKong++;
				    if(VirusHongKong >= 4) {
				        VirusHongKong--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusSidney++;
				    if(VirusSidney >= 4) {
				        VirusSidney--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				} 
				}

				if(SidneyCuarentena == false) {
				    int SumarVirusSidney = SumarVirus("Sidney");
				    VirusSidney = VirusSidney + SumarVirusSidney;
				    if(SumarVirusSidney == 1) {
				        ExclamationApeares(SidneyExclamation);
				    }
				if(VirusSidney >= 4) {
				    VirusSidney--;
				    VirusLosAngeles++;
				    if(VirusLosAngeles >= 4) {
				        VirusLosAngeles--;
				        Niveles++;
				        asignarNivel(Niveles);
				    }
				    VirusManila++;
				    if(VirusManila >= 4) {
				        VirusManila--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				    VirusYakarta++;
				    if(VirusYakarta >= 4) {
				        VirusYakarta--;
				        Niveles++;
				        asignarNivel(Niveles);
				    } 
				} 
				}
			}
			Ronda++;
			calcularVirusTotales();
		}
	}

	private void ExclamationApeares(JLabel Exclamation) {
	    Exclamation.setVisible(true);
	    Timer timer = new Timer(6000, event -> {
	        Exclamation.setVisible(false); 
	    });
	    timer.start();
	}

	private void pintarMatraz() {
		String BotonVacuna;
		
		if(PorcentajeDesarrolloAzul >= 25 && PorcentajeDesarrolloAzul < 50 ) {
			BotonVacuna = "src/img/CuraAzul25_Boton.png";
			CuraAzul.setIcon(new ImageIcon(BotonVacuna));
		}else if(PorcentajeDesarrolloAzul >= 50 && PorcentajeDesarrolloAzul < 75) {
			BotonVacuna = "src/img/CuraAzul50_Boton.png";
			CuraAzul.setIcon(new ImageIcon(BotonVacuna));
		}else if(PorcentajeDesarrolloAzul >= 75 && PorcentajeDesarrolloAzul < 100) {
			BotonVacuna = "src/img/CuraAzul75_Boton.png";
			CuraAzul.setIcon(new ImageIcon(BotonVacuna));
		}else if(PorcentajeDesarrolloAzul >= 100) {
			BotonVacuna = "src/img/CuraAzul100_Boton.png";
			CuraAzul.setIcon(new ImageIcon(BotonVacuna));
		}
		if(PorcentajeDesarrolloAmarillo >= 25 && PorcentajeDesarrolloAmarillo < 50 ) {
			BotonVacuna = "src/img/CuraAmarillo25_Boton.png";
			CuraAmarillo.setIcon(new ImageIcon(BotonVacuna));
		}else if(PorcentajeDesarrolloAmarillo >= 50 && PorcentajeDesarrolloAmarillo < 75) {
			BotonVacuna = "src/img/CuraAmarillo50_Boton.png";
			CuraAmarillo.setIcon(new ImageIcon(BotonVacuna));
		}else if(PorcentajeDesarrolloAmarillo >= 75 && PorcentajeDesarrolloAmarillo < 100) {
			BotonVacuna = "src/img/CuraAmarillo75_Boton.png";
			CuraAmarillo.setIcon(new ImageIcon(BotonVacuna));
		}else if(PorcentajeDesarrolloAmarillo >= 100) {
			BotonVacuna = "src/img/CuraAmarillo100_Boton.png";
			CuraAmarillo.setIcon(new ImageIcon(BotonVacuna));
		}
		if(PorcentajeDesarrolloNegro >= 25 && PorcentajeDesarrolloNegro < 50 ) {
			BotonVacuna = "src/img/CuraNegro25_Boton.png";
			CuraNegro.setIcon(new ImageIcon(BotonVacuna));
		}else if(PorcentajeDesarrolloNegro >= 50 && PorcentajeDesarrolloNegro < 75) {
			BotonVacuna = "src/img/CuraNegro50_Boton.png";
			CuraNegro.setIcon(new ImageIcon(BotonVacuna));
		}else if(PorcentajeDesarrolloNegro >= 75 && PorcentajeDesarrolloNegro < 100) {
			BotonVacuna = "src/img/CuraNegro75_Boton.png";
			CuraNegro.setIcon(new ImageIcon(BotonVacuna));
		}else if(PorcentajeDesarrolloNegro >= 100) {
			BotonVacuna = "src/img/CuraNegro100_Boton.png";
			CuraNegro.setIcon(new ImageIcon(BotonVacuna));
		}
		if(PorcentajeDesarrolloRojo >= 25 && PorcentajeDesarrolloRojo < 50 ) {
			BotonVacuna = "src/img/CuraRojo25_Boton.png";
			CuraRojo.setIcon(new ImageIcon(BotonVacuna));
		}else if(PorcentajeDesarrolloRojo >= 50 && PorcentajeDesarrolloRojo < 75) {
			BotonVacuna = "src/img/CuraRojo50_Boton.png";
			CuraRojo.setIcon(new ImageIcon(BotonVacuna));
		}else if(PorcentajeDesarrolloRojo >= 75 && PorcentajeDesarrolloRojo < 100) {
			BotonVacuna = "src/img/CuraRojo75_Boton.png";
			CuraRojo.setIcon(new ImageIcon(BotonVacuna));
		}else if(PorcentajeDesarrolloRojo >= 100) {
			BotonVacuna = "src/img/CuraRojo100_Boton.png";
			CuraRojo.setIcon(new ImageIcon(BotonVacuna));
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
		String ImagenColores;
		if (e.getSource() == SanFrancisco) {
	        VirusActual.setText("San Francisco = " + VirusSanFrancisco);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Chicago) {
	        VirusActual.setText("Chicago = " + VirusChicago);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Atlanta) {
	        VirusActual.setText("Atlanta = " + VirusAtlanta);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Montreal) {
	        VirusActual.setText("Montreal = " + VirusMontreal);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == NuevaYork) {
	        VirusActual.setText("Nueva York = " + VirusNuevaYork);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Washington) {
	        VirusActual.setText("Washington = " + VirusWashington);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Londres) {
	        VirusActual.setText("Londres = " + VirusLondres);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Madrid) {
	        VirusActual.setText("Madrid = " + VirusMadrid);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Paris) {
	        VirusActual.setText("París = " + VirusParis);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Essen) {
	        VirusActual.setText("Essen = " + VirusEssen);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Milan) {
	        VirusActual.setText("Milán = " + VirusMilan);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == SanPetersburgo) {
	        VirusActual.setText("San Petersburgo = " + VirusSanPetersburgo);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == LosAngeles) {
	        VirusActual.setText("Los Ángeles = " + VirusLosAngeles);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Miami) {
	        VirusActual.setText("Miami = " + VirusMiami);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Mexico) {
	        VirusActual.setText("México = " + VirusMexico);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Bogota) {
	        VirusActual.setText("Bogotá = " + VirusBogota);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Lima) {
	        VirusActual.setText("Lima = " + VirusLima);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Santiago) {
	        VirusActual.setText("Santiago de Chile = " + VirusSantiago);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == BuenosAires) {
	        VirusActual.setText("Buenos Aires = " + VirusBuenosAires);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == SaoPaulo) {
	        VirusActual.setText("Sao Paulo = " + VirusSaoPaulo);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Lagos) {
	        VirusActual.setText("Lagos = " + VirusLagos);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Kinsasa) {
	        VirusActual.setText("Kinsasa = " + VirusKinsasa);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Jartum) {
	        VirusActual.setText("Jartum = " + VirusJartum);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Johannesburgo) {
	        VirusActual.setText("Johannesburgo = " + VirusJohannesburgo);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Argel) {
	        VirusActual.setText("Argel = " + VirusArgel);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Cairo) {
	        VirusActual.setText("El Cairo = " + VirusCairo);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Riad) {
	        VirusActual.setText("Riad = " + VirusRiad);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Estambul) {
	        VirusActual.setText("Estambul = " + VirusEstambul);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Bagdad) {
	        VirusActual.setText("Bagdad = " + VirusBagdad);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Moscu) {
	        VirusActual.setText("Moscú = " + VirusMoscu);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Teheran) {
	        VirusActual.setText("Teherán = " + VirusTeheran);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Karachi) {
	        VirusActual.setText("Karachi = " + VirusKarachi);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Bombay) {
	        VirusActual.setText("Bombay = " + VirusBombay);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == NuevaDelhi) {
	        VirusActual.setText("Nueva Delhi = " + VirusNuevaDelhi);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Calcuta) {
	        VirusActual.setText("Calcuta = " + VirusCalcuta);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Madras) {
	        VirusActual.setText("Madras = " + VirusMadras);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Yakarta) {
	        VirusActual.setText("Yakarta = " + VirusYakarta);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Bangkok) {
	        VirusActual.setText("Bangkok = " + VirusBangkok);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == HongKong) {
	        VirusActual.setText("Hong Kong = " + VirusHongKong);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Shanghai) {
	        VirusActual.setText("Shanghai = " + VirusShanghai);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Pekin) {
	        VirusActual.setText("Pekín = " + VirusPekin);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Seul) {
	        VirusActual.setText("Seúl = " + VirusSeul);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Tokio) {
	        VirusActual.setText("Tokio = " + VirusTokio);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Osaka) {
	        VirusActual.setText("Osaka = " + VirusOsaka);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Taipei) {
	        VirusActual.setText("Taipéi = " + VirusTaipei);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == HoChiMinh) {
	        VirusActual.setText("Ho Chi Minh = " + VirusHoChiMinh);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Manila) {
	        VirusActual.setText("Manila = " + VirusManila);
	        VirusActual.setVisible(true);
	    } else if (e.getSource() == Sidney) {
	        VirusActual.setText("Sídney = " + VirusSidney);
	        VirusActual.setVisible(true);
	    }else if(e.getSource() == CuraAzul) {
			CuraAzul.setBorder(BorderFactory.createEmptyBorder(10, 0, 25, 0));
		}else if(e.getSource() == CuraAmarillo) {
			CuraAmarillo.setBorder(BorderFactory.createEmptyBorder(10, 0, 25, 0));
		}else if(e.getSource() == CuraRojo) {
			CuraRojo.setBorder(BorderFactory.createEmptyBorder(10, 0, 25, 0));
		}else if(e.getSource() == CuraNegro) {
			CuraNegro.setBorder(BorderFactory.createEmptyBorder(10, 0, 25, 0));
		} else if(e.getSource() == Opciones ) {
			ImagenColores = "src/img/OpcionesBotonGIF.gif";
			Opciones.setIcon(new ImageIcon(ImagenColores));
		} else if (e.getSource() == PasarTurno) {
		    String rutaImagen = "src/img/PasarTurno_Boton-Blanco.png"; 
		    ImageIcon imagenIcono = new ImageIcon(rutaImagen); 
		    PasarTurno.setIcon(new ImageIcon(imagenIcono.getImage().getScaledInstance(192, 24, java.awt.Image.SCALE_SMOOTH)));
		} else if(e.getSource() == DesarrollarCura) {
			String rutaImagen = "src/img/DesarrollarCura_Boton-Blanco.png"; 
		    ImageIcon imagenIcono = new ImageIcon(rutaImagen); 
		    DesarrollarCura.setIcon(new ImageIcon(imagenIcono.getImage().getScaledInstance(192, 48, java.awt.Image.SCALE_SMOOTH)));
		}else if(e.getSource() == Cuarentena) {
			String rutaImagen = "src/img/Cuarentena_Boton-Blanco.png"; 
		    ImageIcon imagenIcono = new ImageIcon(rutaImagen); 
		    Cuarentena.setIcon(new ImageIcon(imagenIcono.getImage().getScaledInstance(192, 48, java.awt.Image.SCALE_SMOOTH)));
		}else if(e.getSource() == CurarCiudad) {
			String rutaImagen = "src/img/CurarCiudad_Boton-Blanco.png"; 
		    ImageIcon imagenIcono = new ImageIcon(rutaImagen); 
		    CurarCiudad.setIcon(new ImageIcon(imagenIcono.getImage().getScaledInstance(192, 48, java.awt.Image.SCALE_SMOOTH)));
		}else if(e.getSource() == GuardarPartida) {
			String rutaImagen = "src/img/GuardarPartida_Boton-Blanco.png"; 
		    ImageIcon imagenIcono = new ImageIcon(rutaImagen); 
		    GuardarPartida.setIcon(new ImageIcon(imagenIcono.getImage().getScaledInstance(256, 32, java.awt.Image.SCALE_SMOOTH)));
		}else if(e.getSource() == VolverMenu) {
			String rutaImagen = "src/img/Boton-Menu-Blanco.png"; 
		    ImageIcon imagenIcono = new ImageIcon(rutaImagen); 
		    VolverMenu.setIcon(new ImageIcon(imagenIcono.getImage().getScaledInstance(128, 32, java.awt.Image.SCALE_SMOOTH)));
		}	
	}
	@Override
	public void mouseExited(MouseEvent e) {
		VirusActual.setVisible(false);
		
		CuraAzul.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		CuraAmarillo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		CuraRojo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		CuraNegro.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		String Imagen = "src/img/OpcionesBoton.png";
		Opciones.setIcon(new ImageIcon(Imagen));
	 if(e.getSource() == PasarTurno ) {
		 String rutaImagen = "src/img/PasarTurno_Boton.png"; 
		    ImageIcon imagenIcono = new ImageIcon(rutaImagen); 
		    PasarTurno.setIcon(new ImageIcon(imagenIcono.getImage().getScaledInstance(192, 24, java.awt.Image.SCALE_SMOOTH)));
	} else if(e.getSource() == DesarrollarCura){
		String rutaImagen = "src/img/DesarrollarCura_Boton.png"; 
	    ImageIcon imagenIcono = new ImageIcon(rutaImagen); 
	    DesarrollarCura.setIcon(new ImageIcon(imagenIcono.getImage().getScaledInstance(192, 48, java.awt.Image.SCALE_SMOOTH)));
	}else if(e.getSource() == Cuarentena) {
		String rutaImagen = "src/img/Cuarentena_Boton.png"; 
	    ImageIcon imagenIcono = new ImageIcon(rutaImagen); 
	    Cuarentena.setIcon(new ImageIcon(imagenIcono.getImage().getScaledInstance(192, 48, java.awt.Image.SCALE_SMOOTH)));
	}else if(e.getSource() == CurarCiudad) {
		String rutaImagen = "src/img/CurarCiudad_Boton.png"; 
	    ImageIcon imagenIcono = new ImageIcon(rutaImagen); 
	    CurarCiudad.setIcon(new ImageIcon(imagenIcono.getImage().getScaledInstance(192, 48, java.awt.Image.SCALE_SMOOTH)));
	}else if(e.getSource() == GuardarPartida) {
		String rutaImagen = "src/img/GuardarPartida_Boton.png"; 
	    ImageIcon imagenIcono = new ImageIcon(rutaImagen); 
	    GuardarPartida.setIcon(new ImageIcon(imagenIcono.getImage().getScaledInstance(256, 32, java.awt.Image.SCALE_SMOOTH)));
	}else if(e.getSource() == VolverMenu) {
		String rutaImagen = "src/img/Boton-Menu.png"; 
	    ImageIcon imagenIcono = new ImageIcon(rutaImagen); 
	    VolverMenu.setIcon(new ImageIcon(imagenIcono.getImage().getScaledInstance(128, 32, java.awt.Image.SCALE_SMOOTH)));
	}
	}
	public static int getPuntuacion() {
		return Puntuacion;
	}
	public static void setPuntuacion(int puntuacion) {
		Puntuacion = puntuacion;
	}
}