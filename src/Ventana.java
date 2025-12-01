import javax.swing.*;
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

    //Crear el codigo y la Lista
    int codigo=0;
    EcoSistema sis=new EcoSistema();
    ListaMateriales mat=new ListaMateriales();

    public Ventana() {

        //Definir el modelo del spinner
        SpinnerNumberModel snm=new SpinnerNumberModel(1,1,100,1);
        spnPuntaje.setModel(snm);
        SpinnerNumberModel snm1=new SpinnerNumberModel(1,1,100,1);
        spnCantidad.setModel(snm1);

        //Agregar Usuario
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(txtId.getText());
                String nombre=txtNombre.getText();
                String rol=cmbRol.getSelectedItem().toString();
                int puntaje=Integer.parseInt(spnPuntaje.getValue().toString());
                String zona=cmbZona.getSelectedItem().toString();

                if(id<=codigo){
                    JOptionPane.showMessageDialog(null,"Id no valido");
                }else{
                    Usuario usuario=new Usuario(id,nombre,rol,puntaje,zona);
                    sis.agregar(usuario);
                    JOptionPane.showMessageDialog(null,"Usuario Agregado");
                    codigo=id;
                }
            }
        });

        //Mostrar Usuarios
        btnMostarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel dlm=new DefaultListModel<>();
                for(Usuario usuario:sis.todos()){
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
                    JOptionPane.showMessageDialog(null,"Usuario Encontrado");
                    txtId1.setText(""+encontrado.getId());
                    txtNombre1.setText(""+encontrado.getNombre());
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
                int id=Integer.parseInt(txtId1.getText());
                String nombre=txtNombre1.getText();
                String rol=cmbRol1.getSelectedItem().toString();
                int puntaje=Integer.parseInt(spnPuntaje1.getValue().toString());
                String zona=cmbZona1.getSelectedItem().toString();

                Usuario editar=new Usuario(id,nombre,rol,puntaje,zona);
                if(sis.editar(id,editar)){
                    JOptionPane.showMessageDialog(null,"Edición correcta, muestre los datos");
                }else {
                    JOptionPane.showMessageDialog(null,"No se permite cambiar el ID");
                }
            }
        });

        //Agregar Material
        btnAgregar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo=cmbTipo.getSelectedItem().toString();
                int cantidad=Integer.parseInt(spnCantidad.getValue().toString());
                String fecha=txtFecha.getText();
                int id=Integer.parseInt(txtIdUsuario.getText());

                Usuario encontrado = sis.buscar(id);

                if (encontrado != null) {
                    JOptionPane.showMessageDialog(null,"Usuario Encontrado");
                    MaterialReciclado material=new MaterialReciclado(tipo,cantidad,fecha,id);
                    mat.agregar(material);
                    JOptionPane.showMessageDialog(null,"Material Agregado");
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
                DefaultListModel dlm=new DefaultListModel<>();
                for(MaterialReciclado material:mat.todos()){
                    dlm.addElement(material.toString());
                }
                lstMateriales.setModel(dlm);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
