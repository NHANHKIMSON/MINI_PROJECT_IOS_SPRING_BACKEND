-- Insert static data of category
INSERT INTO category (name, icon) VALUES
                                      ('Automobile', 'car.fill'),
                                      ('Electronics', 'desktopcomputer'),
                                      ('Sports', 'basketball.fill'),
                                      ('Clothing', 'tshirt.fill'),
                                      ('Real Estates', 'house.fill'),
                                      ('Games', 'gamecontroller.fill');




-- Products
INSERT INTO product (id, name, image, is_favorite, price, category_id, detail_id)
VALUES (1, 'air pod', 'http://localhost:9090/api/v1/file/view/cee60106-bc14-475f-a40c-d23cf7a5363c.png', true, 999.99, 1, 1);
INSERT INTO product (id, name, image, is_favorite, price, category_id, detail_id)
VALUES (2, 'air pod A1', 'http://localhost:9090/api/v1/file/view/dae1fb8c-8603-476e-9c19-df64f037ba7b.png', false, 120.00, 1, 2);
INSERT INTO product (id, name, image, is_favorite, price, category_id, detail_id)
VALUES (3, 'Head phone', 'http://localhost:9090/api/v1/file/view/45e24c42-a422-4935-8508-d0403c69e704.png', true, 899.99, 1, 3);
INSERT INTO product (id, name, image, is_favorite, price, category_id, detail_id)
VALUES (4, 'ipad M4', 'http://localhost:9090/api/v1/file/view/a9492b5d-98c1-4e0c-a70c-730d0602dd88.png', false, 150.00, 2, 4);
INSERT INTO product (id, name, image, is_favorite, price, category_id, detail_id)
VALUES (5, 'iphone 17 pro max', 'http://localhost:9090/api/v1/file/view/882df3bc-099c-42b1-83ba-31936b387aa0.png', false, 450.00, 1, 5);
INSERT INTO product (id, name, image, is_favorite, price, category_id, detail_id)
VALUES (6, 'Key board', 'http://localhost:9090/api/v1/file/view/f3b43853-0224-494d-9d52-276bc1355c09.png', true, 799.99, 1, 6);
INSERT INTO product (id, name, image, is_favorite, price, category_id, detail_id)
VALUES (7, 'Mac book M4', 'http://localhost:9090/api/v1/file/view/6a9cfdde-4fbf-4076-bb7d-138ba2b1d9bf.png', false, 70.00, 1, 7);
INSERT INTO product (id, name, image, is_favorite, price, category_id, detail_id)
VALUES (8, 'Mouse', 'http://localhost:9090/api/v1/file/view/d77392a8-cc3d-4056-be73-62a8e66fe5ff.png', false, 250.00, 1, 8);
INSERT INTO product (id, name, image, is_favorite, price, category_id, detail_id)
VALUES (9, 'Rog Gaming', 'http://localhost:9090/api/v1/file/view/017f08db-ff25-4166-b819-f79174138129.png', true, 299.99, 1, 9);
INSERT INTO product (id, name, image, is_favorite, price, category_id, detail_id)
VALUES (10, 'Galaxy Ultra s25', 'http://localhost:9090/api/v1/file/view/654c9242-f9c4-4d63-a75f-9dd1a98db463.png', false, 1200.00, 1, 10);


-- Product Details
INSERT INTO product_detail (id, condition, brand, model, color, year, size, type, description)
VALUES (1, 'New', 'Apple', 'iPhone 14', 'Black', '2023', '6.1 inch', 'Smartphone', 'Latest Apple iPhone 14 model');
INSERT INTO product_detail (id, condition, brand, model, color, year, size, type, description)
VALUES (2, 'Used', 'Nike', 'Air Max', 'White', '2022', '42', 'Shoes', 'Comfortable running shoes');
INSERT INTO product_detail (id, condition, brand, model, color, year, size, type, description)
VALUES (3, 'New', 'Samsung', 'Galaxy S23', 'Blue', '2023', '6.5 inch', 'Smartphone', 'Flagship Samsung phone');
INSERT INTO product_detail (id, condition, brand, model, color, year, size, type, description)
VALUES (4, 'New', 'Adidas', 'Ultraboost', 'Black', '2023', '43', 'Shoes', 'High-performance running shoes');
INSERT INTO product_detail (id, condition, brand, model, color, year, size, type, description)
VALUES (5, 'New', 'Ikea', 'Malm', 'Brown', '2021', '200x160cm', 'Bed', 'Modern wooden bed frame');
INSERT INTO product_detail (id, condition, brand, model, color, year, size, type, description)
VALUES (6, 'Used', 'Sony', 'Bravia 55X', 'Black', '2020', '55 inch', 'TV', '4K Smart TV with HDR');
INSERT INTO product_detail (id, condition, brand, model, color, year, size, type, description)
VALUES (7, 'New', 'Levi’s', '501 Original', 'Blue', '2023', 'L', 'Jeans', 'Classic straight fit jeans');
INSERT INTO product_detail (id, condition, brand, model, color, year, size, type, description)
VALUES (8, 'New', 'Wilson', 'Pro Staff', 'Red/Black', '2023', '27 inch', 'Tennis Racket', 'Professional tennis racket');
INSERT INTO product_detail (id, condition, brand, model, color, year, size, type, description)
VALUES (9, 'New', 'Samsung', 'Galaxy Watch 5', 'Silver', '2023', '44mm', 'Smartwatch', 'Advanced health tracking smartwatch');
INSERT INTO product_detail (id, condition, brand, model, color, year, size, type, description)
VALUES (10, 'New', 'Canon', 'EOS R10', 'Black', '2023', 'Standard', 'Camera', 'Mirrorless camera for photography');
