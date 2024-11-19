package Controlador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Modelo.ConexionDB;
import Vista.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class VentanaPrincipalGUI extends JFrame {

    private JPanel contentPane;

    public VentanaPrincipalGUI() {
     
     

		setTitle("Menú Principal");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setToolTipText("Gestion de Hotel");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);


       
		
		JLabel lblBienvenidosAlRegistro = new JLabel("Gestión del Hotel ");
		lblBienvenidosAlRegistro.setBounds(204, 35, 303, 42);
		lblBienvenidosAlRegistro.setFont(new Font("Times New Roman", Font.BOLD, 26));
		contentPane.add(lblBienvenidosAlRegistro);
		
		JLabel label = new JLabel("");

        ImageIcon iconoOriginal = new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/hotell.png"));
        // Escalar la imagen al tamaño deseado (ajustando el tamaño del JLabel)
        int anchoLabel = 160; // Ancho deseado del JLabel
        int altoLabel = 110;  // Alto deseado del JLabel
        // Escalar la imagen para que se ajuste al JLabel
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(anchoLabel, altoLabel, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        label.setIcon(iconoEscalado);
        label.setBounds(355, 110, anchoLabel, altoLabel); // Ajusta la posición y tamaño del JLabel

        // Agregar la imagen al panel
        contentPane.add(label);

		

		
		JButton btnIngresar = new JButton("Gestionar Clientes");
		btnIngresar.setBounds(70, 107, 250, 40);
		btnIngresar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/clipng.png")));
		btnIngresar.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnIngresar.setBackground(Color.WHITE);
		
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				abrirVentanaCliente();
				dispose();
			}
		});		
		contentPane.setLayout(null);

		btnIngresar.setToolTipText("Ingresar datos de usuarios");
		contentPane.add(btnIngresar);
		
		
		
		JButton btnMostrarDatos = new JButton("Gestionar Reservación");
		btnMostrarDatos.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/Registro.png")));
		btnMostrarDatos.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnMostrarDatos.setBounds(70, 168, 250, 40);
		btnMostrarDatos.setBackground(Color.WHITE);
		btnMostrarDatos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				abrirVentanaReservaciones();
				dispose();
				
			}
		});
		
		btnMostrarDatos.setToolTipText("Muestra datos del usuario");
		contentPane.add(btnMostrarDatos);
		
	
		
		
		JButton btnActualizarDatos = new JButton("Recepcionistas        ");
		btnActualizarDatos.setBounds(70, 229, 250, 40);
		btnActualizarDatos.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnActualizarDatos.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/recep.png")));
		btnActualizarDatos.setBackground(Color.WHITE);
		btnActualizarDatos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				
				mostrarRecepcionistas();
				
				
			}
		});
		
		btnActualizarDatos.setToolTipText("Actualiza  datos de usuarios");
		contentPane.add(btnActualizarDatos);
		
		
		
		JButton btnBuscarDatos = new JButton("Habitaciones            ");
		btnBuscarDatos.setBounds(70, 289, 250, 40);
		btnBuscarDatos.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnBuscarDatos.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/habi.png")));
		btnBuscarDatos.setBackground(Color.WHITE);
		btnBuscarDatos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
		
				mostrarHabitaciones(); 
			
			}
		});
		
		btnBuscarDatos.setToolTipText("Busca usuarios");
		contentPane.add(btnBuscarDatos);
		

		JButton btnEliminarDatos =  new JButton("Tipo De Habitaciones");
		btnEliminarDatos.setBounds(70, 352, 250, 40);
		btnEliminarDatos.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnEliminarDatos.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/tipoHabi.png")));
		btnEliminarDatos.setToolTipText("Elimina datos de usuarios");
		btnEliminarDatos.setBackground(Color.WHITE);
		btnEliminarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarTipoHabitacion(); 
			}
		});
		contentPane.add(btnEliminarDatos);


		
		JButton btnTipoPago =  new JButton("Tipo De Pagos       ");
		btnTipoPago.setBounds(70, 415, 250, 40);
		btnTipoPago.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnTipoPago.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/pagos.png")));
		btnTipoPago.setToolTipText("Elimina datos de usuarios");
		btnTipoPago.setBackground(Color.WHITE);
		btnTipoPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarTipoPago();
			}
		});
		contentPane.add(btnTipoPago);



		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(370, 485, 190, 40);
		btnSalir.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnSalir.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/salir.png")));
		btnSalir.setBackground(Color.WHITE);
		btnSalir.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				abrirLogin();
				dispose();
			}
				
		});
		
		btnSalir.setToolTipText("Salida del registro");
		contentPane.add(btnSalir);
		
	}

	private void abrirLogin() {
        Login ventana = new Login();
        ventana.setVisible(true);
    }
	
	private void abrirVentanaReservaciones() {

        VentanaReservacion ventanaPrincipal = new VentanaReservacion();
        ventanaPrincipal.setVisible(true);
    }

		
	private void abrirVentanaCliente() {

        VentanaCliente ventanaPrincipal = new VentanaCliente();
        ventanaPrincipal.setVisible(true);
    }


	private void mostrarRecepcionistas() {
		// Crear la ventana
		JDialog ventana = new JDialog();
		ventana.setTitle("Lista de Recepcionistas");
		ventana.setBounds(500, 200, 800, 400);
		ventana.getContentPane().setBackground(new Color(224, 255, 255));
		ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		ventana.setLayout(new BorderLayout());
	
		// Crear el modelo para la tabla
		DefaultTableModel modeloTabla = new DefaultTableModel();
	
		// Añadir columnas al modelo
		modeloTabla.addColumn("ID Empleado");
		modeloTabla.addColumn("Cédula");
		modeloTabla.addColumn("Nombre 1");
		modeloTabla.addColumn("Nombre 2");
		modeloTabla.addColumn("Apellido 1");
		modeloTabla.addColumn("Apellido 2");
		modeloTabla.addColumn("Teléfono");
		modeloTabla.addColumn("Correo");
		modeloTabla.addColumn("Salario");
	
		// Crear la tabla y vincularla con el modelo
		JTable tablaRecepcionistas = new JTable(modeloTabla);
		JScrollPane scrollPane = new JScrollPane(tablaRecepcionistas);
		ventana.add(scrollPane, BorderLayout.CENTER);
	
		// Cargar datos desde la base de datos
		try (Connection conn = ConexionDB.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery("SELECT id_empleado, cedula, nombre1, nombre2, apellido1, apellido2, telefono1, correo1, salario FROM recepcionista")) {
	
			// Llenar la tabla con los datos de la base de datos
			while (rs.next()) {
				int idEmpleado = rs.getInt("id_empleado");
				String cedula = rs.getString("cedula");
				String nombre1 = rs.getString("nombre1");
				String nombre2 = rs.getString("nombre2");
				String apellido1 = rs.getString("apellido1");
				String apellido2 = rs.getString("apellido2");
				String telefono = rs.getString("telefono1");
				String correo = rs.getString("correo1");
				double salario = rs.getDouble("salario");
	
				// Agregar una fila al modelo de la tabla
				modeloTabla.addRow(new Object[]{idEmpleado, cedula, nombre1, nombre2, apellido1, apellido2, telefono, correo, salario});
			}
	
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	
		// Botón para cerrar la ventana
		JButton btnCerrar = new JButton("Cerrar");

		btnCerrar.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnCerrar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/volver.png")));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				ventana.dispose();  }
			});
		ventana.add(btnCerrar, BorderLayout.SOUTH);
			
	
		// Hacer visible la ventana
		ventana.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
		ventana.setModal(true); // Bloquear la interacción con otras ventanas
		ventana.setVisible(true);
	}
	


	 // Método para mostrar el contenido de la tabla "habitacion"
	 private void mostrarHabitaciones() {
        // Crear la ventana
        JDialog ventana = new JDialog();
        ventana.setTitle("Lista de Habitaciones");
        ventana.setSize(600, 400);
        ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        ventana.setLayout(new BorderLayout());

        // Crear el modelo para la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();

        // Añadir columnas al modelo
        modeloTabla.addColumn("Número de Habitación");
        modeloTabla.addColumn("Tipo de Habitación");
        modeloTabla.addColumn("Precio");

        // Crear la tabla y vincularla con el modelo
        JTable tablaHabitaciones = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaHabitaciones);
        ventana.add(scrollPane, BorderLayout.CENTER);

        // Cargar datos desde la base de datos
        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT num_habitacion, tipo_habitacion, precio FROM habitacion")) {

            // Llenar la tabla con los datos de la base de datos
            while (rs.next()) {
                int numHabitacion = rs.getInt("num_habitacion");
                String tipoHabitacion = rs.getString("tipo_habitacion");
                double precio = rs.getDouble("precio");

                // Agregar una fila al modelo de la tabla
                modeloTabla.addRow(new Object[]{numHabitacion, tipoHabitacion, precio});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Botón para cerrar la ventana
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Time New Roman", Font.PLAIN, 16));
		btnCerrar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/volver.png")));
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventana.dispose();
            }
        });
        ventana.add(btnCerrar, BorderLayout.SOUTH);

        // Hacer visible la ventana
        ventana.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        ventana.setModal(true); // Bloquear la interacción con otras ventanas
        ventana.setVisible(true);
    }

    

	
