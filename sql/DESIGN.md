# Design Document

By Abhishek Chavan

Video overview: <URL HERE>

## Hotel bookings.
## Scope

Purpose of this database was to build a database that would allow multiple hotels to keep track of their customers and bookings they make.
People, places and things I included in the scope of my database database are:
1. customers characterized by id, name, surname and phone number.
2. bookings characterized by id, customer_id, hotelid, date, num_of_people, breakfast, confirmed and total_price.
3. hotels characterized by id, name, address, avg_rating and phone number.
4. availabilities characterized by id, hotelid, date, no_of_bed, roomprice and breakfast_price.

## Functional Requirements

User should be able to:

1. add, edit and delete availabilities from the "availabilities" table.
2. add, edit and delete customers from the "customers" table.
3. add, edit and delete mountain huts from the "hotels" table.
4. add, edit and delete bookings from the "bookings" table.

Overall, the main purpose of my database is to keep track of bookings and extra facilities. It would allow to better plan processes inside thehotels and avoid overbooking.

## Representation
Entities I have chosen to represent data in my database are:
* customers represented by the "customers" table.
* Hotels represented by the "hotels" table.
* bookings represented by the "bookings" table.
* availabilities represented by the "availabilities" table.

### Entities
* Customers
* Availabilites
* Bookings
* Hotels

### Relationships
* Customers Entity consists of: id, name, surname and mobile number.
* Bookings Entity consists of: id, customer_id, Hotel_id, date, num_of_people, breakfast, confirmed and total_price.
* Availabilities Entity consists of: id, hotel_id, date, num_of_beds_available, bed_price and breakfast_price.
* When customer will book a hotel the data will be filled in respective tables.

## Optimizations

There're two main optimisations in the database:

1. Indexes:
Indexes have been created to speed up searches in the table.Indexes will help to accelerate query performance by allowing the database engine to quickly locate and retrieve specific rows.

2. Views:
Views are virtual table. Views can help simplify complex queries and improve readability.

## Limitations

While the provided database schema is well-structured for managing bookings, customers, hotels, and availabilities, there are some limitations and considerations:

Simplicity.
The design appears to be geared towards simplicity, which is often a positive aspect. However, depending on the specific requirements of your application, it might be overly simplistic for more complex scenarios. Scalability and Extensibility needs of this system need to be considered.

Some of the Limitations are as follows:

1) Assumption of Single Booking Date.
2) Limited Customer Information.
3) No User Authentication or Authorization.
4) No Logging or Auditing.
5) Limited Price Calculation Logic.
6) No Soft Deletes.
7) Assumption of Single Mountain Hut Price.
8) No Explicit Handling of Time Zones.
