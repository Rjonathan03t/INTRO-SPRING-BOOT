package model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Collaborators {
    private int id_collaborators;
    private String first_name;
    private String last_name;
    private String sex;
    private String birth_date;
    private String email;
    private int posts;
    private int status;
}
