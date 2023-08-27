package model;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Schedules {
    private int id_Schedules;
    private LocalDateTime working_time;
    private LocalDateTime break_time;
    private int id_posts;
}
