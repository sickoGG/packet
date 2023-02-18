package net.javaguides.springboot.controller;
import net.javaguides.springboot.dto.ProjectDto;
import net.javaguides.springboot.entity.Project;
import net.javaguides.springboot.repository.ProjectRepository;
import net.javaguides.springboot.service.ProjectService;
//import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/api/project")
@CrossOrigin("http://localhost:8080/")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/list")
    public List<Project> getAllProjectName(){
        return projectService.getProjectlist();
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody ProjectDto projectDto ){
        try {
            projectService.saveProject(projectDto);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{packetId}")
    public void deleteProject(@PathVariable("packetId") Integer packetId) {
        projectService.deleteProjectById(packetId);
    }

    @GetMapping("/get/{packetId}")
    public Project getProjectId(@PathVariable("packetId") Integer packetId){
        return projectService.getProjectById(packetId);
    }

}

