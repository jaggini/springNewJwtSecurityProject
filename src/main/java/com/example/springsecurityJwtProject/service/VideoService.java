package com.example.springsecurityJwtProject.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.springsecurityJwtProject.Model.Video;
import com.example.springsecurityJwtProject.repositories.VideoRepository;



public class VideoService {
    @Autowired
    VideoRepository videoRepository;
    public List<Video> getAllVideo()
    {
        return videoRepository.findAll();

    }
    public Video cretVideo(Video video)
    {
        return videoRepository.save(video);
    }

    public Video updatVideo(Long id,Video videoDetaials)
    {
        Video v=videoRepository.findById(id).orElseThrow(()->  new RuntimeException("video not found Exception"+id));
        v.setTitle(videoDetaials.getTitle());
        v.setDirector(videoDetaials.getDirector());
        v.setGenre(videoDetaials.getGenre());
        v.setAvailable(videoDetaials.isAvailable());
        return videoRepository.save(v);
    }
    public void deleteVideo(Long id)
    {
        Video v=videoRepository.findById(id).orElseThrow(()->  new RuntimeException("video not found Exception"+id));
    videoRepository.delete(v);
    }
    public List<Video> findAllVideos()
    {
        return videoRepository.findByAvailable(true);
    }
}
