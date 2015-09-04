package studenciak;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ViewReceivers extends javax.swing.JFrame {

    public static DefaultTableModel getNotEditableTable()
    {
        return new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
             return false;
            }

        };
    }
       public static void setCenterTable(JTable jTable1)
    {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for (int a=0; a<jTable1.getColumnCount(); a++)
            {
                jTable1.getColumnModel().getColumn(a).setCellRenderer(centerRenderer);
            }
    }
    static String Analog_text = "Analog";
    static String Binar_text = "Binar";
    private void setTable()
    {
        DefaultTableModel model = getNotEditableTable();
        String header[] = new String[] { "Id", "Nazwa", "Typ", "Min",
            "Max" };
        model.setRowCount(Dane.A + Dane.D);
        model.setColumnIdentifiers(header);
        for (int a=0; a<Dane.A; a++)
        {
            model.setValueAt(Dane.Analog[a].index, a, 0);
            model.setValueAt(Dane.Analog[a].ch_id, a, 1); //nazwa
            model.setValueAt(Analog_text, a, 2); 
            model.setValueAt(Dane.Analog[a].min, a, 3);
            model.setValueAt(Dane.Analog[a].max, a, 4);
        }
        for (int a=Dane.A; a<Dane.A+Dane.D; a++)
        {
            model.setValueAt(Dane.Binars[a-Dane.A].index, a, 0);
            model.setValueAt(Dane.Binars[a-Dane.A].ch_id, a, 1); //nazwa
            model.setValueAt(Binar_text, a, 2); 
            model.setValueAt("0", a, 3);
            model.setValueAt("1", a, 4);
        }
        jTable2.setModel(model);
        setCenterTable(jTable2);
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(500);
    }
    private void setCFGData()
    {
        JLabel[] jl = {station_name, rec_dev_id, rev_year, TT, A, D};
        Object[] j  = {Dane.station_name, Dane.rec_dev_id, Dane.rev_year, Dane.TT, Dane.A, Dane.D};
        for (int a=0; a<jl.length; a++)
        {
            jl[a].setText(jl[a].getText()+j[a]);
        }
    }
 //if true then returns only binary, otherwise returns digitals (indexes of static arrays)
    private List<Integer> getSelectedReceivers(boolean binary)
    {
        int[] tab = jTable2.getSelectedRows();
        List<Integer> wynik = new ArrayList<>();
        for (int a=0; a<tab.length; a++)
        {
            if (jTable2.getModel().getValueAt(tab[a],2)==Analog_text)  if (!binary) wynik.add(tab[a]);
            else if (binary) wynik.add(tab[a]);
        }
        return wynik;
    }
    public ViewReceivers()
    {
        initComponents();
        setCFGData();
        setTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        station_name = new javax.swing.JLabel();
        rec_dev_id = new javax.swing.JLabel();
        rev_year = new javax.swing.JLabel();
        TT = new javax.swing.JLabel();
        A = new javax.swing.JLabel();
        D = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nazwa", "Typ", "Min", "Max"
            }
        ));
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane2.setViewportView(jTable2);

        station_name.setText("Nazwa stacji: ");

        rec_dev_id.setText("Numer identyfikacyjny urządzenia: ");

        rev_year.setText("Wersja COMTRADE:  ");

        TT.setText("Suma kanałów: ");

        A.setText("Liczba kanałów analogowych: ");

        D.setText("Liczba kanałów binarnych: ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Dane z pliku CFG");

        jButton1.setText("GENERUJ XML");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(station_name)
                    .addComponent(rec_dev_id)
                    .addComponent(rev_year)
                    .addComponent(TT)
                    .addComponent(A)
                    .addComponent(jLabel1)
                    .addComponent(D)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(station_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rec_dev_id)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rev_year)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(A, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(D, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(28, 28, 28))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        List<Integer> binars = getSelectedReceivers(true);
        List<Integer> analogs = getSelectedReceivers(false);
        GetSavePath gsp = new GetSavePath(this, true);
        gsp.setVisible(true);
        String resultPath = gsp.getPath();
        if (resultPath!=null) 
        {
            Exception xml = Dane.makeXML(resultPath, binars, analogs);
            if (xml!=null) JOptionPane.showMessageDialog(this, "Wystąpił błąd: "+xml.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel A;
    private javax.swing.JLabel D;
    private javax.swing.JLabel TT;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel rec_dev_id;
    private javax.swing.JLabel rev_year;
    private javax.swing.JLabel station_name;
    // End of variables declaration//GEN-END:variables
}
