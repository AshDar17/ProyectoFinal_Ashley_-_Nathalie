package Controlador;

import javax.swing.border.EmptyBorder;
import Modelo.ConexionDB;
import Modelo.LlamadoSP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;




public class VentanaReservacion extends JFrame {

    private JPanel contentPane;

    public VentanaReservacion() {
     
     

		setTitle("Menú reservaciones");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setToolTipText("Gestion de Hotel");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);


       
		
		JLabel lblBienvenidosAlRegistro = new JLabel("Gestión de Reservaciones");
		lblBienvenidosAlRegistro.setBounds(170, 50, 303, 42);
		lblBienvenidosAlRegistro.setFont(new Font("Times New Roman", Font.BOLD, 26));
		contentPane.add(lblBienvenidosAlRegistro);


        JButton btnIngresar = new JButton("Registrar Reservación");
		btnIngresar.setBounds(30, 200, 250, 45);
		btnIngresar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/Registro.png")));
		btnIngresar.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnIngresar.setBackground(Color.WHITE);
		
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                mostrarVentanaReservacion(); 
						dispose(); 
			}
		});		
		contentPane.setLayout(null);

		btnIngresar.setToolTipText("Registra Reservaciones");
		contentPane.add(btnIngresar);


        JButton btnMostrarDatos = new JButton("Consultar Recervasión");
		btnMostrarDatos.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/consultar.png")));
		btnMostrarDatos.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnMostrarDatos.setBounds(310, 200, 250, 45);
        btnMostrarDatos.setBackground(Color.WHITE);
		btnMostrarDatos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
                
                mostrarVentanaConsultarReservacion();
                dispose(); 
			}
		});
		
		btnMostrarDatos.setToolTipText("Consultar Reservación por ID");
		contentPane.add(btnMostrarDatos);
		

        JButton btnActualizarDatos = new JButton("Actualizar Recervasión");
		btnActualizarDatos.setBounds(30, 280, 250, 45);
		btnActualizarDatos.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnActualizarDatos.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/actualizar.png")));
        btnActualizarDatos.setBackground(Color.WHITE);

		btnActualizarDatos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
                mostrarVentanaActualizarReservacion();
                dispose(); 
				
			}
		});
		
		btnActualizarDatos.setToolTipText("Actualizar Resrvación por ID");
		contentPane.add(btnActualizarDatos);


		
        JButton btnEliminarDatos = new JButton("Eliminar Resrvación");
		btnEliminarDatos.setBounds(310, 280, 250, 45);
		btnEliminarDatos.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnEliminarDatos.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/eliminar.png")));
        btnEliminarDatos.setBackground(Color.WHITE);

		btnEliminarDatos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
		
                mostrarVentanaEliminarReservacion();
                dispose();
			}
		});
		
		btnEliminarDatos.setToolTipText("Eliminar Recervacion por ID");
		contentPane.add(btnEliminarDatos);




        JButton btnSalir = new JButton("Menú Principal");
		btnSalir.setBounds(330, 450, 240, 40);
		btnSalir.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnSalir.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/volver.png")));
        btnSalir.setBackground(Color.WHITE);

		btnSalir.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
                abrirVentanaPrincipal();
                dispose(); 
			}
				
		});
		
		btnSalir.setToolTipText("Volver");
		contentPane.add(btnSalir);
}
 
