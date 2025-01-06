CREATE TABLE person (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             lastname VARCHAR(255) NOT NULL,
                             firstname VARCHAR(255) NOT NULL,
                             birth_date DATE NOT NULL
);

CREATE TABLE enterprise (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL
);

CREATE TABLE person_job (

                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        enterprise_id BIGINT NOT NULL,
                        person_id BIGINT NOT NULL,
                        is_current BIT NOT NULL ,
                        start_date DATE NOT NULL ,
                        end_date DATE,
                        CONSTRAINT fk_enterprise FOREIGN KEY (enterprise_id) REFERENCES enterprise(id),
                        CONSTRAINT fk_person FOREIGN KEY (person_id) REFERENCES person(id)
)