-- =============================================
-- Sample Data for Hotel Booking Management System
-- Generated Date: 2024-01-10
-- All user passwords are '12345678'
-- BCrypt hash: '$2a$10$vXy1.FGLZkxfZ5D5q3T5/.TRxKlOr1F9qzTOhDZtKqIRtxVytRze2'
-- Date Range: 2023-07-01 to 2024-04-01
-- =============================================

-- =============================================
-- 1. Status and Type Tables
-- =============================================

-- Booking Status
INSERT INTO booking_status (booking_status_id, booking_status, description) VALUES
(1, 'Pending', 'Booking is pending confirmation'),
(2, 'Confirmed', 'Booking has been confirmed'),
(3, 'Checked-in', 'Guest has checked in'),
(4, 'Checked-out', 'Guest has checked out'),
(5, 'Cancelled', 'Booking has been cancelled');

-- Payment Status
INSERT INTO payment_status (payment_status_id, payment_status, description) VALUES
(1, 'Pending', 'Payment is pending'),
(2, 'Paid', 'Payment has been completed'),
(3, 'Refunded', 'Payment has been refunded'),
(4, 'Failed', 'Payment has failed');

-- Payment Types
INSERT INTO payment_types (payment_type_id, payment_type, description, active) VALUES
(1, 'Cash', 'Cash payment at counter', 1),
(2, 'Credit Card', 'Credit card payment', 1),
(3, 'Debit Card', 'Debit card payment', 1),
(4, 'Bank Transfer', 'Bank transfer payment', 1),
(5, 'E-Wallet', 'Electronic wallet payment', 1);

-- Room Status
INSERT INTO room_status (room_status_id, room_status, description) VALUES
(1, 'Available', 'Room is available for booking'),
(2, 'Occupied', 'Room is currently occupied'),
(3, 'Maintenance', 'Room is under maintenance'),
(4, 'Out of Service', 'Room is out of service');

-- Room Types
INSERT INTO rooms_type (room_type_id, room_type, description, bed_count, occupancy, active) VALUES
(1, 'Standard Single', 'Standard room with single bed', 1, '1-2', 1),
(2, 'Standard Double', 'Standard room with double bed', 1, '2-3', 1),
(3, 'Deluxe Single', 'Deluxe room with single bed', 1, '1-2', 1),
(4, 'Deluxe Double', 'Deluxe room with double bed', 2, '2-4', 1),
(5, 'Suite', 'Luxury suite', 2, '2-4', 1),
(6, 'Executive Suite', 'Premium luxury suite', 3, '2-6', 1);

-- Booking Methods
INSERT INTO booking_methods (booking_method_id, booking_method, description, active) VALUES
(1, 'Online', 'Booking made through website', 1),
(2, 'Phone', 'Booking made through phone call', 1),
(3, 'Walk-in', 'Walk-in booking at counter', 1),
(4, 'Agency', 'Booking through travel agency', 1);

-- =============================================
-- 2. Users, Roles and Permissions
-- =============================================

-- Permissions
INSERT INTO permission (name, description) VALUES
('VIEW_DASHBOARD', 'Can view dashboard'),
('MANAGE_BOOKINGS', 'Can manage bookings'),
('MANAGE_ROOMS', 'Can manage rooms'),
('MANAGE_USERS', 'Can manage users'),
('MANAGE_PAYMENTS', 'Can manage payments'),
('MANAGE_SERVICES', 'Can manage services'),
('VIEW_REPORTS', 'Can view reports'),
('MANAGE_BRANCHES', 'Can manage branches');

-- Roles
INSERT INTO role (user_role_id, name, description) VALUES
('ROLE001', 'ADMIN', 'System Administrator'),
('ROLE002', 'MANAGER', 'Branch Manager'),
('ROLE003', 'STAFF', 'Hotel Staff'),
('ROLE004', 'CUSTOMER', 'Hotel Guest');