public void mostrarVentanaReservacion() {
    JFrame frame = new JFrame("Registrar Reservación");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setBounds(500, 200, 500, 500);
    frame.getContentPane().setBackground(new Color(224, 255, 255));
    
    frame.setLayout(null);

    // ComboBox para Cédula del Cliente
    JLabel lblCedula = new JLabel("Cédula Cliente:");
    lblCedula.setBounds(30, 30, 150, 25);
    JComboBox<String> comboCedulaClientes = new JComboBox<>();
    comboCedulaClientes.setBounds(180, 30, 200, 25);
    cargarCedulasClientes(comboCedulaClientes); // Cargar datos en el ComboBox

    // ComboBox para Número de Habitación
    JLabel lblNumHabitacion = new JLabel("Número de Habitación:");
    lblNumHabitacion.setBounds(30, 70, 150, 25);
    JComboBox<Integer> comboHabitaciones = new JComboBox<>();
    comboHabitaciones.setBounds(180, 70, 200, 25);
    cargarHabitaciones(comboHabitaciones);

    // ComboBox para Tipo de Pago
    JLabel lblTipoPago = new JLabel("Tipo de Pago:");
    lblTipoPago.setBounds(30, 110, 150, 25);
    JComboBox<Integer> comboTiposPago = new JComboBox<>();
    comboTiposPago.setBounds(180, 110, 200, 25);
    cargarTiposPago(comboTiposPago);

    // ComboBox para Empleado
    JLabel lblEmpleado = new JLabel("Empleado:");
    lblEmpleado.setBounds(30, 150, 150, 25);
    JComboBox<Integer> comboEmpleados = new JComboBox<>();
    comboEmpleados.setBounds(180, 150, 200, 25);
    cargarEmpleados(comboEmpleados);

    // Campos para fechas
    JLabel lblFechaInicio = new JLabel("Fecha Inicio (yyyy-MM-dd):");
    lblFechaInicio.setBounds(30, 190, 150, 25);
    JTextField txtFechaInicio = new JTextField();
    txtFechaInicio.setBounds(180, 190, 200, 25);

    JLabel lblFechaFin = new JLabel("Fecha Fin (yyyy-MM-dd):");
    lblFechaFin.setBounds(30, 230, 150, 25);
    JTextField txtFechaFin = new JTextField();
    txtFechaFin.setBounds(180, 230, 200, 25);

    // Botones
    JButton btnGuardar = new JButton("Registrar");
    btnGuardar.setBounds(60, 350, 125, 35);
    btnGuardar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/guardar.png")));

    JButton btnCancelar = new JButton("Cancelar");
    btnCancelar.setBounds(230, 350, 125, 35);
    btnCancelar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/cancelar.png")));

    // Agregar componentes al frame
    frame.add(lblCedula);
    frame.add(comboCedulaClientes);
    frame.add(lblNumHabitacion);
    frame.add(comboHabitaciones);
    frame.add(lblTipoPago);
    frame.add(comboTiposPago);
    frame.add(lblEmpleado);
    frame.add(comboEmpleados);
    frame.add(lblFechaInicio);
    frame.add(txtFechaInicio);
    frame.add(lblFechaFin);
    frame.add(txtFechaFin);
    frame.add(btnGuardar);
    frame.add(btnCancelar);

    // Acción del botón Registrar
    btnGuardar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                // Obtener valores del formulario
                String cedulaCliente = (String) comboCedulaClientes.getSelectedItem();
                int numHabitacion = (int) comboHabitaciones.getSelectedItem();
                int idTipoPago = (int) comboTiposPago.getSelectedItem();
                int idEmpleado = (int) comboEmpleados.getSelectedItem();

                // Convertir fechas de String a java.sql.Date
                java.sql.Date fechaInicio = java.sql.Date.valueOf(txtFechaInicio.getText());
                java.sql.Date fechaFin = java.sql.Date.valueOf(txtFechaFin.getText());

                // Llamar al método del modelo que interactúa con el SP
                Modelo.LlamadoSP.insertarReservacion(cedulaCliente, numHabitacion, idTipoPago, idEmpleado, fechaInicio, fechaFin);

                JOptionPane.showMessageDialog(frame, "Reservación registrada con éxito.");


                abrirMenuResevacion();
                frame.dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor, ingresa números válidos en los campos correspondientes.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(frame, "Formato de fecha incorrecto. Usa 'yyyy-MM-dd'.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error al registrar la reservación: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    });

    // Acción del botón Cancelar
    btnCancelar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            abrirMenuResevacion();
            frame.dispose(); // Cerrar la ventana sin hacer nada
        }
    });

    frame.setVisible(true);
}



