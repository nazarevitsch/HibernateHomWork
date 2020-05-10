package com.bida.dbconection.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "Developer")
@Table(name = "developers")
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
public class Developer {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id_developer")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "sex")
    @Type(type = "pgsql_enum")
    private Sex sex;
    @Column(name = "it_company_id")
    private long itCompanyId;
    @Column(name = "salary")
    private BigDecimal salary;

    public Developer(long id, String name, int age, String sex, long itCompanyId, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.itCompanyId = itCompanyId;
        this.salary = salary;
        this.sex = Sex.getSex(sex);
    }

    public Developer(long id, String name, int age, Sex sex, long itCompanyId, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.itCompanyId = itCompanyId;
        this.salary = salary;
        this.sex = sex;
    }

    public Developer(String name, int age, Sex sex, long itCompanyId, BigDecimal salary) {
        this.name = name;
        this.age = age;
        this.itCompanyId = itCompanyId;
        this.salary = salary;
        this.sex = sex;
    }

    public Developer(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setSex(String sex) {
        this.sex = Sex.getSex(sex);
    }

    public long getItCompanyId() {
        return itCompanyId;
    }

    public void setItCompanyId(long itCompanyId) {
        this.itCompanyId = itCompanyId;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", itCompanyId=" + itCompanyId +
                ", salary=" + salary +
                '}';
    }
}
