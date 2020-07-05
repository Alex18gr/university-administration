package io.alexc.studentsweb.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity @Data
@Table(name = "announcement")
public class Announcement {

    @Id
    @Column(name = "id_announcement")
    private Integer announcementId;

    @ManyToOne
    @JoinColumn(name="id_department", nullable=false)
    private Department department;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "ins_date")
    private Date insDate;

    @ManyToOne
    @JoinColumn(name="id_employee", nullable=false)
    private Employee creator;


}
