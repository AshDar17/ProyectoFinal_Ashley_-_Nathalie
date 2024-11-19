package Controlador;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class VentanaCliente extends JFrame {

    private JPanel contentPane;

    public VentanaCliente() {
     
     

		setTitle("Menú Clientes");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setToolTipText("Clientes");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		
		JLabel lblBienvenidosAlRegistro = new JLabel("Gestión del Cliente");
		lblBienvenidosAlRegistro.setBounds(180, 50, 303, 42);
		lblBienvenidosAlRegistro.setFont(new Font("Times New Roman", Font.BOLD, 26));
		contentPane.add(lblBienvenidosAlRegistro);


        JButton btnIngresar = new JButton("Ingresar Cliente");
		btnIngresar.setBounds(50, 200, 220, 45);
		btnIngresar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/cliente.png")));
		btnIngresar.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnIngresar.setBackground(Color.WHITE);
		
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                mostrarVentanaInsertarCliente();
						dispose(); 
			}
		});		
		contentPane.setLayout(null);

		btnIngresar.setToolTipText("Ingresar Cliente");
		contentPane.add(btnIngresar);


        JButton btnMostrarDatos = new JButton("Consultar Cliente");
		btnMostrarDatos.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/consultar.png")));
		btnMostrarDatos.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnMostrarDatos.setBounds(300, 200, 220, 50);
        btnMostrarDatos.setBackground(Color.WHITE);

		btnMostrarDatos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
                mostrarVentanaConsultarCliente();
                dispose();
			}
		});
		
		btnMostrarDatos.setToolTipText("Consultar Cliente");
		contentPane.add(btnMostrarDatos);
		

        JButton btnActualizarDatos = new JButton("Actualizar Cliente");
		btnActualizarDatos.setBounds(50, 280, 220, 45);
		btnActualizarDatos.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnActualizarDatos.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/actualizar.png")));
        btnActualizarDatos.setBackground(Color.WHITE);

		btnActualizarDatos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				mostrarVentanaActualizarCliente();
                dispose();
			}
		});
		
		btnActualizarDatos.setToolTipText("Actualizar Cliente");
		contentPane.add(btnActualizarDatos);


		
        JButton btnEliminarDatos = new JButton("Eliminar Cliente");
		btnEliminarDatos.setBounds(300, 280, 220, 45);
		btnEliminarDatos.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnEliminarDatos.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/eliminar.png")));
        btnEliminarDatos.setBackground(Color.WHITE);

		btnEliminarDatos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
		
                mostrarVentanaEliminarCliente();
                dispose();
			}
		});
		
		btnEliminarDatos.setToolTipText("Eliminar Cliente");
		contentPane.add(btnEliminarDatos);


        






        JButton btnSalir = new JButton("Menú Principal");
		btnSalir.setBounds(350, 450, 200, 40);
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



