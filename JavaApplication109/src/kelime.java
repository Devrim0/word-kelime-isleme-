
import java.awt.event.ComponentListener;
import java.util.Scanner;

/*
 *
 * @author Devrim
 */
public class kelime extends javax.swing.JFrame {

    class dugum {

        public String kelime;
        public dugum ileri;

        public dugum(String kelime) {
            this.kelime = kelime;
            ileri = null;
        }

    }

    class yigit {

        dugum top, tmp;

        public yigit() {

            top = null;

        }

        boolean bosmu() {
            return top == null;
        }

        void ekle(dugum yeni) {
            if (bosmu()) { //if(top==null)
                top = yeni;
            } else {
                yeni.ileri = top;
                top = yeni;

            }
//word.setText(yeni.kelime);           // System.out.println(yeni.kelime);
        }

        dugum sil() {
            tmp = top;
            if (!bosmu()) {
                top = top.ileri;
            }

            return tmp;

        }

        dugum tepe() {
            if (!bosmu()) {
                return top;
            } else {
                return null;
            }
        }

    }

    yigit t;
    yigit t2;
    dugum sil, sil2;    dugum         sil3;
    Scanner k;
yigit yeni1,yeni2;
    public kelime() {
        initComponents();

        t = new yigit();
        t2 = new yigit();
        yeni1=new yigit();
        yeni2=new yigit();
        String gelen;
        k = new Scanner(word.getText());
        while (k.hasNext()) {

            gelen = k.nextLine();

            t.ekle(new dugum(gelen.substring(0,2)));
            yeni1.ekle(new dugum(gelen.substring(3,7)));

           //yeni2.ekle(new dugum(gelen.substring(, 27)));
          
           

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        word = new javax.swing.JTextArea();
        undo = new javax.swing.JButton();
        redo = new javax.swing.JButton();
        KAYDET = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        word.setColumns(20);
        word.setRows(5);
        word.setText("aa bb cc dd");
        jScrollPane1.setViewportView(word);

        undo.setText("UNDO");
        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });

        redo.setText("REDO");
        redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoActionPerformed(evt);
            }
        });

        KAYDET.setText("KAYDET");
        KAYDET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KAYDETActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(undo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(redo)
                .addGap(49, 49, 49))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(KAYDET)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(undo)
                    .addComponent(redo))
                .addGap(18, 18, 18)
                .addComponent(KAYDET)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void undoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoActionPerformed
 
        if (!t.bosmu()) {
            sil = t.sil();
           dugum sil4=yeni2.sil();
          sil3=yeni1.sil();
            System.out.println("1 yigit=" + sil.kelime);
                        System.out.println("ikinci yıgıt="+sil3.kelime);
                        System.out.println(sil4.kelime);
                        System.out.println();
            t2.ekle(sil); // sil verileri ikinci yigita ekler
t2.ekle(sil3);
                       
                        
                 word.setText("");
       } else {
            System.out.println("1.yigit redoya eklendi ");
        }

            }//GEN-LAST:event_undoActionPerformed

    private void redoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoActionPerformed
       
       sil3=t2.sil();
        if (!t2.bosmu()) {

            sil2 = t2.sil();   //sil2 ikinci yigiti birinci yigta ekler
            t.ekle(sil2);
            System.out.println("tekrar eklenen kelime=" + sil2.kelime); //sil2 ikinci yigiti birinci yigta ekler
            word.setText(" " + sil2.kelime);
        } else {
            System.out.println("2'inci yigıttan tekrar undoya eklendi ");
        }
       // System.out.println(sil2.kelime);

                             }//GEN-LAST:event_redoActionPerformed

    private void KAYDETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KAYDETActionPerformed

        t.sil();
        t2.sil();
        System.out.println("yıgıt boşaltıldı");

    }//GEN-LAST:event_KAYDETActionPerformed
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kelime().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton KAYDET;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton redo;
    private javax.swing.JButton undo;
    private javax.swing.JTextArea word;
    // End of variables declaration//GEN-END:variables
}
