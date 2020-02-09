package JDBC.cn.wzk.jdbc.domain;

import java.util.Date;

public class Emp {

    private int id;
    private String ename;
    private int jobId;
    private int mgr;
    private Date joinDate;
    private double bonus;
    private int deptId;

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", jobId=" + jobId +
                ", mgr=" + mgr +
                ", joinDate=" + joinDate +
                ", bonus=" + bonus +
                ", deptId=" + deptId +
                '}';
    }

    public Emp() {
    }

    public Emp(int id, String ename, int jobId, int mgr, Date joinDate, double bonus, int deptId) {
        this.id = id;
        this.ename = ename;
        this.jobId = jobId;
        this.mgr = mgr;
        this.joinDate = joinDate;
        this.bonus = bonus;
        this.deptId = deptId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
}
