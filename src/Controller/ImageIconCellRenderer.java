/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Iformatique
 */
public final class ImageIconCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        JLabel label = (JLabel) component;

        if (value instanceof ImageIcon) {
            ImageIcon icon = (ImageIcon) value;

            if (icon.getImageLoadStatus() == java.awt.MediaTracker.COMPLETE) {
                label.setIcon(icon);
            } else {
                label.setIcon(null);
            }
            label.setText(""); // on efface le texte
        } else {
            label.setIcon(null);
            table.setRowHeight(row, table.getRowHeight());
        }
        this.setHorizontalAlignment(SwingConstants.CENTER);
        return component;
    }
}
