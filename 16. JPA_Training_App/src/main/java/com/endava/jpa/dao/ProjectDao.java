package com.endava.jpa.dao;

import com.endava.jpa.model.Project;

import java.util.List;

public interface ProjectDao {

    public Project find(int id);

    public List<Project> find(String projectName);

    public void save(Project toBeSaved);

    public void update(Project toBeUpdated);

    public void remove(Project toBeRemoved);
}
