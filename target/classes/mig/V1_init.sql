CREATE TABLE currencyUSD
(
    id SERIAL,
    date VARCHAR(50) NOT NULL,
    value VARCHAR(50) NOT NULL
);
/*
 DOUBLE PRECISION выдает ошибку
 */
CREATE TABLE currencyRUB
(
    id SERIAL,
    date VARCHAR(50) NOT NULL,
    value VARCHAR(50) NOT NULL
);
CREATE TABLE currencyEUR
(
    id SERIAL,
    date VARCHAR(50) NOT NULL,
    value VARCHAR(50) NOT NULL
);


SELECT * FROM currencyUSD;
SELECT * FROM currencyRUB;
SELECT * FROM currencyEUR;

SELECT date,value from currencyrub;

drop table currencyUSD;
drop table currencyEUR;
drop table currencyRUB;

DELETE FROM currencyRUB WHERE ctid NOT IN (SELECT max(ctid) FROM currencyRUB GROUP BY date);
