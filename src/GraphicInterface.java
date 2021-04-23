
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kami
 */
public class GraphicInterface extends javax.swing.JFrame {

    /**
     * Creates new form GraphicalInterface
     */
    public GraphicInterface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        EnterSequence1 = new javax.swing.JTextField();
        EnterSequence2 = new javax.swing.JTextField();
        SubmitRNA1 = new javax.swing.JButton();
        EnterParenthesis1 = new javax.swing.JTextField();
        EnterParenthesis2 = new javax.swing.JTextField();
        SubmitRNA2 = new javax.swing.JButton();
        SubmitFile1 = new javax.swing.JButton();
        SubmitFile2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BiggestSubtreeLauncher = new javax.swing.JButton();
        TxtDisplayTree1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        RNA1Tree = new javax.swing.JTextArea();
        TxtDisplayTree2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        RNA2Tree = new javax.swing.JTextArea();
        choiceOfElementToCompare = new javax.swing.JCheckBox();
        PatternResearchLaunchingButton = new javax.swing.JButton();
        Title = new javax.swing.JLabel();
        nameOfFile2 = new javax.swing.JLabel();
        nameOfFile1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ParenthesingRNA1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        ParenthesingRNA2 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        SequenceRNA1 = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        SequenceRNA2 = new javax.swing.JTextArea();
        resultPatternResearch = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        biggestSubTreeResult = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        EnterSequence1.setText("Enter sequence1");

        EnterSequence2.setText("Enter sequence 2");

