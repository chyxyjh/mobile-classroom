package cn.edu.bupt.mobileclassroom.model;

import java.io.Serializable;

public class StudentClass extends StudentClassKey implements Serializable {
    private Boolean attendFlag;

    private static final long serialVersionUID = 1L;

    public Boolean getAttendFlag() {
        return attendFlag;
    }

    public void setAttendFlag(Boolean attendFlag) {
        this.attendFlag = attendFlag;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        StudentClass other = (StudentClass) that;
        return (this.getStudentId() == null ? other.getStudentId() == null : this.getStudentId().equals(other.getStudentId()))
            && (this.getClassId() == null ? other.getClassId() == null : this.getClassId().equals(other.getClassId()))
            && (this.getAttendFlag() == null ? other.getAttendFlag() == null : this.getAttendFlag().equals(other.getAttendFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStudentId() == null) ? 0 : getStudentId().hashCode());
        result = prime * result + ((getClassId() == null) ? 0 : getClassId().hashCode());
        result = prime * result + ((getAttendFlag() == null) ? 0 : getAttendFlag().hashCode());
        return result;
    }
}