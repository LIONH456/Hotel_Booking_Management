-- Insert Sample Booking Method

INSERT INTO booking_methods (Booking_Method, Description, Active) VALUES
('Online Booking', 'Booking through the website or mobile app', TRUE),
('Phone Booking', 'Booking made by calling the reservation line', TRUE),
('In-Person Booking', 'Booking made directly at the hotel reception', TRUE),
('Travel Agent', 'Booking made through a travel agency', FALSE),
('Third-Party Website', 'Booking through online travel agencies (OTAs) like Expedia or Booking.com', TRUE),
('Corporate Booking', 'Booking made by companies for their employees', FALSE);