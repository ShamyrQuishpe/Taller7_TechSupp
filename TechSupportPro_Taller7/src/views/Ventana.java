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
    private JTextField txtConstelacion;
    private JTextField txtNivelPoder;
    private JTextField txtMision;
    private JTextField txtDificultad;
    private JTextField txtRecompensa;
    private JComboBox cmbRango;
    private JButton btnRegistrar;
    private JTextArea txtAreaResultados;
    private JTabbedPane tabbedPane2;
    private JTextField txtIdModificar;
    private JTextField txtNombreModificar;
    private JTextField txtConstelacionModificar;
    private JTextField txtNivelPoderModificar;
    private JTextField txtDificultadModificar;
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
    private CaballeroController controller;


    public Ventana() {
        controller = new CaballeroController();
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,700);
        setLocationRelativeTo(null);
        cmbRango.setModel(new DefaultComboBoxModel(new String[] {"Bronce", "Plata", "Oro"}));
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    int id = Integer.parseInt(txtId.getText());

                    String nombre = txtNombre.getText();

                    String rango = cmbRango.getSelectedItem().toString();

                    String constelacion = txtConstelacion.getText();

                    int nivelPoder = Integer.parseInt(txtNivelPoder.getText());

                    String mision = txtMision.getText();

                    int dificultad = Integer.parseInt(txtDificultad.getText());

                    double recompensa = Double.parseDouble(txtRecompensa.getText());

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

                        txtConstelacionModificar.setText(
                                caballero.getConstelacionCab()
                        );

                        txtNivelPoderModificar.setText(
                                String.valueOf(
                                        caballero.getNivelPoderCab()
                                )
                        );

                        txtMisionModificar.setText(
                                caballero.getMision()
                        );

                        txtDificultadModificar.setText(
                                String.valueOf(
                                        caballero.getDificultad()
                                )
                        );

                        txtRecompensaModificar.setText(
                                String.valueOf(
                                        caballero.getRecompensa()
                                )
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
                                    txtConstelacionModificar.getText(),
                                    Integer.parseInt(
                                            txtNivelPoderModificar.getText()
                                    ),
                                    txtMisionModificar.getText(),
                                    Integer.parseInt(
                                            txtDificultadModificar.getText()
                                    ),
                                    Double.parseDouble(
                                            txtRecompensaModificar.getText()
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

}
