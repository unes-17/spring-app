package com.jobintech.springapp.Model;

import com.jobintech.springapp.Model.Enum.TypeStep;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.List;

import java.util.ArrayList;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private TypeStep type;
//    @ManyToMany(mappedBy = "ListStep")
//    private List<User> ListUsers;

    @ManyToOne
    private Course course;





}
