package com.jh.hotelbookingmanagement.service.implement;

import com.jh.hotelbookingmanagement.dto.request.InvoiceRequest;
import com.jh.hotelbookingmanagement.dto.response.InvoiceResponse;
import com.jh.hotelbookingmanagement.entity.Invoice;
import com.jh.hotelbookingmanagement.exception.AppException;
import com.jh.hotelbookingmanagement.exception.ErrorCode;
import com.jh.hotelbookingmanagement.mapper.InvoiceMapper;
import com.jh.hotelbookingmanagement.repository.*;
import com.jh.hotelbookingmanagement.service.InvoiceService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class InvoiceServiceImplement implements InvoiceService {

    BookingRepository bookingRepository;
    InvoiceRepository invoiceRepository;
    InvoiceMapper invoiceMapper;

    @NonFinal
    @Value("${invoice.tax}")
    double taxRate;

    @Override
    public InvoiceResponse generateInvoice(InvoiceRequest request) {
        Invoice invoice = invoiceMapper.toInvoice(request);
        invoice.setBooking(bookingRepository.findById(request.getBookingId())
                .orElseThrow(() -> new AppException(ErrorCode.BOOKING_NOT_FOUND)));
        invoice.setInvoiceDate(new Date());

    // Get and round total amount

        Double totalAmount = invoiceRepository.getTotalAmount(request.getBookingId());
        double safeTotalAmount = (totalAmount != null) ? totalAmount : 0.0;

        invoice.setTotalAmount(roundToTwoDecimalPlaces(safeTotalAmount));

    // Calculate discounted amount and round
        double discountedAmount = totalAmount * (1 - request.getPromotionInPercentage() / 100);
        invoice.setDiscountedAmount(roundToTwoDecimalPlaces(discountedAmount));

    // Set tax rate (assume taxRate is already defined)
        invoice.setTax(taxRate);

    // Calculate final amount and round
        double finalAmount = discountedAmount + discountedAmount * taxRate / 100;
        invoice.setFinalAmount(roundToTwoDecimalPlaces(finalAmount));

    // Save and return response
        return invoiceMapper.toInvoiceResponse(invoiceRepository.save(invoice));
    }

    // Utility method for rounding to two decimal places
    private double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }


    @Override
    public List<InvoiceResponse> getInvoicesByBookingId(String bookingId) {
        return List.of();
    }
}