// Método para cargar las cédulas de los clientes en el ComboBox
private void cargarCedulasClientes(JComboBox<String> comboBox) {
    try (Connection conn = ConexionDB.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT cedula_cliente FROM cliente")) {
        while (rs.next()) {
            comboBox.addItem(rs.getString("cedula_cliente"));
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cargar cédulas de clientes: " + e.getMessage());
    }
}


// Método para cargar habitaciones en el ComboBox
private void cargarHabitaciones(JComboBox<Integer> comboBox) {
    try (Connection conn = ConexionDB.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT num_habitacion FROM habitacion")) {
        while (rs.next()) {
            comboBox.addItem(rs.getInt("num_habitacion"));
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cargar habitaciones: " + e.getMessage());
    }
}

// Método para cargar tipos de pago en el ComboBox
private void cargarTiposPago(JComboBox<Integer> comboBox) {
    try (Connection conn = ConexionDB.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT idtipo_pago FROM tipo_pago")) {
        while (rs.next()) {
            comboBox.addItem(rs.getInt("idtipo_pago"));
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cargar tipos de pago: " + e.getMessage());
    }
}

// Método para cargar empleados en el ComboBox
private void cargarEmpleados(JComboBox<Integer> comboBox) {
    try (Connection conn = ConexionDB.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT id_empleado FROM recepcionista")) {
        while (rs.next()) {
            comboBox.addItem(rs.getInt("id_empleado"));
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cargar empleados: " + e.getMessage());
    }
}






public  void mostrarVentanaConsultarReservacion() {
    // Crear la ventana
    JDialog ventanaConsultar = new JDialog();
    ventanaConsultar.setTitle("Consultar Reservación");
    ventanaConsultar.getContentPane().setBackground(new Color(224, 255, 255));
    ventanaConsultar.setBounds(500, 200, 500, 500);
    ventanaConsultar.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    ventanaConsultar.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

    // Establecer el layout de la ventana
    ventanaConsultar.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(10, 10, 10, 10);

    // Crear los componentes
    JLabel lblIdReservacion = new JLabel("ID Reservación:");
    JTextField txtIdReservacion = new JTextField(10);
    JButton btnConsultar = new JButton("Consultar");
    btnConsultar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/Buscar1.png")));
    

    JButton btnCancelar = new JButton("Salir");
    btnCancelar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/cancelar.png")));
    

    JLabel lblCedulaCliente = new JLabel("Cédula Cliente:");
    JLabel lblCedulaClienteValor = new JLabel("-");

    JLabel lblCliente = new JLabel("Cliente:");
    JLabel lblClienteValor = new JLabel("-");

    JLabel lblNumHabitacion = new JLabel("Núm. Habitación:");
    JLabel lblNumHabitacionValor = new JLabel("-");

    JLabel lblTipoHabitacion = new JLabel("Tipo Habitación:");
    JLabel lblTipoHabitacionValor = new JLabel("-");

    JLabel lblTipoPago = new JLabel("Tipo de Pago:");
    JLabel lblTipoPagoValor = new JLabel("-");

    JLabel lblRecepcionista = new JLabel("Recepcionista:");
    JLabel lblRecepcionistaValor = new JLabel("-");

    JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
    JLabel lblFechaInicioValor = new JLabel("-");

    JLabel lblFechaFin = new JLabel("Fecha Fin:");
    JLabel lblFechaFinValor = new JLabel("-");

    // Añadir componentes a la ventana con GridBagLayout

    // Fila 1: ID Reservación y Botón Consultar
    gbc.gridx = 0;
    gbc.gridy = 0;
    ventanaConsultar.add(lblIdReservacion, gbc);

    gbc.gridx = 1;
    ventanaConsultar.add(txtIdReservacion, gbc);

    gbc.gridx = 2;
    ventanaConsultar.add(btnConsultar, gbc);

    // Fila 2: Cédula Cliente
    gbc.gridx = 0;
    gbc.gridy = 1;
    ventanaConsultar.add(lblCedulaCliente, gbc);

    gbc.gridx = 1;
    gbc.gridwidth = 2;
    ventanaConsultar.add(lblCedulaClienteValor, gbc);

    // Fila 3: Cliente
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 1;
    ventanaConsultar.add(lblCliente, gbc);

    gbc.gridx = 1;
    gbc.gridwidth = 2;
    ventanaConsultar.add(lblClienteValor, gbc);

    // Fila 4: Número de Habitación
    gbc.gridx = 0;
    gbc.gridy = 3;
    ventanaConsultar.add(lblNumHabitacion, gbc);

    gbc.gridx = 1;
    gbc.gridwidth = 2;
    ventanaConsultar.add(lblNumHabitacionValor, gbc);

    // Fila 5: Tipo de Habitación
    gbc.gridx = 0;
    gbc.gridy = 4;
    ventanaConsultar.add(lblTipoHabitacion, gbc);

    gbc.gridx = 1;
    gbc.gridwidth = 2;
    ventanaConsultar.add(lblTipoHabitacionValor, gbc);

    // Fila 6: Tipo de Pago
    gbc.gridx = 0;
    gbc.gridy = 5;
    ventanaConsultar.add(lblTipoPago, gbc);

    gbc.gridx = 1;
    gbc.gridwidth = 2;
    ventanaConsultar.add(lblTipoPagoValor, gbc);

    // Fila 7: Recepcionista
    gbc.gridx = 0;
    gbc.gridy = 6;
    ventanaConsultar.add(lblRecepcionista, gbc);

    gbc.gridx = 1;
    gbc.gridwidth = 2;
    ventanaConsultar.add(lblRecepcionistaValor, gbc);

    // Fila 8: Fecha Inicio
    gbc.gridx = 0;
    gbc.gridy = 7;
    ventanaConsultar.add(lblFechaInicio, gbc);

    gbc.gridx = 1;
    gbc.gridwidth = 2;
    ventanaConsultar.add(lblFechaInicioValor, gbc);

    // Fila 9: Fecha Fin
    gbc.gridx = 0;
    gbc.gridy = 8;
    ventanaConsultar.add(lblFechaFin, gbc);

    gbc.gridx = 1;
    gbc.gridwidth = 2;
    ventanaConsultar.add(lblFechaFinValor, gbc);

    // Fila 10: Botón Cancelar
    gbc.gridx = 1;
    gbc.gridy = 9;
    gbc.gridwidth = 1;
    ventanaConsultar.add(btnCancelar, gbc);

    // Acción del botón Consultar
    btnConsultar.addActionListener(e -> {
        String idReservacionStr = txtIdReservacion.getText().trim();

        if (idReservacionStr.isEmpty()) {
            JOptionPane.showMessageDialog(ventanaConsultar, "Por favor, ingrese un ID de reservación.");
            return;
        }

        try {
            int idReservacion = Integer.parseInt(idReservacionStr);
            // Llamar al método de LlamadoSP para obtener el ResultSet
            ResultSet rs = Modelo.LlamadoSP.consultarReservacion(idReservacion);

            if (rs != null && rs.next()) {
                lblCedulaClienteValor.setText(rs.getString("cedula_cliente"));
                lblClienteValor.setText(rs.getString("cliente"));
                lblNumHabitacionValor.setText(rs.getString("num_habitacion"));
                lblTipoHabitacionValor.setText(rs.getString("tipo_habitacion"));
                lblTipoPagoValor.setText(rs.getString("tipo_pago"));
                lblRecepcionistaValor.setText(rs.getString("recepcionista"));
                lblFechaInicioValor.setText(rs.getString("fecha_inicio"));
                lblFechaFinValor.setText(rs.getString("fecha_fin"));

               
                
            } else {
                JOptionPane.showMessageDialog(ventanaConsultar, "No se encontró una reservación con el ID proporcionado.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(ventanaConsultar, "El ID de reservación debe ser un número.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(ventanaConsultar, "Error al procesar la consulta: " + ex.getMessage());
        }
    });

    // Acción del botón Cancelar
    btnCancelar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            
            abrirMenuResevacion();
            ventanaConsultar.dispose(); // Cerrar la ventana sin hacer nada
        }
    });

    // Mostrar la ventana
    ventanaConsultar.setModal(true);
    ventanaConsultar.setVisible(true);
}





public  void mostrarVentanaActualizarReservacion() {
    // Crear la ventana
    JDialog ventanaActualizar = new JDialog();
    ventanaActualizar.setTitle("Actualizar Reservación");
    ventanaActualizar.getContentPane().setBackground(new Color(224, 255, 255));
    ventanaActualizar.setBounds(450, 100, 600, 600);
    ventanaActualizar.setLayout(new GridLayout(11, 2, 10, 10));
    ventanaActualizar.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    // Crear componentes
    JLabel lblIdReservacion = new JLabel("ID Reservación:");
    JTextField txtIdReservacion = new JTextField();

    JLabel lblCedulaCliente = new JLabel("Cédula Cliente:");
    JComboBox<String> comboCedulaCliente = new JComboBox<>();

    JLabel lblNumHabitacion = new JLabel("Núm. Habitación:");
    JComboBox<Integer> comboNumHabitacion = new JComboBox<>();

    JLabel lblTipoPago = new JLabel("Tipo de Pago:");
    JComboBox<Integer> comboTipoPago = new JComboBox<>();

    JLabel lblEmpleado = new JLabel("ID Empleado:");
    JComboBox<Integer> comboEmpleado = new JComboBox<>();

    JLabel lblFechaInicio = new JLabel("Fecha Inicio (YYYY-MM-DD):");
    JTextField txtFechaInicio = new JTextField();

    JLabel lblFechaFin = new JLabel("Fecha Fin (YYYY-MM-DD):");
    JTextField txtFechaFin = new JTextField();

    JButton btnActualizar = new JButton("Actualizar Reservación");
    btnActualizar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/avatar.png")));

    JButton btnCancelar = new JButton("Cancelar");
    btnCancelar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/cancelar.png")));

    // Añadir componentes a la ventana
    ventanaActualizar.add(lblIdReservacion);
    ventanaActualizar.add(txtIdReservacion);
    ventanaActualizar.add(lblCedulaCliente);
    ventanaActualizar.add(comboCedulaCliente);
    ventanaActualizar.add(lblNumHabitacion);
    ventanaActualizar.add(comboNumHabitacion);
    ventanaActualizar.add(lblTipoPago);
    ventanaActualizar.add(comboTipoPago);
    ventanaActualizar.add(lblEmpleado);
    ventanaActualizar.add(comboEmpleado);
    ventanaActualizar.add(lblFechaInicio);
    ventanaActualizar.add(txtFechaInicio);
    ventanaActualizar.add(lblFechaFin);
    ventanaActualizar.add(txtFechaFin);
    ventanaActualizar.add(btnCancelar);
    ventanaActualizar.add(btnActualizar);

    // Cargar datos en los ComboBox desde la base de datos
    cargarCedulasClientes(comboCedulaCliente);
    cargarHabitaciones(comboNumHabitacion);
    cargarTiposPago(comboTipoPago);
    cargarEmpleados(comboEmpleado);

    // Acción del botón Actualizar
    btnActualizar.addActionListener(e -> {
        try {
            // Validar campos obligatorios
            if (txtIdReservacion.getText().isEmpty() || comboCedulaCliente.getSelectedItem() == null 
                    || comboNumHabitacion.getSelectedItem() == null || txtFechaInicio.getText().isEmpty() 
                    || txtFechaFin.getText().isEmpty()) {
                JOptionPane.showMessageDialog(ventanaActualizar, "Por favor, complete todos los campos obligatorios.");
                return;
            }

            // Obtener los datos de los campos
            int idReservacion = Integer.parseInt(txtIdReservacion.getText());
            String cedulaCliente = (String) comboCedulaCliente.getSelectedItem();
            int numHabitacion = (Integer) comboNumHabitacion.getSelectedItem();
            int idTipoPago = (Integer) comboTipoPago.getSelectedItem();
            int idEmpleado = (Integer) comboEmpleado.getSelectedItem();
            Date fechaInicio = Date.valueOf(txtFechaInicio.getText());
            Date fechaFin = Date.valueOf(txtFechaFin.getText());

            // Llamar al método de la clase LlamadoSP para actualizar
            Modelo.LlamadoSP.actualizarReservacion(idReservacion, cedulaCliente, numHabitacion, idTipoPago, idEmpleado, fechaInicio, fechaFin);

            JOptionPane.showMessageDialog(ventanaActualizar, "Reservación actualizada correctamente.");

            // Cerrar ventana tras actualizar
            abrirMenuResevacion();
            ventanaActualizar.dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(ventanaActualizar, "Por favor, ingrese datos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(ventanaActualizar, "Fecha en formato incorrecto. Use YYYY-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    });

    // Acción del botón Cancelar
    btnCancelar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            
            abrirMenuResevacion();
            ventanaActualizar.dispose(); // Cerrar la ventana sin hacer nada
        }
    });


    // Mostrar la ventana
    ventanaActualizar.setModal(true);
    ventanaActualizar.setVisible(true);
}






// Método para mostrar la ventana de eliminación de reservación
private void mostrarVentanaEliminarReservacion() {
    JFrame ventanaEliminar = new JFrame("Eliminar Reservación");
    ventanaEliminar.setBounds(500, 200, 450, 250);
    ventanaEliminar.getContentPane().setBackground(new Color(224, 255, 255));
    ventanaEliminar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    ventanaEliminar.getContentPane().setLayout(null);

    // Etiqueta y campo de texto para el ID de la reservación
    JLabel lblIdReservacion = new JLabel("Ingrese el ID de Reservación:");
    lblIdReservacion.setBounds(30, 30, 160, 30);
    ventanaEliminar.getContentPane().add(lblIdReservacion);

    JTextField txtIdReservacion = new JTextField();
    txtIdReservacion.setBounds(200, 30, 150, 30);
    ventanaEliminar.getContentPane().add(txtIdReservacion);

    // Botón para realizar la eliminación
    JButton btnEliminar = new JButton("Eliminar");
    btnEliminar.setBounds(70, 80, 100, 40);
    btnEliminar.setBounds(50, 90, 150, 40);
    btnEliminar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/basura.png")));
    ventanaEliminar.getContentPane().add(btnEliminar);

    // Botón para cerrar la ventana
    JButton btnCancelar = new JButton("Cancelar");
    btnCancelar.setBounds(220, 80, 100, 40);
    btnCancelar.setBounds(250, 90,150, 40);
    btnCancelar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/cancelar.png")));
    ventanaEliminar.getContentPane().add(btnCancelar);

    // Acción del botón Eliminar para eliminar la reservación
    btnEliminar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String idReservacionStr = txtIdReservacion.getText();

            // Validar que el campo no esté vacío
            if (idReservacionStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el ID de la reservación.");
                return;
            }

            try {
                // Convertir el ID de reservación a entero
                int idReservacion = Integer.parseInt(idReservacionStr);

                // Llamar al método de eliminación de reservación
                LlamadoSP.eliminarReservacion(idReservacion);

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(null, "Reservación eliminada correctamente.");
                abrirMenuResevacion();
                ventanaEliminar.dispose(); // Cerrar la ventana sin hacer nada
            } catch (NumberFormatException ex) {
                // Validar que el ID sea un número
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID válido.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                // Manejar errores de SQL
                JOptionPane.showMessageDialog(null, "Error al eliminar la reservación: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    });

    // Acción del botón Cancelar
    btnCancelar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            abrirMenuResevacion();
            ventanaEliminar.dispose(); // Cerrar la ventana sin hacer nada
        }
    });

    ventanaEliminar.setVisible(true); // Mostrar la ventana
}


private void abrirMenuResevacion() {
    VentanaReservacion ventanaPrincipal = new VentanaReservacion();
    ventanaPrincipal.setVisible(true);
}


private void abrirVentanaPrincipal() {
    VentanaPrincipalGUI ventanaPrincipal = new VentanaPrincipalGUI();
    ventanaPrincipal.setVisible(true);
}


public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            new VentanaReservacion().setVisible(true);
        }
    });
}

}
