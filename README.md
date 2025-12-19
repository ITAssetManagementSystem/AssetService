# Asset Service (Java)

## Overview
Manages IT assets. External DB. Cloud-ready.

## Prerequisites
- Java 17
- Maven
- PostgreSQL
- Postman

## Setup
1. Create DB and user
2. Set env variables
3. Run app
4. Call /assets/init-db

## APIs
- POST /assets/init-db
- POST /assets
- GET /assets
- PUT /assets/{id}/status
- GET /actuator/health

## Cloud Migration
Change DB_URL, USERNAME, PASSWORD → Azure DB
