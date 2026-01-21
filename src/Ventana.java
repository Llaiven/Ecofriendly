import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextField txtId;
    private JTextField txtNombre;
    private JComboBox cmbRol;
    private JSpinner spnPuntaje;
    private JComboBox cmbZona;
    private JButton btnAgregar;
    private JList lstUsuario;
    private JButton btnMostarUsuario;
    private JTextField txtId1;
    private JTextField txtNombre1;
    private JComboBox cmbRol1;
    private JSpinner spnPuntaje1;
    private JComboBox cmbZona1;
    private JButton btnBuscar;
    private JButton btnEditar;
    private JComboBox cmbTipo;
    private JSpinner spnCantidad;
    private JTextField txtFecha;
    private JTextField txtIdUsuario;
    private JButton btnAgregar1;
    private JList lstMateriales;
    private JButton btnMostrarMaterial;
    private JButton btnMostrarPorUsuario;
    private JButton btnTopReciclador;
    private JButton btnTotalMaterial;
    private JTextField txtIDUsuario;

    Color VERDE = new Color(46, 139, 87);
    Color VERDE_CLARO = new Color(152, 251, 152);
    Color GRIS_SUAVE = new Color(245, 245, 245);

    private void mostrarMaterialesPorUsuario(int idUsuario) {
        DefaultListModel<String> dlm = new DefaultListModel<>();

        for (MaterialReciclado m : mat.todos()) {
            if (m.getIdUsuario() == idUsuario) {
                dlm.addElement(m.toString());
            }
        }

        lstMateriales.setModel(dlm);
    }

    private Usuario obtenerTopReciclador() {
        Usuario top = null;

        for (Usuario u : sis.todos()) {
            if (top == null || u.getPuntaje() > top.getPuntaje()) {
                top = u;
            }
        }
        return top;
    }


    private void limpiarFormularioUsuario() {
        txtId.setText("");
        txtNombre.setText("");
        spnPuntaje.setValue(1);
        cmbRol.setSelectedIndex(0);
        cmbZona.setSelectedIndex(0);
    }

    private int totalMaterialesReciclados() {
        int total = 0;

        for (MaterialReciclado m : mat.todos()) {
            total += m.getCantidad();
        }
        return total;
    }

    private void aumentarPuntajeUsuario(int idUsuario, int cantidad) {
        Usuario u = sis.buscar(idUsuario);

        if (u != null) {
            int puntosGanados = cantidad * 2; // regla de puntos
            u.setPuntaje(u.getPuntaje() + puntosGanados);
        }
    }


    //Crear el codigo y la Lista
    int codigo=0;
    EcoSistema sis=new EcoSistema();
    ListaMateriales mat=new ListaMateriales();

    public Ventana() {

        btnAgregar.setBackground(VERDE);
        btnAgregar.setForeground(Color.BLACK);
        btnAgregar.setFocusPainted(false);
        btnAgregar.setBorder(
                BorderFactory.createEmptyBorder(8, 15, 8, 15)
        );

        btnAgregar1.setBackground(VERDE);
        btnAgregar1.setForeground(Color.BLACK);
        btnAgregar1.setFocusPainted(false);
        btnAgregar1.setBorder(
                BorderFactory.createEmptyBorder(8, 15, 8, 15)
        );

        btnBuscar.setBackground(VERDE);
        btnBuscar.setForeground(Color.BLACK);
        btnBuscar.setFocusPainted(false);
        btnBuscar.setBorder(
                BorderFactory.createEmptyBorder(8, 15, 8, 15)
        );

        btnEditar.setBackground(VERDE);
        btnEditar.setForeground(Color.BLACK);
        btnEditar.setFocusPainted(false);
        btnEditar.setBorder(
                BorderFactory.createEmptyBorder(8, 15, 8, 15)
        );

        btnMostarUsuario.setBackground(VERDE);
        btnMostarUsuario.setForeground(Color.BLACK);
        btnMostarUsuario.setFocusPainted(false);
        btnMostarUsuario.setBorder(
                BorderFactory.createEmptyBorder(8, 15, 8, 15)
        );

        btnMostrarMaterial.setBackground(VERDE);
        btnMostrarMaterial.setForeground(Color.BLACK);
        btnMostrarMaterial.setFocusPainted(false);
        btnMostrarMaterial.setBorder(
                BorderFactory.createEmptyBorder(8, 15, 8, 15)
        );

        btnTopReciclador.setBackground(VERDE);
        btnTopReciclador.setForeground(Color.BLACK);
        btnTopReciclador.setFocusPainted(false);
        btnTopReciclador.setBorder(
                BorderFactory.createEmptyBorder(8, 15, 8, 15)
        );

        btnTotalMaterial.setBackground(VERDE);
        btnTotalMaterial.setForeground(Color.BLACK);
        btnTotalMaterial.setFocusPainted(false);
        btnTotalMaterial.setBorder(
                BorderFactory.createEmptyBorder(8, 15, 8, 15)
        );

        btnMostrarPorUsuario.setBackground(VERDE);
        btnMostrarPorUsuario.setForeground(Color.BLACK);
        btnMostrarPorUsuario.setFocusPainted(false);
        btnMostrarPorUsuario.setBorder(
                BorderFactory.createEmptyBorder(8, 15, 8, 15)
        );


        //Definir el modelo del spinner
        SpinnerNumberModel snm = new SpinnerNumberModel(1, 1, 100, 1);
        spnPuntaje.setModel(snm);
        SpinnerNumberModel snm1 = new SpinnerNumberModel(1, 1, 100, 1);
        spnCantidad.setModel(snm1);

        //Agregar Usuario
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtId.getText());
                String nombre = txtNombre.getText();
                String rol = cmbRol.getSelectedItem().toString();
                int puntaje = Integer.parseInt(spnPuntaje.getValue().toString());
                String zona = cmbZona.getSelectedItem().toString();

                if (id <= codigo) {
                    JOptionPane.showMessageDialog(null, "Id no valido");
                } else {
                    Usuario usuario = new Usuario(id, nombre, rol, puntaje, zona);
                    sis.agregar(usuario);
                    JOptionPane.showMessageDialog(null, "Usuario Agregado");
                    codigo = id;
                    limpiarFormularioUsuario();
                }
            }
        });

        //Mostrar Usuarios
        btnMostarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel dlm = new DefaultListModel<>();
                for (Usuario usuario : sis.todos()) {
                    dlm.addElement(usuario.toString());
                }
                lstUsuario.setModel(dlm);
            }
        });

        //Buscar a un Usuario por ID
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtId1.getText());
                Usuario encontrado = sis.buscar(id);

                if (encontrado != null) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Usuario encontrado correctamente ✔",
                            "Éxito",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    txtId1.setText("" + encontrado.getId());
                    txtNombre1.setText("" + encontrado.getNombre());
                    cmbRol1.setSelectedItem(encontrado.getRol());
                    spnPuntaje1.setValue(encontrado.getPuntaje());
                    cmbZona1.setSelectedItem(encontrado.getZona());
                } else {
                    JOptionPane.showMessageDialog(null,
                            "No existe un usuario con el ID " + id);
                }
            }
        });

        //Editar a un Usuario
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtId1.getText());
                String nombre = txtNombre1.getText();
                String rol = cmbRol1.getSelectedItem().toString();
                int puntaje = Integer.parseInt(spnPuntaje1.getValue().toString());
                String zona = cmbZona1.getSelectedItem().toString();

                Usuario editar = new Usuario(id, nombre, rol, puntaje, zona);
                if (sis.editar(id, editar)) {
                    JOptionPane.showMessageDialog(null, "Edición correcta, muestre los datos");
                } else {
                    JOptionPane.showMessageDialog(null, "No se permite cambiar el ID");
                }
            }
        });

        //Agregar Material
        btnAgregar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo = cmbTipo.getSelectedItem().toString();
                int cantidad = Integer.parseInt(spnCantidad.getValue().toString());
                String fecha = txtFecha.getText();
                int id = Integer.parseInt(txtIdUsuario.getText());

                Usuario encontrado = sis.buscar(id);

                if (encontrado != null) {
                    JOptionPane.showMessageDialog(null, "Usuario Encontrado");
                    MaterialReciclado material = new MaterialReciclado(tipo, cantidad, fecha, id);
                    mat.agregar(material);

                    aumentarPuntajeUsuario(id, cantidad);

                    JOptionPane.showMessageDialog(
                            null,
                            "Material agregado correctamente\n" +
                                    "Puntos ganados: " + (cantidad * 2),
                            "Éxito",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(null,
                            "No existe un usuario con el ID " + id);
                }
            }
        });

        //Mostrar los Materiales
        btnMostrarMaterial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel dlm = new DefaultListModel<>();
                for (MaterialReciclado material : mat.todos()) {
                    dlm.addElement(material.toString());
                }
                lstMateriales.setModel(dlm);
            }
        });
        btnTopReciclador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario top = obtenerTopReciclador();

                if (top == null) {
                    JOptionPane.showMessageDialog(null, "No hay usuarios registrados");
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "🌟 TOP RECICLADOR 🌟\n\n" + top.toString(),
                            "Ranking",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        });
        btnTotalMaterial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int total = totalMaterialesReciclados();

                JOptionPane.showMessageDialog(
                        null,
                        "Total de material reciclado:\n\n" + total + " unidades",
                        "Impacto Ambiental",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
        btnMostrarPorUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idUsuario = Integer.parseInt(txtIDUsuario.getText());
                    mostrarMaterialesPorUsuario(idUsuario);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un ID válido");
                }
            }
        });
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        JFrame frame = new JFrame("EcoSistema ♻");
        frame.setContentPane(new Ventana().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null); // centrar
        frame.setVisible(true);
    }


}
