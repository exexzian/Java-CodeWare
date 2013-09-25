/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testCode;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SwingConstants;

/** @see http://stackoverflow.com/a/14858272/230513 */
public class DynamicGroupLayout extends JPanel {

    JButton addRecordButton;
    JTextField[] fieldsArray;
    JLabel[] labelsArray;
    GroupLayout layout;
    JScrollPane scrollPane;

    public DynamicGroupLayout() {
        addRecordButton = new JButton("add record");
        layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        setTextFields();
        scrollPane = new JScrollPane();
        scrollPane.setViewport(new JViewport() {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(320, 240);
            }
        });
        scrollPane.setViewportView(this);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        JOptionPane.showOptionDialog(null, scrollPane, "Update data",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
    }

    private void setTextFields() {
        int num = 30;
        fieldsArray = new JTextField[num];
        labelsArray = new JLabel[num];

        for (int i = 0; i < num; i++) {
            labelsArray[i] = new JLabel(String.valueOf(i + 1));
            fieldsArray[i] = new JTextField(String.valueOf(i + 1));
            labelsArray[i].setLabelFor(fieldsArray[i]);
        }
        GroupLayout.ParallelGroup parallelGroupHoriz = layout.createParallelGroup();
        layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(parallelGroupHoriz));
        GroupLayout.SequentialGroup sequentialGroupVert = layout.createSequentialGroup();
        layout.setVerticalGroup(sequentialGroupVert);
        for (int i = 0; i < num; i++) {
            System.out.println(i);
            parallelGroupHoriz.addGroup(layout.createSequentialGroup().
                addComponent(labelsArray[i]).addComponent(fieldsArray[i]));
            sequentialGroupVert.addGroup(layout.createParallelGroup().
                addComponent(labelsArray[i]).addComponent(fieldsArray[i]));
        }
        parallelGroupHoriz.addComponent(addRecordButton, GroupLayout.Alignment.CENTER);
        sequentialGroupVert.addComponent(addRecordButton);

        for (int i = 0; i < num; i++) {
            layout.linkSize(SwingConstants.HORIZONTAL, labelsArray[i], labelsArray[0]);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                DynamicGroupLayout d = new DynamicGroupLayout();
            }
        });
    }
}