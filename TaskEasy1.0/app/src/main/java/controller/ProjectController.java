package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;


public class ProjectController {
    
    public void save(Project project){
        String sql = "INSERT INTO projects(name, description, createdAt, updateAt) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new java.sql.Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new java.sql.Date(project.getUpdateAt().getTime()));
            
            statement.execute();
            
            System.out.println(sql);
            System.out.println(statement);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir o Projeto", e);
        } finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public void update(Project project){
        String sql = "UPDATE projects SET name = ?, description = ?, createdAt = ?, updateAt = ? WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            //Cria uma conex�o com o banco
            conn = ConnectionFactory.getConnection();
            //Cria um PreparedStatment, classe usada para executar a query
            statement = conn.prepareStatement(sql);

            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new java.sql.Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new java.sql.Date(project.getUpdateAt().getTime()));
            statement.setInt(5, project.getId());

            //Executa a sql para inser��o dos dados
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o Projeto" + e);
        } finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public void removeById(int idProject){
        
        String sql = "DELETE FROM projects WHERE id= ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, idProject);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar a tarefa" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
   
            }
        }
    
    public List<Project> getAll(){
        String sql = "SELECT * FROM projects";
        
        List<Project> projects = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            result = statement.executeQuery();
            
            while(result.next()){
                
                Project project = new Project();
                
                project.setId(result.getInt("id"));
                project.setName(result.getString("name"));
                project.setDescription(result.getString("description"));
                project.setCreatedAt(result.getDate("createdAt"));
                project.setUpdateAt(result.getDate("updateAt"));
                
                projects.add(project);
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar a tarefa" + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, statement, result);
   
         }
        
        return projects;
        
    }
    }

