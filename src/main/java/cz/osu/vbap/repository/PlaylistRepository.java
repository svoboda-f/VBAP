package cz.osu.vbap.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cz.osu.vbap.model.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long>{
    List<Playlist> findAllByUserId(long userId, Pageable pageable);
}
