CREATE TABLE rooms (
  id SERIAL PRIMARY KEY,
  hotel_id INTEGER NOT NULL REFERENCES hotels (id),
  room_number VARCHAR(10),
  room_type VARCHAR(50),
  price DECIMAL(10, 2) NOT NULL,
  max_guests INTEGER,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);