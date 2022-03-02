package com.pranavkhavare.pmt.web;

import com.pranavkhavare.pmt.domain.Project;
import com.pranavkhavare.pmt.services.ProjectService;
import com.pranavkhavare.pmt.utility.ErrorUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    /**
     * Creates new Project in DB and return an HTTP status.
     *
     * @param project
     * @return
     * @Valid removes 500 error and descriptive error
     * BindingResult interface invokes the validator on the object to check if there are error
     */
    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {
        ResponseEntity<Map<String, String>> errorMap = ErrorUtility.FieldErrorMap(result);
        if (errorMap != null) {
            return errorMap;
        }
        Project project1 = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<>(project1, HttpStatus.CREATED);
    }
}
