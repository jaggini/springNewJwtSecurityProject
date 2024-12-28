package com.example.springsecurityJwtProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.springsecurityJwtProject.Model.Video;






@EnableJpaRepositories

@Repository("jdbcVideoRepository")
public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findByAvailable(boolean available);

}