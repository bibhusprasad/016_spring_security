package com.bibhu.eazybank.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notice_details")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private int noticeId;
    @Column(name = "notice_summary")
    private String noticeSummary;
    @Column(name = "notice_details")
    private String noticeDetails;
    @Column(name = "notic_beg_dt")
    private Date noticBegDt;
    @Column(name = "notic_end_dt")
    private Date noticEndDt;
    @Column(name = "create_dt")
    private Date createDt;
    @Column(name = "update_dt")
    private Date updateDt;

    public Notice() {
    }

    public Notice(final String noticeSummary, final String noticeDetails, final Date noticBegDt, final Date noticEndDt, final Date createDt, final Date updateDt) {
        this.noticeSummary = noticeSummary;
        this.noticeDetails = noticeDetails;
        this.noticBegDt = noticBegDt;
        this.noticEndDt = noticEndDt;
        this.createDt = createDt;
        this.updateDt = updateDt;
    }

    public int getNoticeId() {
        return this.noticeId;
    }

    public void setNoticeId(final int noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeSummary() {
        return this.noticeSummary;
    }

    public void setNoticeSummary(final String noticeSummary) {
        this.noticeSummary = noticeSummary;
    }

    public String getNoticeDetails() {
        return this.noticeDetails;
    }

    public void setNoticeDetails(final String noticeDetails) {
        this.noticeDetails = noticeDetails;
    }

    public Date getNoticBegDt() {
        return this.noticBegDt;
    }

    public void setNoticBegDt(final Date noticBegDt) {
        this.noticBegDt = noticBegDt;
    }

    public Date getNoticEndDt() {
        return this.noticEndDt;
    }

    public void setNoticEndDt(final Date noticEndDt) {
        this.noticEndDt = noticEndDt;
    }

    public Date getCreateDt() {
        return this.createDt;
    }

    public void setCreateDt(final Date createDt) {
        this.createDt = createDt;
    }

    public Date getUpdateDt() {
        return this.updateDt;
    }

    public void setUpdateDt(final Date updateDt) {
        this.updateDt = updateDt;
    }
}
