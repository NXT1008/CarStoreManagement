
package Views.OtherForm.component.CustomJTable;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author RAVEN
 */
public class TableActionCellEditor_XemChiTietXe extends DefaultCellEditor {

    private TableActionEvent_XemChiTietXe event;

    public TableActionCellEditor_XemChiTietXe(TableActionEvent_XemChiTietXe event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        PanelAction_XemChiTietXe action = new PanelAction_XemChiTietXe();
        action.initEvent(event, row);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}
