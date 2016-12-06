DROP TABLE Onkosten PURGE;
DROP TABLE Kredieten PURGE;
DROP TABLE Users PURGE;



CREATE TABLE Users(
    functie varchar2(50),
    usernr int,
    baasnr int,
    paswoord varchar2(50),
    PRIMARY KEY (usernr),
    FOREIGN KEY (baasnr) REFERENCES Users(usernr),
    CONSTRAINT chk_functie CHECK (functie IN ('werknemer', 'manager', 'boekhouder', 'managerboekhouder', 'ceo'))
);
CREATE TABLE Kredieten(
    kredietnr int,
    saldo int,
    usernr int,
    soort varchar2(50),
    PRIMARY KEY (kredietnr),
    FOREIGN KEY (usernr) REFERENCES Users(usernr),
    CONSTRAINT chk_soort CHECK (soort IN ('gewaarborgd', 'ongewaarborgd'))
);
CREATE TABLE Onkosten(
    onkostnr int,
    omschrijving varchar2(50),
    datum date,
    bedrag int,
    status varchar2(50),
    usernr int,
    kredietnr int,
    PRIMARY KEY (onkostnr),
    FOREIGN KEY (usernr) REFERENCES Users(usernr),
    FOREIGN KEY (kredietnr) REFERENCES Kredieten(kredietnr),
    CONSTRAINT chk_status CHECK (status IN ('in maak', 'doorgestuurd', 'betaald', 'afgekeurd'))
);
    
INSERT INTO Users (functie, usernr, baasnr, paswoord)
    VALUES ('ceo', '000', '000', 'ceo');
INSERT INTO Users (functie, usernr, baasnr, paswoord)
    VALUES ('boekhouder', '006', '000', '000');
INSERT INTO Users (functie, usernr, baasnr, paswoord)
    VALUES ('managerboekhouder', '005', '000', '000');
INSERT INTO Users (functie, usernr, baasnr, paswoord)
    VALUES ('manager', '003', '005', '000');
INSERT INTO Users (functie, usernr, baasnr, paswoord)
    VALUES ('werknemer', '001', '003', '000');
INSERT INTO Users (functie, usernr, baasnr, paswoord)
    VALUES ('werknemer', '002', '003', '000');
INSERT INTO Users (functie, usernr, baasnr, paswoord)
    VALUES ('boekhouder', '004', '003', '000');

INSERT INTO Kredieten  (kredietnr, saldo, usernr, soort)
    VALUES ('001', '5000', '003', 'ongewaarborgd'); 
INSERT INTO Kredieten  (kredietnr, saldo, usernr, soort)
    VALUES ('002', '-7500', '005', 'gewaarborgd'); 
INSERT INTO Onkosten (onkostnr, omschrijving, datum, bedrag, status, usernr, kredietnr)
	Values('1', 'Groot gesneden brood', '2016-10-05', 2, 'in maak', 0, 1);
    





