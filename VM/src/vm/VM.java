/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexy jr
 */
public class VM extends javax.swing.JFrame {

    /**
     * Creates new form VK
     */
    public VM() {
        initComponents();
        cargar();
        setLocationRelativeTo(this);
        LlenarListas();
        LlenadoTabla();
        //8 meses
    }

    public void LlenarListas() {
        Fechas.add("Julio");
        Fechas.add("Agosto");
        Fechas.add("Septiembre");
        Fechas.add("Octubre");
        Fechas.add("Noviembre");
        Fechas.add("Diciembre");
        Fechas.add("Enero");
        Fechas.add("Febrero");

        if (Totales.isEmpty()) {
            Totales.add(34500.00);
        }

        if (AbonoAgendado.isEmpty()) {
            AbonoAgendado.add(Totales.get(0) / 8);
        }
    }

    private void guardar() {
        Salvar = new Guardar();
        Salvar.LlenarAbonoAgendado(AbonoAgendado);
        Salvar.LlenarAbono(Abono);
        Salvar.LlenarDebito(Debito);
        Salvar.LlenarTotales(Totales);
        Salvar.LlenarTotalAbonado(TotalAbonado);
        try {
            File archivo = null;
            try {
                archivo = new File("./Binary.AOC");
                FileOutputStream fo = new FileOutputStream(archivo);
                ObjectOutputStream oo = new ObjectOutputStream(fo);
                oo.writeObject(Salvar);
                oo.close();
                fo.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "No se guardo correctamente",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se guardo correctamente",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void cargar() {
        try {
            File archivo = null;
            try {
                archivo = new File("./Binary.AOC");
                FileInputStream fo = new FileInputStream(archivo);
                ObjectInputStream oo = new ObjectInputStream(fo);
                Salvar = (Guardar) oo.readObject();

                for (int i = 0; i < Salvar.AbonoAgendado.size(); i++) {
                    AbonoAgendado.add(Salvar.AbonoAgendado.get(i));
                }

                for (int i = 0; i < Salvar.Abono.size(); i++) {
                    Abono.add(Salvar.Abono.get(i));
                }

                for (int i = 0; i < Salvar.Debito.size(); i++) {
                    Debito.add(Salvar.Debito.get(i));
                }

                for (int i = 0; i < Salvar.Totales.size(); i++) {
                    Totales.add(Salvar.Totales.get(i));
                }

                for (int i = 0; i < Salvar.TotalAbonado.size(); i++) {
                    TotalAbonado.add(Salvar.TotalAbonado.get(i));
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "No hay archivo guardado",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se cargo el archivo",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void LlenadoTabla() {
        DefaultTableModel ModeloTabla = (DefaultTableModel) jt_informacion.getModel();
        int Fila = 1;
        System.out.println(Fechas.size());
        System.out.println(Abono.size());
        System.out.println(AbonoAgendado.size());
        System.out.println(Debito.size());
        System.out.println(Totales.size());

        while (Fila < 9) {
            Object[] Row = new Object[6];

            Row[0] = Fechas.get(Fila - 1);

            if (Abono.size() >= Fila) {
                Row[1] = Abono.get(Fila - 1);
            }

            if (AbonoAgendado.size() >= Fila) {
                Row[2] = AbonoAgendado.get(Fila - 1);
            }

            if (Debito.size() >= Fila) {
                Row[3] = Debito.get(Fila - 1);
            }

            if (Totales.size() >= Fila) {
                Row[4] = Totales.get(Fila - 1);
            }

            if (TotalAbonado.size() >= Fila) {
                Row[5] = TotalAbonado.get(Fila - 1);
            }

            Fila++;
            ModeloTabla.addRow(Row);
        }
    }

    public void LimpiarTabla() {
        DefaultTableModel ModeloTabla = (DefaultTableModel) jt_informacion.getModel();

        for (int i = 0; i < jt_informacion.getRowCount(); i++) {
            ModeloTabla.removeRow(i);
            i -= 1;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jt_informacion = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtf_valor = new javax.swing.JTextField();
        jb_pagar = new javax.swing.JButton();
        jb_debitar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jt_informacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Abono", "Abono Agendado", "Debito", "Total Lps.", "Total Abonado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jt_informacion);
        if (jt_informacion.getColumnModel().getColumnCount() > 0) {
            jt_informacion.getColumnModel().getColumn(0).setResizable(false);
            jt_informacion.getColumnModel().getColumn(1).setResizable(false);
            jt_informacion.getColumnModel().getColumn(2).setResizable(false);
            jt_informacion.getColumnModel().getColumn(3).setResizable(false);
            jt_informacion.getColumnModel().getColumn(4).setResizable(false);
            jt_informacion.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel1.setText("Valor");

        jb_pagar.setText("Pago");
        jb_pagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_pagarMouseClicked(evt);
            }
        });

        jb_debitar.setText("Debito");
        jb_debitar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_debitarMouseClicked(evt);
            }
        });

        jLabel2.setText("Total Lps.");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("34,500");

        jButton1.setText("pruebas");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(25, 25, 25))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jb_pagar)
                        .addGap(18, 18, 18)
                        .addComponent(jb_debitar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jtf_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtf_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_pagar)
                    .addComponent(jb_debitar))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_formWindowClosing

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jb_pagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_pagarMouseClicked
        // TODO add your handling code here:
        boolean Seleccionado = true;
        if (jt_informacion.getSelectedRow() < 0) {
            Seleccionado = false;
        }

        if (!"".equals(jtf_valor.getText()) && !Pagado && Seleccionado) {
            DefaultTableModel ModeloTabla = (DefaultTableModel) jt_informacion.getModel();

            System.out.println(jt_informacion.getSelectedRow());
            if (Abono.size() > jt_informacion.getSelectedRow()) {
                Abono.set(jt_informacion.getSelectedRow(), Double.parseDouble(jtf_valor.getText()));
            } else {
                Abono.add(Double.parseDouble(jtf_valor.getText()));
            }

            if (jt_informacion.getSelectedRow() > 0) {
                AbonoAgendado.add(Totales.get(jt_informacion.getSelectedRow() - 1) / 8 - jt_informacion.getSelectedRow());
                Totales.add(Totales.get(jt_informacion.getSelectedRow() - 1) - Double.parseDouble(jtf_valor.getText()));
                TotalAbonado.add(TotalAbonado.get(jt_informacion.getSelectedRow() - 1) + Double.parseDouble(jtf_valor.getText()));
            } else {
                if (!TotalAbonado.isEmpty()) {
                    TotalAbonado.remove(0);
                }
                
                if (Totales.size() == 2) {
                    Totales.remove(1);
                }
                
                TotalAbonado.add(Double.parseDouble(jtf_valor.getText()));
                Totales.add(Totales.get(0) - Double.parseDouble(jtf_valor.getText()));
            }

            LimpiarTabla();
            LlenadoTabla();

            for (int i = 0; i < Totales.size(); i++) {
                if (Totales.get(i) <= 0) {
                    Pagado = true;
                }
            }
            
            jtf_valor.setText("");
            
        } else if ("".equals(jtf_valor.getText())) {
            JOptionPane.showMessageDialog(this, "El campo del valor esta vacio",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (!Seleccionado) {
            JOptionPane.showMessageDialog(this, "No hay fila seleccionada en la tabla",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Ya has completado el pago total",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            
            jtf_valor.setText("");
        }
    }//GEN-LAST:event_jb_pagarMouseClicked

    private void jb_debitarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_debitarMouseClicked
        // TODO add your handling code here:
        if (!"".equals(jtf_valor.getText())) {

        }
    }//GEN-LAST:event_jb_debitarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_debitar;
    private javax.swing.JButton jb_pagar;
    private javax.swing.JTable jt_informacion;
    private javax.swing.JTextField jtf_valor;
    // End of variables declaration//GEN-END:variables
    ArrayList<String> Fechas = new ArrayList();
    ArrayList<Double> AbonoAgendado = new ArrayList();
    ArrayList<Double> Abono = new ArrayList();
    ArrayList<Double> Debito = new ArrayList();
    ArrayList<Double> Totales = new ArrayList();
    ArrayList<Double> TotalAbonado = new ArrayList();

    Guardar Salvar;
    boolean Pagado = false;
}
