-- One admin user, named admin1 with passwor 4dm1n and authority admin
INSERT INTO users(username,password,enabled) VALUES ('admin1','$2a$10$mJB2TfG4f2ycsETLjh3KHuqEEJuKa26TOgcHFa6Xe09leeAyZ5w2a',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (1,'admin1','admin');
-- One owner user, named owner1 with passwor 0wn3r
INSERT INTO users(username,password,enabled) VALUES ('owner1','$2a$10$OIpAfw68I1RKViLPNB.Vy.FvKGxeGgJsl9aFsQJJvfkyPeb2Bzhmm',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (2,'owner1','owner');

INSERT INTO users(username,password,enabled) VALUES ('owner2','$2a$10$OIpAfw68I1RKViLPNB.Vy.FvKGxeGgJsl9aFsQJJvfkyPeb2Bzhmm',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (3,'owner2','owner');

INSERT INTO users(username,password,enabled) VALUES ('owner3','$2a$10$OIpAfw68I1RKViLPNB.Vy.FvKGxeGgJsl9aFsQJJvfkyPeb2Bzhmm',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (4,'owner3','owner');

INSERT INTO users(username,password,enabled) VALUES ('owner4','$2a$10$OIpAfw68I1RKViLPNB.Vy.FvKGxeGgJsl9aFsQJJvfkyPeb2Bzhmm',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (5,'owner4','owner');

INSERT INTO users(username,password,enabled) VALUES ('owner5','$2a$10$OIpAfw68I1RKViLPNB.Vy.FvKGxeGgJsl9aFsQJJvfkyPeb2Bzhmm',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (6,'owner5','owner');

INSERT INTO users(username,password,enabled) VALUES ('owner6','$2a$10$OIpAfw68I1RKViLPNB.Vy.FvKGxeGgJsl9aFsQJJvfkyPeb2Bzhmm',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (7,'owner6','owner');

INSERT INTO users(username,password,enabled) VALUES ('owner7','$2a$10$OIpAfw68I1RKViLPNB.Vy.FvKGxeGgJsl9aFsQJJvfkyPeb2Bzhmm',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (8,'owner7','owner');

INSERT INTO users(username,password,enabled) VALUES ('owner8','$2a$10$OIpAfw68I1RKViLPNB.Vy.FvKGxeGgJsl9aFsQJJvfkyPeb2Bzhmm',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (9,'owner8','owner');

INSERT INTO users(username,password,enabled) VALUES ('owner9','$2a$10$OIpAfw68I1RKViLPNB.Vy.FvKGxeGgJsl9aFsQJJvfkyPeb2Bzhmm',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (10,'owner9','owner');

INSERT INTO users(username,password,enabled) VALUES ('owner10','$2a$10$OIpAfw68I1RKViLPNB.Vy.FvKGxeGgJsl9aFsQJJvfkyPeb2Bzhmm',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (11,'owner10','owner');
-- One vet user, named vet1 with passwor v3t
INSERT INTO users(username,password,enabled) VALUES ('vet1','$2a$10$JUekX3ZVtrQifm2KXK0vjO6o/JlezYL71nKlV.e1iQNs2suxxX74m',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (12,'vet1','veterinarian');

INSERT INTO vets VALUES (1, 'James', 'Carter');
INSERT INTO vets VALUES (2, 'Helen', 'Leary');
INSERT INTO vets VALUES (3, 'Linda', 'Douglas');
INSERT INTO vets VALUES (4, 'Rafael', 'Ortega');
INSERT INTO vets VALUES (5, 'Henry', 'Stevens');
INSERT INTO vets VALUES (6, 'Sharon', 'Jenkins');

INSERT INTO specialties VALUES (1, 'radiology');
INSERT INTO specialties VALUES (2, 'surgery');
INSERT INTO specialties VALUES (3, 'dentistry');

INSERT INTO vet_specialties VALUES (2, 1);
INSERT INTO vet_specialties VALUES (3, 2);
INSERT INTO vet_specialties VALUES (3, 3);
INSERT INTO vet_specialties VALUES (4, 2);
INSERT INTO vet_specialties VALUES (5, 1);

INSERT INTO types VALUES (1, 'cat');
INSERT INTO types VALUES (2, 'dog');
INSERT INTO types VALUES (3, 'lizard');
INSERT INTO types VALUES (4, 'snake');
INSERT INTO types VALUES (5, 'bird');
INSERT INTO types VALUES (6, 'hamster');

INSERT INTO owners VALUES (1, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023', 'owner1');
INSERT INTO owners VALUES (2, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749', 'owner2');
INSERT INTO owners VALUES (3, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763', 'owner3');
INSERT INTO owners VALUES (4, 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198', 'owner4');
INSERT INTO owners VALUES (5, 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765', 'owner5');
INSERT INTO owners VALUES (6, 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654', 'owner6');
INSERT INTO owners VALUES (7, 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387', 'owner7');
INSERT INTO owners VALUES (8, 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683', 'owner8');
INSERT INTO owners VALUES (9, 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435', 'owner9');
INSERT INTO owners VALUES (10, 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487', 'owner10');

INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (1, 'Leo', '2010-09-07', 1, 1);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (2, 'Basil', '2012-08-06', 6, 2);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (3, 'Rosy', '2011-04-17', 2, 3);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (4, 'Jewel', '2010-03-07', 2, 3);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (5, 'Iggy', '2010-11-30', 3, 4);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (6, 'George', '2010-01-20', 4, 5);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (7, 'Samantha', '2012-09-04', 1, 6);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (8, 'Max', '2012-09-04', 1, 6);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (10, 'Mulligan', '2007-02-24', 2, 8);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (11, 'Freddy', '2010-03-09', 5, 9);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (12, 'Sly', '2012-06-08', 1, 10);

INSERT INTO visits(id,pet_id,visit_date,description) VALUES (1, 7, '2013-01-01', 'rabies shot');
INSERT INTO visits(id,pet_id,visit_date,description) VALUES (2, 8, '2013-01-02', 'rabies shot');
INSERT INTO visits(id,pet_id,visit_date,description) VALUES (3, 8, '2013-01-03', 'neutered');
INSERT INTO visits(id,pet_id,visit_date,description) VALUES (4, 7, '2013-01-04', 'spayed');


INSERT INTO causes(id, name, budget_target, act_non_prof_org, is_open) VALUES (1, 'Causa1', 500.0, 'SaveChildren', true);
INSERT INTO causes(id, name, description, budget_target, act_non_prof_org, is_open) VALUES (2, 'Causa2','Descripcion', 700.0, 'MedicosSinFronteras', true);

INSERT INTO donations(id, date, amount, username, cause_id) VALUES (1, '2021-03-15', 100.0, 'owner1', 1);
INSERT INTO donations(id, date, amount, username, cause_id) VALUES (2, '2021-03-23', 150.0, 'owner1', 1);
INSERT INTO adoption_request VALUES (1,'This pet is really quiet.');

INSERT INTO pets(id,name,birth_date, adoption_request_id,type_id,owner_id) VALUES (9, 'Lucky', '2011-08-06',1, 5, 7);
