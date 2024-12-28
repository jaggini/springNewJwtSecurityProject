package com.example.springsecurityJwtProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springsecurityJwtProject.Model.Video;
import com.example.springsecurityJwtProject.service.VideoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/videos")
@RequiredArgsConstructor
public class VideoController {
    @Autowired
    VideoService videoServiece;

    @GetMapping
    public ResponseEntity<List<Video>> getAllVideo() {
        return ResponseEntity.ok(videoServiece.getAllVideo());

    }

    @GetMapping("/available")
    public ResponseEntity<List<Video>> getAvialableAllVideo() {
        return ResponseEntity.ok(videoServiece.findAllVideos());

    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Video> createVideo(@RequestBody Video video) {
        return ResponseEntity.status(HttpStatus.CREATED).body(videoServiece.cretVideo(video));
    }

    // @PostMapping("/{id}")
    // @PreAuthorize("hasRole('ADMIN')")
    // public ResponseEntity<Video> updateVideo(@PathVariable Long id, @RequestBody
    // Video v) {
    // return ResponseEntity.ok(videoServiece.updatVideo(id, v));
    // }

    // @DeleteMapping("/{id}")
    // @PreAuthorize("hasRole('ADMIN')")
    // public ResponseEntity<Video> updateVideo(@PathVariable Long id) {
    // videoServiece.deleteVideo(id);
    // return ResponseEntity.noContent().build();
    // }
}