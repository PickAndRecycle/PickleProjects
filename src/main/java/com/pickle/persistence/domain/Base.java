package com.pickle.persistence.domain;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public abstract class Base implements Serializable {

	private static final long serialVersionUID = -7369920601847524273L;

	public Base() {
	}

	@Id
	@GeneratedValue
    @Column(name = "ID")
	protected Integer id;

    /**
     * Random id for security reason
     */
    @Column(name = "SECURE_ID", unique = true, length = 36)
    private String secureId;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_CREATED", updatable = false)
	private Date creationDate;

    @CreatedBy
    @Column(name = "CREATED_BY", length = 30, updatable = false)
    private String createdBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_MODIFIED")
    private Date modificationDate;

    @LastModifiedBy
    @Column(name = "MODIFIED_BY", length = 30)
    private String modifiedBy;

	@Version
	@Column(name = "VERSION")
	private Integer version;

    @Column(name = "DELETED")
    private Boolean deleted;

    @PrePersist
    public void prePersist() {
        this.secureId = UUID.randomUUID().toString();
        this.deleted = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSecureId() {
        return secureId;
    }

    public void setSecureId(String hardToGuestId) {
        this.secureId = hardToGuestId;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getModifiedBy(){
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy){
        this.modifiedBy = modifiedBy;
    }

    public String getCreatedBy(){
        return  createdBy;
    }

    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Base base = (Base) o;

        if (id != null ? !id.equals(base.id) : base.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
