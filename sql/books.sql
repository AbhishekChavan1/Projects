INSERT INTO "customers" ("id","name", "surname", "PhoneNumber")
VALUES ('4', 'Adam', 'Smith', '+44 674-675-676');

SELECT * FROM "customers";

INSERT INTO "bookings" ("customer_id", "hotelId", "date", "num_of_people", "breakfast", "confirmed")
VALUES ('4', '7', '2024-01-18', '6', '1', '0');

SELECT * FROM "bookings";

-- Check number of available places
SELECT SUM("num_of_beds") AS "total number of beds available" FROM "availabilities"
    WHERE "hotelId" = (SELECT "id" FROM "hotels" WHERE "name" = 'Blue Oak');

SELECT SUM("num_of_beds") AS "number of beds available" FROM "availabilities"
    WHERE "hotelId" = (SELECT "id" FROM "hotels" WHERE "name" = 'Raj Mahal')

INSERT INTO "bookings" ("customer_id", "hotelId", "date", "num_of_people", "breakfast", "confirmed")
VALUES('1', '2', '2024-01-15', '1', '1', '1');

SELECT SUM("num_of_people") FROM "bookings"
WHERE "hotelId" = '1' AND "date" = '2024-01-15';

SELECT SUM("num_of_people") FROM "bookings";
