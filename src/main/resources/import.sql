INSERT INTO CUSTOMER (ID, EMAIL, NAME, SURNAME) VALUES (1, 'email@test.com', 'Test', 'User');

INSERT INTO TICKET (ID, SUBJECT, CONTENT, SUB_CATEGORY, STATUS, CREATED, UPDATED, CUSTOMER_ID) VALUES (1, 'Info ticket welfare', 'Dove posso accedere per vedere il valori dei ticket per lo shopping?', 'Budget Welfare', 'NEW', SYSDATE, SYSDATE, 1);
INSERT INTO TICKET (ID, SUBJECT, CONTENT, SUB_CATEGORY, STATUS, CREATED, UPDATED, CUSTOMER_ID) VALUES (2, 'Scadenza buoni', 'Quanto valgono i buoni pasto?', 'Buoni Pasto', 'NEW', SYSDATE-1, SYSDATE, 1);
INSERT INTO TICKET (ID, SUBJECT, CONTENT, SUB_CATEGORY, STATUS, CREATED, UPDATED, CUSTOMER_ID) VALUES (3, 'Problema ventola', 'La ventola del PC fa un rumore eccessivo.', 'Pc Aziendale', 'IN PROGRESS', SYSDATE-2, SYSDATE, 1);
INSERT INTO TICKET (ID, SUBJECT, CONTENT, SUB_CATEGORY, STATUS, CREATED, UPDATED, CUSTOMER_ID) VALUES (4, 'Errore Pin', 'Ho dimenticato il pin.', 'Smartphone Aziendale', 'CLOSED', SYSDATE-3, SYSDATE-3, 1);
INSERT INTO TICKET (ID, SUBJECT, CONTENT, SUB_CATEGORY, STATUS, CREATED, UPDATED, CUSTOMER_ID) VALUES (5, 'Apertura fondo', 'Quando viene aperto il fondo?', 'Fondo Metasalute', 'CLOSED', SYSDATE-4, SYSDATE-4, 1);


