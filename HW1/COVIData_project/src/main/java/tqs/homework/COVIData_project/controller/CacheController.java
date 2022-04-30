package tqs.homework.COVIData_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/cache-statistics"})
public class CacheController {
    
    @GetMapping
    public String getCacheStatistics() {
        return "cache-statistics";
    }
    
}