// Método para mostrar el contenido de la tabla "tipo_habitacion"
private void mostrarTipoHabitacion() {
	// Crear la ventana
	JDialog ventana = new JDialog();
	ventana.setTitle("Lista de Tipos de Habitación");
	ventana.setSize(500, 300);
	ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	ventana.setLayout(new BorderLayout());

	// Crear el modelo para la tabla
	DefaultTableModel modeloTabla = new DefaultTableModel();

	// Añadir columnas al modelo
	modeloTabla.addColumn("ID Tipo Habitación");
	modeloTabla.addColumn("Tipo de Habitación");

	// Crear la tabla y vincularla con el modelo
	JTable tablaTipoHabitacion = new JTable(modeloTabla);
	JScrollPane scrollPane = new JScrollPane(tablaTipoHabitacion);
	ventana.add(scrollPane, BorderLayout.CENTER);

	// Cargar datos desde la base de datos
	try (Connection conn = ConexionDB.getConnection();
		 Statement stmt = conn.createStatement();
		 ResultSet rs = stmt.executeQuery("SELECT idtipo_habitacion, tipo_habitacion FROM tipo_habitacion")) {

		// Llenar la tabla con los datos de la base de datos
		while (rs.next()) {
			int idTipoHabitacion = rs.getInt("idtipo_habitacion");
			String tipoHabitacion = rs.getString("tipo_habitacion");

			// Agregar una fila al modelo de la tabla
			modeloTabla.addRow(new Object[]{idTipoHabitacion, tipoHabitacion});
		}

	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	}

	// Botón para cerrar la ventana
	JButton btnCerrar = new JButton("Cerrar");
	btnCerrar.setFont(new Font("Time New Roman", Font.PLAIN, 16));
	btnCerrar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/volver.png")));
	btnCerrar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ventana.dispose();
		}
	});
	ventana.add(btnCerrar, BorderLayout.SOUTH);

	// Hacer visible la ventana
	ventana.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
	ventana.setModal(true); // Bloquear la interacción con otras ventanas
	ventana.setVisible(true);
}




