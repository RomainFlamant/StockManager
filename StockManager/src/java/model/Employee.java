package model;
// Generated 3 mars 2015 14:34:36 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name="employee"
    ,catalog="stockmanager"
)
public class Employee extends Metier implements java.io.Serializable {


     private long idEmployee;
     private String nameEmployee;
     private String firstNameEmployee;
     private String emailEmployee;
     private String mdpEmployee;
     private Integer isActive;
     private Set<Orders> orderses = new HashSet(0);

    public Employee() {
    }

	
    public Employee(long idEmployee) {
        this.idEmployee = idEmployee;
    }
    public Employee(long idEmployee, String nameEmployee, String firstNameEmployee, String emailEmployee, String mdpEmployee, Integer isActive, Set<Orders> orderses) {
       this.idEmployee = idEmployee;
       this.nameEmployee = nameEmployee;
       this.firstNameEmployee = firstNameEmployee;
       this.emailEmployee = emailEmployee;
       this.mdpEmployee = mdpEmployee;
       this.isActive = isActive;
       this.orderses = orderses;
    }
   
     @Id 

    
    @Column(name="IdEmployee", unique=true, nullable=false)
    public long getIdEmployee() {
        return this.idEmployee;
    }
    
    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
    }

    
    @Column(name="NameEmployee", length=65535)
    public String getNameEmployee() {
        return this.nameEmployee;
    }
    
    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    
    @Column(name="FirstNameEmployee", length=65535)
    public String getFirstNameEmployee() {
        return this.firstNameEmployee;
    }
    
    public void setFirstNameEmployee(String firstNameEmployee) {
        this.firstNameEmployee = firstNameEmployee;
    }

    
    @Column(name="EmailEmployee", length=65535)
    public String getEmailEmployee() {
        return this.emailEmployee;
    }
    
    public void setEmailEmployee(String emailEmployee) {
        this.emailEmployee = emailEmployee;
    }

    
    @Column(name="MdpEmployee", length=65535)
    public String getMdpEmployee() {
        return this.mdpEmployee;
    }
    
    public void setMdpEmployee(String mdpEmployee) {
        this.mdpEmployee = mdpEmployee;
    }

    
    @Column(name="IsActive")
    public Integer getIsActive() {
        return this.isActive;
    }
    
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="employee")
    public Set<Orders> getOrderses() {
        return this.orderses;
    }
    
    public void setOrderses(Set<Orders> orderses) {
        this.orderses = orderses;
    }




}


