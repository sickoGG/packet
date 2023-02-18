package net.javaguides.springboot.service;

import lombok.RequiredArgsConstructor;
import net.javaguides.springboot.dto.ProjectDto;
import net.javaguides.springboot.entity.Project;
import net.javaguides.springboot.repository.ProjectRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getProjectlist(){
        return projectRepository.findAll();
    }

//    save page Project Plan
    public void saveProject(ProjectDto projectDto) {
        Project project = new Project();
        BeanUtils.copyProperties(projectDto, project);
        projectRepository.save(project);
    }

//    delete by id
    public void deleteProjectById(Integer packetId) {
        projectRepository.deleteById(packetId);
    }

//    get by id
    public Project getProjectById(Integer packetId) {
        Project NameId = projectRepository.findById(packetId).orElse(null);
        return NameId;
    }
}

