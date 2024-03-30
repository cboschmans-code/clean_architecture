INSERT INTO payment.credit_entry(id, customer_id, total_credit_amount)
VALUES ('af51cffb-d3e9-42f0-99f3-1d604be68752','f6c2f724-41aa-4c64-9c2f-011e638de3d8',500.00);
INSERT INTO payment.credit_history(id, customer_id, amount,type)
VALUES ('b8cb6bbf-5370-4803-8604-33dc2f9435e4','f6c2f724-41aa-4c64-9c2f-011e638de3d8',100.00,'CREDIT');
INSERT INTO payment.credit_history(id, customer_id, amount,type)
VALUES ('d2c9a720-9747-4d24-8396-b3c1f6db19a2','f6c2f724-41aa-4c64-9c2f-011e638de3d8',600.00,'CREDIT');
INSERT INTO payment.credit_history(id, customer_id, amount,type)
VALUES ('4ea18e04-fb51-48b1-b965-916960285b28','f6c2f724-41aa-4c64-9c2f-011e638de3d8',200.00,'DEBIT');

INSERT INTO payment.credit_entry(id, customer_id, total_credit_amount)
VALUES ('303ecea1-78e6-4a22-acf8-5fa34154b408','5d887e08-a5bb-4d7c-9a93-96acbe0b3f4d',100.00);
INSERT INTO payment.credit_history(id, customer_id, amount,type)
VALUES ('7714dc2f-834f-40b8-b12e-0d1788acc9d3','5d887e08-a5bb-4d7c-9a93-96acbe0b3f4d',100.00,'CREDIT');