CREATE TABLE if not exists application
(
    id                               UUID NOT NULL,
    account_number                     TEXT,
    business_decision                  TEXT,
    contract_date                      TIMESTAMP,
    created_time                       TIMESTAMP,
    merchandise_type                   TEXT,
    product_selected_timestamp         TIMESTAMP,
    selected_offer_uuid                UUID,
    ssn_collected_timestamp            TIMESTAMP,
    status                             INT4,
    updated_time                       TIMESTAMP,
    created_by                         TEXT,
    updated_by                         TEXT,
    CONSTRAINT APPLICATION_PK PRIMARY KEY (id)
);

CREATE TABLE ADDRESS
(
    ID            uuid,
    PHONE_NUMBER  TEXT,
    ADDRESS_LINE1 TEXT,
    ADDRESS_LINE2 TEXT,
    ZIP_CODE      TEXT,
    CITY          TEXT,
    STATE         TEXT,
    created_time DATE,
    updated_time DATE,
    created_by TEXT,
    updated_by TEXT,
    CONSTRAINT ADDRESS_PK PRIMARY KEY (ID)
);

CREATE TABLE if not exists applicant
(
    id                         UUID NOT NULL,
    application_uuid             UUID,
    email                        TEXT,
    annual_income                NUMERIC(18, 2),
    created_time                 TIMESTAMP,
    address_id                   UUID,
    mobile_phone_number          TEXT,
    verification_code            TEXT,
    last4_ssn                    TEXT,
    customer_uuid                UUID,
    mobile_phone_number_verified BOOLEAN,
    email_verified               BOOLEAN,
    new_email_address            TEXT,
    education                    BOOLEAN,
    verification_code_expire_at  TIMESTAMP,
    updated_time                 TIMESTAMP,
    created_by                         TEXT,
    updated_by                         TEXT,
    CONSTRAINT APPLICANT_PK PRIMARY KEY (id),
    CONSTRAINT APPLICATION_UUID_FK FOREIGN KEY (application_uuid) REFERENCES application (id),
    CONSTRAINT ADDRESS_ID_FK FOREIGN KEY (address_id) REFERENCES ADDRESS (ID)
);

