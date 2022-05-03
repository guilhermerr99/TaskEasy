package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

public class TaskController {
    //INSERT
    public void save(Task task){
        String sql = "INSERT INTO tasks (idProject,"
                                       + "name,"
                                       + "description, "
                                       + "notes,"
                                       + "completed,"
                                       + "deadline,"
                                       + "createdAt,"
                                       + "updateAt) VALUES (?,?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescripiton());
            statement.setString(4, task.getNotes());
            statement.setBoolean(5, task.getCompleted());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdateAt().getTime()));
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir a tarefa" + e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    //Atualizar
    public void update(Task task){
        String sql = "UPDATE tasks SET idProject = ?, name = ?, description = ?,  notes = ?, completed = ?, deadline = ?,  createdAt = ?, updateAt = ? WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            //Estabelecendo a conexão com BD
            conn = ConnectionFactory.getConnection();
            //Preparando a query
            statement = conn.prepareStatement(sql);
            //Setando os valores do statement
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescripiton());
            statement.setString(4, task.getNotes());
            statement.setBoolean(5, task.getCompleted());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdateAt().getTime()));
            statement.setInt(9, task.getId());
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar " + e.getMessage());
        }
    }
    //Delete
    public void removeById(int taskId) {
        
        String sql = "DELETE FROM tasks WHERE id= ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar a tarefa" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
   
            }
        }
    
    public List<Task> getAll(int idProject){
    
        String sql = "SELECT * FROM tasks WHERE idProject = ?";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        
        // Lista de tarefas que será devolvida quando houver chamada do método
        List<Task> tasks = new ArrayList<Task>();
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, idProject);
            result = statement.executeQuery();
            
            while (result.next()) {
                Task task = new Task();
                task.setId(result.getInt("id"));
                task.setIdProject(result.getInt("idProject"));
                task.setName(result.getString("name"));
                task.setDescripiton(result.getString("description"));
                task.setNotes(result.getString("notes"));
                task.setCompleted(result.getBoolean("completed"));
                task.setDeadline(result.getDate("deadline"));
                task.setCreatedAt(result.getDate("createdAt"));
                task.setUpdateAt(result.getDate("updateAt"));
                tasks.add(task);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar a tarefa" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, statement, result);
        }
        //Lista de tarefas que foi criada e carregada do BD
        return tasks;
    }
}

