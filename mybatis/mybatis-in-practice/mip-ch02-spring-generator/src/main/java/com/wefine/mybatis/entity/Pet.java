package com.wefine.mybatis.entity;

import java.util.Date;

public class Pet {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pet.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pet.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pet.owner
     *
     * @mbg.generated
     */
    private String owner;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pet.species
     *
     * @mbg.generated
     */
    private String species;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pet.sex
     *
     * @mbg.generated
     */
    private String sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pet.birth
     *
     * @mbg.generated
     */
    private Date birth;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pet.death
     *
     * @mbg.generated
     */
    private Date death;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pet.id
     *
     * @return the value of pet.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pet.id
     *
     * @param id the value for pet.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pet.name
     *
     * @return the value of pet.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pet.name
     *
     * @param name the value for pet.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pet.owner
     *
     * @return the value of pet.owner
     *
     * @mbg.generated
     */
    public String getOwner() {
        return owner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pet.owner
     *
     * @param owner the value for pet.owner
     *
     * @mbg.generated
     */
    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pet.species
     *
     * @return the value of pet.species
     *
     * @mbg.generated
     */
    public String getSpecies() {
        return species;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pet.species
     *
     * @param species the value for pet.species
     *
     * @mbg.generated
     */
    public void setSpecies(String species) {
        this.species = species == null ? null : species.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pet.sex
     *
     * @return the value of pet.sex
     *
     * @mbg.generated
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pet.sex
     *
     * @param sex the value for pet.sex
     *
     * @mbg.generated
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pet.birth
     *
     * @return the value of pet.birth
     *
     * @mbg.generated
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pet.birth
     *
     * @param birth the value for pet.birth
     *
     * @mbg.generated
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pet.death
     *
     * @return the value of pet.death
     *
     * @mbg.generated
     */
    public Date getDeath() {
        return death;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pet.death
     *
     * @param death the value for pet.death
     *
     * @mbg.generated
     */
    public void setDeath(Date death) {
        this.death = death;
    }
}