-- ──────────────────────────────────────────
-- Départements
-- ──────────────────────────────────────────
INSERT INTO departement (nom) VALUES
                                  ('Informatique'),
                                  ('Mathématiques'),
                                  ('Physique'),
                                  ('Génie Civil');

-- ──────────────────────────────────────────
-- Étudiants (avec email, annee_premiere_inscription, departement_id)
-- ──────────────────────────────────────────
INSERT INTO etudiant (cin, nom, date_naissance, email, annee_premiere_inscription, departement_id) VALUES
                                                                                                       ('12345678', 'Ahmed Ben Ali',    '2001-03-15', 'ahmed.benali@isett.tn',    '2020-09-15', 1),
                                                                                                       ('23456789', 'Fatma Trabelsi',   '2000-07-22', 'fatma.trabelsi@isett.tn',  '2019-09-15', 1),
                                                                                                       ('34567890', 'Mohamed Chaabane', '2001-11-08', 'med.chaabane@isett.tn',    '2020-09-15', 2),
                                                                                                       ('45678901', 'Sarra Mansouri',   '2002-01-30', 'sarra.mansouri@isett.tn',  '2021-09-15', 2),
                                                                                                       ('56789012', 'Youssef Ezzine',   '2000-09-14', 'youssef.ezzine@isett.tn',  '2019-09-15', 3),
                                                                                                       ('67890123', 'Rim Belhaj',       '2001-05-03', 'rim.belhaj@isett.tn',      '2020-09-15', 3),
                                                                                                       ('78901234', 'Karim Hamdi',      '2002-12-19', 'karim.hamdi@isett.tn',     '2021-09-15', 4),
                                                                                                       ('89012345', 'Nour Khelifi',     '2000-04-27', 'nour.khelifi@isett.tn',    '2019-09-15', 4),
                                                                                                       ('90123456', 'Bilel Saidi',      '2001-08-11', 'bilel.saidi@isett.tn',     '2020-09-15', 1),
                                                                                                       ('01234567', 'Ines Gharbi',      '2002-06-05', 'ines.gharbi@isett.tn',     '2021-09-15', 2);