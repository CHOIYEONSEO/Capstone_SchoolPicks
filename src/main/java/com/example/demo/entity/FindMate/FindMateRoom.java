package com.example.demo.entity.FindMate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FindMateRoom {
    @Id
    @GeneratedValue
    @Column(name = "FIND_MATE_ROOM_ID")
    private Long id;

    String roomId;

    String roomTitle;
    String shopName;

    @DateTimeFormat(pattern = "yyyy-MM-dd/HH:mm:ss")
    private LocalDateTime planTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd/HH:mm:ss")
    private LocalDateTime expiredTime;

    int headCount;

    String roomWriter;

    @Column(columnDefinition = "TEXT")
    private String roomMessage;

    boolean isPrivate;

    String roomPassword;

    int version;

    @OneToMany(mappedBy = "findMateRoom", cascade = CascadeType.REMOVE)
    @Fetch(FetchMode.JOIN)
    private List<RoomUser> roomUsers = new ArrayList<>();

    @Override
    public String toString() {
        return "FindMateRoom{" +
                "id=" + id +
                ", roomId='" + roomId + '\'' +
                ", roomTitle='" + roomTitle + '\'' +
                ", shopName='" + shopName + '\'' +
                ", planTime=" + planTime +
                ", headCount=" + headCount +
                ", roomWriter='" + roomWriter + '\'' +
                ", roomMessage='" + roomMessage + '\'' +
                ", isPrivate=" + isPrivate +
                ", roomPassword='" + roomPassword + '\'' +
                '}';
    }
}