-- Role Permissions
INSERT INTO role_permissions (role_user_role_id, permissions_name) VALUES
-- Admin permissions
('ROLE001', 'VIEW_DASHBOARD'),
('ROLE001', 'MANAGE_BOOKINGS'),
('ROLE001', 'MANAGE_ROOMS'),
('ROLE001', 'MANAGE_USERS'),
('ROLE001', 'MANAGE_PAYMENTS'),
('ROLE001', 'MANAGE_SERVICES'),
('ROLE001', 'VIEW_REPORTS'),
('ROLE001', 'MANAGE_BRANCHES'),
-- Manager permissions
('ROLE002', 'VIEW_DASHBOARD'),
('ROLE002', 'MANAGE_BOOKINGS'),
('ROLE002', 'MANAGE_ROOMS'),
('ROLE002', 'MANAGE_PAYMENTS'),
('ROLE002', 'MANAGE_SERVICES'),
('ROLE002', 'VIEW_REPORTS'),
-- Staff permissions
('ROLE003', 'VIEW_DASHBOARD'),
('ROLE003', 'MANAGE_BOOKINGS'),
('ROLE003', 'MANAGE_SERVICES'),
-- Customer permissions
('ROLE004', 'MANAGE_BOOKINGS');

-- Users
-- Note: All passwords are '12345678'
-- BCrypt hash: '$2a$10$vXy1.FGLZkxfZ5D5q3T5/.TRxKlOr1F9qzTOhDZtKqIRtxVytRze2'
INSERT INTO user (user_id, username, password, first_name, last_name, dob) VALUES
-- Admin users
('USER001', 'admin', '$2a$10$vXy1.FGLZkxfZ5D5q3T5/.TRxKlOr1F9qzTOhDZtKqIRtxVytRze2', 'System', 'Admin', '1990-01-01'),
-- Managers
('USER002', 'manager1', '$2a$10$vXy1.FGLZkxfZ5D5q3T5/.TRxKlOr1F9qzTOhDZtKqIRtxVytRze2', 'John', 'Manager', '1985-03-15'),
('USER003', 'manager2', '$2a$10$vXy1.FGLZkxfZ5D5q3T5/.TRxKlOr1F9qzTOhDZtKqIRtxVytRze2', 'Jane', 'Director', '1988-07-22'),
-- Staff
('USER004', 'staff1', '$2a$10$vXy1.FGLZkxfZ5D5q3T5/.TRxKlOr1F9qzTOhDZtKqIRtxVytRze2', 'Mike', 'Staff', '1992-05-10'),
('USER005', 'staff2', '$2a$10$vXy1.FGLZkxfZ5D5q3T5/.TRxKlOr1F9qzTOhDZtKqIRtxVytRze2', 'Sarah', 'Employee', '1995-11-30'),
-- Customers
('USER006', 'customer1', '$2a$10$vXy1.FGLZkxfZ5D5q3T5/.TRxKlOr1F9qzTOhDZtKqIRtxVytRze2', 'Tom', 'Customer', '1991-04-20'),
('USER007', 'customer2', '$2a$10$vXy1.FGLZkxfZ5D5q3T5/.TRxKlOr1F9qzTOhDZtKqIRtxVytRze2', 'Mary', 'Guest', '1993-08-15'),
('USER008', 'customer3', '$2a$10$vXy1.FGLZkxfZ5D5q3T5/.TRxKlOr1F9qzTOhDZtKqIRtxVytRze2', 'Peter', 'Client', '1987-12-03'),
('USER009', 'customer4', '$2a$10$vXy1.FGLZkxfZ5D5q3T5/.TRxKlOr1F9qzTOhDZtKqIRtxVytRze2', 'Linda', 'Visitor', '1994-06-25'),
('USER010', 'customer5', '$2a$10$vXy1.FGLZkxfZ5D5q3T5/.TRxKlOr1F9qzTOhDZtKqIRtxVytRze2', 'James', 'Tourist', '1989-09-17');