        SubmitRNA1.setText("Submit");
        SubmitRNA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitRNA1ActionPerformed(evt);
            }
        });

        EnterParenthesis1.setText("Enter parenthesing1");

        EnterParenthesis2.setText("Enter parenthesing2");

        SubmitRNA2.setText("Submit");
        SubmitRNA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitRNA2ActionPerformed(evt);
            }
        });

        SubmitFile1.setText("Use file");
        SubmitFile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitFile1ActionPerformed(evt);
            }
        });

        SubmitFile2.setText("Use file");
        SubmitFile2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitFile2ActionPerformed(evt);
            }
        });

        jLabel1.setText("RNA 1");

        jLabel2.setText("RNA 2");

        BiggestSubtreeLauncher.setText("Biggest subtree in common");
        BiggestSubtreeLauncher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BiggestSubtreeLauncherActionPerformed(evt);
            }
        });

        TxtDisplayTree1.setText("Display RNA1 tree");

        RNA1Tree.setColumns(20);
        RNA1Tree.setRows(5);
        jScrollPane2.setViewportView(RNA1Tree);

        TxtDisplayTree2.setText("Display RNA2 tree");

        RNA2Tree.setColumns(20);
        RNA2Tree.setRows(5);
        jScrollPane4.setViewportView(RNA2Tree);

        choiceOfElementToCompare.setText("Just parenthesing");

        PatternResearchLaunchingButton.setText("RNA2 pattern present in RNA1 ");
        PatternResearchLaunchingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatternResearchLaunchingButtonActionPerformed(evt);
            }
        });

        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("RNA secondary structure comparison");

        nameOfFile2.setText("No file choosen");

        nameOfFile1.setText("No file choosen");

        ParenthesingRNA1.setColumns(20);
        ParenthesingRNA1.setRows(5);
        ParenthesingRNA1.setText("No parenthesing entered");
        jScrollPane1.setViewportView(ParenthesingRNA1);

        ParenthesingRNA2.setColumns(20);
        ParenthesingRNA2.setRows(5);
        ParenthesingRNA2.setText("No parenthesing entered");
        jScrollPane3.setViewportView(ParenthesingRNA2);

        SequenceRNA1.setColumns(20);
        SequenceRNA1.setRows(5);
        SequenceRNA1.setText("No sequence entered");
        jScrollPane6.setViewportView(SequenceRNA1);

        SequenceRNA2.setColumns(20);
        SequenceRNA2.setRows(5);
        SequenceRNA2.setText("No sequence entered");
        jScrollPane7.setViewportView(SequenceRNA2);

        resultPatternResearch.setText("No pattern research done");

        biggestSubTreeResult.setColumns(20);
        biggestSubTreeResult.setRows(5);
        jScrollPane8.setViewportView(biggestSubTreeResult);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(EnterParenthesis2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(SubmitRNA2))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(EnterSequence1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(EnterParenthesis1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(27, 27, 27)
                                                        .addComponent(SubmitRNA1)))
                                        .addComponent(EnterSequence2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(367, 367, 367)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(SubmitFile1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(nameOfFile1))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(SubmitFile2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(nameOfFile2)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TxtDisplayTree2)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(225, 225, 225))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(570, 570, 570)
                                                .addComponent(Title)
                                                .addGap(65, 65, 65)
                                                .addComponent(TxtDisplayTree1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(BiggestSubtreeLauncher)
                                                                .addGap(26, 26, 26)
                                                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(PatternResearchLaunchingButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(resultPatternResearch))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(67, 67, 67)
                                                .addComponent(choiceOfElementToCompare)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(Title)
                                                        .addComponent(TxtDisplayTree1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(EnterSequence1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(23, 23, 23)
                                                                .addComponent(EnterParenthesis1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(1, 1, 1)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(SubmitFile1)
                                                                        .addComponent(nameOfFile1)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(11, 11, 11)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(SubmitRNA1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel1))))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(39, 39, 39)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(SubmitRNA2)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(EnterSequence2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(EnterParenthesis2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(SubmitFile2)
                                                                                        .addComponent(nameOfFile2)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(TxtDisplayTree2)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGap(50, 50, 50)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(PatternResearchLaunchingButton)
                                                        .addComponent(resultPatternResearch))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(choiceOfElementToCompare)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(BiggestSubtreeLauncher)
                                                .addGap(65, 65, 65))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(41, 41, 41))))
        );

        pack();
    }// </editor-fold>

    private void SubmitFile1ActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileOpener = new JFileChooser();
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Texte", "txt");
        fileOpener.addChoosableFileFilter(fileFilter);
        fileOpener.setAcceptAllFileFilterUsed(false);
        int returnValue = fileOpener.showOpenDialog(this);
        if(returnValue == JFileChooser.APPROVE_OPTION){
            Brin input = BrinBuilder.lire_fichier(fileOpener.getSelectedFile().getPath());
            nameOfFile1.setText("You opened " + fileOpener.getSelectedFile().getName());
            ParenthesingRNA1.setText(input.appariement);
            SequenceRNA1.setText(input.sequence);
            RNA1Tree.setText(Tree.strandToTree(input).toString());
        }
    }

    private void PatternResearchLaunchingButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Brin RNA1 = new Brin(SequenceRNA1.getText(), ParenthesingRNA1.getText());
        Brin RNA2 = new Brin(SequenceRNA2.getText(), ParenthesingRNA2.getText());
        Boolean useSequence = !choiceOfElementToCompare.isSelected();
        if(RNA1.contains(RNA2, useSequence)){
            resultPatternResearch.setText("The pattern of RNA2 is present in RNA1");
        } else{
            resultPatternResearch.setText("The pattern of RNA2 is not present in RNA1");
        }

    }

    private void BiggestSubtreeLauncherActionPerformed(java.awt.event.ActionEvent evt) {
        Brin RNA1 = new Brin(SequenceRNA1.getText(), ParenthesingRNA1.getText());
        Brin RNA2 = new Brin(SequenceRNA2.getText(), ParenthesingRNA2.getText());
        Brin biggestCommonPattern = RNA1.biggestSubstrand(RNA2);
        biggestSubTreeResult.setText(Tree.strandToTree(biggestCommonPattern).toString());
    }

    private void SubmitRNA1ActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            Brin input = BrinBuilder.input_brin(this.EnterSequence1.getText(), this.EnterParenthesis1.getText());
            ParenthesingRNA1.setText(input.appariement);
            SequenceRNA1.setText(input.sequence);
            RNA1Tree.setText(Tree.strandToTree(input).toString());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Bad RNA1","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void SubmitRNA2ActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            Brin input = BrinBuilder.input_brin(this.EnterSequence1.getText(), this.EnterParenthesis1.getText());
            ParenthesingRNA2.setText(input.appariement);
            SequenceRNA2.setText(input.sequence);
            RNA2Tree.setText(Tree.strandToTree(input).toString());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Bad RNA2","Error",JOptionPane.ERROR_MESSAGE);
        }

    }

    private void SubmitFile2ActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileOpener = new JFileChooser();
        int returnValue = fileOpener.showOpenDialog(this);
        if(returnValue == JFileChooser.APPROVE_OPTION){
            Brin input = BrinBuilder.lire_fichier(fileOpener.getSelectedFile().getPath());
            nameOfFile2.setText("You opened " + fileOpener.getSelectedFile().getName());
            ParenthesingRNA2.setText(input.appariement);
            SequenceRNA2.setText(input.sequence);
            RNA2Tree.setText(Tree.strandToTree(input).toString());
        }
    }

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
            java.util.logging.Logger.getLogger(GraphicInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraphicInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraphicInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraphicInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphicInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton BiggestSubtreeLauncher;
    private javax.swing.JTextField EnterParenthesis1;
    private javax.swing.JTextField EnterParenthesis2;
    private javax.swing.JTextField EnterSequence1;
    private javax.swing.JTextField EnterSequence2;
    private javax.swing.JTextArea ParenthesingRNA1;
    private javax.swing.JTextArea ParenthesingRNA2;
    private javax.swing.JButton PatternResearchLaunchingButton;
    private javax.swing.JTextArea RNA1Tree;
    private javax.swing.JTextArea RNA2Tree;
    private javax.swing.JTextArea SequenceRNA1;
    private javax.swing.JTextArea SequenceRNA2;
    private javax.swing.JButton SubmitFile1;
    private javax.swing.JButton SubmitFile2;
    private javax.swing.JButton SubmitRNA1;
    private javax.swing.JButton SubmitRNA2;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel TxtDisplayTree1;
    private javax.swing.JLabel TxtDisplayTree2;
    private javax.swing.JTextArea biggestSubTreeResult;
    private javax.swing.JCheckBox choiceOfElementToCompare;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel nameOfFile1;
    private javax.swing.JLabel nameOfFile2;
    private javax.swing.JLabel resultPatternResearch;
    // End of variables declaration
}