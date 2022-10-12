/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public final class CellObjectRenderer extends DefaultTableCellRenderer {

    Component component;

    public CellObjectRenderer() {

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (row % 2 == 0) {
            this.setBackground(new Color(238, 238, 238));
        } else {
            this.setBackground(Color.white);
        }
        table.getTableHeader().setBackground(Color.darkGray);
        table.setShowGrid(false);
        this.setBorder(BorderFactory.createEmptyBorder(3,20,3,3));
        table.setRowHeight(48);
        return this;
    }

}