// Método para mostrar la ventana de inserción de cliente
private void mostrarVentanaInsertarCliente() {
    JFrame ventanaInsertar = new JFrame("Ingresar Cliente");
    ventanaInsertar.setBounds(450, 100, 500, 500);
    ventanaInsertar.getContentPane().setBackground(new Color(224, 255, 255));
    ventanaInsertar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    ventanaInsertar.getContentPane().setLayout(null);

    // Etiquetas y campos de texto
    JLabel lblCedula = new JLabel("Cédula:");
    lblCedula.setBounds(50, 30, 200, 30);
    ventanaInsertar.getContentPane().add(lblCedula);

    JTextField txtCedula = new JTextField();
    txtCedula.setBounds(200, 30, 200, 30);
    ventanaInsertar.getContentPane().add(txtCedula);

    JLabel lblNombre1 = new JLabel("Primer Nombre:");
    lblNombre1.setBounds(50, 80, 200, 30);
    ventanaInsertar.getContentPane().add(lblNombre1);

    JTextField txtNombre1 = new JTextField();
    txtNombre1.setBounds(200, 80, 200, 30);
    ventanaInsertar.getContentPane().add(txtNombre1);

    JLabel lblNombre2 = new JLabel("Segundo Nombre:");
    lblNombre2.setBounds(50, 130, 200, 30);
    ventanaInsertar.getContentPane().add(lblNombre2);

    JTextField txtNombre2 = new JTextField();
    txtNombre2.setBounds(200, 130, 200, 30);
    ventanaInsertar.getContentPane().add(txtNombre2);

    JLabel lblApellido1 = new JLabel("Primer Apellido:");
    lblApellido1.setBounds(50, 180, 200, 30);
    ventanaInsertar.getContentPane().add(lblApellido1);

    JTextField txtApellido1 = new JTextField();
    txtApellido1.setBounds(200, 180, 200, 30);
    ventanaInsertar.getContentPane().add(txtApellido1);

    JLabel lblApellido2 = new JLabel("Segundo Apellido:");
    lblApellido2.setBounds(50, 230, 200, 30);
    ventanaInsertar.getContentPane().add(lblApellido2);

    JTextField txtApellido2 = new JTextField();
    txtApellido2.setBounds(200, 230, 200, 30);
    ventanaInsertar.getContentPane().add(txtApellido2);

    JLabel lblTelefono = new JLabel("Teléfono:");
    lblTelefono.setBounds(50, 280, 200, 30);
    ventanaInsertar.getContentPane().add(lblTelefono);

    JTextField txtTelefono = new JTextField();
    txtTelefono.setBounds(200, 280, 200, 30);
    ventanaInsertar.getContentPane().add(txtTelefono);

    // Botón Guardar
    JButton btnGuardar = new JButton("Guardar");
    btnGuardar.setBounds(70, 350, 150, 50);
    btnGuardar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/guardar.png")));
    ventanaInsertar.getContentPane().add(btnGuardar);

    // Botón Cancelar
    JButton btnCancelar = new JButton("Cancelar");
    btnCancelar.setBounds(250, 350, 150, 50);
    btnCancelar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/cancelar.png")));
    ventanaInsertar.getContentPane().add(btnCancelar);

    // Acción del botón Guardar
    btnGuardar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Obtener los datos ingresados por el usuario
            String cedula = txtCedula.getText();
            String nombre1 = txtNombre1.getText();
            String nombre2 = txtNombre2.getText();
            String apellido1 = txtApellido1.getText();
            String apellido2 = txtApellido2.getText();
            String telefono = txtTelefono.getText();

            // Validar campos no vacíos
            if (cedula.isEmpty() || nombre1.isEmpty() || apellido1.isEmpty() || telefono.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos obligatorios.");
                return;
            }

            // Llamar al método insertarCliente del modelo (SP en la base de datos)
            try {
                Modelo.LlamadoSP.insertarCliente(cedula, nombre1, nombre2, apellido1, apellido2, telefono);
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }

            // Cerrar ventana tras insertar
            abrirMenuCliente(); 
            ventanaInsertar.dispose();
            
        }
    });

    // Acción del botón Cancelar
    btnCancelar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            abrirMenuCliente(); 
            ventanaInsertar.dispose();
        }
    });

    ventanaInsertar.setVisible(true);
}



// Método para mostrar la ventana de consulta de cliente
private void mostrarVentanaConsultarCliente() {
    JFrame ventanaConsultar = new JFrame("Consultar Cliente");
    ventanaConsultar.setBounds(500, 200, 400, 300);
    ventanaConsultar.getContentPane().setBackground(new Color(224, 255, 255));
    ventanaConsultar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    ventanaConsultar.getContentPane().setLayout(null);

    // Etiqueta y campo de texto para la cédula
    JLabel lblCedula = new JLabel("Ingrese la Cédula:");
    lblCedula.setBounds(30, 30, 120, 30);
    ventanaConsultar.getContentPane().add(lblCedula);

    JTextField txtCedula = new JTextField();
    txtCedula.setBounds(150, 30, 200, 30);
    ventanaConsultar.getContentPane().add(txtCedula);

    // Etiquetas para mostrar los datos del cliente
    JLabel lblNombre = new JLabel("Nombre:");
    lblNombre.setBounds(30, 100, 200, 30);
    ventanaConsultar.getContentPane().add(lblNombre);

    JLabel lblApellido = new JLabel("Apellido:");
    lblApellido.setBounds(30, 130, 200, 30);
    ventanaConsultar.getContentPane().add(lblApellido);

    JLabel lblTelefono = new JLabel("Teléfono:");
    lblTelefono.setBounds(30, 160, 200, 30);
    ventanaConsultar.getContentPane().add(lblTelefono);

    // Botón para realizar la consulta
    JButton btnConsultar = new JButton("Consultar");
    btnConsultar.setBounds(50, 200, 150, 50);
    btnConsultar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/Buscar1.png")));
    ventanaConsultar.getContentPane().add(btnConsultar);

    // Botón para cerrar la ventana
    JButton btnCancelar = new JButton("Salir");
    btnCancelar.setBounds(220, 200, 150, 50);
    btnCancelar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/cancelar.png")));
    ventanaConsultar.getContentPane().add(btnCancelar);

    // Acción del botón Consultar
    btnConsultar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String cedula = txtCedula.getText();

            // Validar que el campo no esté vacío
            if (cedula.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese una cédula.");
                return;
            }

            // Llamar al método de consulta en la clase ClienteDAO
            try {
                // Llamamos al método de consulta y mostramos los datos en las etiquetas
                ResultSet rs = Modelo.LlamadoSP.consultarCliente(cedula);

            

                if (rs != null && rs.next()) {
                    // Mostrar los datos en las etiquetas
                    lblNombre.setText("Nombre: " + rs.getString("nombre1") + " " + rs.getString("nombre2"));
                    lblApellido.setText("Apellido: " + rs.getString("apellido1") + " " + rs.getString("apellido2"));
                    lblTelefono.setText("Teléfono: " + rs.getString("telefono1"));
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con la cédula proporcionada.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al consultar el cliente: " + ex.getMessage(),
                                              "Error", JOptionPane.ERROR_MESSAGE);
            }

            
        }
    });

    // Acción del botón Cancelar
    btnCancelar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            abrirMenuCliente();
            ventanaConsultar.dispose();
        }
    });

    ventanaConsultar.setVisible(true);
}


