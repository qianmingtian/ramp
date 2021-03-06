/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BroadcastClientProgramConfigJFrame.java
 *
 * Created on 22-mar-2010, 11.49.09
 */

package it.unibo.deis.lia.ramp.service.application;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;

/**
 *
 * @author useruser
 */
public class BroadcastServiceProgramConfigJFrame extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BroadcastService.BroadcastServiceProgramHandler programHandler;

    /** Creates new form BroadcastClientProgramConfigJFrame */
    public BroadcastServiceProgramConfigJFrame(BroadcastService.BroadcastServiceProgramHandler programHandler) {
        initComponents();
        
        this.programHandler = programHandler;
        this.jButtonRefreshParametersActionPerformed(null);
        this.chckbxParsing.setSelected(programHandler.isStreamParsing());
        //this.jCheckBoxSmartSplitterActionPerformed(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCheckBoxQualityTailor = new javax.swing.JCheckBox();
        jButtonRefreshParameters = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldSplitterAmount = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jCheckBoxQualityTailor.setText("quality tailoring");
        jCheckBoxQualityTailor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxQualityTailorActionPerformed(evt);
            }
        });

        jButtonRefreshParameters.setText("refresh parameters");
        jButtonRefreshParameters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshParametersActionPerformed(evt);
            }
        });

        jLabel8.setText("splitterAmount =");

        jTextFieldSplitterAmount.setColumns(4);
        jTextFieldSplitterAmount.setEditable(false);
        jTextFieldSplitterAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSplitterAmountActionPerformed(evt);
            }
        });
        
        chckbxParsing = new JCheckBox();
        chckbxParsing.setText("parsing");
        chckbxParsing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jCheckBoxParsingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jCheckBoxQualityTailor)
        					.addGap(18)
        					.addComponent(chckbxParsing, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel8)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jTextFieldSplitterAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jButtonRefreshParameters)))
        			.addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel8)
        				.addComponent(jTextFieldSplitterAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButtonRefreshParameters))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jCheckBoxQualityTailor)
        				.addComponent(chckbxParsing))
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxQualityTailorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxQualityTailorActionPerformed
        boolean selected = this.jCheckBoxQualityTailor.getModel().isSelected();
        if(selected){
            programHandler.setQualityTailoring(true);
        }
        else{
            programHandler.setQualityTailoring(false);
        }
    }//GEN-LAST:event_jCheckBoxQualityTailorActionPerformed

    private void jButtonRefreshParametersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshParametersActionPerformed
        /*this.jTextFieldRtpIn.setText(""+programHandler.rtpIn);
        this.jTextFieldRtpDe.setText(""+programHandler.rtpDe);
        this.jTextFieldPdvIn.setText(""+programHandler.pdvIn);
        this.jTextFieldPdvDe.setText(""+programHandler.pdvDe);*/
        this.jTextFieldSplitterAmount.setText(""+programHandler.getSplitterAmount());
        this.jCheckBoxQualityTailor.setSelected(programHandler.isQualityTailoring());
    }//GEN-LAST:event_jButtonRefreshParametersActionPerformed
    
    private void jTextFieldSplitterAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSplitterAmountActionPerformed
        // do nothing
    }//GEN-LAST:event_jTextFieldSplitterAmountActionPerformed

    private void jCheckBoxParsingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxRawBytesActionPerformed
        boolean selected = this.chckbxParsing.getModel().isSelected();
        if(selected){
        	programHandler.setStreamParsing(true);
        } else{
        	programHandler.setStreamParsing(false);
        }
    }
    
    private javax.swing.JButton jButtonRefreshParameters;
    private javax.swing.JCheckBox jCheckBoxQualityTailor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextFieldSplitterAmount;
    private JCheckBox chckbxParsing;
    // End of variables declaration//GEN-END:variables

}
