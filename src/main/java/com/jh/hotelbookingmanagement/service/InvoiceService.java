package com.jh.hotelbookingmanagement.service;

import com.jh.hotelbookingmanagement.dto.request.BookingDetailRequest;
import com.jh.hotelbookingmanagement.dto.request.BookingDetailUpdateRequest;
import com.jh.hotelbookingmanagement.dto.request.InvoiceRequest;
import com.jh.hotelbookingmanagement.dto.response.BookingDetailResponse;
import com.jh.hotelbookingmanagement.dto.response.InvoiceResponse;

import java.util.List;

public interface InvoiceService {
    public InvoiceResponse generateInvoice(InvoiceRequest request);


    public List<InvoiceResponse> getInvoicesByBookingId(String bookingId);
}
