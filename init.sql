USE recette;

CREATE TABLE IF NOT EXISTS ingredient (
    id_ingredient INT PRIMARY KEY AUTO_INCREMENT,
    nom_ingredient VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS recette (
    id_recette INT PRIMARY KEY AUTO_INCREMENT,
    nom_recette VARCHAR(100) NOT NULL,
    description TEXT
);

CREATE TABLE IF NOT EXISTS recette_ingredient (
    id_recette INT,
    id_ingredient INT,
    quantite VARCHAR(50),
    PRIMARY KEY (id_recette, id_ingredient),
    FOREIGN KEY (id_recette) REFERENCES recette(id_recette),
    FOREIGN KEY (id_ingredient) REFERENCES ingredient(id_ingredient)
);

INSERT INTO ingredient (nom_ingredient) VALUES 
('Tomate'),
('Fromage'),
('Pates'),
('Poulet'),
('Oignon'),
('Ail'),
('Huile d\'olive'),
('Farine'),
('Oeuf'),
('Lait')
ON DUPLICATE KEY UPDATE nom_ingredient = VALUES(nom_ingredient);

INSERT INTO recette (nom_recette, description) VALUES 
('Pates a la tomate', 'Delicieuses pates avec une sauce tomate maison'),
('Pizza Margherita', 'Pizza traditionnelle italienne'),
('Poulet roti', 'Poulet roti aux herbes'),
('Omelette', 'Omelette classique au fromage'),
('Crepes', 'Crepes sucrees traditionnelles')
ON DUPLICATE KEY UPDATE description = VALUES(description);

INSERT INTO recette_ingredient (id_recette, id_ingredient, quantite) VALUES 
(1, 1, '500g'), (1, 3, '250g'), (1, 5, '1'), (1, 6, '2 gousses'), (1, 7, '2 cuilleres'),
(2, 1, '300g'), (2, 2, '200g'), (2, 8, '400g'), (2, 7, '1 cuillere'),
(3, 4, '1 poulet'), (3, 5, '2'), (3, 6, '3 gousses'), (3, 7, '3 cuilleres'),
(4, 9, '3'), (4, 2, '50g'), (4, 10, '2 cuilleres'),
(5, 8, '250g'), (5, 9, '3'), (5, 10, '500ml')
ON DUPLICATE KEY UPDATE quantite = VALUES(quantite);
