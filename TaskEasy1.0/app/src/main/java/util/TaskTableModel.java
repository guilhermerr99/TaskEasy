/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

/**
 *
 * @author Gui-notebook
 */
public class TaskTableModel extends AbstractTableModel {

    String[] columns = {"Nome", "Descrição", "Prazo", "Tarefa concluída", "Editar", "Excluir",};
    List<Task> task = new ArrayList();

    @Override
    public int getRowCount() {
        return task.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return columns[columnIndex];
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex){
        
      return columnIndex ==3;
      
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        if(task.isEmpty()){
            return Object.class;
        }
        return this.getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return task.get(rowIndex).getName();
            case 1:
                return task.get(rowIndex).getDescripiton();
            case 2:
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                
                return dateFormat.format(task.get(rowIndex).getDeadline());
            case 3:
                return task.get(rowIndex).getCompleted();
            case 4:
                return "";
            case 5:
                return "";
            default:
                return "Dados não encontrados";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        task.get(rowIndex).setCompleted((boolean) aValue);
    }
    
    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTask() {
        return task;
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }
    
}
