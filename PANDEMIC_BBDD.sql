CREATE SEQUENCE autoPlayer_ID
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1;

CREATE SEQUENCE autoPartida_ID
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1;

CREATE OR REPLACE TRIGGER PLAYERS_INSERT
  AFTER
  INSERT
  ON PLAYERS
BEGIN
  UPDATE PLAYERS SET ID_P = autoPlayer_ID.NEXTVAL
  WHERE ID_P = 0;
  
  UPDATE PARTIDA SET ID_P = autoPlayer_ID.NEXTVAL
  WHERE ID_P = 0;
END;


CREATE TABLE PARTIDA (
ID_PARTIDA NUMBER(5) PRIMARY KEY,
ID_P NUMBER(5),
DIFICULTAD NUMBER(5),
RONDAS NUMBER(5),
ACCIONES NUMBER(5),
BROTES NUMBER(5),
ARRAY_CIUDADES ARRAY_CIUDADES,
ARRAY_VACUNAS ARRAY_VACUNAS,
WL VARCHAR2(5),
FOREIGN KEY (ID_P) REFERENCES PLAYERS (ID_P));




CREATE OR REPLACE TYPE ARRAY_CIUDADES AS VARRAY (48) OF CIUDADES;
CREATE OR REPLACE TYPE ARRAY_VACUNAS AS VARRAY (4) OF VACUNAS;

DROP SEQUENCE autoPlayer_ID;
DROP SEQUENCE autoPartida_ID;

DROP TABLE PARTIDA;
DELETE FROM PLAYERS;