-- User Roles
INSERT INTO user_roles (user_user_id, roles_user_role_id) VALUES
('USER001', 'ROLE001'), -- Admin
('USER002', 'ROLE002'), -- Manager
('USER003', 'ROLE002'), -- Manager
('USER004', 'ROLE003'), -- Staff
('USER005', 'ROLE003'), -- Staff
('USER006', 'ROLE004'), -- Customer
('USER007', 'ROLE004'), -- Customer
('USER008', 'ROLE004'), -- Customer
('USER009', 'ROLE004'), -- Customer
('USER010', 'ROLE004'); -- Customer

-- =============================================
-- 3. Branches and Rooms
-- =============================================

-- Branches (Managed by USER002 and USER003)
INSERT INTO branches (branch_id, address, branch_phone_num, last_maintenance_date, number_of_rooms, started_date, manager_id) VALUES
('BR001', '123 Main Street, Downtown', '+1234567890', '2023-12-15', '20', '2020-01-01', 'USER002'),
('BR002', '456 Park Avenue, Uptown', '+1234567891', '2023-12-20', '25', '2020-03-15', 'USER003'),
('BR003', '789 Beach Road, Seaside', '+1234567892', '2023-12-25', '15', '2021-01-01', 'USER002'),
('BR004', '321 Mountain View, Heights', '+1234567893', '2023-12-30', '30', '2021-06-15', 'USER003'),
('BR005', '654 Lake Drive, Riverside', '+1234567894', '2024-01-05', '20', '2022-01-01', 'USER002');

-- =============================================
-- 4. Rooms and Room Pictures
-- =============================================

-- Rooms for Branch 1 (BR001)
INSERT INTO rooms (room_id, room_number, descriptions, price, branch_id, room_status_id, room_type_id) VALUES
('RM001', '101', 'Standard Single Room with City View', 100.00, 'BR001', 1, 1),
('RM002', '102', 'Standard Double Room with City View', 150.00, 'BR001', 1, 2),
('RM003', '103', 'Deluxe Single Room with City View', 180.00, 'BR001', 1, 3),
('RM004', '104', 'Deluxe Double Room with City View', 220.00, 'BR001', 1, 4),
('RM005', '105', 'Suite with City View', 300.00, 'BR001', 1, 5),
('RM006', '201', 'Standard Single Room with Pool View', 120.00, 'BR001', 1, 1),
('RM007', '202', 'Standard Double Room with Pool View', 170.00, 'BR001', 1, 2),
('RM008', '203', 'Deluxe Single Room with Pool View', 200.00, 'BR001', 1, 3),
('RM009', '204', 'Deluxe Double Room with Pool View', 240.00, 'BR001', 1, 4),
('RM010', '205', 'Executive Suite with Pool View', 350.00, 'BR001', 1, 6);

-- Rooms for Branch 2 (BR002)
INSERT INTO rooms (room_id, room_number, descriptions, price, branch_id, room_status_id, room_type_id) VALUES
('RM011', '101', 'Standard Single Room with Garden View', 110.00, 'BR002', 1, 1),
('RM012', '102', 'Standard Double Room with Garden View', 160.00, 'BR002', 1, 2),
('RM013', '103', 'Deluxe Single Room with Garden View', 190.00, 'BR002', 1, 3),
('RM014', '104', 'Deluxe Double Room with Garden View', 230.00, 'BR002', 1, 4),
('RM015', '105', 'Suite with Garden View', 310.00, 'BR002', 1, 5),
('RM016', '201', 'Standard Single Room with Mountain View', 130.00, 'BR002', 1, 1),
('RM017', '202', 'Standard Double Room with Mountain View', 180.00, 'BR002', 1, 2),
('RM018', '203', 'Deluxe Single Room with Mountain View', 210.00, 'BR002', 1, 3),
('RM019', '204', 'Deluxe Double Room with Mountain View', 250.00, 'BR002', 1, 4),
('RM020', '205', 'Executive Suite with Mountain View', 360.00, 'BR002', 1, 6);

-- =============================================
-- 5. Services and Items
-- =============================================

