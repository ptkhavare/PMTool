package com.pranavkhavare.pmt.services;

import com.pranavkhavare.pmt.domain.Project;
import com.pranavkhavare.pmt.exceptions.ProjectIdentifierException;
import com.pranavkhavare.pmt.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    /**
     * Creates or Updates Project Object in database.
     *
     * @param project
     * @return
     */
    public Project saveOrUpdateProject(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdentifierException(" Project Identifier " + project.getProjectIdentifier().toUpperCase() + " is duplicate!");
        }
    }


}
