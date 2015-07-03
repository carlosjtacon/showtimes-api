CREATE TABLE "SHOWTIME"(
	"tid" Varchar NOT NULL,
	"fid" Varchar NOT NULL,
	-- "sid" Varchar NOT NULL,
	"stime" Date NOT NULL,
	-- "sdate" Varchar NOT NULL,
	"slang" Varchar,
	"s3d" Boolean,
	"sdigital" Boolean
);
-- ALTER TABLE "SHOWTIME" ADD CONSTRAINT "key_showtime" PRIMARY KEY ("sid","tid","fid");
ALTER TABLE "SHOWTIME" ADD CONSTRAINT "key_showtime" PRIMARY KEY ("stime","tid","fid");
ALTER TABLE "SHOWTIME" ADD CONSTRAINT "unique_showtime" UNIQUE ("stime","tid","fid");
-- ALTER TABLE "SHOWTIME" ADD CONSTRAINT "unique_sid" UNIQUE ("sid");
-- ALTER TABLE "SHOWTIME" ADD CONSTRAINT "unique_sid" UNIQUE ("stime");

CREATE TABLE "THEATRE"(
	"tid" Varchar NOT NULL,
	"tname" Varchar NOT NULL,
	"taddress" Varchar,
	"ttelf" Varchar,
	"tcoords" Point,
	"tnominatim" json
);
ALTER TABLE "THEATRE" ADD CONSTRAINT "key_theatre" PRIMARY KEY ("tid");
ALTER TABLE "THEATRE" ADD CONSTRAINT "unique_tid" UNIQUE ("tid");

CREATE TABLE "FILM"(
	"fid" Varchar NOT NULL,
	"fname" Varchar NOT NULL,
	"fgenre" Varchar,
	"flength" Varchar,
	"ftmdb" json
);
ALTER TABLE "FILM" ADD CONSTRAINT "key_film" PRIMARY KEY ("fid");
ALTER TABLE "FILM" ADD CONSTRAINT "unique_fid" UNIQUE ("fid");

-- RELATIONSHIPS

ALTER TABLE "SHOWTIME" ADD CONSTRAINT "relation_theatre" FOREIGN KEY ("tid") REFERENCES "THEATRE" ("tid");
ALTER TABLE "SHOWTIME" ADD CONSTRAINT "relation_film" FOREIGN KEY ("fid") REFERENCES "FILM" ("fid");
