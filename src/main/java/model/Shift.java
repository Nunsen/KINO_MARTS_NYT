package model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Shift {
    //igen

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int shift_id;

    @ManyToOne //en medarbejder kan have mange shifts
    @JoinColumn(name = "employee_id", nullable = false) // Fremmednøgle fra Employee
    private Employee employee;
    private Date start_time;
    private Date end_time;
    private Date date_of_shift;
    private String role;

    public int getShift_id() {
        return shift_id;
    }
    //tester git

    public void setShift_id(int shift_id) {
        this.shift_id = shift_id;
    }

    public Employee getEmployee_id() {
        return employee;
    }

    public void setEmployee_id(Employee employee) {
        this.employee = employee;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Date getDate_of_shift() {
        return date_of_shift;
    }

    public void setDate_of_shift(Date date_of_shift) {
        this.date_of_shift = date_of_shift;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