-- Services
INSERT INTO services (service_id, service_name, description, price, active) VALUES
(1, 'Room Cleaning', 'Daily room cleaning service', 20.00, 1),
(2, 'Laundry', 'Laundry and ironing service', 30.00, 1),
(3, 'Breakfast Buffet', 'Breakfast buffet at restaurant', 25.00, 1),
(4, 'Airport Transfer', 'Hotel transfer service', 50.00, 1),
(5, 'Spa Treatment', 'Spa and massage service', 80.00, 1),
(6, 'Gym Access', 'Access to hotel gym', 15.00, 1),
(7, 'Pool Access', 'Access to swimming pool', 15.00, 1),
(8, 'Room Service', '24/7 room service', 10.00, 1),
(9, 'Business Center', 'Access to business center', 25.00, 1),
(10, 'Guided Tour', 'Local area guided tour', 100.00, 1);

-- Room Items
INSERT INTO room_item (item_id, item_name, description, price, stock, is_served) VALUES
(1, 'Extra Pillow', 'Additional comfort pillow', 10.00, 100, 1),
(2, 'Extra Blanket', 'Additional warm blanket', 15.00, 100, 1),
(3, 'Mini Bar Drinks', 'Assorted mini bar beverages', 8.00, 200, 1),
(4, 'Snacks', 'Assorted snacks', 5.00, 200, 1),
(5, 'Toiletries Set', 'Premium toiletries set', 20.00, 150, 1),
(6, 'Slippers', 'Hotel slippers', 8.00, 300, 1),
(7, 'Bathrobe', 'Luxury bathrobe', 25.00, 100, 1),
(8, 'Dental Kit', 'Toothbrush and toothpaste', 5.00, 200, 1),
(9, 'Sewing Kit', 'Emergency sewing kit', 3.00, 150, 1),
(10, 'Phone Charger', 'Universal phone charger', 15.00, 50, 1);

-- =============================================
-- 6. Promotions
-- =============================================

INSERT INTO promotion (promotion_id, promotion_name, description, discount, start_date, end_date) VALUES
(1, 'Early Bird 2024', 'Book 30 days in advance and save 20%', 20.0, '2024-01-01', '2024-12-31'),
(2, 'Weekend Special', 'Special weekend rates', 15.0, '2024-01-01', '2024-06-30'),
(3, 'Summer Holiday', 'Summer season special rates', 25.0, '2024-06-01', '2024-08-31'),
(4, 'Long Stay Discount', 'Stay 5 nights or more and save 30%', 30.0, '2024-01-01', '2024-12-31'),
(5, 'Last Minute Deal', 'Last minute booking discount', 10.0, '2024-01-01', '2024-12-31');

-- =============================================
-- 7. Bookings and Booking Details
-- =============================================

-- Past Completed Bookings (July-December 2023)
INSERT INTO bookings (booking_id, booked_date, room_count, total_amount, active, booked_by, booking_method_id) VALUES
('BK001', '2023-07-15 10:00:00', 1, 330.00, 1, 'USER006', 1),
('BK002', '2023-08-20 14:30:00', 2, 750.00, 1, 'USER007', 1),
('BK003', '2023-09-05 09:15:00', 1, 420.00, 1, 'USER008', 2),
('BK004', '2023-10-10 16:45:00', 1, 550.00, 1, 'USER009', 3),
('BK005', '2023-11-25 11:20:00', 2, 980.00, 1, 'USER010', 1);

-- Current Active Bookings (January 2024)
INSERT INTO bookings (booking_id, booked_date, room_count, total_amount, active, booked_by, booking_method_id) VALUES
('BK006', '2024-01-05 13:00:00', 1, 440.00, 1, 'USER006', 1),
('BK007', '2024-01-08 15:30:00', 1, 660.00, 1, 'USER007', 2),
('BK008', '2024-01-10 10:45:00', 2, 890.00, 1, 'USER008', 1);

-- Future Bookings (February-April 2024)
INSERT INTO bookings (booking_id, booked_date, room_count, total_amount, active, booked_by, booking_method_id) VALUES
('BK009', '2024-01-15 14:20:00', 1, 440.00, 1, 'USER009', 1),
('BK010', '2024-01-20 11:30:00', 2, 880.00, 1, 'USER010', 1);

