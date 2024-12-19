-- Insert sample booking statuses
INSERT INTO booking_status (booking_status, Description) VALUES
('Pending', 'Booking has been created but not yet confirmed.'),
('Confirmed', 'Booking has been confirmed by the hotel.'),
('Checked In', 'Guest has checked in and is currently staying at the hotel.'),
('Checked Out', 'Guest has checked out.'),
('Cancelled', 'Booking has been cancelled by the guest or the hotel.'),
('No-Show', 'Guest did not arrive for their booking.'),
('Processing', 'Booking is currently being processed by the system'),
('Waiting for Payment', 'Booking is waiting for the payment to be processed');