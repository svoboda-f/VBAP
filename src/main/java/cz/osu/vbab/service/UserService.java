package cz.osu.vbab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.osu.vbab.model.User;
import cz.osu.vbab.model.rest.PrivateUserInfo;
import cz.osu.vbab.model.rest.PublicUserInfo;
import cz.osu.vbab.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthService authService;

    public PublicUserInfo getInfo(long id) throws Exception {
        User user = this.userRepository.findById(id).orElseThrow(() -> new Exception());
        return new PublicUserInfo(user.getUsername(), user.getUploadedVideos(), user.getPlaylists());
    }

    public void updateInfo(PrivateUserInfo privateUserInfo) {
        User currentUser = this.authService.getCurrentUser();
        currentUser.setDateOfBirth(privateUserInfo.dateOfBirth());
        currentUser.setFirstName(privateUserInfo.firstName());
        currentUser.setLastName(privateUserInfo.lastName());
        this.userRepository.save(currentUser);
    }
}