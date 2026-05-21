package views;

import controllers.CaballeroController;
import models.Caballero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
    private JPanel panelPrincipal;
    private JTabbedPane tabbedPane1;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtMision;
    private JComboBox cmbRango;
    private JButton btnRegistrar;
    private JTextArea txtAreaResultados;
    private JTabbedPane tabbedPane2;
    private JTextField txtIdModificar;
    private JTextField txtNombreModificar;
    private JTextField txtConstelacionModificar;
    private JTextField txtMisionModificar;
    private JTextField txtRecompensaModificar;
    private JTextField txtBuscarId;
    private JButton btnBuscar;
    private JTextArea txtAreaModificar;
    private JButton btnModificar;
    private JComboBox cmbRangoModificar;
    private JTabbedPane tabbedPane3;
    private JButton btnListar;
    private JTabbedPane tabbedPane4;
    private JComboBox cmbCaballerosReporte;
    private JTextArea txtAreaCalculo;
    private JButton btnCalcular;
    private JTextArea txtAreaListar;
    private JSpinner spnDific;
    private JSpinner spnNvlPoder;
    private JComboBox BoxConstelcion;
    private JComboBox BoxConst;
    private JSpinner spnPoderMod;
    private JSpinner spnDifMod;
    private JSpinner spnMonedasMod;
    private JSpinner spnMonedas;
    private CaballeroController controller;


    public Ventana() {
        controller = new CaballeroController();
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,700);
        setLocationRelativeTo(null);
        precargarDatos();
        cmbRango.setModel(new DefaultComboBoxModel(new String[] {"Bronce", "Plata", "Oro"}));
        BoxConstelcion.setModel(new DefaultComboBoxModel(new String[] {"Pégaso", "Dragón", "Cisne", "Andrómeda", "Fénix", "Aries", "Tauro", "Géminis", "Cáncer", "Leo", "Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario", "Piscis", "Águila", "Ofiuco", "Lira", "Lagarto", "Ballena", "Perseo", "Cefeo"}));
        BoxConst.setModel(new DefaultComboBoxModel(new String[] {"Pégaso", "Dragón", "Cisne", "Andrómeda", "Fénix", "Aries", "Tauro", "Géminis", "Cáncer", "Leo", "Virgo", "Libra", "Escorpio", "Sagitario", "Capricornio", "Acuario", "Piscis", "Águila", "Ofiuco", "Lira", "Lagarto", "Ballena", "Perseo", "Cefeo"}));

        spnNvlPoder.setModel(new SpinnerNumberModel(1, 1, 10, 1));
        spnDific.setModel(new SpinnerNumberModel(1, 1, 5, 1));
        spnMonedas.setModel(new SpinnerNumberModel(0.0, 0.0, 1000000.0, 500.0));

        spnPoderMod.setModel(new SpinnerNumberModel(1, 1, 10, 1));
        spnDifMod.setModel(new SpinnerNumberModel(1, 1, 5, 1));
        spnMonedasMod.setModel(new SpinnerNumberModel(0.0, 0.0, 1000000.0, 500.0));



        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    int id = Integer.parseInt(txtId.getText());

                    String nombre = txtNombre.getText();

                    String rango = cmbRango.getSelectedItem().toString();

//                    String constelacion = txtConstelacion.getText();
                    String constelacion =  BoxConstelcion.getSelectedItem().toString();

