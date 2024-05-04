
package Views.OtherForm.component.CustomJTable;


import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class CellRender_ModelXe extends JPanel implements TableCellRenderer {
    private JPanel panel;

    public CellRender_ModelXe() {
        setLayout(new BorderLayout());
        panel = new JPanel();
        add(panel, BorderLayout.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof JPanel) {
            panel = (JPanel) value;
            return panel;
        } else {
            return this;
        }
    }
}

