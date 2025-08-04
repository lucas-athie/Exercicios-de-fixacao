package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {

        double monthValue = contract.getTotalValue()/months;

        for(int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(months);

            double interest = onlinePaymentService.interest(monthValue, i);
            double fee = onlinePaymentService.paymentFee(monthValue + interest);
            double quota = monthValue + fee + interest;

            contract.getInstallments().add(new Installment(dueDate, quota));
        }

    }

}
