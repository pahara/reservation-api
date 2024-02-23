INSERT INTO concerts (concert_date, location, concert_name) VALUES (now(), 'Jakarta', 'Concert1') ON CONFLICT (concert_name) DO NOTHING;
INSERT INTO concerts (concert_date, location, concert_name) VALUES (now(), 'Jakarta', 'Concert2') ON CONFLICT (concert_name) DO NOTHING;
INSERT INTO concerts (concert_date, location, concert_name) VALUES (now(), 'Jakarta', 'Concert3') ON CONFLICT (concert_name) DO NOTHING;
INSERT INTO concerts (concert_date, location, concert_name) VALUES (now(), 'Jakarta', 'Concert4') ON CONFLICT (concert_name) DO NOTHING;

INSERT INTO customers (customer_name, email) VALUES ('Nino', 'nino@gmail.com') ON CONFLICT DO NOTHING;

INSERT INTO tickets (seat, price, concert_id) VALUES ('A1', '500000', 1) ON CONFLICT DO NOTHING;
INSERT INTO tickets (seat, price, concert_id) VALUES ('A2', '500000', 1) ON CONFLICT DO NOTHING;
INSERT INTO tickets (seat, price, concert_id) VALUES ('B1', '200000', 1) ON CONFLICT DO NOTHING;
INSERT INTO tickets (seat, price, concert_id) VALUES ('B2', '200000', 1) ON CONFLICT DO NOTHING;
INSERT INTO tickets (seat, price, concert_id) VALUES ('C1', '100000', 1) ON CONFLICT DO NOTHING;