-- Booking Details for Past Bookings
INSERT INTO booking_details (booking_detail_id, booking_id, room_id, check_in_date, check_out_date, adult, child, 
                           total_room_charge, service_charge, item_charge, total_amount, booking_status_id) VALUES
-- July 2023 Booking
('BD001', 'BK001', 'RM001', '2023-07-20 14:00:00', '2023-07-22 12:00:00', 2, 0, 
        200.00, 80.00, 50.00, 330.00, 4),
-- August 2023 Booking
('BD002', 'BK002', 'RM004', '2023-08-25 14:00:00', '2023-08-27 12:00:00', 2, 1, 
        440.00, 200.00, 110.00, 750.00, 4),
-- September 2023 Booking
('BD003', 'BK003', 'RM007', '2023-09-10 14:00:00', '2023-09-12 12:00:00', 2, 0, 
        340.00, 50.00, 30.00, 420.00, 4),
-- October 2023 Booking
('BD004', 'BK004', 'RM015', '2023-10-15 14:00:00', '2023-10-17 12:00:00', 2, 1, 
        420.00, 80.00, 50.00, 550.00, 4),
-- November 2023 Booking
('BD005', 'BK005', 'RM018', '2023-11-30 14:00:00', '2023-12-02 12:00:00', 2, 2, 
        620.00, 260.00, 100.00, 980.00, 4);

-- Booking Details for Current Bookings
INSERT INTO booking_details (booking_detail_id, booking_id, room_id, check_in_date, check_out_date, adult, child, 
                           total_room_charge, service_charge, item_charge, total_amount, booking_status_id) VALUES
-- January 2024 Current Bookings
('BD006', 'BK006', 'RM002', '2024-01-12 14:00:00', '2024-01-14 12:00:00', 2, 0, 
        300.00, 90.00, 50.00, 440.00, 3),
('BD007', 'BK007', 'RM005', '2024-01-15 14:00:00', '2024-01-17 12:00:00', 2, 1, 
        500.00, 110.00, 50.00, 660.00, 2),
('BD008', 'BK008', 'RM008', '2024-01-20 14:00:00', '2024-01-22 12:00:00', 2, 2, 
        600.00, 190.00, 100.00, 890.00, 1);

-- Booking Details for Future Bookings
INSERT INTO booking_details (booking_detail_id, booking_id, room_id, check_in_date, check_out_date, adult, child, 
                           total_room_charge, service_charge, item_charge, total_amount, booking_status_id) VALUES
('BD009', 'BK009', 'RM010', '2024-02-01 14:00:00', '2024-02-03 12:00:00', 2, 0, 
        300.00, 90.00, 50.00, 440.00, 1),
('BD010', 'BK010', 'RM020', '2024-03-15 14:00:00', '2024-03-17 12:00:00', 2, 1, 
        600.00, 180.00, 100.00, 880.00, 1);

-- =============================================
-- 8. Payments and Invoices
-- =============================================

-- Payments for Completed Bookings
INSERT INTO payments (payment_id, booking_id, amount, discount, service_charges, item_charges, 
                     total, total_paid, paid_date, payment_status_id, payment_type_id) VALUES
('PAY001', 'BK001', 330.00, 0.00, 80.00, 50.00, 330.00, 330.00, '2023-07-20 14:30:00', 2, 2),
('PAY002', 'BK002', 750.00, 50.00, 200.00, 110.00, 750.00, 750.00, '2023-08-25 15:00:00', 2, 1),
('PAY003', 'BK003', 420.00, 0.00, 50.00, 30.00, 420.00, 420.00, '2023-09-10 10:00:00', 2, 3),
('PAY004', 'BK004', 550.00, 25.00, 80.00, 50.00, 550.00, 550.00, '2023-10-15 17:00:00', 2, 2),
('PAY005', 'BK005', 980.00, 100.00, 260.00, 100.00, 980.00, 980.00, '2023-11-30 12:00:00', 2, 1);

-- Payments for Current Bookings
INSERT INTO payments (payment_id, booking_id, amount, discount, service_charges, item_charges, 
                     total, total_paid, paid_date, payment_status_id, payment_type_id) VALUES
