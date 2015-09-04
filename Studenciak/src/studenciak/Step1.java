package studenciak;

import static studenciak.Dane.endsamp;

public class Step1 extends javax.swing.JFrame {


    public Step1() {
        initComponents();
    }
    public void runLoading()
    {
        this.setVisible(false);
        Step0 step0 = new Step0(this);
        step0.setVisible(true);
        String[] data = step0.getPaths();
        this.setVisible(true);
        Loading loading = new Loading(data[0], data[1], this);
        loading.start();
    }
    public void setProgress(float cur, float max)
    {
         current.setText(cur+"/"+endsamp);
         progress.setValue( (int) ((cur/endsamp)*100));
    }
    public void setError(String title, String text)
    {
        this.title.setText(title);
        this.text.setText(text);
        this.current.setVisible(false);
        this.progress.setVisible(false);
    }
    public void dataLoaded()
    {
        this.dispose();
        new ViewReceivers().setVisible(true);
    }
    class Loading extends Thread
    {
        String s1,s2;
        Step1 gui;
        Loading(String s1, String s2, Step1 gui)
        {
           this.s1 = s1;
           this.s2 = s2;
           this.gui = gui;
        }
        @Override
        public void run()
        {
            Exception ex = Dane.loadData(s1, s2, gui);
            if (ex!=null) setError("Wystąpił błąd", ex.getMessage());
            gui.dataLoaded();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        current = new javax.swing.JLabel();
        progress = new javax.swing.JProgressBar();
        title = new javax.swing.JLabel();
        text = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        current.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        current.setText("1000/10000");

        title.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Proszę czekać");

        text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text.setText("Trwa ładowanie danych");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(current, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(247, Short.MAX_VALUE)
                .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(246, 246, 246))
            .addComponent(title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text)
                .addGap(29, 29, 29)
                .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(current)
                .addGap(120, 120, 120))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel current;
    private javax.swing.JProgressBar progress;
    private javax.swing.JLabel text;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
