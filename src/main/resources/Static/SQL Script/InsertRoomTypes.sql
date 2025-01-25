-- insert sample room type

INSERT INTO rooms_type(room_type, Description, Occupancy, Bed_Count, Active) VALUES
    ('Standard Room', 'Standard room with basic amenities', 'Single/Double', 1, true),
    ('Deluxe Room', 'Spacious room with enhanced amenities', 'Single/Double/Triple', 2, true),
    ('Suite Room', 'Luxurious suite with living area', 'Family', 3, true),
    ('Family Room', 'Room suitable for families', 'Family', 4, true),
    ('Executive Suite', 'Top-tier suite with exclusive amenities', 'VIP', 2, true);