('PAY006', 'BK006', 440.00, 0.00, 90.00, 50.00, 440.00, 440.00, '2024-01-12 14:30:00', 2, 2),
('PAY007', 'BK007', 660.00, 40.00, 110.00, 50.00, 660.00, 660.00, '2024-01-15 15:00:00', 1, 1),
('PAY008', 'BK008', 890.00, 60.00, 190.00, 100.00, 890.00, 0.00, '2024-01-20 10:00:00', 1, 2);

-- Invoices
INSERT INTO invoice (invoice_id, booking_id, total_amount, discounted_amount, tax, promotion, final_amount, invoice_date) VALUES
('INV001', 'BK001', 330.00, 0.00, 23.10, 0.00, 353.10, '2023-07-20 14:35:00'),
('INV002', 'BK002', 750.00, 50.00, 49.00, 10.00, 749.00, '2023-08-25 15:05:00'),
('INV003', 'BK003', 420.00, 0.00, 29.40, 0.00, 449.40, '2023-09-10 10:05:00'),
('INV004', 'BK004', 550.00, 25.00, 36.75, 5.00, 561.75, '2023-10-15 17:05:00'),
('INV005', 'BK005', 980.00, 100.00, 61.60, 15.00, 941.60, '2023-11-30 12:05:00');

-- =============================================
-- 9. Service Usage Records
-- =============================================

INSERT INTO service_usage (service_usage_id, booking_detail_id, service_id, quantity, charge, date_used) VALUES
-- Past bookings service usage
('SU001', 'BD001', 1, 1, 20.00, '2023-07-20 16:00:00'),
('SU002', 'BD001', 3, 2, 50.00, '2023-07-21 08:00:00'),
('SU003', 'BD002', 2, 1, 30.00, '2023-08-25 18:00:00'),
('SU004', 'BD002', 5, 2, 160.00, '2023-08-26 14:00:00'),
('SU005', 'BD003', 4, 1, 50.00, '2023-09-10 15:00:00'),
('SU006', 'BD004', 3, 2, 50.00, '2023-10-15 08:00:00'),
('SU007', 'BD004', 8, 3, 30.00, '2023-10-16 20:00:00'),
('SU008', 'BD005', 5, 2, 160.00, '2023-11-30 16:00:00'),
('SU009', 'BD005', 3, 2, 50.00, '2023-12-01 08:00:00'),
-- Current bookings service usage
('SU010', 'BD006', 1, 1, 20.00, '2024-01-12 16:00:00'),
('SU011', 'BD006', 3, 2, 50.00, '2024-01-13 08:00:00'),
('SU012', 'BD007', 5, 1, 80.00, '2024-01-15 17:00:00');

-- =============================================
-- 10. Room Item Usage Records
-- =============================================

INSERT INTO room_item_usage (item_usage_id, booking_detail_id, item_id, quantity, charge, room_id) VALUES
-- Past bookings item usage
('IU001', 'BD001', 3, 2, 16.00, 'RM001'),
('IU002', 'BD001', 4, 2, 10.00, 'RM001'),
('IU003', 'BD002', 5, 1, 20.00, 'RM004'),
('IU004', 'BD002', 7, 2, 50.00, 'RM004'),
('IU005', 'BD003', 3, 2, 16.00, 'RM007'),
('IU006', 'BD004', 4, 3, 15.00, 'RM015'),
('IU007', 'BD004', 6, 2, 16.00, 'RM015'),
('IU008', 'BD005', 7, 2, 50.00, 'RM018'),
-- Current bookings item usage
('IU009', 'BD006', 3, 2, 16.00, 'RM002'),
('IU010', 'BD006', 4, 2, 10.00, 'RM002'),
('IU011', 'BD007', 5, 1, 20.00, 'RM005');

-- =============================================
-- 11. Ratings and Reviews
-- =============================================

