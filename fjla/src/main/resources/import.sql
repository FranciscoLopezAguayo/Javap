
SELECT * FROM javap._user_;
SELECT * FROM javap.product;

SELECT * FROM javap.sale;
SELECT * FROM javap.sale_item;

UPDATE javap._user_
SET
    role = 'SALES_PERSON'
WHERE
    username = 'fjlaTEST2';

-- 'ADMINISTRATOR'
-- SALES_PERSON

SELECT * FROM javap._user_ order by id desc;
SELECT * FROM javap.product;


UPDATE javap._user_
SET
    role = 'ADMINISTRATOR'
WHERE
    username = 'fjlaTEST';



INSERT INTO javap._user_ (username, name, password, role) VALUES ('fjla1', 'francisco 1', '$2a$10$DvucTCVLJL.JIok9H8QSTuqKtIBZWtAz7Du9YLc9lm1mDHcNum9FS', 'CUSTOMER');
INSERT INTO javap._user_ (username, name, password, role) VALUES ('fjla2', 'francisco 2', '$2a$10$DvucTCVLJL.JIok9H8QSTuqKtIBZWtAz7Du9YLc9lm1mDHcNum9FS', 'ASSISTANT_ADMINISTRATOR');
INSERT INTO javap._user_ (username, name, password, role) VALUES ('fjla3', 'francisco 3', '$2a$10$DvucTCVLJL.JIok9H8QSTuqKtIBZWtAz7Du9YLc9lm1mDHcNum9FS', 'ADMINISTRATOR');
INSERT INTO javap._user_ (username, name, password, role) VALUES ('fjla4', 'francisco 3', '$2a$10$DvucTCVLJL.JIok9H8QSTuqKtIBZWtAz7Du9YLc9lm1mDHcNum9FS', 'SALES_PERSON');



-- CREACIÓN DE CATEGORIAS
INSERT INTO javap.category (name, status) VALUES ('Electrónica', 'ENABLED');
INSERT INTO javap.category (name, status) VALUES ('Ropa', 'ENABLED');
INSERT INTO javap.category (name, status) VALUES ('Deportes', 'ENABLED');
INSERT INTO javap.category (name, status) VALUES ('Hogar', 'ENABLED');
INSERT INTO javap.category (name, status) VALUES ('Libros', 'ENABLED');
INSERT INTO javap.category (name, status) VALUES ('Papeleria', 'ENABLED');
INSERT INTO javap.category (name, status) VALUES ('Oficina', 'ENABLED');

-- CREACIÓN DE PRODUCTOS
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('Smartphone', 500.00, 'ENABLED', 1,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('Auriculares Bluetooth', 50.00, 'DISABLED', 1,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('Tablet', 300.00, 'ENABLED', 1,100);

INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('Camiseta', 25.00, 'ENABLED', 2,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('Pantalones', 35.00, 'ENABLED', 2,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('Zapatos', 45.00, 'ENABLED', 2,100);

INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('Balón de Fútbol', 20.00, 'ENABLED', 3,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('Raqueta de Tenis', 80.00, 'DISABLED', 3,100);

INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('Aspiradora', 120.00, 'ENABLED', 4,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('Licuadora', 50.00, 'ENABLED', 4,100);

-- EJEMPLO
-- INSERT INTO javap.sale (sale_amount,sale_date,customer_user_id,sales_person_user_id) VALUES (1500,NOW(),1,4);
-- INSERT INTO javap.sale_item(product_id,qty,fk_sale,product_sale_amount)VALUES(1,2,1,0);


INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('Cien años de soledad - Gabriel García Márquez', 20.00, 'ENABLED', 5,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('1984 - George Orwell', 20.00, 'ENABLED', 5,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('El señor de los anillos - J.R.R. Tolkien', 20.00, 'ENABLED', 5,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('Orgullo y prejuicio - Jane Austen', 20.00, 'ENABLED', 5,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('Crónica de una muerte anunciada - Gabriel García Márquez', 20.00, 'ENABLED', 5,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('Matar a un ruiseñor - Harper Lee', 20.00, 'ENABLED', 5,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('Sapiens: De animales a dioses - Yuval Noah Harari', 20.00, 'ENABLED', 5,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('El nombre del viento - Patrick Rothfuss', 20.00, 'ENABLED', 5,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('El cuento de la criada - Margaret Atwood', 20.00, 'ENABLED', 5,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('La sombra del viento - Carlos Ruiz Zafón', 20.00, 'ENABLED', 5,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('El juego de Ender - Orson Scott Card', 20.00, 'ENABLED', 5,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('Rayuela - Julio Cortázar', 20.00, 'ENABLED', 5,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('Los hombres que no amaban a las mujeres - Stieg Larsson', 20.00, 'ENABLED', 5,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('Don Quijote de la Mancha - Miguel de Cervantes', 20.00, 'ENABLED', 5,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('El retrato de Dorian Gray - Oscar Wilde', 20.00, 'ENABLED', 5,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('Los pilares de la Tierra - Ken Follett', 20.00, 'ENABLED', 5,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('La ladrona de libros - Markus Zusak', 20.00, 'ENABLED', 5,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('La insoportable levedad del ser - Milan Kundera', 20.00, 'ENABLED', 5,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('Harry Potter y la piedra filosofal - J.K. Rowling', 20.00, 'ENABLED', 5,100);
INSERT INTO javap.product (name, price, status, category_id, current_stock) VALUES ('El perfume - Patrick Süskind', 20.00, 'ENABLED', 5,100);
