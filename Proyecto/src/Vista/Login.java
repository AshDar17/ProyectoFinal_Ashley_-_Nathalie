package Vista;


import javax.swing.*;

import Controlador.VentanaPrincipalGUI;
import Modelo.ConexionDB;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.sql.SQLException;


public class Login extends JFrame {
    
    public ConexionDB conexion; 
    private JTextField txtUsuario;
    private JPasswordField txtClave;

    public Login() {
        super("Inicio de Sesión");
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 450);
        setResizable(false);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Cargar imagen para el panel de login
        ImageIcon iconoFondo = new ImageIcon(Login.class.getResource("/Imagenes/usuar.png"));
        ImageIcon iconoRedimensionado = new ImageIcon(iconoFondo.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH));
        JLabel lblImagen = new JLabel(iconoRedimensionado);

        JPanel panel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(224, 255, 255));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.anchor = GridBagConstraints.WEST; 
        panel.add(lblImagen, gbc);

        JLabel lblTitulo = new JLabel("Inicio de Sesión");
        lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblTitulo.setForeground(Color.BLACK); // Texto en color negro
        lblTitulo.setHorizontalAlignment(JLabel.CENTER);
        panel.add(lblTitulo, gbc);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setForeground(Color.BLACK);
        lblUsuario.setFont(new Font("Times New Roman", Font.BOLD, 16)); // Aumentar el tamaño y hacer negrita
        lblUsuario.setHorizontalAlignment(JLabel.CENTER); // Centrar el texto
        panel.add(lblUsuario, gbc);

        txtUsuario = new JTextField(15);
        txtUsuario.setHorizontalAlignment(JTextField.CENTER); // Centrar el texto en el JTextField
        txtUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 14)); // Reducir el tamaño de la fuente
        panel.add(txtUsuario, gbc);

        JLabel lblClave = new JLabel("Contraseña:");
        lblClave.setForeground(Color.BLACK);
        lblClave.setFont(new Font("Times New Roman", Font.BOLD, 16)); // Aumentar el tamaño y hacer negrita
        lblClave.setHorizontalAlignment(JLabel.CENTER); // Centrar el texto
        panel.add(lblClave, gbc);

        txtClave = new JPasswordField(15);
        txtClave.setHorizontalAlignment(JPasswordField.CENTER); // Centrar el texto en el JPasswordField
        txtClave.setFont(new Font("Times New Roman", Font.PLAIN, 14)); // Reducir el tamaño de la fuente
        panel.add(txtClave, gbc);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBotones.setOpaque(false); // Hacer el panel transparente

        // BOTON INICIAR SESION
        ImageIcon iconoIniciarSesion = new ImageIcon(Login.class.getResource("/Imagenes/entrarrr.png"));
        ImageIcon iconoIniciarSesionRedimensionado = new ImageIcon(iconoIniciarSesion.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        JButton btnIniciarSesion = new JButton("Iniciar Sesión", iconoIniciarSesionRedimensionado);
        btnIniciarSesion.setPreferredSize(new Dimension(150, 50));
        btnIniciarSesion.setForeground(Color.BLACK); // Texto en color negro
        btnIniciarSesion.setHorizontalTextPosition(SwingConstants.CENTER); // Texto centrado horizontalmente
        btnIniciarSesion.setVerticalTextPosition(SwingConstants.BOTTOM); // Texto debajo del icono
        btnIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String clave = new String(txtClave.getPassword());
        
                if (validarUsuario(usuario, clave) == true) {
                    System.out.println("hola");
                    abrirVentanaPrincipal();
                    dispose(); // Cerrar la ventana de inicio de sesión
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Usuario o contraseña incorrectos", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panelBotones.add(btnIniciarSesion);
        
        

        // BOTON SALIR
        ImageIcon iconoSalir = new ImageIcon(Login.class.getResource("/Imagenes/exitb.png"));
        ImageIcon iconoSalirRedimensionado = new ImageIcon(iconoSalir.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        JButton btnSalir = new JButton("Salir", iconoSalirRedimensionado);
        btnSalir.setPreferredSize(new Dimension(150, 50));
        btnSalir.setForeground(Color.BLACK); // Texto en color negro
        btnSalir.setHorizontalTextPosition(SwingConstants.CENTER); // Texto centrado horizontalmente
        btnSalir.setVerticalTextPosition(SwingConstants.BOTTOM); // Texto debajo del icono
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null,"�Est� seguro de que desea salir?", "Confirmaci�n",JOptionPane.YES_NO_OPTION);
				if(JOptionPane.YES_NO_OPTION == a) {
					JOptionPane.showMessageDialog(null, "�Gracias por preferirnos!", "Cerrando sistema", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}	
               
            }
        });
        panelBotones.add(btnSalir);

        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(panelBotones, gbc);

        getContentPane().add(panel);
    }

   
    
    private boolean validarUsuario(String usuario, String clave) {
        
        String sql = "SELECT * FROM usuario WHERE nombre_usuario = ? AND contraseña = ?";
    
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            // Asignar los parámetros
            stmt.setString(1, usuario);
            stmt.setString(2, clave);
    
            // Ejecutar la consulta
            try (ResultSet rs = stmt.executeQuery()) {
                // Si hay un registro, significa que el usuario y la clave son correctos
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    

    private void abrirVentanaPrincipal() {
        VentanaPrincipalGUI ventanaPrincipal = new VentanaPrincipalGUI();
        ventanaPrincipal.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
