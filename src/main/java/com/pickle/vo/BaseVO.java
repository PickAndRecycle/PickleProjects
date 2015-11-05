package com.pickle.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseVO implements Serializable {

    /**
     * Internal ID / Primary Key Domain / Autoincrement
     */
    @JsonIgnore
    private Integer internalId;

    /**
     * Secure ID / UUID
     */
    private String id;

    @JsonIgnore
    private Date creationDate;

    @JsonIgnore
    private String createdBy;

    @JsonIgnore
    private Date modificationDate;

    @JsonIgnore
    private String modifiedBy;

    @JsonIgnore
    private Integer version;

//    private Boolean active;
    @JsonIgnore
    private Boolean deleted;

    public Integer getInternalId() {
        return internalId;
    }

    public void setInternalId(Integer internalId) {
        this.internalId = internalId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

//    public Boolean getActive() {
//        return active;
//    }

//    public void setActive(Boolean active) {
//        this.active = active;
//    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "BaseVO{" +
                "internalId=" + internalId +
                ", id='" + id + '\'' +
                ", creationDate=" + creationDate +
                ", createdBy='" + createdBy + '\'' +
                ", modificationDate=" + modificationDate +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", version=" + version +
                ", deleted=" + deleted +
                '}';
    }
}