// Método para mostrar la ventana de actualización de cliente
private void mostrarVentanaActualizarCliente() {
    JFrame ventanaActualizar = new JFrame("Actualizar Cliente");
    ventanaActualizar.setBounds(500, 200, 450, 450);
    ventanaActualizar.getContentPane().setBackground(new Color(224, 255, 255));
    ventanaActualizar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    ventanaActualizar.getContentPane().setLayout(null);

    // Etiqueta y campo de texto para la cédula
    JLabel lblCedula = new JLabel("Ingrese la Cédula:");
    lblCedula.setBounds(30, 30, 120, 30);
    ventanaActualizar.getContentPane().add(lblCedula);

    JTextField txtCedula = new JTextField();
    txtCedula.setBounds(150, 30, 200, 30);
    ventanaActualizar.getContentPane().add(txtCedula);

    // Etiquetas y campos de texto para los nuevos datos del cliente
    JLabel lblNombre1 = new JLabel("Nombre 1:");
    lblNombre1.setBounds(30, 80, 120, 30);
    ventanaActualizar.getContentPane().add(lblNombre1);

    JTextField txtNombre1 = new JTextField();
    txtNombre1.setBounds(150, 80, 200, 30);
    ventanaActualizar.getContentPane().add(txtNombre1);

    JLabel lblNombre2 = new JLabel("Nombre 2:");
    lblNombre2.setBounds(30, 120, 120, 30);
    ventanaActualizar.getContentPane().add(lblNombre2);

    JTextField txtNombre2 = new JTextField();
    txtNombre2.setBounds(150, 120, 200, 30);
    ventanaActualizar.getContentPane().add(txtNombre2);

    JLabel lblApellido1 = new JLabel("Apellido 1:");
    lblApellido1.setBounds(30, 160, 120, 30);
    ventanaActualizar.getContentPane().add(lblApellido1);

    JTextField txtApellido1 = new JTextField();
    txtApellido1.setBounds(150, 160, 200, 30);
    ventanaActualizar.getContentPane().add(txtApellido1);

    JLabel lblApellido2 = new JLabel("Apellido 2:");
    lblApellido2.setBounds(30, 200, 120, 30);
    ventanaActualizar.getContentPane().add(lblApellido2);

    JTextField txtApellido2 = new JTextField();
    txtApellido2.setBounds(150, 200, 200, 30);
    ventanaActualizar.getContentPane().add(txtApellido2);

    JLabel lblTelefono = new JLabel("Teléfono:");
    lblTelefono.setBounds(30, 240, 120, 30);
    ventanaActualizar.getContentPane().add(lblTelefono);

    JTextField txtTelefono = new JTextField();
    txtTelefono.setBounds(150, 240, 200, 30);
    ventanaActualizar.getContentPane().add(txtTelefono);

    // Botón para realizar la actualización
    JButton btnActualizar = new JButton("Actualizar");
    btnActualizar.setBounds(50, 290, 150, 40);
    btnActualizar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/guardar.png")));
    ventanaActualizar.getContentPane().add(btnActualizar);

    // Botón para cerrar la ventana
    JButton btnCancelar = new JButton("Cancelar");
    btnCancelar.setBounds(250, 290, 150, 40);
    btnCancelar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/cancelar.png")));
    ventanaActualizar.getContentPane().add(btnCancelar);

    // Acción del botón Actualizar
    btnActualizar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String cedula = txtCedula.getText();
            String nombre1 = txtNombre1.getText();
            String nombre2 = txtNombre2.getText();
            String apellido1 = txtApellido1.getText();
            String apellido2 = txtApellido2.getText();
            String telefono = txtTelefono.getText();

            // Validar que todos los campos no estén vacíos
            if (cedula.isEmpty() || nombre1.isEmpty() || nombre2.isEmpty() || apellido1.isEmpty() || apellido2.isEmpty() || telefono.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
                return;
            }

            // Llamar al método de actualización de cliente
            try {
                Modelo.LlamadoSP.actualizarCliente(cedula, nombre1, nombre2, apellido1, apellido2, telefono);
                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente.");
                abrirMenuCliente(); 
                ventanaActualizar.dispose();
            } catch (SQLException ex) {
                // Manejar errores de SQL y mostrar un mensaje de error
                JOptionPane.showMessageDialog(null, "Error al actualizar el cliente: " + ex.getMessage(),
                                              "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    });

    // Acción del botón Cancelar
    btnCancelar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            abrirMenuCliente();
            ventanaActualizar.dispose(); // Cerrar la ventana sin hacer nada
        }
    });

    ventanaActualizar.setVisible(true); // Mostrar la ventana
}



