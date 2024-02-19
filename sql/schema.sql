-- In this SQL file, write (and comment!) the schema of your database.
-- Create tables: "customers", "bookings", "hotels" and "availabilities"
CREATE TABLE IF NOT EXISTS "customers"(
    "id" INTEGER, "PhoneNumber" INTEGER UNIQUE,
    "name" TEXT, "surname" TEXT,
    PRIMARY KEY("id")
);

CREATE TABLE IF NOT EXISTS "bookings" (
    "id" INTEGER, "customer_id" INTEGER,
    "hotelId" INTEGER, "num_of_people" INTEGER,
    "date" DATE,
    "breakfast" BOOLEAN, "confirmed" BOOLEAN DEFAULT "0",
    "total_price" INTEGER DEFAULT "0",
    PRIMARY KEY("id"),
    FOREIGN KEY ("customer_id") REFERENCES "customers"("id")
    FOREIGN KEY ("hotelId") REFERENCES "hotels"("id")
);

CREATE TABLE IF NOT EXISTS "hotels" (
    "id" INTEGER, "Rooms" INTEGER,
    "name" TEXT, "address" TEXT,
    "avg_rating" REAL, "Phone" TEXT,
    PRIMARY KEY("id")
);

CREATE TABLE IF NOT EXISTS "availabilities" (
    "id" INTEGER, "hotelId" INTEGER,
    "date" DATE,  "no_of_bed" INTEGER,
    "roomPrice" INTEGER, "breakfast_price" INTEGER,
    PRIMARY KEY("id"),
    FOREIGN KEY ("hotelId") REFERENCES "hotels"("id")
);

-- Create view "availabilities_in_various_hotels_in_January_2024"
CREATE VIEW "availabilities_in_various_hotels_in_January_2024" AS
SELECT "name", "date", "no_of_bed" FROM "hotels"
JOIN "availabilities" ON "hotels"."id" = "availabilities"."hotelId"
WHERE date > '2023-12-31' AND date < '2024-02-01';

-- Create view "availabilities_in_various_hotels_in_February_2024"
CREATE VIEW "availabilities_in_various_hotels_in_February_2024" AS
SELECT "name", "date", "no_of_bed" FROM "hotels"
JOIN "availabilities" ON "hotels"."id" = "availabilities"."hotelId"
WHERE date > '2024-01-31' AND date < '2024-03-01';

-- Create indexes
CREATE INDEX "search_availabilities_by_hotelId" ON "availabilities"("hotelId");

CREATE INDEX "search_availabilities_by_date" ON "availabilities"("date");

CREATE INDEX "search_bookings_by_customer_id" ON "availabilities"("date");

-- Trigger "check_availability" checks if there're enough free places for a specified day in a specified mountain hut,

CREATE TRIGGER "check_availability" BEFORE INSERT ON "bookings"
FOR EACH ROW
BEGIN
    SELECT
        CASE
            WHEN (
                SELECT "no_of_bed"
                FROM "availabilities"
                WHERE "availabilities"."hotelId" = NEW."hotelId" AND "availabilities"."date" = NEW."date"
            ) < (
                SELECT NEW."num_of_people"
                FROM "bookings"
            )
            THEN
                RAISE(ABORT, 'Not enough Rooms for that day to accomodate all people. We are sorry.')
            END;
END;

CREATE TRIGGER "update_availability"
AFTER INSERT ON "bookings"
FOR EACH ROW
BEGIN
    UPDATE "availabilities"
    SET "no_of_bed" = ((
            SELECT "no_of_bed"
            FROM "availabilities"
            WHERE "hotelId" = NEW."hotelId" AND "date" = NEW."date"
        ) - (
            SELECT NEW."num_of_people"
            FROM "bookings"
        ))
    WHERE "hotelId" = NEW."hotelId" AND "date" = NEW."date";
END;

-- Trigger "update_total_price" calculates total price for a new booking based on prices from "availabilities" table.
CREATE TRIGGER "update_total_price"
AFTER INSERT ON "bookings"
FOR EACH ROW
BEGIN
    UPDATE "bookings"
    SET "total_price" = ((
            SELECT "roomPrice"
            FROM "availabilities"
            WHERE "hotelId" = NEW."hotelId" AND "date" = NEW."date"
        ) * (
            SELECT NEW."num_of_people"
            FROM "bookings"
            WHERE "hotelId" = NEW."hotelId" AND "date" = NEW."date"
        )) + ((
            SELECT "breakfast_price"
            FROM "availabilities"
            WHERE "hotelId" = NEW."hotelId" AND "date" = NEW."date"
        ) * (
            SELECT NEW."num_of_people"
            FROM "bookings"
            WHERE "hotelId" = NEW."hotelId" AND "date" = NEW."date"
        ) * (
            SELECT NEW."breakfast"
            FROM "bookings"
            WHERE "hotelId" = NEW."hotelId" AND "date" = NEW."date"
        ))
    WHERE "id" = NEW."id";
END;
