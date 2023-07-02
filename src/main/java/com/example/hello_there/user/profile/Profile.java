package com.example.hello_there.user.profile;

import com.example.hello_there.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;
    private String profileUrl; // 프로필 사진 URL
    private String profileFileName; // 프로필 사진명

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private User user;

    //==객체 생성 메서드==//
    public void setUser(User user){
        this.user = user;
    }
}