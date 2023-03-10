package cz.osu.vbap.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cz.osu.vbap.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    List<Video> findAllByTitleContaining(String partialTitle, Pageable pageable);
}
