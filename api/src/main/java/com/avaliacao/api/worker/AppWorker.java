package com.avaliacao.api.worker;

import com.avaliacao.api.model.TransferModel;
import com.avaliacao.api.model.enums.TransferStatus;
import com.avaliacao.api.service.TransferService;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.util.List;

public class AppWorker {

    private final TransferService service;

    public AppWorker(TransferService service) {
        this.service = service;
    }

    @Scheduled(cron = "*/2 * * * *")
    public void verifyScheduleDateAndChangeTransferStatus() throws Exception {

        System.out.println("Verifying.....");

        List<TransferModel> transferListToChangeStatus = service.findTransferByScheduleDate(LocalDate.now());

        for (TransferModel model : transferListToChangeStatus) {
            service.changeTransferStatus(model.getId(), TransferStatus.DONE);
        }
    }
}
