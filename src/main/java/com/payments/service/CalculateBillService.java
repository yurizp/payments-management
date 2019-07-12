package com.payments.service;

import com.payments.dto.ResponseBillDTO;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

@Service
public class CalculateBillService {

    public ResponseBillDTO calculateWithTax(ResponseBillDTO billDTO) {
        return ResponseBillDTO.builder()
                .dateDue(billDTO.getDateDue())
                .name(billDTO.getName())
                .priceWithTax(getPriceWithTax(billDTO))
                .price(billDTO.getPrice())
                .payday(billDTO.getPayday())
                .build();
    }

    private Double getPriceWithTax(ResponseBillDTO billDTO) {
        Double tax = getTax(billDTO);
        return billDTO.getPrice() * tax;
    }

    private Double getTax(ResponseBillDTO billDTO) {
        long days = getDays(billDTO);
        if (days <= 0) {
            return 1D;
        }
        if (days <= 3) {
            return getPercentForPrice(days, 2.0, 0.1);
        }
        if (days > 5) {
            return getPercentForPrice(days, 5.0, 0.3);
        }
        if (days > 3) {
            return getPercentForPrice(days, 3.0, 0.2);
        }
        return 1D;
    }

    private Double getPercentForPrice(long days, double latePenalty, double interestDay) {
        return ((interestDay * days) + latePenalty) / 10 + 1;
    }

    private long getDays(ResponseBillDTO billDTO) {
        long days = ChronoUnit.DAYS.between(billDTO.getDateDue(), billDTO.getPayday());
        return Math.abs(days);
    }
}
