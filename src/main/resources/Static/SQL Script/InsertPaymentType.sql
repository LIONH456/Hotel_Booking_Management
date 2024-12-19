-- Insert sample payment types
INSERT INTO payment_types (Payment_Type, Description, Active) VALUES
('Credit Card', 'Payment made using a credit card.', TRUE),
('Debit Card', 'Payment made using a debit card.', TRUE),
('Cash', 'Payment made using cash.', TRUE),
('Bank Transfer', 'Payment made through a bank transfer.', TRUE),
('PayPal', 'Payment made using the PayPal online payment system.', FALSE),
('Mobile Payment', 'Payment made using a mobile payment app (e.g., Apple Pay, Google Pay)', TRUE);