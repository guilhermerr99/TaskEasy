package model;

import java.util.Date;

public class Task {
    
    private int id;
    private int idProject;
    private String name;
    private String descripiton;
    private String notes;
    private boolean completed; 
    private Date deadline;
    private Date createdAt;
    private Date updateAt;

    public Task(int id, int idProject, String name, String descripiton, 
                String notes, boolean completed, Date deadline, Date createdAt, Date updateAt) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.descripiton = descripiton;
        this.notes = notes;
        this.completed = completed;
        this.deadline = deadline;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
    
    public Task(){
        this.createdAt = new Date();
        this.updateAt = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripiton() {
        return descripiton;
    }

    public void setDescripiton(String descripiton) {
        this.descripiton = descripiton;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", idProject=" + idProject + ", name=" + name + ", descripiton=" + descripiton + ", notes=" + notes + ", completed=" + completed + ", deadline=" + deadline + ", createdAt=" + createdAt + ", updateAt=" + updateAt + '}';
    }


}
