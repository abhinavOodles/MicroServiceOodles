package com.example.user.service.UserService.Model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Hotel {

    private  String id;
    private  String name;
    private  String location;
    private  String about;

}
