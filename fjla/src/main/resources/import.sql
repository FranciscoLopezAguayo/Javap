

INSERT INTO javap._user_ (username, name, password, role) VALUES ('fjla1', 'francisco 1', '$2a$10$DvucTCVLJL.JIok9H8QSTuqKtIBZWtAz7Du9YLc9lm1mDHcNum9FS', 'CUSTOMER');
INSERT INTO javap._user_ (username, name, password, role) VALUES ('fjla2', 'francisco 2', '$2a$10$DvucTCVLJL.JIok9H8QSTuqKtIBZWtAz7Du9YLc9lm1mDHcNum9FS', 'ASSISTANT_ADMINISTRATOR');
INSERT INTO javap._user_ (username, name, password, role) VALUES ('fjla3', 'francisco 3', '$2a$10$DvucTCVLJL.JIok9H8QSTuqKtIBZWtAz7Du9YLc9lm1mDHcNum9FS', 'ADMINISTRATOR');


-- CREACIÓN DE CATEGORIAS
INSERT INTO javap.category (name, status) VALUES ('Electrónica', 'ENABLED');
INSERT INTO javap.category (name, status) VALUES ('Ropa', 'ENABLED');
INSERT INTO javap.category (name, status) VALUES ('Deportes', 'ENABLED');
INSERT INTO javap.category (name, status) VALUES ('Hogar', 'ENABLED');

-- CREACIÓN DE PRODUCTOS
INSERT INTO javap.product (name, price, status, category_id) VALUES ('Smartphone', 500.00, 'ENABLED', 1);
INSERT INTO javap.product (name, price, status, category_id) VALUES ('Auriculares Bluetooth', 50.00, 'DISABLED', 1);
INSERT INTO javap.product (name, price, status, category_id) VALUES ('Tablet', 300.00, 'ENABLED', 1);

INSERT INTO javap.product (name, price, status, category_id) VALUES ('Camiseta', 25.00, 'ENABLED', 2);
INSERT INTO javap.product (name, price, status, category_id) VALUES ('Pantalones', 35.00, 'ENABLED', 2);
INSERT INTO javap.product (name, price, status, category_id) VALUES ('Zapatos', 45.00, 'ENABLED', 2);

INSERT INTO javap.product (name, price, status, category_id) VALUES ('Balón de Fútbol', 20.00, 'ENABLED', 3);
INSERT INTO javap.product (name, price, status, category_id) VALUES ('Raqueta de Tenis', 80.00, 'DISABLED', 3);

INSERT INTO javap.product (name, price, status, category_id) VALUES ('Aspiradora', 120.00, 'ENABLED', 4);
INSERT INTO javap.product (name, price, status, category_id) VALUES ('Licuadora', 50.00, 'ENABLED', 4);
