package com.example.demo.entity.FindMate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RoomUser {

    @Id @GeneratedValue
    @Column(name = "ROOM_USER_ID")
    private Long Id;

    private String userName;

    @ManyToOne
    @JoinColumn(name = "FIND_MATE_ROOM_ID")
    private FindMateRoom findMateRoom;


    @Override
    public String toString() {
        return "RoomUser{" +
                "Id=" + Id +
                ", userName='" + userName + '\'' +
                '}';
    }

}