// Método para mostrar la ventana de eliminación de cliente
private void mostrarVentanaEliminarCliente() {
    JFrame ventanaEliminar = new JFrame("Eliminar Cliente");
    ventanaEliminar.setBounds(500, 200, 450, 250);
    ventanaEliminar.getContentPane().setBackground(new Color(224, 255, 255));
    ventanaEliminar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    ventanaEliminar.getContentPane().setLayout(null);

    // Etiqueta y campo de texto para la cédula
    JLabel lblCedula = new JLabel("Ingrese la Cédula:");
    lblCedula.setBounds(30, 30, 120, 30);
    ventanaEliminar.getContentPane().add(lblCedula);

    JTextField txtCedula = new JTextField();
    txtCedula.setBounds(150, 30, 200, 30);
    ventanaEliminar.getContentPane().add(txtCedula);

    // Botón para realizar la eliminación
    JButton btnEliminar = new JButton("Eliminar");
    btnEliminar.setBounds(50, 90, 150, 40);
    btnEliminar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/basura.png")));
    ventanaEliminar.getContentPane().add(btnEliminar);

    // Botón para cerrar la ventana
    JButton btnCancelar = new JButton("Cancelar");
    btnCancelar.setBounds(250, 90,150, 40);
    btnCancelar.setIcon(new ImageIcon(VentanaPrincipalGUI.class.getResource("/Imagenes/cancelar.png")));
    ventanaEliminar.getContentPane().add(btnCancelar);

    // Acción del botón Eliminar
    btnEliminar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String cedula = txtCedula.getText();

            // Validar que el campo no esté vacío
            if (cedula.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese la cédula.");
                return;
            }

            // Llamar al método de eliminación de cliente
            try {
                Modelo.LlamadoSP.eliminarCliente(cedula);
                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
                abrirMenuCliente(); 
                dispose();
            } catch (SQLException ex) {
                // Manejar errores de SQL y mostrar un mensaje de error
                JOptionPane.showMessageDialog(null, "Error al eliminar el cliente: " + ex.getMessage(),
                                              "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    });

    // Acción del botón Cancelar
    btnCancelar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            abrirMenuCliente(); 
            ventanaEliminar.dispose(); // Cerrar la ventana sin hacer nada
        }
    });

    ventanaEliminar.setVisible(true); // Mostrar la ventana
}

private void abrirMenuCliente() {
    VentanaCliente ventanaPrincipal = new VentanaCliente();
    ventanaPrincipal.setVisible(true);
}

   private void abrirVentanaPrincipal() {
        VentanaPrincipalGUI ventanaPrincipal = new VentanaPrincipalGUI();
        ventanaPrincipal.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaCliente().setVisible(true);
            }
        });
    }


}