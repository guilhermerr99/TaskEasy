
package util;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import model.Task;

/**
 *
 * @author Gui-notebook
 */
public class DeadLineColumnCellRenderer extends DefaultTableCellRenderer{
    
        
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int col){
        
        JLabel label;
        label = (JLabel)super.getTableCellRendererComponent(table,
                value, isSelected, hasFocus, row, col);
        
        label.setHorizontalAlignment(CENTER);
        
        TaskTableModel taskModel = (TaskTableModel)table.getModel();
        Task task = taskModel.getTask().get(row);
        
        if (task.getDeadline().after(new Date())) {
            label.setBackground(Color.GREEN);
            
        } else{
            label.setBackground(Color.RED);
        }
        
        return label;
    }
}
