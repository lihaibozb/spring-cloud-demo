package com.cloud.demo.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "t_account")
public class TAccount {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //禁止自动生成主键
    private Long id;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "account_sum")
    private BigDecimal accountSum;

    @Column(name = "modify_time")
    private String modifyTime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return account_name
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * @param accountName
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * @return account_sum
     */
    public BigDecimal getAccountSum() {
        return accountSum;
    }

    /**
     * @param accountSum
     */
    public void setAccountSum(BigDecimal accountSum) {
        this.accountSum = accountSum;
    }

    /**
     * @return modify_time
     */
    public String getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime
     */
    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
}