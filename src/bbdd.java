import java.sql.*;

/**
 * Clase que proporciona métodos para interactuar con una base de datos Oracle.
 */
public class bbdd {
	private static final String USER = "DAM1_2324_ESP_JOEL";
	private static final String PWD = "joel";
	// Si estáis desde casa, la url será oracle.ilerna.com y no 192.168.3.26
	private static final String URL = "jdbc:oracle:thin:@oracle.ilerna.com:1521:xe";

    /**
     * Intenta establecer una conexión a la base de datos Oracle. NO HACE FALTA QUE ENTENDAIS COMO FUNCIONA,
     * SE HACE TODO DE MANERA AUTOMÁTICA.
     *
     * @return Objeto Connection si la conexión es exitosa, null en caso contrario. LA VARIABLE QUE DEVUELVE
     * LA TENEIS QUE GUARDAR PARA LAS DEMÁS FUNCIONES
     */
	public static Connection conectarBaseDatos() {
		Connection con = null;

		System.out.println("Intentando conectarse a la base de datos");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PWD);
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver " + e);
		} catch (SQLException e) {
			System.out.println("Error en las credenciales o en la URL " + e);
		}

		System.out.println("Conectados a la base de datos");

		return con;
	}

    /**
     * Realiza una inserción en la base de datos.
     *
     * @param con Objeto Connection que representa la conexión a la base de datos.
     * @param sql Sentencia SQL de inserción que hayais creado.
     */
	public static void insert(Connection con, String sql) {
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			
			System.out.println("Insert hecho correctamente");
		} catch (SQLException e) {
			System.out.println("Ha habido un error en el Insert " + e);
		}
	}
	
    /**
     * Realiza una actualización en la base de datos.
     *
     * @param con Objeto Connection que representa la conexión a la base de datos.
     * @param sql Sentencia SQL de actualización que hayais creado.
     */
	public static void update(Connection con, String sql) {
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			
			System.out.println("Update hecho correctamente");
		} catch (SQLException e) {
			System.out.println("Ha habido un error en el Update " + e);
		}
	}
	
    /**
     * Realiza una eliminación en la base de datos.
     *
     * @param con Objeto Connection que representa la conexión a la base de datos.
     * @param sql Sentencia SQL de eliminación que hayais creado.
     */
	public static void delete(Connection con, String sql) {
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			
			System.out.println("Delete hecho correctamente");
		} catch (SQLException e) {
			System.out.println("Ha habido un error en el Delete " + e);
		}
	}
	
    /**
     * Realiza una consulta en la base de datos y devuelve los resultados como un array de Strings.
     * ADVERTENCIA, SOLO PODEIS BUSCAR RESULTADOS DE UNA SOLA FILA, SI SE ENCUENTRA MÁS DE UNA FILA
     * PUEDE DAR RESULTADOS EXTRAÑOS.
     *
     * @param con                         Objeto Connection que representa la conexión a la base de datos.
     * @param sql                         Sentencia SQL de consulta.
     * @param listaElementosSeleccionados Array de Strings con los nombres de las columnas seleccionadas.
     * @return Array de Strings con los resultados de la consulta donde cada posición es el contenido de la columna correspondiente
     */
	public static String[] select(Connection con, String sql, String[] listaElementosSeleccionados) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);


			if (rs.isBeforeFirst()) {
				String[] arrayS = new String[listaElementosSeleccionados.length];
				while (rs.next()) {
					for (int i = 0; i < listaElementosSeleccionados.length; i++) {
						arrayS[i] = rs.getString(listaElementosSeleccionados[i]);
					}
				}
				return arrayS;
			} else {
				System.out.println("No se ha encontrado nada");
				String[] arrayNull = {""};
				return arrayNull;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new String[0];
		}
	}
	
    /**
     * Imprime los resultados de una consulta SELECT en la base de datos.
     * EN ESTE CASO SI PODEIS IMPRIMIR MÁS DE UNA FILA.
     *
     * @param con                         Objeto Connection que representa la conexión a la base de datos.
     * @param sql                         Sentencia SQL de consulta.
     * @param listaElementosSeleccionados Array de Strings con los nombres de los elementos seleccionados.
     */
}
