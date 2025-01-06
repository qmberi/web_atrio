
INSERT INTO enterprise (name) VALUES
                                  ('Tech Innovators'),
                                  ('Green Solutions Inc.'),
                                  ('Global Financial Group'),
                                  ('HealthCare Plus');
INSERT INTO person (lastname, firstname, birth_date) VALUES
                                                         ('Doe', 'Alice', '1990-03-14'),
                                                         ('Smith', 'Bob', '1985-07-23'),
                                                         ('Johnson', 'Carla', '1992-01-11'),
                                                         ('Williams', 'David', '1980-09-30');


INSERT INTO person_job (name, enterprise_id, person_id, is_current, start_date, end_date) VALUES
                                                                                              ('Software Engineer', 1, 1, 1, '2017-06-01', NULL),
                                                                                              ('Financial Analyst', 3, 2, 0, '2010-04-15', '2018-10-31'),
                                                                                              ('Nurse Practitioner', 4, 3, 1, '2018-01-01', NULL),
                                                                                              ('Project Manager', 2, 4, 1, '2020-05-01', NULL);
