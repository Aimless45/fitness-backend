package com.fitness.activityservice.controller;

import com.fitness.activityservice.ActivityRepository;
import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.model.Activity;
import com.fitness.activityservice.service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@AllArgsConstructor
public class ActivityController {
    private final ActivityService activityService;
    private final ActivityRepository activityRepository;
    @PostMapping
    public ResponseEntity<ActivityResponse>trackActivity(@RequestBody ActivityRequest request){
        return ResponseEntity.ok(activityService.trackActivity(request));
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Activity>> getActivitiesByUser(
            @PathVariable String userId) {

        return ResponseEntity.ok(
                activityRepository.findByUserId(userId)
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteActivity(
            @PathVariable String id) {

        activityRepository.deleteById(id);

        return ResponseEntity.ok("Activity Deleted");
    }

}
