package com.avaliacao.api.model;

import com.avaliacao.api.model.enums.TransferStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "tb_transfers")
public class TransferModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="account_origin_id", nullable=false)
    private AccountModel origin;

    @ManyToOne
    @JoinColumn(name="account_destination_id", nullable=false)
    private AccountModel destination;

    @Column(name = "transfer_effective_date")
    private LocalDate transferEffectiveDate;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Enumerated(EnumType.STRING)
    private TransferStatus status;

    private BigDecimal amount;

    @Column(name = "amount_fee")
    private BigDecimal amountFee;

}
