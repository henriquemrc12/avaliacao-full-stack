package com.avaliacao.api.service.impl;

import com.avaliacao.api.dto.TransferCreateDto;
import com.avaliacao.api.dto.TransferFeeDto;
import com.avaliacao.api.model.AccountModel;
import com.avaliacao.api.model.TransferModel;
import com.avaliacao.api.model.enums.TransferStatus;
import com.avaliacao.api.repository.TransferRepository;
import com.avaliacao.api.service.AccountService;
import com.avaliacao.api.service.TransferService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

    private final TransferRepository repository;

    private final AccountService accountService;

    public TransferServiceImpl(TransferRepository repository, AccountService accountService) {
        this.repository = repository;
        this.accountService = accountService;
    }

    @Override
    public void create(TransferCreateDto dto) throws Exception {
        try {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate scheduleDate = LocalDate.parse(dto.getScheduleDate(), formatter);

            AccountModel originAccount = accountService.findByAccountNumber(dto.getOrigin());
            AccountModel destinationAccount = accountService.findByAccountNumber(dto.getDestination());

            TransferModel transferModel = new TransferModel();
            transferModel.setCreatedAt(LocalDate.now());
            transferModel.setStatus(TransferStatus.SCHEDULED);
            transferModel.setOrigin(originAccount);
            transferModel.setDestination(destinationAccount);
            transferModel.setTransferEffectiveDate(scheduleDate);
            transferModel.setAmountFee(getFeeAmount(dto.getAmount(), scheduleDate));
            transferModel.setAmount(dto.getAmount());
            repository.save(transferModel);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public TransferFeeDto findTransferFees(BigDecimal amount, LocalDate scheduleDate) throws Exception {
        try {
            TransferFeeDto transferFee = new TransferFeeDto();
            transferFee.setFeeAmount(getFeeAmount(amount, scheduleDate));
            return transferFee;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<TransferModel> findAll() {
        try {
            return (List<TransferModel>) repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void changeTransferStatus(Long id, TransferStatus status) throws Exception {
        try {
            TransferModel transferModelFounded = findById(id);
            transferModelFounded.setStatus(status);
            repository.save(transferModelFounded);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<TransferModel> findTransferByScheduleDate(LocalDate date) {
        try {
            return repository.findAllByTransferEffectiveDate(date);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public TransferModel findById(Long id) throws Exception {
        try {
            return repository.findById(id)
                    .orElseThrow(() -> new Exception("Transferência não encontrada"));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    private BigDecimal getFeeAmount(BigDecimal amount, LocalDate scheduleDate) throws Exception {
        try {

            long days = ChronoUnit.DAYS.between(LocalDate.now(), scheduleDate);

            if (days == 0 || amount.compareTo(new BigDecimal("1000")) < 0) {
                amount = amount.multiply(new BigDecimal("0.03"));
                return amount.add(new BigDecimal("3.00"));
            } else if (days > 0 && days <= 10 || amount.compareTo(new BigDecimal("1001")) > 0 && amount.compareTo(new BigDecimal("2000")) < 0) {
                return new BigDecimal("12.00");
            } else if (amount.compareTo(new BigDecimal("2000")) > 0) {
                if (days > 10 && days <= 20) {
                    return amount.multiply(new BigDecimal("0.082"));
                } else if (days > 20 && days <= 30) {
                    return amount.multiply(new BigDecimal("0.069"));
                } else if (days > 30 && days <= 40) {
                    return amount.multiply(new BigDecimal("0.047"));
                } else if (days > 40) {
                    return amount.multiply(new BigDecimal("0.017"));
                }
            }

            throw new Exception("Não há taxa aplicável. Tente novamente!");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