private void mostrarTipoPago() {
    // Crear la ventana
    JDialog ventanaTipoPago = new JDialog();
    ventanaTipoPago.setTitle("Tipos de Pago");
    ventanaTipoPago.setSize(500, 300);
    ventanaTipoPago.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    ventanaTipoPago.setLayout(new BorderLayout());

    // Crear el modelo para la tabla
    DefaultTableModel modeloTabla = new DefaultTableModel();

    // Añadir columnas al modelo
    modeloTabla.addColumn("ID Tipo Pago");
    modeloTabla.addColumn("Tipo de Pago");

    // Crear la tabla y vincularla con el modelo
    JTable tablaTipoPago = new JTable(modeloTabla);
    JScrollPane scrollPane = new JScrollPane(tablaTipoPago);
    ventanaTipoPago.add(scrollPane, BorderLayout.CENTER);

    // Cargar datos desde la base de datos
    try (Connection conn = ConexionDB.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT idtipo_pago, tipo_pago FROM tipo_pago")) {

        // Llenar la tabla con los datos de la base de datos
        while (rs.next()) {
            int idTipoPago = rs.getInt("idtipo_pago");
            String tipoPago = rs.getString("tipo_pago");

            // Agregar una fila al modelo de la tabla
            modeloTabla.addRow(new Object[]{idTipoPago, tipoPago});
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage(),
                                      "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Botón para cerrar la ventana
    JButton btnCerrar = new JButton("Cerrar");
    btnCerrar.setFont(new Font("Time New Roman", Font.PLAIN, 16));
	btnCerrar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/volver.png")));
    btnCerrar.addActionListener(e -> ventanaTipoPago.dispose());

    // Panel para el botón
    JPanel panelBoton = new JPanel();
    panelBoton.add(btnCerrar);
    ventanaTipoPago.add(panelBoton, BorderLayout.SOUTH);

    // Configurar y mostrar la ventana
    ventanaTipoPago.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    ventanaTipoPago.setVisible(true);
}



	



	

}
	