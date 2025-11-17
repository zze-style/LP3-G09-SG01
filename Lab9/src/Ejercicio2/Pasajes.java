package Ejercicio2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pasajes extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private JTextField NombreApellidos;
    private JTextField DocumentoIdentidad;
    private JTextField FechaViaje;

    private JCheckBox checkAudifonos;
    private JCheckBox checkMantas;
    private JCheckBox checkSnacks;
    private JCheckBox checkRevistas;

    private JComboBox comboOrigen;
    private JComboBox comboDestino;

    private JRadioButton rdbPrimerPiso;
    private JRadioButton rdbSegundoPiso;
    private ButtonGroup grupoPiso;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Pasajes frame = new Pasajes();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Pasajes() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        NombreApellidos = new JTextField();
        NombreApellidos.setColumns(10);

        DocumentoIdentidad = new JTextField();
        DocumentoIdentidad.setColumns(10);

        FechaViaje = new JTextField();
        FechaViaje.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre y apellidos:");
        JLabel lblDNI = new JLabel("Documento de identidad:");
        JLabel lblFecha = new JLabel("Fecha de viaje:");

        JLabel lblServicios = new JLabel("Servicios adicionales");
        JLabel lblOrigen = new JLabel("Origen");
        JLabel lblDestino = new JLabel("Destino");
        JLabel lblPreferencia = new JLabel("Preferencia (Piso)");

        checkAudifonos = new JCheckBox("Audífonos");
        checkMantas = new JCheckBox("Manta adicional");
        checkSnacks = new JCheckBox("Snacks");
        checkRevistas = new JCheckBox("Revistas");

        String[] ciudades = {"Lima", "Arequipa", "Cusco", "Tacna"};
        comboOrigen = new JComboBox(ciudades);
        comboDestino = new JComboBox(ciudades);


        JRadioButton botonPrimerPiso = new JRadioButton("Primer piso");
        JRadioButton botonSegundoPiso = new JRadioButton("Segundo piso");

        rdbPrimerPiso = botonPrimerPiso;
        rdbSegundoPiso = botonSegundoPiso;

        grupoPiso = new ButtonGroup();
        grupoPiso.add(rdbPrimerPiso);
        grupoPiso.add(rdbSegundoPiso);
        
        JLabel lblCalidad = new JLabel("Calidad");
        
        String[] calidades = {null, "Económico", "Estándar", "VIP"};
        
        JComboBox comboCalidad = new JComboBox(calidades);

        JButton btnRegistrar = new JButton("Registrar pasaje");
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String nombre = NombreApellidos.getText();
                String dni = DocumentoIdentidad.getText();
                String fecha = FechaViaje.getText();

                String origen = comboOrigen.getSelectedItem().toString();
                String destino = comboDestino.getSelectedItem().toString();

                boolean audifonos = checkAudifonos.isSelected();
                boolean mantas = checkMantas.isSelected();
                boolean revistas = checkRevistas.isSelected();
                boolean snacks = checkSnacks.isSelected();

                String piso = "";
                if (rdbPrimerPiso.isSelected()) {
                    piso = "Primer piso";
                } else if (rdbSegundoPiso.isSelected()) {
                    piso = "Segundo piso";
                }
                
                String calidad = comboCalidad.getSelectedItem().toString();

                String mensaje =
                        "Nombre: " + nombre +
                        "\nDocumento: " + dni +
                        "\nFecha de viaje: " + fecha +
                        "\nOrigen: " + origen +
                        "\nDestino: " + destino +
                        "\nCalidad: " + calidad +
                        "\n----- Servicios adicionales ----" +
                        "\nAudífonos: " + audifonos +
                        "\nMantas: " + mantas +
                        "\nRevistas: " + revistas +
                        "\nSnacks: " + snacks +
                        "\n----- Preferencias ----" +
                        "\nPiso: " + piso;

                JOptionPane.showMessageDialog(null, mensaje);
            }
        });

        JButton btnReiniciar = new JButton("Reiniciar campos");
        btnReiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NombreApellidos.setText("");
                DocumentoIdentidad.setText("");
                FechaViaje.setText("");

                checkAudifonos.setSelected(false);
                checkMantas.setSelected(false);
                checkSnacks.setSelected(false);
                checkRevistas.setSelected(false);

                comboOrigen.setSelectedIndex(0);
                comboDestino.setSelectedIndex(0);

                grupoPiso.clearSelection();
                
                JOptionPane.showMessageDialog(null, "Se han limpiado los campos");
                
                
            }
        });
        
        JLabel lblNewLabel = new JLabel("");

        GroupLayout layout = new GroupLayout(contentPane);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblNombre)
        						.addComponent(lblServicios)
        						.addComponent(checkAudifonos)
        						.addComponent(checkSnacks)
        						.addComponent(lblPreferencia)
        						.addComponent(botonPrimerPiso)
        						.addComponent(botonSegundoPiso)
        						.addComponent(lblFecha))
        					.addGap(23))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblDNI)
        					.addGap(18)))
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        					.addGroup(layout.createSequentialGroup()
        						.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        							.addGroup(layout.createSequentialGroup()
        								.addGap(20)
        								.addGroup(layout.createParallelGroup(Alignment.LEADING)
        									.addGroup(layout.createSequentialGroup()
        										.addGroup(layout.createParallelGroup(Alignment.LEADING)
        											.addComponent(checkMantas)
        											.addComponent(checkRevistas))
        										.addGap(134)
        										.addComponent(comboOrigen, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        										.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
        										.addComponent(comboDestino, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        										.addGap(13))
        									.addComponent(NombreApellidos, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
        							.addGroup(layout.createSequentialGroup()
        								.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        									.addGroup(layout.createSequentialGroup()
        										.addGap(18)
        										.addGroup(layout.createParallelGroup(Alignment.LEADING)
        											.addComponent(FechaViaje, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        											.addComponent(DocumentoIdentidad, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
        										.addPreferredGap(ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
        										.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        											.addComponent(btnReiniciar)
        											.addComponent(btnRegistrar)))
        									.addGroup(layout.createSequentialGroup()
        										.addPreferredGap(ComponentPlacement.RELATED)
        										.addComponent(lblOrigen)
        										.addGap(97)
        										.addComponent(lblDestino)))
        								.addGap(53)))
        						.addGap(111))
        					.addGroup(layout.createSequentialGroup()
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(lblNewLabel)
        						.addGap(227)))
        				.addGroup(layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(comboCalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblCalidad))
        					.addGap(213))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNombre)
        				.addComponent(NombreApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(DocumentoIdentidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblDNI))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(FechaViaje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblFecha)))
        				.addGroup(layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnRegistrar)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnReiniciar)))
        			.addGap(70)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblServicios)
        				.addComponent(lblOrigen)
        				.addComponent(lblDestino))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(checkAudifonos)
        				.addComponent(checkMantas)
        				.addComponent(comboOrigen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(comboDestino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(checkSnacks)
        				.addComponent(checkRevistas))
        			.addGap(20)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblPreferencia)
        				.addComponent(lblNewLabel)
        				.addComponent(lblCalidad))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(botonPrimerPiso)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(botonSegundoPiso))
        				.addComponent(comboCalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(20))
        );
        contentPane.setLayout(layout);
    }
}