//                    int nivelPoder = Integer.parseInt(txtNivelPoder.getText());
                    int nivelPoder = Integer.parseInt(spnNvlPoder.getValue().toString());

                    String mision = txtMision.getText();

                    int dificultad = Integer.parseInt(spnDific.getValue().toString());

                    double recompensa = Double.parseDouble(spnMonedas.getValue().toString());

                    if (controller.buscarPorId(id) != null) {
                        JOptionPane.showMessageDialog(null,
                                "Error: El ID " + id + " ya se encuentra registrado.",
                                "ID Duplicado",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    Caballero caballero = new Caballero(
                            id,
                            nombre,
                            rango,
                            constelacion,
                            nivelPoder,
                            mision,
                            dificultad,
                            recompensa
                    );

                    controller.registrarCaballero(caballero);
                    cmbCaballerosReporte.addItem(
                            id + " - " + nombre
                    );

                    txtAreaResultados.append(caballero.toString() + "\n");

                    JOptionPane.showMessageDialog(null,
                            "Registro exitoso");

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(null,
                            "Error en los datos");
                }
            }
        });
        cmbRangoModificar.setModel(new DefaultComboBoxModel(new String[] {"Bronce", "Plata", "Oro"}));
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    int id = Integer.parseInt(
                            txtIdModificar.getText()
                    );

                    Caballero caballero =
                            controller.buscarPorId(id);

                    if (caballero != null) {

                        txtNombreModificar.setText(
                                caballero.getNombreCab()
                        );

                        cmbRangoModificar.setSelectedItem(
                                caballero.getRangoCab()
                        );

                        BoxConst.setSelectedItem(caballero.getConstelacionCab());

                        spnPoderMod.setValue(caballero.getNivelPoderCab());

                        txtMisionModificar.setText(
                                caballero.getMision()
                        );
                        spnDifMod.setValue(
                                caballero.getDificultad()
                        );

                        spnMonedasMod.setValue(
                                        caballero.getRecompensa()
                        );

                        txtAreaModificar.setText(caballero.toString());

                    } else {

                        JOptionPane.showMessageDialog(null,
                                "Caballero no encontrado");
                    }

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(null,
                            "Error en búsqueda");
                    System.out.println(ex);
                }
            }

        });
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    int id = Integer.parseInt(
                            txtIdModificar.getText()
                    );

                    boolean modificado =
                            controller.modificarCaballero(
                                    id,
                                    txtNombreModificar.getText(),
                                    cmbRangoModificar
                                            .getSelectedItem()
                                            .toString(),
                                    BoxConst.getSelectedItem().toString(),
                                    Integer.parseInt(
                                            spnPoderMod.getValue().toString()
                                    ),

                                    txtMisionModificar.getText(),
                                    Integer.parseInt(
                                            spnDifMod.getValue().toString()
                                    ),
                                    Double.parseDouble(
                                            spnMonedasMod.getValue().toString()
                                    )
                            );

                    if (modificado) {

                        txtAreaModificar.append(
                                "\nCaballero modificado correctamente\n"
                        );

                        JOptionPane.showMessageDialog(
                                null,
                                "Modificación exitosa"
                        );

                    } else {

                        JOptionPane.showMessageDialog(
                                null,
                                "No se pudo modificar"
                        );
                    }

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Error al modificar"
                    );
                }
            }

        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtAreaListar.setText("");

                txtAreaListar.append(
                        "===== LISTA CABALLEROS =====\n\n"
                );

                for (Caballero c :
                        controller.listarCaballeros()) {

                    txtAreaListar.append(
                            c.toString() + "\n"
                    );
                }
            }
        });
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String seleccionado =
                            cmbCaballerosReporte
                                    .getSelectedItem()
                                    .toString();

                    String[] partes =
                            seleccionado.split(" - ");

                    int id =
                            Integer.parseInt(partes[0]);

                    Caballero caballero =
                            controller.buscarPorId(id);

                    if (caballero != null) {

                        double aporte =
                                caballero.getRecompensa() * 0.10;

                        double impuesto = 0;

                        if (caballero.getRecompensa() > 50000 &&
                                caballero.getRecompensa() <= 200000) {

                            impuesto =
                                    caballero.getRecompensa() * 0.12;

                        } else if (
                                caballero.getRecompensa() > 200000) {

                            impuesto =
                                    caballero.getRecompensa() * 0.15;
                        }

                        double neto =
                                caballero.getRecompensa()
                                        - aporte
                                        - impuesto;

                        txtAreaCalculo.setText("");

                        txtAreaCalculo.append(
                                "===== REPORTE =====\n\n"
                        );

                        txtAreaCalculo.append(
                                caballero.toString() + "\n\n"
                        );

                        txtAreaCalculo.append(
                                "Aporte Santuario: $" +
                                        aporte + "\n"
                        );

                        txtAreaCalculo.append(
                                "Impuesto Reino: $" +
                                        impuesto + "\n"
                        );

                        txtAreaCalculo.append(
                                "Recompensa Neta: $" +
                                        neto + "\n"
                        );

                    }

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Error al calcular"
                    );
                }
            }

        });
    }

    // Método para precargar datos de prueba al iniciar la aplicación
    private void precargarDatos() {
        // Caballero 1 (Bronce)
        Caballero c1 = new Caballero(1, "Seiya", "Bronce", "Pégaso", 85, "Proteger a Athena", 3, 15000.0);
        // Caballero 2 (Plata)
        Caballero c2 = new Caballero(5, "Marin", "Plata", "Águila", 90, "Entrenar aspirantes", 4, 60000.0);
        // Caballero 3 (Oro)
        Caballero c3 = new Caballero(12, "Aioria", "Oro", "Leo", 100, "Custodiar la Casa de Leo", 5, 250000.0);

        // Guardar en el controlador
        controller.registrarCaballero(c1);
        controller.registrarCaballero(c2);
        controller.registrarCaballero(c3);

        // Sincronizar con el ComboBox de la pestaña de Cálculos/Reportes
        cmbCaballerosReporte.addItem(c1.getId() + " - " + c1.getNombreCab());
        cmbCaballerosReporte.addItem(c2.getId() + " - " + c2.getNombreCab());
        cmbCaballerosReporte.addItem(c3.getId() + " - " + c3.getNombreCab());

        // Opcional: Mostrar los datos iniciales en el txtAreaResultados de la primera pestaña
        txtAreaResultados.append("--- Datos Iniciales Precargados ---\n");
        txtAreaResultados.append(c1.toString() + "\n");
        txtAreaResultados.append(c2.toString() + "\n");
        txtAreaResultados.append(c3.toString() + "\n");
    }
}
