--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: cars; Type: TABLE; Schema: public; Owner: jz36
--

CREATE TABLE cars (
    id integer,
    id_human integer,
    mark character varying(20),
    model character varying(20),
    gov_number character varying(6),
    gov_number2 character varying(3)
);


ALTER TABLE cars OWNER TO jz36;

--
-- Name: city; Type: TABLE; Schema: public; Owner: jz36
--

CREATE TABLE city (
    id integer,
    cityname character varying(255)
);


ALTER TABLE city OWNER TO jz36;

--
-- Name: human; Type: TABLE; Schema: public; Owner: jz36
--

CREATE TABLE human (
    id integer,
    name character varying(50),
    second_name character varying(50),
    third_name character varying(50),
    city integer
);


ALTER TABLE human OWNER TO jz36;

--
-- Data for Name: cars; Type: TABLE DATA; Schema: public; Owner: jz36
--

COPY cars (id, id_human, mark, model, gov_number, gov_number2) FROM stdin;
0	0	Toyota	Mark II	е786ху	96
1	0	Chevrolet	Camaro	у251ра	196
2	1	ВАЗ	2109	e112ра	102
3	2	Chevrolet	Aveo	р253рр	177
4	2	ВАЗ	2114	а001аа	197
5	2	Daweoo	Matiz	с872ао	14
6	3	Nissan	Patrol	о920са	45
7	4	ГАЗ	3110	р121мо	196
8	4	Mitsubishi	Pajero	р912ом	174
9	5	Volkswagen	Polo	е312кх	74
10	6	LADA	Vesta	о812ра	99
11	6	BMW	X5	е293тв	77
12	6	Mercedes	Benz	т923ев	05
13	7	Skoda	Octavia	х142хх	12
14	8	Ferrari	California T	р294хк	121
15	8	Chery	Tigo	а923ео	21
16	9	Infinity	QX50	м124рк	16
17	9	Renault	Sandero	т723ек	155
18	9	Subaru	WRX	к748ек	999
19	9	Opel	Astra	р201мо	999
\.


--
-- Data for Name: city; Type: TABLE DATA; Schema: public; Owner: jz36
--

COPY city (id, cityname) FROM stdin;
0	Екатеринбург
1	Москва
2	Санкт-Петербург
3	Самара
4	Тюмень
5	Челябинск
6	Пермь
7	Тольятти
8	Анапа
9	Архангельск
\.


--
-- Data for Name: human; Type: TABLE DATA; Schema: public; Owner: jz36
--

COPY human (id, name, second_name, third_name, city) FROM stdin;
0	Иван	Зыков	Олегович	0
1	Игорь	Газманов	Валерьевич	1
4	Аркадий	Привалов	Владиславович	2
2	Светлана	Мельникова	Евгеньевна	3
3	Валерия	Бандуркина	Михеевна	4
5	Злата	Ажикелямова	Несторовна	5
8	Владилен	Ягунов	Андроникович	6
6	Давид	Чернецкий	Всеволодович	7
7	Мирослава	Борщёва	Олеговна	8
9	Гавриил	Кризько	Онуфриевич	9
\.


--
-- Name: cars cars_id_key; Type: CONSTRAINT; Schema: public; Owner: jz36
--

ALTER TABLE ONLY cars
    ADD CONSTRAINT cars_id_key UNIQUE (id);


--
-- Name: city city_id_key; Type: CONSTRAINT; Schema: public; Owner: jz36
--

ALTER TABLE ONLY city
    ADD CONSTRAINT city_id_key UNIQUE (id);


--
-- Name: human human_id_key; Type: CONSTRAINT; Schema: public; Owner: jz36
--

ALTER TABLE ONLY human
    ADD CONSTRAINT human_id_key UNIQUE (id);


--
-- PostgreSQL database dump complete
--

