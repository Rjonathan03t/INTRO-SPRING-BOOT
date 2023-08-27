package model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Posts {
    private int id_posts;
    private String posts_name;
    private String difficulty;
    private int importance;
    private String description;
}
