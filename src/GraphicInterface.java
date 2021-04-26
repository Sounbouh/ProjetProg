
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GraphicInterface extends javax.swing.JFrame {
    // Declaration des variables
    private javax.swing.JTextField EnterParenthesis1;
    private javax.swing.JTextField EnterParenthesis2;
    private javax.swing.JTextField EnterSequence1;
    private javax.swing.JTextField EnterSequence2;
    private javax.swing.JTextArea ParenthesingRNA1;
    private javax.swing.JTextArea ParenthesingRNA2;
    private javax.swing.JTextArea RNA1Tree;
    private javax.swing.JTextArea RNA2Tree;
    private javax.swing.JTextArea SequenceRNA1;
    private javax.swing.JTextArea SequenceRNA2;
    private javax.swing.JTextArea biggestSubTreeResult;
    private javax.swing.JCheckBox choiceOfElementToCompare;
    private javax.swing.JLabel nameOfFile1;
    private javax.swing.JLabel nameOfFile2;
    private javax.swing.JLabel resultPatternResearch;
    /**
     * Crée nouvelle interface graphique
     */
    public GraphicInterface() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RNA Comparison");
        //Initialisation des éléments graphiques pour ARN1
        javax.swing.JLabel nameRNA1 = new javax.swing.JLabel();
        EnterSequence1 = new javax.swing.JTextField();
        SequenceRNA1 = new javax.swing.JTextArea();
        javax.swing.JScrollPane sequenceRNA1scroll = new javax.swing.JScrollPane();

        EnterParenthesis1 = new javax.swing.JTextField();
        ParenthesingRNA1 = new javax.swing.JTextArea();
        javax.swing.JScrollPane parenthesingRNA1scroll = new javax.swing.JScrollPane();

        javax.swing.JButton submitRNA1 = new javax.swing.JButton();

        javax.swing.JButton submitFile1 = new javax.swing.JButton();
        nameOfFile1 = new javax.swing.JLabel();

        RNA1Tree = new javax.swing.JTextArea();
        javax.swing.JLabel txtDisplayTree1 = new javax.swing.JLabel();
        javax.swing.JScrollPane rna1TreeScrollPane = new javax.swing.JScrollPane();

        //Initialisation des éléments graphiques pour ARN2
        javax.swing.JLabel nameRNA2 = new javax.swing.JLabel();

        EnterSequence2 = new javax.swing.JTextField();
        javax.swing.JScrollPane sequenceRNA2scroll = new javax.swing.JScrollPane();
        SequenceRNA2 = new javax.swing.JTextArea();

        EnterParenthesis2 = new javax.swing.JTextField();
        javax.swing.JScrollPane parenthesingRNA2scroll = new javax.swing.JScrollPane();
        ParenthesingRNA2 = new javax.swing.JTextArea();

        javax.swing.JButton submitRNA2 = new javax.swing.JButton();

        javax.swing.JButton submitFile2 = new javax.swing.JButton();
        nameOfFile2 = new javax.swing.JLabel();

        RNA2Tree = new javax.swing.JTextArea();
        javax.swing.JLabel txtDisplayTree2 = new javax.swing.JLabel();
        javax.swing.JScrollPane rna2TreeScrollPane = new javax.swing.JScrollPane();

        //Eléments graphiques pour la recherche de présence du motif de l'ARN2 dans 1
        javax.swing.JButton patternResearchLaunchingButton = new javax.swing.JButton();
        resultPatternResearch = new javax.swing.JLabel();
        choiceOfElementToCompare = new javax.swing.JCheckBox();

        //Elements graphiques pour la recherche du plus grand sous arbre communs
        javax.swing.JButton biggestSubtreeLauncher = new javax.swing.JButton();
        javax.swing.JScrollPane biggestSubtreeScroll = new javax.swing.JScrollPane();
        biggestSubTreeResult = new javax.swing.JTextArea();



        //Paramètres des éléments graphiques
        nameRNA1.setText("RNA 1");
        nameRNA2.setText("RNA 2");

        EnterSequence1.setText("Enter sequence1");
        EnterSequence2.setText("Enter sequence 2");
        EnterParenthesis1.setText("Enter parenthesing1");
        EnterParenthesis2.setText("Enter parenthesing2");
        submitRNA1.setText("Submit");
        submitRNA1.addActionListener(evt -> SubmitRNAActionPerformed(1));
        submitRNA2.setText("Submit");
        submitRNA2.addActionListener(evt -> SubmitRNAActionPerformed(2));

        nameOfFile2.setText("No file choosen");
        nameOfFile1.setText("No file choosen");
        submitFile1.setText("Use file");
        submitFile1.addActionListener(evt -> SubmitFileActionPerformed(1));
        submitFile2.setText("Use file");
        submitFile2.addActionListener(evt -> SubmitFileActionPerformed(2));

        ParenthesingRNA1.setColumns(20);
        ParenthesingRNA1.setRows(5);
        ParenthesingRNA1.setText("No parenthesing entered");
        parenthesingRNA1scroll.setViewportView(ParenthesingRNA1);
        ParenthesingRNA2.setColumns(20);
        ParenthesingRNA2.setRows(5);
        ParenthesingRNA2.setText("No parenthesing entered");
        parenthesingRNA2scroll.setViewportView(ParenthesingRNA2);

        SequenceRNA1.setColumns(20);
        SequenceRNA1.setRows(5);
        SequenceRNA1.setText("No sequence entered");
        sequenceRNA1scroll.setViewportView(SequenceRNA1);
        SequenceRNA2.setColumns(20);
        SequenceRNA2.setRows(5);
        SequenceRNA2.setText("No sequence entered");
        sequenceRNA2scroll.setViewportView(SequenceRNA2);

        RNA1Tree.setColumns(30);
        RNA1Tree.setRows(5);
        rna1TreeScrollPane.setViewportView(RNA1Tree);
        txtDisplayTree1.setText("Display RNA1 tree");
        RNA2Tree.setColumns(30);
        RNA2Tree.setRows(5);
        rna2TreeScrollPane.setViewportView(RNA2Tree);
        txtDisplayTree2.setText("Display RNA2 tree");

        patternResearchLaunchingButton.setText("RNA2 pattern present in RNA1 ");
        patternResearchLaunchingButton.addActionListener(this::PatternResearchLaunchingButtonActionPerformed);
        resultPatternResearch.setText("No pattern research done");
        choiceOfElementToCompare.setText("Use only parenthesing to compare");

        biggestSubtreeLauncher.setText("Biggest subtree in common");
        biggestSubtreeLauncher.addActionListener(this::BiggestSubtreeLauncherActionPerformed);
        biggestSubTreeResult.setColumns(40);
        biggestSubTreeResult.setRows(5);
        biggestSubtreeScroll.setViewportView(biggestSubTreeResult);

        //Disposition horizontale et verticale des éléments graphiques
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(/*position horizontale des éléments*/
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nameRNA1)
                                        .addComponent(nameRNA2))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(EnterSequence2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(EnterParenthesis2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(27, 27, 27)
                                                        .addComponent(submitRNA2))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(EnterSequence1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(EnterParenthesis1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(27, 27, 27)
                                                        .addComponent(submitRNA1)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(367, 367, 367)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(parenthesingRNA2scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sequenceRNA1scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sequenceRNA2scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(parenthesingRNA1scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(submitFile1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(nameOfFile1))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(submitFile2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(nameOfFile2)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDisplayTree1)
                                        .addComponent(rna1TreeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDisplayTree2)
                                        .addComponent(rna2TreeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(biggestSubtreeLauncher)
                                                                .addGap(26, 26, 26)
                                                                .addComponent(biggestSubtreeScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(patternResearchLaunchingButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(resultPatternResearch))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(67, 67, 67)
                                                .addComponent(choiceOfElementToCompare)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup( /*position verticale des éléments*/
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtDisplayTree1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rna1TreeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(EnterSequence1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(23, 23, 23)
                                                                .addComponent(EnterParenthesis1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(1, 1, 1)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(submitFile1)
                                                                        .addComponent(nameOfFile1)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(sequenceRNA1scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(parenthesingRNA1scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(11, 11, 11)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(submitRNA1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(nameRNA1))))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(39, 39, 39)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(submitRNA2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(nameRNA2)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(sequenceRNA2scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(parenthesingRNA2scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(EnterSequence2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(EnterParenthesis2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(submitFile2)
                                                                                        .addComponent(nameOfFile2)))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(txtDisplayTree2)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(rna2TreeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGap(50, 50, 50)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(patternResearchLaunchingButton)
                                                        .addComponent(resultPatternResearch))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(choiceOfElementToCompare)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(biggestSubtreeLauncher)
                                                .addGap(65, 65, 65))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(biggestSubtreeScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(41, 41, 41))))
        );

        pack();
    }

    /**
     * Methode pour choisir un fichier texte quand on clique sur un bouton submit file
     * Elle utilise la méthode readFile de BrinBuilder pour lire le fichier
     * puis insère la séquence et le parenthésage dans les Jlabel dédiés
     * affiche l'arbre
     * @param RNA numero du RNA auxquels les champs à remplir sont associés
     */
    private void SubmitFileActionPerformed(int RNA) {
        JFileChooser fileOpener = new JFileChooser();

        //Empecher l'utilisateur de voir des fichiers autres que .txt
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Texte", "txt");
        fileOpener.addChoosableFileFilter(fileFilter);
        fileOpener.setAcceptAllFileFilterUsed(false);

        //Ouverture du file chooser
        int returnValue = fileOpener.showOpenDialog(this);
        if(returnValue == JFileChooser.APPROVE_OPTION){
            Strand input = StrandBuilder.readFile(fileOpener.getSelectedFile().getPath());
            if (RNA == 1){
                nameOfFile1.setText("You opened " + fileOpener.getSelectedFile().getName());/*fichier ouvert*/
                ParenthesingRNA1.setText(input.parenthesing);
                SequenceRNA1.setText(input.sequence);
                RNA1Tree.setText(Tree.strandToTree(input).toString());
            } else{
                nameOfFile2.setText("You opened " + fileOpener.getSelectedFile().getName());
                ParenthesingRNA2.setText(input.parenthesing);
                SequenceRNA2.setText(input.sequence);
                RNA2Tree.setText(Tree.strandToTree(input).toString());
            }

        }
    }

    /**
     * Methode pour lancer la recherche du plus grand sous arbre commun
     * Elle donne l'affichage de l'arbre obtenu dans le champ biggestSubTreeResult
     * @param evt
     */
    private void BiggestSubtreeLauncherActionPerformed(java.awt.event.ActionEvent evt) {
        Strand RNA1 = new Strand(SequenceRNA1.getText(), ParenthesingRNA1.getText());
        Strand RNA2 = new Strand(SequenceRNA2.getText(), ParenthesingRNA2.getText());
        Strand biggestCommonPattern = RNA1.biggestSubstrand(RNA2);
        biggestSubTreeResult.setText(Tree.strandToTree(biggestCommonPattern).toString());
    }

    /**
     * Methode pour lancer la recherche de motif, elle donne le résultat dans resultPatternResearch
     * et tient compte de la checkBox ChoiceOfElementToCompare
     */
    private void PatternResearchLaunchingButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Strand RNA1 = new Strand(SequenceRNA1.getText(), ParenthesingRNA1.getText());
        Strand RNA2 = new Strand(SequenceRNA2.getText(), ParenthesingRNA2.getText());
        boolean useSequence = !choiceOfElementToCompare.isSelected();
        if(RNA1.contains(RNA2, useSequence)){
            resultPatternResearch.setText("The pattern of RNA2 is present in RNA1");
        } else{
            resultPatternResearch.setText("The pattern of RNA2 is not present in RNA1");
        }

    }

    /**
     * Methode pour écrire manuellement la séquence et le parenthésage d' un ARN donné
     * @param RNA numero du RNA auxquels les champs à remplir sont associés
     */
    private void SubmitRNAActionPerformed(int RNA) {
        try{
            if (RNA == 1){
                Strand input = StrandBuilder.input_brin(this.EnterSequence1.getText(), this.EnterParenthesis1.getText());
                ParenthesingRNA1.setText(input.parenthesing);
                SequenceRNA1.setText(input.sequence);
                RNA1Tree.setText(Tree.strandToTree(input).toString());
            } else{
                Strand input = StrandBuilder.input_brin(this.EnterSequence2.getText(), this.EnterParenthesis2.getText());
                ParenthesingRNA2.setText(input.parenthesing);
                SequenceRNA2.setText(input.sequence);
                RNA2Tree.setText(Tree.strandToTree(input).toString());
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Bad RNA"+RNA,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }


    /**
     * Lance l'affichage graphique
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraphicInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Crée et montre l' interface*/
        java.awt.EventQueue.invokeLater(() -> new GraphicInterface().setVisible(true));
    }
}
