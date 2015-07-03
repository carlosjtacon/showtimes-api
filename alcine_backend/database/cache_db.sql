CREATE TABLE "CACHE"(
	"url" Varchar NOT NULL,
	"r_location" Varchar NOT NULL,
	"r_lang" Varchar NOT NULL,
	"r_date" Date NOT NULL,
	"tid" Varchar,
	"fid" Varchar,
	"cache_date" Date NOT NULL,
	"response" Json NOT NULL
);
ALTER TABLE "CACHE" ADD CONSTRAINT "key_cache" PRIMARY KEY ("url", "r_location", "r_lang", "r_date");
ALTER TABLE "CACHE" ADD CONSTRAINT "unique_cache" UNIQUE ("url", "r_location", "r_lang", "r_date");

CREATE TABLE "FILM_CACHE"(
	"fid" Varchar NOT NULL,
	"r_lang" Varchar NOT NULL,
	"cache_date" Date NOT NULL,
	"response" Json NOT NULL
);
ALTER TABLE "FILM_CACHE" ADD CONSTRAINT "key_film_cache" PRIMARY KEY ("fid", "r_lang");
ALTER TABLE "FILM_CACHE" ADD CONSTRAINT "unique_film_cache" UNIQUE ("fid", "r_lang");

CREATE TABLE "THEATRE_CACHE"(
	"tid" Varchar NOT NULL,
	"r_lang" Varchar NOT NULL,
	"cache_date" Date NOT NULL,
	"response" Json NOT NULL
);
ALTER TABLE "THEATRE_CACHE" ADD CONSTRAINT "key_theatre_cache" PRIMARY KEY ("tid", "r_lang");
ALTER TABLE "THEATRE_CACHE" ADD CONSTRAINT "unique_theatre_cache" UNIQUE ("tid", "r_lang");