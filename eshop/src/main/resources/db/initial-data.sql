INSERT INTO PRODUCTS (id, name, quantity, price, description) VALUES
    ('acf49189-e872-48b0-949e-63d455f4fd86', 'iPhone XM', 200, 1599.99, 'Naujausias iPhone!'),
    ('7a580a64-a414-40dc-8861-52aa79ff2259', 'Samsung S31', 50, 999.99, 'Pats geriausias Samsung!'),
    ('7a580a64-a414-40dc-8861-52aa79ff2251', 'Samsung S31', 50, 999.99, 'Pats geriausias Samsung!'),
    ('7a580a64-a414-40dc-8861-52aa79ff2252', 'Samsung S31', 50, 999.99, 'Pats geriausias Samsung!'),
    ('7a580a64-a414-40dc-8861-52aa79ff2253', 'Samsung S31', 50, 999.99, 'Pats geriausias Samsung!'),
    ('7a580a64-a414-40dc-8861-52aa79ff2254', 'Samsung S31', 50, 999.99, 'Pats geriausias Samsung!'),
    ('7a580a64-a414-40dc-8861-52aa79ff2255', 'Samsung S31', 50, 999.99, 'Pats geriausias Samsung!'),
    ('7a580a64-a414-40dc-8861-52aa79ff2256', 'Samsung S31', 50, 999.99, 'Pats geriausias Samsung!'),
    ('7a580a64-a414-40dc-8861-52aa79ff2257', 'Samsung S31', 50, 999.99, 'Pats geriausias Samsung!'),
    ('7a580a64-a414-40dc-8861-52aa79ff2217', 'a', 50, 999.99, 'Pats geriausias Samsung!'),
    ('7a580a64-a414-40dc-8861-52aa79ff2227', 'b', 50, 999.99, 'Pats geriausias Samsung!'),
    ('7a580a64-a414-40dc-8861-52aa79ff1227', 'c', 50, 999.99, 'Pats geriausias Samsung!'),
    ('7a580a64-a414-40dc-8861-52aa79ff3227', 'C', 50, 999.99, 'Pats geriausias Samsung!'),
    ('7a580a64-a414-40dc-8861-52aa79ff4227', 'd', 50, 999.99, 'Pats geriausias Samsung!'),
    ('7a580a64-a414-40dc-8861-52aa79ff2258', 'Samsung S31', 50, 999.99, 'Pats geriausias Samsung!');


INSERT INTO USERS (id, username, password, name, surname) VALUES
    ('acf49189-e872-48b0-949e-63d455f4fd86', 'user',
     '{bcrypt}$2y$12$Asaa8kGQMLq5IQ2LNb2VEeF6zKX4larg/rvALtrzLlJhczyl6teWC', 'Vardenis', 'Pavardenis'), /*pass*/
    ('7a580a64-a414-40dc-8861-52aa79ff2258', 'admin',
     '{bcrypt}$2y$12$RZ77B8lWhj..N1EA5Z2Q5.LnQ5YcwjhNaA13EljO6BvGMVeQeD4yO', 'Adminas', 'Adminauskas'); /*admin*/

INSERT INTO ROLES (id, name) VALUES
    ('acf49189-e872-48b0-949e-63d455f4fd86', 'USER'),
    ('7a580a64-a414-40dc-8861-52aa79ff2258', 'ADMIN');

INSERT INTO USERS_ROLES (user_id, roles_id) VALUES
    ('acf49189-e872-48b0-949e-63d455f4fd86', 'acf49189-e872-48b0-949e-63d455f4fd86'), /* user -> USER ROLE */
    ('7a580a64-a414-40dc-8861-52aa79ff2258', 'acf49189-e872-48b0-949e-63d455f4fd86'),
    ('7a580a64-a414-40dc-8861-52aa79ff2258', '7a580a64-a414-40dc-8861-52aa79ff2258'); /* admin -> USER, ADMIN ROLES */