INSERT INTO rates (rate_id, room_id, rated_by, rate_date, feedback_comment, rate) VALUES
-- Past stays ratings
(1, 'RM001', 'USER006', '2023-07-22 12:30:00', 'Great room, excellent service!', 5),
(2, 'RM004', 'USER007', '2023-08-27 12:45:00', 'Very comfortable stay, will come back', 4),
(3, 'RM007', 'USER008', '2023-09-12 13:00:00', 'Good value for money', 4),
(4, 'RM015', 'USER009', '2023-10-17 11:30:00', 'Amazing view and comfortable bed', 5),
(5, 'RM018', 'USER010', '2023-12-02 12:15:00', 'Nice room but could be cleaner', 3),
(6, 'RM002', 'USER006', '2024-01-14 12:30:00', 'Excellent service and amenities', 5),
(7, 'RM005', 'USER007', '2024-01-17 14:00:00', 'Perfect for family stay', 4);

-- =============================================
-- 12. Seasonal Pricing
-- =============================================

INSERT INTO seasonal_pricing (seasonal_pricing_id, room_type_id, season_name, seasonal_rate, start_date, end_date) VALUES
('SP001', 1, 'Peak Season', 130.00, '2023-12-15 00:00:00', '2024-01-15 00:00:00'),
('SP002', 2, 'Peak Season', 180.00, '2023-12-15 00:00:00', '2024-01-15 00:00:00'),
('SP003', 3, 'Peak Season', 220.00, '2023-12-15 00:00:00', '2024-01-15 00:00:00'),
('SP004', 4, 'Peak Season', 260.00, '2023-12-15 00:00:00', '2024-01-15 00:00:00'),
('SP005', 5, 'Peak Season', 350.00, '2023-12-15 00:00:00', '2024-01-15 00:00:00'),
('SP006', 6, 'Peak Season', 400.00, '2023-12-15 00:00:00', '2024-01-15 00:00:00'),
('SP007', 1, 'Low Season', 90.00, '2024-01-16 00:00:00', '2024-03-31 00:00:00'),
('SP008', 2, 'Low Season', 140.00, '2024-01-16 00:00:00', '2024-03-31 00:00:00'),
('SP009', 3, 'Low Season', 170.00, '2024-01-16 00:00:00', '2024-03-31 00:00:00'),
('SP010', 4, 'Low Season', 200.00, '2024-01-16 00:00:00', '2024-03-31 00:00:00'),
('SP011', 5, 'Low Season', 280.00, '2024-01-16 00:00:00', '2024-03-31 00:00:00'),
('SP012', 6, 'Low Season', 320.00, '2024-01-16 00:00:00', '2024-03-31 00:00:00');

-- =============================================
-- 13. Picture Categories and Pictures
-- =============================================

INSERT INTO picture_category (category_name, description) VALUES
('Room', 'Room pictures'),
('Facility', 'Hotel facility pictures'),
('Branch', 'Branch pictures'),
('Other', 'Other pictures');

INSERT INTO picture (picture_id, picture_name, picture_path, upload_date, category_category_name) VALUES
(1, 'standard-single.jpg', '/images/rooms/standard-single.jpg', '2024-01-01 10:00:00', 'Room'),
(2, 'deluxe-double.jpg', '/images/rooms/deluxe-double.jpg', '2024-01-01 10:00:00', 'Room'),
(3, 'suite.jpg', '/images/rooms/suite.jpg', '2024-01-01 10:00:00', 'Room'),
(4, 'lobby.jpg', '/images/facilities/lobby.jpg', '2024-01-01 10:00:00', 'Facility'),
(5, 'pool.jpg', '/images/facilities/pool.jpg', '2024-01-01 10:00:00', 'Facility'),
(6, 'branch1-exterior.jpg', '/images/branches/branch1-exterior.jpg', '2024-01-01 10:00:00', 'Branch'),
(7, 'branch2-exterior.jpg', '/images/branches/branch2-exterior.jpg', '2024-01-01 10:00:00', 'Branch');

-- Link pictures to rooms
INSERT INTO room_picture (room_id, picture_id) VALUES
('RM001', 1),
('RM004', 2),
('RM005', 3);

-- Link pictures to branches
INSERT INTO branch_pictures (branch_id, picture_id) VALUES
('BR001', 6),
('BR002', 7);

