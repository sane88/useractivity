package com.vr.useractivity.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "T_USER_ACTIVITY_LOG")
public class UserActivity {

//    private User user;
//
//    private Date activityDate;
//
//    private Integer activityCount;
//
//
//    @ManyToOne
//    @JoinColumn(name = "USER_ID")
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    @Id
//    @Column(name = "ACTIVITY_DATE")
//    public Date getActivityDate() {
//        return activityDate;
//    }
//
//    public void setActivityDate(Date activityDate) {
//        this.activityDate = activityDate;
//    }
//
//    @Column(name = "ACTIVITY_COUNT")
//    public Integer getActivityCount() {
//        return activityCount;
//    }
//
//    public void setActivityCount(Integer activityCount) {
//        this.activityCount = activityCount;
//    }
   @EmbeddedId
    private UserRecordPK id = new UserRecordPK();

    public User getUser() {
        return id.user;
    }

    public void setUser(User user) {
        id.user = user;
    }


    public Date getActivityDate() {
        return id.activityDate;
    }

    public void setActivityDate(Date activityDate) {
        id.activityDate = activityDate;
    }

    public Integer getActivityCount() {
        return id.activityCount;
    }

    public void setActivityCount(Integer activityCount) {
        id.activityCount = activityCount;
    }

    @Embeddable
    private static class UserRecordPK implements Serializable{

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "USER_ID")
        private User user;

        @Column(name = "ACTIVITY_DATE")
        private Date activityDate;

        @Column(name = "ACTIVITY_COUNT")
        private Integer activityCount;

    }
}
